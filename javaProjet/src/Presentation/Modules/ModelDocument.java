package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Metier.Gestion.GestionDocument;
import Metier.Gestion.GestionProjet;
import Metier.POJO.Document;
import Metier.POJO.Projet;



public class ModelDocument extends AbstractTableModel {
	
	private ArrayList<Document> documents;
	
	public ModelDocument(ArrayList<Document> documents) {
		super();
		this.documents = documents;
	}

	@Override
	public int getRowCount() {
		return documents.size();
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Document a=documents.get(rowIndex);
		switch(columnIndex) {
		case 0 : return a.getId_document();
		case 1 : return a.getNom_document();
		case 2 : return a.getCreer_par();
		case 3 : return a.getId_projets();
		default : return null;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "ID Document";
		case 1 : return "Nom Document";
		case 2 : return "Par";
		case 3 : return "ID Projet";
		default : return null;
		}
	}
	
	@Override
	public Class getColumnClass(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		default : return Object.class;
		}
	}
	
	public void addDocument(Document e) {
		
		Projet p = new Projet();
		p = GestionProjet.searchById(e.getId_projets());
		
		if(p.getId_projets() != null)
		{
			if(GestionDocument.insert(e)) {
				
				documents.add(e);
				fireTableRowsInserted(0,0);
			}
			else JOptionPane.showMessageDialog(null, "Deja existe !!");
		}
		else
			JOptionPane.showMessageDialog(null, "Le id de ce projet n\'existe pas !");
		
	}

	public void removeDocument(int rowIndex) {
		
		GestionDocument.delete(documents.get(rowIndex));
		documents.remove(rowIndex);
		fireTableRowsDeleted(rowIndex,rowIndex);
		
	}

	public void importer(int i,String Path) {
		
		GestionDocument.setFile(documents.get(i).getId_document(), Path);
		
	}
	
	public void telecharger(int i, String Path) {
		
		GestionDocument.getFile(documents.get(i).getId_document(), Path, documents.get(i).getNom_document());
		
	}

	
	
}
