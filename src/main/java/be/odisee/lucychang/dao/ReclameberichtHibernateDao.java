package be.odisee.lucychang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import be.odisee.lucychang.domain.Reclamebericht;

@Repository("reclameberichtDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class ReclameberichtHibernateDao extends HibernateDao implements ReclameberichtDao {
	
	public Reclamebericht bewaarReclamebericht(int id, String titel, String status, String probleemOmschrijving, String oplossing) {
		Reclamebericht reclame = new Reclamebericht(id,  titel,  status, probleemOmschrijving,  oplossing);
		sessionSaveObject(reclame);
		return reclame;
	}
	
	public Reclamebericht bewaarReclamebericht(String titel, String status, String probleemOmschrijving, String oplossing) {
		Reclamebericht reclame = new Reclamebericht(titel, status, probleemOmschrijving, oplossing);
		sessionSaveObject(reclame);
		return reclame;
	}
	
	public Reclamebericht getReclameId(int reclameID) {
		 return (Reclamebericht) sessionGetObjectById("Reclamebericht", reclameID);
	}

	@SuppressWarnings("unchecked")
	public List<Reclamebericht> getReclame() {
		 return (List<Reclamebericht>) sessionGetAllObjects("Reclamebericht");
	}

	@Override
	public void deleteReclame(int id) {
		Reclamebericht verwijderen = getReclameId(id);
		sessionDeleteObject(verwijderen);
	}
	
	@Override
	public void updateReclame(int id, String titel, String status, String probleemOmschrijving, String oplossing){
		Reclamebericht wijzigen = getReclameId(id);
		wijzigen.setTitel(titel);
		wijzigen.setStatus(status);
		wijzigen.setPrombleemOmschrijving(probleemOmschrijving);
		wijzigen.setOplossing(oplossing);
		sessionUpdateObject(wijzigen);
	}
}
