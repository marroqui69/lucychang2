package be.odisee.lucychang.service;

import be.odisee.lucychang.dao.*;
import be.odisee.lucychang.domain.*;
import be.odisee.lucychang.utilities.RolNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service("brainstormSessieService")
public class BrainstormSessieServiceImpl implements BrainstormSessieService {

    private SessieDao sessieDao;
    private PersoonDao persoonDao;
    private RolDao rolDao;
    private OnderwerpDao onderwerpDao;
    private BijdrageDao bijdrageDao;

    public BrainstormSessieServiceImpl(){}

    @Autowired
    public void setSessieDao(SessieDao sessieDao) {
        this.sessieDao = sessieDao;
    }

    @Autowired
    public void setPersoonDao(PersoonDao persoonDao) {
        this.persoonDao = persoonDao;
    }

    @Autowired
    public void setRolDao(RolDao rolDao) {
        this.rolDao = rolDao;
    }

    @Autowired
    public void setOnderwerpDao(OnderwerpDao onderwerpDao) {
        this.onderwerpDao = onderwerpDao;
    }

    @Autowired
    public void setBijdrageDao(BijdrageDao bijdrageDao) {
        this.bijdrageDao = bijdrageDao;
    }

   public Sessie voegSessieToe(int id, String titel) {
        return sessieDao.saveSessie(id, "actief", titel);
    }

    public Sessie voegSessieToe(String titel) {
        return sessieDao.saveSessie("actief", titel);
    }

    public Sessie zoekSessieMetId(int id){
        return sessieDao.getSessieById(id);
    }

    public Persoon voegPersoonToe(int id, String voornaam, String familienaam, String emailadres, String paswoord) {
        return persoonDao.savePersoon(id,"actief",voornaam,familienaam,emailadres,paswoord);
    }

    public Persoon voegPersoonToe(String voornaam, String familienaam, String emailadres, String paswoord) {
        return persoonDao.savePersoon("aktief",voornaam,familienaam,emailadres,paswoord);
    }

    public Persoon zoekPersoonMetId(int id){
        return persoonDao.getPersoonById(id);
    }

    public Persoon zoekPersoonMetEmailadres(String emailadres){
        return persoonDao.getPersoonByEmailadres(emailadres);
    }

    @Override
    public List<Persoon> geefAllePersonen() {
        return persoonDao.getAllPersons();
    }

    @Override
    public Rol voegRolToe(String type, int sessieId, int persoonId, String usernaam) throws RolNotFoundException {
        Sessie deSessie = zoekSessieMetId(sessieId);
        Persoon dePersoon = zoekPersoonMetId(persoonId);
        Rol deRol = dePersoon.voegRolToe(type, "actief", usernaam, deSessie);
        deRol = rolDao.saveRol(deRol);
        return deRol;
    }

    public Rol zoekRolMetId(int id) {
        return rolDao.getRolById(id);
    }

    public Rol zoekRolMetUserid(String userid) {
        return rolDao.getRolByUserid(userid);
    }

    // TODO deze en andere operaties (ook in andere klassen
    // met een versie met id en zonder id te refactoren (dubbele code)

    public Onderwerp voegOnderwerpToe(int onderwerpId, int sessieId, int facilitatorId, String titel){

        checkOnderwerpNietBlanco(titel);

        Onderwerp newOnderwerp
                = zoekSessieMetId(sessieId).voegOnderwerpToe(onderwerpId,(Facilitator)zoekRolMetId(facilitatorId), getActueelOnderwerp(), titel);

        onderwerpDao.saveOnderwerpEnVoorgangers(newOnderwerp); // en het vorige en voor vorige ook want status veranderd

        return newOnderwerp;
    }

    public Onderwerp voegOnderwerpToe(int sessieId, int facilitatorId, String titel){

        checkOnderwerpNietBlanco(titel);

        Onderwerp newOnderwerp
                = zoekSessieMetId(sessieId).voegOnderwerpToe((Facilitator)zoekRolMetId(facilitatorId), getActueelOnderwerp(), titel);

        onderwerpDao.saveOnderwerpEnVoorgangers(newOnderwerp); // en het vorige en voor vorige ook want status veranderd

        return newOnderwerp;
    }

