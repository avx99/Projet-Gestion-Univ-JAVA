//package Presentation.Controlleur;
//
//import java.util.ArrayList;
//
//import javax.swing.JOptionPane;
//
////import Presentation.Modules.ModelLoginEtudiant;
//import Presentation.Vues.AjoutDocument;
//import Presentation.Vues.AjoutProjet;
//import Presentation.Vues.AjoutRapport;
//import Presentation.Vues.VueDocument;
////import Presentation.Vues.VueEtudiant;
//import Presentation.Vues.VueEtudiant2;
//import Presentation.Vues.VueProjet;
//import Presentation.Vues.VueRapport;
//import Metier.Gestion.GestionDocument;
//import Metier.Gestion.GestionEtudiant;
//import Metier.Gestion.GestionProjet;
//import Metier.Gestion.GestionRapport;
//import Metier.Gestion.GestionRendez;
//import Metier.POJO.Document;
//import Metier.POJO.Etudiant;
//import Metier.POJO.Projet;
//import Metier.POJO.Rapport;
//import Metier.POJO.Rendez;
//
//public class ControlleurEspaceEtudiant {
//	
//	
////	private VueEtudiant vue1; //login
//	private VueEtudiant2 vue2; // principal
//	private VueProjet vue3;
//	private VueDocument vue4;
//	private VueRapport vue5;
//	
//	private AjoutDocument ajoutDocument;
//	private AjoutProjet ajoutProjet;
//	private AjoutRapport ajoutRapport;
//	
//	private Etudiant etudiant;
//	
//	private ArrayList<Projet> table1;
//	private ArrayList<Document> table2;
//	private ArrayList<Rapport> table3;
//	private ArrayList<Rendez> table4;
//	
//	
//	
//	public ControlleurEspaceEtudiant() {
//		
//		super();
//		
//	}
//
////
////	public VueEtudiant getVue1() {
////		return vue1;
////	}
////
////
////	public void setVue1(VueEtudiant vue1) {
////		this.vue1 = vue1;
////	}
//
//
//	public VueEtudiant2 getVue2() {
//		return vue2;
//	}
//
//
//	public void setVue2(VueEtudiant2 vue2) {
//		this.vue2 = vue2;
//	}
//
//
//	public ArrayList<Projet> getTable1() {
//		return table1;
//	}
//
//
//	public void setTable1(ArrayList<Projet> table1) {
//		this.table1 = table1;
//	}
//
//
//	public ArrayList<Document> getTable2() {
//		return table2;
//	}
//
//
//	public void setTable2(ArrayList<Document> table2) {
//		this.table2 = table2;
//	}
//
//
//	public ArrayList<Rapport> getTable3() {
//		return table3;
//	}
//
//
//	public void setTable3(ArrayList<Rapport> table3) {
//		this.table3 = table3;
//	}
//
//
//	public VueProjet getVue3() {
//		return vue3;
//	}
//
//
//	public void setVue3(VueProjet vue3) {
//		this.vue3 = vue3;
//	}
//
//
//	public VueDocument getVue4() {
//		return vue4;
//	}
//
//
//	public void setVue4(VueDocument vue4) {
//		this.vue4 = vue4;
//	}
//
//
//	public VueRapport getVue5() {
//		return vue5;
//	}
//
//
//	public void setVue5(VueRapport vue5) {
//		this.vue5 = vue5;
//	}
//
//
////	public void executeVueEtudiant2() {
////		ModelLoginEtudiant M = vue1.getModelLoginEtudiant();
////		if(GestionEtudiant.isExistEtudiant(M)) {
////			etudiant = GestionEtudiant.searchById(M.getPassword());
////			
////			table1 = GestionProjet.getProjetsEtudiant(M.getPassword());
////			table2 = GestionDocument.getDocumentsEtudiant(M.getPassword());
////			table3 = GestionRapport.getRapportsEtudiant(M.getPassword());
////			table4 = GestionRendez.getRendezEtudiant(M.getPassword());
////			
////			vue3 = new VueProjet(table1);
////			vue4 = new VueDocument(table2);
////			vue5 = new VueRapport(table3);
////			
////			vue2 = new VueEtudiant2();
////			vue2.setControlleur(this);
////			vue2.setEtudiant(etudiant);
////			vue2.setRendez(table4);
////			vue2.setVisible(true);
////			
////			vue1.dispose();
////		}
////		
////		else JOptionPane.showMessageDialog(null, "S'il vous plait V�rifier Nom et CNE");
////	}
//
//
//	public void executeProjets() {
//		
//		vue3.setControlleur(this);
//		vue3.setVisible(true);
//		vue2.dispose();
//		
//	}
//	
//	public void executeRapports() {
//		
//		vue5.setControlleur(this);
//		vue5.setVisible(true);
//		vue2.dispose();
//		
//	}
//	
//	public void executeDocuments() {
//		
//		vue4.setControlleur(this);
//		vue4.setVisible(true);
//		vue2.dispose();
//		
//	}
//
//
//	public void executeVueEtudiant2Document() {
//		
//		vue2.setVisible(true);
//		vue4.dispose();
//		
//	}
//	
//	public void executeVueEtudiant2Projet() {
//		
//		vue2.setVisible(true);
//		vue3.dispose();
//		
//	}
//	
//	public void executeVueEtudiant2Rapport() {
//		
//		vue2.setVisible(true);
//		vue5.dispose();
//		
//	}
//
//
//	public void executeAjoutDocument() {
//		
//		ajoutDocument = new AjoutDocument();
//		ajoutDocument.setControlleur(this);
//		ajoutDocument.setVisible(true);
//		
//	}
//
//
//	public void executeAjoutProjet() {
//		
//		ajoutProjet = new AjoutProjet();
//		ajoutProjet.setControlleur(this);
//		ajoutProjet.setVisible(true);
//		
//	}
//	
//	public void executeAjoutRapport() {
//		
//		ajoutRapport = new AjoutRapport();
//		ajoutRapport.setControlleur(this);
//		ajoutRapport.setVisible(true);
//		
//	}
//
//
//	public void executeProjetAjout() {
//		
//		Projet P = ajoutProjet.getProjet(etudiant.getCNE(), etudiant.getCode_professeur());
//		ajoutProjet.dispose();
//		vue3.setProjet(P);
//	}
//	
//	public void executeDocumentAjout() {
//		
//		Document P = ajoutDocument.getDocument(etudiant.getCNE(), etudiant.getCode_professeur());
//		ajoutDocument.dispose();
//		vue4.setDocument(P);
//	}
//	
//	public void executeRapportAjout() {
//		
//		Rapport P = ajoutRapport.getRapport(etudiant.getCNE(), etudiant.getCode_professeur());
//		ajoutRapport.dispose();
//		vue5.setRapport(P);
//	}
//		
//		
//}