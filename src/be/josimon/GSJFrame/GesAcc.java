package be.josimon.GSJFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.josimon.GSPOJO.Gestionnaire;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GesAcc extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public GesAcc(Gestionnaire ges) {
		JFrame instance = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnrsvsalle = new JButton("Reserver la Salle");
		btnrsvsalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GesCrRes frame2 = new GesCrRes(ges);
				frame2.setVisible(true);
				instance.dispose();
			}
		});
		btnrsvsalle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnrsvsalle.setBounds(666, 11, 588, 315);
		contentPane.add(btnrsvsalle);
		
		JButton btnNewButton_1_1 = new JButton("Voir mes reservations");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton_1_1.setBounds(666, 355, 588, 315);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Cr\u00E9er un Spectacle");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1_1.setBounds(10, 11, 286, 315);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Cr\u00E9er une repr\u00E9sentation");
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1_2.setBounds(10, 355, 286, 315);
		contentPane.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Voir mes Spectacle");
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1_1_1.setBounds(306, 11, 286, 315);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_2_1 = new JButton("Voir mes repr\u00E9sentation");
		btnNewButton_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1_2_1.setBounds(306, 355, 286, 315);
		contentPane.add(btnNewButton_1_1_2_1);
		setTitle("Accueil Gestion" + ges.getNom() + " " + ges.getPrenom());
	}
}
