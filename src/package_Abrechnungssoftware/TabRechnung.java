package package_Abrechnungssoftware;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TabRechnung {
	
	// Attribute
	private Rechnung aktuelleRechnung;
	private boolean neueRechnung;
	private int anzahlPosten = 0;
	private ArrayList<ArrayList<Object>> posten = new ArrayList<ArrayList<Object>>();
	
	// ggf veraltet
	private String betreff;
	private String anrede;
	private String anschreiben;
	private ArrayList<ArrayList<Object>> rechnungsPosten = new ArrayList<ArrayList<Object>>();
	private double summeNetto;
	private double rechnungsbetrag;
	private java.sql.Date rechnungsDatum;
	private int kundeID;
	private String rechnungNummer;
	private String dateiName;
	
	// Konstruktoren
	
	public TabRechnung(boolean neueRechnung, Integer rechnungID) {
		this.neueRechnung = neueRechnung;
		if (neueRechnung == false) {
			aktuelleRechnung = new Rechnung(rechnungID);
			aktuelleRechnung.ladeRechnungsposten();
		}else {
			aktuelleRechnung = new Rechnung();
		}
		
	}
	
	// Methoden
	public ArrayList<Object> rechnungspostenErstellen(Integer postenNummer, boolean ladeBestehendeDaten) {
		ArrayList<Object> panel = new ArrayList<Object>();
		
		JPanel panel_Rechnung_Posten_Posten = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Posten = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Posten.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Rechnung_Posten_Posten.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Posten_Posten.gridx = 0;
		gbc_panel_Rechnung_Posten_Posten.gridy = postenNummer;
		//panel_Rechnung_Posten_sub.add(panel_Rechnung_Posten_Posten, gbc_panel_Rechnung_Posten_Posten);
		GridBagLayout gbl_panel_Rechnung_Posten_Posten = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Posten.columnWidths = new int[]{0, 30, 15, 250, 25, 100, 25, 60, 25, 110, 25, 110, 20, 0};
		gbl_panel_Rechnung_Posten_Posten.rowHeights = new int[]{0, 0};
		gbl_panel_Rechnung_Posten_Posten.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Posten_Posten.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_Rechnung_Posten_Posten.setLayout(gbl_panel_Rechnung_Posten_Posten);
		
		JLabel lbl_Rechnung_Posten_Nr = new JLabel(String.format("%03d", postenNummer));
		lbl_Rechnung_Posten_Nr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Nr = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Nr.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Posten_Nr.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Nr.gridx = 1;
		gbc_lbl_Rechnung_Posten_Nr.gridy = postenNummer;
		panel_Rechnung_Posten_Posten.add(lbl_Rechnung_Posten_Nr, gbc_lbl_Rechnung_Posten_Nr);
		
		JComboBox<Object> comboBox_Rechnung_Posten_Bezeichnung = new JComboBox<Object>();
		comboBox_Rechnung_Posten_Bezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox_Rechnung_Posten_Bezeichnung = new GridBagConstraints();
		gbc_comboBox_Rechnung_Posten_Bezeichnung.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_Rechnung_Posten_Bezeichnung.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Rechnung_Posten_Bezeichnung.gridx = 3;
		gbc_comboBox_Rechnung_Posten_Bezeichnung.gridy = postenNummer;
		panel_Rechnung_Posten_Posten.add(comboBox_Rechnung_Posten_Bezeichnung, gbc_comboBox_Rechnung_Posten_Bezeichnung);
		
		JLabel lbl_Rechnung_Posten_Satz = new JLabel(" ");
		lbl_Rechnung_Posten_Satz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Satz = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Satz.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Posten_Satz.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Satz.gridx = 5;
		gbc_lbl_Rechnung_Posten_Satz.gridy = postenNummer;
		panel_Rechnung_Posten_Posten.add(lbl_Rechnung_Posten_Satz, gbc_lbl_Rechnung_Posten_Satz);
		
		JTextField textField_Rechnung_Posten_Einheiten = new JTextField();
		textField_Rechnung_Posten_Einheiten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textField_Rechnung_Posten_Einheiten = new GridBagConstraints();
		gbc_textField_Rechnung_Posten_Einheiten.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Rechnung_Posten_Einheiten.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Posten_Einheiten.gridx = 7;
		gbc_textField_Rechnung_Posten_Einheiten.gridy = postenNummer;
		panel_Rechnung_Posten_Posten.add(textField_Rechnung_Posten_Einheiten, gbc_textField_Rechnung_Posten_Einheiten);
		textField_Rechnung_Posten_Einheiten.setColumns(10);
		
		JTextField textField_Rechnung_Posten_Satz_in_Euro = new JTextField();
		textField_Rechnung_Posten_Satz_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textField_Rechnung_Posten_Satz_in_Euro = new GridBagConstraints();
		gbc_textField_Rechnung_Posten_Satz_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Rechnung_Posten_Satz_in_Euro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Posten_Satz_in_Euro.gridx = 9;
		gbc_textField_Rechnung_Posten_Satz_in_Euro.gridy = postenNummer;
		panel_Rechnung_Posten_Posten.add(textField_Rechnung_Posten_Satz_in_Euro, gbc_textField_Rechnung_Posten_Satz_in_Euro);
		textField_Rechnung_Posten_Satz_in_Euro.setColumns(10);
		
		JLabel lbl_Rechnung_Posten_Gesamt_in_Euro = new JLabel("0.00");
		lbl_Rechnung_Posten_Gesamt_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Gesamt_in_Euro = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro.anchor = GridBagConstraints.EAST;
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro.gridx = 11;
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro.gridy = postenNummer;
		panel_Rechnung_Posten_Posten.add(lbl_Rechnung_Posten_Gesamt_in_Euro, gbc_lbl_Rechnung_Posten_Gesamt_in_Euro);
		
		// --------------------------------------------------------------------------------------------------------------
				// ggf actionlistener für die Betrag und Einheiten Felder zum ansprechen der Berechnung
		
		// ComboBox befüllen und ActionListener Hinzufügen
		comboBox_Rechnung_Posten_Bezeichnung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				if (comboBox_Rechnung_Posten_Bezeichnung.getSelectedIndex() != -1) {
					SQLAnbindung sql = new SQLAnbindung();
					String sqlBefehl = "";
					String positionsName = comboBox_Rechnung_Posten_Bezeichnung.getSelectedItem().toString();
					sqlBefehl = sql.erstelleBefehl("SELECT", true, "kategoriepositionName", "rechnungsposition", "kategorieposition", "kategoriepositionID", "rechnungspositionName", positionsName);
					String kategorieAuswahl = sql.holeStringAusDatenbank(sqlBefehl, "kategoriepositionName");
					lbl_Rechnung_Posten_Satz.setText(kategorieAuswahl);
				}else {
					lbl_Rechnung_Posten_Satz.setText(" ");
				}
			}
		});
		
		for (int i = 0; i < Suchleiste.getRechnungspositionen().size(); i++) {
			comboBox_Rechnung_Posten_Bezeichnung.addItem(Suchleiste.getRechnungspositionen().get(i));
		}
		comboBox_Rechnung_Posten_Bezeichnung.setSelectedIndex(-1);
		comboBox_Rechnung_Posten_Bezeichnung.revalidate();
		comboBox_Rechnung_Posten_Bezeichnung.repaint();
		
		
		//AutoFill falls es eine bestehende Rechnung ist
		if (ladeBestehendeDaten == true) {
			String comboBoxAuswahl = aktuelleRechnung.getRechnungsposten().get(postenNummer).getRechnungspositionName();
			lbl_Rechnung_Posten_Satz.setText(aktuelleRechnung.getRechnungsposten().get(postenNummer).getRechnungspostenSatz());
			comboBox_Rechnung_Posten_Bezeichnung.setSelectedIndex(Suchleiste.getRechnungspositionen().indexOf(comboBoxAuswahl));
			textField_Rechnung_Posten_Einheiten.setText(Double.toString(aktuelleRechnung.getRechnungsposten().get(postenNummer).getRechnungspostenEinheiten()));
			textField_Rechnung_Posten_Satz_in_Euro.setText(Double.toString(aktuelleRechnung.getRechnungsposten().get(postenNummer).getRechnungspostenSatzEuro()));
			lbl_Rechnung_Posten_Gesamt_in_Euro.setText(Double.toString(aktuelleRechnung.getRechnungsposten().get(postenNummer).getRechnungspostenGesamtEuro()));
			
		}
		panel.add(panel_Rechnung_Posten_Posten);
		panel.add(gbc_panel_Rechnung_Posten_Posten);
		return panel;
	}
	
	public void rechnungspostenHinzufügen(boolean ladeBestehendeDaten) {
		anzahlPosten++;
		posten.add(rechnungspostenErstellen(anzahlPosten, ladeBestehendeDaten));
		for (int i = 0; i < posten.size(); i++) {
			GUI.getTk1().getNeueGUIRechnung().getPanel_Rechnung_Posten_Innen_Posten().add((JPanel)posten.get(i).get(0), posten.get(i).get(1));
		}
	}
	
	public void rechnungspostenEntfernen(){
		if(anzahlPosten > 0) {
			GUI.getTk1().getNeueGUIRechnung().getPanel_Rechnung_Posten_Innen_Posten().remove(GUI.getTk1().getNeueGUIRechnung().getPanel_Rechnung_Posten_Innen_Posten().getComponentCount()-1);
			posten.remove(posten.size()-1);
			anzahlPosten--;
		}
	}
	
	
	public void zeigeBestehendeRechnungsdaten() {
		GUI.getTk1().getNeueGUIRechnung().getTextArea_Rechnung_Rechnung_Betreff().setText(aktuelleRechnung.getRechnungBetreff());
		GUI.getTk1().getNeueGUIRechnung().getTextField_Rechnung_Rechnung_Anrede().setText(aktuelleRechnung.getRechnungAnrede());
		GUI.getTk1().getNeueGUIRechnung().getTextArea_Rechnung_Rechnung_Anschreiben().setText(aktuelleRechnung.getRechnungAnschreiben());
		GUI.getTk1().getNeueGUIRechnung().getLbl_Rechnung_Summe_Netto_in_Euro().setText(Double.toString(aktuelleRechnung.getRechnungSummeNetto()));
		GUI.getTk1().getNeueGUIRechnung().getLbl_Rechnung_Rechnung_Betrag_in_Euro().setText(Double.toString(aktuelleRechnung.getRechnungEndbetrag()));
		System.out.println(aktuelleRechnung.getRechnungsposten().size());
		for (int i = 0; i < aktuelleRechnung.getRechnungsposten().size(); i++) {
			rechnungspostenHinzufügen(true);
		}
		GUI.getTk1().getNeueGUIRechnung().fensterAktualisieren();

	}

	
	public void speichern() {
		speichereRechnung();
		speicherePosten();
	}
	
	public void drucken() {
		
	}
	
	
	public void speichereRechnung() {
//		betreff = GUI.getTk1().getNeueRechnung().getTextArea_Rechnung_Rechnung_Betreff().getText();
//		anrede = GUI.getTk1().getNeueRechnung().getTextField_Rechnung_Rechnung_Anrede().getText();
//		anschreiben = GUI.getTk1().getNeueRechnung().getTextArea_Rechnung_Rechnung_Anschreiben().getText();
//		summeNetto = GUI.getTk1().getNeueRechnung().getRechnung_Summe_Netto_in_Euro();
//		rechnungsbetrag = GUI.getTk1().getNeueRechnung().getRechnung_Rechnung_Betrag_in_Euro();
//		rechnungsDatum = new java.sql.Date(System.currentTimeMillis());
//		kundeID = GUI.getTk1().getKundeID();
//		ArrayList<Integer> bisherigeRechnungen = new ArrayList<Integer>();
//		
//		SQLAnbindung sql = new SQLAnbindung();
//		String sqlBefehl;
//		sqlBefehl = sql.erstelleBefehl("SELECT", "kundeID", "rechnung", "kundeID", kundeID);
//		bisherigeRechnungen = sql.holeIntegerArrayAusDatenbank(sqlBefehl, "kundeID");
//		rechnungNummer = generiereRechnungsnummer(bisherigeRechnungen.size());
//		dateiName = generiereRechnungsDateiName();
//		sqlBefehl = sql.erstelleBefehl("INSERT", "rechnung", "rechnungBetreff", betreff, "rechnungAnrede", anrede, "rechnungAnschreiben", anschreiben, "rechnungSummeNetto", summeNetto, "rechnungEndbetrag", rechnungsbetrag, "rechnungDatum", rechnungsDatum, "rechnungNummer", rechnungNummer, "rechnungDateiName", dateiName, "kundeID", kundeID);
//		sql.datenbankÄnderung(sqlBefehl);
	}
	
	public void speicherePosten() {
//		rechnungsPosten = GUI.getTk1().getNeueRechnung().getPosten();
//		int rechnungspostenNummer;
//		int rechnungspostenEinheit;
//		String rechnungspostenBezeichnung;
//		String rechnungspostenSatz;
//		Double rechnungspostenBetrag;
//		Double rechnungspostenGesamt;
//		int rechnungID;
//		int rechnungspositionID;
//		
//		SQLAnbindung sql = new SQLAnbindung();
//		String sqlBefehl = "";
//		
//		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungID", "rechnung", "rechnungNummer", rechnungNummer);
//		rechnungID = sql.holeIntAusDatenbank(sqlBefehl, "rechnungID");
//		
//		for (int i = 0; i < rechnungsPosten.size(); i++) {
//			ArrayList<Object> tempArray = rechnungsPosten.get(i);
//			JPanel rechnungsPostenPanel = (JPanel) tempArray.get(0);
//			JLabel lbl_Posten_Nummer = (JLabel) rechnungsPostenPanel.getComponent(0);
//			rechnungspostenNummer = Integer.valueOf(lbl_Posten_Nummer.getText());
//			JComboBox comboBox_PostenBezeichnung = (JComboBox) rechnungsPostenPanel.getComponent(1);
//			rechnungspostenBezeichnung = comboBox_PostenBezeichnung.getSelectedItem().toString();
//			JLabel lbl_Posten_Satz = (JLabel) rechnungsPostenPanel.getComponent(2);
//			rechnungspostenSatz = lbl_Posten_Satz.getText();
//			JTextField lbl_Posten_Einheit = (JTextField) rechnungsPostenPanel.getComponent(3);
//			rechnungspostenEinheit = Integer.valueOf(lbl_Posten_Einheit.getText());
//			JTextField lbl_Posten_Betrag = (JTextField) rechnungsPostenPanel.getComponent(4);
//			rechnungspostenBetrag = Double.valueOf(lbl_Posten_Betrag.getText());
//			JLabel lbl_Posten_Gesamt = (JLabel) rechnungsPostenPanel.getComponent(5);
//			rechnungspostenGesamt = Double.valueOf(lbl_Posten_Gesamt.getText());
//
//			sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionID", "rechnungsposition", "rechnungspositionName", rechnungspostenBezeichnung);
//			rechnungspositionID = sql.holeIntAusDatenbank(sqlBefehl, "rechnungspositionID");
//			
//			sqlBefehl = sql.erstelleBefehl("INSERT", "rechnungsposten", "rechnungID", rechnungID, "rechnungspositionID", rechnungspositionID, "rechnungspostenNummer", rechnungspostenNummer, "rechnungspostenEinheit", rechnungspostenEinheit, "rechnungspostenSatz", rechnungspostenSatz, "rechnungspostenBetrag", rechnungspostenBetrag, "rechnungspostenGesamt", rechnungspostenGesamt);
//			sql.datenbankÄnderung(sqlBefehl);
//		}
	}
	
	public String generiereRechnungsnummer(int anzahlRechnungen) {
		String retNummer;
		retNummer = "KD" + kundeID + "D" + rechnungsDatum + "R" + (anzahlRechnungen+1);
		return retNummer;
	}
	
	public String generiereRechnungsDateiName() {
		String retName;
		retName = rechnungNummer + ".pdf";
		return retName;
	}


	public boolean isNeueRechnung() {
		return neueRechnung;
	}


	
	public void setNeueRechnung(boolean neueRechnung) {
		this.neueRechnung = neueRechnung;
	}

	public Rechnung getAktuelleRechnung() {
		return aktuelleRechnung;
	}

	public void setAktuelleRechnung(Rechnung aktuelleRechnung) {
		this.aktuelleRechnung = aktuelleRechnung;
	}
	
	
	
	

}
