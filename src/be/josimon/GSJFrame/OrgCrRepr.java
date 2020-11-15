package be.josimon.GSJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.josimon.GSPOJO.Organisateur;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OrgCrRepr extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame instance = this;
	private JTable table = new JTable();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 */
	public OrgCrRepr(Organisateur orga) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Creer représentation");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date d\u00E9but", "Date Fin", "Statut"
			}
		));
		table.setBounds(5, 5, 586, 665);
		contentPane.add(table);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(601, 11, 190, 146);
		contentPane.add(calendar);
		
		JLabel lblNewLabel = new JLabel("Heure de d\u00E9but :");
		lblNewLabel.setBounds(601, 168, 99, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(710, 165, 38, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("H");
		lblNewLabel_1.setBounds(758, 168, 16, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(768, 165, 38, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHeureDeFin = new JLabel("Heure de fin :");
		lblHeureDeFin.setBounds(601, 199, 99, 14);
		contentPane.add(lblHeureDeFin);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(710, 196, 38, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("H");
		lblNewLabel_1_1.setBounds(758, 199, 16, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(768, 196, 38, 20);
		contentPane.add(textField_3);
		
		JButton btnleave = new JButton("Quitter");
		btnleave.setBounds(601, 647, 89, 23);
		contentPane.add(btnleave);
		
		JButton btnadd = new JButton("Ajouter");
		btnadd.setBounds(601, 224, 89, 23);
		contentPane.add(btnadd);
	}
}
