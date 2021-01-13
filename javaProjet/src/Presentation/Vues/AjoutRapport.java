package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Metier.POJO.Rapport;
import Presentation.Controlleur.ControlleurOpenAUser;

public class AjoutRapport extends JFrame {
	
private JLabel Message;
	
	private JLabel ID;
	private JTextField ValeurID;
	private JLabel Nom;
	private JTextField ValeurNom;
	
	private JButton Valider;
	
	private JPanel Panel;
	private JPanel Panel2;

	private ControlleurOpenAUser controlleur;
	
	public AjoutRapport() {
		
		super("Rapport");
		this.intialliser();
		this.dessiner();
		this.actions();
	}
	
	private void intialliser() {
		
		Panel = new JPanel();
		Panel2 = new JPanel();
		
		Message = new JLabel("Remplie Les informations : ");
		
		ID = new JLabel("ID : ");
		ValeurID = new JTextField();
		Nom = new JLabel("Nom : ");
		ValeurNom = new JTextField();
		
		
		Valider = new JButton("Valider");
		
	}
	
	private void dessiner() {
		
		this.setLayout(new BorderLayout());
		this.setSize(600, 300);
		
		Panel.setLayout(new GridLayout(2, 2));
		Panel.add(ID);
		Panel.add(ValeurID);
		Panel.add(Nom);
		Panel.add(ValeurNom);
		
		
		Panel2.setLayout(new FlowLayout(0,400,20));
		Panel2.add(Valider);
		
		this.add(Message,BorderLayout.NORTH);
		this.add(Panel,BorderLayout.CENTER);
		this.add(Panel2, BorderLayout.SOUTH);
	}
	
	private void actions() {	
		
		Valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.executeRapportAjout();
				
			}
		});
		
	}
	
	public Rapport getRapport(String CNE,String codeP) {
		
		return new Rapport(ValeurID.getText(), ValeurNom.getText(), CNE, codeP, "Non valider");
	}

	public void setControlleur(ControlleurOpenAUser controlleurEspaceEtudiant) {
		
		this.controlleur = controlleurEspaceEtudiant;
	}

}
