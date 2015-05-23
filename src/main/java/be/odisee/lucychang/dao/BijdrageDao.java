package be.odisee.lucychang.dao;

import be.odisee.lucychang.domain.Bijdrage;

public interface BijdrageDao {

    public Bijdrage saveBijdrage(Bijdrage bijdrage);

    public Bijdrage getBijdrageById(int id);

}
