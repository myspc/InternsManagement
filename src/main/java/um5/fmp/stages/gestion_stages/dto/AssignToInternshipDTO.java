package um5.fmp.stages.gestion_stages.dto;

import java.util.Date;

import lombok.Data;
import um5.fmp.stages.gestion_stages.models.EmplacementStage;
import um5.fmp.stages.gestion_stages.models.Encadrant;
import um5.fmp.stages.gestion_stages.models.Etudiant;
import um5.fmp.stages.gestion_stages.models.Stage;

@Data
public class AssignToInternshipDTO {
	private Encadrant encadrant;
	private Etudiant student;
	private Stage stage;
	private EmplacementStage location;
	private Date date_debut;
	private Date date_fin;

}
