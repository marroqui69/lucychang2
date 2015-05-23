package be.odisee.lucychang.service;

import be.odisee.lucychang.domain.*;
import be.odisee.lucychang.utilities.RolNotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

public interface BrainstormSessieService {

    public Sessie voegSessieToe(int id, String titel);

    public Sessie voegSessieToe(String titel);

    public Sessie zoekSessieMetId(int id);

    public Persoon voegPersoonToe(int id, String voornaam, String familienaam, String emailadres, String paswoord);

    public Persoon voegPersoonToe(String voornaam, String familienaam, String emailadres, String paswoord);

    public Persoon zoekPersoonMetId(int id);

    public Persoon zoekPersoonMetEmailadres(String username);

    public List<Persoon> geefAllePersonen();

    public Rol voegRolToe(String type, int sessieId, int persoonId, String usernaam) throws RolNotFoundException;

    public Rol zoekRolMetId(int id);

    public Rol zoekRolMetUserid(String userid);

    public Onderwerp voegOnderwerpToe(int onderwerpId, int sessieId, int facilitatorId, String titel);

    public Onderwerp voegOnderwerpToe(int sessieId, int facilitatorId, String titel);

    public Onderwerp zoekOnderwerpMetId(int id);

    public Bijdrage voegBijdrageToe
            (int id, int onderwerpId, int deelnemerId, String type, int reactieOpBijdrageId, String bijdragetekst);

    public Bijdrage voegBijdrageToe
            (int onderwerpId, int deelnemerId, String type, int reactieOpBijdrageId, String tekst);

    public Bijdrage zoekBijdrageMetId(int id);

    public boolean verwijderBijdrage(Bijdrage bjdrage);

    public void toonSessieResultaten(Sessie sessie);

}