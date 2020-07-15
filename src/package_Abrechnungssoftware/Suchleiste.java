package package_Abrechnungssoftware;

import java.util.ArrayList;
import java.util.Collections;

public class Suchleiste {

	// Attribute
	private static ArrayList<String> rechnungspositionen;

	private static ArrayList<String> kundenNamen;
	
	private static ArrayList<Kunde> kunden;
	
	private static ArrayList<String> kundenComboBoxListe;
	
	private static String ausgewählterKundenName;

//	private static ArrayList<String> tempListSuche;
//
//	private static String tempSuchWort;

	// Methoden

	public static void generiereArrayLists() {
		SQLAnbindung sqlAuftrag = new SQLAnbindung();
		String sqlBefehl = "";
		String kundenTabelle = "kunde";
		String kundenSpalte = "kundeName";
		String rechnungspositionenTabelle = "rechnungsposition";
		String rechnungspositionenSpalte = "rechnungspositionName";
		kundenNamen = new ArrayList<String>();
		rechnungspositionen = new ArrayList<String>();
		kunden = new ArrayList<Kunde>();
		kundenComboBoxListe = new ArrayList<String>();
		ArrayList<String> kundenIDs = new ArrayList<String>();
		ArrayList<String> rechungsnummern = new ArrayList<String>();
		
		if (TabProgrammOptionen.isInaktiveKundenAusblenden()) {
			sqlBefehl = sqlAuftrag.erstelleBefehl("SELECT", kundenSpalte, kundenTabelle, "kundeInaktiv", 0);
		} else {
			sqlBefehl = sqlAuftrag.erstelleBefehl("SELECT", kundenSpalte, kundenTabelle);
		}

		kundenNamen = sqlAuftrag.holeStringArrayAusDatenbank(sqlBefehl, kundenSpalte);
		sqlBefehl = sqlAuftrag.erstelleBefehl("SELECT", rechnungspositionenSpalte, rechnungspositionenTabelle);
		rechnungspositionen = sqlAuftrag.holeStringArrayAusDatenbank(sqlBefehl, rechnungspositionenSpalte);
		
		
		for (int i = 0; i < kundenNamen.size(); i++) {
			ausgewählterKundenName = kundenNamen.get(i);
			kunden.add(new Kunde(false));
			kundenIDs.add(String.valueOf(kunden.get(i).getKundeID() + " - KundenID"));
			kunden.get(i).ladeRechnungen();
			for (int j = 0; j < kunden.get(i).getRechnungen().size(); j++) {
				rechungsnummern.add(kunden.get(i).getRechnungen().get(j).getRechnungNummer() + " - Rechnungsnummer");
			}
		}
		
		Collections.sort(kundenNamen);
		Collections.sort(rechnungspositionen);
		Collections.sort(kundenIDs);
		Collections.sort(rechungsnummern);
		
		kundenComboBoxListe.addAll(kundenNamen);
		kundenComboBoxListe.addAll(kundenIDs);
		kundenComboBoxListe.addAll(rechungsnummern);
	}
	
	public static void kundenSelector(String comboBoxAuswahl) {
		String suchWert;
		if(comboBoxAuswahl.contains("KundenID") || comboBoxAuswahl.contains("Rechnungsnummer")) {
			int endIndex = comboBoxAuswahl.indexOf(" ");
			suchWert = comboBoxAuswahl.substring(0, endIndex);
			for (int i = 0; i < kunden.size(); i++) {
				if(suchWert.equals(String.valueOf(kunden.get(i).getKundeID()))) {
					ausgewählterKundenName = kunden.get(i).getKundeName();
				}else {
					for (int j = 0; j < kunden.get(i).getRechnungen().size(); j++) {
						if(kunden.get(i).getRechnungen().get(j).getRechnungNummer().equals(suchWert)) {
							ausgewählterKundenName = kunden.get(i).getKundeName();
						}
					}
				}
			}
		}else {
			ausgewählterKundenName = comboBoxAuswahl;
		}
		
	}

//	public ArrayList implementiereAutofill() {
//		// Methode schreiben!
//		return tempListSuche;
//	}

//	public ArrayList sortiereListe(ArrayList<String> unsortiert) {
//		// Methode schreiben!
//		ArrayList<String> sortiert = unsortiert;
//		return sortiert;
//	}

	
	// Getter/Setter
	
	public static ArrayList<String> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public static void setRechnungspositionen(ArrayList<String> rechnungspositionen) {
		Suchleiste.rechnungspositionen = rechnungspositionen;
	}

	public static ArrayList<String> getKundenNamen() {
		return kundenNamen;
	}

	public static void setKundenNamen(ArrayList<String> kundenNamen) {
		Suchleiste.kundenNamen = kundenNamen;
	}

	public static ArrayList<Kunde> getKunden() {
		return kunden;
	}

	public static void setKunden(ArrayList<Kunde> kunden) {
		Suchleiste.kunden = kunden;
	}

	public static String getAusgewählterKundenName() {
		return ausgewählterKundenName;
	}

	public static void setAusgewählterKundenName(String ausgewählterKundenName) {
		Suchleiste.ausgewählterKundenName = ausgewählterKundenName;
	}

	public static ArrayList<String> getKundenComboBoxListe() {
		return kundenComboBoxListe;
	}

	public static void setKundenComboBoxListe(ArrayList<String> kundenComboBoxListe) {
		Suchleiste.kundenComboBoxListe = kundenComboBoxListe;
	}



	
	
//	public static ArrayList<String> getRechnungspositionen() {
//		return rechnungspositionen;
//	}
//
//	public static void setRechnungspositionen(ArrayList<String> rechnungspositionen) {
//		Suchleiste.rechnungspositionen = rechnungspositionen;
//	}
//
//	public static ArrayList<String> getKunden() {
//		return kundenNamen;
//	}
//
//	public static void setKunden(ArrayList<String> kunden) {
//		Suchleiste.kundenNamen = kunden;
//	}
//
//	public static ArrayList<String> getKundenNamen() {
//		return kundenNamen;
//	}
//
//	public static void setKundenNamen(ArrayList<String> kundenNamen) {
//		Suchleiste.kundenNamen = kundenNamen;
//	}
//
//	public static String getAusgewählterKundenName() {
//		return ausgewählterKundenName;
//	}
//
//	public static void setAusgewählterKundenName(String ausgewählterKundenName) {
//		Suchleiste.ausgewählterKundenName = ausgewählterKundenName;
//	}
//
//	public static void setKunden(ArrayList<Kunde> kunden) {
//		Suchleiste.kunden = kunden;
//	}

//	public static ArrayList<String> getTempListSuche() {
//		return tempListSuche;
//	}
//
//	public static void setTempListSuche(ArrayList<String> tempListSuche) {
//		Suchleiste.tempListSuche = tempListSuche;
//	}
//
//	public static String getTempSuchWort() {
//		return tempSuchWort;
//	}
//
//	public static void setTempSuchWort(String tempSuchWort) {
//		Suchleiste.tempSuchWort = tempSuchWort;
//	}

	
	
}
