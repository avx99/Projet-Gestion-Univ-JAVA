package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Metier.Gestion.GestionRendez;
import Metier.POJO.Rendez;

public class ModelRendezPr extends AbstractTableModel{
	
	
	private ArrayList<Rendez> rendez = new ArrayList<Rendez>();
	private String code;
	private final String[] cols = {"ID","Date","Professeur","Etudiant"};
	
	
	
	
	public ModelRendezPr(String code) {
		super();
		this.code = code;
		this.rendez = GestionRendez.getListRendezPr(code);
	}

	@Override
	public int getRowCount() {
		return rendez.size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0 : return rendez.get(rowIndex).getId_rendez();
		case 1 : return rendez.get(rowIndex).getDate_rendez();
		case 2 : return rendez.get(rowIndex).getCode_professeur();
		case 3 : return rendez.get(rowIndex).getCNE();
		default : return null;
		}
	}
	
	public void setValueAt(String elt, int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0 : rendez.get(rowIndex).setId_rendez(elt);
		case 1 : rendez.get(rowIndex).setDate_rendez(elt);
		case 2 : rendez.get(rowIndex).setCode_professeur(elt);
		case 3 : rendez.get(rowIndex).setCNE(elt);
		}
	}
	
		@Override
		public String getColumnName(int columnIndex) {
			
			if(columnIndex > 3) return null;
			else return cols[columnIndex];
		}
		
		@Override
		public Class getColumnClass(int columnIndex ) {
			return String.class;
		}
	
		
		public void addRendezPr(Rendez r) {
			if(GestionRendez.insert(r)) {
				rendez.add(r);
				fireTableRowsInserted(0,0);
			}else {
				JOptionPane.showMessageDialog(null, "Deja Existe !");
			}
		}
		
		public void deleteRendez(int rowIndex) {
				rendez.remove(rowIndex);
				fireTableRowsInserted(0,0);
		}

		public void setDate(String elt, int rowIndex) {
			rendez.get(rowIndex).setDate_rendez(elt);
			System.out.println(rendez.get(rowIndex).getDate_rendez());
		}

}
