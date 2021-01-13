package Metier.POJO;


public class Professeur {
	
	private String code_professeur;
	private String nom_professeur;
	public Professeur() {
		super();
	}


	private String prenom_professeur;
	private String grade_professeur;
	private String email_professeur;
	
	
	
	

	public Professeur(String code_professeur, String nom_professeur, String prenom_professeur, String grade_professeur,
			String email_professeur) {
		super();
		this.code_professeur = code_professeur;
		this.nom_professeur = nom_professeur;
		this.prenom_professeur = prenom_professeur;
		this.grade_professeur = grade_professeur;
		this.email_professeur = email_professeur;
	}


	public String getCode_professeur() {
		return code_professeur;
	}


	public void setCode_professeur(String code_professeur) {
		this.code_professeur = code_professeur;
	}


	public String getNom_professeur() {
		return nom_professeur;
	}


	public void setNom_professeur(String nom_professeur) {
		this.nom_professeur = nom_professeur;
	}


	public String getPrenom_professeur() {
		return prenom_professeur;
	}


	public void setPrenom_professeur(String prenom_professeur) {
		this.prenom_professeur = prenom_professeur;
	}


	public String getGrade_professeur() {
		return grade_professeur;
	}


	public void setGrade_professeur(String grade_professeur) {
		this.grade_professeur = grade_professeur;
	}


	public String getEmail_professeur() {
		return email_professeur;
	}


	public void setEmail_professeur(String email_professeur) {
		this.email_professeur = email_professeur;
	}
	
	
	
	
	
	
}
