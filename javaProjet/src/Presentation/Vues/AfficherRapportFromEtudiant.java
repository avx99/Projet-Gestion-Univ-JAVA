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

import Metier.Gestion.GestionRapport;
import Metier.POJO.Document;
import Metier.POJO.Projet;
import Metier.POJO.Rapport;
import Presentation.Controlleur.ControlleurEtudiantAd;
import Presentation.Controlleur.ControlleurProfesseurAdd;
import Presentation.Modules.ModelEtudiantProjet;
import Presentation.Modules.ModelEtudiantRapport;
import Presentation.Modules.ModelProfesseurDocument;

public class AfficherRapportFromEtudiant extends JFrame{
	
	

	private JTable table;
	private JButton quitter;
	private JPanel b;
	private ControlleurEtudiantAd controlleur;
	private ModelEtudiantRapport model;
	private ArrayList<Rapport> list;

	
	
	
	public AfficherRapportFromEtudiant() throws HeadlessException {
		super();
		
		this.runProgram();
	}
	
	public void initialiser()
	{
		table = new JTable();
		quitter = new JButton("Quitter");
		b = new JPanel();
	}
	
	public void dessiner() {
		this.setSize(600, 400);
		this.getContentPane().setLayout(new BorderLayout());
		b.add(quitter);
		this.getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
		this.getContentPane().add(b,BorderLayout.SOUTH);
	}
	
	
	void initialiserControlleur()
	{
		this.model = new ModelEtudiantRapport(list);
		controlleur = new ControlleurEtudiantAd(list, this);
		table = new JTable(this.model);
	}
	
	void getDataFromDataBase()
	{
		this.list = GestionRapport.getAll();
	}
	
	

	public void runProgram()
	{
		this.initialiser();
		this.getDataFromDataBase();
		this.initialiserControlleur();
		this.dessiner();
		this.action();
	}
	
	public void action()
	{
		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				dispose();
			}
			
			
			
		
		});
	}
	
	
	


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ControlleurEtudiantAd getControlleur() {
		return controlleur;
	}

	public void setControlleur(ControlleurEtudiantAd controlleur) {
		this.controlleur = controlleur;
	}

	public ModelEtudiantRapport getModel() {
		return model;
	}

	public void setModel(ModelEtudiantRapport model) {
		this.model = model;
	}

	public ArrayList<Rapport> getList() {
		return list;
	}

	public void setList(ArrayList<Rapport> list) {
		this.list = list;
	}

	public static void main(String[] args) {
		AfficherRapportFromEtudiant f = new AfficherRapportFromEtudiant();
		f.setVisible(true);
	}
	
	
	
	

}
