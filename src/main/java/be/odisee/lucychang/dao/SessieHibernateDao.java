package be.odisee.lucychang.dao;

import org.hibernate.*;
import org.springframework.stereotype.Repository;

import be.odisee.lucychang.domain.Sessie;


@Repository("sessieDao")
public class SessieHibernateDao extends HibernateDao implements SessieDao {


    public Sessie saveSessie(int id, String status, String titel) {
        Sessie sessie = new Sessie(id, status, titel);
        sessionSaveObject(sessie);
        return sessie;
    }

    public Sessie saveSessie(String status, String titel) {
        Sessie sessie = new Sessie(status, titel);
        sessionSaveObject(sessie);
        return sessie;
    }

    public Sessie getSessieById(int sessieId) {
        return (Sessie) sessionGetObjectById("Sessie", sessieId);
    }


}
