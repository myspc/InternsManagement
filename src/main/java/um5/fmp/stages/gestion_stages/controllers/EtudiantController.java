package um5.fmp.stages.gestion_stages.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.Document;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.repository.UserRepository;
import um5.fmp.stages.gestion_stages.services.EtudiantService;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
	
	@Autowired
	private EtudiantService etudiantService;
	
	
	
	
	@GetMapping("/me")
	public Etudiant me(Principal principal) {
		return etudiantService.me(principal.getName());
	}
	
	@PutMapping("/etudiant")
	public void modifierPassword(@RequestBody Etudiant e) {
		etudiantService.modifierPassword(e);
	}
	
	@GetMapping("/collegues")
	public List<Etudiant> getStudentsSameClasse(@RequestParam("id") Long idNiveau){
		return etudiantService.getEtudiantSameNiveau(idNiveau);
	}
	
	@GetMapping("/encadrant")
	public Encadrant getEncadrant(@RequestParam("id") Long idNiveau) {
		return etudiantService.getEncadrantOfNiveau(idNiveau);
	}
	
	@GetMapping("/documents")
	public Encadrant getDocument(@RequestParam("id") Long idProprietaite) {
		return etudiantService.getEncadrantOfNiveau(idProprietaite);
	}
	
	@PostMapping("/importDocument")
	public void importDocument(@RequestBody Etudiant e,Document document) {
		etudiantService.deposerDocument(e, document);
	}
	
	@GetMapping("/affectations")
	public List<AffectationEmplacementStage> getAffectations(@RequestParam("id") Long idEtudiant){
		return etudiantService.getAffectations(idEtudiant);
	}
	
	@GetMapping
	public Etudiant getEtudiant(@RequestParam("id") Long idEtudiant) {
		return etudiantService.avoirEtudiant(idEtudiant);
	}
	

}
