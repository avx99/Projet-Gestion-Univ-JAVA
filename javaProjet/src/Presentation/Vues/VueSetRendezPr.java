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
import javax.swing.JTextField;

import Presentation.Controlleur.ControlleurOpenAUser;

public class VueSetRendezPr extends JFrame{
	
	private JPanel panel1;
	private JPanel panel2;
	
	private JLabel id;
	private JLabel date;
	private JLabel cne;
	
	private JTextField textid;
	private JTextField textdate;
	private JTextField textcne;
	
	private JButton valider;
	private JButton retour;
	
	private ControlleurOpenAUser controler;
	

	public VueSetRendezPr() throws HeadlessException {
		super();
		this.initialiser();
		this.dessiner();
		this.init();
		this.actions();
		this.setSize(400, 500);
	}
	
	private void initialiser() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		id = new JLabel("Id");
		date = new JLabel("Date");
		cne = new JLabel("CNE");
		
		textid = new JTextField();
		textdate = new JTextField();
		textcne = new JTextField();
		
		valider = new JButton("Valider");
		retour = new JButton("Retour");
		
	}
	
	private void dessiner() {
		panel1.setLayout(new GridLayout(3,2,30,30));
		
		panel1.add(id);
		panel1.add(textid);
		panel1.add(date);
		panel1.add(textdate);
		panel1.add(cne);
		panel1.add(textcne);
		
		panel2.add(retour);
		panel2.add(valider);
		
		this.add(BorderLayout.CENTER, panel1);
		this.add(BorderLayout.SOUTH, panel2);
		
	}
	
	public void init() {
		controler = new ControlleurOpenAUser();
		controler.setRendez(this);
		//this.vdp = controlleur.getVdp();
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
				controler.executeAjouterRendez(textid.getText(), textdate.getText(), textcne.getText());
				dispose();
			}
			
		});
	}
}
