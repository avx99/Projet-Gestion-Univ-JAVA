package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.POJO.Rapport;

public class ModelEtudiantRapport extends  AbstractTableModel{
	
	
private ArrayList<Rapport> list = new ArrayList<Rapport>();
	
	String [] titles = {"Id Rapport","Nom du rapport","CNE d\'etudiant","Code du professeur","Valider?"};
	


	
	
	public ModelEtudiantRapport(ArrayList<Rapport> list, String[] titles) {
		super();
		this.list = list;
		this.titles = titles;
	}





	public ModelEtudiantRapport(ArrayList<Rapport> list) {
		super();
		this.list = list;
	}





	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titles.length;
	}
	@Override
	public String getColumnName(int columnIndex ) {
		
		return titles[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		
		case 0 : 
			return list.get(rowIndex).getId_rapport();
		case 1 : 
			return list.get(rowIndex).getNom_rapport();
		case 2 : 
			return list.get(rowIndex).getCNE();
		case 3 : 
			return list.get(rowIndex).getCode_professeur();
		case 4 : 
			return list.get(rowIndex).getValider();
		default: return null;
		}
	}
		
		
		public void addelement(Rapport r) {
			list.add(r);
			fireTableRowsDeleted(list.size(),list.size());
			
		}
		
		public void supprimer(int rowIndex ) {
			list.remove(rowIndex);
			fireTableRowsDeleted(rowIndex,rowIndex);
			
		}	
	
	
}
