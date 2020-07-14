package package_Abrechnungssoftware;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TabProgrammOptionen {

	// Attribute

	private static String speicherpfad;
	private static String dbAdresse;
	private static String dbBenutzername;
	private static String dbPasswort;
	private static boolean inaktiveKundenAusblenden;
	private static boolean datenbankAnbindung;

	// Methoden

	public static void ladeConfigs() {
		try {
			checkConfigIni();
			BufferedReader einlesenVonDaten = new BufferedReader(new FileReader("config.ini"));
			String eintrag;
			int zeile = 0;
			while ((eintrag = einlesenVonDaten.readLine()) != null) {
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
					} else {
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
			String speicherpfad = chooser.getSelectedFile().getAbsolutePath();
			if(!speicherpfad.endsWith("\\")) {
				speicherpfad += "\\";
			}
			GUI.getTextField_Optionen_Speicherpfad().setText(speicherpfad);
		}
	}

	public static void speichern() {
		if (checkAufUngesicherteDaten()) {
			if (sicherheitsabfrage()) {
				speichereConfigs();
			} else {
				fülleConfigFelder();
			}
		} else {
			speichereConfigs();
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
		if (datenbankAnbindung) {
			GUI.getTk1().comboBox_kunde_kunden_aktualisieren();
			GUI.getRp1().comboBox_Position_Positionen_aktualisieren();
			GUI.getRp1().comboBox_Position_Kategorie_aktualisieren();
		}
	}

	public static void fülleConfigFelder() {
		GUI.getTextField_Optionen_Speicherpfad().setText(speicherpfad);
		GUI.getTextField_Optionen_dbAdresse().setText(dbAdresse);
		GUI.getTextField_Optionen_dbBenutzername().setText(dbBenutzername);
		GUI.getPasswordField_Optionen_dbPasswort().setText(dbPasswort);
		GUI.getChckbx_Optionen_KundenAusblenden().setSelected(inaktiveKundenAusblenden);
	}

	public static boolean checkAufUngesicherteDaten() {
		boolean check = false;
		if (!speicherpfad.equals(GUI.getTextField_Optionen_Speicherpfad().getText())) {
			check = true;
		} else if (!dbAdresse.equals(GUI.getTextField_Optionen_dbAdresse().getText())) {
			check = true;
		} else if (!dbBenutzername.equals(GUI.getTextField_Optionen_dbBenutzername().getText())) {
			check = true;
		} else if (!dbPasswort.equals(String.valueOf(GUI.getPasswordField_Optionen_dbPasswort().getPassword()))) {
			check = true;
		} else if (inaktiveKundenAusblenden != GUI.getChckbx_Optionen_KundenAusblenden().isSelected()) {
			check = true;
		}
		return check;
	}

	public static boolean sicherheitsabfrage() {
		boolean ausgabe;
		int bestätigung = JOptionPane.showConfirmDialog(null,
				"<html><center>Sie haben Einstellungen verändert. <br>War dies so beabsichtigt?</center></html>",
				"Achtung", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (bestätigung == 0) {
			ausgabe = true;
		} else {
			ausgabe = false;
		}
		return ausgabe;
	}

	public static void datenbankCheck() {
		SQLAnbindung check = new SQLAnbindung();
		datenbankAnbindung = check.datenbankTest();
	}

	public static void checkConfigIni() {
		File configTest = new File("config.ini");
		if (!configTest.exists()) {
			DateiGenerierung dg1 = new DateiGenerierung();
			dg1.generiereConfigDatei("", "", "", "", false);
		}
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
