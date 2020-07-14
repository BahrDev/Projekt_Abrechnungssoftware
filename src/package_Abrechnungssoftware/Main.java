package package_Abrechnungssoftware;

public class Main {

	public static void main(String[] args) {

		// Laden der Configs aus der Config.ini
		TabProgrammOptionen.ladeConfigs();
		// generierung der primären GUI (alles weitere geht von hier aus)
		GUI unsereGui = new GUI();
		unsereGui.hauptfenster();
		// fülle die Felder im Reiter Programmoptionen aus (usability)
		TabProgrammOptionen.fülleConfigFelder();

	}

}
