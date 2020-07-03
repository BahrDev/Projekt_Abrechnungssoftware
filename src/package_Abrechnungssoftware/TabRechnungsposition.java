package package_Abrechnungssoftware;

import java.util.ArrayList;

public class TabRechnungsposition {
	
	// Attribute
	private String positionsname;
	private int positionsID;
	private ArrayList<String> kategorie;
	private String kategorieAuswahl;
	private int kategorieID;
	private double satzEuro;
	private String satzArt;
	
	// Konstruktoren
	
	// Methoden
	
	public void positionAnzeigen() {
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		sqlBefehl = sql.erstelleBefehl("SELECT", true, "kategoriepositionName", "rechnungsposition", "kategorieposition", "kategoriepositionID", "rechnungspositionName", positionsname);
		kategorieAuswahl = sql.holeStringAusDatenbank(sqlBefehl, "kategoriepositionName");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionSatz", "rechnungsposition", "rechnungspositionName", positionsname);
		satzArt = sql.holeStringAusDatenbank(sqlBefehl, "rechnungspositionSatz");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionBetrag", "rechnungsposition", "rechnungspositionName", positionsname);
		satzEuro = sql.holeDoubleAusDatenbank(sqlBefehl, "rechnungspositionBetrag");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionID", "rechnungsposition", "rechnungspositionName", positionsname);
		positionsID = sql.holeIntAusDatenbank(sqlBefehl, "rechnungspositionID");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kategoriepositionID", "rechnungsposition", "rechnungspositionName", positionsname);
		kategorieID = sql.holeIntAusDatenbank(sqlBefehl, "kategoriepositionID");
		
		GUI.getTextField_Positionsname().setText(positionsname);
		GUI.getTextField_Position_Kategorie_Satz_in_Euro().setText(Double.toString(satzEuro));
		GUI.getComboBox_Position_Kategorie().setSelectedItem(kategorieAuswahl);
	
		if(satzArt.equals("Honorarsatz")) {
			GUI.getRdbtn_Position_Honorarsatz().setSelected(true);
		}else if(satzArt.equals("Stundensatz")) {
			GUI.getRdbtn_Position_Stundensatz().setSelected(true);
		}else if(satzArt.equals("Tagessatz")) {
			GUI.getRdbtn_Position_Tagessatz().setSelected(true);
		}else {
			System.out.println("Button auswahl gescheitert");
		}
	}

	public void positionAnlegen() {
		positionsname = GUI.getTextField_Positionsname().getText();
		kategorieAuswahl = GUI.getComboBox_Position_Kategorie().getSelectedItem().toString();
		satzEuro = Double.valueOf(GUI.getTextField_Position_Kategorie_Satz_in_Euro().getText());
		if(GUI.getRdbtn_Position_Honorarsatz().isSelected()) {
			satzArt = "Honorarsatz";
		}else if(GUI.getRdbtn_Position_Stundensatz().isSelected()) {
			satzArt = "Stundensatz";
		}else if(GUI.getRdbtn_Position_Tagessatz().isSelected()) {
			satzArt = "Tagessatz";
		}
		
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("SELECT", "kategoriepositionID", "kategorieposition", "kategoriepositionName", kategorieAuswahl);
		kategorieID = sql.holeIntAusDatenbank(sqlBefehl, "kategoriepositionID");
		sqlBefehl = sql.erstelleBefehl("INSERT", "rechnungsposition", "kategoriepositionID", kategorieID, "rechnungspositionName", positionsname, "rechnungspositionSatz", satzArt, "rechnungspositionBetrag", satzEuro);
		sql.datenbankÄnderung(sqlBefehl);
	}
	
	public void kategorieAnlegen() {
		
	}
	
	public void speichern() {
		positionsname = GUI.getTextField_Positionsname().getText();
		kategorieAuswahl = GUI.getComboBox_Position_Kategorie().getSelectedItem().toString();
		satzEuro = Double.valueOf(GUI.getTextField_Position_Kategorie_Satz_in_Euro().getText());
		if(GUI.getRdbtn_Position_Honorarsatz().isSelected()) {
			satzArt = "Honorarsatz";
		}else if(GUI.getRdbtn_Position_Stundensatz().isSelected()) {
			satzArt = "Stundensatz";
		}else if(GUI.getRdbtn_Position_Tagessatz().isSelected()) {
			satzArt = "Tagessatz";
		}
		
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("UPDATE", "rechnungsposition", "rechnungspositionName", positionsname, "rechnungspositionID", positionsID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "rechnungsposition", "rechnungspositionSatz", satzArt, "rechnungspositionID", positionsID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "rechnungsposition", "rechnungspositionBetrag", satzEuro, "rechnungspositionID", positionsID);
		sql.datenbankÄnderung(sqlBefehl);
		sqlBefehl = sql.erstelleBefehl("UPDATE", "rechnungsposition", "kategoriepositionID", kategorieID, "rechnungspositionID", positionsID);
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
		GUI.getComboBox_Position_Positionen().setSelectedItem(positionsname);
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
		// Methode schreiben!
		return false;
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
	
	// Getter/Setter
	
	
}
