package be.odisee.lucychang.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends Rol {

    public Administrator(){}

    public Administrator(String status, String usernaam, Sessie sessie, Persoon persoon){
        super(status,usernaam,sessie,persoon);
    }

    public Administrator(int id, String status, String usernaam, Sessie sessie, Persoon persoon){
        super(id,status,usernaam,sessie,persoon);
    }

    @Override
    public String getType() {
        return "Administrator";
    }

}