package be.odisee.lucychang.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="reclameberichten")
public class Reclamebericht implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private java.lang.String titel;
	@Column
	private java.lang.String status;
	@Column
	private java.lang.String prombleemOmschrijving;
	@Column
	private java.lang.String oplossing;
	
	public Reclamebericht(int id, String titel, String status, String probleemOmschrijving, String oplossing) {
		this.setId(id);
		this.titel = titel;
		this.status = status;
		this.setPrombleemOmschrijving(probleemOmschrijving);
		this.setOplossing(oplossing);
	}
	
	public Reclamebericht(String titel, String status, String probleemOmschrijving, String oplossing) {
		this.setTitel(titel);
		this.setStatus(status);
		this.setPrombleemOmschrijving(probleemOmschrijving);
		this.setOplossing(oplossing);
	}
	
	public Reclamebericht() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.lang.String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public java.lang.String getPrombleemOmschrijving() {
		return prombleemOmschrijving;
	}
	public void setPrombleemOmschrijving(java.lang.String prombleemOmschrijving) {
		this.prombleemOmschrijving = prombleemOmschrijving;
	}
	public java.lang.String getOplossing() {
		return oplossing;
	}
	public void setOplossing(java.lang.String oplossing) {
		this.oplossing = oplossing;
	}
}
