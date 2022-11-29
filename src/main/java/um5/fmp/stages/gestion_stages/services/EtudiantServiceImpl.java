package um5.fmp.stages.gestion_stages.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um5.fmp.stages.gestion_stages.dto.DocumentDTO;
import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.Document;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.repository.AffectationRepository;
import um5.fmp.stages.gestion_stages.repository.DocumentRepository;
import um5.fmp.stages.gestion_stages.repository.EmplacementStageRepository;
import um5.fmp.stages.gestion_stages.repository.EtudiantRepository;
import um5.fmp.stages.gestion_stages.repository.UserRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private AffectationRepository affectationRepository;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public void modifierPassword(Etudiant etudiant) {
		Etudiant e=etudiantRepository.findById(etudiant.getId()).get();
		if (e!=null) {
			e.setPassword(etudiant.getPassword());
			etudiantRepository.save((Etudiant) e);
		}	
	}

	@Override
	public List<Etudiant> getEtudiantSameNiveau(String email) {
		return etudiantRepository.getListEtudiantSameNiveau(((Etudiant)userRepo.findByEmail()).getId());
	}

	@Override
	public Encadrant getEncadrantOfNiveau(Long id) {
		return etudiantRepository.getEncadrantOfNiveau(id);
	}

	@Override
	public boolean deposerDocument(Etudiant etudiant, DocumentDTO document) {
		Etudiant e=etudiantRepository.findById(etudiant.getId()).get();
		AffectationEmplacementStage aes = affectationRepository.findById(document.getAffectationId()).get();
		Document d = new Document();
		if (e!=null) {
			d.setLien(document.getLien());
			d.setType(document.getType());
			d.setDescription(document.getDescription());
			d.setProprietaire(e);
			try {
				documentRepository.save(d);
				List<Document> documentsAES = aes.getDocuments();
				List<Document> documentsE = e.getDocuments();
				
				
				documentsAES.add(d);
				documentsE.add(d);


				aes.setDocuments(documentsAES);
				e.setDocuments(documentsE);
				affectationRepository.save(aes);
				etudiantRepository.save(e);
				return true;
			} catch (Exception e2) {
				System.out.println(e2.getMessage()); 
				e2.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Document> getDocumentsEtd(Long id) {
		return etudiantRepository.getDocumentsEtd(id);
	}

	@Override
	public List<AffectationEmplacementStage> getAffectations(Long id) {
		return etudiantRepository.getAffectations(id);
		
	}

	@Override
	public Etudiant avoirEtudiant(Long id) {
		Optional<Etudiant> etudiant=etudiantRepository.findById(id);
		return etudiant.isPresent() ? etudiant.get() : null;
	}

	@Override
	public Etudiant me(String email) {
		// TODO Auto-generated method stub
		return (Etudiant)userRepo.findByEmail(email);
	}
	
}
