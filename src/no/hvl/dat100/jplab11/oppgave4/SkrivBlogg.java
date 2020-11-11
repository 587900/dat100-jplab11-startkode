package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		try {
			String data = samling.toString();
			PrintWriter skriver = new PrintWriter(mappe + filnavn);
			skriver.print(data);
			skriver.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}

	}
}
