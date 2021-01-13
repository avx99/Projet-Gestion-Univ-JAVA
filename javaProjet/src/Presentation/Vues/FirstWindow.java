package Presentation.Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Metier.POJO.Etudiant;
import Presentation.Controlleur.ControlleurFirstWindow;
import Presentation.Modules.ModelFirstWindow;





public class FirstWindow extends JFrame
{
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JLabel title;
	private JLabel choice;
	private JRadioButton etudiant;
	private JRadioButton administrateur;
	private JRadioButton professeur;
	private ButtonGroup group;
	private JButton valider;
	
	private ModelFirstWindow model;
	private ControlleurFirstWindow controlleur;

	public FirstWindow()
	{
		this.initialiser();
		this.dessiner();
		this.initialiserControlleurAndModel();
		this.action();
	}
	
	
	public void initialiser()
	{
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		title = new JLabel("PROJET JAVA");
		choice = new JLabel("vous etes un :");
		etudiant = new JRadioButton("Etudiant",true);
		administrateur = new JRadioButton("Administrarteur");
		professeur = new JRadioButton("Professeur");
		valider = new JButton("Valider votre choix");
		group = new ButtonGroup();
		group.add(etudiant);
		group.add(administrateur);
		group.add(professeur);
	}
	
	
	public void dessiner()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.getContentPane().setLayout(new BorderLayout());
		p2.setLayout(new GridLayout(1,3));
		administrateur.setActionCommand("Administrarteur");
		professeur.setActionCommand("Professeur");
		etudiant.setActionCommand("Etudiant");
		p2.add(etudiant);p2.add(professeur);p2.add(administrateur);
		p1.add(title);
		p3.add(valider);
		this.getContentPane().add(p1,BorderLayout.NORTH);
		this.getContentPane().add(p2,BorderLayout.CENTER);
		this.getContentPane().add(p3,BorderLayout.SOUTH);
	}
	
	
	public void initialiserControlleurAndModel()
	{
		controlleur = new ControlleurFirstWindow();
		controlleur.setF1(this);
		model = new ModelFirstWindow();
	}
	
	
	public void action()
	{
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setUser((String)group.getSelection().getActionCommand());
				controlleur.setM1(model);
				controlleur.executeLogin();
			}	});
	}
	

	public static void main(String[] args) {
		FirstWindow f = new FirstWindow();
		f.setVisible(true);		
	}


	public ModelFirstWindow getModel() {
		return model;
	}


	public void setModel(ModelFirstWindow model) {
		this.model = model;
	}


	public ControlleurFirstWindow getControlleur() {
		return controlleur;
	}


	public void setControlleur(ControlleurFirstWindow controlleur) {
		this.controlleur = controlleur;
	}
	
	
	
	

	
}
