package be.odisee.lucychang.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Facilitator")
public class Facilitator extends Rol {

    @OneToMany(fetch=FetchType.LAZY,mappedBy="m_Facilitator")
    private List<Onderwerp> m_Onderwerpen;

    public Facilitator(){}

    public Facilitator(String status, String usernaam, Sessie sessie,Persoon persoon){
        super(status,usernaam, sessie,persoon);
    }

    public Facilitator(int id, String status, String usernaam, Sessie sessie, Persoon persoon){
        super(id,status,usernaam, sessie,persoon);
    }

    @Override
    public String getType() {
        return "Facilitator in brainstormsessie "+this.sessie.getTitel();
    }

    public List<Onderwerp> getOnderwerpen(){
            return m_Onderwerpen;
    }

    public void voegOnderwerpToe(Onderwerp newVal){
            m_Onderwerpen.add(newVal);
    }
}