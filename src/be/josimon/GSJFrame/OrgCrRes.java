package be.josimon.GSJFrame;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibm.icu.util.Calendar;
import com.toedter.calendar.JCalendar;

import be.josimon.GSDAO.AbstractDAOFactory;
import be.josimon.GSDAO.DAO;
import be.josimon.GSPOJO.Organisateur;
import be.josimon.GSPOJO.PlanningSalle;
import be.josimon.GSPOJO.Reservation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrgCrRes extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame instance = this;
	Calendar cal = Calendar.getInstance(); 
	Calendar calfin = Calendar.getInstance();
	// On recupere la liste complete du planning de la salle
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<PlanningSalle> planDAO = adf.getPlanningSalleDAO();
	List<PlanningSalle> list = planDAO.getAll();
	// on crée un objet planning qui sera utiliser pour les test et la création de la reservation
	Reservation res = null;
	PlanningSalle temp = null;
	/**
	 * Create the frame.
	 */
	public OrgCrRes(Organisateur orga) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Reservation de la salle");
		
		JCalendar calendardebut = new JCalendar();
		calendardebut.setBounds(10, 50, 420, 330);
		contentPane.add(calendardebut);
		
		JLabel lbldatedebut = new JLabel("");
		lbldatedebut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldatedebut.setBounds(10, 387, 414, 40);
		contentPane.add(lbldatedebut);
		
		JCalendar calendarfin = new JCalendar();
		calendarfin.setBounds(440, 50, 420, 330);
		contentPane.add(calendarfin);
		
		JLabel lblNewLabel = new JLabel("<html>Information : La location ce fait d'un jour \u00E0 12h jusqu'au <br/> lendemain 12h <br/> Si le 12 Decembre est prit cela signifie que salle est prise du 12/12 12h jusqu'au 13/12 12h. Si la reservation dure plusieurs jours, la m\u00EAme logique est utilis\u00E9.</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(870, 11, 384, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date du d\u00E9but de la reservation : ");
		lblNewLabel_1.setBounds(10, 12, 420, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date de la fin de la reservation : ");
		lblNewLabel_1_1.setBounds(440, 12, 420, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lbldatefin = new JLabel("");
		lbldatefin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldatefin.setBounds(440, 387, 414, 40);
		contentPane.add(lbldatefin);
		
		JLabel lblinfores = new JLabel("Votre r\u00E9servation :");
		lblinfores.setBounds(10, 450, 123, 22);
		contentPane.add(lblinfores);
		
		JLabel lbl1 = new JLabel("Prix Total :");
		lbl1.setBounds(10, 483, 60, 14);
		contentPane.add(lbl1);
		
		JLabel lblNewLabel_2 = new JLabel("Acompte :");
		lblNewLabel_2.setBounds(10, 508, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Solde restant :");
		lblNewLabel_3.setBounds(0, 533, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblsolde = new JLabel("");
		lblsolde.setBounds(87, 533, 106, 14);
		contentPane.add(lblsolde);
		
		JLabel lblaco = new JLabel("");
		lblaco.setBounds(87, 508, 106, 14);
		contentPane.add(lblaco);
		
		JLabel lblprix = new JLabel("");
		lblprix.setBounds(80, 483, 106, 14);
		contentPane.add(lblprix);
		
		JButton btnvalid = new JButton("Valid\u00E9 et Payer");
		btnvalid.setBounds(10, 630, 140, 40);
		contentPane.add(btnvalid);
		calendarfin.setVisible(false);
		btnvalid.setVisible(false);
		
		// On ajoute un listener sur le DayChooser du Calendrier ( donc quand on choisis une date )
		calendardebut.getDayChooser().addPropertyChangeListener("day",new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						// Lorsqu'on change la date de début, on réinitialise les valeurs de tout les champs qui s'adaptent en fonction des choix
						lbldatedebut.setText("");
						lbldatefin.setText("");
						calendarfin.setVisible(false);
						lblsolde.setText("");
						lblaco.setText("");
						lblprix.setText("");
						btnvalid.setVisible(false);
						// On recupere des objets contenant presque vide, ils possédent juste les referents pour la suite des opérations, je le mets la pour pouvoir faire plusieurs reservation à partir du moment ou l'utilisateur change la date de début !
						res = orga.emptyRes();
						temp = res.emptySalle();
						
						// Lorsqu'on selectionne une date de début on vérifie si celle si est déjà prise ou si elle est antérieur à demain
						cal.set(calendardebut.getYearChooser().getYear(), calendardebut.getMonthChooser().getMonth(), calendardebut.getDayChooser().getDay());
						Date today = Calendar.getInstance().getTime();
						if(cal.getTime().before(today) || cal.getTime().compareTo(today) == 0) {
							lbldatedebut.setText("Il est impossible de reserver dans le passé ou pour le jour même");
							calendarfin.setVisible(false);
						} else {
							temp.setDateDébutReservation(cal.getTime());
							boolean test = false;
							for(PlanningSalle ps : list) {
								if(temp.getDateDébutReservation().after(ps.getDateDébutReservation()) && temp.getDateDébutReservation().after(ps.getDateFinReservation())) {
									// Si la date de début de ma nouvelle reservation ce trouve dans un intervalle de reservation existant alors 
									test = true;
								}
							}
							if(test == true) {
								// la reservation est impossible, on le notifie a l'utilisateur !
								lbldatedebut.setText("La date n'est pas disponible");
								calendarfin.setVisible(false);
							} else {
								// la reservation est possible, on affiche le deuxieme calendrier pour choisir la date de fin
								calendarfin.setVisible(true);
							}
						}
					}
				});
		calendarfin.getDayChooser().addPropertyChangeListener("day",new PropertyChangeListener( ) {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				lbldatefin.setText("");
				btnvalid.setVisible(false);
				// lorsqu'on selectionne un date de fin on vérifie si celle si est déjà prise et si elle est aprés la date début 
				calfin.set(calendarfin.getYearChooser().getYear(), calendarfin.getMonthChooser().getMonth(), calendarfin.getDayChooser().getDay());
				if(calfin.before(cal)) {
					// si la date de fin ce trouve avant la date de début c'est pas possible
					lbldatefin.setText("Il est impossible de reserver avec une date de fin avant la date début");
				} else {
					temp.setDateFinReservation(calfin.getTime());
					boolean test = false;
					for(PlanningSalle ps : list) {
						/* Plus complexe => Il faut tester si le couple dateDébut-dateFin du nouvelle objet ne ce trouve dans aucun autre interface
						* Explication : Si tempDateFin est avant psDateDébut OU Si tempDateDebut est aprés psDateFin alors pas dans l'intervale, et on test pour tout ce qui dans la db
						*/
						if(temp.getDateFinReservation().before(ps.getDateDébutReservation()) || temp.getDateDébutReservation().after(ps.getDateFinReservation())) {
							test = true;
						}
					}
					if(test == true) {
						// La reservation est impossible, on le notifie a l'utilisateur !
						lbldatefin.setText("L'intervalle de date n'est pas reservable, modifier votre choix");
					} else {
						// La reservation est possible, on va calculer le cout de celle ci est afficher un bouton pour que l'utilisateur puisse confirmer son choix
						double prix = temp.CalculPrix();
						// On attribue les valeurs
						res.setPrix(prix);
						res.setAcompte(prix/10); // on considére que l'accompte est de 10% du prix total
						res.setSolde(res.getPrix()-res.getAcompte());
						res.setStatut("En attente");
						
						// On affiche les informations dans l'interface et on attends que le client valide la reservation et on affiche le bouton pour valider et payé
						lblsolde.setText(String.valueOf(res.getSolde()));
						lblaco.setText(String.valueOf(res.getAcompte()));
						lblprix.setText(String.valueOf(res.getPrix()));
						
						btnvalid.setVisible(true);
					}
				}
			}
		});
		
		btnvalid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lorsqu'on appuie sur le bouton il faut envoyé dans la db la reservation et le planning lié a la reservation et notifié l'utilisateur
				boolean test = orga.createReservation(res.getAcompte(), res.getSolde(), "Acompte Payé", res.getPrix(),temp.getDateDébutReservation(), temp.getDateFinReservation());
				if(test) {
					// Dans le cadre d'une application a utilisé en production il faudrait ajouter ici une nouvelle fenetre qui permet le payement avec des intégrations diverse ( mastercard/visa/paypal/etc )
					JOptionPane.showMessageDialog(null, "Votre reservation à bien été créer et le payement est validé");
					OrgAcc frame2 = new OrgAcc(orga);
					instance.dispose();
					frame2.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Un probleme est survenu, contacter un administrateur");
				}
			}
		});
	}
}
