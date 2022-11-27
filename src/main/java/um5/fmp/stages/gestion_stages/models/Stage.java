package um5.fmp.stages.gestion_stages.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Stage")
@Data
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String sujet;
    private int duree;
	
	public boolean eq(Stage obj) {
		if(this.id==obj.id)
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
    
    
}
