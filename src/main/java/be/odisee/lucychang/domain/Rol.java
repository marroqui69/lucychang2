package be.odisee.lucychang.domain;

import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.annotations.Index;

@Entity
@Table(name="rollen")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Rol")
public abstract class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected int id;

    // we willen dit even aan de db overlaten
    // specifieke noden FitLibrary zullen we met een functie oplossen
    // private static int nextid=1;

    @Column
    protected String status;

    @Column(unique=true)
    @Index(name="IRol_usernaam",columnNames="usernaam")
    protected String usernaam;

    @ManyToOne
    @JoinColumn(name="sessie_id")
    protected Sessie sessie;

    @ManyToOne
    @JoinColumn(name="persoon_id")
    protected Persoon persoon;

    public Rol(){}

    public Rol(String status, String usernaam, Sessie sessie, Persoon persoon) {
        this.status = status;
        this.usernaam = usernaam;
        this.sessie = sessie;
        this.persoon = persoon;
    }

    public Rol(int id, String status, String usernaam, Sessie sessie, Persoon persoon) {
        this.id = id;
        this.status = status;
        this.usernaam = usernaam;
        this.sessie = sessie;
        this.persoon = persoon;
    }

    public int getId() {
        return id;
    }

    public Sessie getSessie(){
        return sessie;
    }

    public String getUsernaam() {
        return usernaam;
    }

    public abstract String getType();
    
    public void setSessie(Sessie newVal){
        sessie = newVal;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

}