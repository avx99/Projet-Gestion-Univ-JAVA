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

import Metier.POJO.Projet;
import Presentation.Controlleur.ControlleurOpenAUser;

public class AjoutProjet extends JFrame {
	
private JLabel Message;
	
	private JLabel ID;
	private JTextField ValeurID;
	private JLabel Type;
	private JTextField ValeurType;
	private JLabel Sujet;
	private JTextField ValeurSujet;
	private JLabel Progress;
	private JTextField ValeurProgress;
	
	private JButton Valider;
	
	private JPanel Panel;
	private JPanel Panel2;

	private ControlleurOpenAUser controlleur;
	
	public AjoutProjet() {
		
		super("Projet");
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
		Type = new JLabel("Type : ");
		ValeurType = new JTextField();
		Sujet = new JLabel("Sujet");
		ValeurSujet = new JTextField();
		Progress = new JLabel("Progress");
		ValeurProgress = new JTextField();
		
		
		Valider = new JButton("Valider");
		
	}
	
	private void dessiner() {
		
		this.setLayout(new BorderLayout());
		this.setSize(600, 300);
		
		Panel.setLayout(new GridLayout(5, 2));
		Panel.add(ID);
		Panel.add(ValeurID);
		Panel.add(Type);
		Panel.add(ValeurType);
		Panel.add(Sujet);
		Panel.add(ValeurSujet);
		Panel.add(Progress);
		Panel.add(ValeurProgress);
		
		
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
				
				controlleur.executeProjetAjout();
				
			}
		});
	}
	
	public Projet getProjet(String CNE,String codeP) {
		
		return new Projet(ValeurID.getText(), codeP, CNE, ValeurType.getText(), ValeurSujet.getText(), ValeurProgress.getText(),
				"Non valider");
	}

	public void setControlleur(ControlleurOpenAUser controlleurEspaceEtudiant) {
		
		this.controlleur = controlleurEspaceEtudiant;
	}

}
