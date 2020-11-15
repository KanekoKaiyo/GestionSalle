package be.josimon.GSJFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.josimon.GSPOJO.Organisateur;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrgCrSpec extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame instance = this;
	private JTable table = new JTable();
	private JTextField tfTitre;
	private JComboBox<Object> box;
	private JComboBox<Object> box2;
	private JLabel lblNewLabel_1;
	private JTextField tfplmax;
	private JLabel lblNewLabel_2;
	private JButton btnValider;
	private JButton btnleave;
	/**
	 * Create the frame.
	 */
	public OrgCrSpec(Organisateur orga) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Creer un spectacle");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date d\u00E9but", "Date Fin", "Statut"
			}
		));
		table.setBounds(10, 11, 739, 659);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Titre :");
		lblNewLabel.setBounds(759, 11, 74, 29);
		contentPane.add(lblNewLabel);
		
		tfTitre = new JTextField();
		tfTitre.setBounds(843, 15, 117, 20);
		contentPane.add(tfTitre);
		tfTitre.setColumns(10);
		
		String[] test = {"test1","test2"};
		box = new JComboBox<Object>(test);
		box.setLocation(759, 51);
		box.setSize(201, 29);
		box.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						
					}
				}
		);
		getContentPane().add(box);
		
		box2 = new JComboBox<Object>(test);
		box2.setLocation(759, 167);
		box2.setSize(201, 29);
		box2.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						
					}
				}
		);
		getContentPane().add(box2);
		
		lblNewLabel_1 = new JLabel("Place Max Par Client :");
		lblNewLabel_1.setBounds(759, 103, 104, 14);
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
		
	}
}
