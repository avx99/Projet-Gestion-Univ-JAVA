//package Presentation.Vues;
//
//import java.awt.BorderLayout;
//
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//import Presentation.Controlleur.ControlleurEspaceEtudiant;
//import Presentation.Modules.ModelLoginEtudiant;
//
//import javax.swing.JPasswordField;
//import javax.swing.JButton;
//
//public class VueEtudiant extends JFrame {
//	
//	private JLabel Message;
//	private JLabel LoginLabel;
//	private JLabel PasswordLabel;
//	
//	private JTextField Login;
//	private JPasswordField password;
//	
//	private JButton Valider;
//	private JButton Acueil;
//	
//	private JPanel Panel;
//	private JPanel Panel2;
//	
//	private ControlleurEspaceEtudiant EspaceEtudiant; 
//	
//	public VueEtudiant() {
//		
//		super("Espace Etudiant");
//		this.intialliser();
//		this.dessiner();
//		this.actions();
//	}
//
//	private void intialliser() {
//		
//		Panel = new JPanel();
//		Panel2 = new JPanel();
//		
//		Message = new JLabel("Connexion :");
//		LoginLabel = new JLabel("Nom : ");
//		PasswordLabel = new JLabel("CNE : ");
//		
//		Login = new JTextField(20);
//		password = new JPasswordField(20);
//		
//		Valider = new JButton("Valider");
//		Acueil = new JButton("Acueil");
//		
//		EspaceEtudiant = new ControlleurEspaceEtudiant();
//		
//	}
//	
//	private void dessiner() {
//		
//		this.setLayout(new BorderLayout());
//		this.setSize(1200, 700);
//		
//		Panel.setLayout(new GridLayout(2, 2));
//		Panel.add(LoginLabel);
//		Panel.add(Login);
//		Panel.add(PasswordLabel);
//		Panel.add(password);
//		
//		Panel2.setLayout(new FlowLayout(0,400,150));
//		Panel2.add(Acueil);
//		Panel2.add(Valider);
//		
//		EspaceEtudiant.setVue1(this);
//		
//		this.add(Message,BorderLayout.NORTH);
//		this.add(Panel,BorderLayout.CENTER);
//		this.add(Panel2, BorderLayout.SOUTH);
//	}
//	
//	private void actions() {	
//		Acueil.addActionListener(null);
//		
//		Valider.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				EspaceEtudiant.executeVueEtudiant2();
//			}
//		});
//	}
//	
//	public ModelLoginEtudiant getModelLoginEtudiant() {
//		
//		return new ModelLoginEtudiant(Login.getText(), password.getText());
//	}
//	
//}