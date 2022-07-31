package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import um5.fmp.stages.gestion_stages.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
