package be.josimon.GSJFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.josimon.GSPOJO.Client;
import be.josimon.GSPOJO.Personne;

public class ClAcc extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ClAcc(Client cl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
