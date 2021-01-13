package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Metier.POJO.Document;
import Presentation.Controlleur.ControlleurOpenAUser;

public class AjoutDocument extends JFrame {
	
	private JLabel Message;
	
	private JLabel ID;
	private JTextField ValeurID;
	private JLabel Nom;
	private JTextField ValeurNom;
	private JLabel ID_projet;
	private JTextField ValeurID_projet;
	
	private JButton Valider;
	
	private JPanel Panel;
	private JPanel Panel2;

	private ControlleurOpenAUser controlleur;
	
	public AjoutDocument() {
		
		super("Document");
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
		ID_projet = new JLabel("ID_projet : ");
		ValeurID_projet = new JTextField();
		Nom = new JLabel("Nom : ");
		ValeurNom = new JTextField();
		
		
		Valider = new JButton("Valider");
		
	}
	
	private void dessiner() {
		
		this.setLayout(new BorderLayout());
		this.setSize(600, 300);
		
		Panel.setLayout(new GridLayout(3, 2));
		Panel.add(ID);
		Panel.add(ValeurID);
		Panel.add(Nom);
		Panel.add(ValeurNom);
		Panel.add(ID_projet);
		Panel.add(ValeurID_projet);
		
		
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
				
				controlleur.executeDocumentAjout();
				
			}
		});
		
	}
	
	public Document getDocument(String CNE,String IDP) {
		
		return new Document(ValeurID.getText(), ValeurNom.getText(), CNE, ValeurID_projet.getText(), IDP, "Etudiant");
	}

	public void setControlleur(ControlleurOpenAUser controlleurEspaceEtudiant) {
		
		this.controlleur = controlleurEspaceEtudiant;
	}

}