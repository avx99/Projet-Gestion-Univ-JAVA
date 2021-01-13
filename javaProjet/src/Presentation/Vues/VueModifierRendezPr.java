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

public class VueModifierRendezPr extends JFrame{
	
	private JPanel panel1;
	private JPanel panel2;
	
	private JLabel date;
	private JTextField textDate;
	
	private JButton valider;
	
	private ControlleurOpenAUser controler;
	private String str;
	
	
	public VueModifierRendezPr() throws HeadlessException {
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
		
		date = new JLabel("Date Modification");
		textDate = new JTextField();
		
		valider = new JButton("Valider");
	}
	
	private void dessiner() {
		panel1.setLayout(new GridLayout(2,1,50,50));
		panel1.add(date);
		panel1.add(textDate);
		
		panel2.add(valider);
		
		this.add(BorderLayout.CENTER, panel1);
		this.add(BorderLayout.SOUTH, panel2);
	}
	private void init() {
		controler = new ControlleurOpenAUser();
		controler.setvMRendez(this);
	}
	
	
	private void actions() {
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				str = textDate.getText();
				controler.executeSetModification(str);
				dispose();
				
			}
			
		});
	}
	
	
	public ControlleurOpenAUser getControler() {
		return controler;
	}

	public void setControler(ControlleurOpenAUser controler) {
		this.controler = controler;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
