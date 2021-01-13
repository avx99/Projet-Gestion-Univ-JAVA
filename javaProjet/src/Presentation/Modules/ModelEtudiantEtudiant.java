package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.POJO.Etudiant;

public class ModelEtudiantEtudiant extends  AbstractTableModel{
	
	
private ArrayList<Etudiant> list = new ArrayList<Etudiant>();
	
	String [] titles = {"CNE","Code du professeur","Nom d\'etudiant","Prenom d\'etudiant","Email d\'etudiant","Anne"};
	

	public ModelEtudiantEtudiant(ArrayList<Etudiant> list) {
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
			return list.get(rowIndex).getCNE();
		case 1 : 
			return list.get(rowIndex).getCode_professeur();
		case 2 : 
			return list.get(rowIndex).getNom_etudiant();
		case 3 : 
			return list.get(rowIndex).getPrenom_etudiant();
		case 4 : 
			return list.get(rowIndex).getEmail_etudiant();
		case 5 : 
			return list.get(rowIndex).getAnne();
		default: return null;
		}
	}
		
		
		public void addelement(Etudiant e) {
			list.add(e);
			fireTableRowsDeleted(list.size(),list.size());
			
		}
		
		public void supprimer(int rowIndex ) {
			list.remove(rowIndex);
			fireTableRowsDeleted(rowIndex,rowIndex);
			
		}	
		
		
		public void setValueAt(String toSet,int i, int j)
		{
			switch(j) {
			case 0 : 
				this.list.get(i).setCNE(toSet);
			case 1 : 
				this.list.get(i).setCode_professeur(toSet);
			case 2 : 
				this.list.get(i).setNom_etudiant(toSet);
			case 3 : 
				this.list.get(i).setPrenom_etudiant(toSet);
			case 4 : 
				this.list.get(i).setEmail_etudiant(toSet);
			case 5 : 
				this.list.get(i).setAnne(toSet);
			default: return;
			}
		}
	
	
}
