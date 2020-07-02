package package_Abrechnungssoftware;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SQLAnbindung {
	
	//Attribute
	Connection verbindung = null;	
	Statement befehl = null;
	ResultSet ausgabe = null;
	HashMap<String, Object> insertMap;
	
	//Konstruktoren
	
	// Methoden
	
	public Connection datenbankAnwahl(){	
		try 
		{			
			Class.forName("com.mysql.cj.jdbc.Driver");		
			verbindung = DriverManager.getConnection("jdbc:mysql://localhost:3306/abrechnungssoftwareherzogbahr?useSSL=false&serverTimezone=UTC", "root", "");			
			return verbindung;
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}		
		return null;
	}
	
	public Object zeigeDatensatz(){
		ArrayList<String> kunden = new ArrayList<String>();
		
		try 
		{
			//Zugriff auf Verbindungsmethode
			verbindung = datenbankAnwahl();
			befehl = verbindung.createStatement();
			
			String sql ="SELECT * FROM kunde";
			
			
			ausgabe = befehl.executeQuery(sql);
			
			while(ausgabe.next())
			{
				//System.out.println("\n" + ausgabe.getInt("TeilnehmerID") + " " + ausgabe.getString("Nachname") + " " + ausgabe.getString("Vorname") + " " + ausgabe.getString("Standort") + " " + ausgabe.getString("Fachrichtung"));
				//System.out.println("\n" + ausgabe.getInt(1) + " " + ausgabe.getString(2) + " " + ausgabe.getString(3) + " " + ausgabe.getString(4)+ " " + ausgabe.getString(5));
				kunden.add(ausgabe.getString("kundeName"));
			}
			verbindung.close();
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return kunden;
	}
	
	public void datenbankAuftrag(String sqlBefehl) {
		try {
			verbindung = datenbankAnwahl();
			befehl = verbindung.createStatement();
			ausgabe = befehl.executeQuery(sqlBefehl);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> holeArrayAusDatenbank(String sqlBefehl, String spaltenName) {
		ArrayList<String> retArray = new ArrayList<String>();
		datenbankAuftrag(sqlBefehl);
		
		try {
			while(ausgabe.next()){
				retArray.add(ausgabe.getString(spaltenName));
			}
			verbindung.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retArray;
	}
	
	public String holeStringAusDatenbank(String sqlBefehl, String spaltenName) {
		String retString = "";
		datenbankAuftrag(sqlBefehl);
		
		try {
			while(ausgabe.next()){
				retString = ausgabe.getString(spaltenName);
			}
			verbindung.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retString;
	}
	
	public int holeIntAusDatenbank(String sqlBefehl, String spaltenName) {
		int retInt = 0;
		datenbankAuftrag(sqlBefehl);
		
		try {
			while(ausgabe.next()){
				retInt = ausgabe.getInt(spaltenName);
			}
			verbindung.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retInt;
	}
	
	public double holeDoubleAusDatenbank(String sqlBefehl, String spaltenName) {
		double retDouble = 0;
		datenbankAuftrag(sqlBefehl);
		
		try {
			while(ausgabe.next()){
				retDouble = ausgabe.getInt(spaltenName);
			}
			verbindung.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retDouble;
	}

	
	public void ändereDaten(String befehl) {

	}
	
	public String holeDaten(String befehl) {
		// Methode schreiben!
		return befehl;
	}
	
	
	public String erstelleBefehl(String selectALL, String auswahl, String tabelle1) {
		return erstelleBefehl(selectALL, auswahl, tabelle1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String selectWhere, String auswahl, String tabelle1, String suchSpalte1, String suchWert1) {
		return erstelleBefehl(selectWhere, auswahl, tabelle1, null, suchSpalte1, null, null, null, null, null, null, null, null, null, null, null, suchWert1, null, null, null, null, null, null, 0, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String selectStringString, String auswahl, String tabelle1, String suchSpalte1, String suchWert1, String suchSpalte2, String suchWert2) {
		return erstelleBefehl(selectStringString, auswahl, tabelle1, null, suchSpalte1, suchSpalte2, null, null, null, null, null, null, null, null, null, null, suchWert1, suchWert2, null, null, null, null, null, 0, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String selectStringInt, String auswahl, String tabelle1, String suchSpalte1, String suchWert1, String suchSpalte2, int suchWert2) {
		return erstelleBefehl(selectStringInt, auswahl, tabelle1, null, suchSpalte1, suchSpalte2, null, null, null, null, null, null, null, null, null, null, suchWert1, null, null, null, null, null, null, 0, suchWert2, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String selectIntInt, String auswahl, String tabelle1, String suchSpalte1, int suchWert1, String suchSpalte2, int suchWert2) {
		return erstelleBefehl(selectIntInt, auswahl, tabelle1, null, suchSpalte1, suchSpalte2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, suchWert1, suchWert2, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String selectIntString, String auswahl, String tabelle1, String suchSpalte1, int suchWert1, String suchSpalte2, String suchWert2) {
		return erstelleBefehl(selectIntString, auswahl, tabelle1, null, suchSpalte1, suchSpalte2, null, null, null, null, null, null, null, null, null, null, suchWert2, null, null, null, null, null, null, suchWert1, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String selectInnerJoinString, boolean innerJoin, String auswahl, String tabelle1, String tabelle2, String keySpalte, String suchSpalte2, String suchWert2) {
		return erstelleBefehl(selectInnerJoinString, auswahl, tabelle1, tabelle2, null, suchSpalte2, keySpalte, null, null, null, null, null, null, null, null, null, null, suchWert2, null, null, null, null, null, 0, 0, 0, 0, true, false, null);
	}
	
	public String erstelleBefehl(String selectInnerJoinInt, boolean innerJoin, String auswahl, String tabelle1, String tabelle2, String keySpalte, String suchSpalte2, int suchWert2) {
		return erstelleBefehl(selectInnerJoinInt, auswahl, tabelle1, tabelle2, null, suchSpalte2, keySpalte, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, suchWert2, 0, 0, true, false, null);
	}
	
	public String erstelleBefehl(String updateString, boolean stringUpdate, String tabelle1, String auswahlSpalte, String neuerWert, String suchSpalte2, String suchWert2) {
		return erstelleBefehl(updateString, null, tabelle1, null, null, null, null, auswahlSpalte, suchSpalte2, null, null, null, null, null, null, null, neuerWert, suchWert2, null, null, null, null, null, 0, 0, 0, 0, stringUpdate, false, null);
	}
	
	public String erstelleBefehl(String updateInt, String tabelle1, String auswahlSpalte, int neuerWert, String suchSpalte2, String suchWert2) {
		return erstelleBefehl(updateInt, null, tabelle1, null, null, null, null, auswahlSpalte, suchSpalte2, null, null, null, null, null, null, null, null, suchWert2, null, null, null, null, null, neuerWert, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String updateBool, String tabelle1, String auswahlSpalte, boolean neuerWert, String suchSpalte2, String suchWert2) {
		return erstelleBefehl(updateBool, null, tabelle1, null, null, null, null, auswahlSpalte, suchSpalte2, null, null, null, null, null, null, null, null, suchWert2, null, null, null, null, null, 0, 0, 0, 0, false, neuerWert, null);
	}
	
	public String erstelleBefehl(String insertKategorie, String tabelle1, String spalte1, String wert1String) {
		insertMap = new HashMap<String, Object>();
		insertMap.put(spalte1, wert1String);
		return erstelleBefehl(insertKategorie, null, tabelle1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String insertRechnungsposition, String tabelle1, String spalte1, int wert1Int, String spalte2, String wert2String, String spalte3, String wert3String, String spalte4, double wert4Double) {
		insertMap = new HashMap<String, Object>();
		insertMap.put(spalte1, wert1Int);
		insertMap.put(spalte2, wert2String);
		insertMap.put(spalte3, wert3String);
		insertMap.put(spalte4, wert4Double);
		return erstelleBefehl(insertRechnungsposition, null, tabelle1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String insertRechnungsposten, String tabelle1, String spalte1, int wert1Int, String spalte2, int wert2Int, String spalte3, int wert3Int, String spalte4, int wert4Int, String spalte5, String wert5String, String spalte6, double wert6Double, String spalte7, double wert7Double) {
		insertMap = new HashMap<String, Object>();
		insertMap.put(spalte1, wert1Int);
		insertMap.put(spalte2, wert2Int);
		insertMap.put(spalte3, wert3Int);
		insertMap.put(spalte4, wert4Int);
		insertMap.put(spalte5, wert5String);
		insertMap.put(spalte6, wert6Double);
		insertMap.put(spalte7, wert7Double);
		return erstelleBefehl(insertRechnungsposten, null, tabelle1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String insertRechnung, String tabelle1, String spalte1, String wert1String, String spalte2, String wert2String, String spalte3, String wert3String, String spalte4, double wert4Double, String spalte5, double wert5Double, String spalte6, Date wert6datum, String spalte7, String wert7String, String spalte8, String wert8String, String spalte9, int wert9Int) {
		insertMap = new HashMap<String, Object>();
		insertMap.put(spalte1, wert1String);
		insertMap.put(spalte2, wert2String);
		insertMap.put(spalte3, wert3String);
		insertMap.put(spalte4, wert4Double);
		insertMap.put(spalte5, wert5Double);
		insertMap.put(spalte6, wert6datum);
		insertMap.put(spalte7, wert7String);
		insertMap.put(spalte8, wert8String);
		insertMap.put(spalte9, wert9Int);
		return erstelleBefehl(insertRechnung, null, tabelle1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, false, null);
	}
	
	public String erstelleBefehl(String insertKunde, String tabelle1, String spalte1, String wert1String, String spalte2, String wert2String, String spalte3, String wert3String, String spalte4, int wert4Int, String spalte5, String wert5String, String spalte6, String wert6String, String spalte7, String wert7String, String spalte8, String wert8String, String spalte9, boolean wert9String) {
		return null;
	}
	
	
	public String erstelleBefehl(String befehl, String auswahl,	String tabelle1, String tabelle2, String suchSpalte1, String suchSpalte2, String keySpalte,	
								String spalte1,	String spalte2,	String spalte3, String spalte4,	String spalte5,	String spalte6,	String spalte7,	String spalte8,	String spalte9,
								String wert1String, String wert2String,	String wert3String,	String wert4String,	String wert5String,	String wert6String,	String wert7String,
								int wert1Int, int wert2Int,	int wert3Int, int wert4Int,	boolean befehlMarker, boolean wert1Bool, Date datum) {
		String sqlBefehl = "";
		
		if (befehl == "SELECT") {
			sqlBefehl+= "SELECT";
		
			if (auswahl != "ALL") {
				sqlBefehl+= " " + auswahl;
			}else {
				sqlBefehl+= " *";
			}
			
			sqlBefehl+= " FROM " + tabelle1;
			
			if(befehlMarker == false) {
				if(suchSpalte1 != null) {
					sqlBefehl+= " WHERE " + suchSpalte1 + " = ";
					if(wert1String != null) {
						sqlBefehl+= "'" + wert1String +"'";
					}else if(wert1Int != 0) {
						sqlBefehl+= wert1Int;
					}
				}
			}else {
				sqlBefehl+= " INNER JOIN " + tabelle2 + " ON " + tabelle1 + "." + keySpalte + " = " + tabelle2 + "." + keySpalte;
			}
			
			if (suchSpalte2 != null) {
				sqlBefehl+= " AND " + suchSpalte2 + " = ";
				if(wert2String != null) {
					sqlBefehl+= "'" + wert2String +"'";
				}else if(wert2Int != 0) {
					sqlBefehl+= wert2Int;
				}
			}
		}else if(befehl == "UPDATE") {
			sqlBefehl+= "UPDATE " + tabelle1 + " SET " + spalte1 + " = ";
			
			if(wert1String != null) {
				sqlBefehl+= "'" + wert1String +"'";
			}else if (wert1Int != 0) {
				sqlBefehl+= wert1Int;
			}
			
			sqlBefehl+= " WHERE " + spalte2 + " = ";
			
			if(wert2String != null) {
				sqlBefehl+= "'" + wert2String +"'";
			}else if (wert2Int != 0) {
				sqlBefehl+= wert2Int;
			}
		}else if(befehl == "INSERT") {
			String tabellen = "(";
			String werte = "(";
			int counter = 0;
			sqlBefehl+= "INSERT INTO " + tabelle1 + " ";
			
			for (HashMap.Entry<String, Object> eintrag : insertMap.entrySet()) {
				counter++;
				tabellen+= eintrag.getKey();
				
				if(eintrag.getValue() instanceof String) {
					werte+= "'" + (String)eintrag.getValue() + "'";
				}else if(eintrag.getValue() instanceof Integer) {
					werte+= (int)eintrag.getValue();
				}else if(eintrag.getValue() instanceof Double) {
					werte+= (double)eintrag.getValue();
				}else if (eintrag.getValue() instanceof Date) {
					werte+= "";												// DATE recherchieren und hier einfügen
				}else if (eintrag.getValue() instanceof Boolean) {
					werte += (boolean)eintrag.getValue();
				}else {
					System.out.println("Fehler bei der HashMap-Verarbeitung in der SQL-Befehlszusammenstellung");
				}
				
				if (counter <= insertMap.size()) {
					tabellen+= ", ";
					werte+= ", ";
				}
			}
			
			tabellen+= ")";
			werte+= ")";
			sqlBefehl+= tabellen + " VALUES " + werte;		
		}else {
			System.out.println("Fehler bei der Befehlsgenerierung");
		}
		
		return sqlBefehl;
	}
	
	
//	public String erstelleBefehl(String select, String tabelle, String spalte) {
//		return erstelleBefehl(select, tabelle, spalte, null, null, null);
//	}
//	
//	public String erstelleBefehl(String selectWhere, String tabelle, String spalte, String suchSpalte, String zeile) {
//		return erstelleBefehl(selectWhere, tabelle, spalte, null, null, null);
//	}
	
//	public String erstelleBefehl(String anweisung, String tabelle, String spalte, String suchSpalte, String zeile, String platzhalter) {
//		String befehl = "";
//		if (anweisung == "SELECT") {
//			befehl+= "SELECT";
//			
//			if (spalte != "ALL") {
//				befehl+= " " + spalte;
//			}else {
//				befehl+= " *";
//			}
//			
//			befehl+= " FROM " + tabelle;
//				
//			if(zeile != null) {
//				befehl+= " WHERE " + suchSpalte + " = " + zeile;
//			}
//		}
//		
//
//		
//		return befehl;
//	}
	
	// Getter/Setter
}
