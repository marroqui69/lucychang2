package be.odisee.lucychang.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Idee")
public class Idee extends Bijdrage implements Serializable {

    public Idee(){

    }

    public Idee(int id, String status, Deelnemer deelnemer, Bijdrage reactieOp, String tekst, Onderwerp onderwerp) {
        super(id, status, deelnemer, tekst, onderwerp);
        if (reactieOp != null) this.reactieOp = reactieOp;
    }

    public Idee(String status, Deelnemer deelnemer, Bijdrage reactieOp, String tekst, Onderwerp onderwerp) {
        super(status, deelnemer, tekst, onderwerp);
        if (reactieOp != null) this.reactieOp = reactieOp;
    }

    public Bijdrage getReactieOp(){
        return reactieOp;
    }

    public void setReactieOp(Bijdrage newVal){
        reactieOp = newVal;
    }

}