package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.POJO.Document;

public class ModelProfesseurDocument extends  AbstractTableModel{
	
	
private ArrayList<Document> list = new ArrayList<Document>();
	
	String [] titles = {"Id document","Nom du document","CNE d\'etudiant","Id projet","Code du professeur","Creer par"};
	

	public ModelProfesseurDocument(ArrayList<Document> list) {
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
			return list.get(rowIndex).getId_document();
		case 1 : 
			return list.get(rowIndex).getNom_document();
		case 2 : 
			return list.get(rowIndex).getCNE();
		case 3 : 
			return list.get(rowIndex).getId_projets();
		case 4 : 
			return list.get(rowIndex).getCode_professeur();
		case 5 : 
			return list.get(rowIndex).getCreer_par();
		default: return null;
		}
	}
		
		
		public void addelement(Document d) {
			list.add(d);
			fireTableRowsDeleted(list.size(),list.size());
			
		}
		
		public void supprimer(int rowIndex ) {
			list.remove(rowIndex);
			fireTableRowsDeleted(rowIndex,rowIndex);
			
		}	
	
	
}
