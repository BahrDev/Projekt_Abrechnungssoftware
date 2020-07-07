package package_Abrechnungssoftware;

import java.util.ArrayList;

public class Kunde {
	
	// Attribute -
	private int kundeID;
	private String kundeName;
	private String kundeStrasse;
	private String kundeHausnummer;
	private int kundePLZ;
	private String kundeOrt;
	private String kundeTelefon;
	private String kundeEmail;
	private String kundeSteuerNummer;
	private boolean inaktiv;
	private ArrayList<Rechnung> rechnungen;
	private boolean wurdeVerändert = false;
	
	// Konstruktoren
	

	public Kunde(boolean neuerKunde) {	
		if (neuerKunde == false) {
			this.ladeKundenDaten();
		}
	}
	
	public Kunde() {
		
	}
	
	
	
	// Methoden
	
	public void ladeKundenDaten() {
		this.kundeName = GUI.getComboBox_Kunde_Kunden().getSelectedItem().toString();
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeID", "kunde", "kundeName", kundeName);
		this.kundeID = sql.holeIntAusDatenbank(sqlBefehl, "kundeID");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeStrasse", "kunde", "kundeName", kundeName);
		this.kundeStrasse = sql.holeStringAusDatenbank(sqlBefehl, "kundeStrasse");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeHausnummer", "kunde", "kundeName", kundeName);
		this.kundeHausnummer = sql.holeStringAusDatenbank(sqlBefehl, "kundeHausnummer");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeOrt", "kunde", "kundeName", kundeName);
		this.kundeOrt = sql.holeStringAusDatenbank(sqlBefehl, "kundeOrt");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundePLZ", "kunde", "kundeName", kundeName);
		this.kundePLZ = sql.holeIntAusDatenbank(sqlBefehl, "kundePLZ");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeTelefon", "kunde", "kundeName", kundeName);
		this.kundeTelefon = sql.holeStringAusDatenbank(sqlBefehl, "kundeTelefon");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeEmail", "kunde", "kundeName", kundeName);
		this.kundeEmail = sql.holeStringAusDatenbank(sqlBefehl, "kundeEmail");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeSteuerNummer", "kunde", "kundeName", kundeName);
		this.kundeSteuerNummer = sql.holeStringAusDatenbank(sqlBefehl, "kundeSteuerNummer");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeInaktiv", "kunde", "kundeName", kundeName);
		this.inaktiv = sql.holeBoolAusDatenbank(sqlBefehl, "kundeInaktiv");
	}

	public void ladeRechnungen() {
		rechnungen = new ArrayList<Rechnung>();
		ArrayList<Integer> rechnungsIDs = new ArrayList<Integer>();
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungID", "rechnung", "kundeID", kundeID);
		rechnungsIDs = sql.holeIntegerArrayAusDatenbank(sqlBefehl, "rechnungID");
		for (int i = 0; i < rechnungsIDs.size(); i++) {
			Rechnung weitereRechnung = new Rechnung(rechnungsIDs.get(i));
			rechnungen.add(weitereRechnung);
		}
	}

	
	// Getter/Setter

	public int getKundeID() {
		return kundeID;
	}



	public void setKundeID(int kundeID) {
		this.kundeID = kundeID;
	}



	public String getKundeName() {
		return kundeName;
	}



	public void setKundeName(String kundeName) {
		this.kundeName = kundeName;
	}



	public String getKundeStrasse() {
		return kundeStrasse;
	}



	public void setKundeStrasse(String kundeStrasse) {
		this.kundeStrasse = kundeStrasse;
	}



	public String getKundeHausnummer() {
		return kundeHausnummer;
	}



	public void setKundeHausnummer(String kundeHausnummer) {
		this.kundeHausnummer = kundeHausnummer;
	}



	public int getKundePLZ() {
		return kundePLZ;
	}



	public void setKundePLZ(int kundePLZ) {
		this.kundePLZ = kundePLZ;
	}



	public String getKundeOrt() {
		return kundeOrt;
	}



	public void setKundeOrt(String kundeOrt) {
		this.kundeOrt = kundeOrt;
	}



	public String getKundeTelefon() {
		return kundeTelefon;
	}



	public void setKundeTelefon(String kundeTelefon) {
		this.kundeTelefon = kundeTelefon;
	}



	public String getKundeEmail() {
		return kundeEmail;
	}



	public void setKundeEmail(String kundeEmail) {
		this.kundeEmail = kundeEmail;
	}



	public String getKundeSteuerNummer() {
		return kundeSteuerNummer;
	}



	public void setKundeSteuerNummer(String kundeSteuerNummer) {
		this.kundeSteuerNummer = kundeSteuerNummer;
	}



	public boolean isInaktiv() {
		return inaktiv;
	}



	public void setInaktiv(boolean inaktiv) {
		this.inaktiv = inaktiv;
	}



	public ArrayList<Rechnung> getRechnungen() {
		return rechnungen;
	}



	public void setRechnungen(ArrayList<Rechnung> rechnungen) {
		this.rechnungen = rechnungen;
	}



	public boolean isWurdeVerändert() {
		return wurdeVerändert;
	}



	public void setWurdeVerändert(boolean wurdeVerändert) {
		this.wurdeVerändert = wurdeVerändert;
	}


	
	
}
