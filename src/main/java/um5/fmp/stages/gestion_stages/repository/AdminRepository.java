package um5.fmp.stages.gestion_stages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import um5.fmp.stages.gestion_stages.models.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {

}
