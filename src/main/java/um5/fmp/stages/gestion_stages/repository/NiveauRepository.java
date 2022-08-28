package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import um5.fmp.stages.gestion_stages.models.Annonce;
import um5.fmp.stages.gestion_stages.models.Niveau;

public interface NiveauRepository extends JpaRepository<Niveau, Long> {
	@Query("Select u From Niveau u where lower(u.libelle) like lower(concat('%', :searchTerm, '%'))")
    Page<Niveau> searchNiveau(String searchTerm,Pageable pageable);
}
