package Metier.Gestion;

import java.util.ArrayList;

import Metier.POJO.Document;
import persistance.DAO.DAODocument;

public class GestionDocument {
	
	
	static DAODocument document = new DAODocument();
	


	public static boolean delete(Document table) {
		return document.delete(table);
	}
	
	public static boolean insert(Document table) {
		return document.insert(table);
	}
	
	public static boolean isExist(Document table) {
		return document.isExist(table);
	}

	public static Document searchById(String o) {
		return (Document) document.searchById(o);
	}

	public static ArrayList<Document> getAll() {
		return document.getAll();
	}

	public Boolean update(Document table) {
		return document.update(table);
	}
	
	
	public static ArrayList<Document> getListDocumentPr(String codeProf){
		ArrayList<Document> list1 = new ArrayList<Document>();
		ArrayList<Document> list2 = new ArrayList<Document>();
		list2 = document.getAll();
		int i=0;
		for(i=0; i<list2.size();i++) {
			String str = list2.get(i).getCode_professeur();
			if(codeProf.equals(str)) {
				list1.add(list2.get(i));
			}
		}

		return list1;
	}
	
	public static void setFile(String id, String path) {
		document.setFile(id, path);
	}
	
	public static void getFile(String id, String export, String fileName) {
		document.getFile(id, export, fileName);
	}
	
	

	
	public static ArrayList<Document> getDocumentsEtudiant(String CNE) {
		
		return document.getDocumentsEtudiant(CNE);
	}
	

	
	
	
}