package um5.fmp.stages.gestion_stages.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Document")
@Data
@NoArgsConstructor
@JsonSerialize
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lien;
    private String description;
    private String type;

    @ManyToOne
    @JsonIgnoreProperties("{documents}")
    private Etudiant proprietaire;
}
