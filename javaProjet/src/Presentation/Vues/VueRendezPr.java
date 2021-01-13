
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
import Presentation.Modules.ModelRendezPr;

public class VueRendezPr extends JFrame{
	
	private final String[] cols = {"ID","Date","Professeur","Etudiant"};

	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JTable table;
	
	private JButton retour;
	private JButton supprimer;
	private JButton ajouter;
	private JButton modifier;
	private JButton effectuer;
	
	private ModelRendezPr mrp;
	
	private ControlleurOpenAUser controler;
	
	public VueRendezPr(ModelRendezPr mrp) throws HeadlessException {
		super();
		this.mrp = mrp;
		this.initialiser(this.mrp);
		this.dessiner();
		this.init();
		this.setTitle("Rendez vous");
		this.actions();
		this.setSize(500,400);
	}
	
	private void initialiser(ModelRendezPr mrp) {
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		table = new JTable(mrp);
		
		retour = new JButton("Retour");
		ajouter = new JButton("Ajouter un rendez-vous");
		supprimer = new JButton("Supprimer");
		modifier = new JButton("Modifier");
		effectuer = new JButton("Effectuer");
		
	}
	
	private void dessiner() {
		
		panel1.add(table);
		panel2.add(retour);
		panel3.add(ajouter);
		panel3.add(supprimer);
		panel3.add(modifier);
		panel3.add(effectuer);

		
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.add(BorderLayout.WEST, panel2);
		this.add(BorderLayout.SOUTH, panel3);
		
		
		
	}
	
	private void init() {
		controler = new ControlleurOpenAUser();
		controler.setvRendez(this);
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
				controler.executeSetrendez();
				dispose();
			}
			
		});
		
		supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.executeSupprimerRendez();
				
				
			}
			
		});
		
		modifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.executeModifier();
				
			}
			
		});
		
		effectuer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(true);
			}
			
		});
	}

	public ModelRendezPr getMrp() {
		return mrp;
	}

	public void setMrp(ModelRendezPr mrp) {
		this.mrp = mrp;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	
	
	
	
	
}
