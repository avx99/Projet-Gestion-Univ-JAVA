package Presentation.Modules;

import Metier.POJO.Professeur;

public class ModelMainProfesseurPr {
	
	private String nom;
	private String prenom;
	private String email;
	private String id;
	
	private String user;
	
	
	private Professeur p;

	public ModelMainProfesseurPr() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}
	
	
	
	
	
	
	
}
