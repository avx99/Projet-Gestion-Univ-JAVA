package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.POJO.Projet;

public class ModelEtudiantProjet extends  AbstractTableModel{
	
	
private ArrayList<Projet> list = new ArrayList<Projet>();
	
	String [] titles = {"Id projet","Code du professeur","CNE d\'etudiant","Type de projet","Sujet","Progres","Valider?"};
	
	
	
	
	

	public ModelEtudiantProjet(ArrayList<Projet> list) {
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
			return list.get(rowIndex).getId_projets();
		case 1 : 
			return list.get(rowIndex).getCode_professeur();
		case 2 : 
			return list.get(rowIndex).getCNE();
		case 3 : 
			return list.get(rowIndex).getType_projet();
		case 4 : 
			return list.get(rowIndex).getSujet();
		case 5 : 
			return list.get(rowIndex).getProgres();
		case 6 : 
			return list.get(rowIndex).getValider();
		default: return null;
		}
	}
		
		
		public void addelement(Projet p) {
			list.add(p);
			fireTableRowsDeleted(list.size(),list.size());
			
		}
		
		public void supprimer(int rowIndex ) {
			list.remove(rowIndex);
			fireTableRowsDeleted(rowIndex,rowIndex);
			
		}	
	
	
}
