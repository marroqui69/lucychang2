package be.odisee.lucychang.service;

import be.odisee.lucychang.domain.*;

import java.util.List;

public interface LucyChangService {
    public Reclamebericht voegReclameberichtToe(String titel , String status, String probleemOmschrijving , String oplossing);
    
    public void deleteReclamebericht(int id);
    
    public void updateReclamebericht(int id, String titel, String status, String probleemOmschrijving, String oplossing);
    
    public Reclamebericht zoekReclameberichtId(int id);

    public List<Reclamebericht> geefReclameberichten();
}