package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Metier.Gestion.GestionDocument;
import Metier.Gestion.GestionProfesseur;
import Metier.POJO.Document;
import Metier.POJO.Professeur;
import Presentation.Controlleur.ControlleurProfesseurAdd;
import Presentation.Controlleur.ControlleurProfesseurEtudiantAd;
import Presentation.Modules.ModelProfesseurDocument;
import Presentation.Modules.ModelProfesseurProfesseur;
import persistance.DAO.DAOProfesseur;


public class ProfesseurAdministration extends JFrame
{
	private JPanel topMenu;
	private JPanel buttonList1;
	private JPanel buttonList2;
	private JPanel menuList;
	private JTable table;
	private JButton ajouter;
	private JButton supprimer;
	private JButton modifier;
	private JButton afficherDocuments;
	private JButton quitter;
	private JButton acceuil;
	private JButton etd;
	private JButton prf;
	private ArrayList<Professeur> list;
	private ControlleurProfesseurAdd controlleur;
	private ControlleurProfesseurEtudiantAd navigateur;
	private ModelProfesseurProfesseur model;
	private Professeur p;
	private ModelProfesseurDocument modelDocument;
	
	
	public ProfesseurAdministration()
	{
		this.runProgram();
	}
	
	
	
	public void initialiser()
	{
		topMenu = new JPanel();
		buttonList1 = new JPanel();
		buttonList2 = new JPanel();
		menuList = new JPanel();
		ajouter = new JButton("Ajouter");
		supprimer = new JButton("Supprimer");
		modifier = new JButton("Modifier");
		afficherDocuments = new JButton("<html>Afficher les<br>documents</html>");
		quitter = new JButton("Quitter");
		acceuil = new JButton("Acceuil");
		etd = new JButton("Espace etudiant");
		prf = new JButton("Espace professeur");
		prf.setEnabled(false);
		list = new ArrayList<>();
	}
	
	
	public void dessiner()
	{
		this.setSize(1200, 700);
		buttonList1.setLayout(new GridLayout(1,3,5,5));
		buttonList2.setLayout(new GridLayout(1,3,5,5));
		menuList.setLayout(new GridLayout(2,1,5,5));
		buttonList1.add(ajouter);buttonList1.add(supprimer);buttonList1.add(modifier);
		buttonList2.add(afficherDocuments);buttonList2.add(quitter);buttonList2.add(acceuil);
		menuList.add(buttonList1);menuList.add(buttonList2);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(menuList, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		topMenu.setLayout(new GridLayout(1,2));
		topMenu.add(etd);topMenu.add(prf);
		this.getContentPane().add(topMenu, BorderLayout.NORTH);

	}
	
	void initialiserControlleur()
	{
			this.model = new ModelProfesseurProfesseur(list);
			controlleur = new ControlleurProfesseurAdd(list, this);
			table = new JTable(this.model);
			navigateur = new ControlleurProfesseurEtudiantAd(this);

	}
	
	void getDataFromDataBase()
	{
			this.list = GestionProfesseur.getAll();
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
		
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 controlleur.executeAddProfesseur();
				
			}
		
		});
		
		
		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		
		supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controlleur.deleteProfesseur();
				
				
			}
			
			
			
		
		});
		
		modifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controlleur.executeModifierProfesseur();
				
				
			}
			
		});

		
		afficherDocuments.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				controlleur.executeAfficherDocuments();
			}
		
		});
		
		
		acceuil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 controlleur.executeAcceuil();
				
				
			}
			
		
		});
		
		
		
		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				dispose();
			}
			
			
			
		
		});
		
		etd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				navigateur.executeEtd();
			}

		});

	}
	
	
	public ControlleurProfesseurAdd getControlleur() {
		return controlleur;
	}



	public void setControlleur(ControlleurProfesseurAdd controlleur) {
		this.controlleur = controlleur;
	}


	public ModelProfesseurProfesseur getModel() {
		return model;
	}




	public void setModel(ModelProfesseurProfesseur model) {
		this.model = model;
	}




	public Professeur getP() {
		return p;
	}




	public void setP(Professeur p) {
		this.model.addelement(p);
	}

	public ModelProfesseurDocument getModelDocument() {
		return modelDocument;
	}




	public void setModelDocument(ModelProfesseurDocument modelDocument) {
		this.modelDocument = modelDocument;
	}


	public JTable getTable() {
		return table;
	}




	public void setTable(JTable table) {
		this.table = table;
	}

	
	public static void main(String[] args) 
	{
		ProfesseurAdministration f = new ProfesseurAdministration();
		f.setVisible(true);
	}
	
	
}
