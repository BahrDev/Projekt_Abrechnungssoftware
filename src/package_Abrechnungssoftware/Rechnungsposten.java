package package_Abrechnungssoftware;

public class Rechnungsposten {

	//Attribute
	private int rechnungspostenID;
	private int rechnungID;
	private int rechnungspositionID;
	private int rechnungspostenNummer;
	private String rechnungspositionName;
	private String rechnungspostenSatz;
	private double rechnungspostenEinheiten;
	private double rechnungspostenSatzEuro;
	private double rechnungspostenGesamtEuro;
	
	// Konstruktoren
	
	public Rechnungsposten(Integer rechnungspostenID) {
		this.rechnungspostenID = rechnungspostenID;
		ladePostenDaten();
	}
	
	public Rechnungsposten() {

	}
	
	// Methoden
	
	public void ladePostenDaten() {
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungID", "rechnungsposten", "rechnungspostenID", rechnungspostenID);
		this.rechnungID = sql.holeIntAusDatenbank(sqlBefehl, "rechnungID");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionID", "rechnungsposten", "rechnungspostenID", rechnungspostenID);
		this.rechnungspositionID = sql.holeIntAusDatenbank(sqlBefehl, "rechnungspositionID");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspostenNummer", "rechnungsposten", "rechnungspostenID", rechnungspostenID);
		this.rechnungspostenNummer = sql.holeIntAusDatenbank(sqlBefehl, "rechnungspostenNummer");
		sqlBefehl = sql.erstelleBefehl("SELECT", true, "rechnungspositionName", "rechnungsposten", "rechnungsposition", "rechnungspositionID", "rechnungspostenID", rechnungspostenID);
		this.rechnungspositionName = sql.holeStringAusDatenbank(sqlBefehl, "rechnungspositionName");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspostenSatz", "rechnungsposten", "rechnungspostenID", rechnungspostenID);
		this.rechnungspostenSatz = sql.holeStringAusDatenbank(sqlBefehl, "rechnungspostenSatz");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspostenEinheiten", "rechnungsposten", "rechnungspostenID", rechnungspostenID);
		this.rechnungspostenEinheiten = sql.holeIntAusDatenbank(sqlBefehl, "rechnungspostenEinheiten");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspostenSatzEuro", "rechnungsposten", "rechnungspostenID", rechnungspostenID);
		this.rechnungspostenSatzEuro = sql.holeDoubleAusDatenbank(sqlBefehl, "rechnungspostenSatzEuro");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspostenGesamtEuro", "rechnungsposten", "rechnungspostenID", rechnungspostenID);
		this.rechnungspostenGesamtEuro = sql.holeDoubleAusDatenbank(sqlBefehl, "rechnungspostenGesamtEuro");
	}

	
	// Getter/Setter
	
	public int getRechnungspostenID() {
		return rechnungspostenID;
	}

	public void setRechnungspostenID(int rechnungspostenID) {
		this.rechnungspostenID = rechnungspostenID;
	}

	public int getRechnungID() {
		return rechnungID;
	}

	public void setRechnungID(int rechnungID) {
		this.rechnungID = rechnungID;
	}

	public int getRechnungspositionID() {
		return rechnungspositionID;
	}

	public void setRechnungspositionID(int rechnungspositionID) {
		this.rechnungspositionID = rechnungspositionID;
	}

	public int getRechnungspostenNummer() {
		return rechnungspostenNummer;
	}

	public void setRechnungspostenNummer(int rechnungspostenNummer) {
		this.rechnungspostenNummer = rechnungspostenNummer;
	}

	public String getRechnungspositionName() {
		return rechnungspositionName;
	}

	public void setRechnungspositionName(String rechnungspositionName) {
		this.rechnungspositionName = rechnungspositionName;
	}

	public String getRechnungspostenSatz() {
		return rechnungspostenSatz;
	}

	public void setRechnungspostenSatz(String rechnungspostenSatz) {
		this.rechnungspostenSatz = rechnungspostenSatz;
	}

	public double getRechnungspostenEinheiten() {
		return rechnungspostenEinheiten;
	}

	public void setRechnungspostenEinheiten(double rechnungspostenEinheiten) {
		this.rechnungspostenEinheiten = rechnungspostenEinheiten;
	}

	public double getRechnungspostenSatzEuro() {
		return rechnungspostenSatzEuro;
	}

	public void setRechnungspostenSatzEuro(double rechnungspostenSatzEuro) {
		this.rechnungspostenSatzEuro = rechnungspostenSatzEuro;
	}

	public double getRechnungspostenGesamtEuro() {
		return rechnungspostenGesamtEuro;
	}

	public void setRechnungspostenGesamtEuro(double rechnungspostenGesamtEuro) {
		this.rechnungspostenGesamtEuro = rechnungspostenGesamtEuro;
	}

	
	
	
}
