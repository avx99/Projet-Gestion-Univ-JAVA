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
import javax.swing.JTextField;





public class AfficherEtudiant extends JFrame
{
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JLabel title;
	private JTextField text;
	private JButton valider;
	

	public AfficherEtudiant()
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
		title = new JLabel("Donner le CNE d\'etudiant(e)");
		text = new JTextField(22);
		valider = new JButton("Valider");

	}
	
	
	public void dessiner()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		this.getContentPane().setLayout(new BorderLayout());
		p1.add(title);p2.add(text);p3.add(valider);
		this.getContentPane().add(p1,BorderLayout.NORTH);
		this.getContentPane().add(p2,BorderLayout.CENTER);
		this.getContentPane().add(p3,BorderLayout.SOUTH);
		this.getContentPane().add(new JPanel(),BorderLayout.EAST);
		this.getContentPane().add(new JPanel(),BorderLayout.WEST);
	}
	
	public void action()
	{

	}
	

	public static void main(String[] args) {
		AfficherEtudiant f = new AfficherEtudiant();
		f.setVisible(true);
		
		
	}

	
}
