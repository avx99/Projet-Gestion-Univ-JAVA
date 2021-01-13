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
import Presentation.Modules.ModelRapportPr;

public class VueRapportPr extends JFrame{
	
	private final String[] cols = {"ID","Nom rapport","CNE","Code_prof","Validation"};

	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JTable table;
	
	private JButton retour;
	private JButton valider;
	private JButton exporter;
	
	private ModelRapportPr modelrp;
	
	private ControlleurOpenAUser controler;
	
	
	public VueRapportPr(ModelRapportPr modelrp) throws HeadlessException {
		super();
		
		this.modelrp = modelrp;
		this.initialiser(this.modelrp);
		this.dessiner();
		this.init();
		this.setTitle("Rapports");
		this.setSize(500,400);
		this.actions();
	}
	
	private void initialiser(ModelRapportPr modelrp) {
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		table = new JTable(modelrp);
		
		retour = new JButton("Retour");
		valider = new JButton("Valider");
		exporter = new JButton("Exporter");
		
	}
	
	private void dessiner() {
		
		panel1.add(table);
		panel2.add(retour);
		panel3.add(valider);
		panel3.add(exporter);
		
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.add(BorderLayout.WEST, panel2);
		this.add(BorderLayout.SOUTH, panel3);
			
	}
	
	private void init() {
		controler = new ControlleurOpenAUser();
		controler.setvRapport(this);
		
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
				dispose();
				controler.executeValideRapport();
				setVisible(true);
			}
			
		});
		
		exporter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
				controler.exporterRapport();
				//setVisible(true);
			}
			
		});
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ModelRapportPr getModelrp() {
		return modelrp;
	}

	public void setModelrp(ModelRapportPr modelrp) {
		this.modelrp = modelrp;
	}
	
	

}
