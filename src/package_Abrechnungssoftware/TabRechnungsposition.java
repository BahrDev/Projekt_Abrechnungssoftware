package package_Abrechnungssoftware;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TabRechnungsposition {
	
	// Attribute
	private ArrayList<String> kategorie;
	private Rechnungsposition aktuelleRechnungsposition;
	private boolean neueRechnungsposition;
	
	// ggf Veraltet
	private String positionsname;
	private int positionsID;
	
	private String kategorieAuswahl;
	private int kategorieID;
	private double satzEuro;
	private String satzArt;
	
	// Konstruktoren
	
	// Methoden
	
	public void positionAnzeigen(boolean neuePosition) {
		this.neueRechnungsposition = neuePosition;
		aktuelleRechnungsposition = new Rechnungsposition(neuePosition);

	}
	
	public void kategorieAnlegen() {
		String neueKategorie;
		neueKategorie = JOptionPane.showInputDialog(null, "Geben sie den Namen der neuen Kategorie ein", "Neue Kategorie:", JOptionPane.PLAIN_MESSAGE);
		if(neueKategorie != null) {
			SQLAnbindung sqlAuftrag = new SQLAnbindung();
			String sqlBefehl;
			sqlBefehl = sqlAuftrag.erstelleBefehl("INSERT", "kategorieposition", "kategoriepositionName", neueKategorie);
			sqlAuftrag.datenbankÄnderung(sqlBefehl);
			comboBox_Position_Kategorie_aktualisieren();
		}
	}
	
	public void speichern() {
		if(neueRechnungsposition) {
			rechnungspositionAnlegen();
		}else {
			rechnungspositionSpeichern();
		}
	}

	public void rechnungspositionSpeichern() {
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("UPDATE", "rechnungsposition", "rechnungspositionName", aktuelleRechnungsposition.getRechnungspositionName(), "rechnungspositionID", aktuelleRechnungsposition.getRechnungspositionID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "rechnungsposition", "rechnungspositionSatz", aktuelleRechnungsposition.getRechnungspositionSatz(), "rechnungspositionID", aktuelleRechnungsposition.getRechnungspositionID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "rechnungsposition", "rechnungspositionBetrag", aktuelleRechnungsposition.getRechnungspositionBetrag(), "rechnungspositionID", aktuelleRechnungsposition.getRechnungspositionID());
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "rechnungsposition", "kategoriepositionID", aktuelleRechnungsposition.getKategoriepositionID(), "rechnungspositionID", aktuelleRechnungsposition.getRechnungspositionID());
		sql.datenbankÄnderung(sqlBefehl);
	}
	
	public void rechnungspositionAnlegen() {
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("INSERT", "rechnungsposition", "kategoriepositionID", aktuelleRechnungsposition.getKategoriepositionID(), "rechnungspositionName", aktuelleRechnungsposition.getRechnungspositionName(), "rechnungspositionSatz", aktuelleRechnungsposition.getRechnungspositionSatz(), "rechnungspositionBetrag", aktuelleRechnungsposition.getRechnungspositionBetrag());
		sql.datenbankÄnderung(sqlBefehl);
	}
	
	public void generiereKategorieArray() {
		SQLAnbindung sqlAuftrag = new SQLAnbindung();
		String sqlBefehl;
		kategorie = new ArrayList<String>();
		sqlBefehl = sqlAuftrag.erstelleBefehl("SELECT", "kategoriepositionName", "kategorieposition");
		kategorie = sqlAuftrag.holeStringArrayAusDatenbank(sqlBefehl, "kategoriepositionName");
	}
	
	public void comboBox_Position_Positionen_aktualisieren() {
		Suchleiste.generiereArrayLists();
		GUI.getComboBox_Position_Positionen().removeAllItems();
		for (int i = 0; i < Suchleiste.getRechnungspositionen().size(); i++) {
			GUI.getComboBox_Position_Positionen().addItem(Suchleiste.getRechnungspositionen().get(i));
		}	
		if (aktuelleRechnungsposition != null) {
			GUI.getComboBox_Position_Positionen().setSelectedItem(aktuelleRechnungsposition.getRechnungspositionName());
		}else {
			GUI.getComboBox_Position_Positionen().setSelectedItem(-1);
		}
		GUI.getComboBox_Position_Positionen().revalidate();
		GUI.getComboBox_Position_Positionen().repaint();
	}
	
	public void comboBox_Position_Kategorie_aktualisieren() {
		generiereKategorieArray();
		GUI.getComboBox_Position_Kategorie().removeAllItems();
		for (int i = 0; i < kategorie.size(); i++) {
			GUI.getComboBox_Position_Kategorie().addItem(kategorie.get(i));
		}
		GUI.getComboBox_Position_Kategorie().setSelectedItem(kategorieAuswahl);
		GUI.getComboBox_Position_Kategorie().revalidate();
		GUI.getComboBox_Position_Kategorie().repaint();
	}
	
	public void eingabefelderLeeren() {
		GUI.getTextField_Positionsname().setText("");
		GUI.getTextField_Position_Kategorie_Satz_in_Euro().setText("");
		GUI.getButtongroupPositionSatz().clearSelection();
		GUI.getComboBox_Position_Kategorie().setSelectedIndex(-1);
	}
	
	public boolean checkAufUngesicherteDaten() {
	//Methode schreiben
		boolean ausgabe;
		if(aktuelleRechnungsposition.isWurdeVerändert()) {
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
	
	public void frageZurAbsicherung() {
		//JOptionPane hier
	}

	
	// Getter/Setter
	
	public String getPositionsname() {
		return positionsname;
	}

	public void setPositionsname(String positionsname) {
		this.positionsname = positionsname;
	}

	public ArrayList<String> getKategorie() {
		return kategorie;
	}

	public void setKategorie(ArrayList<String> kategorie) {
		this.kategorie = kategorie;
	}

	public String getKategorieAuswahl() {
		return kategorieAuswahl;
	}

	public void setKategorieAuswahl(String kategorieAuswahl) {
		this.kategorieAuswahl = kategorieAuswahl;
	}

	public double getSatzEuro() {
		return satzEuro;
	}

	public void setSatzEuro(double satzEuro) {
		this.satzEuro = satzEuro;
	}

	public String getSatzArt() {
		return satzArt;
	}

	public void setSatzArt(String satzArt) {
		this.satzArt = satzArt;
	}

	public Rechnungsposition getAktuelleRechnungsposition() {
		return aktuelleRechnungsposition;
	}

	public void setAktuelleRechnungsposition(Rechnungsposition aktuelleRechnungsposition) {
		this.aktuelleRechnungsposition = aktuelleRechnungsposition;
	}

	public boolean isNeueRechnungsposition() {
		return neueRechnungsposition;
	}

	public void setNeueRechnungsposition(boolean neueRechnungsposition) {
		this.neueRechnungsposition = neueRechnungsposition;
	}

	public int getPositionsID() {
		return positionsID;
	}

	public void setPositionsID(int positionsID) {
		this.positionsID = positionsID;
	}

	public int getKategorieID() {
		return kategorieID;
	}

	public void setKategorieID(int kategorieID) {
		this.kategorieID = kategorieID;
	}
	

	
	
}
