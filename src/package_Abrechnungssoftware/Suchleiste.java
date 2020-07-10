package package_Abrechnungssoftware;

import java.util.ArrayList;

public class Suchleiste {
	
	// Attribute
	private static ArrayList<String> rechnungspositionen;

	private static ArrayList<String> kunden;
	
	private static ArrayList<String> tempListSuche;
	
	private static String tempSuchWort;
	
	// Konstruktoren
	
	
	// Methoden
	
	public static void generiereArrayLists() {
		SQLAnbindung sqlAuftrag = new SQLAnbindung();
		String sqlBefehl;
		String kundenTabelle = "kunde";
		String kundenSpalte = "kundeName";
		String rechnungspositionenTabelle = "rechnungsposition";
		String rechnungspositionenSpalte = "rechnungspositionName";
		kunden = new ArrayList<String>();
		rechnungspositionen = new ArrayList<String>();
		sqlBefehl = sqlAuftrag.erstelleBefehl("SELECT", kundenSpalte, kundenTabelle);
		kunden = sqlAuftrag.holeStringArrayAusDatenbank(sqlBefehl, kundenSpalte);
		sqlBefehl = sqlAuftrag.erstelleBefehl("SELECT", rechnungspositionenSpalte, rechnungspositionenTabelle);
		rechnungspositionen = sqlAuftrag.holeStringArrayAusDatenbank(sqlBefehl, rechnungspositionenSpalte);
	
	}
	
	public ArrayList implementiereAutofill() {
		// Methode schreiben!
		return tempListSuche;
	}
	
	public ArrayList sortiereListe(ArrayList<String> unsortiert) {
		// Methode schreiben!
		ArrayList<String> sortiert = unsortiert;
		return sortiert;
	}

	
	
	// Getter/Setter
	
	public static ArrayList<String> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public static void setRechnungspositionen(ArrayList<String> rechnungspositionen) {
		Suchleiste.rechnungspositionen = rechnungspositionen;
	}

	public static ArrayList<String> getKunden() {
		return kunden;
	}

	public static void setKunden(ArrayList<String> kunden) {
		Suchleiste.kunden = kunden;
	}

	public static ArrayList<String> getTempListSuche() {
		return tempListSuche;
	}

	public static void setTempListSuche(ArrayList<String> tempListSuche) {
		Suchleiste.tempListSuche = tempListSuche;
	}

	public static String getTempSuchWort() {
		return tempSuchWort;
	}

	public static void setTempSuchWort(String tempSuchWort) {
		Suchleiste.tempSuchWort = tempSuchWort;
	}
	
	
	
	
	
}
