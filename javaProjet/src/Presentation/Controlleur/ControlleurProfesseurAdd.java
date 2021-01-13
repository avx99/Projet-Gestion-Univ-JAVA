package Presentation.Controlleur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Metier.Gestion.GestionEtudiant;
import Metier.Gestion.GestionProfesseur;
import Metier.POJO.Document;
import Metier.POJO.Etudiant;
import Metier.POJO.Professeur;
import Presentation.Vues.AddProfesseur;
import Presentation.Vues.AfficherDocumentsFromProfesseur;
import Presentation.Vues.FirstWindow;
import Presentation.Vues.ModifierProfesseur;
import Presentation.Vues.ProfesseurAdministration;


public class ControlleurProfesseurAdd
{
	private ArrayList<Professeur> profs;
	private ArrayList<Document> docs;
	private FirstWindow f0;
	private ProfesseurAdministration f1;
	private AddProfesseur f2;
	private ModifierProfesseur f3;
	private AfficherDocumentsFromProfesseur f4;
	
	
	
	
	public ControlleurProfesseurAdd(ArrayList<Document> docs, AfficherDocumentsFromProfesseur f4) {
		super();
		this.docs = docs;
		this.f4 = f4;
	}
	
	
	
	public ControlleurProfesseurAdd(ArrayList<Professeur> profs, AddProfesseur f2, ProfesseurAdministration f1) {
		super();
		this.profs = profs;
		this.f2 = f2;
		this.f1 = f1;
	}
	public ControlleurProfesseurAdd(ArrayList<Professeur> profs, ProfesseurAdministration f1) {
		super();
		this.profs = profs;
		this.f1 = f1;
	}
	
	
	public void executeAcceuil()
	{
		f0 = new FirstWindow();
		f0.setVisible(true);
		f1.dispose();
	}
	
	public void executeAddProfesseur()
	{
		f2 = new AddProfesseur();
		f2.setControlleur(this);
		f2.setVisible(true);
		f2.setSize(500,500);
	}
	
	public void executeModifierProfesseur()
	{
		f3 = new ModifierProfesseur();
		f3.setControlleur(this);
		f3.setVisible(true);
		f3.setSize(500,500);
	}
	
	public void executeProfesseurAdminstration()
	{
		 Professeur p =f2.getP();
			Professeur np = new Professeur();
			np = GestionProfesseur.searchById(p.getCode_professeur());
			if(np.getCode_professeur() != null)
			{
				JOptionPane.showMessageDialog(null, "Erorrrr");
				return;
			}
			else
			{
				GestionProfesseur.insert(p);
			}
		 f1.setP(p);
		 f2.dispose();
	}
	
	public void deleteProfesseur()
	{
		Professeur p;
		int [] selection= f1.getTable().getSelectedRows();
		for(int i =selection.length-1;i>=0;i--) {
			p = new Professeur((String)f1.getModel().getValueAt(selection[i],0),
					(String)f1.getModel().getValueAt(selection[i],1),
					(String)f1.getModel().getValueAt(selection[i],2),
					(String)f1.getModel().getValueAt(selection[i],3),
					(String)f1.getModel().getValueAt(selection[i],4));
			f1.getModel().supprimer(selection[i]);
			GestionProfesseur.delete(p);
			p = null;
			System.gc();
		}
	}
	
	
	public void modifierProfesseur()
	{
		Professeur p = new Professeur();
		Professeur np;
		p = f3.getP();
		int [] selection= f1.getTable().getSelectedRows();
		for(int i =selection.length-1;i>=0;i--) {
		f1.getModel().setValueAt(p.getNom_professeur(),selection[i],1);
		f1.getModel().setValueAt(p.getPrenom_professeur(),selection[i],2);
		f1.getModel().setValueAt(p.getGrade_professeur(),selection[i],3);
		f1.getModel().setValueAt(p.getEmail_professeur(),selection[i],4);
		np = new Professeur((String)f1.getModel().getValueAt(selection[i],0),
				(String)f1.getModel().getValueAt(selection[i],1),
				(String)f1.getModel().getValueAt(selection[i],2),
				(String)f1.getModel().getValueAt(selection[i],3),
				(String)f1.getModel().getValueAt(selection[i],4));
		GestionProfesseur.update(np);
		np = null;
		System.gc();
		}
		f1.getTable().setRowSelectionInterval(0,0);
		f3.dispose();
	}
	
	
	
	public void executeAfficherDocuments()
	{
		f4 = new AfficherDocumentsFromProfesseur();
		f4.setControlleur(this);
		f4.setVisible(true);
	}
	
	
	public ArrayList<Document> getDocs() {
		return docs;
	}
	public void setDocs(ArrayList<Document> docs) {
		this.docs = docs;
	}
	public AfficherDocumentsFromProfesseur getF4() {
		return f4;
	}
	public void setF4(AfficherDocumentsFromProfesseur f4) {
		this.f4 = f4;
	}
	public ModifierProfesseur getF3() {
		return f3;
	}
	public void setF3(ModifierProfesseur f3) {
		this.f3 = f3;
	}
	
	public ControlleurProfesseurAdd() {
		super();
	}
	public ArrayList<Professeur> getProfs() {
		return profs;
	}
	public void setProfs(ArrayList<Professeur> profs) {
		this.profs = profs;
	}
	public AddProfesseur getF2() {
		return f2;
	}
	public void setF2(AddProfesseur f2) {
		this.f2 = f2;
	}
	public ProfesseurAdministration getF1() {
		return f1;
	}
	public void setF1(ProfesseurAdministration f1) {
		this.f1 = f1;
	}
	
	
	
	
}
