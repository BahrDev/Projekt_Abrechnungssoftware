package package_Abrechnungssoftware;

import java.util.ArrayList;

public class Berechnung {

	
	public void berechneRechnungspositionsSumme() {
		
		//Methode schreiben
		ArrayList<Rechnungsposten> rechnungsposten = GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungsposten();
		double summe;
		double satz_Euro;
		int einheiten;
		
		for (int i = 0; i < rechnungsposten.size() ; i++) {
			
			satz_Euro = rechnungsposten.get(i).getRechnungspostenSatzEuro();
			einheiten = rechnungsposten.get(i).getRechnungspostenEinheiten();
			summe = satz_Euro * einheiten;
			rechnungsposten.get(i).setRechnungspostenGesamtEuro(summe);
			
		}
		
	}
	public void berechneGesamtSumme() {
		//Methode schreiben
		
		ArrayList<Rechnungsposten> rechnungsposten = GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungsposten();
		
		double gesamt_Euro = 0.0;
		
		for (int i = 0; i < rechnungsposten.size(); i++) {
			
			gesamt_Euro += rechnungsposten.get(i).getRechnungspostenGesamtEuro();
			GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().setRechnungSummeNetto(gesamt_Euro);
			GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().setRechnungEndbetrag(gesamt_Euro);
		
			
		}
		
		
	}
}
