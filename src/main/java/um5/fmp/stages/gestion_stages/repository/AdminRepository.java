package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import um5.fmp.stages.gestion_stages.models.Admin;
import um5.fmp.stages.gestion_stages.models.Etudiant;



public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Query("Select u From Admin u where lower(u.nom) like lower(concat('%', :searchTerm, '%'))"+"or lower(u.prenom) like lower(concat('%', :searchTerm, '%'))"+"or lower(u.email) like lower(concat('%', :searchTerm, '%'))")
    Page<Admin> searchAdmins(String searchTerm,Pageable pageable);
}

