package package_Abrechnungssoftware;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {

	// Attribute
	
	private JFrame frame;
	private JTextField textField_KundeStrasse;
	private JTextField textField_KundeID;
	private JTextField textField_KundeName;
	private JTextField textField_KundeOrt;
	private JTextField textField_KundeTelefon;
	private JTextField textField_KundeEmail;
	private JTextField textField_KundeSteuerNummer;
	private JTextField textField_KundeHausnummer;
	private JTextField textField_KundePLZ;
	private JTextField textField_Positionsname;
	private JTextField textField_Position_Kategorie_Satz_in_Euro;
	private final ButtonGroup buttonGroup_Position_Satz = new ButtonGroup();
	private JTextField textField_Optionen_Speicherpfad;
	private JTextField textField_Optionen_dbAdresse;
	private JTextField textField_Optionen_dbBenutzername;
	private JPasswordField passwordField_Optionen_dbPasswort;
	private JButton btn_Kunde_Anzeigen;
	private JButton btn_Kunde_Neu;
	private JComboBox comboBox_Kunde_Kunden;
	private JLabel lbl_KundeName;
	private JLabel lbl_KundeID;
	private JLabel lbl_KundeStrasse;
	private JLabel lbl_KundeHausnummer;
	private JLabel lbl_KundeOrt;
	private JLabel lbl_KundePLZ;
	private JLabel lbl_KundeTelefon;
	private JLabel lbl_KundeEmail;
	private JLabel lbl_KundeSteuerNummer;
	private JCheckBox chckbx_Kunde_Inaktiv;
	private JButton btn_Kunde_Speichern;
	private JLabel lblNewLabel;
	private JList list_Kunde_Rechnungen;
	private JButton btn_Kunde_Rechnung_Anzeigen;
	private JButton btn_Kunde_Rechnung_Korrektur;
	private JButton btn_Kunde_Rechnung_Neu;
	private JPanel panel_KundenDaten;
	private JPanel panel_Kunde_Speichern;
	private JPanel panel_Kunde_Rechnungen;
	private JPanel panel_Kunde_Rechnungen_Buttons;
	private JComboBox comboBox_Position_Positionen;
	private JButton btn_Position_Anzeigen;
	private JButton btn_Position_Neu;
	private JPanel panel_Position_Daten;
	private JLabel lbl_Position_Name;
	private JLabel lbl_Position_Kategorie;
	private JComboBox comboBox_Position_Kategorie;
	private JButton btn_Position_Kategorie_Neu;
	private JLabel lbl_Position_Satz_in_Euro;
	private JRadioButton rdbtn_Position_Stundensatz;
	private JRadioButton rdbtn_Position_Tagessatz;
	private JRadioButton rdbtn_Position_Honorarsatz;
	private JButton btn_Position_Speichern;
	private JButton btn_Optionen_Speicherpfad;
	private JButton btn_Optionen_Speichern;
	private JLabel lbl_Optionen_Optionen;
	private JCheckBox chckbx_Optionen_KundenAusblenden;
	
	// private JPanel contentPane;
	private JTextField textField_Rechnung_Rechnung_Anrede;
	private JTextField textField_Rechnung_Posten_Einheiten_1;
	private JTextField textField_Rechnung_Posten_Satz_in_Euro_1;
	private JTextField textField_Rechnung_Posten_Einheiten_2;
	private JTextField textField_Rechnung_Posten_Satz_in_Euro_2;
	private JFrame frame_Rechnung;
	private JLabel lbl_Rechnung_Kunden_Name;
	private JLabel lbl_Rechnung_Kunden_Strasse;
	private JLabel lbl_Rechnung_Rechnung_PLZ_Stadt;
	private JTextArea textArea_Rechnung_Rechnung_Betreff;
	private JTextArea textArea_Rechnung_Rechnung_Anschreiben;
	private JButton btn_Rechnung_Posten_Plus;
	private JButton btn_Rechnung_Posten_Minus;
	private JButton btn_Rechnung_Rechnung_Speichern;
	private JButton btn_Rechnung_Rechnung_Drucken;
	private JLabel lbl_Rechnung_Summe_Netto_in_Euro;
	private JLabel lbl_Rechnung_Rechnung_Betrag_in_Euro;
	
	
	// Methoden
	
	public void hauptfenster() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 900, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{784, 0};
		gridBagLayout.rowHeights = new int[]{561, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel TabKunde = new JPanel();
		tabbedPane.addTab("Kunde", null, TabKunde, null);
		GridBagLayout gbl_TabKunde = new GridBagLayout();
		gbl_TabKunde.columnWidths = new int[]{25, 675, 25, 150, 25, 0};
		gbl_TabKunde.rowHeights = new int[]{10, 1, 210, 10, 300, 0};
		gbl_TabKunde.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_TabKunde.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		TabKunde.setLayout(gbl_TabKunde);
		
		JPanel panel_Kunde_Suchleiste = new JPanel();
		GridBagConstraints gbc_panel_Kunde_Suchleiste = new GridBagConstraints();
		gbc_panel_Kunde_Suchleiste.anchor = GridBagConstraints.NORTH;
		gbc_panel_Kunde_Suchleiste.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Kunde_Suchleiste.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Kunde_Suchleiste.gridx = 1;
		gbc_panel_Kunde_Suchleiste.gridy = 1;
		TabKunde.add(panel_Kunde_Suchleiste, gbc_panel_Kunde_Suchleiste);
		GridBagLayout gbl_panel_Kunde_Suchleiste = new GridBagLayout();
		gbl_panel_Kunde_Suchleiste.columnWidths = new int[]{0, 25, 0, 0};
		gbl_panel_Kunde_Suchleiste.rowHeights = new int[]{0, 0, 0};
		gbl_panel_Kunde_Suchleiste.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Kunde_Suchleiste.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_Kunde_Suchleiste.setLayout(gbl_panel_Kunde_Suchleiste);
		
		comboBox_Kunde_Kunden = new JComboBox();
		comboBox_Kunde_Kunden.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_comboBox_Kunde_Kunden = new GridBagConstraints();
		gbc_comboBox_Kunde_Kunden.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Kunde_Kunden.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Kunde_Kunden.gridx = 0;
		gbc_comboBox_Kunde_Kunden.gridy = 0;
		panel_Kunde_Suchleiste.add(comboBox_Kunde_Kunden, gbc_comboBox_Kunde_Kunden);
		
		btn_Kunde_Anzeigen = new JButton("Anzeigen");
		btn_Kunde_Anzeigen.setMinimumSize(new Dimension(130, 25));
		btn_Kunde_Anzeigen.setPreferredSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Kunde_Anzeigen = new GridBagConstraints();
		gbc_btn_Kunde_Anzeigen.insets = new Insets(0, 0, 5, 0);
		gbc_btn_Kunde_Anzeigen.gridx = 2;
		gbc_btn_Kunde_Anzeigen.gridy = 0;
		panel_Kunde_Suchleiste.add(btn_Kunde_Anzeigen, gbc_btn_Kunde_Anzeigen);
		
		JPanel panel_Kunde_Abstandshalter_1 = new JPanel();
		GridBagConstraints gbc_panel_Kunde_Abstandshalter_1 = new GridBagConstraints();
		gbc_panel_Kunde_Abstandshalter_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Kunde_Abstandshalter_1.gridx = 2;
		gbc_panel_Kunde_Abstandshalter_1.gridy = 1;
		TabKunde.add(panel_Kunde_Abstandshalter_1, gbc_panel_Kunde_Abstandshalter_1);
		
		btn_Kunde_Neu = new JButton("Neuer Kunde");
		btn_Kunde_Neu.setMinimumSize(new Dimension(130, 25));
		btn_Kunde_Neu.setPreferredSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Kunde_Neu = new GridBagConstraints();
		gbc_btn_Kunde_Neu.anchor = GridBagConstraints.NORTHEAST;
		gbc_btn_Kunde_Neu.insets = new Insets(0, 0, 5, 5);
		gbc_btn_Kunde_Neu.gridx = 3;
		gbc_btn_Kunde_Neu.gridy = 1;
		TabKunde.add(btn_Kunde_Neu, gbc_btn_Kunde_Neu);
		
		panel_KundenDaten = new JPanel();
		GridBagConstraints gbc_panel_KundenDaten = new GridBagConstraints();
		gbc_panel_KundenDaten.anchor = GridBagConstraints.SOUTH;
		gbc_panel_KundenDaten.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_KundenDaten.insets = new Insets(0, 0, 5, 5);
		gbc_panel_KundenDaten.gridx = 1;
		gbc_panel_KundenDaten.gridy = 2;
		TabKunde.add(panel_KundenDaten, gbc_panel_KundenDaten);
		GridBagLayout gbl_panel_KundenDaten = new GridBagLayout();
		gbl_panel_KundenDaten.columnWidths = new int[]{0, 400, 25, 60, 70, 0};
		gbl_panel_KundenDaten.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_KundenDaten.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_KundenDaten.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_KundenDaten.setLayout(gbl_panel_KundenDaten);
		
		lbl_KundeName = new JLabel("Kundenname: ");
		lbl_KundeName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundeName = new GridBagConstraints();
		gbc_lbl_KundeName.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundeName.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_KundeName.gridx = 0;
		gbc_lbl_KundeName.gridy = 0;
		panel_KundenDaten.add(lbl_KundeName, gbc_lbl_KundeName);
		
		textField_KundeName = new JTextField();
		textField_KundeName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_KundeName = new GridBagConstraints();
		gbc_textField_KundeName.insets = new Insets(0, 0, 5, 5);
		gbc_textField_KundeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_KundeName.gridx = 1;
		gbc_textField_KundeName.gridy = 0;
		panel_KundenDaten.add(textField_KundeName, gbc_textField_KundeName);
		textField_KundeName.setColumns(10);
		
		lbl_KundeID = new JLabel("KundenID: ");
		lbl_KundeID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundeID = new GridBagConstraints();
		gbc_lbl_KundeID.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundeID.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_KundeID.gridx = 0;
		gbc_lbl_KundeID.gridy = 1;
		panel_KundenDaten.add(lbl_KundeID, gbc_lbl_KundeID);
		
		textField_KundeID = new JTextField();
		textField_KundeID.setMinimumSize(new Dimension(70, 25));
		textField_KundeID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_KundeID = new GridBagConstraints();
		gbc_textField_KundeID.anchor = GridBagConstraints.WEST;
		gbc_textField_KundeID.insets = new Insets(0, 0, 5, 5);
		gbc_textField_KundeID.gridx = 1;
		gbc_textField_KundeID.gridy = 1;
		panel_KundenDaten.add(textField_KundeID, gbc_textField_KundeID);
		textField_KundeID.setColumns(10);
		
		lbl_KundeStrasse = new JLabel("Stra\u00DFe: ");
		lbl_KundeStrasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundeStrasse = new GridBagConstraints();
		gbc_lbl_KundeStrasse.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundeStrasse.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_KundeStrasse.gridx = 0;
		gbc_lbl_KundeStrasse.gridy = 2;
		panel_KundenDaten.add(lbl_KundeStrasse, gbc_lbl_KundeStrasse);
		
		textField_KundeStrasse = new JTextField();
		textField_KundeStrasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_KundeStrasse = new GridBagConstraints();
		gbc_textField_KundeStrasse.insets = new Insets(0, 0, 5, 5);
		gbc_textField_KundeStrasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_KundeStrasse.gridx = 1;
		gbc_textField_KundeStrasse.gridy = 2;
		panel_KundenDaten.add(textField_KundeStrasse, gbc_textField_KundeStrasse);
		textField_KundeStrasse.setColumns(10);
		
		lbl_KundeHausnummer = new JLabel("Nr: ");
		lbl_KundeHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundeHausnummer = new GridBagConstraints();
		gbc_lbl_KundeHausnummer.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundeHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_KundeHausnummer.gridx = 3;
		gbc_lbl_KundeHausnummer.gridy = 2;
		panel_KundenDaten.add(lbl_KundeHausnummer, gbc_lbl_KundeHausnummer);
		
		textField_KundeHausnummer = new JTextField();
		textField_KundeHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_KundeHausnummer.setColumns(10);
		GridBagConstraints gbc_textField_KundeHausnummer = new GridBagConstraints();
		gbc_textField_KundeHausnummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_KundeHausnummer.insets = new Insets(0, 0, 5, 0);
		gbc_textField_KundeHausnummer.gridx = 4;
		gbc_textField_KundeHausnummer.gridy = 2;
		panel_KundenDaten.add(textField_KundeHausnummer, gbc_textField_KundeHausnummer);
		
		lbl_KundeOrt = new JLabel("Ort: ");
		lbl_KundeOrt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundeOrt = new GridBagConstraints();
		gbc_lbl_KundeOrt.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundeOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_KundeOrt.gridx = 0;
		gbc_lbl_KundeOrt.gridy = 3;
		panel_KundenDaten.add(lbl_KundeOrt, gbc_lbl_KundeOrt);
		
		textField_KundeOrt = new JTextField();
		textField_KundeOrt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_KundeOrt = new GridBagConstraints();
		gbc_textField_KundeOrt.insets = new Insets(0, 0, 5, 5);
		gbc_textField_KundeOrt.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_KundeOrt.gridx = 1;
		gbc_textField_KundeOrt.gridy = 3;
		panel_KundenDaten.add(textField_KundeOrt, gbc_textField_KundeOrt);
		textField_KundeOrt.setColumns(10);
		
		lbl_KundePLZ = new JLabel("PLZ: ");
		lbl_KundePLZ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundePLZ = new GridBagConstraints();
		gbc_lbl_KundePLZ.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundePLZ.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_KundePLZ.gridx = 3;
		gbc_lbl_KundePLZ.gridy = 3;
		panel_KundenDaten.add(lbl_KundePLZ, gbc_lbl_KundePLZ);
		
		textField_KundePLZ = new JTextField();
		textField_KundePLZ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_KundePLZ.setColumns(10);
		GridBagConstraints gbc_textField_KundePLZ = new GridBagConstraints();
		gbc_textField_KundePLZ.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_KundePLZ.insets = new Insets(0, 0, 5, 0);
		gbc_textField_KundePLZ.gridx = 4;
		gbc_textField_KundePLZ.gridy = 3;
		panel_KundenDaten.add(textField_KundePLZ, gbc_textField_KundePLZ);
		
		lbl_KundeTelefon = new JLabel("Telefon: ");
		lbl_KundeTelefon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundeTelefon = new GridBagConstraints();
		gbc_lbl_KundeTelefon.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundeTelefon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_KundeTelefon.gridx = 0;
		gbc_lbl_KundeTelefon.gridy = 4;
		panel_KundenDaten.add(lbl_KundeTelefon, gbc_lbl_KundeTelefon);
		
		textField_KundeTelefon = new JTextField();
		textField_KundeTelefon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_KundeTelefon = new GridBagConstraints();
		gbc_textField_KundeTelefon.insets = new Insets(0, 0, 5, 5);
		gbc_textField_KundeTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_KundeTelefon.gridx = 1;
		gbc_textField_KundeTelefon.gridy = 4;
		panel_KundenDaten.add(textField_KundeTelefon, gbc_textField_KundeTelefon);
		textField_KundeTelefon.setColumns(10);
		
		lbl_KundeEmail = new JLabel("E-Mail: ");
		lbl_KundeEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundeEmail = new GridBagConstraints();
		gbc_lbl_KundeEmail.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundeEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_KundeEmail.gridx = 0;
		gbc_lbl_KundeEmail.gridy = 5;
		panel_KundenDaten.add(lbl_KundeEmail, gbc_lbl_KundeEmail);
		
		textField_KundeEmail = new JTextField();
		textField_KundeEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_KundeEmail = new GridBagConstraints();
		gbc_textField_KundeEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textField_KundeEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_KundeEmail.gridx = 1;
		gbc_textField_KundeEmail.gridy = 5;
		panel_KundenDaten.add(textField_KundeEmail, gbc_textField_KundeEmail);
		textField_KundeEmail.setColumns(10);
		
		lbl_KundeSteuerNummer = new JLabel("Steuernummer:");
		lbl_KundeSteuerNummer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_KundeSteuerNummer = new GridBagConstraints();
		gbc_lbl_KundeSteuerNummer.anchor = GridBagConstraints.WEST;
		gbc_lbl_KundeSteuerNummer.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_KundeSteuerNummer.gridx = 0;
		gbc_lbl_KundeSteuerNummer.gridy = 6;
		panel_KundenDaten.add(lbl_KundeSteuerNummer, gbc_lbl_KundeSteuerNummer);
		
		textField_KundeSteuerNummer = new JTextField();
		textField_KundeSteuerNummer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_KundeSteuerNummer = new GridBagConstraints();
		gbc_textField_KundeSteuerNummer.insets = new Insets(0, 0, 0, 5);
		gbc_textField_KundeSteuerNummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_KundeSteuerNummer.gridx = 1;
		gbc_textField_KundeSteuerNummer.gridy = 6;
		panel_KundenDaten.add(textField_KundeSteuerNummer, gbc_textField_KundeSteuerNummer);
		textField_KundeSteuerNummer.setColumns(10);
		
		chckbx_Kunde_Inaktiv = new JCheckBox("Inaktiv");
		chckbx_Kunde_Inaktiv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_chckbx_Kunde_Inaktiv = new GridBagConstraints();
		gbc_chckbx_Kunde_Inaktiv.gridx = 4;
		gbc_chckbx_Kunde_Inaktiv.gridy = 6;
		panel_KundenDaten.add(chckbx_Kunde_Inaktiv, gbc_chckbx_Kunde_Inaktiv);
		
		panel_Kunde_Speichern = new JPanel();
		GridBagConstraints gbc_panel_Kunde_Speichern = new GridBagConstraints();
		gbc_panel_Kunde_Speichern.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel_Kunde_Speichern.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Kunde_Speichern.gridx = 3;
		gbc_panel_Kunde_Speichern.gridy = 2;
		TabKunde.add(panel_Kunde_Speichern, gbc_panel_Kunde_Speichern);
		GridBagLayout gbl_panel_Kunde_Speichern = new GridBagLayout();
		gbl_panel_Kunde_Speichern.columnWidths = new int[]{0, 0};
		gbl_panel_Kunde_Speichern.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_Kunde_Speichern.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_Kunde_Speichern.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Kunde_Speichern.setLayout(gbl_panel_Kunde_Speichern);
		
		btn_Kunde_Speichern = new JButton("Speichern");
		btn_Kunde_Speichern.setPreferredSize(new Dimension(130, 25));
		btn_Kunde_Speichern.setMinimumSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Kunde_Speichern = new GridBagConstraints();
		gbc_btn_Kunde_Speichern.anchor = GridBagConstraints.EAST;
		gbc_btn_Kunde_Speichern.gridx = 0;
		gbc_btn_Kunde_Speichern.gridy = 6;
		panel_Kunde_Speichern.add(btn_Kunde_Speichern, gbc_btn_Kunde_Speichern);
		
		panel_Kunde_Rechnungen = new JPanel();
		GridBagConstraints gbc_panel_Kunde_Rechnungen = new GridBagConstraints();
		gbc_panel_Kunde_Rechnungen.insets = new Insets(0, 0, 0, 5);
		gbc_panel_Kunde_Rechnungen.fill = GridBagConstraints.BOTH;
		gbc_panel_Kunde_Rechnungen.gridx = 1;
		gbc_panel_Kunde_Rechnungen.gridy = 4;
		TabKunde.add(panel_Kunde_Rechnungen, gbc_panel_Kunde_Rechnungen);
		panel_Kunde_Rechnungen.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Rechnungen:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setPreferredSize(new Dimension(64, 15));
		panel_Kunde_Rechnungen.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_Kunde_Abstandshalter_2 = new JPanel();
		panel_Kunde_Rechnungen.add(panel_Kunde_Abstandshalter_2, BorderLayout.EAST);
		GridBagLayout gbl_panel_Kunde_Abstandshalter_2 = new GridBagLayout();
		gbl_panel_Kunde_Abstandshalter_2.columnWidths = new int[]{0, 0};
		gbl_panel_Kunde_Abstandshalter_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_Kunde_Abstandshalter_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_Kunde_Abstandshalter_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Kunde_Abstandshalter_2.setLayout(gbl_panel_Kunde_Abstandshalter_2);
		
		JPanel panel_Kunde_Abstandshalter_3 = new JPanel();
		panel_Kunde_Rechnungen.add(panel_Kunde_Abstandshalter_3, BorderLayout.WEST);
		
		list_Kunde_Rechnungen = new JList();
		panel_Kunde_Rechnungen.add(list_Kunde_Rechnungen, BorderLayout.CENTER);
		
		panel_Kunde_Rechnungen_Buttons = new JPanel();
		GridBagConstraints gbc_panel_Kunde_Rechnungen_Buttons = new GridBagConstraints();
		gbc_panel_Kunde_Rechnungen_Buttons.insets = new Insets(0, 0, 0, 5);
		gbc_panel_Kunde_Rechnungen_Buttons.fill = GridBagConstraints.BOTH;
		gbc_panel_Kunde_Rechnungen_Buttons.gridx = 3;
		gbc_panel_Kunde_Rechnungen_Buttons.gridy = 4;
		TabKunde.add(panel_Kunde_Rechnungen_Buttons, gbc_panel_Kunde_Rechnungen_Buttons);
		panel_Kunde_Rechnungen_Buttons.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Kunde_Abstandshalter_4 = new JPanel();
		panel_Kunde_Rechnungen_Buttons.add(panel_Kunde_Abstandshalter_4, BorderLayout.WEST);
		
		JPanel panel_Kunde_Rechnungen_Buttons_mitte = new JPanel();
		panel_Kunde_Rechnungen_Buttons.add(panel_Kunde_Rechnungen_Buttons_mitte, BorderLayout.EAST);
		GridBagLayout gbl_panel_Kunde_Rechnungen_Buttons_mitte = new GridBagLayout();
		gbl_panel_Kunde_Rechnungen_Buttons_mitte.columnWidths = new int[]{0, 0};
		gbl_panel_Kunde_Rechnungen_Buttons_mitte.rowHeights = new int[]{0, 25, 0, 25, 0, 0};
		gbl_panel_Kunde_Rechnungen_Buttons_mitte.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_Kunde_Rechnungen_Buttons_mitte.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Kunde_Rechnungen_Buttons_mitte.setLayout(gbl_panel_Kunde_Rechnungen_Buttons_mitte);
		
		btn_Kunde_Rechnung_Anzeigen = new JButton("Anzeigen");
		btn_Kunde_Rechnung_Anzeigen.setPreferredSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Kunde_Rechnung_Anzeigen = new GridBagConstraints();
		gbc_btn_Kunde_Rechnung_Anzeigen.anchor = GridBagConstraints.EAST;
		gbc_btn_Kunde_Rechnung_Anzeigen.insets = new Insets(0, 0, 5, 0);
		gbc_btn_Kunde_Rechnung_Anzeigen.gridx = 0;
		gbc_btn_Kunde_Rechnung_Anzeigen.gridy = 0;
		panel_Kunde_Rechnungen_Buttons_mitte.add(btn_Kunde_Rechnung_Anzeigen, gbc_btn_Kunde_Rechnung_Anzeigen);
		
		btn_Kunde_Rechnung_Korrektur = new JButton("Korrektur");
		btn_Kunde_Rechnung_Korrektur.setPreferredSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Kunde_Rechnung_Korrektur = new GridBagConstraints();
		gbc_btn_Kunde_Rechnung_Korrektur.anchor = GridBagConstraints.EAST;
		gbc_btn_Kunde_Rechnung_Korrektur.insets = new Insets(0, 0, 5, 0);
		gbc_btn_Kunde_Rechnung_Korrektur.gridx = 0;
		gbc_btn_Kunde_Rechnung_Korrektur.gridy = 2;
		panel_Kunde_Rechnungen_Buttons_mitte.add(btn_Kunde_Rechnung_Korrektur, gbc_btn_Kunde_Rechnung_Korrektur);
		
		btn_Kunde_Rechnung_Neu = new JButton("Neue Rechnung");
		btn_Kunde_Rechnung_Neu.setPreferredSize(new Dimension(130, 25));
		btn_Kunde_Rechnung_Neu.setSize(100, 25);
		GridBagConstraints gbc_btn_Kunde_Rechnung_Neu = new GridBagConstraints();
		gbc_btn_Kunde_Rechnung_Neu.anchor = GridBagConstraints.EAST;
		gbc_btn_Kunde_Rechnung_Neu.gridx = 0;
		gbc_btn_Kunde_Rechnung_Neu.gridy = 4;
		panel_Kunde_Rechnungen_Buttons_mitte.add(btn_Kunde_Rechnung_Neu, gbc_btn_Kunde_Rechnung_Neu);
		
		JPanel panel_Kunde_Abstandshalter_5 = new JPanel();
		panel_Kunde_Abstandshalter_5.setMinimumSize(new Dimension(10, 14));
		panel_Kunde_Abstandshalter_5.setPreferredSize(new Dimension(10, 15));
		panel_Kunde_Rechnungen_Buttons.add(panel_Kunde_Abstandshalter_5, BorderLayout.NORTH);
		
		JPanel TabPosition = new JPanel();
		tabbedPane.addTab("Positionen", null, TabPosition, null);
		GridBagLayout gbl_TabPosition = new GridBagLayout();
		gbl_TabPosition.columnWidths = new int[]{25, 675, 25, 150, 25, 0};
		gbl_TabPosition.rowHeights = new int[]{10, 1, 210, 10, 300, 0};
		gbl_TabPosition.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_TabPosition.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		TabPosition.setLayout(gbl_TabPosition);
		
		JPanel panel__Position_Suchleiste = new JPanel();
		GridBagConstraints gbc_panel__Position_Suchleiste = new GridBagConstraints();
		gbc_panel__Position_Suchleiste.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel__Position_Suchleiste.anchor = GridBagConstraints.NORTH;
		gbc_panel__Position_Suchleiste.insets = new Insets(0, 0, 5, 5);
		gbc_panel__Position_Suchleiste.gridx = 1;
		gbc_panel__Position_Suchleiste.gridy = 1;
		TabPosition.add(panel__Position_Suchleiste, gbc_panel__Position_Suchleiste);
		GridBagLayout gbl_panel__Position_Suchleiste = new GridBagLayout();
		gbl_panel__Position_Suchleiste.columnWidths = new int[]{0, 25, 0, 0};
		gbl_panel__Position_Suchleiste.rowHeights = new int[]{0, 0, 0};
		gbl_panel__Position_Suchleiste.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel__Position_Suchleiste.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel__Position_Suchleiste.setLayout(gbl_panel__Position_Suchleiste);
		
		comboBox_Position_Positionen = new JComboBox();
		comboBox_Position_Positionen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_comboBox_Position_Positionen = new GridBagConstraints();
		gbc_comboBox_Position_Positionen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Position_Positionen.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Position_Positionen.gridx = 0;
		gbc_comboBox_Position_Positionen.gridy = 0;
		panel__Position_Suchleiste.add(comboBox_Position_Positionen, gbc_comboBox_Position_Positionen);
		
		btn_Position_Anzeigen = new JButton("Anzeigen");
		btn_Position_Anzeigen.setPreferredSize(new Dimension(130, 25));
		btn_Position_Anzeigen.setMinimumSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Position_Anzeigen = new GridBagConstraints();
		gbc_btn_Position_Anzeigen.insets = new Insets(0, 0, 5, 0);
		gbc_btn_Position_Anzeigen.gridx = 2;
		gbc_btn_Position_Anzeigen.gridy = 0;
		panel__Position_Suchleiste.add(btn_Position_Anzeigen, gbc_btn_Position_Anzeigen);
		
		JPanel panel_Position_Abstandshalter_1 = new JPanel();
		GridBagConstraints gbc_panel_Position_Abstandshalter_1 = new GridBagConstraints();
		gbc_panel_Position_Abstandshalter_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Position_Abstandshalter_1.gridx = 2;
		gbc_panel_Position_Abstandshalter_1.gridy = 1;
		TabPosition.add(panel_Position_Abstandshalter_1, gbc_panel_Position_Abstandshalter_1);
		
		btn_Position_Neu = new JButton("Neue Position");
		btn_Position_Neu.setPreferredSize(new Dimension(130, 25));
		btn_Position_Neu.setMinimumSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Position_Neu = new GridBagConstraints();
		gbc_btn_Position_Neu.anchor = GridBagConstraints.NORTHEAST;
		gbc_btn_Position_Neu.insets = new Insets(0, 0, 5, 5);
		gbc_btn_Position_Neu.gridx = 3;
		gbc_btn_Position_Neu.gridy = 1;
		TabPosition.add(btn_Position_Neu, gbc_btn_Position_Neu);
		
		panel_Position_Daten = new JPanel();
		GridBagConstraints gbc_panel_Position_Daten = new GridBagConstraints();
		gbc_panel_Position_Daten.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Position_Daten.anchor = GridBagConstraints.SOUTH;
		gbc_panel_Position_Daten.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Position_Daten.gridx = 1;
		gbc_panel_Position_Daten.gridy = 2;
		TabPosition.add(panel_Position_Daten, gbc_panel_Position_Daten);
		GridBagLayout gbl_panel_Position_Daten = new GridBagLayout();
		gbl_panel_Position_Daten.columnWidths = new int[]{0, 400, 25, 60, 70, 0};
		gbl_panel_Position_Daten.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_Position_Daten.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Position_Daten.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_Position_Daten.setLayout(gbl_panel_Position_Daten);
		
		lbl_Position_Name = new JLabel("Positionsname: ");
		lbl_Position_Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Position_Name = new GridBagConstraints();
		gbc_lbl_Position_Name.anchor = GridBagConstraints.WEST;
		gbc_lbl_Position_Name.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Position_Name.gridx = 0;
		gbc_lbl_Position_Name.gridy = 1;
		panel_Position_Daten.add(lbl_Position_Name, gbc_lbl_Position_Name);
		
		textField_Positionsname = new JTextField();
		textField_Positionsname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_Positionsname.setColumns(10);
		GridBagConstraints gbc_textField_Positionsname = new GridBagConstraints();
		gbc_textField_Positionsname.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Positionsname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Positionsname.gridx = 1;
		gbc_textField_Positionsname.gridy = 1;
		panel_Position_Daten.add(textField_Positionsname, gbc_textField_Positionsname);
		
		lbl_Position_Kategorie = new JLabel("Kategorie: ");
		lbl_Position_Kategorie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Position_Kategorie = new GridBagConstraints();
		gbc_lbl_Position_Kategorie.anchor = GridBagConstraints.WEST;
		gbc_lbl_Position_Kategorie.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Position_Kategorie.gridx = 0;
		gbc_lbl_Position_Kategorie.gridy = 2;
		panel_Position_Daten.add(lbl_Position_Kategorie, gbc_lbl_Position_Kategorie);
		
		JPanel panel_Position_Kategorie = new JPanel();
		GridBagConstraints gbc_panel_Position_Kategorie = new GridBagConstraints();
		gbc_panel_Position_Kategorie.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Position_Kategorie.fill = GridBagConstraints.BOTH;
		gbc_panel_Position_Kategorie.gridx = 1;
		gbc_panel_Position_Kategorie.gridy = 2;
		panel_Position_Daten.add(panel_Position_Kategorie, gbc_panel_Position_Kategorie);
		GridBagLayout gbl_panel_Position_Kategorie = new GridBagLayout();
		gbl_panel_Position_Kategorie.columnWidths = new int[]{0, 25, 130, 0};
		gbl_panel_Position_Kategorie.rowHeights = new int[]{0, 0};
		gbl_panel_Position_Kategorie.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Position_Kategorie.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_Position_Kategorie.setLayout(gbl_panel_Position_Kategorie);
		
		comboBox_Position_Kategorie = new JComboBox();
		GridBagConstraints gbc_comboBox_Position_Kategorie = new GridBagConstraints();
		gbc_comboBox_Position_Kategorie.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_Position_Kategorie.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Position_Kategorie.gridx = 0;
		gbc_comboBox_Position_Kategorie.gridy = 0;
		panel_Position_Kategorie.add(comboBox_Position_Kategorie, gbc_comboBox_Position_Kategorie);
		
		btn_Position_Kategorie_Neu = new JButton("Neue Kategorie");
		btn_Position_Kategorie_Neu.setMaximumSize(new Dimension(130, 25));
		btn_Position_Kategorie_Neu.setMinimumSize(new Dimension(130, 25));
		btn_Position_Kategorie_Neu.setPreferredSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Position_Kategorie_Neu = new GridBagConstraints();
		gbc_btn_Position_Kategorie_Neu.gridx = 2;
		gbc_btn_Position_Kategorie_Neu.gridy = 0;
		panel_Position_Kategorie.add(btn_Position_Kategorie_Neu, gbc_btn_Position_Kategorie_Neu);
		
		lbl_Position_Satz_in_Euro = new JLabel("Satz in Euro: ");
		lbl_Position_Satz_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Position_Satz_in_Euro = new GridBagConstraints();
		gbc_lbl_Position_Satz_in_Euro.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbl_Position_Satz_in_Euro.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Position_Satz_in_Euro.gridx = 0;
		gbc_lbl_Position_Satz_in_Euro.gridy = 3;
		panel_Position_Daten.add(lbl_Position_Satz_in_Euro, gbc_lbl_Position_Satz_in_Euro);
		
		JPanel panel_Position_Satz = new JPanel();
		GridBagConstraints gbc_panel_Position_Satz = new GridBagConstraints();
		gbc_panel_Position_Satz.anchor = GridBagConstraints.NORTH;
		gbc_panel_Position_Satz.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Position_Satz.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Position_Satz.gridx = 1;
		gbc_panel_Position_Satz.gridy = 3;
		panel_Position_Daten.add(panel_Position_Satz, gbc_panel_Position_Satz);
		GridBagLayout gbl_panel_Position_Satz = new GridBagLayout();
		gbl_panel_Position_Satz.columnWidths = new int[]{0, 25, 130, 0};
		gbl_panel_Position_Satz.rowHeights = new int[]{0, 0};
		gbl_panel_Position_Satz.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Position_Satz.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Position_Satz.setLayout(gbl_panel_Position_Satz);
		
		textField_Position_Kategorie_Satz_in_Euro = new JTextField();
		textField_Position_Kategorie_Satz_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_Position_Kategorie_Satz_in_Euro = new GridBagConstraints();
		gbc_textField_Position_Kategorie_Satz_in_Euro.anchor = GridBagConstraints.NORTH;
		gbc_textField_Position_Kategorie_Satz_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Position_Kategorie_Satz_in_Euro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Position_Kategorie_Satz_in_Euro.gridx = 0;
		gbc_textField_Position_Kategorie_Satz_in_Euro.gridy = 0;
		panel_Position_Satz.add(textField_Position_Kategorie_Satz_in_Euro, gbc_textField_Position_Kategorie_Satz_in_Euro);
		textField_Position_Kategorie_Satz_in_Euro.setColumns(10);
		
		JPanel panel_Position_RadioButtons = new JPanel();
		GridBagConstraints gbc_panel_Position_RadioButtons = new GridBagConstraints();
		gbc_panel_Position_RadioButtons.fill = GridBagConstraints.BOTH;
		gbc_panel_Position_RadioButtons.gridx = 2;
		gbc_panel_Position_RadioButtons.gridy = 0;
		panel_Position_Satz.add(panel_Position_RadioButtons, gbc_panel_Position_RadioButtons);
		GridBagLayout gbl_panel_Position_RadioButtons = new GridBagLayout();
		gbl_panel_Position_RadioButtons.columnWidths = new int[]{0, 0};
		gbl_panel_Position_RadioButtons.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_Position_RadioButtons.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_Position_RadioButtons.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_Position_RadioButtons.setLayout(gbl_panel_Position_RadioButtons);
		
		rdbtn_Position_Stundensatz = new JRadioButton("Stundensatz");
		buttonGroup_Position_Satz.add(rdbtn_Position_Stundensatz);
		GridBagConstraints gbc_rdbtn_Position_Stundensatz = new GridBagConstraints();
		gbc_rdbtn_Position_Stundensatz.anchor = GridBagConstraints.WEST;
		gbc_rdbtn_Position_Stundensatz.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtn_Position_Stundensatz.gridx = 0;
		gbc_rdbtn_Position_Stundensatz.gridy = 0;
		panel_Position_RadioButtons.add(rdbtn_Position_Stundensatz, gbc_rdbtn_Position_Stundensatz);
		
		rdbtn_Position_Tagessatz = new JRadioButton("Tagessatz");
		buttonGroup_Position_Satz.add(rdbtn_Position_Tagessatz);
		GridBagConstraints gbc_rdbtn_Position_Tagessatz = new GridBagConstraints();
		gbc_rdbtn_Position_Tagessatz.anchor = GridBagConstraints.WEST;
		gbc_rdbtn_Position_Tagessatz.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtn_Position_Tagessatz.gridx = 0;
		gbc_rdbtn_Position_Tagessatz.gridy = 1;
		panel_Position_RadioButtons.add(rdbtn_Position_Tagessatz, gbc_rdbtn_Position_Tagessatz);
		
		rdbtn_Position_Honorarsatz = new JRadioButton("Honorarsatz");
		buttonGroup_Position_Satz.add(rdbtn_Position_Honorarsatz);
		GridBagConstraints gbc_rdbtn_Position_Honorarsatz = new GridBagConstraints();
		gbc_rdbtn_Position_Honorarsatz.anchor = GridBagConstraints.WEST;
		gbc_rdbtn_Position_Honorarsatz.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtn_Position_Honorarsatz.gridx = 0;
		gbc_rdbtn_Position_Honorarsatz.gridy = 2;
		panel_Position_RadioButtons.add(rdbtn_Position_Honorarsatz, gbc_rdbtn_Position_Honorarsatz);
		
		JPanel panel_Position_Speichern = new JPanel();
		GridBagConstraints gbc_panel_Position_Speichern = new GridBagConstraints();
		gbc_panel_Position_Speichern.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Position_Speichern.fill = GridBagConstraints.BOTH;
		gbc_panel_Position_Speichern.gridx = 1;
		gbc_panel_Position_Speichern.gridy = 5;
		panel_Position_Daten.add(panel_Position_Speichern, gbc_panel_Position_Speichern);
		GridBagLayout gbl_panel_Position_Speichern = new GridBagLayout();
		gbl_panel_Position_Speichern.columnWidths = new int[]{0, 25, 130, 0};
		gbl_panel_Position_Speichern.rowHeights = new int[]{0, 0};
		gbl_panel_Position_Speichern.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Position_Speichern.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_Position_Speichern.setLayout(gbl_panel_Position_Speichern);
		
		btn_Position_Speichern = new JButton("Speichern");
		btn_Position_Speichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Position_Speichern.setPreferredSize(new Dimension(130, 25));
		btn_Position_Speichern.setMinimumSize(new Dimension(130, 25));
		btn_Position_Speichern.setMaximumSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Position_Speichern = new GridBagConstraints();
		gbc_btn_Position_Speichern.gridx = 2;
		gbc_btn_Position_Speichern.gridy = 0;
		panel_Position_Speichern.add(btn_Position_Speichern, gbc_btn_Position_Speichern);
		
		JPanel panel_Position_Abstandshalter_2 = new JPanel();
		GridBagConstraints gbc_panel_Position_Abstandshalter_2 = new GridBagConstraints();
		gbc_panel_Position_Abstandshalter_2.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel_Position_Abstandshalter_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Position_Abstandshalter_2.gridx = 3;
		gbc_panel_Position_Abstandshalter_2.gridy = 2;
		TabPosition.add(panel_Position_Abstandshalter_2, gbc_panel_Position_Abstandshalter_2);
		GridBagLayout gbl_panel_Position_Abstandshalter_2 = new GridBagLayout();
		gbl_panel_Position_Abstandshalter_2.columnWidths = new int[]{0, 0};
		gbl_panel_Position_Abstandshalter_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_Position_Abstandshalter_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_Position_Abstandshalter_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Position_Abstandshalter_2.setLayout(gbl_panel_Position_Abstandshalter_2);
		
		JPanel TabOptionen = new JPanel();
		tabbedPane.addTab("Optionen", null, TabOptionen, null);
		GridBagLayout gbl_TabOptionen = new GridBagLayout();
		gbl_TabOptionen.columnWidths = new int[]{25, 0, 25, 130, 100, 25, 0};
		gbl_TabOptionen.rowHeights = new int[]{25, 0, 0, 0, 25, 0, 0, 0, 0, 25, 0, 0, 50, 25, 0};
		gbl_TabOptionen.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_TabOptionen.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		TabOptionen.setLayout(gbl_TabOptionen);
		
		JLabel lbl_Optionen_Rechnungen = new JLabel("Rechnungen");
		lbl_Optionen_Rechnungen.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lbl_Optionen_Rechnungen = new GridBagConstraints();
		gbc_lbl_Optionen_Rechnungen.anchor = GridBagConstraints.WEST;
		gbc_lbl_Optionen_Rechnungen.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Optionen_Rechnungen.gridx = 1;
		gbc_lbl_Optionen_Rechnungen.gridy = 1;
		TabOptionen.add(lbl_Optionen_Rechnungen, gbc_lbl_Optionen_Rechnungen);
		
		JLabel lbl_Optionen_Speicherpfad = new JLabel("Speicherpfad: ");
		lbl_Optionen_Speicherpfad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Optionen_Speicherpfad = new GridBagConstraints();
		gbc_lbl_Optionen_Speicherpfad.anchor = GridBagConstraints.WEST;
		gbc_lbl_Optionen_Speicherpfad.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Optionen_Speicherpfad.gridx = 1;
		gbc_lbl_Optionen_Speicherpfad.gridy = 2;
		TabOptionen.add(lbl_Optionen_Speicherpfad, gbc_lbl_Optionen_Speicherpfad);
		
		textField_Optionen_Speicherpfad = new JTextField();
		textField_Optionen_Speicherpfad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_Optionen_Speicherpfad = new GridBagConstraints();
		gbc_textField_Optionen_Speicherpfad.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Optionen_Speicherpfad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Optionen_Speicherpfad.gridx = 1;
		gbc_textField_Optionen_Speicherpfad.gridy = 3;
		TabOptionen.add(textField_Optionen_Speicherpfad, gbc_textField_Optionen_Speicherpfad);
		textField_Optionen_Speicherpfad.setColumns(10);
		
		btn_Optionen_Speicherpfad = new JButton("Pfad ausw\u00E4hlen");
		btn_Optionen_Speicherpfad.setPreferredSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Optionen_Speicherpfad = new GridBagConstraints();
		gbc_btn_Optionen_Speicherpfad.anchor = GridBagConstraints.EAST;
		gbc_btn_Optionen_Speicherpfad.insets = new Insets(0, 0, 5, 5);
		gbc_btn_Optionen_Speicherpfad.gridx = 3;
		gbc_btn_Optionen_Speicherpfad.gridy = 3;
		TabOptionen.add(btn_Optionen_Speicherpfad, gbc_btn_Optionen_Speicherpfad);
		
		JLabel lbl_Optionen_Datenbank = new JLabel("Datenbank");
		lbl_Optionen_Datenbank.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lbl_Optionen_Datenbank = new GridBagConstraints();
		gbc_lbl_Optionen_Datenbank.anchor = GridBagConstraints.WEST;
		gbc_lbl_Optionen_Datenbank.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Optionen_Datenbank.gridx = 1;
		gbc_lbl_Optionen_Datenbank.gridy = 5;
		TabOptionen.add(lbl_Optionen_Datenbank, gbc_lbl_Optionen_Datenbank);
		
		JLabel lbl_Optionen_Adresse = new JLabel("Adresse: ");
		lbl_Optionen_Adresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Optionen_Adresse = new GridBagConstraints();
		gbc_lbl_Optionen_Adresse.anchor = GridBagConstraints.WEST;
		gbc_lbl_Optionen_Adresse.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Optionen_Adresse.gridx = 1;
		gbc_lbl_Optionen_Adresse.gridy = 6;
		TabOptionen.add(lbl_Optionen_Adresse, gbc_lbl_Optionen_Adresse);
		
		textField_Optionen_dbAdresse = new JTextField();
		textField_Optionen_dbAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_Optionen_dbAdresse = new GridBagConstraints();
		gbc_textField_Optionen_dbAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Optionen_dbAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Optionen_dbAdresse.gridx = 1;
		gbc_textField_Optionen_dbAdresse.gridy = 7;
		TabOptionen.add(textField_Optionen_dbAdresse, gbc_textField_Optionen_dbAdresse);
		textField_Optionen_dbAdresse.setColumns(10);
		
		JPanel panel_Optionen_Datenbank_Benutzerdaten = new JPanel();
		GridBagConstraints gbc_panel_Optionen_Datenbank_Benutzerdaten = new GridBagConstraints();
		gbc_panel_Optionen_Datenbank_Benutzerdaten.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Optionen_Datenbank_Benutzerdaten.fill = GridBagConstraints.BOTH;
		gbc_panel_Optionen_Datenbank_Benutzerdaten.gridx = 1;
		gbc_panel_Optionen_Datenbank_Benutzerdaten.gridy = 8;
		TabOptionen.add(panel_Optionen_Datenbank_Benutzerdaten, gbc_panel_Optionen_Datenbank_Benutzerdaten);
		GridBagLayout gbl_panel_Optionen_Datenbank_Benutzerdaten = new GridBagLayout();
		gbl_panel_Optionen_Datenbank_Benutzerdaten.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_Optionen_Datenbank_Benutzerdaten.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_Optionen_Datenbank_Benutzerdaten.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Optionen_Datenbank_Benutzerdaten.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Optionen_Datenbank_Benutzerdaten.setLayout(gbl_panel_Optionen_Datenbank_Benutzerdaten);
		
		JLabel lbl_Optionen_Benutzername = new JLabel("Benutzername: ");
		lbl_Optionen_Benutzername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Optionen_Benutzername = new GridBagConstraints();
		gbc_lbl_Optionen_Benutzername.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Optionen_Benutzername.gridx = 0;
		gbc_lbl_Optionen_Benutzername.gridy = 0;
		panel_Optionen_Datenbank_Benutzerdaten.add(lbl_Optionen_Benutzername, gbc_lbl_Optionen_Benutzername);
		
		textField_Optionen_dbBenutzername = new JTextField();
		textField_Optionen_dbBenutzername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_Optionen_dbBenutzername = new GridBagConstraints();
		gbc_textField_Optionen_dbBenutzername.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Optionen_dbBenutzername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Optionen_dbBenutzername.gridx = 2;
		gbc_textField_Optionen_dbBenutzername.gridy = 0;
		panel_Optionen_Datenbank_Benutzerdaten.add(textField_Optionen_dbBenutzername, gbc_textField_Optionen_dbBenutzername);
		textField_Optionen_dbBenutzername.setColumns(10);
		
		JLabel lbl_Optionen_Passwort = new JLabel("Passwort: ");
		lbl_Optionen_Passwort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Optionen_Passwort = new GridBagConstraints();
		gbc_lbl_Optionen_Passwort.anchor = GridBagConstraints.WEST;
		gbc_lbl_Optionen_Passwort.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Optionen_Passwort.gridx = 0;
		gbc_lbl_Optionen_Passwort.gridy = 2;
		panel_Optionen_Datenbank_Benutzerdaten.add(lbl_Optionen_Passwort, gbc_lbl_Optionen_Passwort);
		
		passwordField_Optionen_dbPasswort = new JPasswordField();
		passwordField_Optionen_dbPasswort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordField_Optionen_dbPasswort = new GridBagConstraints();
		gbc_passwordField_Optionen_dbPasswort.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_Optionen_dbPasswort.gridx = 2;
		gbc_passwordField_Optionen_dbPasswort.gridy = 2;
		panel_Optionen_Datenbank_Benutzerdaten.add(passwordField_Optionen_dbPasswort, gbc_passwordField_Optionen_dbPasswort);
		
		lbl_Optionen_Optionen = new JLabel("Optionen");
		lbl_Optionen_Optionen.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lbl_Optionen_Optionen = new GridBagConstraints();
		gbc_lbl_Optionen_Optionen.anchor = GridBagConstraints.WEST;
		gbc_lbl_Optionen_Optionen.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Optionen_Optionen.gridx = 1;
		gbc_lbl_Optionen_Optionen.gridy = 10;
		TabOptionen.add(lbl_Optionen_Optionen, gbc_lbl_Optionen_Optionen);
		
		chckbx_Optionen_KundenAusblenden = new JCheckBox("Inaktive Kunden ausblenden");
		chckbx_Optionen_KundenAusblenden.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_chckbx_Optionen_KundenAusblenden = new GridBagConstraints();
		gbc_chckbx_Optionen_KundenAusblenden.anchor = GridBagConstraints.WEST;
		gbc_chckbx_Optionen_KundenAusblenden.insets = new Insets(0, 0, 5, 5);
		gbc_chckbx_Optionen_KundenAusblenden.gridx = 1;
		gbc_chckbx_Optionen_KundenAusblenden.gridy = 11;
		TabOptionen.add(chckbx_Optionen_KundenAusblenden, gbc_chckbx_Optionen_KundenAusblenden);
		
		btn_Optionen_Speichern = new JButton("Speichern");
		btn_Optionen_Speichern.setPreferredSize(new Dimension(130, 25));
		GridBagConstraints gbc_btn_Optionen_Speichern = new GridBagConstraints();
		gbc_btn_Optionen_Speichern.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btn_Optionen_Speichern.insets = new Insets(0, 0, 5, 5);
		gbc_btn_Optionen_Speichern.gridx = 3;
		gbc_btn_Optionen_Speichern.gridy = 12;
		TabOptionen.add(btn_Optionen_Speichern, gbc_btn_Optionen_Speichern);
		
		frame.setVisible(true);
	}



	public void TabRechnung() {
		frame_Rechnung = new JFrame();
		frame_Rechnung.setVisible(true);
		frame_Rechnung.setResizable(false);
		frame_Rechnung.setAlwaysOnTop(true);
		frame_Rechnung.setTitle("Rechnung");
		frame_Rechnung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_Rechnung.setBounds(100, 100, 900, 1000);
		
//		contentPane = new JPanel();
//		frame.getContentPane().setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_frame.getContentPane().columnWidths = new int[]{25, 100, 25, 0};
//		gbl_frame.getContentPane().rowHeights = new int[]{25, 0, 0, 50, 0, 0, 0, 0, 0, 200, 0, 0, 25, 0};
//		gbl_frame.getContentPane().columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
//		gbl_frame.getContentPane().rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		frame.getContentPane().setLayout(gbl_contentPane);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{25, 100, 25, 0};
        gridBagLayout.rowHeights = new int[]{25, 0, 0, 50, 0, 0, 0, 0, 0, 200, 0, 0, 25, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frame_Rechnung.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_Rechnung_Kunden_Daten = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Kunden_Daten = new GridBagConstraints();
		gbc_panel_Rechnung_Kunden_Daten.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panel_Rechnung_Kunden_Daten.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Kunden_Daten.gridx = 1;
		gbc_panel_Rechnung_Kunden_Daten.gridy = 1;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Kunden_Daten, gbc_panel_Rechnung_Kunden_Daten);
		GridBagLayout gbl_panel_Rechnung_Kunden_Daten = new GridBagLayout();
		gbl_panel_Rechnung_Kunden_Daten.columnWidths = new int[]{0, 0, 0};
		gbl_panel_Rechnung_Kunden_Daten.rowHeights = new int[]{20, 0, 10, 0, 10, 0, 20, 0};
		gbl_panel_Rechnung_Kunden_Daten.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Kunden_Daten.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbl_panel_Rechnung_Anschreiben.columnWidths = new int[]{100, 0};
		gbl_panel_Rechnung_Anschreiben.rowHeights = new int[]{0, 0};
		gbl_panel_Rechnung_Anschreiben.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Anschreiben.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		panel_Rechnung_Anschreiben.add(textArea_Rechnung_Rechnung_Anschreiben, gbc_textArea_Rechnung_Rechnung_Anschreiben);
		
		JPanel panel_Rechnung_Posten_Überschrift = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Überschrift = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Überschrift.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Rechnung_Posten_Überschrift.anchor = GridBagConstraints.SOUTH;
		gbc_panel_Rechnung_Posten_Überschrift.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Posten_Überschrift.gridx = 1;
		gbc_panel_Rechnung_Posten_Überschrift.gridy = 8;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Posten_Überschrift, gbc_panel_Rechnung_Posten_Überschrift);
		GridBagLayout gbl_panel_Rechnung_Posten_Überschrift = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Überschrift.columnWidths = new int[]{0, 30, 15, 250, 30, 100, 25, 60, 25, 110, 25, 110, 20, 0};
		gbl_panel_Rechnung_Posten_Überschrift.rowHeights = new int[]{0, 0, 0};
		gbl_panel_Rechnung_Posten_Überschrift.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Posten_Überschrift.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
		panel_Rechnung_Posten_Überschrift.add(lbl_Rechnungen_Rechnung_Satz_in_Euro, gbc_lbl_Rechnungen_Rechnung_Satz_in_Euro);
		
		JLabel lbl_Rechnung_rechnung_Gesamt_in_Euro = new JLabel("Gesamt/\u20AC");
		lbl_Rechnung_rechnung_Gesamt_in_Euro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro = new GridBagConstraints();
		gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro.gridx = 11;
		gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro.gridy = 1;
		panel_Rechnung_Posten_Überschrift.add(lbl_Rechnung_rechnung_Gesamt_in_Euro, gbc_lbl_Rechnung_rechnung_Gesamt_in_Euro);
		
		JScrollPane scrollPane_Rechnung_Posten = new JScrollPane();
		GridBagConstraints gbc_scrollPane_Rechnung_Posten = new GridBagConstraints();
		gbc_scrollPane_Rechnung_Posten.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_Rechnung_Posten.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_Rechnung_Posten.gridx = 1;
		gbc_scrollPane_Rechnung_Posten.gridy = 9;
		frame_Rechnung.getContentPane().add(scrollPane_Rechnung_Posten, gbc_scrollPane_Rechnung_Posten);
		
		JPanel panel_Rechnung_Posten_Gesamt = new JPanel();
		panel_Rechnung_Posten_Gesamt.setPreferredSize(new Dimension(575, 150));
		panel_Rechnung_Posten_Gesamt.setMinimumSize(new Dimension(575, 150));
		panel_Rechnung_Posten_Gesamt.setMaximumSize(new Dimension(575, 150));
		scrollPane_Rechnung_Posten.setViewportView(panel_Rechnung_Posten_Gesamt);
		GridBagLayout gbl_panel_Rechnung_Posten_Gesamt = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Gesamt.columnWidths = new int[]{0, 0};
		gbl_panel_Rechnung_Posten_Gesamt.rowHeights = new int[]{0, 0, 0};
		gbl_panel_Rechnung_Posten_Gesamt.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Posten_Gesamt.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_Rechnung_Posten_Gesamt.setLayout(gbl_panel_Rechnung_Posten_Gesamt);
		
		JPanel panel_Rechnung_Posten_sub = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_sub = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_sub.anchor = GridBagConstraints.NORTH;
		gbc_panel_Rechnung_Posten_sub.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Rechnung_Posten_sub.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Rechnung_Posten_sub.gridx = 0;
		gbc_panel_Rechnung_Posten_sub.gridy = 0;
		panel_Rechnung_Posten_Gesamt.add(panel_Rechnung_Posten_sub, gbc_panel_Rechnung_Posten_sub);
		GridBagLayout gbl_panel_Rechnung_Posten_sub = new GridBagLayout();
		gbl_panel_Rechnung_Posten_sub.columnWidths = new int[]{0, 0};
		gbl_panel_Rechnung_Posten_sub.rowHeights = new int[]{25, 25, 0, 0};
		gbl_panel_Rechnung_Posten_sub.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Posten_sub.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_Rechnung_Posten_sub.setLayout(gbl_panel_Rechnung_Posten_sub);
		
		JPanel panel_Rechnung_Posten_Posten_1 = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Posten_1 = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Posten_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Rechnung_Posten_Posten_1.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Posten_Posten_1.gridx = 0;
		gbc_panel_Rechnung_Posten_Posten_1.gridy = 0;
		panel_Rechnung_Posten_sub.add(panel_Rechnung_Posten_Posten_1, gbc_panel_Rechnung_Posten_Posten_1);
		GridBagLayout gbl_panel_Rechnung_Posten_Posten_1 = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Posten_1.columnWidths = new int[]{0, 30, 15, 250, 25, 100, 25, 60, 25, 110, 25, 110, 20, 0};
		gbl_panel_Rechnung_Posten_Posten_1.rowHeights = new int[]{0, 0};
		gbl_panel_Rechnung_Posten_Posten_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Posten_Posten_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_Rechnung_Posten_Posten_1.setLayout(gbl_panel_Rechnung_Posten_Posten_1);
		
		JLabel lbl_Rechnung_Posten_Nr_1 = new JLabel("123");
		lbl_Rechnung_Posten_Nr_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Nr_1 = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Nr_1.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Posten_Nr_1.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Nr_1.gridx = 1;
		gbc_lbl_Rechnung_Posten_Nr_1.gridy = 0;
		panel_Rechnung_Posten_Posten_1.add(lbl_Rechnung_Posten_Nr_1, gbc_lbl_Rechnung_Posten_Nr_1);
		
		JComboBox comboBox_Rechnung_Posten_Bezeichnung_1 = new JComboBox();
		comboBox_Rechnung_Posten_Bezeichnung_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox_Rechnung_Posten_Bezeichnung_1 = new GridBagConstraints();
		gbc_comboBox_Rechnung_Posten_Bezeichnung_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_Rechnung_Posten_Bezeichnung_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Rechnung_Posten_Bezeichnung_1.gridx = 3;
		gbc_comboBox_Rechnung_Posten_Bezeichnung_1.gridy = 0;
		panel_Rechnung_Posten_Posten_1.add(comboBox_Rechnung_Posten_Bezeichnung_1, gbc_comboBox_Rechnung_Posten_Bezeichnung_1);
		
		JLabel lbl_Rechnung_Posten_Satz_1 = new JLabel("Honorarbasis");
		lbl_Rechnung_Posten_Satz_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Satz_1 = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Satz_1.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Posten_Satz_1.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Satz_1.gridx = 5;
		gbc_lbl_Rechnung_Posten_Satz_1.gridy = 0;
		panel_Rechnung_Posten_Posten_1.add(lbl_Rechnung_Posten_Satz_1, gbc_lbl_Rechnung_Posten_Satz_1);
		
		textField_Rechnung_Posten_Einheiten_1 = new JTextField();
		textField_Rechnung_Posten_Einheiten_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textField_Rechnung_Posten_Einheiten_1 = new GridBagConstraints();
		gbc_textField_Rechnung_Posten_Einheiten_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Rechnung_Posten_Einheiten_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Posten_Einheiten_1.gridx = 7;
		gbc_textField_Rechnung_Posten_Einheiten_1.gridy = 0;
		panel_Rechnung_Posten_Posten_1.add(textField_Rechnung_Posten_Einheiten_1, gbc_textField_Rechnung_Posten_Einheiten_1);
		textField_Rechnung_Posten_Einheiten_1.setColumns(10);
		
		textField_Rechnung_Posten_Satz_in_Euro_1 = new JTextField();
		textField_Rechnung_Posten_Satz_in_Euro_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textField_Rechnung_Posten_Satz_in_Euro_1 = new GridBagConstraints();
		gbc_textField_Rechnung_Posten_Satz_in_Euro_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Rechnung_Posten_Satz_in_Euro_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Posten_Satz_in_Euro_1.gridx = 9;
		gbc_textField_Rechnung_Posten_Satz_in_Euro_1.gridy = 0;
		panel_Rechnung_Posten_Posten_1.add(textField_Rechnung_Posten_Satz_in_Euro_1, gbc_textField_Rechnung_Posten_Satz_in_Euro_1);
		textField_Rechnung_Posten_Satz_in_Euro_1.setColumns(10);
		
		JLabel lbl_Rechnung_Posten_Gesamt_in_Euro_1 = new JLabel("1.000.000,00\u20AC");
		lbl_Rechnung_Posten_Gesamt_in_Euro_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_1 = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_1.anchor = GridBagConstraints.EAST;
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_1.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_1.gridx = 11;
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_1.gridy = 0;
		panel_Rechnung_Posten_Posten_1.add(lbl_Rechnung_Posten_Gesamt_in_Euro_1, gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_1);
		
		JPanel panel_Rechnung_Posten_Posten_2 = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Posten_2 = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Posten_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Rechnung_Posten_Posten_2.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Posten_Posten_2.gridx = 0;
		gbc_panel_Rechnung_Posten_Posten_2.gridy = 1;
		panel_Rechnung_Posten_sub.add(panel_Rechnung_Posten_Posten_2, gbc_panel_Rechnung_Posten_Posten_2);
		GridBagLayout gbl_panel_Rechnung_Posten_Posten_2 = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Posten_2.columnWidths = new int[]{0, 30, 15, 250, 25, 100, 25, 60, 25, 110, 25, 110, 20, 0};
		gbl_panel_Rechnung_Posten_Posten_2.rowHeights = new int[]{0, 0};
		gbl_panel_Rechnung_Posten_Posten_2.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Posten_Posten_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_Rechnung_Posten_Posten_2.setLayout(gbl_panel_Rechnung_Posten_Posten_2);
		
		JLabel lbl_Rechnung_Posten_Nr_2 = new JLabel("123");
		lbl_Rechnung_Posten_Nr_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Nr_2 = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Nr_2.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Posten_Nr_2.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Nr_2.gridx = 1;
		gbc_lbl_Rechnung_Posten_Nr_2.gridy = 0;
		panel_Rechnung_Posten_Posten_2.add(lbl_Rechnung_Posten_Nr_2, gbc_lbl_Rechnung_Posten_Nr_2);
		
		JComboBox comboBox_Rechung_Posten_Bezeichnung_2 = new JComboBox();
		comboBox_Rechung_Posten_Bezeichnung_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox_Rechung_Posten_Bezeichnung_2 = new GridBagConstraints();
		gbc_comboBox_Rechung_Posten_Bezeichnung_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Rechung_Posten_Bezeichnung_2.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_Rechung_Posten_Bezeichnung_2.gridx = 3;
		gbc_comboBox_Rechung_Posten_Bezeichnung_2.gridy = 0;
		panel_Rechnung_Posten_Posten_2.add(comboBox_Rechung_Posten_Bezeichnung_2, gbc_comboBox_Rechung_Posten_Bezeichnung_2);
		
		JLabel lbl_Rechnung_Posten_Satz_2 = new JLabel("Honorarbasis");
		lbl_Rechnung_Posten_Satz_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Satz_2 = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Satz_2.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Posten_Satz_2.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Satz_2.gridx = 5;
		gbc_lbl_Rechnung_Posten_Satz_2.gridy = 0;
		panel_Rechnung_Posten_Posten_2.add(lbl_Rechnung_Posten_Satz_2, gbc_lbl_Rechnung_Posten_Satz_2);
		
		textField_Rechnung_Posten_Einheiten_2 = new JTextField();
		textField_Rechnung_Posten_Einheiten_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Rechnung_Posten_Einheiten_2.setColumns(10);
		GridBagConstraints gbc_textField_Rechnung_Posten_Einheiten_2 = new GridBagConstraints();
		gbc_textField_Rechnung_Posten_Einheiten_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Posten_Einheiten_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Rechnung_Posten_Einheiten_2.gridx = 7;
		gbc_textField_Rechnung_Posten_Einheiten_2.gridy = 0;
		panel_Rechnung_Posten_Posten_2.add(textField_Rechnung_Posten_Einheiten_2, gbc_textField_Rechnung_Posten_Einheiten_2);
		
		textField_Rechnung_Posten_Satz_in_Euro_2 = new JTextField();
		textField_Rechnung_Posten_Satz_in_Euro_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Rechnung_Posten_Satz_in_Euro_2.setColumns(10);
		GridBagConstraints gbc_textField_Rechnung_Posten_Satz_in_Euro_2 = new GridBagConstraints();
		gbc_textField_Rechnung_Posten_Satz_in_Euro_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Rechnung_Posten_Satz_in_Euro_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Rechnung_Posten_Satz_in_Euro_2.gridx = 9;
		gbc_textField_Rechnung_Posten_Satz_in_Euro_2.gridy = 0;
		panel_Rechnung_Posten_Posten_2.add(textField_Rechnung_Posten_Satz_in_Euro_2, gbc_textField_Rechnung_Posten_Satz_in_Euro_2);
		
		JLabel lbl_Rechnung_Posten_Gesamt_in_Euro_2 = new JLabel("1.000.000,00\u20AC");
		lbl_Rechnung_Posten_Gesamt_in_Euro_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_2 = new GridBagConstraints();
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_2.anchor = GridBagConstraints.EAST;
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_2.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_2.gridx = 11;
		gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_2.gridy = 0;
		panel_Rechnung_Posten_Posten_2.add(lbl_Rechnung_Posten_Gesamt_in_Euro_2, gbc_lbl_Rechnung_Posten_Gesamt_in_Euro_2);
		
		JPanel panel_Rechnung_Posten_Buttons = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Posten_Buttons = new GridBagConstraints();
		gbc_panel_Rechnung_Posten_Buttons.fill = GridBagConstraints.BOTH;
		gbc_panel_Rechnung_Posten_Buttons.gridx = 0;
		gbc_panel_Rechnung_Posten_Buttons.gridy = 1;
		panel_Rechnung_Posten_Gesamt.add(panel_Rechnung_Posten_Buttons, gbc_panel_Rechnung_Posten_Buttons);
		GridBagLayout gbl_panel_Rechnung_Posten_Buttons = new GridBagLayout();
		gbl_panel_Rechnung_Posten_Buttons.columnWidths = new int[]{0, 0, 10, 0, 0};
		gbl_panel_Rechnung_Posten_Buttons.rowHeights = new int[]{0, 0};
		gbl_panel_Rechnung_Posten_Buttons.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Posten_Buttons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_Rechnung_Posten_Buttons.setLayout(gbl_panel_Rechnung_Posten_Buttons);
		
		btn_Rechnung_Posten_Plus = new JButton("+");
		btn_Rechnung_Posten_Plus.setPreferredSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Plus.setMinimumSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Plus.setMaximumSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Plus.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_btn_Rechnung_Posten_Plus = new GridBagConstraints();
		gbc_btn_Rechnung_Posten_Plus.insets = new Insets(0, 0, 0, 5);
		gbc_btn_Rechnung_Posten_Plus.gridx = 1;
		gbc_btn_Rechnung_Posten_Plus.gridy = 0;
		panel_Rechnung_Posten_Buttons.add(btn_Rechnung_Posten_Plus, gbc_btn_Rechnung_Posten_Plus);
		
		btn_Rechnung_Posten_Minus = new JButton("-");
		btn_Rechnung_Posten_Minus.setPreferredSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Minus.setMinimumSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Minus.setMaximumSize(new Dimension(50, 50));
		btn_Rechnung_Posten_Minus.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_btn_Rechnung_Posten_Minus = new GridBagConstraints();
		gbc_btn_Rechnung_Posten_Minus.gridx = 3;
		gbc_btn_Rechnung_Posten_Minus.gridy = 0;
		panel_Rechnung_Posten_Buttons.add(btn_Rechnung_Posten_Minus, gbc_btn_Rechnung_Posten_Minus);
		
		JPanel panel_Rechnung_Summe = new JPanel();
		GridBagConstraints gbc_panel_Rechnung_Summe = new GridBagConstraints();
		gbc_panel_Rechnung_Summe.anchor = GridBagConstraints.EAST;
		gbc_panel_Rechnung_Summe.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Rechnung_Summe.gridx = 1;
		gbc_panel_Rechnung_Summe.gridy = 10;
		frame_Rechnung.getContentPane().add(panel_Rechnung_Summe, gbc_panel_Rechnung_Summe);
		GridBagLayout gbl_panel_Rechnung_Summe = new GridBagLayout();
		gbl_panel_Rechnung_Summe.columnWidths = new int[]{25, 0, 25, 120, 20, 0};
		gbl_panel_Rechnung_Summe.rowHeights = new int[]{0, 0, 0};
		gbl_panel_Rechnung_Summe.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Summe.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_Rechnung_Summe.setLayout(gbl_panel_Rechnung_Summe);
		
		JLabel lbl_Rechnung_Summe_Netto = new JLabel("Summe Netto: ");
		lbl_Rechnung_Summe_Netto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lbl_Rechnung_Summe_Netto = new GridBagConstraints();
		gbc_lbl_Rechnung_Summe_Netto.anchor = GridBagConstraints.WEST;
		gbc_lbl_Rechnung_Summe_Netto.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_Rechnung_Summe_Netto.gridx = 1;
		gbc_lbl_Rechnung_Summe_Netto.gridy = 0;
		panel_Rechnung_Summe.add(lbl_Rechnung_Summe_Netto, gbc_lbl_Rechnung_Summe_Netto);
		
		lbl_Rechnung_Summe_Netto_in_Euro = new JLabel("1.000.000,00\u20AC");
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
		gbl_panel_Rechnung_Speichern_Buttons.columnWidths = new int[]{0, 25, 0, 0};
		gbl_panel_Rechnung_Speichern_Buttons.rowHeights = new int[]{0, 0};
		gbl_panel_Rechnung_Speichern_Buttons.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Rechnung_Speichern_Buttons.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
	}

	
	
	public void tabAktualisieren ()
	{
		
	}
}
