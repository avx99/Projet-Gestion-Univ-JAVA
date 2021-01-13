package Presentation.Controlleur;

import Presentation.Modules.ModelFirstWindow;
import Presentation.Modules.ModelLoginPr;
import Presentation.Vues.FirstWindow;
import Presentation.Vues.VueLoginPr;

public class ControlleurFirstWindow {

	
	private FirstWindow f1;
	private VueLoginPr f2;
	private ModelFirstWindow m1;
	private ModelLoginPr m2;
	
	
	public ControlleurFirstWindow() {
		super();

		
	}

	
	public void executeLogin()
	{
		m1 = f1.getModel();
		m2 = new ModelLoginPr();
		f2 = new VueLoginPr();
		m2.setUser(m1.getUser());
		f2.setModel(m2);
		f1.dispose();
		f2.setVisible(true);
	}
	
	

	public FirstWindow getF1() {
		return f1;
	}


	public void setF1(FirstWindow f1) {
		this.f1 = f1;
	}


	public VueLoginPr getF2() {
		return f2;
	}


	public void setF2(VueLoginPr f2) {
		this.f2 = f2;
	}


	public ModelFirstWindow getM1() {
		return m1;
	}


	public void setM1(ModelFirstWindow m1) {
		this.m1 = m1;
	}


	public ModelLoginPr getM2() {
		return m2;
	}


	public void setM2(ModelLoginPr m2) {
		this.m2 = m2;
	}
	

}
