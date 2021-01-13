package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Metier.POJO.Etudiant;
import Presentation.Controlleur.ControlleurOpenAUser;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class VueEtudiant2 extends JFrame {

private JLabel Message;
	
	private JLabel Nom;
	private JLabel ValeurNom;
	private JLabel Prenom;
	private JLabel ValeurPrenom;
	private JLabel CNE;
	private JLabel ValeurCNE;
	private JLabel Email;
	private JLabel ValeurEmail;
	private JLabel Anne;
	private JLabel ValeurAnne;
	private JLabel code;
	private JLabel Valeurcode;
	
	private JLabel Rendez;
	private JLabel ValeurRendez;
	
	private JButton Documents;
	private JButton Rapports;
	private JButton MonProjet;
	private JButton Acueil;
	
	private JPanel Panel;
	private JPanel Panel2;


	private JPanel Panel3;
	
	ControlleurOpenAUser controlleur;
	
	
	
	public VueEtudiant2() {
		
		super("Espace Etudiant");
		this.intialliser();
		this.dessiner();
		this.actions();
	}

	private void intialliser() {
		
		Panel = new JPanel();
		Panel2 = new JPanel();
		Panel3 = new JPanel();
		
		Message = new JLabel("Bienvenue !! ");
		
		Nom = new JLabel("Nom : ");
		ValeurNom = new JLabel();
		Prenom = new JLabel("Prenom : ");
		ValeurPrenom = new JLabel();
		CNE = new JLabel("CNE : ");
		ValeurCNE = new JLabel();
		Email = new JLabel("Email : ");
		ValeurEmail = new JLabel();
		Anne = new JLabel("Ann� : ");
		ValeurAnne = new JLabel();
		code = new JLabel("Code_prof : ");
		Valeurcode = new JLabel();
		
		Rendez = new JLabel("Les Rendez_vous :");
		ValeurRendez = new JLabel();
		
		Documents = new JButton("Documents");
		Rapports = new JButton("Rapports");
		MonProjet = new JButton("Projets");
		Acueil = new JButton("Acueil");
		
	}
	
	private void dessiner() {
		

		this.setLayout(new BorderLayout());
		this.setSize(1200, 700);
		controlleur = new ControlleurOpenAUser();
		controlleur.setVue2(this);
		
		
		Panel.setLayout(new GridLayout(6, 2));
		Panel.add(Nom);
		Panel.add(ValeurNom);
		Panel.add(Prenom);
		Panel.add(ValeurPrenom);
		Panel.add(CNE);
		Panel.add(ValeurCNE);
		Panel.add(Email);
		Panel.add(ValeurEmail);
		Panel.add(Anne);
		Panel.add(ValeurAnne);
		Panel.add(code);
		Panel.add(Valeurcode);
		
		Panel3.setLayout(new GridLayout(2, 1,400,400));
		
		Panel3.add(Rendez);
		Panel3.add(ValeurRendez);
		
		Panel2.setLayout(new FlowLayout(0,100,20));
		Panel2.add(Documents);
		Panel2.add(Rapports);
		Panel2.add(MonProjet);
		Panel2.add(Acueil);
		
		this.add(Message,BorderLayout.NORTH);
		this.add(Panel,BorderLayout.CENTER);
		this.add(Panel3,BorderLayout.EAST);
		this.add(Panel2, BorderLayout.SOUTH);
	}
	
	private void actions() {
		
		Documents.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.executeDocuments();
				
			}
		});
	
		Rapports.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.executeRapports();
				
			}
		});
		
		MonProjet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.executeProjets();
				
			}
		});
		
		Acueil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controlleur.acceuilVueEtudiant2();
				
			}
		});
		
	}





	public ControlleurOpenAUser getControlleur() {
		return controlleur;
	}

	public void setControlleur(ControlleurOpenAUser controlleur) {
		this.controlleur = controlleur;
	}



	public void setEtudiant(Etudiant e) {
		
		ValeurNom.setText(e.getNom_etudiant());
		ValeurPrenom.setText(e.getPrenom_etudiant());
		ValeurCNE.setText(e.getCNE());
		ValeurEmail.setText(e.getEmail_etudiant());
		ValeurAnne.setText(e.getAnne());
		Valeurcode.setText(e.getCode_professeur());
		
	}

	public void setRendez(ArrayList<Metier.POJO.Rendez> table4) {
		String s;
		if(table4.size()==0)
			s = "vous avez aucun Rendez-vous";
		else {
			s = "vous avez des Rendez-vous le ";
			for(Metier.POJO.Rendez r:table4)
				s = s + r.getDate_rendez() +"  ";
		}
		ValeurRendez.setText(s);
		
	}


}
