package be.odisee.lucychang.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Reactie")
public class Reactie extends Bijdrage implements Serializable {

    public Reactie(){}

    public Reactie(int id, String status, Deelnemer deelnemer, Bijdrage reactieOp, String tekst, Onderwerp onderwerp) throws Exception {
        super(id, status, deelnemer, tekst, onderwerp);
        if (reactieOp == null) throw new Exception("FOUT: van een reactie moet gegeven zijn waarop gereageerd wordt");
        this.reactieOp = reactieOp;
    }

    public Reactie(String status, Deelnemer deelnemer, Bijdrage reactieOp, String tekst, Onderwerp onderwerp) throws Exception {
        super(status, deelnemer, tekst, onderwerp);
        if (reactieOp == null) throw new Exception("FOUT: van een reactie moet gegeven zijn waarop gereageerd wordt");
        this.reactieOp = reactieOp;
    }

    public Bijdrage getReactieOp(){
        return reactieOp;
    }

    public void setReactieOp(Bijdrage newVal){
        reactieOp = newVal;
    }


}