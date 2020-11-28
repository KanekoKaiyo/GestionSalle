package be.josimon.GSJFrame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.josimon.GSPOJO.Artiste;
import be.josimon.GSPOJO.Configuration;
import be.josimon.GSPOJO.Organisateur;
import be.josimon.GSPOJO.PlanningSalle;
import be.josimon.GSPOJO.Reservation;
import be.josimon.GSPOJO.Spectacle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class OrgCrSpec extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame instance = this;
	private JTable table = new JTable();
	private JTextField tfTitre;
	private JComboBox<Object> boxart;
	private JComboBox<Object> boxconfig;
	private JLabel lblNewLabel_1;
	private JTextField tfplmax;
	private JLabel lblNewLabel_2;
	private JButton btnValider;
	private JButton btnleave;

	/**
	 * Create the frame.
	 */
	public OrgCrSpec(Organisateur orga) {
		Spectacle spec = new Spectacle();
		List<PlanningSalle> plan = new ArrayList<PlanningSalle>();
		plan = orga.getReservation();
		Artiste art = new Artiste();
		List<Artiste> arts = art.getAll();
		List<Configuration> confs = spec.getAllConfig();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Creer un spectacle");
		Object[] toTable = new Object[7];
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Date d\u00E9but", "Date Fin", "Statut", "Prix", "Acompte", "Solde", "idReservation"
				}
			));
		contentPane.add(table.getTableHeader());	
			
		JLabel lblNewLabel = new JLabel("Titre :");
		lblNewLabel.setBounds(759, 11, 74, 29);
		contentPane.add(lblNewLabel);
		
		tfTitre = new JTextField();
		tfTitre.setBounds(843, 15, 117, 20);
		contentPane.add(tfTitre);
		tfTitre.setColumns(10);
		
		boxart = new JComboBox<Object>();
		boxart.setLocation(759, 51);
		boxart.setSize(201, 29);
		getContentPane().add(boxart);
		
		boxconfig = new JComboBox<Object>();
		boxconfig.setLocation(759, 167);
		boxconfig.setSize(201, 29);
		getContentPane().add(boxconfig);
		
		lblNewLabel_1 = new JLabel("Place Max Par Client :");
		lblNewLabel_1.setBounds(712, 103, 151, 14);
		contentPane.add(lblNewLabel_1);
		
		tfplmax = new JTextField();
		tfplmax.setBounds(873, 100, 86, 20);
		contentPane.add(tfplmax);
		tfplmax.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Configuration :");
		lblNewLabel_2.setBounds(759, 142, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(759, 207, 89, 23);
		contentPane.add(btnValider);
		
		btnleave = new JButton("Quitter");
		btnleave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrgAcc frame2 = new OrgAcc(orga);
				instance.dispose();
				frame2.setVisible(true);
			}
		});
		btnleave.setBounds(759, 647, 89, 23);
		contentPane.add(btnleave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 671, 659);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Date d\u00E9but", "Date Fin", "Statut", "Prix", "Acompte", "Solde", "idReservation"
			}
		));
		
		JButton btnNewButton = new JButton("Ajouter Artiste\r\n");
		btnNewButton.setBounds(970, 54, 127, 23);
		contentPane.add(btnNewButton);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(PlanningSalle pls:plan) {
			toTable[0] = pls.getDateDébutReservation();
			toTable[1] = pls.getDateFinReservation();
			toTable[2] = pls.getReservation().getStatut();
			toTable[3] = pls.getReservation().getPrix();
			toTable[4] = pls.getReservation().getAcompte();
			toTable[5] = pls.getReservation().getSolde();
			toTable[6] = pls.getReservation().getIdRéservation();
			model.addRow(toTable);
		}
		
		for(Artiste art1:arts) {
			boxart.addItem(art1.getNom() + " " + art1.getPrenom());
		}
		
		for(Configuration conf:confs) {
			boxconfig.addItem(conf.getType());
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spec.addArt(art);
			}
		});
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idres = (int) table.getModel().getValueAt(table.getSelectedRow(),6);
					String titre = tfTitre.getText();
					int placemax = Integer.valueOf(tfplmax.getText());
					if(spec.getListArtiste().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vous devez selectionner au moins un artiste");
					} else {
						if(titre == null) {
							JOptionPane.showMessageDialog(null, "Le titre ne peut pas être vide");
						} else {
							PlanningSalle plan = new PlanningSalle();
							Reservation res = new Reservation();
							res.setIdRéservation(idres);
							plan.setReservation(res);
							spec.setPlan(plan);
							spec.setPlaceParClient(placemax);
							spec.setTitre(titre);
							spec.setConfig(new Configuration(boxconfig.getSelectedItem().toString()));
							if(spec.create()) {
								JOptionPane.showMessageDialog(null, "La création du spectacle a été effectué");
							} else {
								JOptionPane.showMessageDialog(null, "La création du spectacle a échoué");
							}
						}
					}
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Une erreur est survenue, verifié vos champs et selectionner bien une reservation.");
				}
			}
		});
	}
}
