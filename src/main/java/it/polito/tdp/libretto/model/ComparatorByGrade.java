package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatorByGrade implements Comparator<Voto> {

	public int compare (Voto o1, Voto o2) {
		return o2.getPunti()-o1.getPunti();
	}
	
}
