package Presentation.Modules;

import Metier.POJO.Professeur;

public class ModelAddProfesseur {
	
	private Professeur p;

	public Professeur getP() {
		return p;
	}

	public void setP(Professeur p) {
		this.p = p;
	}

	public ModelAddProfesseur(Professeur p) {
		super();
		this.p = p;
	}
	
	
	

}
