package be.odisee.lucychang.domain;

import be.odisee.lucychang.utilities.RolNotFoundException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.Index;

@Entity
@Table(name="personen")
public class Persoon implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String status;

    @Column
    @Index(name="IPersoon_naam",columnNames="familienaam, voornaam")
    @NotEmpty(message="Vul voornaam in aub")
    private String voornaam;

    @Column
    @Size(min=2,message="Familienaam is minstens 2 letters aub")
    private String familienaam;

    @Column
    @Index(name="IPersoon_email",columnNames="emailadres")
    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$",message="Vul een geldig e-mail adres in ")
    private String emailadres;

    @Column
    @Size(min=6,message="Paswoord is minstens 6 letters aub")
    private String paswoord;

    // we zullen nu toch een verwijzing naar Persoon in Rol moeten toevoegen
    @OneToMany(fetch=FetchType.EAGER,mappedBy="persoon")
    private Set<Rol> m_Rollen= new HashSet<Rol>();

    public Persoon(){

    }

    public Persoon(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        this.status = status;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailadres = emailadres;
        this.paswoord = paswoord;
    }

    public Persoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        this.id = id;
        this.status = status;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailadres = emailadres;
        this.paswoord = paswoord;
    }

    public int getId() {
        return id;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public Set<Rol> getRollen(){
        return m_Rollen;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setM_Rollen(Set<Rol> m_Rollen) {
        this.m_Rollen = m_Rollen;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public Rol voegRolToe(String type, String status, String usernaam, Sessie sessie) throws RolNotFoundException{
        Rol newRol=null;
        if (type.toLowerCase().equals("administrator")) newRol= new Administrator(status, usernaam, sessie,this);
        if (type.toLowerCase().equals("organisator")) newRol= new Organisator(status, usernaam, sessie,this);
        if (type.toLowerCase().equals("facilitator")) newRol= new Facilitator(status, usernaam, sessie,this);
        if (type.toLowerCase().equals("deelnemer")) newRol= new Deelnemer(status, usernaam, sessie,this);
        if (newRol==null) throw new RolNotFoundException("Type "+type+" is geen bekende Rol");
        m_Rollen.add(newRol);
        return newRol;
    }
}