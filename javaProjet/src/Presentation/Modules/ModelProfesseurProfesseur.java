package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.POJO.Professeur;

public class ModelProfesseurProfesseur extends  AbstractTableModel{
	
	
private ArrayList<Professeur> list = new ArrayList<Professeur>();
	
	String [] titles = {"Code du professeur","Nom du professeur","Prenom du professeur","Grade du professeur","Email du professeur"};
	

	public ModelProfesseurProfesseur(ArrayList<Professeur> list) {
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
			return list.get(rowIndex).getCode_professeur();
		case 1 : 
			return list.get(rowIndex).getNom_professeur();
		case 2 : 
			return list.get(rowIndex).getPrenom_professeur();
		case 3 : 
			return list.get(rowIndex).getGrade_professeur();
		case 4 : 
			return list.get(rowIndex).getEmail_professeur();
		default: return null;
		}
	}
		
	
	public void setValueAt(String toSet,int i, int j)
	{
		switch(j) {
	case 0 : 
		this.list.get(i).setCode_professeur(toSet);
	case 1 : 
		this.list.get(i).setNom_professeur(toSet);
	case 2 : 
		this.list.get(i).setPrenom_professeur(toSet);
	case 3 : 
		this.list.get(i).setGrade_professeur(toSet);
	case 4 : 
		this.list.get(i).setEmail_professeur(toSet);
	default: return;
		}
	}
		
		public void addelement(Professeur p) {
			list.add(p);
			fireTableRowsDeleted(list.size(),list.size());
			
		}
		
		public void supprimer(int rowIndex ) {
			list.remove(rowIndex);
			fireTableRowsDeleted(rowIndex,rowIndex);
			
		}	
	
	
}
