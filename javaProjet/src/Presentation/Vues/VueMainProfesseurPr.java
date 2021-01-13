package Presentation.Vues;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentation.Controlleur.*;
import Presentation.Modules.ModelLoginPr;


public class VueMainProfesseurPr extends JFrame{
	
	
	private JPanel panel1 ;
	private JPanel panel2 ;
	private JPanel panel3 ;
	private JPanel panel4 ;
	
	
	
	private JButton affinfo;
	
	private JLabel not;
	private JTextField textnot;
	
	private JButton retour;
	private JButton affetd;
	private JButton affdoc;
	private JButton affrap;
	private JButton affproj;
	private JButton rendez;
	
	private ModelLoginPr m;
	private ControleurLoginProf clp = new ControleurLoginProf();
	private ControleurTablePr ct = new ControleurTablePr();
	private ControlleurOpenAUser controlleur;
	//private String code = "";

	
	
	public VueMainProfesseurPr() throws HeadlessException {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initialiser();
		this.dessiner();
		this.initialiserControlleurAndModel();
		this.initialiserNot();
		this.setTitle("Espace Professuer");
		this.setSize(1000,600);
		this.actions();
	}
	
	

	private void initialiser() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		
		not = new JLabel("Notification : ");
		textnot = new JTextField();
		
		affinfo = new JButton("<html>informations Personnelles</html>");
		
		
		retour = new JButton("Acceuil");
		affetd = new JButton("Afficher les Etudiants");
		affdoc = new JButton("Afficher les Documents");
		affrap = new JButton("Afficher les Rapports");
		affproj = new JButton("Afficher les Projets");
		rendez = new JButton("Afficher la liste des rendez-vous");


	}
	
	/*private void initialiserinformation(String code) {
		
		textnom = new JLabel();
		textprenom = new JLabel();
		textemail = new JLabel();
		
		textid = new JLabel(code);
		
	}
*/


	public ControleurLoginProf getClp() {
		return clp;
	}



	public void setClp(ControleurLoginProf clp) {
		this.clp = clp;
	}



	private void dessiner() {
		
		//panel1.setLayout(new GridLayout(2,1,20,20));
		panel2.setLayout(new GridLayout(2,1,20,20));
		panel3.setLayout(new GridLayout(2,3,50,50));
		panel4.setLayout(new GridLayout(1,2,50,50));
		
		/*panel1.add(info);
		panel1.add(infovide);
		panel1.add(nom);
		panel1.add(textnom);
		panel1.add(prenom);
		panel1.add(textprenom);
		panel1.add(email);
		panel1.add(textemail);
		panel1.add(id);
		panel1.add(textid);*/
		panel1.add(BorderLayout.CENTER, affinfo);
		
		panel2.add(not);
		panel2.add(textnot);
		
		panel3.add(retour);
		panel3.add(affetd);
		panel3.add(affrap);
		panel3.add(affdoc);
		panel3.add(affproj);
		panel3.add(rendez);
		
		panel4.add(BorderLayout.WEST, panel1);
		panel4.add(BorderLayout.EAST, panel2);
		
		this.add(BorderLayout.CENTER, panel4);
		this.add(BorderLayout.SOUTH, panel3);

		
	}
	
	
	
	public void initialiserControlleurAndModel()
	{
		controlleur = new ControlleurOpenAUser();
		controlleur.setF1(this);
		//model = new ModelLoginPr();
	}
	
	private void initialiserNot() {
		textnot.setText("voir si vous avez des rendez-vous !!");
	}
	
	private void actions() {
		retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//clp  = new ControleurLoginProf();
				//clp.executeLogin();
				controlleur.executeFirstWindow();
				dispose();
			}
			
		});
		
		affetd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlleur.executeProfEtudiantPr();
				
				
			}
		});
		
		affdoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlleur.executeProfDocumentPr();
				
			}
			
		});
		
		affrap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlleur.executeProfRapportPr();
				
			}
			
		});
		
		affproj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlleur.executeProfProjetPr();
				
			}
			
		});
		
		rendez.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlleur.executeProfRendezPr();
				
			}
			
		});
			affinfo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {					
					controlleur.executeProf();
					
					
				}
			
		});
	}


	public ModelLoginPr getM() {
		return m;
		
	}

	public void setM(ModelLoginPr m) {
		this.m = m;
		System.out.println(this.getM().getPassword());
	}
	
	

}
