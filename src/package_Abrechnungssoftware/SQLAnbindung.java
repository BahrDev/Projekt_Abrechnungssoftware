package package_Abrechnungssoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLAnbindung {
	
	//Attribute
	Connection verbindung = null;	
	Statement befehl = null;
	ResultSet ausgabe = null;
	
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
	
	
	
	public String erstelleBefehl(String select, String tabelle, String spalte) {
		return erstelleBefehl(select, tabelle, spalte, null, null, null);
	}
	
	public String erstelleBefehl(String selectWhere, String tabelle, String spalte, String suchSpalte, String zeile) {
		return erstelleBefehl(selectWhere, tabelle, spalte, null, null, null);
	}
	
	public String erstelleBefehl(String anweisung, String tabelle, String spalte, String suchSpalte, String zeile, String platzhalter) {
		String befehl = "";
		if (anweisung == "SELECT") {
			befehl+= "SELECT";
			
			if (spalte != "ALL") {
				befehl+= " " + spalte;
			}else {
				befehl+= " *";
			}
			
			befehl+= " FROM " + tabelle;
				
			if(zeile != null) {
				befehl+= " WHERE " + suchSpalte + " = " + zeile;
			}
		}
		

		
		return befehl;
	}
	
	// Getter/Setter
}
