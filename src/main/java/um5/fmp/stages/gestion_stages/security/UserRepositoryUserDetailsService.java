package um5.fmp.stages.gestion_stages.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import um5.fmp.stages.gestion_stages.models.User;
import um5.fmp.stages.gestion_stages.repository.EncadrantRepository;
import um5.fmp.stages.gestion_stages.repository.UserRepository;

@Service
public class UserRepositoryUserDetailsService 
        implements UserDetailsService {

  private UserRepository userRepo;

  @Autowired
  public UserRepositoryUserDetailsService(UserRepository userRepo) {
    this.userRepo = userRepo;
  }
  
  @Override
  public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
    User user = userRepo.findByEmail(email);
    if (user != null) {
      return user;
    }
    throw new UsernameNotFoundException(
                    "User with '" + email + "' not found");
  }

}