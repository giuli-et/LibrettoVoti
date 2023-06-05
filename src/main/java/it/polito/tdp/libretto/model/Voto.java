package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto {

	private String corso;
	private int punti;
	private LocalDate dataEsame;
	
	// Costruttore
	public Voto(String corso, int punti, LocalDate dataEsame) {
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}
	
	// Copy Constructor di voto
	public Voto(Voto v) {
		this.corso = v.corso;
		this.punti = v.punti;
		this.dataEsame = v.dataEsame;
	}

	// Getter e Setter
	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	@Override
	public String toString() {
		return corso + ": " + punti + " il " + dataEsame + "\n";
	}
	
	public boolean isDuplicato(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) && this.getPunti() == altro.getPunti();
	}
	
	public boolean isConflitto(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) && this.getPunti() != altro.getPunti();
	}
	
	public Voto clone() {
		return new Voto(this.corso, this.punti, this.dataEsame);
	}

	
	
	
	
	
	
}
