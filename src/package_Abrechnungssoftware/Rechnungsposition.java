package package_Abrechnungssoftware;

public class Rechnungsposition {
	
	//Attribute
	private int rechnungspositionID;
	private int kategoriepositionID;
	private String kategoriepositionName;
	private String rechnungspositionName;
	private String rechnungspositionSatz;
	private Double rechnungspositionBetrag = 0.00;
	
	
	// Konstruktoren
	
	public Rechnungsposition(boolean neuePosition) {
		if(neuePosition == false) {
			this.rechnungspositionName = GUI.getComboBox_Position_Positionen().getSelectedItem().toString();
			ladePositionsDaten();
		}
	}
	
	public Rechnungsposition() {
		
	}
	
	// Methoden
	
	public void ladePositionsDaten() {
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		sqlBefehl = sql.erstelleBefehl("SELECT", true, "kategoriepositionName", "rechnungsposition", "kategorieposition", "kategoriepositionID", "rechnungspositionName", rechnungspositionName);
		this.kategoriepositionName = sql.holeStringAusDatenbank(sqlBefehl, "kategoriepositionName");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionSatz", "rechnungsposition", "rechnungspositionName", rechnungspositionName);
		this.rechnungspositionSatz = sql.holeStringAusDatenbank(sqlBefehl, "rechnungspositionSatz");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionBetrag", "rechnungsposition", "rechnungspositionName", rechnungspositionName);
		this.rechnungspositionBetrag = sql.holeDoubleAusDatenbank(sqlBefehl, "rechnungspositionBetrag");
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionID", "rechnungsposition", "rechnungspositionName", rechnungspositionName);
		this.rechnungspositionID = sql.holeIntAusDatenbank(sqlBefehl, "rechnungspositionID");
		sqlBefehl = sql.erstelleBefehl("SELECT", "kategoriepositionID", "rechnungsposition", "rechnungspositionName", rechnungspositionName);
		this.kategoriepositionID = sql.holeIntAusDatenbank(sqlBefehl, "kategoriepositionID");
		
		if(rechnungspositionSatz.equals("Honorarbasis")) {
			GUI.getRdbtn_Position_Honorarsatz().setSelected(true);
		}else if(rechnungspositionSatz.equals("Stundensatz")) {
			GUI.getRdbtn_Position_Stundensatz().setSelected(true);
		}else if(rechnungspositionSatz.equals("Tagessatz")) {
			GUI.getRdbtn_Position_Tagessatz().setSelected(true);
		}else {
			System.out.println("Button auswahl gescheitert");
			GUI.getButtongroupPositionSatz().clearSelection();
		}
	}


	// Getter/Setter
	
	public int getRechnungspositionID() {
		return rechnungspositionID;
	}

	public void setRechnungspositionID(int rechnungspositionID) {
		this.rechnungspositionID = rechnungspositionID;
	}

	public int getKategoriepositionID() {
		return kategoriepositionID;
	}

	public void setKategoriepositionID(int kategoriepositionID) {
		this.kategoriepositionID = kategoriepositionID;
	}

	public String getKategoriepositionName() {
		return kategoriepositionName;
	}

	public void setKategoriepositionName(String kategoriepositionName) {
		this.kategoriepositionName = kategoriepositionName;
	}

	public String getRechnungspositionName() {
		return rechnungspositionName;
	}

	public void setRechnungspositionName(String rechnungspositionName) {
		this.rechnungspositionName = rechnungspositionName;
	}

	public String getRechnungspositionSatz() {
		return rechnungspositionSatz;
	}

	public void setRechnungspositionSatz(String rechnungspositionSatz) {
		this.rechnungspositionSatz = rechnungspositionSatz;
	}

	public Double getRechnungspositionBetrag() {
		return rechnungspositionBetrag;
	}

	public void setRechnungspositionBetrag(Double rechnungspositionBetrag) {
		this.rechnungspositionBetrag = rechnungspositionBetrag;
	}
	
	
	
}
