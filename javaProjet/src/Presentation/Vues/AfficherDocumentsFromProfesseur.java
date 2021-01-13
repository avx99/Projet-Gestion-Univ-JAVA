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

import Metier.Gestion.GestionDocument;
import Metier.Gestion.GestionProfesseur;
import Metier.POJO.Document;
import Presentation.Controlleur.ControlleurProfesseurAdd;
import Presentation.Modules.ModelProfesseurDocument;
import Presentation.Modules.ModelProfesseurProfesseur;

public class AfficherDocumentsFromProfesseur extends JFrame{
	
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ControlleurProfesseurAdd getControlleur() {
		return controlleur;
	}

	public void setControlleur(ControlleurProfesseurAdd controlleur) {
		this.controlleur = controlleur;
	}

	public ModelProfesseurDocument getModel() {
		return model;
	}

	public void setModel(ModelProfesseurDocument model) {
		this.model = model;
	}

	public ArrayList<Document> getList() {
		return list;
	}

	public void setList(ArrayList<Document> list) {
		this.list = list;
	}

	private JTable table;
	private JButton quitter;
	private JPanel b;
	private ControlleurProfesseurAdd controlleur;
	private ModelProfesseurDocument model;
	private ArrayList<Document> list;
	
	
	
	public AfficherDocumentsFromProfesseur() throws HeadlessException {
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
			this.model = new ModelProfesseurDocument(list);
			controlleur = new ControlleurProfesseurAdd(list, this);
			table = new JTable(this.model);

	}
	
	void getDataFromDataBase()
	{
			this.list = GestionDocument.getAll();
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
	
	public static void main(String[] args) {
		AfficherDocumentsFromProfesseur f = new AfficherDocumentsFromProfesseur();
		f.setVisible(true);
	}
	

}
