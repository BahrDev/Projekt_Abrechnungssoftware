package package_Abrechnungssoftware;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Rechnung {
	
	//Attribute --
	private int rechnungID;
	private int kundeID;
	private String rechnungBetreff;
	private String rechnungAnrede;
	private String rechnungAnschreiben;
	private double rechnungSummeNetto;
	private double rechnungEndbetrag;
	private Date rechnungDatum;
	private String rechnungNummer;
	private String rechnungDateiName;
	private ArrayList<Rechnungsposten> rechnungsposten;
	private boolean wurdeVerändert;

	
	// Konstruktoren
	
	public Rechnung(Integer rechnungID) {
		this.rechnungID = rechnungID;
		ladeRechnungsdaten();
		this.rechnungDatum = new java.sql.Date(System.currentTimeMillis());
	}
	
	public Rechnung() {
		this.rechnungID = -1;
		this.kundeID = GUI.getTk1().getAktuellerKunde().getKundeID();
		this.rechnungBetreff = "";
		this.rechnungAnrede = "";
		this.rechnungAnschreiben = "";
		this.rechnungSummeNetto = 0.00;
		this.rechnungEndbetrag = 0.00;
		this.rechnungDatum = new java.sql.Date(System.currentTimeMillis());
		rechnungsposten = new ArrayList<Rechnungsposten>();
	}
	
	// Methoden
	
	public void ladeRechnungsdaten() {
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		this.kundeID = GUI.getTk1().getAktuellerKunde().getKundeID();
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungBetreff", "rechnung", "rechnungID", rechnungID);
		this.rechnungBetreff = sql.holeStringAusDatenbank(sqlBefehl, "rechnungBetreff");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungAnrede", "rechnung", "rechnungID", rechnungID);
		this.rechnungAnrede = sql.holeStringAusDatenbank(sqlBefehl, "rechnungAnrede");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungAnschreiben", "rechnung", "rechnungID", rechnungID);
		this.rechnungAnschreiben = sql.holeStringAusDatenbank(sqlBefehl, "rechnungAnschreiben");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungSummeNetto", "rechnung", "rechnungID", rechnungID);
		this.rechnungSummeNetto = sql.holeIntAusDatenbank(sqlBefehl, "rechnungSummeNetto");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungEndbetrag", "rechnung", "rechnungID", rechnungID);
		this.rechnungEndbetrag = sql.holeIntAusDatenbank(sqlBefehl, "rechnungEndbetrag");
		// Date wird nicht aus der Datenbank abgerufen (Vermutlich)
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungNummer", "rechnung", "rechnungID", rechnungID);
		this.rechnungNummer = sql.holeStringAusDatenbank(sqlBefehl, "rechnungNummer");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungDateiName", "rechnung", "rechnungID", rechnungID);
		this.rechnungDateiName = sql.holeStringAusDatenbank(sqlBefehl, "rechnungDateiName");
		rechnungsposten = new ArrayList<Rechnungsposten>();
	}
	
	
	public void ladeRechnungsposten() {
		ArrayList<Integer> rechnungspostenIDs = new ArrayList<Integer>();
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspostenID", "rechnungsposten", "rechnungID", rechnungID);
		rechnungspostenIDs = sql.holeIntegerArrayAusDatenbank(sqlBefehl, "rechnungspostenID");
		for (int i = 0; i < rechnungspostenIDs.size(); i++) {
			Rechnungsposten weitererPosten = new Rechnungsposten(rechnungspostenIDs.get(i));
			rechnungsposten.add(weitererPosten);
		}
	}
	

	public void generiereRechnungsnummer(int anzahlRechnungen) {
		String nummer;
		DateFormat df = new SimpleDateFormat("ddMMyy");
		java.util.Date datumUtil = rechnungDatum;
		String datumFormatiert = df.format(datumUtil);
		nummer = "KD" + kundeID + "D" + datumFormatiert + "R" + (anzahlRechnungen+1);
		this.rechnungNummer = nummer;
	}
	
	public void generiereRechnungsDateiName() {
		String dateiName;
		dateiName = rechnungNummer + ".pdf";
		this.rechnungDateiName = dateiName;
	}
	
	// Getter/Setter
	
	

	public int getRechnungID() {
		return rechnungID;
	}

	public void setRechnungID(int rechnungID) {
		this.rechnungID = rechnungID;
	}

	public int getKundeID() {
		return kundeID;
	}

	public void setKundeID(int kundeID) {
		this.kundeID = kundeID;
	}

	public String getRechnungBetreff() {
		return rechnungBetreff;
	}

	public void setRechnungBetreff(String rechnungBetreff) {
		this.rechnungBetreff = rechnungBetreff;
	}

	public String getRechnungAnrede() {
		return rechnungAnrede;
	}

	public void setRechnungAnrede(String rechnungAnrede) {
		this.rechnungAnrede = rechnungAnrede;
	}

	public String getRechnungAnschreiben() {
		return rechnungAnschreiben;
	}

	public void setRechnungAnschreiben(String rechnungAnschreiben) {
		this.rechnungAnschreiben = rechnungAnschreiben;
	}

	public double getRechnungSummeNetto() {
		return rechnungSummeNetto;
	}

	public void setRechnungSummeNetto(double rechnungSummeNetto) {
		this.rechnungSummeNetto = rechnungSummeNetto;
	}

	public double getRechnungEndbetrag() {
		return rechnungEndbetrag;
	}

	public void setRechnungEndbetrag(double rechnungEndbetrag) {
		this.rechnungEndbetrag = rechnungEndbetrag;
	}

	public Date getRechnungDatum() {
		return rechnungDatum;
	}

	public void setRechnungDatum(Date rechnungDatum) {
		this.rechnungDatum = rechnungDatum;
	}

	public String getRechnungNummer() {
		return rechnungNummer;
	}

	public void setRechnungNummer(String rechnungNummer) {
		this.rechnungNummer = rechnungNummer;
	}

	public String getRechnungDateiName() {
		return rechnungDateiName;
	}

	public void setRechnungDateiName(String rechnungDateiName) {
		this.rechnungDateiName = rechnungDateiName;
	}

	public ArrayList<Rechnungsposten> getRechnungsposten() {
		return rechnungsposten;
	}

	public void setRechnungsposten(ArrayList<Rechnungsposten> rechnungsposten) {
		this.rechnungsposten = rechnungsposten;
	}

	public boolean isWurdeVerändert() {
		return wurdeVerändert;
	}

	public void setWurdeVerändert(boolean wurdeVerändert) {
		this.wurdeVerändert = wurdeVerändert;
	}
	
	
}
