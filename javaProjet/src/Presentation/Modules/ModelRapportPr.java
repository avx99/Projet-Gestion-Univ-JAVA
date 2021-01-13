package Presentation.Modules;

import java.util.ArrayList;

import Metier.Gestion.GestionRapport;
import Metier.POJO.Rapport;

import javax.swing.table.AbstractTableModel;

public class ModelRapportPr extends AbstractTableModel{
	
	private ArrayList<Rapport> rapports;
	private String code;
	private final String[] cols = {"ID","Nom rapport","CNE","Code_prof","Validation"};
	
	
	

	public ModelRapportPr(String code) {
		super();
		this.code = code;
		this.rapports = GestionRapport.getListRapportPr(code);
	}

	@Override
	public int getRowCount() {
		return rapports.size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0 : return rapports.get(rowIndex).getId_rapport();
		case 1 : return rapports.get(rowIndex).getNom_rapport();
		case 2 : return rapports.get(rowIndex).getCNE();
		case 3 : return rapports.get(rowIndex).getCode_professeur();
		case 4 : return rapports.get(rowIndex).getValider();
		default : return null;
		}
	}
	
		@Override
		public String getColumnName(int columnIndex) {
			
			if(columnIndex > 4) return null;
			else return cols[columnIndex];
		}
		
		@Override
		public Class getColumnClass(int columnIndex ) {
			return String.class;
		}
	
	
	public void setToValider(int rowIndex) {
		rapports.get(rowIndex).setValider("Valider");
	}

}
