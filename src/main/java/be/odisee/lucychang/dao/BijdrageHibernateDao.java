package be.odisee.lucychang.dao;

import org.springframework.stereotype.Repository;

import be.odisee.lucychang.domain.Bijdrage;

@Repository("bijdrageDao")
public class BijdrageHibernateDao extends HibernateDao implements BijdrageDao {

    public Bijdrage saveBijdrage(Bijdrage bijdrage) {
        sessionSaveObject(bijdrage);
        return bijdrage;
    }

    public Bijdrage getBijdrageById(int id) {
        return (Bijdrage) sessionGetObjectById("Bijdrage", id);
    }

}
