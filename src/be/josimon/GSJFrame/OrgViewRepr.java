package be.josimon.GSJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.josimon.GSPOJO.Organisateur;

public class OrgViewRepr extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame instance = this;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public OrgViewRepr(Organisateur orga) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Vos réservations de la salle");
		
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
		
		JButton btnleave = new JButton("Quitter");
		btnleave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrgAcc frame2 = new OrgAcc(orga);
				instance.dispose();
				frame2.setVisible(true);
			}
		});
		btnleave.setBounds(759, 626, 113, 44);
		contentPane.add(btnleave);
	}

}
