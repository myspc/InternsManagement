package um5.fmp.stages.gestion_stages.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.Document;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Niveau;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> /*extends PagingAndSortingRepository<Etudiant, Long> */{
   
	//Consulter la liste des étudiants de son niveau
	@Query(value="select e from Etudiant e where e.niveau.id=:id")
	List<Etudiant> getListEtudiantSameNiveau(@Param("id")Long id);
	
	//Consulter les infos de l'encadrant
	@Query(value="select e from Encadrant e where e.niveau.id=:id") 
	Encadrant getEncadrantOfNiveau(@Param("id")Long id);
	
	
	//Consulter la liste des documents dépôsés
	@Query(value="select d from Document d where d.proprietaire.id=:id")
	List<Document> getDocumentsEtd(@Param("id")Long id);
	
	//Consulter le detail de stages affecté
	@Query(value="select a from AffectationEmplacementStage a where a.etudiant.id=:id")
	List<AffectationEmplacementStage> getAffectations(@Param("id")Long id);
	

	/**

     * Fetch student of a specifique year
     */	

    @Query("Select e From Etudiant e Where e.niveau = :niveau")
    Page<Etudiant> getStudents(Niveau niveau,Pageable pageable);

	

 }

