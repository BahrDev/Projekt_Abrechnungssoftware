package package_Abrechnungssoftware;

public class Main {

	public static void main(String[] args) {
		
		// --------- TESTBEREICH ---------
		
//		SQLAnbindung sqltest = new SQLAnbindung();
//		String befehl = sqltest.erstelleBefehl("SELECT", true, "kategoriepositionName", "rechnungsposition", "kategorieposition", "kategoriepositionID", "rechnungspositionName", "Java für Anfänger");
//		System.out.println(befehl);
//		System.out.println(sqltest.holeStringAusDatenbank(befehl, "kategoriepositionName"));
		
		// --------- TESTBEREICH ---------
		
		
		//Suchleiste.generiereArrayLists();
		GUI unsereGui = new GUI();
		unsereGui.hauptfenster();
	}

}
