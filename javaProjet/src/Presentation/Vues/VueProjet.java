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

import Metier.POJO.Projet;
import Presentation.Controlleur.ControlleurOpenAUser;
import Presentation.Modules.ModelProjet;

public class VueProjet extends JFrame {
	
JTable table;
	
	JPanel panel;
	
	JButton Ajouter;
	private JButton set;
	private JButton get;
	JButton Retour;
	JButton Acueil;
	
	ModelProjet md;
	
	ControlleurOpenAUser controlleur;
	
	public VueProjet(ArrayList<Projet> Projets) throws HeadlessException {
		
		super("Projets");
		this.intialliser(Projets);
		this.dessiner();
		this.actions();
	}
	
	private void intialliser(ArrayList<Projet> Projets) {
		
		md = new ModelProjet(Projets);
		table = new JTable(md);
		
		panel = new JPanel();
		
		Ajouter = new JButton("Ajouter");
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
				
				controlleur.executeVueEtudiant2Projet();
				
			}
		});
		
		
		Acueil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.acceuilProj();
				
			}
		});
		
		Ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.executeAjoutProjet();
				
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
				}
				if(b ==true)
					JOptionPane.showMessageDialog(null, "Le projet est bien ajout� dans la base des donn�es !");
				
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
					if(selectedFile.getAbsolutePath().length()!=0 && i!=-1) {
					md.telecharger(i, selectedFile.getAbsolutePath());
					b=true;
					}
				}
				if(b)
					JOptionPane.showMessageDialog(null, "Le projet est bien tel�charger !");
				
			}
				
		});
		
		
	}

	public void setControlleur(ControlleurOpenAUser controlleurEspaceEtudiant) {
		
		this.controlleur = controlleurEspaceEtudiant;
	}
	
	public void setProjet(Projet p) {
		
		md.addProjet(p);
		
	}
	
}
