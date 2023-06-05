package it.polito.tdp.libretto.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Libretto {

	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	public boolean add(Voto v) {
		if (this.esisteVotoConflitto(v) || this.esisteVotoDuplicato(v)) {
			// non aggiungere voto
			throw new IllegalArgumentException("Voto errato: " + v);
		}
		return this.voti.add(v);
	}
	
	public String toString() {
		String txt = "";
		for(Voto v : this.voti) {
			txt = txt + v.toString() + "\n";
		}
		return txt;
	}
	
	public void stampaPuntiUguali(int risultato) {
		for (Voto v : this.voti) {
			if (v.getPunti() == risultato)
				System.out.println(v);
		}
	}
	
	public Voto cercaVotoPerNome(String corso) {
		for (Voto v : this.voti) {
			if (v.getCorso().equals(corso))
				return v;
		}
		return null;
	}
	
	public boolean esisteVotoDuplicato(Voto nuovo) {
		for (Voto v : this.voti) {
			if (v.isDuplicato(nuovo))
				return true;
		}
		return false;
	}
	
	public boolean esisteVotoConflitto(Voto nuovo) {
		for (Voto v : this.voti) {
			if (v.isConflitto(nuovo)) 
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo "factory" per creare un nuovo libretto con i 
	 * voti migliorati
	 * 
	 * @return libretto migliorato
	 */
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		// migliore.voti = this.voti; SBAGLIATO!!!
		migliore.voti = new ArrayList<>();
		for (Voto v : this.voti) {
			migliore.voti.add(v.clone());
		//  migliore.voti.add(new Voto(v));
		}
		for (Voto v : migliore.voti) {
			v.setPunti(v.getPunti() + 2);
			}
		return migliore;
	}
	
	public void cancellaVotiInferiori(int punti) {
//		for (Voto v : this.voti) {
//			if(v.getPunti() < punti) {
//				this.voti.remove(v);
//			}
//		} // SBAGLIATO: non si eliminano MAI elementi da una lista mentre 
		  // itero dentro un ciclo che la scandisce 
		
//		for (int i=0; i<this.voti.size(); i++) {
//			if (this.voti.get(i).getPunti() < punti) {
//				this.voti.remove(i);
//			}
//		}
		List<Voto> daCancellare = new ArrayList<Voto>();
		for (Voto v : this.voti) {
			if (v.getPunti() < punti) {
				daCancellare.add(v);
			}	
		}
		for (Voto v1 : daCancellare) {
			this.voti.remove(v1);
		}
//oppure this.voti.removeAll(daCancellare); -> Alternativa migliore!
	}
	
	public Libretto librettoOrdinatoAlfabeticamente() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);
//		ordinato.voti.sort(new ComparatorByName());
		Collections.sort(ordinato.voti, new ComparatorByName());
		return ordinato;
	}
	
	public Libretto librettoOrdinatoVoto() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);
		Collections.sort(ordinato.voti, new ComparatorByGrade());
		return ordinato;
	}
	
	
	
	
	
	
	
}
