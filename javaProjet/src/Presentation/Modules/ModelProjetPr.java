package Presentation.Modules;

import java.util.ArrayList;

import Metier.Gestion.GestionProjet;
import Metier.POJO.Projet;
import javax.swing.table.AbstractTableModel;

public class ModelProjetPr extends AbstractTableModel{
	
	private ArrayList<Projet> projets;
	private final String[] cols = {"ID","Code Prof","CNE","Type Projet","Sujet", "Progression", "Validation"};
	private String code;
	
	

	public ModelProjetPr(String code) {
		super();
		this.code = code;
		this.projets = GestionProjet.getListProjetPr(code);
	}

	@Override
	public int getRowCount() {
		return projets.size();
	}

	@Override
	public int getColumnCount() {
		
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0 : return projets.get(rowIndex).getId_projets();
		case 1 : return projets.get(rowIndex).getCode_professeur();
		case 2 : return projets.get(rowIndex).getCNE();
		case 3 : return projets.get(rowIndex).getType_projet();
		case 4 : return projets.get(rowIndex).getSujet();
		case 5 : return projets.get(rowIndex).getProgres();
		case 6 : return projets.get(rowIndex).getValider();
		default : return null;
		}
	}
	
	
	public void setValueAt(String toSet,int i, int j)
	{
		switch(j) {
	case 0 : 
		this.projets.get(i).setId_projets(toSet);
	case 1 : 
		this.projets.get(i).setCode_professeur(toSet);
	case 2 : 
		this.projets.get(i).setCNE(toSet);
	case 3 : 
		this.projets.get(i).setType_projet(toSet);
	case 4 : 
		this.projets.get(i).setSujet(toSet);
	case 5 : 
		this.projets.get(i).setProgres(toSet);
	case 6 : 
		this.projets.get(i).setValider(toSet);
	default: return;
		}
	}
		@Override
		public String getColumnName(int columnIndex) {
			
			if(columnIndex > 6) return null;
			else return cols[columnIndex];
		}
		
		@Override
		public Class getColumnClass(int columnIndex ) {
			return String.class;
		}
		
		public void setToValider(int rowIndex) {
			projets.get(rowIndex).setValider("Valider");
		}
		
		public void setProgression(String val, int rowIndex) {
			projets.get(rowIndex).setProgres(val);
		}
	

}
