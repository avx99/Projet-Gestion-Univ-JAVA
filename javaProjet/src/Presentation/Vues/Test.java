package Presentation.Vues;
import Metier.Gestion.*;
import Presentation.Controlleur.ControleurLoginProf;
import Presentation.Modules.*;

public class Test {

public static void main(String[] args) {
	
		
		FirstWindow ff = new FirstWindow();
		ff.setVisible(true);
		
		//System.out.println(ff.getModel().getUser());
		
		ControleurLoginProf clp = new ControleurLoginProf();
		
		//System.out.println(clp.recuperecode());
		
		
		//ModelEtudiantPr mm = new ModelEtudiantPr("prof1");
		//System.out.println(mm.getEtds());
	}
	
}
