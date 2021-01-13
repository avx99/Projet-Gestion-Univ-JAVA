package Metier.Gestion;

import java.util.ArrayList;

import Metier.POJO.Rapport;
import Metier.POJO.Rapport;
import persistance.DAO.DAORapport;

public class GestionRapport {

	static DAORapport rapport = new DAORapport();
	

	public static boolean delete(Rapport table) {
		return rapport.delete(table);
	}
	
	public static boolean insert(Rapport table) {
		return rapport.insert(table);
	}

	public static boolean isExist(Rapport table) {
		return rapport.isExist(table);
	}

	public static Rapport searchById(String o) {
		return (Rapport) rapport.searchById(o);
	}

	public static ArrayList<Rapport> getAll() {
		return rapport.getAll();
	}

	public static boolean update(Rapport table) {
		return rapport.update(table);
	}
	
	public static ArrayList<Rapport> getListRapportPr(String codeprof){
		ArrayList<Rapport> list1 = new ArrayList<Rapport>();
		ArrayList<Rapport> list2 = new ArrayList<Rapport>();

		list2 = rapport.getAll();
		
		int i=0;
		for(i=0; i<list2.size();i++) {
			String str = list2.get(i).getCode_professeur();
			if(codeprof.equals(str)) {
				list1.add(list2.get(i));
			}
		}
		
		return list1;
	}
	
	
	public static ArrayList<Rapport> getRapportsEtudiant(String CNE) {
		return rapport.getRapportsEtudiant(CNE);
	}

	public static void setFile(String id_rapport, String path) {
		rapport.setFile(id_rapport, path);
	}

	public static void getFile(String id_rapport, String path, String nom_rapport) {
		rapport.getFile(id_rapport, path, nom_rapport);
	}


}

