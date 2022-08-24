package um5.fmp.stages.gestion_stages.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "ENCADRANT")
public class Encadrant extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Niveau niveau;

	@OneToMany
	@JsonIgnoreProperties("{encadrant,etudiant,documents}")
	private List<AffectationEmplacementStage> affectationEmplacementStages;
}
