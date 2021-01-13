package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Presentation.Controlleur.ControleurTablePr;
import Presentation.Controlleur.ControlleurOpenAUser;
import Presentation.Modules.ModelDocumentPr;

public class VueDocumentPr extends JFrame{
	
		
		private final String[] cols = {"ID","Nom document","CNE", "Id_Projet","Code_prof", "Creer Par"};
		
		private JPanel panel1;
		private JPanel panel2;
		private JPanel panel3;
		
		private JTable table;
		
		private JButton retour;
		private JButton supprimer;
		private JButton ajouter;
		private JButton importer;
		private JButton exporter;

		private ModelDocumentPr modeldoc;
		private ControlleurOpenAUser controlleur;
		
		//private ControleurTablePr controler;
		
		public VueDocumentPr(ModelDocumentPr modeldoc) throws HeadlessException {
			super();
			this.modeldoc = modeldoc;
			this.initialiser(this.modeldoc);
			this.dessiner();
			this.initaialiserControler();
			this.setTitle("Documents");
			this.actions();
			this.setSize(500,400);
		}
		
		private void initialiser(ModelDocumentPr modeldoc) {
			
			panel1 = new JPanel();
			panel2 = new JPanel();
			panel3 = new JPanel();
			
			table = new JTable(modeldoc);
			
			retour = new JButton("Retour");
			ajouter = new JButton("Ajouter");
			supprimer = new JButton("Supprimer");
			importer = new JButton("Importer Fichier");
			exporter = new JButton("Exporter un fichier");
			
		}
		
		private void dessiner() {
			
			panel1.add(table);
			panel2.add(retour);
			panel3.add(ajouter);
			panel3.add(supprimer);
			panel3.add(importer);
			panel3.add(exporter);
			
			this.add(new JScrollPane(table),BorderLayout.CENTER);
			this.add(BorderLayout.WEST, panel2);
			this.add(BorderLayout.SOUTH, panel3);
			
			
			
		}
		
		private void initaialiserControler() {
			controlleur = new ControlleurOpenAUser();
			controlleur.setVdp(this);
		}

		private void actions() {
			retour.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
				
			});
			
			ajouter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controlleur.executeAjtPr();
					dispose();
				}
				
			});
			
			supprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controlleur.executeSupprimerDoc();
					//dispose();
					//setVisible(true);
					
				}
				
			});
			
			importer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controlleur.importerFichier();
					
				}
				
			});
			
			exporter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controlleur.exporterFichier();
					
				}
				
			});
		}
		

		public ModelDocumentPr getModeldoc() {
			return modeldoc;
		}

		public void setModeldoc(ModelDocumentPr modeldoc) {
			this.modeldoc = modeldoc;
		}

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}
		
		
		
		
		
		

}
