package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Niveau;

public interface AffectationRepository extends JpaRepository<AffectationEmplacementStage, Long> {

	
    @Query("Select a From AffectationEmplacementStage a Where a.niveau = :niveau")
    Page<AffectationEmplacementStage> getAssignments(Niveau niveau,Pageable pageable);
    
    @Query("Select a From AffectationEmplacementStage a Where a.niveau = :niveau AND lower(a.etudiant.nom) like lower(concat('%', :searchTerm, '%'))"+
    "or lower(a.etudiant.prenom) like lower(concat('%', :searchTerm, '%'))"+
    "or lower(a.emplacementStage.nom) like lower(concat('%', :searchTerm, '%'))"+
    "or lower(a.emplacementStage.ville) like lower(concat('%', :searchTerm, '%'))")
    Page<AffectationEmplacementStage> searchAssignments(Niveau niveau,String searchTerm,Pageable pageable);

}
