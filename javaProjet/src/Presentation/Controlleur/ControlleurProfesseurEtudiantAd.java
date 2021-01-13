package Presentation.Controlleur;

import Presentation.Vues.EtudiantAdministration;
import Presentation.Vues.ProfesseurAdministration;

public class ControlleurProfesseurEtudiantAd {
	
	private ProfesseurAdministration prof;
	private EtudiantAdministration etd;
	
	public ControlleurProfesseurEtudiantAd(ProfesseurAdministration prof, EtudiantAdministration etd) {
		super();
		this.prof = prof;
		this.etd = etd;
	}
	
	
	public ControlleurProfesseurEtudiantAd() {
		
	}
	
	
	
	public ControlleurProfesseurEtudiantAd(ProfesseurAdministration prof) {
		super();
		this.prof = prof;
	}



	public ControlleurProfesseurEtudiantAd(EtudiantAdministration etd) {
		super();
		this.etd = etd;
	}


	public void executeProf()
	{
		prof = new ProfesseurAdministration();
		prof.setVisible(true);
		etd.dispose();
	}
	
	public void executeEtd()
	{
		etd = new EtudiantAdministration();
		etd.setVisible(true);
		prof.dispose();
	}
	
	

	public ProfesseurAdministration getProf() {
		return prof;
	}

	public void setProf(ProfesseurAdministration prof) {
		this.prof = prof;
	}

	public EtudiantAdministration getEtd() {
		return etd;
	}

	public void setEtd(EtudiantAdministration etd) {
		this.etd = etd;
	}

	
	
}
