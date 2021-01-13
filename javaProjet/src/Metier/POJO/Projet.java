package Metier.POJO;

public class Projet {
	
	private String id_projets;
	private String code_professeur;
	private String CNE;
	private String type_projet;
	private String sujet;
	private String progres;
	private String valider;
	









	public Projet() {
		super();
	}



	public String getSujet() {
		return sujet;
	}



	public void setSujet(String sujet) {
		this.sujet = sujet;
	}



	public Projet(String id_projets, String type_projet, String sujet, String progres, String valider) {
		super();
		this.id_projets = id_projets;
		this.type_projet = type_projet;
		this.progres = progres;
		this.sujet = sujet;
		this.valider = valider;
	}



	public Projet(String id_projets, String code_professeur, String cNE, String type_projet,String sujet, String progres,
			String valider) {
		super();
		this.id_projets = id_projets;
		this.sujet = sujet;
		this.code_professeur = code_professeur;
		CNE = cNE;
		this.type_projet = type_projet;
		this.progres = progres;
		this.valider = valider;
	}



	public String getCNE() {
		return CNE;
	}



	public void setCNE(String cNE) {
		CNE = cNE;
	}



	public String getCode_professeur() {
		return code_professeur;
	}



	public void setCode_professeur(String code_professeur) {
		this.code_professeur = code_professeur;
	}



	public String getProgres() {
		return progres;
	}



	public void setProgres(String progres) {
		this.progres = progres;
	}



	public String getValider() {
		return valider;
	}
	



	public void setValider(String valider) {
		this.valider = valider;
	}






	public String getId_projets() {
		return id_projets;
	}



	public void setId_projets(String id_projets) {
		this.id_projets = id_projets;
	}



	public String getType_projet() {
		return type_projet;
	}



	public void setType_projet(String type_projet) {
		this.type_projet = type_projet;
	}



	@Override
	public String toString() {
		return "Projet [id_projets=" + id_projets + ", code_professeur=" + code_professeur + ", CNE=" + CNE
				+ ", type_projet=" + type_projet + ", sujet=" + sujet + ", progres=" + progres + ", valider=" + valider
				+ "]";
	}



	
	
	

}
