package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {

    private String direcrot;
    private String actor;

    public String getDirecrot() {
        return direcrot;
    }
 
    public void setDirecrot(String direcrot) {
        this.direcrot = direcrot;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
