package be.odisee.lucychang.dao;

import be.odisee.lucychang.domain.Onderwerp;

public interface OnderwerpDao {

    public Onderwerp saveOnderwerp(Onderwerp onderwerp);

    public void saveOnderwerpEnVoorgangers(Onderwerp onderwerp);

    public Onderwerp getOnderwerpById(int id);

    public Onderwerp getLastOnderwerp();

}
