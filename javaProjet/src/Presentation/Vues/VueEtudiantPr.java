package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Metier.POJO.Etudiant;
import Presentation.Modules.ModelEtudiantPr;
import Presentation.Controlleur.ControleurTablePr;
import Presentation.Controlleur.ControlleurOpenAUser;

public class VueEtudiantPr extends JFrame{
	
	private String[] cols = {"CNE","Encadrant","Nom","Prenom","Email","Annee"};


	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JTable table;
	
	private JButton retour;
	//private JButton supprimer;
	//private JButton ajouter;
	private JButton chercher;
	
	private ModelEtudiantPr modeletd;
	private Etudiant etd;
	private ArrayList<Etudiant> etds;
	private ControleurTablePr ctp;
	
	private ControlleurOpenAUser controlleur;
	
		
	
	public VueEtudiantPr(ModelEtudiantPr modeletd) throws HeadlessException {
		super();
		//this.modeletd = new ModelEtudiantPr("prof1");
		this.modeletd = modeletd;
		this.initialiser(this.modeletd);
		this.dessiner();
		this.initialiserControl();
		this.setTitle("Etudiants");
		this.actions();
		this.setSize(500,400);
		
	}
	
	
	
	private void initialiser(ModelEtudiantPr mm) {
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		table = new JTable(mm);
		
		retour = new JButton("Retour");
		//ajouter = new JButton("Ajouter");
		//supprimer = new JButton("Supprimer");
		chercher = new JButton("Chercher");
		
	}
	
	private void dessiner() {
		
		panel1.add(table);
		panel2.add(retour);
		//panel3.add(ajouter);
		//panel3.add(supprimer);
		//panel3.add(chercher);
		
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.add(BorderLayout.WEST, panel2);
		this.add(BorderLayout.SOUTH, panel3);
		
	}
	
	private void initialiserControl() {
		controlleur = new ControlleurOpenAUser();
		controlleur.setVep(this);
	}
	
	private void actions() {
		retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
	}
	
	

	public ModelEtudiantPr getModeletd() {
		return modeletd;
	}

	public void setModeletd(ModelEtudiantPr modeletd) {
		this.modeletd = modeletd;
	}
	
	
	
}
