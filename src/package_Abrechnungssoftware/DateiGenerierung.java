package package_Abrechnungssoftware;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;


public class DateiGenerierung {
	
	// Attribute
	private static NumberFormat geldformatierung = new DecimalFormat("0.00");
	private ArrayList<Rechnungsposten> rechnungsposten;
	// Konstruktoren
	
	// Methoden
	
	public void generiereConfigDatei(String speicherpfad, String dbAdresse, String dbBenutzername, String dbPasswort) {
		
	}
	

	public void generierePDFAusVorlage(boolean mitDruckauftrag) throws IOException, PrinterException {
			
			String kunde_Name = GUI.getTk1().getAktuellerKunde().getKundeName();
			String kunde_Strasse = GUI.getTk1().getAktuellerKunde().getKundeStrasse();
			String kunde_Hausnummer = GUI.getTk1().getAktuellerKunde().getKundeHausnummer();
			String kunde_Ort = GUI.getTk1().getAktuellerKunde().getKundeOrt();
			int kunde_PLZ = GUI.getTk1().getAktuellerKunde().getKundePLZ();
			String kunde_PLZ_String = String.valueOf(kunde_PLZ);
			Date date = GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungDatum();
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			String Datum = df.format(date);
			String rechnung_Nummer = GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungNummer();
			int kunde_ID = GUI.getTk1().getAktuellerKunde().getKundeID();
			String kunde_ID_String = String.valueOf(kunde_ID);
			String rechnung_Betreff = GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungBetreff();
			String rechnung_Anrede = GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungAnrede();
			String rechnung_Anschreiben = GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungAnschreiben();
//			String rechnung_Rechnungposten = GUI.
			String summe_Netto = "Summe Netto: " + geldformatierung.format(GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungSummeNetto());
			String summe_Gesamt = "Summe Gesamt: " + geldformatierung.format(GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungEndbetrag());
			
			// TEST
			//generiereRechnungsPostenStream();
			// TEST
			
			
			//PDF Dokumentvorlage in unsere neue PDF laden
				
			File file = new File("F:/Rechnung_Vorlage_Bahr_Herzog_JD_Studio_v5.pdf");
			PDDocument pdf_Test = PDDocument.load(file);
			
			PDDocumentCatalog pdCatalog = pdf_Test.getDocumentCatalog();
			PDAcroForm pdAcroForm = pdCatalog.getAcroForm();

			//System.out.println(pdAcroForm.toString());
			
//			for(PDField pdField : pdAcroForm.getFields()) {
//			    System.out.println( pdField.getFullyQualifiedName() + " " + pdField.getPartialName() + " -- " + pdField.getValueAsString());
//			}
			
			PDField kunde_Name_pdf = pdAcroForm.getField("Kunde_Name");
			kunde_Name_pdf.setValue(kunde_Name);
			kunde_Name_pdf.setReadOnly(true);
			
			PDField kunde_Strasse_pdf = pdAcroForm.getField("Kunde_Strasse");
			kunde_Strasse_pdf.setValue(kunde_Strasse + " " + kunde_Hausnummer);
			kunde_Strasse_pdf.setReadOnly(true);
			
			PDField kunde_Ort_pdf = pdAcroForm.getField("Kunde_Ort");
			kunde_Ort_pdf.setValue(kunde_Ort +" " + kunde_PLZ_String);
			kunde_Ort_pdf.setReadOnly(true);
			
			PDField rechnung_Datum_pdf = pdAcroForm.getField("Rechnung_Datum");
			rechnung_Datum_pdf.setValue(Datum);
			rechnung_Datum_pdf.setReadOnly(true);
			
			PDField rechnung_Nummer_pdf = pdAcroForm.getField("Rechnung_Nummer");
			rechnung_Nummer_pdf.setValue(rechnung_Nummer);
			rechnung_Nummer_pdf.setReadOnly(true);
			
			PDField kunde_ID_pdf = pdAcroForm.getField("Kunde_ID");
			kunde_ID_pdf.setValue(kunde_ID_String);
			kunde_ID_pdf.setReadOnly(true);
			
			PDField rechnung_Betreff_pdf = pdAcroForm.getField("Rechnung_Betreff");
			rechnung_Betreff_pdf.setValue(rechnung_Betreff);
			rechnung_Betreff_pdf.setReadOnly(true);
			
			PDField rechnung_Anrede_pdf = pdAcroForm.getField("Rechnung_Anrede");
			rechnung_Anrede_pdf.setValue(rechnung_Anrede);
			rechnung_Anrede_pdf.setReadOnly(true);
			
			PDField rechnung_Anschreiben_pdf = pdAcroForm.getField("Rechnung_Anschreiben");
			rechnung_Anschreiben_pdf.setValue(rechnung_Anschreiben);
			rechnung_Anschreiben_pdf.setReadOnly(true);
			
			PDField rechnung_Posten = pdAcroForm.getField("Rechnung_Posten");
			rechnung_Posten.setValue(generiereRechnungsPostenStream());
			rechnung_Posten.setReadOnly(true);
			
			PDField summe_Netto_pdf = pdAcroForm.getField("Rechnung_Summe_Netto");
			summe_Netto_pdf.setValue(summe_Netto);
			summe_Netto_pdf.setReadOnly(true);
			
			PDField summe_Gesamt_pdf = pdAcroForm.getField("Rechnung_Summe_Gesamt");
			summe_Gesamt_pdf.setValue(summe_Gesamt);
			summe_Gesamt_pdf.setReadOnly(true);
			
			file.setReadOnly();
			
			pdf_Test.save("F:/filled.pdf");
			
			if(mitDruckauftrag) {
				File pdf_print = new File("F:/filled.pdf");
				try {
					if(Desktop.isDesktopSupported()) {
						Desktop dt = Desktop.getDesktop();
						dt.print(pdf_print);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			

			pdf_Test.close();
			
		
			
		
	}
	
	
	public String generiereRechnungsPostenStream() {
		int markerBezeichnung = 5;
		int markerSatz = 41;
		int markerEinheiten = 55;
		int markerSatzEuro = 83;
		int gesamtLänge = 105;
		String ausgabe = "";
		
		rechnungsposten = GUI.getTk1().getNeueGUIRechnung().getTr1().getAktuelleRechnung().getRechnungsposten();
		
		for (int i = 0; i < rechnungsposten.size(); i++) {
			String ausgabeZeile = "";
			ausgabeZeile+= String.format("%03d", rechnungsposten.get(i).getRechnungspostenNummer());
			ausgabeZeile = auffüller(ausgabeZeile, markerBezeichnung);
			ausgabeZeile+= rechnungsposten.get(i).getRechnungspositionName();
			ausgabeZeile = auffüller(ausgabeZeile, markerSatz);
			ausgabeZeile+= rechnungsposten.get(i).getRechnungspostenSatz();
			ausgabeZeile = auffüller(ausgabeZeile, markerEinheiten);
			ausgabeZeile+= rechnungsposten.get(i).getRechnungspostenEinheiten();
			
			String testLänge = ausgabeZeile + geldformatierung.format(rechnungsposten.get(i).getRechnungspostenSatzEuro()) +  "€";
			while (testLänge.length() < markerSatzEuro) {
				ausgabeZeile+= " ";
				testLänge = ausgabeZeile + geldformatierung.format(rechnungsposten.get(i).getRechnungspostenSatzEuro()) +  "€";
			}
			ausgabeZeile+= geldformatierung.format(rechnungsposten.get(i).getRechnungspostenSatzEuro()) +  "€";
					
			String gesamtTestLänge = ausgabeZeile + geldformatierung.format(rechnungsposten.get(i).getRechnungspostenGesamtEuro()) +  " €";
			while (gesamtTestLänge.length() < gesamtLänge) {
				ausgabeZeile+= " ";
				gesamtTestLänge = ausgabeZeile + geldformatierung.format(rechnungsposten.get(i).getRechnungspostenGesamtEuro()) +  " €";
			}
			ausgabe += ausgabeZeile + geldformatierung.format(rechnungsposten.get(i).getRechnungspostenGesamtEuro()) +  "€" + "\n";
		}
		
		System.out.println(ausgabe);
		return ausgabe;
	}
	
	public String auffüller(String eingabe, int marker) {
		String ausgabe;
		ausgabe = eingabe;
		while (ausgabe.length() <= marker-1) {
			ausgabe+= " ";
		}
		return ausgabe;
		
	}
	
	
	// Getter/Setter
	
	
}
