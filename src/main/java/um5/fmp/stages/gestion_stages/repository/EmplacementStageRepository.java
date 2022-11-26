package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import um5.fmp.stages.gestion_stages.models.Annonce;
import um5.fmp.stages.gestion_stages.models.EmplacementStage;

public interface EmplacementStageRepository extends JpaRepository<EmplacementStage, Long> {
	@Query("Select u From EmplacementStage u where lower(u.nom) like lower(concat('%', :searchTerm, '%'))"+"or lower(u.adresse) like lower(concat('%', :searchTerm, '%'))"+"or lower(u.ville) like lower(concat('%', :searchTerm, '%'))")
    Page<EmplacementStage> searchEmpl(String searchTerm,Pageable pageable);
}
