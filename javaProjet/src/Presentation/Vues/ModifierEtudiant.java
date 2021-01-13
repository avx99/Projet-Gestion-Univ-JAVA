package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Metier.POJO.Etudiant;
import Presentation.Controlleur.ControlleurEtudiantAd;
import Presentation.Modules.ModelEtudiantEtudiant;

public class ModifierEtudiant extends JFrame
{
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p;
	private JTextField textFieldCode;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldGrade;
	private JTextField textFieldEmail;
	private JTextField a;
	private JLabel text;
	private JLabel lblNomDuProfesseur;
	private JLabel lblPrenomDuProfesseur;
	private JLabel lblCodeProfesseur;
	private JLabel lblGradeDuProfesseur;
	private JLabel lblEmailDuProfesseur;
	private JLabel b;
	private JButton valider;
	private JButton quitter;
	
	
	
	
	private ControlleurEtudiantAd controlleur;
	private ModelEtudiantEtudiant model;
	private Etudiant e;
	
	
	
	
	
	
	
	
	public ControlleurEtudiantAd getControlleur() {
		return controlleur;
	}


	public void setControlleur(ControlleurEtudiantAd controlleur) {
		this.controlleur = controlleur;
	}


	public ModelEtudiantEtudiant getModel() {
		return model;
	}


	public void setModel(ModelEtudiantEtudiant model) {
		this.model = model;
	}


	public Etudiant getE() {
		return e;
	}


	public void setE(Etudiant e) {
		this.e = e;
	}


	public ModifierEtudiant()
	{
		this.initialiser();
		this.dessiner();
		this.action();
	}
	
	
	public void initialiser()
	{
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p = new JPanel();
		
		text = new JLabel("Inserer les information d\'etudiant a modifier");
		
		lblCodeProfesseur = new JLabel("CNE");
		lblNomDuProfesseur = new JLabel("code du professeur");
		lblPrenomDuProfesseur = new JLabel("nom d\'etudiant");
		lblGradeDuProfesseur = new JLabel("prenom d\'etudiant");
		lblEmailDuProfesseur = new JLabel("email d\'etudiant");
		b = new JLabel("anne d\'etudiant");
		
		textFieldCode = new JTextField();
		textFieldCode.setEditable(false);
		textFieldCode.setEditable(false);
		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldPrenom = new JTextField();
		textFieldGrade = new JTextField();
		textFieldEmail = new JTextField();
		a = new JTextField();
		
		valider = new JButton("Valider");
		quitter = new JButton("Quitter");
		
	}
	
	public void dessiner()
	{
		this.setSize(400, 500);
		this.getContentPane().setLayout(new BorderLayout());
		p1.add(text);
		p2.setLayout(new GridLayout(6,2,50,50));
		p3.setLayout(new GridLayout(1,2,50,50));
		
		p2.add(lblCodeProfesseur);p2.add(textFieldCode);p2.add(lblNomDuProfesseur);p2.add(textFieldNom);p2.add(lblPrenomDuProfesseur);
		p2.add(textFieldPrenom);p2.add(lblGradeDuProfesseur);p2.add(textFieldGrade);p2.add(lblEmailDuProfesseur);p2.add(textFieldEmail);
		p2.add(b);p2.add(a);
		p3.add(valider);p3.add(quitter);
		p.add(p3);
		
		this.getContentPane().add(p1,BorderLayout.NORTH);
		this.getContentPane().add(p2,BorderLayout.CENTER);
		this.getContentPane().add(p,BorderLayout.SOUTH);
		this.getContentPane().add(new JPanel(),BorderLayout.EAST);
		this.getContentPane().add(new JPanel(),BorderLayout.WEST);
	}

	
	
	public void action()
	{
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			e = new Etudiant(textFieldCode.getText(),textFieldNom.getText(),textFieldPrenom.getText(),
					textFieldGrade.getText(),textFieldEmail.getText(),a.getText());	
				
			 controlleur.modifierEtudiant();
				
			}	});
	}
	
	public static void main(String[] args) {
		ModifierEtudiant a = new ModifierEtudiant();
		a.setVisible(true);
	}
	
	
}
