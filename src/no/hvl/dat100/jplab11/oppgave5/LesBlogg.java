package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

public class LesBlogg {

	private static final String TEKST = "TEKST";
	private static final String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		
		Blogg blogg = null;

		try(BufferedReader br = new BufferedReader(new FileReader(mappe + filnavn))) {
			
			int n = Integer.parseInt(br.readLine());
			blogg = new Blogg(n);
			
			for (int i = 0; i < n; ++i) {
				
				String type = br.readLine();
				
				switch(type) {
					case TEKST:	//id navn dato likes tekst
						blogg.leggTil(new Tekst(ri(br), rl(br), rl(br), ri(br), rl(br)));
						break;
					case BILDE:	//id navn dato likes tekst url
						blogg.leggTil(new Bilde(ri(br), rl(br), rl(br), ri(br), rl(br), rl(br)));
						break;
					default:
						throw new IllegalArgumentException("Bad file format");
				}
			}
			
		} catch (IOException e) {		//filenotfoundexception
			e.printStackTrace();
		}
		
		if (blogg == null) blogg = new Blogg(0);
		return blogg;

	}
	
	private static int ri(BufferedReader br) throws IOException{ return Integer.parseInt(br.readLine()); }	//read int
	private static String rl(BufferedReader br) throws IOException { return br.readLine(); }				//read line
}
