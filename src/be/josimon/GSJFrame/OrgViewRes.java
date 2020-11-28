package be.josimon.GSJFrame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.josimon.GSPOJO.Organisateur;
import be.josimon.GSPOJO.PlanningSalle;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class OrgViewRes extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame instance = this;
	private JTable table;
	private JButton btnpay;
	private JScrollPane scrollPane;
	/**
	 * Create the frame.
	 */
	public OrgViewRes(Organisateur orga) {
		List<PlanningSalle> plan = new ArrayList<PlanningSalle>();
		plan = orga.getReservation();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Vos réservations de la salle");
		Object[] toTable = new Object[7];
				
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 727, 659);
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
		contentPane.add(table.getTableHeader());
		
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
		
		btnpay = new JButton("Payer");
		btnpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					int id = (Integer) table.getModel().getValueAt(row, 6);
					String statut = (String) table.getModel().getValueAt(row, 2);
					if(statut.equals("Payé")) {
						JOptionPane.showMessageDialog(null,"Vous ne pouvez pas payer une reservation déja payé");
					} else {
						boolean test = orga.payReservation(id);
						if(test == true) {
							JOptionPane.showMessageDialog(null, "Payement effectué.");
							table.setValueAt("Payé", row, 2);
						} else {
							JOptionPane.showMessageDialog(null, "Un problème est survenue, contactez un administrateur.");
						}
					}
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Pour payer, il faut selectionner une reservation a payer.");
				}
			}
		});
		btnpay.setBounds(759, 11, 113, 37);
		contentPane.add(btnpay);
	}
}
