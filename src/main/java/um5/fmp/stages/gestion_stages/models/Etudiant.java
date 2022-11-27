package um5.fmp.stages.gestion_stages.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "ETUDIANT")
@JsonSerialize
public class Etudiant extends User {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    private Niveau niveau;

    @OneToMany
    @JsonIgnoreProperties("proprietaire")
    private List<Document> documents;

    @OneToMany
    @JsonIgnoreProperties("etudiant")
    private List<AffectationEmplacementStage> affectationEmplacementStages;
}
