package Metier.POJO;

public class Rapport {
	
	private String id_rapport;
	private String nom_rapport;
	private String CNE;
	private String code_professeur;
	private String valider;
	
	
	public Rapport(String id_rapport, String nom_rapport, String cNE,String code_professeur,String valider) {
		super();
		this.id_rapport = id_rapport;
		this.nom_rapport = nom_rapport;
		CNE = cNE;
		this.valider = valider;
		this.code_professeur = code_professeur;
	}


	public Rapport(String id_rapport, String nom_rapport, String valider) {
		super();
		this.id_rapport = id_rapport;
		this.nom_rapport = nom_rapport;
		this.valider = valider;
	}


	public String getId_rapport() {
		return id_rapport;
	}


	public void setId_rapport(String id_rapport) {
		this.id_rapport = id_rapport;
	}


	public String getNom_rapport() {
		return nom_rapport;
	}


	public void setNom_rapport(String nom_rapport) {
		this.nom_rapport = nom_rapport;
	}


	public String getCNE() {
		return CNE;
	}


	public void setCNE(String cNE) {
		CNE = cNE;
	}


	public String getValider() {
		return valider;
	}


	public void setValider(String valider) {
		this.valider = valider;
	}


	public String getCode_professeur() {
		return code_professeur;
	}


	public void setCode_professeur(String code_professeur) {
		this.code_professeur = code_professeur;
	}
	
	


}
