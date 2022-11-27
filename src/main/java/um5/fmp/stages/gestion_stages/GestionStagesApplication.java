package um5.fmp.stages.gestion_stages;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import um5.fmp.stages.gestion_stages.models.EmailDetails;
import um5.fmp.stages.gestion_stages.models.EmplacementStage;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Niveau;
import um5.fmp.stages.gestion_stages.models.Role;
import um5.fmp.stages.gestion_stages.models.Stage;
import um5.fmp.stages.gestion_stages.repository.EmplacementStageRepository;
import um5.fmp.stages.gestion_stages.repository.EncadrantRepository;
import um5.fmp.stages.gestion_stages.repository.EtudiantRepository;
import um5.fmp.stages.gestion_stages.repository.NiveauRepository;
import um5.fmp.stages.gestion_stages.repository.RoleRepository;
import um5.fmp.stages.gestion_stages.repository.StageRepository;
import um5.fmp.stages.gestion_stages.services.EmailServiceImpl;

@SpringBootApplication
public class GestionStagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStagesApplication.class, args);
	}
	
	@Bean
	  public ApplicationRunner dataLoader(EmailServiceImpl es,
			  EtudiantRepository etudiantRepo,EncadrantRepository encadrantRepo,EmplacementStageRepository locationRepo,StageRepository stageRepo,NiveauRepository niveauRepo ,RoleRepository roleRepo,PasswordEncoder encoder) {

		
		
		/*Niveau niveau1 = niveauRepo.findById(Long.parseLong("7")).get();
		Niveau niveau2 = niveauRepo.findById(Long.parseLong("8")).get();
		Role role = roleRepo.findById(Long.parseLong("2")).get();
		Role roleEncadrant = roleRepo.findById(Long.parseLong("6")).get();
		Stage stage1 = stageRepo.findById(Long.parseLong("4")).get();
		Stage stage2 = stageRepo.findById(Long.parseLong("5")).get();*/
		
		
		/*Encadrant e1 = new Encadrant();
		e1.setPrenom("Ahmed");
		e1.setNom("Mohamed");
		e1.setEmail("test@email.com");
		e1.setPassword(encoder.encode("password"));
		e1.setNiveau(niveau2);
		e1.setUsername("Ahmed");

		List<Role> roles2 = new ArrayList<Role>();
		roles2.add(roleEncadrant);
		e1.setRoles(roles2);
		encadrantRepo.save(e1);*/
		
		
		
		
		
		/*Niveau niveau = niveauRepo.findById(Long.parseLong("6")).get();
		Role role = roleRepo.findById(Long.parseLong("4")).get();
		Etudiant e2 = new Etudiant();
		e2.setPrenom("Quedor");
		e2.setNom("Sniper");
		e2.setEmail("quedor@email.com");
		e2.setPassword(encoder.encode("password"));
		e2.setNiveau(niveau);
		e2.setUsername("Quedor");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		e2.setRoles(roles);
		etudiantRepo.save(e2);*/
		//System.out.println(es.sendSimpleMail(new EmailDetails("zakaria2ettani@gmail.com", "test dev", "test fmp stage", null)));;
		/*
		EmplacementStage location = new EmplacementStage();
		location.setNom("R&D Lab");
		location.setAdresse("6th avenu");
		location.setVille("Marrakech");
		
		locationRepo.save(location);
		
		Role rEtudiant = new Role();
		rEtudiant.setNom("ETUDIANT");
		roleRepo.save(rEtudiant);
		
		Stage stage = new Stage();
		stage.setDuree(2);
		stage.setNom("Stage 1 ere annee");
		stage.setSujet("Recherche et development d'un medicament");
		
		stageRepo.save(stage);
		*/
		/*Stage stage = stageRepo.findById(Long.parseLong("5")).get();
		Role role = roleRepo.findById(Long.parseLong("4")).get();
		Niveau niveau = niveauRepo.findById(Long.parseLong("6")).get();
		
		Niveau n1 = new Niveau();
		n1.setLibelle("1");
		List<Stage> stages = new ArrayList<Stage>();
		stages.add(stage);
		n1.setStages(stages);

		niveauRepo.save(n1);
		*/
		/*
		Etudiant e1 = new Etudiant();
		e1.setPrenom("karim");
		e1.setNom("test2");
		e1.setEmail("karim@email.com");
		e1.setPassword("password");
		e1.setNiveau(niveau);
		e1.setUsername("karim");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		e1.setRoles(roles);
		
		Etudiant e2 = new Etudiant();
		e2.setPrenom("kamal");
		e2.setNom("michel");
		e2.setEmail("kamal@email.com");
		e2.setPassword("password");
		e2.setNiveau(niveau);
		e2.setUsername("kamal");
		List<Role> roles1 = new ArrayList<Role>();
		roles1.add(role);
		e2.setRoles(roles1);
		
		Etudiant e3 = new Etudiant();
		e3.setPrenom("jamal");
		e3.setNom("EL kahtani");
		e3.setEmail("jamal@email.com");
		e3.setPassword("password");
		e3.setNiveau(niveau);
		e3.setUsername("jamal");
		List<Role> roles2 = new ArrayList<Role>();
		roles2.add(role);
		e3.setRoles(roles2);
		
		Etudiant e4 = new Etudiant();
		e4.setPrenom("mehdi");
		e4.setNom("gadim");
		e4.setEmail("medhi@email.com");
		e4.setPassword("password");
		e4.setNiveau(niveau);
		e4.setUsername("mehdi");
		List<Role> roles3 = new ArrayList<Role>();
		roles3.add(role);
		e4.setRoles(roles3);
		
		Etudiant e5 = new Etudiant();
		e5.setPrenom("farid");
		e5.setNom("unique");
		e5.setEmail("farid@email.com");
		e5.setPassword("password");
		e5.setNiveau(niveau);
		e5.setUsername("farid");
		List<Role> roles4 = new ArrayList<Role>();
		roles4.add(role);
		e5.setRoles(roles4);
		
		Etudiant e6 = new Etudiant();
		e6.setPrenom("amal");
		e6.setNom("hopes");
		e6.setEmail("amal@email.com");
		e6.setPassword("password");
		e6.setNiveau(niveau);
		e6.setUsername("amal");
		List<Role> roles5 = new ArrayList<Role>();
		roles5.add(role);
		e6.setRoles(roles5);
		
		Etudiant e7 = new Etudiant();
		e7.setPrenom("bouchiib");
		e7.setNom("benboun");
		e7.setEmail("bouchiib@email.com");
		e7.setPassword("password");
		e7.setNiveau(niveau);
		e7.setUsername("bouchiib");
		List<Role> roles6 = new ArrayList<Role>();
		roles6.add(role);
		e7.setRoles(roles6);
		
		Etudiant e8 = new Etudiant();
		e8.setPrenom("fouad");
		e8.setNom("heart");
		e8.setEmail("fouad@email.com");
		e8.setPassword("password");
		e8.setNiveau(niveau);
		e8.setUsername("fouad");
		List<Role> roles7 = new ArrayList<Role>();
		roles7.add(role);
		e8.setRoles(roles7);
		
		Etudiant e9 = new Etudiant();
		e9.setPrenom("kedour");
		e9.setNom("teren");
		e9.setEmail("kedour@email.com");
		e9.setPassword("password");
		e9.setNiveau(niveau);
		e9.setUsername("kedour");
		List<Role> roles8 = new ArrayList<Role>();
		roles8.add(role);
		e9.setRoles(roles8);
		
		Etudiant e10 = new Etudiant();
		e10.setPrenom("ilham");
		e10.setNom("inspiration");
		e10.setEmail("ilham@email.com");
		e10.setPassword("password");
		e10.setNiveau(niveau);
		e10.setUsername("ilham");
		List<Role> roles9 = new ArrayList<Role>();
		roles9.add(role);
		e10.setRoles(roles9);
		
		Etudiant e11 = new Etudiant();
		e1.setPrenom("soukaina");
		e1.setNom("souka");
		e1.setEmail("soukq@email.com");
		e1.setPassword("password");
		e1.setNiveau(niveau);
		e1.setUsername("soukaina");
		List<Role> roles10 = new ArrayList<Role>();
		roles10.add(role);
		e1.setRoles(roles10);
		
		etudiantRepo.save(e1);
		etudiantRepo.save(e2);
		etudiantRepo.save(e3);
		etudiantRepo.save(e4);
		etudiantRepo.save(e5);
		etudiantRepo.save(e6);
		etudiantRepo.save(e7);
		etudiantRepo.save(e8);
		etudiantRepo.save(e9);
		etudiantRepo.save(e10);
		etudiantRepo.save(e11);
		*/
		
		return args -> {
		      
		    };
		    
	}

}
