package package_Abrechnungssoftware;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TabKunde {

	// Attribute 
	private Kunde aktuellerKunde;
	private GUIRechnung neueGUIRechnung;
	private boolean neuerKunde;
	
	
	//Methoden
	public void kundeAnzeigen(boolean neuerKunde){
		this.neuerKunde = neuerKunde;
		aktuellerKunde = new Kunde(neuerKunde);
		// die beiden vermutlich nur wenn neuerKunde True ist
		aktuellerKunde.ladeRechnungen();
		ladeRechnungen();
	}
	
	public void kundeAnlegen(){
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("INSERT", "kunde", "kundeName", aktuellerKunde.getKundeName(), "kundeStrasse", aktuellerKunde.getKundeStrasse(), "kundeHausnummer", aktuellerKunde.getKundeHausnummer(), "kundePLZ", aktuellerKunde.getKundePLZ(), "kundeOrt", aktuellerKunde.getKundeOrt(), "kundeTelefon", aktuellerKunde.getKundeTelefon(), "kundeEmail", aktuellerKunde.getKundeEmail(), "kundeSteuerNummer", aktuellerKunde.getKundeSteuerNummer(), "kundeInaktiv", aktuellerKunde.isInaktiv());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeID", "kunde", "kundeName", aktuellerKunde.getKundeName());
		int kundeID = sql.holeIntAusDatenbank(sqlBefehl, "kundeID");
		GUI.getLbl_KundeID_ID().setText(Integer.toString(kundeID));
	}
	
	public void speichern(){
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeName", aktuellerKunde.getKundeName(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeStrasse", aktuellerKunde.getKundeStrasse(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeHausnummer", aktuellerKunde.getKundeHausnummer(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeOrt", aktuellerKunde.getKundeOrt(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundePLZ", aktuellerKunde.getKundePLZ(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeTelefon", aktuellerKunde.getKundeTelefon(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeEmail", aktuellerKunde.getKundeEmail(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeSteuerNummer", aktuellerKunde.getKundeSteuerNummer(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "kunde", "kundeInaktiv", aktuellerKunde.isInaktiv(), "kundeID", aktuellerKunde.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
	}
	
	public void rechnungAnzeigen() 					// leer
	{
		
	}
	
	public void rechnungKorrigieren(){
		String ausgewählteRechnung = (String) GUI.getList_Kunde_Rechnungen().getSelectedValue();
		int rechnungID = -1;
		for (int i = 0; i < aktuellerKunde.getRechnungen().size(); i++) {
			if (aktuellerKunde.getRechnungen().get(i).getRechnungNummer().equals(ausgewählteRechnung)) {
				rechnungID = aktuellerKunde.getRechnungen().get(i).getRechnungID();
			}
		}
		if(rechnungID != -1) {
			neueGUIRechnung = new GUIRechnung(false, rechnungID);
			neueGUIRechnung.fensterRechnung();
			neueGUIRechnung.getTr1().zeigeBestehendeRechnungsdaten();
		}
		
	}
	
	public void rechnungStellen(){
		neueGUIRechnung = new GUIRechnung(true, null);
		neueGUIRechnung.fensterRechnung();
	}
	
	public void ladeRechnungen(){
		GUI.getListModel().clear();
		//Sortieren hier ggf
		for (int i = 0; i < aktuellerKunde.getRechnungen().size(); i++) {
			// Füge 20 Leerzeichen zur Formatierung hinzu???
			GUI.getListModel().addElement(aktuellerKunde.getRechnungen().get(i).getRechnungNummer());
		}
		
		GUI.getList_Kunde_Rechnungen().revalidate();
		GUI.getList_Kunde_Rechnungen().repaint();
	}
	
	public void comboBox_kunde_kunden_aktualisieren() {
		Suchleiste.generiereArrayLists();
		GUI.getComboBox_Kunde_Kunden().removeAllItems();
		for (int i = 0; i < Suchleiste.getKunden().size(); i++) {
			GUI.getComboBox_Kunde_Kunden().addItem(Suchleiste.getKunden().get(i));
		}
		if (aktuellerKunde != null) {
			GUI.getComboBox_Kunde_Kunden().setSelectedItem(aktuellerKunde.getKundeName());
		}else {
			GUI.getComboBox_Kunde_Kunden().setSelectedItem(-1);
		}
		GUI.getComboBox_Kunde_Kunden().revalidate();
		GUI.getComboBox_Kunde_Kunden().repaint();
	}
	
	public void eingabefelderLeeren(){
		GUI.getTextField_KundeStrasse().setText("");
		GUI.getLbl_KundeID_ID().setText("");
		GUI.getTextField_KundeName().setText("");
		GUI.getTextField_KundeOrt().setText("");
		GUI.getTextField_KundeTelefon().setText("");
		GUI.getTextField_KundeEmail().setText("");
		GUI.getTextField_KundeSteuerNummer().setText("");
		GUI.getTextField_KundeHausnummer().setText("");
		GUI.getTextField_KundePLZ().setText("0");
		GUI.getChckbx_Kunde_Inaktiv().setSelected(false);
		
	}
	
	public void maskeSichtbar(boolean sichtbar) {
		GUI.getPanel_KundenDaten().setVisible(sichtbar);
		GUI.getPanel_Kunde_Speichern().setVisible(sichtbar);
		GUI.getPanel_Kunde_Rechnungen().setVisible(sichtbar);
		GUI.getPanel_Kunde_Rechnungen_Buttons().setVisible(sichtbar);
	}
	
	//Abfrage boolean TODO
	public boolean checkAufUngesicherteDaten() {
		boolean ausgabe;
		if(aktuellerKunde.isWurdeVerändert()) {
			int bestätigung = JOptionPane.showConfirmDialog(null, "Achtung, Sie haben Daten verändert. Wollen Sie dies wirklich tun?", "Achtung", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (bestätigung == 0) {
				ausgabe = true;
			}else {
				ausgabe = false;
			}
		}else {
			ausgabe = true;
		}
		return ausgabe;
	}
	
	public void plzWarnung() {
		JOptionPane.showMessageDialog(null, "Fehler: Bitte geben Sie eine gültige deutsche Postleitzahl ein!", "Ungültige Postleitzahl", JOptionPane.WARNING_MESSAGE);
	}

	
	
	// Getter/Setter
	

	public Kunde getAktuellerKunde() {
		return aktuellerKunde;
	}

	public void setAktuellerKunde(Kunde aktuellerKunde) {
		this.aktuellerKunde = aktuellerKunde;
	}

	public GUIRechnung getNeueGUIRechnung() {
		return neueGUIRechnung;
	}

	public void setNeueGUIRechnung(GUIRechnung neueGUIRechnung) {
		this.neueGUIRechnung = neueGUIRechnung;
	}

	public boolean isNeuerKunde() {
		return neuerKunde;
	}

	public void setNeuerKunde(boolean neuerKunde) {
		this.neuerKunde = neuerKunde;
	}
	
	
	
	
	
}
