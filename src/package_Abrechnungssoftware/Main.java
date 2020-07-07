package package_Abrechnungssoftware;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		// --------- TESTBEREICH ---------
		
//		SQLAnbindung sqltest = new SQLAnbindung();
//		String befehl = sqltest.erstelleBefehl("SELECT", true, "kategoriepositionName", "rechnungsposition", "kategorieposition", "kategoriepositionID", "rechnungspositionName", "Java für Anfänger");
//		System.out.println(befehl);
//		System.out.println(sqltest.holeStringAusDatenbank(befehl, "kategoriepositionName"));
		
		// --------- TESTBEREICH ---------
		
		
//		//Suchleiste.generiereArrayLists();
//		GUI unsereGui = new GUI();
//		unsereGui.hauptfenster();
		DateiGenerierung dateiGenerierung = new DateiGenerierung();
		try {
			dateiGenerierung.generierePDFAusVorlage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
