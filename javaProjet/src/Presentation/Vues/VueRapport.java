package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;

import Metier.POJO.Rapport;
import Presentation.Controlleur.ControlleurOpenAUser;
import Presentation.Modules.ModelRapport;

public class VueRapport extends JFrame {
	
	private JTable table;
	
	private JPanel panel;
	
	private JButton Ajouter;
	private JButton Supprimer;
	private JButton set;
	private JButton get;
	private JButton Retour;
	private JButton Acueil;
	
	ModelRapport md;

	private ControlleurOpenAUser controlleur;
	
	public VueRapport(ArrayList<Rapport> rapports) throws HeadlessException {
		
		super("Rapports");
		this.intialliser(rapports);
		this.dessiner();
		this.actions();
	}

	private void intialliser(ArrayList<Rapport> rapports) {
		
		md = new ModelRapport(rapports);
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
				
				controlleur.executeVueEtudiant2Rapport();
//				dispose();
				
			}
		});
		
		Acueil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.acceuilRapp();
				
			}
		});
		
		Ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleur.executeAjoutRapport();
			}
		});
		
		Supprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int[] selecteds = table.getSelectedRows();
				for (int i=selecteds.length - 1 ; i >= 0 ; i-- )
					md.removeRapport(selecteds[i]);
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
				if(b)
					JOptionPane.showMessageDialog(null, "Le rapport est bien ajout� dans la base des donn�es !");
				
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
					if(selectedFile.getAbsolutePath().length()!=0 && i!= -1) {
					md.telecharger(i, selectedFile.getAbsolutePath());
					b = true;
					}
				}
				if(b)
				JOptionPane.showMessageDialog(null, "Le rapport est bien tel�charger !");
				
			}
		});
		
		
	}
	
	public void setControlleur(ControlleurOpenAUser controlleurEspaceEtudiant) {
		
		this.controlleur = controlleurEspaceEtudiant;
	}
	
	public void setRapport(Rapport r) {
		md.addRapport(r);
	}

}