package Presentation.Modules;



import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Metier.Gestion.GestionDocument;
import Metier.Gestion.GestionProjet;
import Metier.POJO.Projet;

public class ModelProjet extends AbstractTableModel {
	
	private ArrayList<Projet> projets;
	
	public ModelProjet(ArrayList<Projet> projets) {
		super();
		this.projets = projets;
	}

	@Override
	public int getRowCount() {
		return projets.size();
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Projet a=projets.get(rowIndex);
		switch(columnIndex) {
		case 0 : return a.getId_projets();
		case 1 : return a.getType_projet();
		case 2 : return a.getSujet();
		case 3 : return a.getProgres();
		case 4 : return a.getValider();
		default : return null;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "ID Projet";
		case 1 : return "Type";
		case 2 : return "Sujet";
		case 3 : return "L'Avancement";
		case 4 : return "Validation";
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
		case 4 : return String.class;
		default : return Object.class;
		}
	}
	
	public void addProjet(Projet e) {
		
		if(GestionProjet.insert(e)) {
			
			projets.add(e);
			fireTableRowsInserted(0,0);
		}
		
		else JOptionPane.showMessageDialog(null, "Deja existe !!");
	}
	
	public void importer(int i, String Path) {
		
		GestionProjet.setFile(projets.get(i).getId_projets(), Path);
		
	}
	
	public void telecharger(int i, String Path) {
		
		GestionProjet.getFile(projets.get(i).getId_projets(), Path, projets.get(i).getSujet());
		
	}
	

}
