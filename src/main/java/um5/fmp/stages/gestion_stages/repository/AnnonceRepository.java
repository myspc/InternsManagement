package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import um5.fmp.stages.gestion_stages.models.Annonce;
import um5.fmp.stages.gestion_stages.models.Etudiant;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	@Query("Select u From Annonce u where lower(u.titre) like lower(concat('%', :searchTerm, '%'))"+"or lower(u.description) like lower(concat('%', :searchTerm, '%'))")
    Page<Annonce> searchAnnonce(String searchTerm,Pageable pageable);
}
