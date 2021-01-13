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
import Metier.POJO.Document;
import Presentation.Controlleur.ControlleurOpenAUser;

public class VueAjtDocumentPr extends JFrame{

	private JPanel panel1;
	private JPanel panel2;
	
	private JLabel iddco;
	private JLabel nomdoc;
	private JLabel idprjt;
	private JLabel cne;
	

	private JTextField textid;
	private JTextField textnom;
	private JTextField textprjt;
	private JTextField textcne;
	
	private JButton valider;
	private JButton retour;
	private Document doc;
	
	private VueDocumentPr vdp;
	private ControlleurOpenAUser controlleur;
	
	public VueAjtDocumentPr() throws HeadlessException {
		super();
		this.initilaiser();
		this.dessiner();
		this.init();
		this.actions();
		this.setSize(350,400);
	}
	
	private void initilaiser() {
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		iddco = new JLabel("ID");
		nomdoc = new JLabel("Nom");
		cne = new JLabel("CNE");
		idprjt = new JLabel("ID Projet");
		
		textid = new JTextField();
		textnom = new JTextField();
		textcne = new JTextField();
		textprjt = new JTextField();
		
		valider = new JButton("Valider");
		retour = new JButton("Retour");
		
	}
	
	private void dessiner() {
		
		panel1.setLayout(new GridLayout(4,2,20,20));
		
		panel1.add(iddco);
		panel1.add(textid);
		panel1.add(nomdoc);
		panel1.add(textnom);
		panel1.add(cne);
		panel1.add(textcne);
		panel1.add(idprjt);
		panel1.add(textprjt);
		
		panel2.add(retour);
		panel2.add(valider);
		
		this.add(BorderLayout.CENTER, panel1);
		this.add(BorderLayout.SOUTH, panel2);
		//this.setBounds(20, 20, 1200, 800);
		
	}
	
	public void init() {
		controlleur = new ControlleurOpenAUser();
		controlleur.setVadp(this);
		//this.vdp = controlleur.getVdp();
	}
	
	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
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
				controlleur.executeAjouterDoc(textid.getText(),textnom.getText(),textcne.getText(),textprjt.getText());
				dispose();
				
			}
			
		});
	}

	
	public VueDocumentPr getVdp() {
		return vdp;
	}

	public void setVdp(VueDocumentPr vdp) {
		this.vdp = vdp;
	}
	
	

}
