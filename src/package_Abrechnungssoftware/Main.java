package package_Abrechnungssoftware;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		// --------- TESTBEREICH ---------
		
//		SQLAnbindung sqltest = new SQLAnbindung();
//		String befehl = sqltest.erstelleBefehl("SELECT", true, "kategoriepositionName", "rechnungsposition", "kategorieposition", "kategoriepositionID", "rechnungspositionName", "Java f�r Anf�nger");
//		System.out.println(befehl);
//		System.out.println(sqltest.holeStringAusDatenbank(befehl, "kategoriepositionName"));
		
//		DateiGenerierung dateiGenerierung = new DateiGenerierung();
//		try {
//			dateiGenerierung.generierePDFAusVorlage();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// --------- TESTBEREICH ---------
		
		
//		//Suchleiste.generiereArrayLists();
		TabOptionen.ladeConfigs();
		GUI unsereGui = new GUI();
		unsereGui.hauptfenster();
		TabOptionen.f�lleConfigFelder();

	}

}
