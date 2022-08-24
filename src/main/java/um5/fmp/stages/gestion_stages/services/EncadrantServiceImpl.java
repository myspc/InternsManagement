package um5.fmp.stages.gestion_stages.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.EmplacementStage;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Niveau;
import um5.fmp.stages.gestion_stages.models.Stage;
import um5.fmp.stages.gestion_stages.repository.AffectationRepository;
import um5.fmp.stages.gestion_stages.repository.EmplacementStageRepository;
import um5.fmp.stages.gestion_stages.repository.EncadrantRepository;
import um5.fmp.stages.gestion_stages.repository.EtudiantRepository;
import um5.fmp.stages.gestion_stages.repository.UserRepository;

@Service
public class EncadrantServiceImpl implements EncadrantService {

	@Autowired
	EncadrantRepository encadrantRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	EtudiantRepository etudiantRepo;

	@Autowired
	AffectationRepository affectationRepo;

	@Autowired
	EmplacementStageRepository emplacementRepo;

	public Boolean add(Encadrant encadrant) {
		try {
			encadrantRepo.save(encadrant);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to save entity encadrant");
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Encadrant findById(Long id) {
		Optional<Encadrant> encadrant = encadrantRepo.findById(id);
		return encadrant.isPresent() ? encadrant.get() : null;
	}

	@Override
	public Page<Etudiant> getStudents(Niveau niveau, int page) {
		Pageable p = PageRequest.of(page, 10);
		return etudiantRepo.getStudents(niveau, p);
	}

	@Override
	public Page<Etudiant> searchStudents(Niveau niveau, String search, int page) {
		Pageable p = PageRequest.of(page, 10);
		return etudiantRepo.searchStudents(niveau, search, p);
	}

	@Override
	public Page<AffectationEmplacementStage> searchAssignments(Niveau niveau, String search, int page) {
		Pageable p = PageRequest.of(page, 10);
		return affectationRepo.searchAssignments(niveau, search, p);
	}

	@Override
	public Page<AffectationEmplacementStage> getAssignments(Niveau niveau, int page) {
		Pageable p = PageRequest.of(page, 10);
		return affectationRepo.getAssignments(niveau,p);
	}

	@Override
	public List<EmplacementStage> getInternshipsLocations() {

		return emplacementRepo.findAll();
	}

	@Override
	public Boolean assignStudentToLocation(Encadrant encadrant, Etudiant etudiant, Stage stage,
		EmplacementStage location, Date date_debut, Date date_fin) {
		AffectationEmplacementStage affectation = new AffectationEmplacementStage();
		affectation.setEncadrant(encadrant);
		affectation.setEtudiant(etudiant);
		affectation.setStage(stage);
		affectation.setEmplacementStage(location);
		affectation.setDate_debut(date_debut);
		affectation.setDate_fin(date_fin);
		try {
			List<AffectationEmplacementStage> affectationsEtudiant = etudiant.getAffectationEmplacementStages();

			AffectationEmplacementStage savedAffevtation = affectationRepo.save(affectation);
			affectationsEtudiant.add(savedAffevtation);
			
			etudiant.setAffectationEmplacementStages(affectationsEtudiant);
			etudiantRepo.save(etudiant);
			return true;

		} catch (Exception e) {
			// TODO: Switch to slf4j for logging
			System.out.println("Unable to save entity affectation");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean updateAssignment(AffectationEmplacementStage affectation) {
		AffectationEmplacementStage existentAffectation = affectationRepo.findById(affectation.getId()).get();
		// TODO Check nulls
		existentAffectation.setEncadrant(affectation.getEncadrant());
		existentAffectation.setEtudiant(affectation.getEtudiant());
		existentAffectation.setStage(affectation.getStage());
		existentAffectation.setEmplacementStage(affectation.getEmplacementStage());
		existentAffectation.setDate_debut(affectation.getDate_debut());
		existentAffectation.setDate_fin(affectation.getDate_fin());
		try {
			affectationRepo.save(affectation);
			return true;

		} catch (Exception e) {
			// TODO: Switch to slf4j for logging
			System.out.println("Unable to save entity affectation");
			return false;
		}
	}

	@Override
	public Boolean deleteAssignment(Long id){
		try{
			affectationRepo.deleteById(id);
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Encadrant findByEmail(String email) {
		// TODO Auto-generated method stub
		return (Encadrant) userRepo.findByEmail(email);
	}

}
