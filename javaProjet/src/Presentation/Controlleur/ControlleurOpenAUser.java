package Presentation.Controlleur;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import Metier.Gestion.GestionDocument;
import Metier.Gestion.GestionEtudiant;
import Metier.Gestion.GestionProfesseur;
import Metier.Gestion.GestionProjet;
import Metier.Gestion.GestionRapport;
import Metier.Gestion.GestionRendez;
import Metier.Gestion.GestionUser;
import Metier.POJO.Document;
import Metier.POJO.Etudiant;
import Metier.POJO.Professeur;
import Metier.POJO.Projet;
import Metier.POJO.Rapport;
import Metier.POJO.Rendez;
import Presentation.Modules.ModelDocumentPr;
import Presentation.Modules.ModelEtudiantPr;
import Presentation.Modules.ModelLoginPr;
import Presentation.Modules.ModelProjetPr;
import Presentation.Modules.ModelRapportPr;
import Presentation.Modules.ModelRendezPr;
import Presentation.Vues.AjoutDocument;
import Presentation.Vues.AjoutProjet;
import Presentation.Vues.AjoutRapport;
import Presentation.Vues.FirstWindow;
import Presentation.Vues.ProfesseurAdministration;
import Presentation.Vues.VueAjtDocumentPr;
import Presentation.Vues.VueDocument;
import Presentation.Vues.VueDocumentPr;
import Presentation.Vues.VueEtudiant2;
import Presentation.Vues.VueEtudiantPr;
import Presentation.Vues.VueEvaluerProgression;
import Presentation.Vues.VueLoginPr;
import Presentation.Vues.VueMainProfesseurPr;
import Presentation.Vues.VueModifierRendezPr;
import Presentation.Vues.VueProjet;
import Presentation.Vues.VueProjetPr;
import Presentation.Vues.VueRapport;
import Presentation.Vues.VueRapportPr;
import Presentation.Vues.VueRendezPr;
import Presentation.Vues.VueSetRendezPr;

public class ControlleurOpenAUser {
	
	private VueLoginPr f0;
	private VueMainProfesseurPr f1;
//	private VueEtudiant2 f2;
	private ProfesseurAdministration f3;
	private ModelLoginPr model;
	private FirstWindow fw;
	
	private VueEtudiantPr vep;
	private ModelEtudiantPr mep;
	
	private VueDocumentPr vdp;
	private ModelDocumentPr mdp;
	private VueAjtDocumentPr vadp;
	
	private VueProjetPr vProjet;
	private ModelProjetPr mProjet;
	private VueEvaluerProgression vEvaluer;
	
	private VueRapportPr vRapport;
	private ModelRapportPr mRapport;
	
	private VueRendezPr vRendez;
	private ModelRendezPr mRendez;
	private VueSetRendezPr rendez;
	private VueModifierRendezPr vMRendez;

	private ArrayList<Projet> table1;
	private ArrayList<Document> table2;
	private ArrayList<Rapport> table3;
	private ArrayList<Rendez> table4;
	private static Professeur pr ;
	private VueProjet vue3;
	private Etudiant etudiant;
	private VueDocument vue4;
	private VueRapport vue5;
	
	private VueEtudiant2 vue2; // principal

	
	private AjoutDocument ajoutDocument;
	private AjoutProjet ajoutProjet;
	private AjoutRapport ajoutRapport;


	
	public ControlleurOpenAUser() {
		super();
	}
	
