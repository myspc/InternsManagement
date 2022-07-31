package um5.fmp.stages.gestion_stages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.Document;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.repository.DocumentRepository;
import um5.fmp.stages.gestion_stages.repository.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	private DocumentRepository documentRepository;
	
	
	@Override
	public void modifierPassword(Etudiant etudiant) {
		Etudiant e=etudiantRepository.findById(etudiant.getId()).get();
		if (e!=null) {
			e.setPassword(etudiant.getPassword());
			etudiantRepository.save((Etudiant) e);
		}	
	}

	@Override
	public List<Etudiant> getEtudiantSameNiveau(Long id) {
		return etudiantRepository.getListEtudiantSameNiveau(id);
	}

	@Override
	public Encadrant getEncadrantOfNiveau(Long id) {
		return etudiantRepository.getEncadrantOfNiveau(id);
	}

	@Override
	public void deposerDocument(Etudiant etudiant, Document document) {
		Etudiant e=etudiantRepository.findById(etudiant.getId()).get();
		
		if (e!=null) {
			document.setProprietaire(e);
			documentRepository.save(document);
		}
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
	
}
