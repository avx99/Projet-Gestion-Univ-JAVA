package Metier.POJO;


public class Etudiant {
	
	private String CNE;
	private String code_professeur;
	private String nom_etudiant;
	private String prenom_etudiant;
	private String email_etudiant;
	private String anne;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Etudiant [CNE=" + CNE + ", code_professeur=" + code_professeur + ", nom_etudiant=" + nom_etudiant
				+ ", prenom_etudiant=" + prenom_etudiant + ", email_etudiant=" + email_etudiant + ", anne=" + anne
				+ "]";
	}
	public Etudiant() {
		super();
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

	public String getNom_etudiant() {
		return nom_etudiant;
	}
	public void setNom_etudiant(String nom_etudiant) {
		this.nom_etudiant = nom_etudiant;
	}
	public String getPrenom_etudiant() {
		return prenom_etudiant;
	}
	public void setPrenom_etudiant(String prenom_etudiant) {
		this.prenom_etudiant = prenom_etudiant;
	}
	public String getEmail_etudiant() {
		return email_etudiant;
	}
	public void setEmail_etudiant(String email_etudiant) {
		this.email_etudiant = email_etudiant;
	}
	public String getAnne() {
		return anne;
	}
	public void setAnne(String anne) {
		this.anne = anne;
	}
	public Etudiant(String cNE, String code_professeur, String nom_etudiant, String prenom_etudiant,
			String email_etudiant, String anne) {
		super();
		CNE = cNE;
		this.code_professeur = code_professeur;
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.email_etudiant = email_etudiant;
		this.anne = anne;
	}
	public Etudiant(String cNE, String nom_etudiant, String prenom_etudiant, String email_etudiant, String anne) {
		super();
		CNE = cNE;
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.email_etudiant = email_etudiant;
		this.anne = anne;
	}
	
	
	
	
	

}
