package be.josimon.GSJFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.josimon.GSPOJO.Client;
import be.josimon.GSPOJO.Organisateur;
import be.josimon.GSPOJO.Personne;
import be.josimon.GSDAO.AbstractDAOFactory;
import be.josimon.GSDAO.DAO;
import be.josimon.GSPOJO.Artiste;
import be.josimon.GSPOJO.Gestionnaire;

import be.josimon.util.Regex;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accueil extends JFrame {
	// Variable de la frame
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFcomail;
	private JTextField TFinsmail;
	private JPasswordField PFco;
	private JPasswordField PFins;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField TFnom;
	private JTextField TFprenom;
	private JTextField TFrue;
	private JTextField TFnum;
	private JTextField TFcp;
	private JTextField TFville;
	// variable dao
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Accueil() {
		// Création de la frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		buttonGroup.clearSelection();
		setTitle("Connexion et Inscription au Bosquet Wallon");
		JFrame instance = this;
		// Label titre du haut
		JLabel lblNewLabel = new JLabel("Gestion de salle : Bosquet Wallon");
		lblNewLabel.setBounds(400, 50, 500, 40);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.red);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 32));
		// Panel de gauche
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(30, 140, 500, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		// Label connexion
		JLabel lblNewLabel_1 = new JLabel("Connexion");
		lblNewLabel_1.setBounds(200, 20, 200, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 24));
		// TextField email connexion
		TFcomail = new JTextField();
		TFcomail.setBounds(200, 100, 200, 30);
		panel.add(TFcomail);
		TFcomail.setColumns(10);
		// PasswordField connexion
		PFco = new JPasswordField();
		PFco.setBounds(200, 160, 200, 30);
		panel.add(PFco);
		// lb email
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(130, 100, 60, 30);
		panel.add(lblNewLabel_3);
		// lb mdp
		JLabel lblNewLabel_4 = new JLabel("Mot de passe :");
		lblNewLabel_4.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(81, 160, 109, 30);
		panel.add(lblNewLabel_4);
		// Panel de droite
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(690, 140, 500, 400);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// Label Inscription
		JLabel lblNewLabel_2 = new JLabel("Inscription");
		lblNewLabel_2.setBounds(200, 20, 200, 20);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 24));
		// TextField Email Inscription
		TFinsmail = new JTextField();
		TFinsmail.setColumns(10);
		TFinsmail.setBounds(275, 100, 200, 30);
		panel_1.add(TFinsmail);
		// PasswordField Inscription
		PFins = new JPasswordField();
		PFins.setBounds(275, 160, 200, 30);
		panel_1.add(PFins);
		// radiobouton client
		JRadioButton rdclient = new JRadioButton("Client");
		rdclient.setBounds(275, 200, 100, 25);
		panel_1.add(rdclient);
		buttonGroup.add(rdclient);
		// radiobouton organisateur
		JRadioButton rdorga = new JRadioButton("Organisateur");
		rdorga.setBounds(275, 230, 100, 25);
		panel_1.add(rdorga);
		buttonGroup.add(rdorga);
		// radiobouton gestionnaire
		JRadioButton rdgest = new JRadioButton("Gestionnaire");
		rdgest.setBounds(375, 200, 100, 25);
		panel_1.add(rdgest);
		buttonGroup.add(rdgest);
		// rd artiste
		JRadioButton rdart = new JRadioButton("Artiste");
		rdart.setBounds(375, 231, 100, 25);
		panel_1.add(rdart);
		buttonGroup.add(rdart);
		// tf nom
		TFnom = new JTextField();
		TFnom.setBounds(100, 200, 130, 20);
		panel_1.add(TFnom);
		TFnom.setColumns(10);
		// tf prenom
		TFprenom = new JTextField();
		TFprenom.setBounds(100, 225, 130, 20);
		panel_1.add(TFprenom);
		TFprenom.setColumns(10);
		// tf rue
		TFrue = new JTextField();
		TFrue.setBounds(100, 250, 130, 20);
		panel_1.add(TFrue);
		TFrue.setColumns(10);
		// tf num rue
		TFnum = new JTextField();
		TFnum.setBounds(100, 275, 130, 20);
		panel_1.add(TFnum);
		TFnum.setColumns(10);
		// tf cp
		TFcp = new JTextField();
		TFcp.setBounds(100, 300, 130, 20);
		panel_1.add(TFcp);
		TFcp.setColumns(10);
		// tf ville
		TFville = new JTextField();
		TFville.setBounds(100, 325, 130, 20);
		panel_1.add(TFville);
		TFville.setColumns(10);
		// lb email
		JLabel lblNewLabel_3_1 = new JLabel("Email :");
		lblNewLabel_3_1.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(205, 100, 60, 30);
		panel_1.add(lblNewLabel_3_1);
		// lb mdp
		JLabel lblNewLabel_4_1 = new JLabel("Mot de passe :");
		lblNewLabel_4_1.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(156, 160, 109, 30);
		panel_1.add(lblNewLabel_4_1);
		// lb nom
		JLabel lblNewLabel_5 = new JLabel("Nom :");
		lblNewLabel_5.setBounds(44, 205, 46, 14);
		panel_1.add(lblNewLabel_5);
		// lb prenom
		JLabel lblNewLabel_6 = new JLabel("Prenom :");
		lblNewLabel_6.setBounds(44, 230, 46, 14);
		panel_1.add(lblNewLabel_6);
		// lb rue
		JLabel lblNewLabel_7 = new JLabel("Rue :");
		lblNewLabel_7.setBounds(44, 253, 46, 14);
		panel_1.add(lblNewLabel_7);
		// lb numero
		JLabel lblNewLabel_8 = new JLabel("Numero :");
		lblNewLabel_8.setBounds(44, 278, 46, 14);
		panel_1.add(lblNewLabel_8);
		// lb cp
		JLabel lblNewLabel_9 = new JLabel("CP :");
		lblNewLabel_9.setBounds(44, 307, 46, 14);
		panel_1.add(lblNewLabel_9);
		// lb ville
		JLabel lblNewLabel_10 = new JLabel("Ville :");
		lblNewLabel_10.setBounds(44, 328, 46, 14);
		panel_1.add(lblNewLabel_10);
		// Label Message d'information
		JLabel lblsys = new JLabel("");
		lblsys.setFont(new Font("Serif", Font.PLAIN, 13));
		lblsys.setBackground(Color.DARK_GRAY);
		lblsys.setForeground(Color.RED);
		lblsys.setBounds(30, 572, 1160, 79);
		contentPane.add(lblsys);
		// Bouton inscription
		JButton btnins = new JButton("Inscription");
		btnins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblsys.setText("");
				// Action lors de la l'enclenchement du bouton inscription :
				if (!TFnom.getText().isEmpty() && !TFprenom.getText().isEmpty() && !TFrue.getText().isEmpty()
						&& !TFnum.getText().isEmpty() && !TFcp.getText().isEmpty() && !TFville.getText().isEmpty()
						&& !TFinsmail.getText().isEmpty() && !String.valueOf(PFins.getPassword()).isEmpty()) {
					// Si tout les champs sont remplie alors on peut continuer, on va tester si
					// l'email est valide
					if (Regex.verifMail(TFinsmail.getText()) == true) {
						// Si l'email est bonne on continue, on va tester le mot de passe
						if (Regex.verifPass(String.valueOf(PFins.getPassword())) == true) {
							// si mot de passe respecte la regle on continue, on va tester les champs lettre
							// only
							if (Regex.verifLettre(TFnom.getText()) && TFnom.getText().length() <= 40) {
								// si le nom ne contient que des lettres et n'est pas plus long que 40 c'est bon
								if (Regex.verifLettre(TFprenom.getText()) == true
										&& TFprenom.getText().length() <= 40) {
									// idem pour le prenom
									if (Regex.verifLettre(TFrue.getText()) == true && TFrue.getText().length() <= 50) {
										// test rue ici
										if (Regex.verifNum(TFnum.getText()) == true && TFnum.getText().length() <= 3) {
											// test numéro rue
											if (Regex.verifCP(TFcp.getText()) == true) {
												// test du CP
												if (Regex.verifLettre(TFville.getText()) == true
														&& TFville.getText().length() <= 40) {
													// test du nom de la ville
													// SI on arrive ici c'est que l'utilisateur a bien entré les
													// information comme il faut, on va pouvoir creer l'objet et
													// l'ajouter dans la base de donnée
													if (rdclient.isSelected() == true) {
														// Création objet
														Client client = new Client(TFnom.getText(), TFprenom.getText(),
																TFrue.getText(), Integer.parseInt(TFnum.getText()),
																Integer.parseInt(TFcp.getText()), TFville.getText(),
																TFinsmail.getText(),
																String.valueOf(PFins.getPassword()));
														// Création de l'enregistrement dans la DB
														DAO<Client> clientDAO = adf.getClientDAO();
														if(clientDAO.Create(client) == true) {
															lblsys.setText("Le compte a bien été créer, vous pouvez vous connecter");
														} else {
															lblsys.setText("Une erreur est survenue lors de la création du compte, contacter un Administrateur si le problème persiste.");
														}
													} else if (rdorga.isSelected() == true) {
														// Création objet
														Organisateur orga = new Organisateur(TFnom.getText(), TFprenom.getText(),
																TFrue.getText(), Integer.parseInt(TFnum.getText()),
																Integer.parseInt(TFcp.getText()), TFville.getText(),
																TFinsmail.getText(),
																String.valueOf(PFins.getPassword()));
														// Création de l'enregistrement dans la DB
														DAO<Organisateur> orgaDAO = adf.getOrganisateurDAO();
														if(orgaDAO.Create(orga) == true) {
															lblsys.setText("Le compte a bien été créer, vous pouvez vous connecter");
														} else {
															lblsys.setText("Une erreur est survenue lors de la création du compte, contacter un Administrateur si le problème persiste.");
														}
													} else if (rdgest.isSelected() == true) {
														// Création objet
														Gestionnaire gest = new Gestionnaire(TFnom.getText(), TFprenom.getText(),
																TFrue.getText(), Integer.parseInt(TFnum.getText()),
																Integer.parseInt(TFcp.getText()), TFville.getText(),
																TFinsmail.getText(),
																String.valueOf(PFins.getPassword()));
														// Création de l'enregistrement dans la DB
														DAO<Gestionnaire> gestDAO = adf.getGestionnaireDAO();
														if(gestDAO.Create(gest) == true) {
															lblsys.setText("Le compte a bien été créer, vous pouvez vous connecter");
														} else {
															lblsys.setText("Une erreur est survenue lors de la création du compte, contacter un Administrateur si le problème persiste.");
														}
													} else if (rdart.isSelected() == true) {
														// Création objet
														Artiste art = new Artiste(TFnom.getText(), TFprenom.getText(),
																TFrue.getText(), Integer.parseInt(TFnum.getText()),
																Integer.parseInt(TFcp.getText()), TFville.getText(),
																TFinsmail.getText(),
																String.valueOf(PFins.getPassword()));
														// Création de l'enregistrement dans la DB
														DAO<Artiste> artDAO = adf.getArtisteDAO();
														if(artDAO.Create(art) == true) {
															lblsys.setText("Le compte a bien été créer, vous pouvez vous connecter");
														} else {
															lblsys.setText("Une erreur est survenue lors de la création du compte, contacter un Administrateur si le problème persiste.");
														}
													} else {
														lblsys.setText("Il faut choisir un rôle pour continuer");
													}
												} else {
													lblsys.setText(
															"Le champ ville ne peut contenir que des caractères et faire 40 de long");
												}
											} else {
												lblsys.setText(
														"Le code postale ne peut contenir que des nombre et faire 4 de long");
											}
										} else {
											lblsys.setText(
													"Le champ numéro ne peut contenir que des numéro et faire 3 de long");
										}
									} else {
										lblsys.setText(
												"Le champ rue de peut contenir que des caractères et faire 50 de long");
									}
								} else {
									lblsys.setText(
											"Le champ nom de peut contenir que des caractères et faire 40 de long");
								}
							} else {
								lblsys.setText("Le champ nom de peut contenir que des caractères et faire 40 de long");
							}
						} else {
							lblsys.setText("Le format de mot de passe n'est pas bon, il faut entre 8 et 20 caractères, une majuscule, une minuscule, un chiffre et un caractére spécial ( sauf - et _ ) pour continuer");
						}
					} else {
						// Affichage d'un message d'erreur
						lblsys.setText("Le format de l'email n'est pas bon");
					}
				} else {
					// Affichage d'un message d'erreur
					lblsys.setText("Veillez remplir tout les champs pour continuer votre inscription");
				}
			}
		});
		btnins.setBounds(375, 299, 100, 30);
		panel_1.add(btnins);
		// Bouton Connexion
		JButton btnco = new JButton("Connexion");
		btnco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblsys.setText("");
				// Action lors de la l'enclenchement du bouton Connexion :
				if(!TFcomail.getText().isEmpty() && !String.valueOf(PFco.getPassword()).isEmpty()) {
					// si les champs sont remplie on continue
					if(Regex.verifMail(TFcomail.getText()) == true) {
						if(Regex.verifPass(String.valueOf(PFco.getPassword())) == true) {
							// Si les formats email et mot de passe sont correcte on va pouvoir tester dans la DL si ils existent
							Personne pr = new Personne();
							pr.setEmail(TFcomail.getText());
							pr.setMotDePasse(String.valueOf(PFco.getPassword()));
							DAO<Personne> personneDAO = adf.getPersonneDAO();
							Personne prauth = personneDAO.Find(pr);
							if(prauth != null) {
								// la combinaison est bonne alors on peu continuer, il faut connaitre le role de l'utilisateur pour savoir ou le rediriger
								if(prauth.getRole().equals("Client")) {
									// log cloent
									Client client = new Client(prauth);
									try {
										ClAcc frame2 = new ClAcc(client);
										instance.dispose();
										frame2.setVisible(true);
									} catch(Exception ex) {
										ex.printStackTrace();
									}
								} else if(prauth.getRole() == "Artiste") {
									// log artiste
									Artiste artiste = new Artiste(prauth);
									try {
										ArtAcc frame2 = new ArtAcc(artiste);
										instance.dispose();
										frame2.setVisible(true);
									} catch(Exception ex) {
										ex.printStackTrace();
									}
								} else if(prauth.getRole() == "Organisateur") {
									// log organisateur
									Organisateur orga = new Organisateur(prauth);
									try {
										OrgAcc frame2 = new OrgAcc(orga);
										instance.dispose();
										frame2.setVisible(true);
									} catch(Exception ex) {
										ex.printStackTrace();
									}
								} else if(prauth.getRole() == "Gestionnaire") {
									// log gestionnaire
									Gestionnaire gest = new Gestionnaire(prauth);
									try {
										GesAcc frame2 = new GesAcc(gest);
										instance.dispose();
										frame2.setVisible(true);
									} catch(Exception ex) {
										ex.printStackTrace();
									}
								} else {
									lblsys.setText("Un problèmes est survenue avec votre compte, contactez un administrateur.");
								}
							} else {
								lblsys.setText("L'email ou le mot de passe est incorrecte");
							}
						} else {
							lblsys.setText("Le format de mot de passe n'est pas bon, il faut entre 8 et 20 caractères, une majuscule, une minuscule, un chiffre et un caractére spécial ( sauf - et _ ) pour continuer");
						}
					} else {
						lblsys.setText("Le format de l'email n'est pas bon.");
					}
				} else {
					lblsys.setText("Remplissez les gens pour vous connecter.");
				}
			}
		});
		btnco.setBounds(300, 201, 100, 30);
		panel.add(btnco);
	}
}