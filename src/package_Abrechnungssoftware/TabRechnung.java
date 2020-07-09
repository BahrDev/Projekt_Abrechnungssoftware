package package_Abrechnungssoftware;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TabRechnung {
	
	// Attribute
	private Rechnung aktuelleRechnung;
	private boolean neueRechnung;
	private int anzahlPosten = 0;
	private ArrayList<ArrayList<Object>> postenPanel = new ArrayList<ArrayList<Object>>();
	private static NumberFormat geldformatierung = new DecimalFormat("0.00");
	// Konstruktoren
	
	public TabRechnung(boolean neueRechnung, Integer rechnungID) {
		this.neueRechnung = neueRechnung;
		if (neueRechnung == false) {
			aktuelleRechnung = new Rechnung(rechnungID);
			aktuelleRechnung.ladeRechnungsposten();
			//aktuelleRechnung.setWurdeVerändert(false);
		}else {
			aktuelleRechnung = new Rechnung();
			//aktuelleRechnung.setWurdeVerändert(false);
		}
	}
	
	// Methoden
	public ArrayList<Object> rechnungspostenPanelErstellen(Integer postenNummer, boolean ladeBestehendeDaten) {
		ArrayList<Object> panel = new ArrayList<Object>();
		if(ladeBestehendeDaten == false) {
			Rechnungsposten neuerPosten = new Rechnungsposten();
			aktuelleRechnung.getRechnungsposten().add(neuerPosten);
		}
		
		JPanel panel_Rechnung_Posten_Posten = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Posten = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Posten.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Rechnung_Posten_Posten.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Posten_Posten.gridx = 0;
		gbc_panel_Rechnung_Posten_Posten.gridy = postenNummer;
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
		// DocumentListener hinzufügen (Dokument Filter ebenso!!!!!!!!!)
		textField_Rechnung_Posten_Einheiten.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String einheitenString = textField_Rechnung_Posten_Einheiten.getText();
				int einheitenInt = 0;
				einheitenString = einheitenString.replaceAll("[^0-9]","");
				if (einheitenString.length() > 4) {
					einheitenString = einheitenString.substring(0, 4);
				}
				if (einheitenString.equals("")) {
					einheitenString = "0";
				}
				einheitenInt = Integer.parseInt(einheitenString);
				aktuelleRechnung.getRechnungsposten().get(postenNummer-1).setRechnungspostenEinheiten(einheitenInt);
				berechneSummen();
				lbl_Rechnung_Posten_Gesamt_in_Euro.setText(geldformatierung.format(aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspostenGesamtEuro()));
				//aktuelleRechnung.setWurdeVerändert(true);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String einheitenString = textField_Rechnung_Posten_Einheiten.getText();
				int einheitenInt = 0;
				einheitenString = einheitenString.replaceAll("[^0-9]","");
				if (einheitenString.length() > 4) {
					einheitenString = einheitenString.substring(0, 4);
				}
				if (einheitenString.equals("")) {
					einheitenString = "0";
				}
				einheitenInt = Integer.parseInt(einheitenString);
				aktuelleRechnung.getRechnungsposten().get(postenNummer-1).setRechnungspostenEinheiten(einheitenInt);
				berechneSummen();
				lbl_Rechnung_Posten_Gesamt_in_Euro.setText(geldformatierung.format(aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspostenGesamtEuro()));
				//aktuelleRechnung.setWurdeVerändert(true);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		textField_Rechnung_Posten_Satz_in_Euro.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String satzEuroString = textField_Rechnung_Posten_Satz_in_Euro.getText();
				double satzEuroDouble = 0.00;
				if(satzEuroString.length() > 15) {
					satzEuroString = satzEuroString.substring(0, 15);
				}
				if(satzEuroString.length() > 3) {
					if(satzEuroString.contains(",") || satzEuroString.contains(".")) {
						satzEuroString = satzEuroString.replaceAll("[^0-9,.]", "");
						satzEuroString = satzEuroString.replace(",", ".");
						int indexPunkt = satzEuroString.lastIndexOf(".");
						String punktsuche = satzEuroString.substring(0, indexPunkt);
						if (punktsuche.contains(".")) {
							punktsuche = punktsuche.replace(".", "");
						}
						satzEuroString = punktsuche + satzEuroString.substring(indexPunkt);
					}
				}else {
					satzEuroString = satzEuroString.replaceAll("[^0-9]", "");
				}
				if (satzEuroString.equals("")) {
					satzEuroString = "0.00";
				}
				satzEuroDouble = Double.parseDouble(satzEuroString);
				aktuelleRechnung.getRechnungsposten().get(postenNummer-1).setRechnungspostenSatzEuro(satzEuroDouble);
				berechneSummen();
				lbl_Rechnung_Posten_Gesamt_in_Euro.setText(geldformatierung.format(aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspostenGesamtEuro()));
				//aktuelleRechnung.setWurdeVerändert(true);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String satzEuroString = textField_Rechnung_Posten_Satz_in_Euro.getText();
				double satzEuroDouble = 0.00;
				if(satzEuroString.length() > 15) {
					satzEuroString = satzEuroString.substring(0, 15);
				}
				if(satzEuroString.length() > 3) {
					if(satzEuroString.contains(",") || satzEuroString.contains(".")) {
						satzEuroString = satzEuroString.replaceAll("[^0-9,.]", "");
						satzEuroString = satzEuroString.replace(",", ".");
						int indexPunkt = satzEuroString.lastIndexOf(".");
						String punktsuche = satzEuroString.substring(0, indexPunkt);
						if (punktsuche.contains(".")) {
							punktsuche = punktsuche.replace(".", "");
						}
						satzEuroString = punktsuche + satzEuroString.substring(indexPunkt);
					}
				}else {
					satzEuroString = satzEuroString.replaceAll("[^0-9]", "");
				}
				if (satzEuroString.equals("")) {
					satzEuroString = "0.00";
				}
				satzEuroDouble = Double.parseDouble(satzEuroString);
				aktuelleRechnung.getRechnungsposten().get(postenNummer-1).setRechnungspostenSatzEuro(satzEuroDouble);
				berechneSummen();
				lbl_Rechnung_Posten_Gesamt_in_Euro.setText(geldformatierung.format(aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspostenGesamtEuro()));
				//aktuelleRechnung.setWurdeVerändert(true);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// ComboBox befüllen und ActionListener Hinzufügen
		
		for (int i = 0; i < Suchleiste.getRechnungspositionen().size(); i++) {
			comboBox_Rechnung_Posten_Bezeichnung.addItem(Suchleiste.getRechnungspositionen().get(i));
		}
		comboBox_Rechnung_Posten_Bezeichnung.setSelectedIndex(-1);
		comboBox_Rechnung_Posten_Bezeichnung.revalidate();
		comboBox_Rechnung_Posten_Bezeichnung.repaint();
		
		comboBox_Rechnung_Posten_Bezeichnung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				if (comboBox_Rechnung_Posten_Bezeichnung.getSelectedIndex() != -1) {
					aktuelleRechnung.getRechnungsposten().get(postenNummer-1).setRechnungspositionName(comboBox_Rechnung_Posten_Bezeichnung.getSelectedItem().toString());
					SQLAnbindung sql = new SQLAnbindung();
					String sqlBefehl = "";
					String positionsName = comboBox_Rechnung_Posten_Bezeichnung.getSelectedItem().toString();
					sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionSatz", "rechnungsposition", "rechnungspositionName", positionsName);
					String satzAuswahl = sql.holeStringAusDatenbank(sqlBefehl, "rechnungspositionSatz");
					lbl_Rechnung_Posten_Satz.setText(satzAuswahl);
					aktuelleRechnung.getRechnungsposten().get(postenNummer-1).setRechnungspostenSatz(satzAuswahl);
					sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionBetrag", "rechnungsposition", "rechnungspositionName", positionsName);
					double betrag = sql.holeIntAusDatenbank(sqlBefehl, "rechnungspositionBetrag");
					textField_Rechnung_Posten_Satz_in_Euro.setText(geldformatierung.format(betrag));
				
				}else {
					lbl_Rechnung_Posten_Satz.setText(" ");
					textField_Rechnung_Posten_Satz_in_Euro.setText("0.00");
				}
				//aktuelleRechnung.setWurdeVerändert(true);
			}
		});
		
		//AutoFill falls es eine bestehende Rechnung ist
		if (ladeBestehendeDaten == true) {
			String comboBoxAuswahl = aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspositionName();
			lbl_Rechnung_Posten_Satz.setText(aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspostenSatz());
			comboBox_Rechnung_Posten_Bezeichnung.setSelectedIndex(Suchleiste.getRechnungspositionen().indexOf(comboBoxAuswahl));
			textField_Rechnung_Posten_Einheiten.setText(String.valueOf(aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspostenEinheiten()));
			textField_Rechnung_Posten_Satz_in_Euro.setText(geldformatierung.format(aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspostenSatzEuro()));
			lbl_Rechnung_Posten_Gesamt_in_Euro.setText(geldformatierung.format(aktuelleRechnung.getRechnungsposten().get(postenNummer-1).getRechnungspostenGesamtEuro()));
			//aktuelleRechnung.setWurdeVerändert(false);
		}
		aktuelleRechnung.getRechnungsposten().get(postenNummer-1).setRechnungspostenNummer(Integer.valueOf(lbl_Rechnung_Posten_Nr.getText()));
		panel.add(panel_Rechnung_Posten_Posten);
		panel.add(gbc_panel_Rechnung_Posten_Posten);
		return panel;
	}
	
	public void rechnungspostenPanelHinzufügen(boolean ladeBestehendeDaten) {
		anzahlPosten++;
		postenPanel.add(rechnungspostenPanelErstellen(anzahlPosten, ladeBestehendeDaten));
		for (int i = 0; i < postenPanel.size(); i++) {
			GUI.getTk1().getNeueGUIRechnung().getPanel_Rechnung_Posten_Innen_Posten().add((JPanel)postenPanel.get(i).get(0), postenPanel.get(i).get(1));
		}
	}
	
	public void rechnungspostenPanelEntfernen(){
		if(anzahlPosten > 0) {
			GUI.getTk1().getNeueGUIRechnung().getPanel_Rechnung_Posten_Innen_Posten().remove(GUI.getTk1().getNeueGUIRechnung().getPanel_Rechnung_Posten_Innen_Posten().getComponentCount()-1);
			postenPanel.remove(postenPanel.size()-1);
			aktuelleRechnung.getRechnungsposten().remove(aktuelleRechnung.getRechnungsposten().size()-1);
			anzahlPosten--;
		}
	}
	
	
	public void zeigeBestehendeRechnungsdaten() {
		GUI.getTk1().getNeueGUIRechnung().getTextArea_Rechnung_Rechnung_Betreff().setText(aktuelleRechnung.getRechnungBetreff());
		GUI.getTk1().getNeueGUIRechnung().getTextField_Rechnung_Rechnung_Anrede().setText(aktuelleRechnung.getRechnungAnrede());
		GUI.getTk1().getNeueGUIRechnung().getTextArea_Rechnung_Rechnung_Anschreiben().setText(aktuelleRechnung.getRechnungAnschreiben());
		GUI.getTk1().getNeueGUIRechnung().getLbl_Rechnung_Summe_Netto_in_Euro().setText(geldformatierung.format(aktuelleRechnung.getRechnungSummeNetto()));
		GUI.getTk1().getNeueGUIRechnung().getLbl_Rechnung_Rechnung_Betrag_in_Euro().setText(geldformatierung.format(aktuelleRechnung.getRechnungEndbetrag()));
		for (int i = 0; i < aktuelleRechnung.getRechnungsposten().size(); i++) {
			rechnungspostenPanelHinzufügen(true);
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
		aktuelleRechnung.generiereRechnungsnummer(GUI.getTk1().getAktuellerKunde().getRechnungen().size());
		aktuelleRechnung.generiereRechnungsDateiName();
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl;
		sqlBefehl = sql.erstelleBefehl("INSERT", "rechnung", "rechnungBetreff", aktuelleRechnung.getRechnungBetreff(), "rechnungAnrede", aktuelleRechnung.getRechnungAnrede(), "rechnungAnschreiben", aktuelleRechnung.getRechnungAnschreiben(), "rechnungSummeNetto", aktuelleRechnung.getRechnungSummeNetto(), "rechnungEndbetrag", aktuelleRechnung.getRechnungEndbetrag(), "rechnungDatum", aktuelleRechnung.getRechnungDatum(), "rechnungNummer", aktuelleRechnung.getRechnungNummer(), "rechnungDateiName", aktuelleRechnung.getRechnungDateiName(), "kundeID", aktuelleRechnung.getKundeID());
		sql.datenbankÄnderung(sqlBefehl);
	}
													
	public void speicherePosten() {
		int rechnungspostenNummer;
		int rechnungspostenEinheit;
		String rechnungspostenBezeichnung;
		String rechnungspostenSatz;
		Double rechnungspostenBetrag;
		Double rechnungspostenGesamt;
		int rechnungspositionID;
		
		SQLAnbindung sql = new SQLAnbindung();
		String sqlBefehl = "";
		
		sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungID", "rechnung", "rechnungNummer", aktuelleRechnung.getRechnungNummer());
		aktuelleRechnung.setRechnungID(sql.holeIntAusDatenbank(sqlBefehl, "rechnungID"));
		
		for (int i = 0; i < aktuelleRechnung.getRechnungsposten().size(); i++) {
			rechnungspostenNummer = aktuelleRechnung.getRechnungsposten().get(i).getRechnungspostenNummer();
			rechnungspostenEinheit = aktuelleRechnung.getRechnungsposten().get(i).getRechnungspostenEinheiten();
			rechnungspostenBezeichnung = aktuelleRechnung.getRechnungsposten().get(i).getRechnungspositionName();
			rechnungspostenSatz = aktuelleRechnung.getRechnungsposten().get(i).getRechnungspostenSatz();
			rechnungspostenBetrag = aktuelleRechnung.getRechnungsposten().get(i).getRechnungspostenSatzEuro();
			rechnungspostenGesamt = aktuelleRechnung.getRechnungsposten().get(i).getRechnungspostenGesamtEuro();
			
			sqlBefehl = sql.erstelleBefehl("SELECT", "rechnungspositionID", "rechnungsposition", "rechnungspositionName", rechnungspostenBezeichnung);
			rechnungspositionID = sql.holeIntAusDatenbank(sqlBefehl, "rechnungspositionID");
			
			sqlBefehl = sql.erstelleBefehl("INSERT", "rechnungsposten", "rechnungID", aktuelleRechnung.getRechnungID(), "rechnungspositionID", rechnungspositionID, "rechnungspostenNummer", rechnungspostenNummer, "rechnungspostenEinheit", rechnungspostenEinheit, "rechnungspostenSatz", rechnungspostenSatz, "rechnungspostenBetrag", rechnungspostenBetrag, "rechnungspostenGesamt", rechnungspostenGesamt);
			sql.datenbankÄnderung(sqlBefehl);		
		}
	}
	

	public void berechneSummen() {
		Berechnung br = new Berechnung();
		br.berechneRechnungspositionsSumme();
		br.berechneGesamtSumme();
		aktualisiereEndbetrage();
	}
	
	public void aktualisiereEndbetrage() {
		GUI.getTk1().getNeueGUIRechnung().getLbl_Rechnung_Summe_Netto_in_Euro().setText(geldformatierung.format(aktuelleRechnung.getRechnungSummeNetto()));
		GUI.getTk1().getNeueGUIRechnung().getLbl_Rechnung_Rechnung_Betrag_in_Euro().setText(geldformatierung.format(aktuelleRechnung.getRechnungEndbetrag()));
	}
	
	public void aktualisierePostenFelder() {
		for (int i = 0; i < postenPanel.size(); i++) {
			ArrayList<Object> tempArray = postenPanel.get(i);
			JPanel postenPanel = (JPanel) tempArray.get(0);
			JTextField einheiten = (JTextField) postenPanel.getComponent(3);
			JTextField satzEuro = (JTextField) postenPanel.getComponent(4);
			einheiten.setText(String.valueOf(aktuelleRechnung.getRechnungsposten().get(i).getRechnungspostenEinheiten()));
			satzEuro.setText(geldformatierung.format(aktuelleRechnung.getRechnungsposten().get(i).getRechnungspostenSatzEuro()));	
		
		}
	}
	
	
	public boolean sicherheitsabfrage() {
		boolean ausgabe;
		// <html><center>"Das Speichern einer Rechnung ist ein amtliches Dokument.<br>Haben Sie ihre Eingaben überprüft und sind sich sicher, dass sie dieses Dokument erstellen möchten?"</center></html>
		// "Das Speichern einer Rechnung ist ein amtliches Dokument. \nHaben Sie ihre Eingaben überprüft und sind sich sicher, dass sie dieses Dokument erstellen möchten?"
		int bestätigung = JOptionPane.showConfirmDialog(null, "<html><center>Das Speichern einer Rechnung ist ein amtliches Dokument.<br>Haben Sie ihre Eingaben überprüft und sind sich sicher, dass sie dieses Dokument erstellen möchten?</center></html>", "Achtung", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (bestätigung == 0) {
			ausgabe = true;
		}else {
			ausgabe = false;
		}
		return ausgabe;
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
