package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Metier.Gestion.GestionEtudiant;
import Metier.POJO.Etudiant;
import Presentation.Controlleur.ControlleurEtudiantAd;
import Presentation.Controlleur.ControlleurProfesseurEtudiantAd;
import Presentation.Modules.ModelEtudiantEtudiant;

public class EtudiantAdministration extends JFrame
{
	private JPanel topMenu;
	private JPanel buttonList1;
	private JPanel buttonList2;
	private JPanel menuList;
	private JTable table;
	private JButton ajouter;
	private JButton supprimer;
	private JButton modifier;
	private JButton csv;
	private JButton afficherRapports;
	private JButton quitter;
	private JButton acceuil;
	private JButton afficherProjets;
	private JButton etd;
	private JButton prf;
	private ModelEtudiantEtudiant model;
	private ControlleurEtudiantAd controlleur;
	private ControlleurProfesseurEtudiantAd navigateur;
	private Etudiant e;
	private ArrayList<Etudiant> list;
	
	
	public EtudiantAdministration()
	{
		this.runProgram();
	}
	
	
	
	
	public void initialiser()
	{
		topMenu = new JPanel();
		buttonList1 = new JPanel();
		buttonList2 = new JPanel();
		menuList = new JPanel();
		table = new JTable();
		ajouter = new JButton("Ajouter");
		supprimer = new JButton("Supprimer");
		modifier = new JButton("Modifier");
		csv = new JButton("<html>Importer fichier<br> csv</html>");
		afficherRapports = new JButton("<html>Afficher liste <br>des rapports </html>");
		afficherProjets = new JButton("<html>Afficher les<br>projets</html>");
		quitter = new JButton("Quitter");
		acceuil = new JButton("Acceuil");
		etd = new JButton("Espace etudiant");
		etd.setEnabled(false);
		prf = new JButton("Espace professeur");
	}
	
	
	public void dessiner()
	{
		this.setSize(1200, 700);
		buttonList1.setLayout(new GridLayout(1,4,5,5));
		buttonList2.setLayout(new GridLayout(1,4,5,5));
		menuList.setLayout(new GridLayout(2,1,5,5));
		buttonList1.add(ajouter);buttonList1.add(supprimer);buttonList1.add(modifier);
		buttonList1.add(csv);buttonList2.add(afficherRapports);buttonList2.add(acceuil);
		buttonList2.add(afficherProjets);buttonList2.add(quitter);
		menuList.add(buttonList1);menuList.add(buttonList2);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(menuList, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		topMenu.setLayout(new GridLayout(1,2));
		topMenu.add(etd);topMenu.add(prf);
		this.getContentPane().add(topMenu, BorderLayout.NORTH);
	}
	
	
	public void action()
	{
		
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 controlleur.executeAddEtudiant();
				
				
			}
			
		
		});
		
		
		modifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			 controlleur.executeModifierEtudiant();
				
			}	});
		
		supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controlleur.deleteEtudiant();
				
			}

		});
		
		
		
		afficherProjets.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 controlleur.executeAfficherProjets();
				
				
			}
			
		
		});
		
		afficherRapports.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 controlleur.executeAfficherRapport();
				
				
			}
			
		
		});
		
		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 dispose();
				
				
			}
			
		
		});
		
		csv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 controlleur.insert3et4anne();
				
				
			}
			
		
		});
		
		
		prf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				navigateur.executeProf();
			}

		});
		
		
		acceuil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 controlleur.executeAcceuil();
				
				
			}
			
		
		});
		
	}
	
	
	void initialiserControlleur()
	{
			this.model = new ModelEtudiantEtudiant(list);
			controlleur = new ControlleurEtudiantAd(list, this);
			table = new JTable(this.model);
			navigateur = new ControlleurProfesseurEtudiantAd(this);

	}
	
	void getDataFromDataBase()
	{
			this.list = GestionEtudiant.getAll();
	}
	
	public void runProgram()
	{
		this.initialiser();
		this.getDataFromDataBase();
		this.initialiserControlleur();
		this.dessiner();
		this.action();
	}
	
	
	public ModelEtudiantEtudiant getModel() {
		return model;
	}




	public void setModel(ModelEtudiantEtudiant model) {
		this.model = model;
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




	public Etudiant getE() {
		return e;
	}




	public void setE(Etudiant e) {
		this.model.addelement(e);
	}




	public ArrayList<Etudiant> getList() {
		return list;
	}




	public void setList(ArrayList<Etudiant> list) {
		this.list = list;
	}
	


	public static void main(String[] args) 
	{
		EtudiantAdministration f = new EtudiantAdministration();
		f.setVisible(true);
		
	}
	
	
}

