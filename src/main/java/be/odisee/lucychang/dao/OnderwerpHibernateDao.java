package be.odisee.lucychang.dao;

import be.odisee.lucychang.domain.Onderwerp;

import org.hibernate.*;
import org.springframework.stereotype.Repository;


@Repository("onderwerpDao")
public class OnderwerpHibernateDao extends HibernateDao implements OnderwerpDao {

    private Session hibernateSession;

    public Onderwerp saveOnderwerp(Onderwerp onderwerp) {
        sessionSaveObject(onderwerp);
        return onderwerp;
    }

    public void saveOnderwerpEnVoorgangers(Onderwerp onderwerp) {
        // moet in één transactie
        try{
            this.hibernateSession = sessionFactory.getCurrentSession();
            if (onderwerp != null) {
                hibernateSession.save(onderwerp);
                Onderwerp vorigOnderwerp = onderwerp.getvorigOnderwerp();
                if (vorigOnderwerp != null) {
                    hibernateSession.update(vorigOnderwerp);
                    Onderwerp voorVorigOnderwerp = vorigOnderwerp.getvorigOnderwerp();
                    if (voorVorigOnderwerp != null) hibernateSession.update(voorVorigOnderwerp);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Onderwerp getOnderwerpById(int id) {
        return (Onderwerp) sessionGetObjectById("Onderwerp", id);
    }

    public Onderwerp getLastOnderwerp() {
        String qry = "from Onderwerp order by id";
        return (Onderwerp) getLastObjectOfQuery(qry);
    }

}
