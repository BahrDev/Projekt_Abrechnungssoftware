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
import javax.swing.JTabbedPane;
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


	public void tabAktualisieren ()
	{
		
	}
}
