package Presentation.Modules;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Metier.Gestion.GestionRapport;
import Metier.POJO.Rapport;

public class ModelRapport extends AbstractTableModel {
	
private ArrayList<Rapport> rapports;
	
	public ModelRapport(ArrayList<Rapport> rapports) {
		super();
		this.rapports = rapports;
	}

	@Override
	public int getRowCount() {
		return rapports.size();
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Rapport a=rapports.get(rowIndex);
		switch(columnIndex) {
		case 0 : return a.getId_rapport();
		case 1 : return a.getNom_rapport();
		case 2 : return a.getValider();
		default : return null;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "ID Rapp";
		case 1 : return "Nom Rapp";
		case 2 : return "Validation";
		default : return null;
		}
	}
	
	@Override
	public Class getColumnClass(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		default : return Object.class;
		}
	}
	
	public void addRapport(Rapport e) {
		
		if(GestionRapport.insert(e)) {
			
			rapports.add(e);
			fireTableRowsInserted(0,0);
		}
		
		else JOptionPane.showMessageDialog(null, "Deja existe !!");
		
	}

	public void removeRapport(int rowIndex) {
		
		GestionRapport.delete(rapports.get(rowIndex));
		rapports.remove(rowIndex);
		fireTableRowsDeleted(rowIndex,rowIndex);
		
	}
	
	public void importer(int i, String Path) {
		
		GestionRapport.setFile(rapports.get(i).getId_rapport(), Path);
		
	}

	public void telecharger(int i, String Path) {
		
		GestionRapport.getFile(rapports.get(i).getId_rapport(), Path, rapports.get(i).getNom_rapport());
		
	}
	
	
	
}