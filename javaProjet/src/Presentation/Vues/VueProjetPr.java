package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Presentation.Controlleur.ControlleurOpenAUser;
import Presentation.Modules.ModelProjetPr;

public class VueProjetPr extends JFrame{
	
	

	private final String[] cols = {"ID","Code Prof","CNE","Type Projet","Sujet", "Progression", "Validation"};

	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JTable table;
	
	private JButton retour;
	private JButton progres;
	private JButton valider;
	private JButton exporter;
	private JButton effectuer;

	
	private ModelProjetPr modelprojet;
	private ControlleurOpenAUser controler;
	
	private VueEvaluerProgression vEvaluer;
	private static int[] selection;
	
	
	public VueProjetPr(ModelProjetPr modelprojet) throws HeadlessException {
		super();
		this.modelprojet = modelprojet;
		this.initialiser(this.modelprojet);
		this.dessiner();
		this.init();
		this.setTitle("Projets");
		this.actions();
		this.setSize(500,400);
	}
	
	private void initialiser(ModelProjetPr modelprojet) {
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		table = new JTable(modelprojet);
		
		retour = new JButton("Retour");
		progres = new JButton("Evaluer la progression");
		valider = new JButton("Valider");
		exporter = new JButton("Exporter");
		effectuer = new JButton("Effectuer");
		
		
	}
	
	private void dessiner() {
		
		panel1.add(table);
		panel2.add(retour);
		panel3.add(progres);
		panel3.add(valider);
		panel3.add(exporter);
		panel3.add(effectuer);

		
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.add(BorderLayout.WEST, panel2);
		this.add(BorderLayout.SOUTH, panel3);
				
	}
	
	private void init() {
		controler = new ControlleurOpenAUser();
		controler.setvProjet(this);
		//this.vEvaluer = controler.getvEvaluer();
		//vEvaluer.setvProjet(this);
	}
	
	private void actions() {
		retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.executeValiderProjet();
			}
			
		});
		
		
		progres.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.setEvaluerVisible();
				JTable table = new JTable();
				table = getTable();
				System.out.println(table);
				selection = controler.getLignes();
				System.out.println(selection);
				System.out.println(table.getSelectedRows());
			}
			
		});
		
		effectuer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(true);
			}
			
		});
		
		exporter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.exporterProjet();
			}
			
		});
		
		
	}
	
	public static int[] table() {
		return selection;
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ModelProjetPr getModelprojet() {
		return modelprojet;
	}

	public void setModelprojet(ModelProjetPr modelprojet) {
		this.modelprojet = modelprojet;
	}

	public VueEvaluerProgression getvEvaluer() {
		return vEvaluer;
	}

	public void setvEvaluer(VueEvaluerProgression vEvaluer) {
		this.vEvaluer = vEvaluer;
	}
	
	
	
	
	
}
