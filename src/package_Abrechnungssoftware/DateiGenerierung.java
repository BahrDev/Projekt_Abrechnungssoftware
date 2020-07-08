package package_Abrechnungssoftware;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class DateiGenerierung {
	
	// Attribute
	private static NumberFormat geldformatierung = new DecimalFormat("0.00");
	// Konstruktoren
	
	// Methoden
	
	public void generiereConfigDatei(String speicherpfad, String dbAdresse, String dbBenutzername, String dbPasswort) {
		
	}
	

	public void generierePDFAusVorlage() throws IOException {
			
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
			
			
			
			
			//PDF Dokumentvorlage in unsere neue PDF laden
				
			File file = new File("F:/Rechnung_Vorlage_Bahr_Herzog_JD_Studio_v3.pdf");
			PDDocument pdf_Test = PDDocument.load(file);
			
			PDDocumentCatalog pdCatalog = pdf_Test.getDocumentCatalog();
			PDAcroForm pdAcroForm = pdCatalog.getAcroForm();

			System.out.println(pdAcroForm.toString());
			
			for(PDField pdField : pdAcroForm.getFields()) {
			    System.out.println( pdField.getFullyQualifiedName() + " " + pdField.getPartialName() + " -- " + pdField.getValueAsString());
			}
			
			PDField kunde_Name_pdf = pdAcroForm.getField("Kunde_Name");
			kunde_Name_pdf.setValue(kunde_Name);
			
			PDField kunde_Strasse_pdf = pdAcroForm.getField("Kunde_Strasse");
			kunde_Strasse_pdf.setValue(kunde_Strasse + " " + kunde_Hausnummer);
			
			PDField kunde_Ort_pdf = pdAcroForm.getField("Kunde_Ort");
			kunde_Ort_pdf.setValue(kunde_Ort +" " + kunde_PLZ_String);
			
			PDField rechnung_Datum_pdf = pdAcroForm.getField("Rechnung_Datum");
			rechnung_Datum_pdf.setValue(Datum);
			
			PDField rechnung_Nummer_pdf = pdAcroForm.getField("Rechnung_Datum");
			rechnung_Nummer_pdf.setValue(rechnung_Nummer);
			
			PDField kunde_ID_pdf = pdAcroForm.getField("Kunde_ID");
			kunde_ID_pdf.setValue(kunde_ID_String);
			
			PDField rechnung_Betreff_pdf = pdAcroForm.getField("Rechnung_Betreff");
			rechnung_Betreff_pdf.setValue(rechnung_Betreff);
			
			PDField rechnung_Anrede_pdf = pdAcroForm.getField("Rechnung_Anrede");
			rechnung_Anrede_pdf.setValue(rechnung_Anrede);
			
			PDField rechnung_Anschreiben_pdf = pdAcroForm.getField("Rechnung_Anschreiben");
			rechnung_Anschreiben_pdf.setValue(rechnung_Anschreiben);
			
			
//			PDField Rechnung_Posten = pdAcroForm.getField("[Rechnung_Posten]");
//			Rechnung_Posten.setValue();
			
			PDField summe_Netto_pdf = pdAcroForm.getField("Rechnung_Summe_Netto");
			summe_Netto_pdf.setValue(summe_Netto);
			
			PDField summe_Gesamt_pdf = pdAcroForm.getField("Rechnung_Summe_Gesamt");
			summe_Gesamt_pdf.setValue(summe_Gesamt);
			
			
			pdf_Test.save("F:/neuTest.pdf");
			
		
			
			pdf_Test.close();
			
		

		
	}
	
	// Getter/Setter
	
	
}
