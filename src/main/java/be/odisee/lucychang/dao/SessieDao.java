package be.odisee.lucychang.dao;

import be.odisee.lucychang.domain.Sessie;

public interface SessieDao {

    public Sessie saveSessie(int id, String status, String onderwerp);
    
    public Sessie saveSessie(String status, String onderwerp);

    public Sessie getSessieById(int sessieId);

}
