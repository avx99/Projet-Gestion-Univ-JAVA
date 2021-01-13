package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;

import Metier.POJO.Document;
import Presentation.Controlleur.ControlleurOpenAUser;
import Presentation.Modules.ModelDocument;

public class VueDocument extends JFrame {
	
	private JTable table;
	
	private JPanel panel;
	
	private JButton Ajouter;
	private JButton Supprimer;
	private JButton set;
	private JButton get;
	private JButton Retour;
	private JButton Acueil;
	
	private ModelDocument md;
	
	private ControlleurOpenAUser controlleur;
	
	public VueDocument(ArrayList<Document> documents) throws HeadlessException {
		
		super("Documents");
		this.intialliser(documents);
		this.dessiner();
		this.actions();
	}
	
	private void intialliser(ArrayList<Document> documents) {
		
		md = new ModelDocument(documents);
		table = new JTable(md);
		
		panel = new JPanel();
		
		Ajouter = new JButton("Ajouter");
		Supprimer = new JButton("Supprimer");
		set = new JButton("Importer");
		get = new JButton("tel�charger");
		Retour = new JButton("Retour");
		Acueil = new JButton("Acueil");
		
	}

	private void dessiner() {
		this.setLayout(new BorderLayout());
		this.setSize(1200, 700);
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		
		panel.setLayout(new FlowLayout(0,100,0));
		panel.add(Ajouter);
		panel.add(Supprimer);
		panel.add(set);
		panel.add(get);
		panel.add(Retour);
		panel.add(Acueil);
		
		this.add(panel,BorderLayout.SOUTH);
	}

	private void actions() {
		
		Retour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.executeVueEtudiant2Document();
				
			}
		});
		
		Acueil.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controlleur.acceuilDoc();
			}
		});
		
		Ajouter.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.executeAjoutDocument();
				
			}
		});
		
		Supprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int[] selecteds = table.getSelectedRows();
				for (int i=selecteds.length - 1 ; i >= 0 ; i-- )
					md.removeDocument(selecteds[i]);
				
			}
		});
		
		set.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean b = false;
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = jfc.getSelectedFile();
					int[] selecteds = table.getSelectedRows();
					if(selecteds.length != 0) {
					for (int i=selecteds.length - 1 ; i >= 0 ; i-- )
						md.importer(i,selectedFile.getAbsolutePath());
					b = true;
					}
					if(b == true)
						JOptionPane.showMessageDialog(null, "Le document est bien ajout� dans la base des donn�es !");
				}

			}
		});
		
		get.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean b = false;
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
				
					File selectedFile = jfc.getSelectedFile();
					int i = table.getSelectedRow();
					if (selectedFile.getAbsolutePath().length()!=0 && i!=-1)
					{
						md.telecharger(i, selectedFile.getAbsolutePath());
						b = true;
					}
				}
				if (b == true)
					JOptionPane.showMessageDialog(null, "Le document est bien tel�charger !");
					
				
			}
		});
		
	}

	public void setControlleur(ControlleurOpenAUser controlleurEspaceEtudiant) {
		
		this.controlleur = controlleurEspaceEtudiant;
		
	}
	
	public void setDocument(Document d) {
		
		md.addDocument(d);
		
	}
	
}
