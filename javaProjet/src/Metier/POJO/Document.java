package Metier.POJO;

public class Document{
	
	private String id_document;
	private String nom_document;
	private String CNE;
	private String id_projets;
	private String code_professeur;
	private String creer_par;
	
	
	
	public Document() {
		super();
	}





	public Document(String id_document, String nom_document, String cNE, String id_projets, String code_professeur,
			String creer_par) {
		super();
		this.id_document = id_document;
		this.nom_document = nom_document;
		CNE = cNE;
		this.id_projets = id_projets;
		this.code_professeur = code_professeur;
		this.creer_par = creer_par;
	}
	
	
	
	
	
	public Document(String id_document, String nom_document, String creer_par) {
		super();
		this.id_document = id_document;
		this.nom_document = nom_document;
		this.creer_par = creer_par;
	}





	public String getId_document() {
		return id_document;
	}
	public void setId_document(String id_document) {
		this.id_document = id_document;
	}
	public String getNom_document() {
		return nom_document;
	}
	public void setNom_document(String nom_document) {
		this.nom_document = nom_document;
	}
	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	public String getId_projets() {
		return id_projets;
	}
	public void setId_projets(String id_projets) {
		this.id_projets = id_projets;
	}
	public String getCode_professeur() {
		return code_professeur;
	}
	public void setCode_professeur(String code_professeur) {
		this.code_professeur = code_professeur;
	}
	public String getCreer_par() {
		return creer_par;
	}
	public void setCreer_par(String creer_par) {
		this.creer_par = creer_par;
	}
	
	
	
	
	
	
	
}

