package be.odisee.lucychang.service;

import be.odisee.lucychang.dao.*;
import be.odisee.lucychang.domain.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("LucyChangService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class LucyChangServiceImpl implements LucyChangService {
	@Autowired
	private ReclameberichtDao reclameberichtdao;
	public LucyChangServiceImpl(){}

	@Autowired
	public void setReclameberichtdao(ReclameberichtDao reclameberichtdao) {
		this.reclameberichtdao = reclameberichtdao;
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Reclamebericht voegReclameberichtToe(String titel, String status, String probleemOmschrijving, String oplossing) {
		return reclameberichtdao.bewaarReclamebericht(titel, status, probleemOmschrijving, oplossing);
	}

	@Transactional(propagation= Propagation.REQUIRED,readOnly=false)
	public Reclamebericht zoekReclameberichtId(int id) {
		return reclameberichtdao.getReclameId(id);
	}

	public List<Reclamebericht> geefReclameberichten() {
		return reclameberichtdao.getReclame();
	}

	public void deleteReclamebericht(int id) {
		reclameberichtdao.deleteReclame(id);
	}
	
	public void updateReclamebericht(int id, String titel, String status, String probleemOmschrijving, String oplossing){
		reclameberichtdao.updateReclame(id, titel, status, probleemOmschrijving, oplossing);
	}
}