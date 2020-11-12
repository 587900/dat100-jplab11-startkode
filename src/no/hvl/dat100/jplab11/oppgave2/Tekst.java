package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.oppgave1.*;

public class Tekst extends Innlegg {

private String tekst;
	
	public Tekst(int id, String bruker, String dato, String tekst) { this(id, bruker, dato, 0, tekst); }
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.tekst = tekst;
	}
	
	public String getTekst() { return tekst; }
	public void setTekst(String tekst) { this.tekst = tekst; }

	@Override
	public String toString() {
		return "TEKST\n" + super.toString() + tekst + "\n";
	}
	
	//hjelpemetode oppg 3m)
	public boolean search(String bruker, String ord) {
		return bruker.equals(getBruker()) && search(ord);
	}
	public boolean search(String keyword) {
		return tekst.contains(keyword);
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		return String.format("%s\n<p>%s</p>", super.toHTML(), tekst);	
	}
}
