package be.odisee.lucychang.dao;

import be.odisee.lucychang.domain.*;

import java.util.List;

public interface ReclameberichtDao {
    public Reclamebericht bewaarReclamebericht(int id, String titel , String status, String probleemOmschrijving , String oplossing);

    public Reclamebericht bewaarReclamebericht(String titel , String status, String probleemOmschrijving , String oplossing);

    public Reclamebericht getReclameId(int reclameID);

    public List<Reclamebericht> getReclame();

    public void updateReclame(int id, String titel, String status, String probleemOmschrijving, String oplossing);
    
    public void deleteReclame(int id);
}
