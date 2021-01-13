package Presentation.Modules;

import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;

import Metier.Gestion.GestionEtudiant;
import Metier.POJO.Etudiant;

public class ModelEtudiantPr extends AbstractTableModel{
	
	private ArrayList<Etudiant> etds = new ArrayList<Etudiant>();
	private String code;
	private final String[] cols = {"CNE","Encadrant","Nom","Prenom","Email","Annee"};
	

	public ModelEtudiantPr(String code) {
		super();
		this.code = code;
		this.etds = GestionEtudiant.getListEtudiantPr(code);
	}
	

	@Override
	public int getRowCount() {
		return etds.size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0 : return etds.get(rowIndex).getCNE();
		case 1 : return etds.get(rowIndex).getCode_professeur();
		case 2 : return etds.get(rowIndex).getNom_etudiant();
		case 3 : return etds.get(rowIndex).getPrenom_etudiant();
		case 4 : return etds.get(rowIndex).getEmail_etudiant();
		case 5 : return etds.get(rowIndex).getAnne();
		default : return null;
		}
	}
	
		@Override
		public String getColumnName(int columnIndex) {
			
			if(columnIndex > 5) return null;
			else return cols[columnIndex];		}
		
		@Override
		public Class getColumnClass(int columnIndex ) {
			return String.class;
		}
	
		
		public void addelement(Etudiant e) {
			etds.add(e);
			fireTableRowsDeleted(etds.size(),etds.size());
			
		}
		
		public void supprimer(int rowIndex ) {
			etds.remove(rowIndex);
			fireTableRowsDeleted(rowIndex,rowIndex);
			
		}


		public ArrayList<Etudiant> getEtds() {
			return etds;
		}


		public void setEtds(ArrayList<Etudiant> etds) {
			this.etds = etds;
		}


		public String getCode() {
			return code;
		}


		public void setCode(String code) {
			this.code = code;
		}	
		
		
		

}
