package Metier.POJO;

public class Rendez {
	
	private String id_rendez;
	private String date_rendez;
	private String code_professeur;
	private String CNE;
	
	
	public Rendez(String id_rendez, String date_rendez, String code_professeur, String cNE) {
		super();
		this.id_rendez = id_rendez;
		this.date_rendez = date_rendez;
		this.code_professeur = code_professeur;
		this.CNE = cNE;
	}
	public Rendez(String id_rendez, String date_rendez) {
		super();
		this.id_rendez = id_rendez;
		this.date_rendez = date_rendez;
	}
	public String getId_rendez() {
		return id_rendez;
	}
	public void setId_rendez(String id_rendez) {
		this.id_rendez = id_rendez;
	}
	public String getDate_rendez() {
		return date_rendez;
	}
	public void setDate_rendez(String date_rendez) {
		this.date_rendez = date_rendez;
	}
	public String getCode_professeur() {
		return code_professeur;
	}
	public void setCode_professeur(String code_professeur) {
		this.code_professeur = code_professeur;
	}
	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	
	
	
	
	
	
	
	

}
