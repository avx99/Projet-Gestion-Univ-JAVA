package Metier.Gestion;

import java.util.ArrayList;

import Metier.POJO.Projet;
import Metier.POJO.Projet;
import persistance.DAO.DAOProjet;

public class GestionProjet {
	static DAOProjet projet = new DAOProjet();
	

	public static boolean delete(Projet table) {
		return projet.delete(table);
	}
	
	public static boolean insert(Projet table) {
		return projet.insert(table);
	}

	public static boolean isExist(Projet table) {
		return projet.isExist(table);
	}

	public static Projet searchById(String o) {
		return (Projet) projet.searchById(o);
	}

	public static ArrayList<Projet> getAll() {
		return projet.getAll();
	}

	public static boolean update(Projet table) {
		return projet.update(table);
	}

	public static ArrayList<Projet> getListProjetPr(String codeprof){
		ArrayList<Projet> list1 = new ArrayList<Projet>();
		ArrayList<Projet> list2 = new ArrayList<Projet>();

		list2 = projet.getAll();
		
		int i=0;
		for(i=0; i<list2.size();i++) {
			String str = list2.get(i).getCode_professeur();
			if(codeprof.equals(str)) {
				list1.add(list2.get(i));
			}
		}
		
		return list1;
	}

	
	
	public static boolean chercher(String id,ArrayList<Projet> projets) {
		int i=0;
		for(i= 0;i<projets.size();i++) {
			if(id.equals(projets.get(i).getId_projets())) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public static ArrayList<Projet> getProjetsEtudiant(String CNE) {
		return projet.getProjetsEtudiant(CNE);
	}
	
	public static void setFile(String id_projets, String path) {
		
		projet.setFile(id_projets, path);
		
	}

	public static void getFile(String id_projets, String path, String sujet) {
		projet.getFile(id_projets, path, sujet);
	}
	
}
