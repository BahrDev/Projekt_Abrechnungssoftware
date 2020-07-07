package package_Abrechnungssoftware;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class DateiGenerierung {
	
	// Attribute
	
	// Konstruktoren
	
	// Methoden
	
	public void generiereConfigDatei(String speicherpfad, String dbAdresse, String dbBenutzername, String dbPasswort) {
		
	}
	

	public void generierePDFAusVorlage() throws IOException {
			
		
		
			//PDF Dokumentvorlage in unsere neue PDF laden
				
			File file = new File("C:/Users/paric/Documents/Rechnung_Vorlage_Bahr_Herzog_JD_Studio_v2.pdf");
			PDDocument pdf_Test = PDDocument.load(file);
			
			PDDocumentCatalog pdCatalog = pdf_Test.getDocumentCatalog();
			PDAcroForm pdAcroForm = pdCatalog.getAcroForm();

			System.out.println(pdAcroForm.toString());
			
			for(PDField pdField : pdAcroForm.getFields()) {
			    System.out.println( pdField.getFullyQualifiedName()+ " " +pdField.getPartialName()+ " -- " + pdField.getValueAsString());
			}
			
			PDField Kunde_Name = pdAcroForm.getField("Kunde_Name");
			Kunde_Name.setValue("blablubb");
//			String Kunde_Name = lbl_Rechnung_Kunden_Name
			
			PDField Rechnung_Posten = pdAcroForm.getField("[Rechnung_Posten]");
			Rechnung_Posten.setValue("blablubb\nblablubb\nblablubb\nblablubb\nblablubb\nblablubb\nblablubb\nblablubb\n");
			
			
			pdf_Test.save("C:/Users/paric/Documents/Java_Tutorials/neuTest.pdf");
			
		
			
			pdf_Test.close();
			
		

		
	}
	
	// Getter/Setter
	
	
}
