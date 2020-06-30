package package_Abrechnungssoftware;

public class Main {

	public static void main(String[] args) {
		
		// --------- TESTBEREICH ---------
		
//		SQLAnbindung sqltest = new SQLAnbindung();
//		String befehl = sqltest.erstelleBefehl("SELECT", "kunde", "kundeName");
//		System.out.println(befehl);
//		System.out.println(sqltest.holeArrayAusDatenbank(befehl, "kundeName").get(0));
		
		// --------- TESTBEREICH ---------
		
		
		//Suchleiste.generiereArrayLists();
		GUI unsereGui = new GUI();
		unsereGui.hauptfenster();
	}

}
