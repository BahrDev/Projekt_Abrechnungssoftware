package package_Abrechnungssoftware;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TabKunde {

	// Attribute 
	private String kundenName; 
	private int kundeID; 
	private String strasse;
	private String hausnummer;
	private String ort;
	private int plz;
	private String telefonNr;
	private String email;
	private String steuerNr;
	private boolean inaktiv;
	private ArrayList<String> rechnungen = new ArrayList<String>();
	private GUIRechnung neueRechnung;
	
	// gegebenenfalls weitere Strings von Programmtext
	
	
	//Methoden
	public void kundeAnzeigen(){
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeID", "kunde", "kundeName", kundenName);
		kundeID = sql.holeIntAusDatenbank(sqlBefehl, "kundeID");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeStrasse", "kunde", "kundeName", kundenName);
		strasse = sql.holeStringAusDatenbank(sqlBefehl, "kundeStrasse");
		
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeHausnummer", "kunde", "kundeName", kundenName);
		hausnummer = sql.holeStringAusDatenbank(sqlBefehl, "kundeHausnummer");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeOrt", "kunde", "kundeName", kundenName);
		ort = sql.holeStringAusDatenbank(sqlBefehl, "kundeOrt");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundePLZ", "kunde", "kundeName", kundenName);
		plz = sql.holeIntAusDatenbank(sqlBefehl, "kundePLZ");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeTelefon", "kunde", "kundeName", kundenName);
		telefonNr = sql.holeStringAusDatenbank(sqlBefehl, "kundeTelefon");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeEmail", "kunde", "kundeName", kundenName);
		email = sql.holeStringAusDatenbank(sqlBefehl, "kundeEmail");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeSteuerNummer", "kunde", "kundeName", kundenName);
		steuerNr = sql.holeStringAusDatenbank(sqlBefehl, "kundeSteuerNummer");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeInaktiv", "kunde", "kundeName", kundenName);
		inaktiv = sql.holeBoolAusDatenbank(sqlBefehl, "kundeInaktiv");
		
		//Rechnungen müssen hier noch abgerufen werden!!!
	}
	
	public void kundeAnlegen(){
		kundenName = GUI.getTextField_KundeName().getText();
		strasse = GUI.getTextField_KundeStrasse().getText();
		hausnummer = GUI.getTextField_KundeHausnummer().getText();
		ort = GUI.getTextField_KundeOrt().getText();
		plz = Integer.valueOf(GUI.getTextField_KundePLZ().getText());
		telefonNr = GUI.getTextField_KundeTelefon().getText();
		email = GUI.getTextField_KundeEmail().getText();
		steuerNr = GUI.getTextField_KundeSteuerNummer().getText();
		inaktiv = GUI.getChckbx_Kunde_Inaktiv().isSelected();
		
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("INSERT", "kunde", "kundeName", kundenName, "kundeStrasse", strasse, "kundeHausnummer", hausnummer, "kundePLZ", plz, "kundeOrt", ort, "kundeTelefon", telefonNr, "kundeEmail", email, "kundeSteuerNummer", steuerNr, "kundeInaktiv", inaktiv);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeID", "kunde", "kundeName", kundenName);
		kundeID = sql.holeIntAusDatenbank(sqlBefehl, "kundeID");
		GUI.getTextField_KundeID().setText(Integer.toString(kundeID));
	}
	
	public void speichern(){
		kundeID = Integer.valueOf(GUI.getTextField_KundeID().getText());
		kundenName = GUI.getTextField_KundeName().getText();
		strasse = GUI.getTextField_KundeStrasse().getText();
		hausnummer = GUI.getTextField_KundeHausnummer().getText();
		ort = GUI.getTextField_KundeOrt().getText();
		plz = Integer.valueOf(GUI.getTextField_KundePLZ().getText());
		telefonNr = GUI.getTextField_KundeTelefon().getText();
		email = GUI.getTextField_KundeEmail().getText();
		steuerNr = GUI.getTextField_KundeSteuerNummer().getText();
		inaktiv = GUI.getChckbx_Kunde_Inaktiv().isSelected();
		
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeName", kundenName, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeStrasse", strasse, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeHausnummer", hausnummer, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeOrt", ort, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundePLZ", plz, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeTelefon", telefonNr, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeEmail", email, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeSteuerNummer", steuerNr, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeInaktiv", inaktiv, "kundeID", kundeID);
		sql.datenbankÄnderung(sqlBefehl);
	}
	
	public void rechnungAnzeigen() 
	{
		
	}
	
	public void rechnungKorrigieren()
	{
		
	}
	
	public void rechnungStellen(){
		neueRechnung = new GUIRechnung();
		neueRechnung.fensterRechnung();
	}
	
	public ArrayList<String> ladeRechnungen()
	{
	// Methode schreiben 
		return rechnungen;	
	}
	
	public void comboBox_kunde_kunden_aktualisieren() {
		Suchleiste.generiereArrayLists();
		GUI.getComboBox_Kunde_Kunden().removeAllItems();
		for (int i = 0; i < Suchleiste.getKunden().size(); i++) {
			GUI.getComboBox_Kunde_Kunden().addItem(Suchleiste.getKunden().get(i));
		}
		GUI.getComboBox_Kunde_Kunden().setSelectedItem(kundenName);
		GUI.getComboBox_Kunde_Kunden().revalidate();
		GUI.getComboBox_Kunde_Kunden().repaint();
	}
	
	public void eingabefelderLeeren(){
		GUI.getTextField_KundeStrasse().setText("");
		GUI.getTextField_KundeID().setText("");
		GUI.getTextField_KundeName().setText("");
		GUI.getTextField_KundeOrt().setText("");
		GUI.getTextField_KundeTelefon().setText("");
		GUI.getTextField_KundeEmail().setText("");
		GUI.getTextField_KundeSteuerNummer().setText("");
		GUI.getTextField_KundeHausnummer().setText("");
		GUI.getTextField_KundePLZ().setText("");
		GUI.getChckbx_Kunde_Inaktiv().setSelected(false);
		
	}
	//Abfrage boolean 
	public boolean checkAufUngesicherteDaten()
	{
	//Methode schreiben
		return false;
	}
	
	public void frageZurAbsicherung()
	{
	//Methode schreiben
	JOptionPane sind_sie_sicher = new JOptionPane();	
	}

	
	
	// Getter/Setter
	
	public String getKundenName() {
		return kundenName;
	}

	public void setKundenName(String kundenName) {
		this.kundenName = kundenName;
	}

	public int getKundeID() {
		return kundeID;
	}

	public void setKundeID(int kundeID) {
		this.kundeID = kundeID;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSteuerNr() {
		return steuerNr;
	}

	public void setSteuerNr(String steuerNr) {
		this.steuerNr = steuerNr;
	}

	public ArrayList<String> getRechnungen() {
		return rechnungen;
	}

	public void setRechnungen(ArrayList<String> rechnungen) {
		this.rechnungen = rechnungen;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public boolean isInaktiv() {
		return inaktiv;
	}

	public void setInaktiv(boolean inaktiv) {
		this.inaktiv = inaktiv;
	}

	public GUIRechnung getNeueRechnung() {
		return neueRechnung;
	}

	public void setNeueRechnung(GUIRechnung neueRechnung) {
		this.neueRechnung = neueRechnung;
	}
	
	
	
	
}
