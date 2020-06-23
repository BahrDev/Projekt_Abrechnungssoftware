package package_Abrechnungssoftware;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TabKunde {

	// Attribute 
	private String kundenName; 
	private String kundeID; 
	private String strasseID;
	private String ort;
	private int plz;
	private String telefonNr;
	private String email;
	private String steuerNr;
	private ArrayList<String> rechnungen = new ArrayList<String>();
	
	// gegebenenfalls weitere Strings von Programmtext
	
	
	//Methoden
	public void kundeAnzeigen() 
	{
		
	}
	
	public void kundeAnlegen() 
	{
		
	}
	
	public void speichern() 
	{
		
	}
	
	public void rechnungAnzeigen() 
	{
		
	}
	
	public void rechnungKorrigieren()
	{
		
	}
	
	public void rechnungStellen()
	{
		
	}
	
	public ArrayList<String> ladeRechnungen()
	{
	// Methode schreiben 
		return rechnungen;	
	}
	
	public void eingabefelderLeeren()
	{
		
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
	
}
