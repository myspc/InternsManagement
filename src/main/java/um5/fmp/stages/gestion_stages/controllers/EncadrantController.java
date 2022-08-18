package um5.fmp.stages.gestion_stages.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import um5.fmp.stages.gestion_stages.dto.AssignToInternshipDTO;
import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.EmplacementStage;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Niveau;
import um5.fmp.stages.gestion_stages.repository.EtudiantRepository;
import um5.fmp.stages.gestion_stages.repository.NiveauRepository;
import um5.fmp.stages.gestion_stages.services.EncadrantServiceImpl;

@RestController
@RequestMapping("/encadrant")
public class EncadrantController {

	@Autowired
	EncadrantServiceImpl encadrantService;

	@Autowired
	EtudiantRepository etudiantRepo;

	@Autowired
	NiveauRepository niveauRepo;

	@GetMapping("/students")
	public Page<Etudiant> getStudents(Principal principal, @RequestParam("page") int page) {
		Encadrant enc = encadrantService.findByEmail(principal.getName());
		return encadrantService.getStudents(enc.getNiveau(), page);
	}

	@GetMapping("/students/search")
	public Page<Etudiant> findStudents(Principal principal, @RequestParam("search") String search,
			@RequestParam("page") int page) {
		Encadrant enc = encadrantService.findByEmail(principal.getName());

		return encadrantService.searchStudents(enc.getNiveau(), search, page);
	}

	@GetMapping("/assignments")
	public Page<AffectationEmplacementStage> getAssignments(@RequestParam("page") int page, Principal principal) {
		Encadrant enc = encadrantService.findByEmail(principal.getName());

		// TODO check if page param not porvided

		return encadrantService.getAssignments(enc.getNiveau(), page);
	}

	@GetMapping("/assignments/search")
	public Page<AffectationEmplacementStage> searchAssignments(Principal principal,
			@RequestParam("search") String search, @RequestParam("page") int page) {
		Encadrant enc = encadrantService.findByEmail(principal.getName());

		// TODO check if page param not porvided

		return encadrantService.searchAssignments(enc.getNiveau(), search, page);
	}

	@GetMapping("/me")
	public Encadrant me(Principal principal) {
		Encadrant enc = encadrantService.findByEmail(principal.getName());

		// TODO check if page param not porvided

		return enc;
	}

	@GetMapping("/internships/locations")
	public List<EmplacementStage> getInternshipLocations() {

		return encadrantService.getInternshipsLocations();
	}

	@PostMapping("/internships/assign")
	public Boolean assignInternship(Principal principal, @RequestBody AssignToInternshipDTO affectation) {
		Encadrant encadrant = encadrantService.findByEmail(principal.getName());

		return encadrantService.assignStudentToLocation(encadrant, affectation.getStudent(), affectation.getStage(),
				affectation.getLocation(), affectation.getDate_debut(), affectation.getDate_fin());
	}

	@PostMapping("/internships/assignment/update")
	public Boolean updateAssignment(@RequestBody AffectationEmplacementStage affectation) {
		System.out.println(affectation.getId());
		System.out.println(affectation.getEtudiant().getNom());
		return encadrantService.updateAssignment(affectation);
	}
}
