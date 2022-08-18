package um5.fmp.stages.gestion_stages.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import um5.fmp.stages.gestion_stages.models.AffectationEmplacementStage;
import um5.fmp.stages.gestion_stages.models.EmplacementStage;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Niveau;
import um5.fmp.stages.gestion_stages.models.Stage;

public interface EncadrantService {

    public Encadrant findById(Long id);
    
    public Encadrant findByEmail(String email);

    /**
     * Get students of same level as the mentor
     */
    public Page<Etudiant> getStudents(Niveau niveau, int page);
    
    public Page<Etudiant> searchStudents(Niveau niveau,String search, int page);

    public List<EmplacementStage> getInternshipsLocations();
    
    public Page<AffectationEmplacementStage> getAssignments(Niveau niveau, int page);

    public Page<AffectationEmplacementStage> searchAssignments(Niveau niveau, String search,  int page);

    public Boolean assignStudentToLocation(Encadrant encadrant, Etudiant etudiant, Stage stage,
            EmplacementStage location,
            Date date_debut, Date date_fin);

    public Boolean updateAssignment(AffectationEmplacementStage affectation);

}
