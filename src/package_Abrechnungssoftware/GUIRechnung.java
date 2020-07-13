package package_Abrechnungssoftware;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUIRechnung {

	// Attribute
	private static NumberFormat geldformatierung = new DecimalFormat("0.00");

	// Initialisierung der GUI-Elemente zum externen Ansprechen/Abgreifen
	private JTextField textField_Rechnung_Posten_Einheiten_1;
	private JTextField textField_Rechnung_Posten_Satz_in_Euro_1;
	private JTextField textField_Rechnung_Posten_Einheiten_2;
	private JTextField textField_Rechnung_Posten_Satz_in_Euro_2;
	private JFrame frame_Rechnung;
	private JLabel lbl_Rechnung_Kunden_Name;
	private JLabel lbl_Rechnung_Kunden_Strasse;
	private JLabel lbl_Rechnung_Rechnung_PLZ_Stadt;
	private JTextArea textArea_Rechnung_Rechnung_Betreff;
	private JTextField textField_Rechnung_Rechnung_Anrede;
	private JTextArea textArea_Rechnung_Rechnung_Anschreiben;
	private JButton btn_Rechnung_Rechnung_Speichern;
	private JButton btn_Rechnung_Rechnung_Drucken;
	private JLabel lbl_Rechnung_Summe_Netto_in_Euro;
	private JLabel lbl_Rechnung_Rechnung_Betrag_in_Euro;
	private JButton btn_Rechnung_Posten_Plus;
	private JButton btn_Rechnung_Posten_Minus;
	private JPanel panel_Rechnung_Posten_Innen_Posten;
	private JPanel panel_Rechnung_Posten_Innen_Gesamt;
	private JScrollPane scrollPane_Rechnung_Posten_Innen;
	private JPanel panel_Rechnung_Posten_Aussen;
	private TabRechnung tr1;
	private double Rechnung_Summe_Netto_in_Euro;
	private double Rechnung_Rechnung_Betrag_in_Euro;

	// Konstruktor

	public GUIRechnung(boolean neueRechnung, Integer rechnungID) {
		this.tr1 = new TabRechnung(neueRechnung, rechnungID);
	}

	// Methoden

	/**
	 * Einstiegspunkt für den Window-Builder Ist nicht programmrelevant aber
	 * notwendig für änderungen an der GUI
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void fensterRechnung() {
		frame_Rechnung = new JFrame();
		frame_Rechnung.setVisible(true);
		frame_Rechnung.setResizable(false);
		frame_Rechnung.toFront();
		frame_Rechnung.setTitle("Rechnung");
		frame_Rechnung.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame_Rechnung.setBounds(100, 100, 1000, 1000);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 25, 100, 25, 0 };
		gridBagLayout.rowHeights = new int[] { 25, 0, 0, 50, 0, 0, 0, 0, 0, 200, 0, 0, 25, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frame_Rechnung.getContentPane().setLayout(gridBagLayout);

		JPanel panel_Rechnung_Kunden_Daten = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Kunden_Daten = new GridBagConstraints();
		gbc_panel_Rechnung_Kunden_Daten.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panel_Rechnung_Kunden_Daten.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Kunden_Daten.gridx = 1;
		gbc_panel_Rechnung_Kunden_Daten.gridy = 1;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Kunden_Daten, gbc_panel_Rechnung_Kunden_Daten);
		GridBagLayout gbl_panel_Rechnung_Kunden_Daten = new GridBagLayout();
		gbl_panel_Rechnung_Kunden_Daten.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_Rechnung_Kunden_Daten.rowHeights = new int[] { 20, 0, 10, 0, 10, 0, 20, 0 };
		gbl_panel_Rechnung_Kunden_Daten.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Rechnung_Kunden_Daten.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_Rechnung_Kunden_Daten.setLayout(gbl_panel_Rechnung_Kunden_Daten);

		lbl_Rechnung_Kunden_Name = new JLabel("KundenName");
		lbl_Rechnung_Kunden_Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Kunden_Name = new GridBagConstraints();
		gbc_lbl_Rechnung_Kunden_Name.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Kunden_Name.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_Rechnung_Kunden_Name.gridx = 1;
		gbc_lbl_Rechnung_Kunden_Name.gridy = 1;
		panel_Rechnung_Kunden_Daten.add(lbl_Rechnung_Kunden_Name, gbc_lbl_Rechnung_Kunden_Name);

		lbl_Rechnung_Kunden_Strasse = new JLabel("KundenStra\u00DFe");
		lbl_Rechnung_Kunden_Strasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Kunden_Strasse = new GridBagConstraints();
		gbc_lbl_Rechnung_Kunden_Strasse.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Kunden_Strasse.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_Rechnung_Kunden_Strasse.gridx = 1;
		gbc_lbl_Rechnung_Kunden_Strasse.gridy = 3;
		panel_Rechnung_Kunden_Daten.add(lbl_Rechnung_Kunden_Strasse, gbc_lbl_Rechnung_Kunden_Strasse);

		lbl_Rechnung_Rechnung_PLZ_Stadt = new JLabel("KundePLZ/Stadt");
		lbl_Rechnung_Rechnung_PLZ_Stadt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_PLZ_Stadt = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_PLZ_Stadt.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_Rechnung_Rechnung_PLZ_Stadt.gridx = 1;
		gbc_lbl_Rechnung_Rechnung_PLZ_Stadt.gridy = 5;
		panel_Rechnung_Kunden_Daten.add(lbl_Rechnung_Rechnung_PLZ_Stadt, gbc_lbl_Rechnung_Rechnung_PLZ_Stadt);

		JLabel lbl_Rechnung_Rechnung_Betreff = new JLabel("Betreff");
		lbl_Rechnung_Rechnung_Betreff.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Betreff = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Betreff.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Rechnung_Betreff.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Rechnung_Rechnung_Betreff.gridx = 1;
		gbc_lbl_Rechnung_Rechnung_Betreff.gridy = 2;
		frame_Rechnung.getContentPane().add(lbl_Rechnung_Rechnung_Betreff, gbc_lbl_Rechnung_Rechnung_Betreff);

		textArea_Rechnung_Rechnung_Betreff = new JTextArea();
		textArea_Rechnung_Rechnung_Betreff.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea_Rechnung_Rechnung_Betreff.setPreferredSize(new Dimension(575, 75));
		textArea_Rechnung_Rechnung_Betreff.setMinimumSize(new Dimension(575, 75));
		textArea_Rechnung_Rechnung_Betreff.setMaximumSize(new Dimension(575, 75));
		GridBagConstraints gbc_textArea_Rechnung_Rechnung_Betreff = new GridBagConstraints();
		gbc_textArea_Rechnung_Rechnung_Betreff.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_Rechnung_Rechnung_Betreff.fill = GridBagConstraints.BOTH;
		gbc_textArea_Rechnung_Rechnung_Betreff.gridx = 1;
		gbc_textArea_Rechnung_Rechnung_Betreff.gridy = 3;
		frame_Rechnung.getContentPane().add(textArea_Rechnung_Rechnung_Betreff, gbc_textArea_Rechnung_Rechnung_Betreff);

		JLabel lbl_Rechnung_Rechnung_Anrede = new JLabel("Anrede");
		lbl_Rechnung_Rechnung_Anrede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Anrede = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Anrede.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Rechnung_Anrede.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Rechnung_Rechnung_Anrede.gridx = 1;
		gbc_lbl_Rechnung_Rechnung_Anrede.gridy = 4;
		frame_Rechnung.getContentPane().add(lbl_Rechnung_Rechnung_Anrede, gbc_lbl_Rechnung_Rechnung_Anrede);

		textField_Rechnung_Rechnung_Anrede = new JTextField();
		textField_Rechnung_Rechnung_Anrede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_Rechnung_Rechnung_Anrede.setPreferredSize(new Dimension(575, 25));
		textField_Rechnung_Rechnung_Anrede.setMinimumSize(new Dimension(575, 25));
		textField_Rechnung_Rechnung_Anrede.setMaximumSize(new Dimension(575, 25));
		GridBagConstraints gbc_textField_Rechnung_Rechnung_Anrede = new GridBagConstraints();
		gbc_textField_Rechnung_Rechnung_Anrede.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Rechnung_Anrede.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Rechnung_Rechnung_Anrede.gridx = 1;
		gbc_textField_Rechnung_Rechnung_Anrede.gridy = 5;
		frame_Rechnung.getContentPane().add(textField_Rechnung_Rechnung_Anrede, gbc_textField_Rechnung_Rechnung_Anrede);
		textField_Rechnung_Rechnung_Anrede.setColumns(10);

		JLabel lbl_Rechnung_Rechnung_Anschreiben = new JLabel("Anschreiben");
		lbl_Rechnung_Rechnung_Anschreiben.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Anschreiben = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Anschreiben.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Rechnung_Anschreiben.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Rechnung_Rechnung_Anschreiben.gridx = 1;
		gbc_lbl_Rechnung_Rechnung_Anschreiben.gridy = 6;
		frame_Rechnung.getContentPane().add(lbl_Rechnung_Rechnung_Anschreiben, gbc_lbl_Rechnung_Rechnung_Anschreiben);

		JPanel panel_Rechnung_Anschreiben = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Anschreiben = new GridBagConstraints();
		gbc_panel_Rechnung_Anschreiben.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Anschreiben.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Anschreiben.gridx = 1;
		gbc_panel_Rechnung_Anschreiben.gridy = 7;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Anschreiben, gbc_panel_Rechnung_Anschreiben);
		GridBagLayout gbl_panel_Rechnung_Anschreiben = new GridBagLayout();
		gbl_panel_Rechnung_Anschreiben.columnWidths = new int[] { 100, 0 };
		gbl_panel_Rechnung_Anschreiben.rowHeights = new int[] { 0, 0 };
		gbl_panel_Rechnung_Anschreiben.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_Rechnung_Anschreiben.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_Rechnung_Anschreiben.setLayout(gbl_panel_Rechnung_Anschreiben);

		textArea_Rechnung_Rechnung_Anschreiben = new JTextArea();
		textArea_Rechnung_Rechnung_Anschreiben.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea_Rechnung_Rechnung_Anschreiben.setMinimumSize(new Dimension(575, 130));
		textArea_Rechnung_Rechnung_Anschreiben.setMaximumSize(new Dimension(575, 130));
		textArea_Rechnung_Rechnung_Anschreiben.setPreferredSize(new Dimension(575, 130));
		GridBagConstraints gbc_textArea_Rechnung_Rechnung_Anschreiben = new GridBagConstraints();
		gbc_textArea_Rechnung_Rechnung_Anschreiben.fill = GridBagConstraints.BOTH;
		gbc_textArea_Rechnung_Rechnung_Anschreiben.gridx = 0;
		gbc_textArea_Rechnung_Rechnung_Anschreiben.gridy = 0;
		panel_Rechnung_Anschreiben.add(textArea_Rechnung_Rechnung_Anschreiben,
				gbc_textArea_Rechnung_Rechnung_Anschreiben);

		JPanel panel_Rechnung_Posten_Überschrift = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Überschrift = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Überschrift.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Rechnung_Posten_Überschrift.anchor = GridBagConstraints.SOUTH;
		gbc_panel_Rechnung_Posten_Überschrift.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Posten_Überschrift.gridx = 1;
		gbc_panel_Rechnung_Posten_Überschrift.gridy = 8;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Posten_Überschrift, gbc_panel_Rechnung_Posten_Überschrift);
		GridBagLayout gbl_panel_Rechnung_Posten_Überschrift = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Überschrift.columnWidths = new int[] { 0, 30, 15, 265, 25, 100, 25, 140, 25, 140, 25,
				110, 20, 0 };
		gbl_panel_Rechnung_Posten_Überschrift.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_Rechnung_Posten_Überschrift.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Rechnung_Posten_Überschrift.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_Rechnung_Posten_Überschrift.setLayout(gbl_panel_Rechnung_Posten_Überschrift);

		JLabel lbl_Rechnung_Rechnung_Nr = new JLabel("Nr.");
		lbl_Rechnung_Rechnung_Nr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Nr = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Nr.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Rechnung_Nr.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Rechnung_Nr.gridx = 1;
		gbc_lbl_Rechnung_Rechnung_Nr.gridy = 1;
		panel_Rechnung_Posten_Überschrift.add(lbl_Rechnung_Rechnung_Nr, gbc_lbl_Rechnung_Rechnung_Nr);

		JLabel lbl_Rechnung_Rechnung_Bezeichnung = new JLabel("Bezeichnung");
		lbl_Rechnung_Rechnung_Bezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Bezeichnung = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Bezeichnung.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Rechnung_Bezeichnung.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Rechnung_Bezeichnung.gridx = 3;
		gbc_lbl_Rechnung_Rechnung_Bezeichnung.gridy = 1;
		panel_Rechnung_Posten_Überschrift.add(lbl_Rechnung_Rechnung_Bezeichnung, gbc_lbl_Rechnung_Rechnung_Bezeichnung);

		JLabel lbl_Rechnung_Rechnung_Satz = new JLabel("Satz");
		lbl_Rechnung_Rechnung_Satz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Satz = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Satz.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Rechnung_Satz.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Rechnung_Satz.gridx = 5;
		gbc_lbl_Rechnung_Rechnung_Satz.gridy = 1;
		panel_Rechnung_Posten_Überschrift.add(lbl_Rechnung_Rechnung_Satz, gbc_lbl_Rechnung_Rechnung_Satz);

		JLabel lbl_Rechnung_Rechnung_Einheiten = new JLabel("Einheiten");
		lbl_Rechnung_Rechnung_Einheiten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Einheiten = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Einheiten.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Rechnung_Einheiten.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Rechnung_Einheiten.gridx = 7;
		gbc_lbl_Rechnung_Rechnung_Einheiten.gridy = 1;
		panel_Rechnung_Posten_Überschrift.add(lbl_Rechnung_Rechnung_Einheiten, gbc_lbl_Rechnung_Rechnung_Einheiten);

		JLabel lbl_Rechnungen_Rechnung_Satz_in_Euro = new JLabel("Satz/\u20AC");
		lbl_Rechnungen_Rechnung_Satz_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnungen_Rechnung_Satz_in_Euro = new GridBagConstraints();
		gbc_lbl_Rechnungen_Rechnung_Satz_in_Euro.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnungen_Rechnung_Satz_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnungen_Rechnung_Satz_in_Euro.gridx = 9;
		gbc_lbl_Rechnungen_Rechnung_Satz_in_Euro.gridy = 1;
		panel_Rechnung_Posten_Überschrift.add(lbl_Rechnungen_Rechnung_Satz_in_Euro,
				gbc_lbl_Rechnungen_Rechnung_Satz_in_Euro);

		JLabel lbl_Rechnung_rechnung_Gesamt_in_Euro = new JLabel("Gesamt/\u20AC");
		lbl_Rechnung_rechnung_Gesamt_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro = new GridBagConstraints();
		gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro.anchor = GridBagConstraints.EAST;
		gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro.gridx = 11;
		gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro.gridy = 1;
		panel_Rechnung_Posten_Überschrift.add(lbl_Rechnung_rechnung_Gesamt_in_Euro,
				gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro);

		panel_Rechnung_Posten_Aussen = new JPanel();
		panel_Rechnung_Posten_Aussen.setPreferredSize(new Dimension(575, 150));
		panel_Rechnung_Posten_Aussen.setMinimumSize(new Dimension(575, 150));
		panel_Rechnung_Posten_Aussen.setMaximumSize(new Dimension(575, 150));
		GridBagConstraints gbc_panel_Rechnung_Posten_Aussen = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Aussen.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Posten_Aussen.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Posten_Aussen.gridx = 1;
		gbc_panel_Rechnung_Posten_Aussen.gridy = 9;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Posten_Aussen, gbc_panel_Rechnung_Posten_Aussen);
		GridBagLayout gbl_panel_Rechnung_Posten_Aussen = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Aussen.columnWidths = new int[] { 0, 0 };
		gbl_panel_Rechnung_Posten_Aussen.rowHeights = new int[] { 0, 0 };
		gbl_panel_Rechnung_Posten_Aussen.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_Rechnung_Posten_Aussen.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_Rechnung_Posten_Aussen.setLayout(gbl_panel_Rechnung_Posten_Aussen);

		scrollPane_Rechnung_Posten_Innen = new JScrollPane();
		scrollPane_Rechnung_Posten_Innen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_Rechnung_Posten_Innen.getVerticalScrollBar().setUnitIncrement(10);
		GridBagConstraints gbc_scrollPane_Rechnung_Posten_Innen = new GridBagConstraints();
		gbc_scrollPane_Rechnung_Posten_Innen.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_Rechnung_Posten_Innen.gridx = 0;
		gbc_scrollPane_Rechnung_Posten_Innen.gridy = 0;
		panel_Rechnung_Posten_Aussen.add(scrollPane_Rechnung_Posten_Innen, gbc_scrollPane_Rechnung_Posten_Innen);

		panel_Rechnung_Posten_Innen_Gesamt = new JPanel();
		scrollPane_Rechnung_Posten_Innen.setViewportView(panel_Rechnung_Posten_Innen_Gesamt);
		GridBagLayout gbl_panel_Rechnung_Posten_Innen_Gesamt = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Innen_Gesamt.columnWidths = new int[] { 0, 0 };
		gbl_panel_Rechnung_Posten_Innen_Gesamt.rowHeights = new int[] { 0, 60, 0 };
		gbl_panel_Rechnung_Posten_Innen_Gesamt.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_Rechnung_Posten_Innen_Gesamt.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_Rechnung_Posten_Innen_Gesamt.setLayout(gbl_panel_Rechnung_Posten_Innen_Gesamt);

		panel_Rechnung_Posten_Innen_Posten = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Innen_Posten = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Innen_Posten.anchor = GridBagConstraints.NORTH;
		gbc_panel_Rechnung_Posten_Innen_Posten.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Rechnung_Posten_Innen_Posten.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Rechnung_Posten_Innen_Posten.gridx = 0;
		gbc_panel_Rechnung_Posten_Innen_Posten.gridy = 0;
		panel_Rechnung_Posten_Innen_Gesamt.add(panel_Rechnung_Posten_Innen_Posten,
				gbc_panel_Rechnung_Posten_Innen_Posten);
		GridBagLayout gbl_panel_Rechnung_Posten_Innen_Posten = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Innen_Posten.columnWidths = new int[] { 0 };
		gbl_panel_Rechnung_Posten_Innen_Posten.rowHeights = new int[] { 0 };
		gbl_panel_Rechnung_Posten_Innen_Posten.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel_Rechnung_Posten_Innen_Posten.rowWeights = new double[] { Double.MIN_VALUE };
		panel_Rechnung_Posten_Innen_Posten.setLayout(gbl_panel_Rechnung_Posten_Innen_Posten);

		JPanel panel_Rechnung_Posten_Innen_Buttons = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Innen_Buttons = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Innen_Buttons.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Posten_Innen_Buttons.gridx = 0;
		gbc_panel_Rechnung_Posten_Innen_Buttons.gridy = 1;
		panel_Rechnung_Posten_Innen_Gesamt.add(panel_Rechnung_Posten_Innen_Buttons,
				gbc_panel_Rechnung_Posten_Innen_Buttons);
		GridBagLayout gbl_panel_Rechnung_Posten_Innen_Buttons = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Innen_Buttons.columnWidths = new int[] { 10, 0, 10, 0, 0 };
		gbl_panel_Rechnung_Posten_Innen_Buttons.rowHeights = new int[] { 0, 0 };
		gbl_panel_Rechnung_Posten_Innen_Buttons.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Rechnung_Posten_Innen_Buttons.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_Rechnung_Posten_Innen_Buttons.setLayout(gbl_panel_Rechnung_Posten_Innen_Buttons);

		btn_Rechnung_Posten_Plus = new JButton("+");
		btn_Rechnung_Posten_Plus.setPreferredSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Plus.setMinimumSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Plus.setMaximumSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Plus.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_btn_Rechnung_Posten_Plus = new GridBagConstraints();
		gbc_btn_Rechnung_Posten_Plus.insets = new Insets(0, 0, 0, 5);
		gbc_btn_Rechnung_Posten_Plus.gridx = 1;
		gbc_btn_Rechnung_Posten_Plus.gridy = 0;
		panel_Rechnung_Posten_Innen_Buttons.add(btn_Rechnung_Posten_Plus, gbc_btn_Rechnung_Posten_Plus);

		btn_Rechnung_Posten_Minus = new JButton("-");
		btn_Rechnung_Posten_Minus.setPreferredSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Minus.setMinimumSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Minus.setMaximumSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Minus.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_btn_Rechnung_Posten_Minus = new GridBagConstraints();
		gbc_btn_Rechnung_Posten_Minus.gridx = 3;
		gbc_btn_Rechnung_Posten_Minus.gridy = 0;
		panel_Rechnung_Posten_Innen_Buttons.add(btn_Rechnung_Posten_Minus, gbc_btn_Rechnung_Posten_Minus);

		JPanel panel_Rechnung_Summe = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Summe = new GridBagConstraints();
		gbc_panel_Rechnung_Summe.anchor = GridBagConstraints.EAST;
		gbc_panel_Rechnung_Summe.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Summe.gridx = 1;
		gbc_panel_Rechnung_Summe.gridy = 10;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Summe, gbc_panel_Rechnung_Summe);
		GridBagLayout gbl_panel_Rechnung_Summe = new GridBagLayout();
		gbl_panel_Rechnung_Summe.columnWidths = new int[] { 25, 0, 25, 120, 20, 0 };
		gbl_panel_Rechnung_Summe.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_Rechnung_Summe.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Rechnung_Summe.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_Rechnung_Summe.setLayout(gbl_panel_Rechnung_Summe);

		JLabel lbl_Rechnung_Summe_Netto = new JLabel("Summe Netto: ");
		lbl_Rechnung_Summe_Netto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Summe_Netto = new GridBagConstraints();
		gbc_lbl_Rechnung_Summe_Netto.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Summe_Netto.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Rechnung_Summe_Netto.gridx = 1;
		gbc_lbl_Rechnung_Summe_Netto.gridy = 0;
		panel_Rechnung_Summe.add(lbl_Rechnung_Summe_Netto, gbc_lbl_Rechnung_Summe_Netto);

		lbl_Rechnung_Summe_Netto_in_Euro = new JLabel("0,00\u20AC");
		lbl_Rechnung_Summe_Netto_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Summe_Netto_in_Euro = new GridBagConstraints();
		gbc_lbl_Rechnung_Summe_Netto_in_Euro.anchor = GridBagConstraints.EAST;
		gbc_lbl_Rechnung_Summe_Netto_in_Euro.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Rechnung_Summe_Netto_in_Euro.gridx = 3;
		gbc_lbl_Rechnung_Summe_Netto_in_Euro.gridy = 0;
		panel_Rechnung_Summe.add(lbl_Rechnung_Summe_Netto_in_Euro, gbc_lbl_Rechnung_Summe_Netto_in_Euro);

		JLabel lbl_Rechnung_Rechnung_Betrag = new JLabel("Rechnungsbetrag: ");
		lbl_Rechnung_Rechnung_Betrag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Betrag = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Betrag.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Rechnung_Betrag.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Rechnung_Betrag.gridx = 1;
		gbc_lbl_Rechnung_Rechnung_Betrag.gridy = 1;
		panel_Rechnung_Summe.add(lbl_Rechnung_Rechnung_Betrag, gbc_lbl_Rechnung_Rechnung_Betrag);

		lbl_Rechnung_Rechnung_Betrag_in_Euro = new JLabel("0.00\u20AC");
		lbl_Rechnung_Rechnung_Betrag_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Rechnung_Betrag_in_Euro = new GridBagConstraints();
		gbc_lbl_Rechnung_Rechnung_Betrag_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Rechnung_Betrag_in_Euro.anchor = GridBagConstraints.EAST;
		gbc_lbl_Rechnung_Rechnung_Betrag_in_Euro.gridx = 3;
		gbc_lbl_Rechnung_Rechnung_Betrag_in_Euro.gridy = 1;
		panel_Rechnung_Summe.add(lbl_Rechnung_Rechnung_Betrag_in_Euro, gbc_lbl_Rechnung_Rechnung_Betrag_in_Euro);

		JPanel panel_Rechnung_Speichern_Buttons = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Speichern_Buttons = new GridBagConstraints();
		gbc_panel_Rechnung_Speichern_Buttons.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Speichern_Buttons.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Speichern_Buttons.gridx = 1;
		gbc_panel_Rechnung_Speichern_Buttons.gridy = 11;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Speichern_Buttons, gbc_panel_Rechnung_Speichern_Buttons);
		GridBagLayout gbl_panel_Rechnung_Speichern_Buttons = new GridBagLayout();
		gbl_panel_Rechnung_Speichern_Buttons.columnWidths = new int[] { 0, 25, 0, 0 };
		gbl_panel_Rechnung_Speichern_Buttons.rowHeights = new int[] { 0, 0 };
		gbl_panel_Rechnung_Speichern_Buttons.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Rechnung_Speichern_Buttons.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_Rechnung_Speichern_Buttons.setLayout(gbl_panel_Rechnung_Speichern_Buttons);

		btn_Rechnung_Rechnung_Speichern = new JButton("Speichern");
		btn_Rechnung_Rechnung_Speichern.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Rechnung_Rechnung_Speichern.setPreferredSize(new Dimension(130, 25));
		btn_Rechnung_Rechnung_Speichern.setMinimumSize(new Dimension(130, 25));
		btn_Rechnung_Rechnung_Speichern.setMaximumSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Rechnung_Rechnung_Speichern = new GridBagConstraints();
		gbc_btn_Rechnung_Rechnung_Speichern.insets = new Insets(0, 0, 0, 5);
		gbc_btn_Rechnung_Rechnung_Speichern.gridx = 0;
		gbc_btn_Rechnung_Rechnung_Speichern.gridy = 0;
		panel_Rechnung_Speichern_Buttons.add(btn_Rechnung_Rechnung_Speichern, gbc_btn_Rechnung_Rechnung_Speichern);

		JPanel panel_Rechnung_Abstandshalter_1 = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Abstandshalter_1 = new GridBagConstraints();
		gbc_panel_Rechnung_Abstandshalter_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_Rechnung_Abstandshalter_1.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Abstandshalter_1.gridx = 1;
		gbc_panel_Rechnung_Abstandshalter_1.gridy = 0;
		panel_Rechnung_Speichern_Buttons.add(panel_Rechnung_Abstandshalter_1, gbc_panel_Rechnung_Abstandshalter_1);

		btn_Rechnung_Rechnung_Drucken = new JButton("Speichern und Drucken");
		btn_Rechnung_Rechnung_Drucken.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Rechnung_Rechnung_Drucken.setPreferredSize(new Dimension(230, 25));
		btn_Rechnung_Rechnung_Drucken.setMinimumSize(new Dimension(230, 25));
		btn_Rechnung_Rechnung_Drucken.setMaximumSize(new Dimension(230, 25));
		GridBagConstraints gbc_btn_Rechnung_Rechnung_Drucken = new GridBagConstraints();
		gbc_btn_Rechnung_Rechnung_Drucken.gridx = 2;
		gbc_btn_Rechnung_Rechnung_Drucken.gridy = 0;
		panel_Rechnung_Speichern_Buttons.add(btn_Rechnung_Rechnung_Drucken, gbc_btn_Rechnung_Rechnung_Drucken);

		// ButtonListener hinzufügen
		buttonActionListenerHinzufügen();
		documentListenerHinzufügen();
	}

	// Button-Methoden
	public void buttonActionListenerHinzufügen() {
		btn_Rechnung_Posten_Plus_ActionListener();
		btn_Rechnung_Posten_Minus_ActionListener();
		btn_Rechnung_Rechnung_Speichern_ActionListener();
		btn_Rechnung_Rechnung_Drucken_ActionListener();

	}

	public void btn_Rechnung_Posten_Plus_ActionListener() {
		btn_Rechnung_Posten_Plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tr1.rechnungspostenPanelHinzufügen(false);
				tr1.aktualisierePostenFelder();
				fensterAktualisieren();
			}
		});
	}

	public void btn_Rechnung_Posten_Minus_ActionListener() {
		btn_Rechnung_Posten_Minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tr1.rechnungspostenPanelEntfernen();
				tr1.aktualisierePostenFelder();
				fensterAktualisieren();
			}
		});
	}

	public void btn_Rechnung_Rechnung_Speichern_ActionListener() {
		btn_Rechnung_Rechnung_Speichern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tr1.sicherheitsabfrage()) {
					fensterAktualisieren();

					tr1.speichern();

					DateiGenerierung dateiGenerierung = new DateiGenerierung();
					try {
						dateiGenerierung.generierePDFAusVorlage(false);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					GUI.getTk1().ladeRechnungen();
					frame_Rechnung.dispose();
				}
			}
		});
	}

	public void btn_Rechnung_Rechnung_Drucken_ActionListener() { // Druckfunktion fehlt
		btn_Rechnung_Rechnung_Drucken.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tr1.sicherheitsabfrage()) {
					fensterAktualisieren();

					DateiGenerierung dateiGenerierung = new DateiGenerierung();
					try {
						dateiGenerierung.generierePDFAusVorlage(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					tr1.speichern();
					frame_Rechnung.dispose();
				}

			}
		});
	}

	// DocumentListener-Methoden
	public void documentListenerHinzufügen() {
		textArea_Rechnung_Rechnung_Betreff_DocumentListener();
		textField_Rechnung_Rechnung_Anrede_DocumentListener();
		textArea_Rechnung_Rechnung_Anschreiben_DocumentListener();
	}

	public void textArea_Rechnung_Rechnung_Betreff_DocumentListener() {
		textArea_Rechnung_Rechnung_Betreff.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				tr1.getAktuelleRechnung().setRechnungBetreff(textArea_Rechnung_Rechnung_Betreff.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				tr1.getAktuelleRechnung().setRechnungBetreff(textArea_Rechnung_Rechnung_Betreff.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
	}

	public void textField_Rechnung_Rechnung_Anrede_DocumentListener() {
		textField_Rechnung_Rechnung_Anrede.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				tr1.getAktuelleRechnung().setRechnungAnrede(textField_Rechnung_Rechnung_Anrede.getText());
				// tr1.getAktuelleRechnung().setWurdeVerändert(true);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				tr1.getAktuelleRechnung().setRechnungAnrede(textField_Rechnung_Rechnung_Anrede.getText());
				// tr1.getAktuelleRechnung().setWurdeVerändert(true);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
	}

	public void textArea_Rechnung_Rechnung_Anschreiben_DocumentListener() {
		textArea_Rechnung_Rechnung_Anschreiben.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				tr1.getAktuelleRechnung().setRechnungAnschreiben(textArea_Rechnung_Rechnung_Anschreiben.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				tr1.getAktuelleRechnung().setRechnungAnschreiben(textArea_Rechnung_Rechnung_Anschreiben.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
	}

	// sonstige Methoden
	public void fensterAktualisieren() {
		if (tr1.getAktuelleRechnung() != null) {
			lbl_Rechnung_Kunden_Name.setText(GUI.getTk1().getAktuellerKunde().getKundeName());
			lbl_Rechnung_Kunden_Strasse.setText(GUI.getTk1().getAktuellerKunde().getKundeStrasse() + " "
					+ GUI.getTk1().getAktuellerKunde().getKundeHausnummer());
			lbl_Rechnung_Rechnung_PLZ_Stadt.setText(GUI.getTk1().getAktuellerKunde().getKundePLZ() + " "
					+ GUI.getTk1().getAktuellerKunde().getKundeOrt());

			textArea_Rechnung_Rechnung_Betreff.setText(tr1.getAktuelleRechnung().getRechnungBetreff());
			textField_Rechnung_Rechnung_Anrede.setText(tr1.getAktuelleRechnung().getRechnungAnrede());
			textArea_Rechnung_Rechnung_Anschreiben.setText(tr1.getAktuelleRechnung().getRechnungAnschreiben());

			lbl_Rechnung_Summe_Netto_in_Euro
					.setText(geldformatierung.format(tr1.getAktuelleRechnung().getRechnungSummeNetto()));
			lbl_Rechnung_Rechnung_Betrag_in_Euro
					.setText(geldformatierung.format(tr1.getAktuelleRechnung().getRechnungEndbetrag()));
		}

		panel_Rechnung_Posten_Innen_Posten.revalidate();
		scrollPane_Rechnung_Posten_Innen.revalidate();
		scrollPane_Rechnung_Posten_Innen.repaint();
		frame_Rechnung.repaint();
		scrollPane_Rechnung_Posten_Innen.getVerticalScrollBar()
				.setValue(scrollPane_Rechnung_Posten_Innen.getVerticalScrollBar().getMaximum());
	}

	// Getter/Setter

	public JTextField getTextField_Rechnung_Rechnung_Anrede() {
		return textField_Rechnung_Rechnung_Anrede;
	}

	public void setTextField_Rechnung_Rechnung_Anrede(JTextField textField_Rechnung_Rechnung_Anrede) {
		this.textField_Rechnung_Rechnung_Anrede = textField_Rechnung_Rechnung_Anrede;
	}

	public JTextField getTextField_Rechnung_Posten_Einheiten_1() {
		return textField_Rechnung_Posten_Einheiten_1;
	}

	public void setTextField_Rechnung_Posten_Einheiten_1(JTextField textField_Rechnung_Posten_Einheiten_1) {
		this.textField_Rechnung_Posten_Einheiten_1 = textField_Rechnung_Posten_Einheiten_1;
	}

	public JTextField getTextField_Rechnung_Posten_Satz_in_Euro_1() {
		return textField_Rechnung_Posten_Satz_in_Euro_1;
	}

	public void setTextField_Rechnung_Posten_Satz_in_Euro_1(JTextField textField_Rechnung_Posten_Satz_in_Euro_1) {
		this.textField_Rechnung_Posten_Satz_in_Euro_1 = textField_Rechnung_Posten_Satz_in_Euro_1;
	}

	public JTextField getTextField_Rechnung_Posten_Einheiten_2() {
		return textField_Rechnung_Posten_Einheiten_2;
	}

	public void setTextField_Rechnung_Posten_Einheiten_2(JTextField textField_Rechnung_Posten_Einheiten_2) {
		this.textField_Rechnung_Posten_Einheiten_2 = textField_Rechnung_Posten_Einheiten_2;
	}

	public JTextField getTextField_Rechnung_Posten_Satz_in_Euro_2() {
		return textField_Rechnung_Posten_Satz_in_Euro_2;
	}

	public void setTextField_Rechnung_Posten_Satz_in_Euro_2(JTextField textField_Rechnung_Posten_Satz_in_Euro_2) {
		this.textField_Rechnung_Posten_Satz_in_Euro_2 = textField_Rechnung_Posten_Satz_in_Euro_2;
	}

	public JFrame getFrame_Rechnung() {
		return frame_Rechnung;
	}

	public void setFrame_Rechnung(JFrame frame_Rechnung) {
		this.frame_Rechnung = frame_Rechnung;
	}

	public JLabel getLbl_Rechnung_Kunden_Name() {
		return lbl_Rechnung_Kunden_Name;
	}

	public void setLbl_Rechnung_Kunden_Name(JLabel lbl_Rechnung_Kunden_Name) {
		this.lbl_Rechnung_Kunden_Name = lbl_Rechnung_Kunden_Name;
	}

	public JLabel getLbl_Rechnung_Kunden_Strasse() {
		return lbl_Rechnung_Kunden_Strasse;
	}

	public void setLbl_Rechnung_Kunden_Strasse(JLabel lbl_Rechnung_Kunden_Strasse) {
		this.lbl_Rechnung_Kunden_Strasse = lbl_Rechnung_Kunden_Strasse;
	}

	public JLabel getLbl_Rechnung_Rechnung_PLZ_Stadt() {
		return lbl_Rechnung_Rechnung_PLZ_Stadt;
	}

	public void setLbl_Rechnung_Rechnung_PLZ_Stadt(JLabel lbl_Rechnung_Rechnung_PLZ_Stadt) {
		this.lbl_Rechnung_Rechnung_PLZ_Stadt = lbl_Rechnung_Rechnung_PLZ_Stadt;
	}

	public JTextArea getTextArea_Rechnung_Rechnung_Betreff() {
		return textArea_Rechnung_Rechnung_Betreff;
	}

	public void setTextArea_Rechnung_Rechnung_Betreff(JTextArea textArea_Rechnung_Rechnung_Betreff) {
		this.textArea_Rechnung_Rechnung_Betreff = textArea_Rechnung_Rechnung_Betreff;
	}

	public JTextArea getTextArea_Rechnung_Rechnung_Anschreiben() {
		return textArea_Rechnung_Rechnung_Anschreiben;
	}

	public void setTextArea_Rechnung_Rechnung_Anschreiben(JTextArea textArea_Rechnung_Rechnung_Anschreiben) {
		this.textArea_Rechnung_Rechnung_Anschreiben = textArea_Rechnung_Rechnung_Anschreiben;
	}

	public JButton getBtn_Rechnung_Rechnung_Speichern() {
		return btn_Rechnung_Rechnung_Speichern;
	}

	public void setBtn_Rechnung_Rechnung_Speichern(JButton btn_Rechnung_Rechnung_Speichern) {
		this.btn_Rechnung_Rechnung_Speichern = btn_Rechnung_Rechnung_Speichern;
	}

	public JButton getBtn_Rechnung_Rechnung_Drucken() {
		return btn_Rechnung_Rechnung_Drucken;
	}

	public void setBtn_Rechnung_Rechnung_Drucken(JButton btn_Rechnung_Rechnung_Drucken) {
		this.btn_Rechnung_Rechnung_Drucken = btn_Rechnung_Rechnung_Drucken;
	}

	public JLabel getLbl_Rechnung_Summe_Netto_in_Euro() {
		return lbl_Rechnung_Summe_Netto_in_Euro;
	}

	public void setLbl_Rechnung_Summe_Netto_in_Euro(JLabel lbl_Rechnung_Summe_Netto_in_Euro) {
		this.lbl_Rechnung_Summe_Netto_in_Euro = lbl_Rechnung_Summe_Netto_in_Euro;
	}

	public JLabel getLbl_Rechnung_Rechnung_Betrag_in_Euro() {
		return lbl_Rechnung_Rechnung_Betrag_in_Euro;
	}

	public void setLbl_Rechnung_Rechnung_Betrag_in_Euro(JLabel lbl_Rechnung_Rechnung_Betrag_in_Euro) {
		this.lbl_Rechnung_Rechnung_Betrag_in_Euro = lbl_Rechnung_Rechnung_Betrag_in_Euro;
	}

	public JButton getBtn_Rechnung_Posten_Plus_1_1() {
		return btn_Rechnung_Posten_Plus;
	}

	public JButton getBtn_Rechnung_Posten_Minus_1_1() {
		return btn_Rechnung_Posten_Minus;
	}

	public JPanel getPanel_Rechnung_Posten_Innen_Posten() {
		return panel_Rechnung_Posten_Innen_Posten;
	}

	public JPanel getPanel_Rechnung_Posten_Innen_Gesamt() {
		return panel_Rechnung_Posten_Innen_Gesamt;
	}

	public JScrollPane getScrollPane_Rechnung_Posten_Innen() {
		return scrollPane_Rechnung_Posten_Innen;
	}

	public JPanel getPanel_Rechnung_Posten_Aussen() {
		return panel_Rechnung_Posten_Aussen;
	}

	public double getRechnung_Summe_Netto_in_Euro() {
		return Rechnung_Summe_Netto_in_Euro;
	}

	public void setRechnung_Summe_Netto_in_Euro(double rechnung_Summe_Netto_in_Euro) {
		Rechnung_Summe_Netto_in_Euro = rechnung_Summe_Netto_in_Euro;
	}

	public double getRechnung_Rechnung_Betrag_in_Euro() {
		return Rechnung_Rechnung_Betrag_in_Euro;
	}

	public void setRechnung_Rechnung_Betrag_in_Euro(double rechnung_Rechnung_Betrag_in_Euro) {
		Rechnung_Rechnung_Betrag_in_Euro = rechnung_Rechnung_Betrag_in_Euro;
	}

	public TabRechnung getTr1() {
		return tr1;
	}

	public void setTr1(TabRechnung tr1) {
		this.tr1 = tr1;
	}

	public JButton getBtn_Rechnung_Posten_Plus() {
		return btn_Rechnung_Posten_Plus;
	}

	public void setBtn_Rechnung_Posten_Plus(JButton btn_Rechnung_Posten_Plus) {
		this.btn_Rechnung_Posten_Plus = btn_Rechnung_Posten_Plus;
	}

	public JButton getBtn_Rechnung_Posten_Minus() {
		return btn_Rechnung_Posten_Minus;
	}

	public void setBtn_Rechnung_Posten_Minus(JButton btn_Rechnung_Posten_Minus) {
		this.btn_Rechnung_Posten_Minus = btn_Rechnung_Posten_Minus;
	}

	public void setPanel_Rechnung_Posten_Innen_Posten(JPanel panel_Rechnung_Posten_Innen_Posten) {
		this.panel_Rechnung_Posten_Innen_Posten = panel_Rechnung_Posten_Innen_Posten;
	}

	public void setPanel_Rechnung_Posten_Innen_Gesamt(JPanel panel_Rechnung_Posten_Innen_Gesamt) {
		this.panel_Rechnung_Posten_Innen_Gesamt = panel_Rechnung_Posten_Innen_Gesamt;
	}

	public void setScrollPane_Rechnung_Posten_Innen(JScrollPane scrollPane_Rechnung_Posten_Innen) {
		this.scrollPane_Rechnung_Posten_Innen = scrollPane_Rechnung_Posten_Innen;
	}

	public void setPanel_Rechnung_Posten_Aussen(JPanel panel_Rechnung_Posten_Aussen) {
		this.panel_Rechnung_Posten_Aussen = panel_Rechnung_Posten_Aussen;
	}

}
