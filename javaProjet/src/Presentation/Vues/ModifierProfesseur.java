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

import Metier.POJO.Professeur;
import Presentation.Controlleur.ControlleurProfesseurAdd;
import Presentation.Modules.ModelProfesseurProfesseur;

public class ModifierProfesseur extends JFrame
{
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel pp;
	private JTextField textFieldCode;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldGrade;
	private JTextField textFieldEmail;
	private JLabel text;
	private JLabel lblNomDuProfesseur;
	private JLabel lblPrenomDuProfesseur;
	private JLabel lblCodeProfesseur;
	private JLabel lblGradeDuProfesseur;
	private JLabel lblEmailDuProfesseur;
	private JButton valider;
	private JButton quitter;
	
	
	private ControlleurProfesseurAdd controlleur;
	private ModelProfesseurProfesseur model;
	private Professeur p;
	
	
	
	
	public ModifierProfesseur()
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
		pp = new JPanel();
		
		text = new JLabel("Inserer les information du professeur a modifier");
		
		lblCodeProfesseur = new JLabel("code du professeur");
		lblNomDuProfesseur = new JLabel("nom du professeur");
		lblPrenomDuProfesseur = new JLabel("prenom du professeur");
		lblGradeDuProfesseur = new JLabel("grade du professeur");
		lblEmailDuProfesseur = new JLabel("email du professeur");
		
		textFieldCode = new JTextField();
		textFieldCode.setEditable(false);
		textFieldNom = new JTextField();
		textFieldPrenom = new JTextField();
		textFieldGrade = new JTextField();
		textFieldEmail = new JTextField();
		
		valider = new JButton("Valider");
		quitter = new JButton("Quitter");
		
	}
	
	public void dessiner()
	{
		this.setSize(400, 500);
		this.getContentPane().setLayout(new BorderLayout());
		p1.add(text);
		p2.setLayout(new GridLayout(5,2,50,50));
		p3.setLayout(new GridLayout(1,2,50,50));
		
		p2.add(lblCodeProfesseur);p2.add(textFieldCode);p2.add(lblNomDuProfesseur);p2.add(textFieldNom);p2.add(lblPrenomDuProfesseur);
		p2.add(textFieldPrenom);p2.add(lblGradeDuProfesseur);p2.add(textFieldGrade);p2.add(lblEmailDuProfesseur);p2.add(textFieldEmail);
	
		p3.add(valider);p3.add(quitter);
		pp.add(p3);
		
		this.getContentPane().add(p1,BorderLayout.NORTH);
		this.getContentPane().add(p2,BorderLayout.CENTER);
		this.getContentPane().add(pp,BorderLayout.SOUTH);
		this.getContentPane().add(new JPanel(),BorderLayout.EAST);
		this.getContentPane().add(new JPanel(),BorderLayout.WEST);
	}

	
	
	
	public ControlleurProfesseurAdd getControlleur() {
		return controlleur;
	}


	public void setControlleur(ControlleurProfesseurAdd controlleur) {
		this.controlleur = controlleur;
	}


	public ModelProfesseurProfesseur getModel() {
		return model;
	}


	public void setModel(ModelProfesseurProfesseur model) {
		this.model = model;
	}


	public Professeur getP() {
		return p;
	}


	public void setP(Professeur p) {
		this.p = p;
	}


	public void action()
	{
		
		
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			p = new Professeur(textFieldCode.getText(),textFieldNom.getText(),textFieldPrenom.getText(),
					textFieldGrade.getText(),textFieldEmail.getText());	
				
			 controlleur.modifierProfesseur();
				
			}	
		
				
});
		}
		
	public static void main(String[] args) {
		ModifierProfesseur a = new ModifierProfesseur();
		a.setVisible(true);
	}
	
	
}
