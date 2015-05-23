package be.odisee.lucychang.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.stereotype.Repository;

import be.odisee.lucychang.domain.Persoon;


@Repository("persoonDao")
public class PersoonHibernateDao extends HibernateDao implements PersoonDao {

    public Persoon savePersoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Persoon persoon = new Persoon(id, status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(persoon);
        return persoon;
    }

    public Persoon savePersoon(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Persoon persoon = new Persoon(status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(persoon);
        return persoon;
    }

    public Persoon getPersoonById(int persoonId) {
        return (Persoon) sessionGetObjectById("Persoon", persoonId);
    }

    @Override
    public Persoon getPersoonByEmailadres(String emailadres) {
        return (Persoon) sessionGetObjectByStringParameterValue("Persoon", "emailadres", emailadres);
    }

    private Persoon sessionGetObjectByStringParameterValue(String string,
			String string2, String emailadres) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Persoon> getAllPersons() {
        return (List<Persoon>) sessionGetAllObjects("Persoon");
    }

    public void updatePersoon(Persoon persoon) {
        sessionUpdateObject(persoon);
    }

}
