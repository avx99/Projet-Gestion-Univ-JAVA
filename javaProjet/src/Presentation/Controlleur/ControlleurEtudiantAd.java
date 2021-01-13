package Presentation.Controlleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import Metier.Gestion.GestionEtudiant;
import Metier.Gestion.GestionProfesseur;
import Metier.POJO.Etudiant;
import Metier.POJO.Professeur;
import Metier.POJO.Projet;
import Metier.POJO.Rapport;
import Presentation.Vues.AddEtudiant;
import Presentation.Vues.AfficherProjetsFromEtudiant;
import Presentation.Vues.AfficherRapportFromEtudiant;
import Presentation.Vues.EtudiantAdministration;
import Presentation.Vues.FirstWindow;
import Presentation.Vues.ModifierEtudiant;



public class ControlleurEtudiantAd {

	private ArrayList<Etudiant> etds;
	private ArrayList<Projet> prjs;
	private ArrayList<Rapport> raps;
	private FirstWindow f0;
	private EtudiantAdministration f1;
	private AddEtudiant f2;
	private ModifierEtudiant f3;
	private AfficherRapportFromEtudiant f4;
	private AfficherProjetsFromEtudiant f5;
	
	public ControlleurEtudiantAd(ArrayList<Etudiant> etds, EtudiantAdministration f1) {
		super();
		this.etds = etds;
		this.f1 = f1;
	}

	
	public ControlleurEtudiantAd() {
	}
	
	
	public ControlleurEtudiantAd(ArrayList<Rapport> raps, AfficherRapportFromEtudiant f4) {
		super();
		this.raps = raps;
		this.f4 = f4;
	}




	public ControlleurEtudiantAd(ArrayList<Projet> prjs, AfficherProjetsFromEtudiant f5) {
		super();
		this.prjs = prjs;
		this.f5 = f5;
	}

	
	public void executeAcceuil()
	{
		f0 = new FirstWindow();
		f0.setVisible(true);
		f1.dispose();
	}


	public void executeAddEtudiant()
	{
		f2 = new AddEtudiant();
		f2.setControlleur(this);
		f2.setVisible(true);
		f2.setSize(500,500);
	}
	
	public void executeEtudiantAdministration()
	{
		Etudiant e = f2.getE();
		Etudiant ne = GestionEtudiant.searchById(e.getCNE());
		Professeur pe = GestionProfesseur.searchById(e.getCode_professeur());
		if(ne.getCNE() != null)
		{
			JOptionPane.showMessageDialog(null, "L'etudiant qui a le CNE "+e.getCNE()+" est deja dans la base donne");
			return;
		}
		else if(pe.getCode_professeur() == null)
		{
			JOptionPane.showMessageDialog(null, "Le professeur qui a le Code "+e.getCode_professeur()+" n\'existe pas est dans la base donne");
			return;
		}
		else
		{
			GestionEtudiant.insert(e);
		}
		 f1.setE(e);
		 f2.dispose();
	}
	
	public void deleteEtudiant()
	{
		Etudiant e;
		int [] selection= f1.getTable().getSelectedRows();
		for(int i =selection.length-1;i>=0;i--) {
			
			e = new Etudiant((String)f1.getModel().getValueAt(selection[i],0),
					(String)f1.getModel().getValueAt(selection[i],1),
					(String)f1.getModel().getValueAt(selection[i],2),
					(String)f1.getModel().getValueAt(selection[i],3),
					(String)f1.getModel().getValueAt(selection[i],4),
					(String)f1.getModel().getValueAt(selection[i],5));
			f1.getModel().supprimer(selection[i]);
			GestionEtudiant.delete(e);
			e = null;
			System.gc();
		}
	}
	
	
	
