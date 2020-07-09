package package_Abrechnungssoftware;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TabOptionen {
	
	// Attribute
	
	private static String speicherpfad;
	private static String dbAdresse;
	private static String dbBenutzername;
	private static String dbPasswort;
	private static boolean inaktiveKundenAusblenden;
	
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
		} catch (Exception abbruch) {
			// TODO: handle exception
			abbruch.printStackTrace();
		}
	}
	
	public static void setzeSpeicherpfad() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Start-Verzeichnis auswählen");
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
	}
	
	public static void fülleConfigFelder() {
		GUI.getTextField_Optionen_Speicherpfad().setText(speicherpfad);
		GUI.getTextField_Optionen_dbAdresse().setText(dbAdresse);
		GUI.getTextField_Optionen_dbBenutzername().setText(dbBenutzername);
		GUI.getPasswordField_Optionen_dbPasswort().setText(dbPasswort);
		GUI.getChckbx_Optionen_KundenAusblenden().setSelected(inaktiveKundenAusblenden);
	}
	
	public boolean checkAufUngesicherteDaten() {
		return false;
	}
	
	public void frageZurAbsicherung() {
		//JOptionPane hier
	}

	// Getter/Setter
	
	public static String getSpeicherpfad() {
		return speicherpfad;
	}

	public static void setSpeicherpfad(String speicherpfad) {
		TabOptionen.speicherpfad = speicherpfad;
	}

	public static String getDbAdresse() {
		return dbAdresse;
	}

	public static void setDbAdresse(String dbAdresse) {
		TabOptionen.dbAdresse = dbAdresse;
	}

	public static String getDbBenutzername() {
		return dbBenutzername;
	}

	public static void setDbBenutzername(String dbBenutzername) {
		TabOptionen.dbBenutzername = dbBenutzername;
	}

	public static String getDbPasswort() {
		return dbPasswort;
	}

	public static void setDbPasswort(String dbPasswort) {
		TabOptionen.dbPasswort = dbPasswort;
	}

	public static boolean isInaktiveKundenAusblenden() {
		return inaktiveKundenAusblenden;
	}

	public static void setInaktiveKundenAusblenden(boolean inaktiveKundenAusblenden) {
		TabOptionen.inaktiveKundenAusblenden = inaktiveKundenAusblenden;
	}
	
	

}
