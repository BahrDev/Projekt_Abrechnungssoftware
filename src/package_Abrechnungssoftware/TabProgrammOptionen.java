package package_Abrechnungssoftware;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TabProgrammOptionen {
	
	// Attribute
	
	private static String speicherpfad;
	private static String dbAdresse;
	private static String dbBenutzername;
	private static String dbPasswort;
	private static boolean inaktiveKundenAusblenden;
	private static boolean datenbankAnbindung;
	
	// Konstruktoren
	
	// Methoden
	
	public static void ladeConfigs() {
		try {
			BufferedReader einlesenVonDaten = new BufferedReader(new FileReader("config.ini"));
			String eintrag;
			int zeile = 0;
			while((eintrag = einlesenVonDaten.readLine()) != null) {
				zeile++;
				
				switch (String.valueOf(zeile)) {
				case "1":
					speicherpfad = eintrag;
					break;
				case "2":
					dbAdresse = eintrag;
					break;
				case "3":
					dbBenutzername = eintrag;
					break;
				case "4":
					dbPasswort = eintrag;
					break;
				case "5":
					if (eintrag.equals("true")) {
						inaktiveKundenAusblenden = true;
					}else {
						inaktiveKundenAusblenden = false;
					}
					break;
					
				default:
					break;
				}
			}
			einlesenVonDaten.close();
			datenbankCheck();
		} catch (Exception abbruch) {
			// TODO: handle exception
			abbruch.printStackTrace();
		}
	}
	
	public static void setzeSpeicherpfad() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Start-Verzeichnis ausw�hlen");
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter standardFilter = new FileNameExtensionFilter("Nur Verzeichnisse", "*.*");
        chooser.addChoosableFileFilter(standardFilter);
        int answer = chooser.showOpenDialog(null);
        if (answer == JFileChooser.APPROVE_OPTION) {
            GUI.getTextField_Optionen_Speicherpfad().setText(chooser.getSelectedFile().getAbsolutePath());
        }
	}
	
	public static void speichereConfigs() {
		speicherpfad = GUI.getTextField_Optionen_Speicherpfad().getText();
		dbAdresse = GUI.getTextField_Optionen_dbAdresse().getText();
		dbBenutzername = GUI.getTextField_Optionen_dbBenutzername().getText();
		dbPasswort = String.valueOf(GUI.getPasswordField_Optionen_dbPasswort().getPassword());
		inaktiveKundenAusblenden = GUI.getChckbx_Optionen_KundenAusblenden().isSelected();
		
		DateiGenerierung dg1 = new DateiGenerierung();
		dg1.generiereConfigDatei(speicherpfad, dbAdresse, dbBenutzername, dbPasswort, inaktiveKundenAusblenden);
		datenbankCheck();
		if(datenbankAnbindung) {
			GUI.getTk1().comboBox_kunde_kunden_aktualisieren();
			GUI.getRp1().comboBox_Position_Positionen_aktualisieren();
			GUI.getRp1().comboBox_Position_Kategorie_aktualisieren();
		}
	}
	
	public static void f�lleConfigFelder() {
		GUI.getTextField_Optionen_Speicherpfad().setText(speicherpfad);
		GUI.getTextField_Optionen_dbAdresse().setText(dbAdresse);
		GUI.getTextField_Optionen_dbBenutzername().setText(dbBenutzername);
		GUI.getPasswordField_Optionen_dbPasswort().setText(dbPasswort);
		GUI.getChckbx_Optionen_KundenAusblenden().setSelected(inaktiveKundenAusblenden);
	}
	
	public boolean checkAufUngesicherteDaten() {			//unbenutzt bisher
		return false;
	}
	
	public static void datenbankCheck() {
		SQLAnbindung check = new SQLAnbindung();
		datenbankAnbindung = check.datenbankTest();
	}

	// Getter/Setter
	
	public static String getSpeicherpfad() {
		return speicherpfad;
	}

	public static void setSpeicherpfad(String speicherpfad) {
		TabProgrammOptionen.speicherpfad = speicherpfad;
	}

	public static String getDbAdresse() {
		return dbAdresse;
	}

	public static void setDbAdresse(String dbAdresse) {
		TabProgrammOptionen.dbAdresse = dbAdresse;
	}

	public static String getDbBenutzername() {
		return dbBenutzername;
	}

	public static void setDbBenutzername(String dbBenutzername) {
		TabProgrammOptionen.dbBenutzername = dbBenutzername;
	}

	public static String getDbPasswort() {
		return dbPasswort;
	}

	public static void setDbPasswort(String dbPasswort) {
		TabProgrammOptionen.dbPasswort = dbPasswort;
	}

	public static boolean isInaktiveKundenAusblenden() {
		return inaktiveKundenAusblenden;
	}

	public static void setInaktiveKundenAusblenden(boolean inaktiveKundenAusblenden) {
		TabProgrammOptionen.inaktiveKundenAusblenden = inaktiveKundenAusblenden;
	}

	public static boolean isDatenbankAnbindung() {
		return datenbankAnbindung;
	}

	public static void setDatenbankAnbindung(boolean datenbankAnbindung) {
		TabProgrammOptionen.datenbankAnbindung = datenbankAnbindung;
	}
	
	

}