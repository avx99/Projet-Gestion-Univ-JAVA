package Presentation.Controlleur;

import java.util.ArrayList;

import javax.swing.JLabel;

import Metier.Gestion.GestionProfesseur;
import Metier.POJO.Professeur;
import Presentation.Modules.ModelLoginPr;
import Presentation.Modules.ModelMainProfesseurPr;
import Presentation.Vues.VueLoginPr;

import Presentation.Vues.VueMainProfesseurPr;
public class ControleurLoginProf {

	private VueLoginPr ml;
	private VueMainProfesseurPr mp;
	private ArrayList<Professeur> list;
	private ModelLoginPr mm1;
	private ModelMainProfesseurPr mm2;
	private Professeur pr;
	
	private ModelLoginPr mlp ;
	
	
	
	public ControleurLoginProf(VueLoginPr ml, VueMainProfesseurPr mp) {
		super();
		this.ml = ml;
		this.mp = mp;
	}
	
	
	
	
	public ControleurLoginProf() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public ControleurLoginProf(VueLoginPr ml) {
		super();
		this.ml = ml;
	}

	public ControleurLoginProf(VueMainProfesseurPr mp) {
		super();
		this.mp = mp;
	}

	
	


	public void executeProf() {
		mp = new VueMainProfesseurPr();
		mm2.setUser(mm1.getUser());
		//mp.setTextid(new JLabel("helooo"));
		mp.setVisible(true);
		
	}
	
	public void executeLogin() {
		
		ml = new VueLoginPr();
		ml.setVisible(true);
	}

	
	/*public boolean verifierLogin(String nom, String pass) {
		list = new ArrayList<Professeur>();
		list = GestionProfesseur.getAll();
		
		if(GestionProfesseur.searchById(pass) != null) {
			if(nom.equals(GestionProfesseur.searchById(pass).getNom_professeur())) {
				return true;	
			}
		}	
		return false;
	}
	*/
	public String recuperecode() {
		mlp = new ModelLoginPr();
		String id = mlp.getPassword();
		return id;
	}
	
	
	
	
	/*public String recupnom() {
		pr = GestionProfesseur.searchById(this.recuperecode());
		return pr.getNom_professeur();
	}
	
	public String recupprenom() {
		pr = GestionProfesseur.searchById(this.recuperecode());
		return pr.getPrenom_professeur();
	}
	public String recupemail() {
		pr = GestionProfesseur.searchById(this.recuperecode());
		return pr.getEmail_professeur();
	}
	public String recupid() {
		pr = GestionProfesseur.searchById(this.recuperecode());
		return pr.getCode_professeur();
	}
*/
	
	
	public VueLoginPr getMl() {
		return ml;
	}

	public void setMl(VueLoginPr ml) {
		this.ml = ml;
	}

	public VueMainProfesseurPr getMp() {
		return mp;
	}


	public void setMp(VueMainProfesseurPr mp) {
		this.mp = mp;
	}

	public ArrayList<Professeur> getList() {
		return list;
	}

	public void setList(ArrayList<Professeur> list) {
		this.list = list;
	}


	public Professeur getPr() {
		return pr;
	}


	public void setPr(Professeur pr) {
		this.pr = pr;
	}


	public ModelLoginPr getMlp() {
		return mlp;
	}

	public void setMlp(ModelLoginPr mlp) {
		this.mlp = mlp;
	}
	
}