	public void executeProfesseur()
	{
		if(GestionUser.isProf(model.getUsername(), model.getPassword()) == true)
		{
			f1 = new VueMainProfesseurPr();
			f1.setM(model);
			f1.setVisible(true);
			f0.dispose();
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "lexxx mot de passe ou le nom est incorrect !");
		}
	}
	
	public void executeEtudiant()
	{
		if(GestionUser.isEtd(model.getUsername(), model.getPassword()))
		{
			table1 = GestionProjet.getProjetsEtudiant(model.getPassword());
			table2 = GestionDocument.getDocumentsEtudiant(model.getPassword());
			table3 = GestionRapport.getRapportsEtudiant(model.getPassword());
			table4 = GestionRendez.getRendezEtudiant(model.getPassword());
			
			vue3 = new VueProjet(table1);
			vue4 = new VueDocument(table2);
			vue5 = new VueRapport(table3);
			
			vue2 = new VueEtudiant2();
			vue2.setControlleur(this);
			etudiant = GestionEtudiant.searchById(model.getPassword());
			vue2.setEtudiant(etudiant);
			vue2.setRendez(table4);
			vue2.setVisible(true);
			
			f0.dispose();
//			f2 = new VueEtudiant2();
//			f2.setM(model);
//			f2.setVisible(true);
//			f0.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "le mot de passe ou le nom est incorrect !");
		}
	}
	
	public void executeAdmin()
	{
		if(GestionUser.isAdmin(model.getUsername(), model.getPassword()))
		{
			f3 = new ProfesseurAdministration();
			f3.setVisible(true);
			f0.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "le mot de passe ou le nom est incorrect !");
		}
	}
	
	public void execute()
	{
		model = f0.getModel();
		if(model.getUser().equals("Etudiant"))
			executeEtudiant();
		if(model.getUser().equals("Professeur"))
			executeProfesseur();
		if(model.getUser().equals("Administrarteur"))
			executeAdmin();
		
	}
	//*************************************************************************************mustafa
	
	
	
