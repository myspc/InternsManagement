package um5.fmp.stages.gestion_stages.dto;

import lombok.Data;

@Data
public class EtudiantDTO {
	private String nom;
	private String prenom;
	private String password;
	private String email;
	private long niveau;

}
