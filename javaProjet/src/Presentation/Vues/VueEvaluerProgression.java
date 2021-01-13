package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Presentation.Controlleur.ControlleurOpenAUser;

public class VueEvaluerProgression extends JFrame{

	private JPanel panel1;
	private JPanel panel2;
	
	private JLabel progres;
	private JTextField evaluer;
	
	private JButton valider;
	
	private ControlleurOpenAUser controler;
	private VueProjetPr vProjet;
	private JTable table;
	private String str;

	public VueEvaluerProgression() throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.init();
		this.actions();
		this.setSize(300,200);
	}
	
	private void initialiser() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		progres = new JLabel("Progression");
		evaluer = new JTextField();
		
		valider = new JButton("Valider");
	}
	
	private void dessiner() {
		
		panel1.setLayout(new GridLayout(2,1,20,20));
		
		panel1.add(progres);
		panel1.add(evaluer);
		
		panel2.add(valider);
		
		this.add(BorderLayout.CENTER, panel1);
		this.add(BorderLayout.SOUTH, panel2);

	}
	
	private void init() {
		controler = new  ControlleurOpenAUser();
		controler.setvEvaluer(this);
	}
	
	private void actions() {
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				str = evaluer.getText();
				System.out.println(str);
				controler.executeEvaluer();
				System.out.println(evaluer.getText());
				dispose();

				
				
			}
			
		});
	}

	public VueProjetPr getvProjet() {
		return vProjet;
	}

	public void setvProjet(VueProjetPr vProjet) {
		this.vProjet = vProjet;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public ControlleurOpenAUser getControler() {
		return controler;
	}

	public void setControler(ControlleurOpenAUser controler) {
		this.controler = controler;
	}
	
	
	
	
	
	
	
}

