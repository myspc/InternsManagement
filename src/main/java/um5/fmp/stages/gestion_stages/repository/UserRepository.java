package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	
	@Query("Select u From User u Where lower(u.nom) like lower(concat('%', :searchTerm, '%'))"+"or lower(u.prenom) like lower(concat('%', :searchTerm, '%'))"+"or lower(u.email) like lower(concat('%', :searchTerm, '%'))")
    Page<Etudiant> searchStudents(String searchTerm,Pageable pageable);
}
