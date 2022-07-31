package um5.fmp.stages.gestion_stages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import um5.fmp.stages.gestion_stages.models.Admin;
import um5.fmp.stages.gestion_stages.models.Annonce;
import um5.fmp.stages.gestion_stages.models.Document;
import um5.fmp.stages.gestion_stages.models.EmplacementStage;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Niveau;
import um5.fmp.stages.gestion_stages.models.Stage;
import um5.fmp.stages.gestion_stages.repository.AdminRepository;
import um5.fmp.stages.gestion_stages.repository.AffectationRepository;
import um5.fmp.stages.gestion_stages.repository.AnnonceRepository;
import um5.fmp.stages.gestion_stages.repository.DocumentRepository;
import um5.fmp.stages.gestion_stages.repository.EmplacementStageRepository;
import um5.fmp.stages.gestion_stages.repository.EncadrantRepository;
import um5.fmp.stages.gestion_stages.repository.EtudiantRepository;
import um5.fmp.stages.gestion_stages.repository.NiveauRepository;
import um5.fmp.stages.gestion_stages.repository.StageRepository;
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminRepository adminRepo;
	AffectationRepository affectationRepo;
	AnnonceRepository annonceRepo;
	DocumentRepository documentRepo;
	EmplacementStageRepository emplacementStageRepo;
	EncadrantRepository encadrantRepo;
	EtudiantRepository etudiantRepo;
	NiveauRepository niveauRepo;
	StageRepository stageRepo;
	//afficher les entites:
	
	@GetMapping("/helloEncadrant")
	@PreAuthorize("hasRole('ENCADRANT')")
	public String helloEncadrant() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		return "Hello encadrant: " +currentPrincipalName+ "";
	}
	
	@GetMapping("/etudiants")
	public List<Etudiant> listEtudiant() {
		return etudiantRepo.findAll();
	}
	@GetMapping("/encadrants")
	public List<Encadrant> listEncadrant() {
		return encadrantRepo.findAll();
	}
	@GetMapping("/administrateurs")
	public List<Admin> listAdmin() {
		return adminRepo.findAll();
	}
	@GetMapping("/stages")
	public List<Stage> listStage() {
		return stageRepo.findAll();
	}
	@GetMapping("/annonces")
	public List<Annonce> listAnnonce() {
		return annonceRepo.findAll();
	}
	@GetMapping("/documents")
	public List<Document> listDocuments() {
		return documentRepo.findAll();
	}
	@GetMapping("/emplacements")
	public List<EmplacementStage> listEmplacement() {
		return emplacementStageRepo.findAll();
	}
	@GetMapping("/niveau")
	public List<Niveau> listNiveau() {
		return niveauRepo.findAll();
	}
	
	//find by id:
	
	@GetMapping("/etudiant/{id}")
	public Etudiant getEtudiant(@PathVariable long id) {
		return etudiantRepo.findById(id).get();
	}
	@GetMapping("/encadrant/{id}")
	public Encadrant getEncadrant(@PathVariable long id) {
		return encadrantRepo.findById(id).get();
	}
	@GetMapping("/admin/{id}")
	public Admin getAdministrateur(@PathVariable long id) {
		return adminRepo.findById(id).get();
	}
	@GetMapping("/stage/{id}")
	public Stage getStage(@PathVariable long id) {
		return stageRepo.findById(id).get();
	}
	@GetMapping("/annonce/{id}")
	public Annonce getAnnonce(@PathVariable long id) {
		return annonceRepo.findById(id).get();
	}
	@GetMapping("/document/{id}")
	public Document getDocument(@PathVariable long id) {
		return documentRepo.findById(id).get();
	}
	@GetMapping("/emplacement/{id}")
	public EmplacementStage getEmplacement(@PathVariable long id) {
		return emplacementStageRepo.findById(id).get();
	}
	@GetMapping("/niveau/{id}")
	public Niveau getNiveau(@PathVariable long id) {
		return niveauRepo.findById(id).get();
	}
	
	//ajoute les entites:
	
	@PostMapping("/etudiant")
	public void ajouterEtudiant(@RequestBody Etudiant e) {
		etudiantRepo.save(e);
	}
	
	

}
