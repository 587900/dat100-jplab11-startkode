package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	Innlegg[] innleggtabell;
	int nesteledig;

	public Blogg() { this(20); }	//start på 20, i følge oppgåve

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() { return nesteledig; }
	
	public Innlegg[] getSamling() { return innleggtabell; }
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; ++i) {
			if (innlegg.erLik(innleggtabell[i])) return i;
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) >= 0;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg) || !ledigPlass()) return false;
		innleggtabell[nesteledig++] = innlegg;
		return true;
	}
	
	public String toString() {
		String s = getAntall() + "\n";
		for (int i = 0; i < nesteledig; ++i) s += innleggtabell[i].toString();
		return s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] neww = new Innlegg[Math.max(innleggtabell.length * 2, 1)];
		for (int i = 0; i < nesteledig; ++i) neww[i] = innleggtabell[i];
		innleggtabell = neww;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (finnes(innlegg)) return false;
		if (!ledigPlass()) utvid();
		innleggtabell[nesteledig++] = innlegg;
		return true;
	}
	
	public boolean slett(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if (pos < 0) return false;
		innleggtabell[pos] = innleggtabell[--nesteledig];
		innleggtabell[nesteledig] = null;
		return true;
	}
	
	//dette var koda vi fekk, likna ikkje på oppgåva
	public int[] search(String keyword) {
		int[] ret = new int[innleggtabell.length];
		int index = 0;
		
		for (int i = 0; i < nesteledig; ++i) {
			Innlegg x = innleggtabell[i];
			if (!(x instanceof Tekst)) continue;
			if (((Tekst)x).search(keyword)) ret[index++] = x.getId();
		}
		
		int[] aRet = new int[index];
		System.arraycopy(ret, 0, aRet, 0, index);

		return aRet;
	}
	
	//denne koda fekk vi ikkje, men står i oppgåva
	public int[] search(String user, String keyword) {
		int[] ret = new int[innleggtabell.length];
		int index = 0;
		
		for (int i = 0; i < nesteledig; ++i) {
			Innlegg x = innleggtabell[i];
			if (!(x instanceof Tekst)) continue;
			if (((Tekst)x).search(user, keyword)) ret[index++] = x.getId();		//einaste forskjell her
		}
		
		int[] aRet = new int[index];
		System.arraycopy(ret, 0, aRet, 0, index);

		return aRet;
	}
}