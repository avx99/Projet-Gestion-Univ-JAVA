package Presentation.Controlleur;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentation.Vues.VueProjetPr;

public class VueChercherPr extends JFrame{
	
	private JPanel panel1;
	private JPanel panel2;
	
	private JTextField textcode;
	
	private JButton chercher;
	
	private ControlleurOpenAUser controler;
	
	
	public VueChercherPr() throws HeadlessException {
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
		
		
		textcode = new JTextField();
		
		chercher = new JButton("Chercher");
	}
	
	private void dessiner() {
		
		panel1.setLayout(new GridLayout(2,1,20,20));
		
		panel1.add(textcode);
		
		panel2.add(chercher);
		
		this.add(BorderLayout.CENTER, panel1);
		this.add(BorderLayout.SOUTH, panel2);

	}
	
	private void init() {
		controler = new  ControlleurOpenAUser();
		//controler.setvEvaluer(this);
		//vProjet = controler.getvProjet();
		
	}
	
	private void actions() {
		chercher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ss = textcode.getText();
				//controler.executeEvaluer();
				dispose();

				
				
			}
			
		});
	}

}