public void executeProjets() {
		
		vue3.setControlleur(this);
		vue3.setVisible(true);
		vue2.dispose();
		
	}
	
	public void executeRapports() {
		
		vue5.setControlleur(this);
		vue5.setVisible(true);
		vue2.dispose();
		
	}
	
	public void executeDocuments() {
		vue4.setControlleur(this);
		vue4.setVisible(true);
		vue2.dispose();
	}

	

	public void acceuilVueEtudiant2() {
		fw = new FirstWindow();
		fw.setVisible(true);
		vue2.dispose();
	}
	
	
	
	public void acceuilDoc() {
		fw = new FirstWindow();
		fw.setVisible(true);
		vue4.dispose();
	}
	public void acceuilProj() {
		fw = new FirstWindow();
		fw.setVisible(true);
		vue3.dispose();
	}
	public void acceuilRapp() {
		fw = new FirstWindow();
		fw.setVisible(true);
		vue5.dispose();
	}
	

	public void executeVueEtudiant2Document() {
		
		vue2.setVisible(true);
		vue4.dispose();
		
	}
	
	public void executeVueEtudiant2Projet() {
		
		vue2.setVisible(true);
		vue3.dispose();
		
	}
	
	public void executeVueEtudiant2Rapport() {
		
		vue2.setVisible(true);
		vue5.dispose();
		
	}


	public void executeAjoutDocument() {
		
		ajoutDocument = new AjoutDocument();
		ajoutDocument.setControlleur(this);
		ajoutDocument.setVisible(true);
		
	}


	public void executeAjoutProjet() {
		
		ajoutProjet = new AjoutProjet();
		ajoutProjet.setControlleur(this);
		ajoutProjet.setVisible(true);
		
	}
	
	public void executeAjoutRapport() {
		
		ajoutRapport = new AjoutRapport();
		ajoutRapport.setControlleur(this);
		ajoutRapport.setVisible(true);
		
	}


	public void executeProjetAjout() {
		
		Projet P = ajoutProjet.getProjet(etudiant.getCNE(), etudiant.getCode_professeur());
		ajoutProjet.dispose();
		vue3.setProjet(P);
	}
	
	public void executeDocumentAjout() {
		
		Document P = ajoutDocument.getDocument(etudiant.getCNE(), etudiant.getCode_professeur());
		ajoutDocument.dispose();
		vue4.setDocument(P);
	}
	
	public void executeRapportAjout() {
		
		Rapport P = ajoutRapport.getRapport(etudiant.getCNE(), etudiant.getCode_professeur());
		ajoutRapport.dispose();
		vue5.setRapport(P);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//*************************************************************************************888
	
	
	public String recupCode() {
		return VueLoginPr.key();
	}
	
	///Information Personnelles
	public static String[] info(String l) {
		String[] list = new String[4];
		
		pr = GestionProfesseur.searchById(l);
		list[0] = l;
		list[1] = pr.getNom_professeur();
		list[2] = pr.getPrenom_professeur();
		list[3] = pr.getEmail_professeur();
		return list;
	}
	
	public void executeProf() {
		f1 = new VueMainProfesseurPr();
		String[] tab = new String[4];
		tab = ControlleurOpenAUser.info(VueLoginPr.key());
		
		JOptionPane.showMessageDialog(null, "<html>Information Personnelles <br><br>Id : " + tab[0]+
				"<br><br>Nom : " + tab[1] + "<br><br>Prenom : "+ tab[2] + "<br><br>Email : "+ tab[3] +
				"<br><br></html>");
	}
	//******************************************************************************************
	
	///Aff info Etudiant
	public void executeProfEtudiantPr() {
		mep = new ModelEtudiantPr(VueLoginPr.key());
		vep = new VueEtudiantPr(mep);
		vep.setVisible(true);
	}
	
	///Aff info Document
	public void executeProfDocumentPr() {
		mdp = new ModelDocumentPr(VueLoginPr.key());
		vdp = new VueDocumentPr(mdp);
		vdp.setVisible(true);
	}
	
	//Aff info Projet
	public void executeProfProjetPr() {
		mProjet = new ModelProjetPr(VueLoginPr.key());	
		vProjet = new VueProjetPr(mProjet);
		vProjet.setVisible(true);
	}
	
	//Aff info Rapport
	public void executeProfRapportPr() {
		mRapport = new ModelRapportPr(VueLoginPr.key());
		vRapport = new VueRapportPr(mRapport);
		vRapport.setVisible(true);
	}
	
	//Aff info Rendez-vous
	public void executeProfRendezPr() {
		mRendez = new ModelRendezPr(VueLoginPr.key());
		vRendez = new VueRendezPr(mRendez);
		vRendez.setVisible(true);
	}
	
	//*********************************Ajouter-Document***********************///
	
	public void executeAjtPr() {
		vadp = new VueAjtDocumentPr();
		vadp.setVisible(true);
	}
	
	public void executeAjouterDoc(String id,String nom,String cne,String idprjt) {
		vdp = new VueDocumentPr(new ModelDocumentPr(VueLoginPr.key()));
		ArrayList<Etudiant> etds = new ArrayList<Etudiant>();
		etds = GestionEtudiant.getListEtudiantPr(VueLoginPr.key());
		ArrayList<Projet> projets = new ArrayList<Projet>();
		projets = GestionProjet.getListProjetPr(VueLoginPr.key());
		
		if((GestionEtudiant.chercher(cne, etds)==true) && (GestionProjet.chercher(idprjt, projets)==true)) {
			vdp.getModeldoc().addDocumentPr(new Document(id,nom,cne,idprjt,VueLoginPr.key(),"Professeur"));
			
		}
		else {
			JOptionPane.showMessageDialog(null, "CNE ou Id de projet Existe Pas ");
			
		}
		
	}
	
	public void executeSupprimerDoc() {
			Document d;
			boolean b = false;
			int [] selection= vdp.getTable().getSelectedRows();
			if(selection.length != 0) {
			for(int i=selection.length-1;i>=0;i--) {
				d = new Document((String)vdp.getModeldoc().getValueAt(selection[i],0),
						(String)vdp.getModeldoc().getValueAt(selection[i],1),
						(String)vdp.getModeldoc().getValueAt(selection[i],2),
						(String)vdp.getModeldoc().getValueAt(selection[i],3),
						(String)vdp.getModeldoc().getValueAt(selection[i],4),
						(String)vdp.getModeldoc().getValueAt(selection[i],5));
				if(((String)vdp.getModeldoc().getValueAt(selection[i], 5)).equals("Professeur")) {
					vdp.getModeldoc().deleteDocument(selection[i]);
					GestionDocument.delete(d);
				}
				
				d = null;
				System.gc();
			
		}
			}
			else {
				b = true;
			}
		
			if(b == true)
				JOptionPane.showMessageDialog(null, "Impossible de supprimer un document d'un etudiant");
	}
	
	
	public void importerFichier()
	{
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);  
		File selectedFile = jfc.getSelectedFile();	   
	   Document d;
	   int[] selection = vdp.getTable().getSelectedRows();
	   if(selection.length != 0) {
		   if(returnValue == JFileChooser.APPROVE_OPTION) {
			   String path = selectedFile.getAbsolutePath();
		   for(int i=selection.length-1;i>=0;i--) {
			   d = new Document((String)vdp.getModeldoc().getValueAt(selection[i],0),
						(String)vdp.getModeldoc().getValueAt(selection[i],1),
						(String)vdp.getModeldoc().getValueAt(selection[i],2),
						(String)vdp.getModeldoc().getValueAt(selection[i],3),
						(String)vdp.getModeldoc().getValueAt(selection[i],4),
						(String)vdp.getModeldoc().getValueAt(selection[i],5));
			   GestionDocument.setFile((String)vdp.getModeldoc().getValueAt(selection[i],0),path);
			   d=null;
			   System.gc();
		   }
		   JOptionPane.showMessageDialog(null, "Succees");
		   }
	   }else{
			JOptionPane.showMessageDialog(null, "Selectionner une ligne");
			
		}
	}
	
	public void exporterFichier() {
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = jfc.showOpenDialog(null);    
		File selectedFile = jfc.getSelectedFile();

	    if(returnValue == JFileChooser.APPROVE_OPTION) {
		File file=new File(selectedFile.getAbsolutePath());
	    String path = file.getAbsolutePath();
		int[] selection = vdp.getTable().getSelectedRows();
		if(selection.length !=0) {
		GestionDocument.getFile((String)vdp.getModeldoc().getValueAt(selection[0], 0),path,(String)vdp.getModeldoc().getValueAt(selection[0], 1)
				+(String)vdp.getModeldoc().getValueAt(selection[0], 0));
		 JOptionPane.showMessageDialog(null, "Succees");
	}
		else{
			JOptionPane.showMessageDialog(null, "Selectionner une ligne");
			
		}
	   
	}
	}
	//***************************************************Fin-Ajouter-Document************************///
	
	//******************************************Projet*****************************************//
	public void executeValiderProjet() {
			
			Projet p;
			int [] selection = vProjet.getTable().getSelectedRows();
			for(int i=selection.length-1;i>=0;i--) {
				p = new Projet((String)vProjet.getModelprojet().getValueAt(selection[i],0),
						(String)vProjet.getModelprojet().getValueAt(selection[i],1),
						(String)vProjet.getModelprojet().getValueAt(selection[i],2),
						(String)vProjet.getModelprojet().getValueAt(selection[i],3),
						(String)vProjet.getModelprojet().getValueAt(selection[i],4),
						(String)vProjet.getModelprojet().getValueAt(selection[i],5),
						(String)vProjet.getModelprojet().getValueAt(selection[i],6));
				vProjet.getModelprojet().setToValider(selection[i]);
				p.setValider("Valider");
				GestionProjet.update(p);
				p=null;
				System.gc();
			}
		}
	
	public void setEvaluerVisible() {
		vEvaluer = new  VueEvaluerProgression();
		vEvaluer.setControler(this);
		vEvaluer.setVisible(true);
	}
	
	
	public int[] getLignes() {
		int[] selection = vProjet.getTable().getSelectedRows();
		return selection;
	}
	
	public void executeEvaluer() {
		Projet p;
		String str = vEvaluer.getStr();
		int[] selection = this.vProjet.getTable().getSelectedRows();
		if(selection.length != 0) {
		for(int i=selection.length-1;i>=0;i--) {
			p = new Projet((String)vProjet.getModelprojet().getValueAt(selection[i],0),
					(String)vProjet.getModelprojet().getValueAt(selection[i],1),
					(String)vProjet.getModelprojet().getValueAt(selection[i],2),
					(String)vProjet.getModelprojet().getValueAt(selection[i],3),
					(String)vProjet.getModelprojet().getValueAt(selection[i],4),
					(String)vProjet.getModelprojet().getValueAt(selection[i],5),
					(String)vProjet.getModelprojet().getValueAt(selection[i],6));
			p.setProgres(str);
			vProjet.getModelprojet().setProgression(str, selection[i]);
			GestionProjet.update(p);
			p = null;
			System.gc();
		}
		
		}
		else
			JOptionPane.showMessageDialog(null, "Selectionner une ligne !");
		
	
	}
	
	public void exporterProjet() {
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = jfc.showOpenDialog(null);    
		File selectedFile = jfc.getSelectedFile();

	    if(returnValue == JFileChooser.APPROVE_OPTION) {
	    	
			File file=new File(selectedFile.getAbsolutePath());
		    String path = file.getAbsolutePath();
			int[] selection = vProjet.getTable().getSelectedRows();
			if(selection.length != 0) {
			GestionDocument.getFile((String)vProjet.getModelprojet().getValueAt(selection[0], 0),path,(String)vProjet.getModelprojet().getValueAt(selection[0], 0)
					+(String)vProjet.getModelprojet().getValueAt(selection[0], 2));
		
		    JOptionPane.showMessageDialog(null, "Succees");
			}else{
				JOptionPane.showMessageDialog(null, "Selectionner une ligne");
				
			}
	    }
	}

		
		
	public VueEvaluerProgression getvEvaluer() {
		return vEvaluer;
	}

	public void setvEvaluer(VueEvaluerProgression vEvaluer) {
		this.vEvaluer = vEvaluer;
	}

	public VueProjetPr getvProjet() {
		return vProjet;
	}
	
	public void setvProjet(VueProjetPr vProjet) {
		this.vProjet = vProjet;
	}
	//*******************************************Fin-Projet**************************************//
	
	

	///****************************Rapport*********************************************//
	public void executeValideRapport() {
		Rapport r;
		int [] selection = vRapport.getTable().getSelectedRows();
		for(int i=selection.length-1;i>=0;i--) {
			r = new Rapport((String)vRapport.getModelrp().getValueAt(selection[i],0),
					(String)vRapport.getModelrp().getValueAt(selection[i],1),
					(String)vRapport.getModelrp().getValueAt(selection[i],2),
					(String)vRapport.getModelrp().getValueAt(selection[i],3),
					(String)vRapport.getModelrp().getValueAt(selection[i],4));
			vRapport.getModelrp().setToValider(selection[i]);
			r.setValider("Valider");
			GestionRapport.update(r);
			r=null;
			System.gc();
		}
		
	}
	
	public void exporterRapport() {
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = jfc.showOpenDialog(null);    
		File selectedFile = jfc.getSelectedFile();

	    if(returnValue == JFileChooser.APPROVE_OPTION) {
	    	
			File file=new File(selectedFile.getAbsolutePath());
		    String path = file.getAbsolutePath();
			int[] selection = vRapport.getTable().getSelectedRows();
			if(selection.length != 0) {
			GestionDocument.getFile((String)vRapport.getModelrp().getValueAt(selection[0], 0),path,(String)vRapport.getModelrp().getValueAt(selection[0], 1)
					+(String)vRapport.getModelrp().getValueAt(selection[0], 0));
		
		    JOptionPane.showMessageDialog(null, "Succees");
	    }else{
			JOptionPane.showMessageDialog(null, "Selectionner une ligne");
			
		}
	    }
	}
	
	
	public VueRapportPr getvRapport() {
		return vRapport;
	}

	public void setvRapport(VueRapportPr vRapport) {
		this.vRapport = vRapport;
	}
	
	//******************************Fin-Rapport*************************************///////
	


	//************************************Rendez-Vous***************************//
	public void executeSetrendez() {
		rendez = new VueSetRendezPr();
		rendez.setVisible(true);
	}
	
	public void executeAjouterRendez(String id,String date, String cne) {
		mRendez = new ModelRendezPr(VueLoginPr.key());
		vRendez = new VueRendezPr(mRendez);
		ArrayList<Etudiant> etds = new ArrayList<Etudiant>();
		etds = GestionEtudiant.getListEtudiantPr(VueLoginPr.key());
		if(GestionEtudiant.chercher(cne, etds) == true) {
			vRendez.getMrp().addRendezPr(new Rendez(id,date,VueLoginPr.key(),cne));
			JOptionPane.showMessageDialog(null, "Le rendez-vous est bien ajoute !");

		}
		else {
			JOptionPane.showMessageDialog(null, "CNE Existe Pas !");
			
		}
	
	}
	
	public void executeSupprimerRendez() {
		Rendez d;
		int [] selection= vRendez.getTable().getSelectedRows();
		for(int i=selection.length-1;i>=0;i--) {
			d = new Rendez((String)vRendez.getMrp().getValueAt(selection[i],0),
					(String)vRendez.getMrp().getValueAt(selection[i],1),
					(String)vRendez.getMrp().getValueAt(selection[i],2),
					(String)vRendez.getMrp().getValueAt(selection[i],3));
			vRendez.getMrp().deleteRendez(selection[i]);
			GestionRendez.delete(d);
			d = null;
			System.gc();
		
	}	
}
	
	public void executeModifier() {
		vMRendez = new VueModifierRendezPr();
		vMRendez.setControler(this);
		vMRendez.setVisible(true);		
	}
	
	public void executeSetModification(String str) {
		Rendez r ;
		int[] selection = vRendez.getTable().getSelectedRows();
		if(selection.length !=0) {
		for(int i = selection.length-1;i>=0;i--) {
			r = new Rendez((String)vRendez.getMrp().getValueAt(selection[i],0),
					(String)vRendez.getMrp().getValueAt(selection[i],1),
					(String)vRendez.getMrp().getValueAt(selection[i],2),
					(String)vRendez.getMrp().getValueAt(selection[i],3));
			r.setDate_rendez(str);
			GestionRendez.update(r);
			vRendez.getMrp().setDate(str, selection[i]);
			r = null;
			System.gc();
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Selectionner une ligne !");
		}
	}
	
	
	public VueModifierRendezPr getvMRendez() {
		return vMRendez;
	}

	public void setvMRendez(VueModifierRendezPr vMRendez) {
		this.vMRendez = vMRendez;
	}

	public VueRendezPr getvRendez() {
		return vRendez;
	}

	public void setvRendez(VueRendezPr vRendez) {
		this.vRendez = vRendez;
	}
	
	
	public VueSetRendezPr getRendez() {
		return rendez;
	}

	public void setRendez(VueSetRendezPr rendez) {
		this.rendez = rendez;
	}	
	
	///************************FIN-Rendez-Vous*************************************//
	
	



	public void executeFirstWindow() {
		fw = new FirstWindow();
		fw.setVisible(true);
		
	}



	
	

	public FirstWindow getFw() {
		return fw;
	}

	public void setFw(FirstWindow fw) {
		this.fw = fw;
	}

	public ModelEtudiantPr getMep() {
		return mep;
	}

	public void setMep(ModelEtudiantPr mep) {
		this.mep = mep;
	}

	public ModelDocumentPr getMdp() {
		return mdp;
	}

	public void setMdp(ModelDocumentPr mdp) {
		this.mdp = mdp;
	}

	public ModelProjetPr getmProjet() {
		return mProjet;
	}

	public void setmProjet(ModelProjetPr mProjet) {
		this.mProjet = mProjet;
	}

	public ModelRapportPr getmRapport() {
		return mRapport;
	}

	public void setmRapport(ModelRapportPr mRapport) {
		this.mRapport = mRapport;
	}

	public ModelRendezPr getmRendez() {
		return mRendez;
	}

	public void setmRendez(ModelRendezPr mRendez) {
		this.mRendez = mRendez;
	}

	public ArrayList<Rendez> getTable4() {
		return table4;
	}

	public void setTable4(ArrayList<Rendez> table4) {
		this.table4 = table4;
	}

	public static Professeur getPr() {
		return pr;
	}

	public static void setPr(Professeur pr) {
		ControlleurOpenAUser.pr = pr;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public AjoutDocument getAjoutDocument() {
		return ajoutDocument;
	}

	public void setAjoutDocument(AjoutDocument ajoutDocument) {
		this.ajoutDocument = ajoutDocument;
	}

	public AjoutProjet getAjoutProjet() {
		return ajoutProjet;
	}

	public void setAjoutProjet(AjoutProjet ajoutProjet) {
		this.ajoutProjet = ajoutProjet;
	}

	public AjoutRapport getAjoutRapport() {
		return ajoutRapport;
	}

	public void setAjoutRapport(AjoutRapport ajoutRapport) {
		this.ajoutRapport = ajoutRapport;
	}

	public VueLoginPr getF0() {
		return f0;
	}

	public void setF0(VueLoginPr f0) {
		this.f0 = f0;
	}

	public VueMainProfesseurPr getF1() {
		return f1;
	}

	public void setF1(VueMainProfesseurPr f1) {
		this.f1 = f1;
	}

//	public VueEtudiant2 getF2() {
//		return f2;
//	}
//
//	public void setF2(VueEtudiant2 f2) {
//		this.f2 = f2;
//	}

	public ProfesseurAdministration getF3() {
		return f3;
	}

	public void setF3(ProfesseurAdministration f3) {
		this.f3 = f3;
	}

	public ModelLoginPr getModel() {
		return model;
	}

	public void setModel(ModelLoginPr model) {
		this.model = model;
	}

	
	public VueEtudiantPr getVep() {
		return vep;
	}

	public void setVep(VueEtudiantPr vep) {
		this.vep = vep;
	}

	
	public VueDocumentPr getVdp() {
		return vdp;
	}

	public void setVdp(VueDocumentPr vdp) {
		this.vdp = vdp;
	}

	public VueAjtDocumentPr getVadp() {
		return vadp;
	}

	public void setVadp(VueAjtDocumentPr vadp) {
		this.vadp = vadp;
	}
	

	public VueEtudiant2 getVue2() {
		return vue2;
	}


	public void setVue2(VueEtudiant2 vue2) {
		this.vue2 = vue2;
	}


	public ArrayList<Projet> getTable1() {
		return table1;
	}


	public void setTable1(ArrayList<Projet> table1) {
		this.table1 = table1;
	}


	public ArrayList<Document> getTable2() {
		return table2;
	}


	public void setTable2(ArrayList<Document> table2) {
		this.table2 = table2;
	}


	public ArrayList<Rapport> getTable3() {
		return table3;
	}


	public void setTable3(ArrayList<Rapport> table3) {
		this.table3 = table3;
	}


	public VueProjet getVue3() {
		return vue3;
	}


	public void setVue3(VueProjet vue3) {
		this.vue3 = vue3;
	}


	public VueDocument getVue4() {
		return vue4;
	}


	public void setVue4(VueDocument vue4) {
		this.vue4 = vue4;
	}


	public VueRapport getVue5() {
		return vue5;
	}


	public void setVue5(VueRapport vue5) {
		this.vue5 = vue5;
	}

}