	public void modifierEtudiant()
	{
		Etudiant e = new Etudiant();
		Etudiant ne;
		e = f3.getE();

		int [] selection= f1.getTable().getSelectedRows();
		for(int i =selection.length-1;i>=0;i--) {
		f1.getModel().setValueAt(e.getNom_etudiant(),selection[i],2);
		f1.getModel().setValueAt(e.getPrenom_etudiant(),selection[i],3);
		f1.getModel().setValueAt(e.getEmail_etudiant(),selection[i],4);
		f1.getModel().setValueAt(e.getAnne(),selection[i],5);
		ne = new Etudiant((String)f1.getModel().getValueAt(selection[i],0),
				(String)f1.getModel().getValueAt(selection[i],2),
				(String)f1.getModel().getValueAt(selection[i],3),
				(String)f1.getModel().getValueAt(selection[i],4),
				(String)f1.getModel().getValueAt(selection[i],5));
		GestionEtudiant.update(ne);
		ne = null;
		System.gc();
		}
		f1.getTable().setRowSelectionInterval(0,0);
		f3.dispose();
	}
	
	
	
	public void executeModifierEtudiant()
	{
		f3 = new ModifierEtudiant();
		f3.setControlleur(this);
		f3.setVisible(true);
		f3.setSize(500,500);
	}
	
	public void executeAfficherRapport()
	{
		f4 = new AfficherRapportFromEtudiant();
		f4.setControlleur(this);
		f4.setVisible(true);
	}
	
	
	public void executeAfficherProjets()
	{
		f5 = new AfficherProjetsFromEtudiant();
		f5.setControlleur(this);
		f5.setVisible(true);
	}
	
	
	
	
	public void insert3et4anne()
	{
		try  
		{  
			String[] s;
			Etudiant e = new Etudiant();
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION)
			{
				    File selectedFile = jfc.getSelectedFile();
				    File file=new File(selectedFile.getAbsolutePath());
					FileReader fr=new FileReader(file);
					BufferedReader br=new BufferedReader(fr);
					String line;  
					while((line=br.readLine())!=null)  
					{
						s = line.split(";");
						e = new Etudiant(s[0],s[1],s[2],s[3],s[4],s[5]);
						Etudiant ne = GestionEtudiant.searchById(e.getCNE());
						Professeur pe = GestionProfesseur.searchById(e.getCode_professeur());
						if(ne.getCNE() != null)
						{
							JOptionPane.showMessageDialog(null, "L'etudiant qui a le CNE "+e.getCNE()+" est deja dans la base donne\n essayez de ien posez le fichier csv!");
							return;
						}
						else if(pe.getCode_professeur() == null)
						{
							JOptionPane.showMessageDialog(null, "Le professeur qui a le Code "+e.getCode_professeur()+" n\'existe pas est dans la base donne\\n essayez de ien posez le fichier csv!");
							return;
						}
						else
						{
							if(s[5].equals("4") || s[5].equals("3"))
							{
								f1.setE(e);
								GestionEtudiant.insert(e);
							}
						}
						s = null;
						e = null;
						pe = null;
						ne = null;
						System.gc();
					}  
					fr.close();   
			}   
		
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}  
		JOptionPane.showMessageDialog(null, "Les eleves sont bien ajoutes dans la base de donne !");
		
	}
	
	

	public ArrayList<Etudiant> getEtds() {
		return etds;
	}

	public void setEtds(ArrayList<Etudiant> etds) {
		this.etds = etds;
	}

	public ArrayList<Projet> getPrjs() {
		return prjs;
	}

	public void setPrjs(ArrayList<Projet> prjs) {
		this.prjs = prjs;
	}

	public ArrayList<Rapport> getRaps() {
		return raps;
	}

	public void setRaps(ArrayList<Rapport> raps) {
		this.raps = raps;
	}

	public EtudiantAdministration getF1() {
		return f1;
	}

	public void setF1(EtudiantAdministration f1) {
		this.f1 = f1;
	}

	public AddEtudiant getF2() {
		return f2;
	}

	public void setF2(AddEtudiant f2) {
		this.f2 = f2;
	}

	public ModifierEtudiant getF3() {
		return f3;
	}

	public void setF3(ModifierEtudiant f3) {
		this.f3 = f3;
	}

	public AfficherRapportFromEtudiant getF4() {
		return f4;
	}

	public void setF4(AfficherRapportFromEtudiant f4) {
		this.f4 = f4;
	}

	public AfficherProjetsFromEtudiant getF5() {
		return f5;
	}

	public void setF5(AfficherProjetsFromEtudiant f5) {
		this.f5 = f5;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