    private boolean checkOnderwerpNietBlanco(String titel){

        Boolean result=false;

        // tekst van een onderwerp mag niet blanco zijn
        try {
            if ((titel == null) || (titel.equals("")) || (titel.equals(" "))){
                throw new RuntimeException("Tekst van onderwerp mag niet blanco zijn");
            }
            else result=true;
        }
        catch (Exception ex){
            System.out.println("ERROR: onderwerp '" + titel + "' toevoegen is niet gelukt.");
            ex.printStackTrace();
        }
        return result;
    }

    public Onderwerp zoekOnderwerpMetId(int id) {

        return onderwerpDao.getOnderwerpById(id);
    }

    private Onderwerp getActueelOnderwerp(){

        // het actueel onderwerp is het laatste onderwerp in de onderwerpen tabel
        return onderwerpDao.getLastOnderwerp();

    }

    // TODO deze en andere operaties (ook in andere klassen
    // met een versie met id en zonder id te refactoren (dubbele code)
    
    public Bijdrage voegBijdrageToe(int id, int onderwerpId, int deelnemerId, String type,
                                        int reactieOpBijdrageId, String tekst) {

        System.out.println("DEBUG service.voegBijdrageToe: onderwerpId="+
                                ", deelnemerId="+deelnemerId+
                                ", type="+type+
                                ", reactieOpBijdrageId="+reactieOpBijdrageId+
                                ", tekst="+tekst);

        System.out.println("DEBUG service.voegBijdrageToe bij onderwerp: "+zoekOnderwerpMetId(onderwerpId).getTitel());

        if (!checkBijdrageNietBlanco(tekst)) return null;

        Bijdrage newBijdrage = null;

        try {
            newBijdrage = zoekOnderwerpMetId(onderwerpId).voegBijdrageToe(id,
                                        (Deelnemer) zoekRolMetId(deelnemerId), type,
                                        zoekBijdrageMetId(reactieOpBijdrageId), tekst);
            if (newBijdrage!=null) bijdrageDao.saveBijdrage(newBijdrage);
        } catch (Exception ex) {
            System.out.println("ERROR: bijdrage '" + tekst + "' toevoegen is niet gelukt.");
            ex.printStackTrace();
        }

        return newBijdrage;
    }

    public Bijdrage voegBijdrageToe(int onderwerpId, int deelnemerId, String type,
                                        int reactieOpBijdrageId, String tekst) {

        if (!checkBijdrageNietBlanco(tekst)) return null;

        Bijdrage newBijdrage = null;

        try {
            newBijdrage = zoekOnderwerpMetId(onderwerpId).voegBijdrageToe
                                        ((Deelnemer) zoekRolMetId(deelnemerId), type,
                                        zoekBijdrageMetId(reactieOpBijdrageId), tekst);
            if (newBijdrage!=null) bijdrageDao.saveBijdrage(newBijdrage);
        } catch (Exception ex) {
            System.out.println("ERROR: bijdrage '" + tekst + "' toevoegen is niet gelukt.");
            ex.printStackTrace();
        }

        return newBijdrage;
    }


    private boolean checkBijdrageNietBlanco(String titel){

        Boolean result=false;

        // tekst van een onderwerp mag niet blanco zijn
        try {
            if ((titel == null) || (titel.equals("")) || (titel.equals(" "))){
                throw new RuntimeException("Tekst van onderwerp mag niet blanco zijn");
            }
            else result=true;
        }
        catch (Exception ex){
            System.out.println("ERROR: bijdrage '" + titel + "' toevoegen is niet gelukt.");
            ex.printStackTrace();
        }
        return result;
    }

    public Bijdrage zoekBijdrageMetId(int id) {

        if (id==0) return null;
        else return bijdrageDao.getBijdrageById(id);
    }

    public boolean verwijderBijdrage(Bijdrage bjdrage){
        return false;
    }


    public void toonSessieResultaten(Sessie sessie){
        // bedoeld voor preliminaire testen
        System.out.println("\nResultaten voor sessie: ");
        sessie.toonSessieResultaten();
    }

}