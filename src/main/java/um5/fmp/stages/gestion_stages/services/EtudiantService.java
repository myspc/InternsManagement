package um5.fmp.stages.gestion_stages.services;

import java.util.List;

import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.Document;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;

public interface EtudiantService {
	
	//Modifier le mot de passe de l'etudiant
	public void modifierPassword(Etudiant etudiant);
	
	//Consulter les etudiants de même niveau
	public List<Etudiant> getEtudiantSameNiveau(Long id);
	
	//Consulter les infos de l'encadrant
	public Encadrant getEncadrantOfNiveau(Long id);
	
	//Consulter la liste des documents
	public List<Document> getDocumentsEtd(Long id);
	
	//Ajouter/dépôser des documents
	public void deposerDocument(Etudiant etudiant,Document document);
	
	//Detail des affectations stages
	public List<AffectationEmplacementStage> getAffectations(Long id);
	
	//Retourner un etudiant
	public Etudiant avoirEtudiant(Long id);
	
	public Etudiant me(String email);
	
}
