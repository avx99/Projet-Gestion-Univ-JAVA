package Presentation.Controlleur;

import Presentation.Modules.ModelDocumentPr;
import Presentation.Vues.VueAjtDocumentPr;
import Presentation.Vues.VueDocumentPr;

public class ControleurTablePr {
	
	private VueDocumentPr vuedoc;
	private VueAjtDocumentPr vueAjouterDoc;
	private ModelDocumentPr modeldoc;

	
	public void executeAjouterDoc() {
		vueAjouterDoc = new VueAjtDocumentPr();
		vueAjouterDoc.setVisible(true);
	}


	public void executeValider() {
		
	}
	
	public VueDocumentPr getVuedoc() {
		return vuedoc;
	}


	public void setVuedoc(VueDocumentPr vuedoc) {
		this.vuedoc = vuedoc;
	}
	
	
}