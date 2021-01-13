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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Presentation.Controlleur.ControlleurFirstWindow;
import Presentation.Controlleur.ControlleurOpenAUser;
import Presentation.Modules.ModelFirstWindow;
import Presentation.Modules.ModelLoginPr;

public class VueLoginPr extends JFrame{
	
	private JPanel panel ;
	private JPanel panel2;
	private JLabel user;
	private JLabel pass;
	private JTextField username;
	private JPasswordField password;
	private JButton login;
	private JButton acceuil;
	
	private ModelLoginPr model;
	private ControlleurOpenAUser controlleur;
	
	private static String ss;
	private static String nom;
	private static String prenom;
	private static String email;
	

	public VueLoginPr() throws HeadlessException {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initialiser();
		this.dessiner();
		this.setTitle("Professeur");
		this.initialiserControlleurAndModel();
		this.action();

	}

	
	private void initialiser() {
		this.setTitle("Etudiants");
		this.setSize(500,200);
		
		panel = new JPanel();
		panel2 = new JPanel();
		
		
		user = new JLabel("Username");
		pass = new JLabel("Password");
		
		username = new JTextField();
		password = new JPasswordField();
		
		login = new JButton("Login");
		acceuil = new JButton("Acceuil");
		
	}
	
	private void dessiner() {
		
		panel.setLayout(new GridLayout(2,2,20,20));
		
		panel.add(user);
		panel.add(username);
		panel.add(pass);
		panel.add(password);
		
		panel2.add(acceuil);
		panel2.add(login);
		
		this.add(BorderLayout.CENTER, panel);
		this.add(BorderLayout.SOUTH, panel2);
		

	}

	
	
	public void initialiserControlleurAndModel()
	{
		controlleur = new ControlleurOpenAUser();
		controlleur.setF0(this);
		model = new ModelLoginPr();
	}
	

	public String getLoginCode() {
		String code = model.getPassword();
		return code;
	}

	
	public void action()
	{
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.setUsername(username.getText());
				model.setPassword(password.getText());
				ss = model.getPassword();
				nom = model.getUsername();
				controlleur.setModel(model);
				controlleur.execute();
				dispose();
			}	
		});
		
		acceuil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlleur.executeFirstWindow();
				dispose();
			}
			
		});
	}
	
	
	public static String key() {
		return ss;
	}
	

	
	

	public ModelLoginPr getModel() {
		return model;
	}


	public void setModel(ModelLoginPr model) {
		this.model = model;
	}


	public ControlleurOpenAUser getControlleur() {
		return controlleur;
	}


	public void setControlleur(ControlleurOpenAUser controlleur) {
		this.controlleur = controlleur;
	}

	
	
	
	
	
	
	
	
}
