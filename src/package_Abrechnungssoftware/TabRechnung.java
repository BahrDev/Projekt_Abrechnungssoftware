package package_Abrechnungssoftware;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TabRechnung {
	
	// Attribute
	
	private String betreff;
	private String anrede;
	private String anschreiben;
	private ArrayList<Rechnungsposten> rechnungspositionen = new ArrayList<Rechnungsposten>();
	private double summeNetto;
	private double rechnungsbetrag;
	private Date rechnungsDatum;
	
	// Konstruktoren
	
	// Methoden
	public ArrayList<Object> rechnungspostenHinzufügen(Integer PostenNummer) {
		ArrayList<Object> panel = new ArrayList<Object>();
		
		JPanel panel_Rechnung_Posten_Posten = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Posten = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Posten.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Rechnung_Posten_Posten.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Posten_Posten.gridx = 0;
		gbc_panel_Rechnung_Posten_Posten.gridy = PostenNummer;
		//panel_Rechnung_Posten_sub.add(panel_Rechnung_Posten_Posten, gbc_panel_Rechnung_Posten_Posten);
		GridBagLayout gbl_panel_Rechnung_Posten_Posten = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Posten.columnWidths = new int[]{0, 30, 15, 250, 25, 100, 25, 60, 25, 110, 25, 110, 20, 0};
		gbl_panel_Rechnung_Posten_Posten.rowHeights = new int[]{0, 0};
		gbl_panel_Rechnung_Posten_Posten.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Posten_Posten.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_Rechnung_Posten_Posten.setLayout(gbl_panel_Rechnung_Posten_Posten);
		
		JLabel lbl_Rechnung_Posten_Nr = new JLabel(PostenNummer.toString());
		lbl_Rechnung_Posten_Nr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Nr = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Nr.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Posten_Nr.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Nr.gridx = 1;
		gbc_lbl_Rechnung_Posten_Nr.gridy = PostenNummer;
		panel_Rechnung_Posten_Posten.add(lbl_Rechnung_Posten_Nr, gbc_lbl_Rechnung_Posten_Nr);
		
		JComboBox comboBox_Rechnung_Posten_Bezeichnung = new JComboBox();
		comboBox_Rechnung_Posten_Bezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox_Rechnung_Posten_Bezeichnung = new GridBagConstraints();
		gbc_comboBox_Rechnung_Posten_Bezeichnung.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_Rechnung_Posten_Bezeichnung.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Rechnung_Posten_Bezeichnung.gridx = 3;
		gbc_comboBox_Rechnung_Posten_Bezeichnung.gridy = PostenNummer;
		panel_Rechnung_Posten_Posten.add(comboBox_Rechnung_Posten_Bezeichnung, gbc_comboBox_Rechnung_Posten_Bezeichnung);
		
		JLabel lbl_Rechnung_Posten_Satz = new JLabel("Stundensatz");
		lbl_Rechnung_Posten_Satz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Satz = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Satz.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Posten_Satz.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Satz.gridx = 5;
		gbc_lbl_Rechnung_Posten_Satz.gridy = PostenNummer;
		panel_Rechnung_Posten_Posten.add(lbl_Rechnung_Posten_Satz, gbc_lbl_Rechnung_Posten_Satz);
		
		JTextField textField_Rechnung_Posten_Einheiten = new JTextField();
		textField_Rechnung_Posten_Einheiten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textField_Rechnung_Posten_Einheiten = new GridBagConstraints();
		gbc_textField_Rechnung_Posten_Einheiten.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Rechnung_Posten_Einheiten.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Posten_Einheiten.gridx = 7;
		gbc_textField_Rechnung_Posten_Einheiten.gridy = PostenNummer;
		panel_Rechnung_Posten_Posten.add(textField_Rechnung_Posten_Einheiten, gbc_textField_Rechnung_Posten_Einheiten);
		textField_Rechnung_Posten_Einheiten.setColumns(10);
		
		JTextField textField_Rechnung_Posten_Satz_in_Euro = new JTextField();
		textField_Rechnung_Posten_Satz_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textField_Rechnung_Posten_Satz_in_Euro = new GridBagConstraints();
		gbc_textField_Rechnung_Posten_Satz_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Rechnung_Posten_Satz_in_Euro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Posten_Satz_in_Euro.gridx = 9;
		gbc_textField_Rechnung_Posten_Satz_in_Euro.gridy = PostenNummer;
		panel_Rechnung_Posten_Posten.add(textField_Rechnung_Posten_Satz_in_Euro, gbc_textField_Rechnung_Posten_Satz_in_Euro);
		textField_Rechnung_Posten_Satz_in_Euro.setColumns(10);
		
		JLabel lbl_Rechnung_Posten_Gesamt_in_Euro = new JLabel("0,00\u20AC");
		lbl_Rechnung_Posten_Gesamt_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Gesamt_in_Euro = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro.anchor = GridBagConstraints.EAST;
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro.gridx = 11;
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro.gridy = PostenNummer;
		panel_Rechnung_Posten_Posten.add(lbl_Rechnung_Posten_Gesamt_in_Euro, gbc_lbl_Rechnung_Posten_Gesamt_in_Euro);
		
		// --------------------------------------------------------------------------------------------------------------
		panel.add(panel_Rechnung_Posten_Posten);
		panel.add(gbc_panel_Rechnung_Posten_Posten);
		return panel;
	}
	
	
	public void rechnungspostenEntfernen() {
		
	}
	
	public void speichern() {
		
	}
	
	public void drucken() {
		
	}
	
	// Getter/Setter
}
