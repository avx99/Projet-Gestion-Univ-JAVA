package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Metier.Gestion.GestionDocument;
import Metier.POJO.Document;

public class ModelDocumentPr extends AbstractTableModel{
	
	private ArrayList<Document> docs;
	private String code;
	private final String[] cols = {"ID","Nom document","CNE", "Id_Projet","Code_prof", "Creer Par"};
	
	public ModelDocumentPr(String code) {
		super();
		this.code = code;
		this.docs = GestionDocument.getListDocumentPr(code);
	}

	@Override
	public int getRowCount() {
		
		return docs.size();
	}

	@Override
	public int getColumnCount() {
		
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch(columnIndex) {
		case 0 : return docs.get(rowIndex).getId_document();
		case 1 : return docs.get(rowIndex).getNom_document();
		case 2 : return docs.get(rowIndex).getCNE();
		case 3 : return docs.get(rowIndex).getId_projets();
		case 4 : return docs.get(rowIndex).getCode_professeur();
		case 5 : return docs.get(rowIndex).getCreer_par();
		default: return null;
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
	
	
	public void addDocumentPr(Document d) {
		if(GestionDocument.insert(d)) {
			docs.add(d);
			fireTableRowsInserted(0,0);
		}else {
			JOptionPane.showMessageDialog(null, "Deja existe !");
		}
	}
	
	public void deleteDocument(int rowIndex) {
		
			docs.remove(rowIndex);
			fireTableRowsInserted(0,0);
		
	}
	


}
