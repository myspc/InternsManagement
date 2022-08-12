package um5.fmp.stages.gestion_stages.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation
             .authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web
             .builders.HttpSecurity;
import org.springframework.security.config.annotation.web
                        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
                        .configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.core.convert.converter.Converter;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	 @Autowired
	 private CORSCustomizer corsCustomizer;
	
	

  @Autowired
  private UserDetailsService userDetailsService;

  
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  corsCustomizer.corsCustomizer(http);
    http
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/encadrant/**").hasRole("ENCADRANT")
        .antMatchers("/etudiant/**").hasRole("ETUDIANT")// needed for Angular/CORS
        .antMatchers("/**").access("permitAll")
        .and()
          .oauth2ResourceServer(oauth2 -> oauth2.jwt().jwtAuthenticationConverter(jwtAuthenticationConverter()))
        .httpBasic()

      .and()
        .logout()
          .logoutSuccessUrl("/")

      .and()
        .csrf()
          .ignoringAntMatchers("/h2-console/**", "/api/**")

      // Allow pages to be loaded in frames from the same origin; needed for H2-Console
      .and()
        .headers()
          .frameOptions()
            .sameOrigin()
      ;
  }
  
  
 
  
  
  
  JwtAuthenticationConverter jwtAuthenticationConverter() {
      final JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
      jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new MyRoleConverter());
      
      return jwtAuthenticationConverter;
  }    

  public class MyRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
      @Override
      public Collection<GrantedAuthority> convert(final Jwt jwt) {
          Map<String, String> userRoles = Map.of("admin", "ADMIN", "encadrant", "ENCADRANT","etudiant","ETUDIANT");
          
          List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
          
          String jsonString = jwt.getClaimAsString("user-authorities");
		  ObjectMapper mapper = new ObjectMapper();
		  List<String> list;
		try {
			list = mapper.readValue(jsonString, new TypeReference<ArrayList<String>>() {});
			
			 System.out.println("Subject: "+list.get(0));
	          SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(list.get(0));
	          simpleGrantedAuthorities.add(simpleGrantedAuthority);   
			
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          
         
          
          return new ArrayList<>(simpleGrantedAuthorities);
      }
  }
  
  
  
  
  
  
  @Bean
	public GrantedAuthoritiesMapper userAuthoritiesMapper() {
		return (authorities) -> {
			Set<GrantedAuthority> mappedAuthorities = new HashSet<>();

			authorities.forEach(authority -> {
				if (OidcUserAuthority.class.isInstance(authority)) {
					OidcUserAuthority oidcUserAuthority = (OidcUserAuthority)authority;

					OidcIdToken idToken = oidcUserAuthority.getIdToken();
					OidcUserInfo userInfo = oidcUserAuthority.getUserInfo();
					System.out.println(userInfo);
					// Map the claims found in idToken and/or userInfo
					// to one or more GrantedAuthority's and add it to mappedAuthorities
					if (userInfo.hasClaim("role")){
                      String roleName = "ROLE_" + userInfo.getClaimAsString("role");
                      mappedAuthorities.add(new SimpleGrantedAuthority(roleName));
                  }
					
				} else if (OAuth2UserAuthority.class.isInstance(authority)) {
					OAuth2UserAuthority oauth2UserAuthority = (OAuth2UserAuthority)authority;

					Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();
					System.out.println(userAttributes);
					// Map the attributes found in userAttributes
					// to one or more GrantedAuthority's and add it to mappedAuthorities
					if (userAttributes.containsKey("user-authorities")){
						   ObjectMapper objectMapper = new ObjectMapper();
						   ArrayList<um5.fmp.stages.gestion_stages.models.Role> authorityList = 
						   objectMapper.convertValue(userAttributes.get("user-authorities"), new 
						   TypeReference<ArrayList<um5.fmp.stages.gestion_stages.models.Role>>() {});
						   System.out.println("authList: "+ authorityList);
						   for(um5.fmp.stages.gestion_stages.models.Role role: authorityList){
						      String roleName = "ROLE_" + role.getNom();
						      System.out.println("role: "+ roleName);
						      mappedAuthorities.add(new SimpleGrantedAuthority(roleName));
						   }
						}

				}
			});

			return mappedAuthorities;
		};
	}
  
  
  
  
  

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }
  
  
  
  
  
  
  

  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {

    auth
      .userDetailsService(userDetailsService)
      .passwordEncoder(encoder());

  }

}