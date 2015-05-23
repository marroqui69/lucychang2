package be.odisee.lucychang.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Organisator")
public class Organisator extends Rol {

    public Organisator(){}

    public Organisator(String status, String usernaam, Sessie sessie, Persoon persoon){
        super(status,usernaam,sessie,persoon);
    }

    public Organisator(int id, String status, String usernaam, Sessie sessie, Persoon persoon){
        super(id,status,usernaam,sessie,persoon);
    }

    @Override
    public String getType() {
        return "Organisator";
    }

}