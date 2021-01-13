package Presentation.Vues;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChoiceForAdmin extends JFrame
{
	private JPanel contentPane;
	private JButton valider;
	private JButton acceuil;
	private JRadioButton professeur;
	private JRadioButton etudiant;
	private JLabel label;
	
	
	
	public ChoiceForAdmin() 
	{
		this.initialiser();
		this.dessiner();
		this.action();
	}
	
	public void initialiser()
	{
		contentPane = new JPanel();
		valider = new JButton("Valider");
		acceuil = new JButton("Accueil");
		professeur = new JRadioButton("Professeurs");
		etudiant = new JRadioButton("Etudiants");
		label = new JLabel("A quel espace vous voulez acceder ?");
	}
	
	public void dessiner()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		valider.setBounds(157, 173, 119, 43);
		acceuil.setBounds(172, 227, 89, 23);
		professeur.setBounds(98, 95, 109, 23);
		etudiant.setBounds(257, 95, 109, 23);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(67, 11, 334, 66);
		contentPane.add(label);
		contentPane.add(professeur);
		contentPane.add(etudiant);
		contentPane.add(valider);
		contentPane.add(acceuil);
	}
	


	public void action()
	{
		
	}
	
	public static void main(String[] args)
	{
		ChoiceForAdmin f = new ChoiceForAdmin();
		f.setVisible(true);
	}
	
}
