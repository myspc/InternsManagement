package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Stage;

public interface StageRepository extends JpaRepository<Stage, Long> {
	@Query("Select u From Stage u where lower(u.nom) like lower(concat('%', :searchTerm, '%'))"+"or lower(u.sujet) like lower(concat('%', :searchTerm, '%'))")
    Page<Stage> searchStage(String searchTerm,Pageable pageable);
}
