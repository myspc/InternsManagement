package um5.fmp.stages.gestion_stages.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Table(name="AffectationEmplacementStage")
@JsonSerialize
@Data
public class AffectationEmplacementStage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date_debut;
    private Date date_fin;
    
    @ManyToOne
    private Stage stage;

    @ManyToOne
    @JsonIgnoreProperties("affectationEmplacementStages")
    private Etudiant etudiant;

    @ManyToOne
    @JsonIgnoreProperties("affectationEmplacementStages")
    private Encadrant encadrant;

    @OneToMany
    @JsonIgnoreProperties("{proprietaire}")
    private List<Document> documents;
    
    @ManyToOne
    private EmplacementStage emplacementStage;


}
