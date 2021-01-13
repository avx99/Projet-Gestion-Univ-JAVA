package Metier.Gestion;

import java.util.ArrayList;

import Metier.POJO.Rendez;
import Metier.POJO.Rapport;
import Metier.POJO.Rendez;
import persistance.DAO.DAORendez;

public class GestionRendez {
	static DAORendez rendez = new DAORendez();
	


	public static boolean delete(Rendez table) {
		return rendez.delete(table);
	}
	
	public static boolean insert(Rendez table) {
		return rendez.insert(table);
	}

	public static boolean isExist(Rendez table) {
		return rendez.isExist(table);
	}

	public static Rapport searchById(String o) {
		return (Rapport) rendez.searchById(o);
	}

	public static ArrayList<Rendez> getAll() {
		return rendez.getAll();
	}

	public static Boolean update(Rendez table) {
		return rendez.update(table);
	}
	
	public static ArrayList<Rendez> getListRendezPr(String codeprof){
		ArrayList<Rendez> list1 = new ArrayList<Rendez>();
		ArrayList<Rendez> list2 = new ArrayList<Rendez>();

		list2 = rendez.getAll();
		
		int i=0;
		for(i=0; i<list2.size();i++) {
			String str = list2.get(i).getCode_professeur();
			if(codeprof.equals(str)) {
				list1.add(list2.get(i));
			}
		}
		
		return list1;
	}
	
	
	public static ArrayList<Rendez> getRendezEtudiant(String CNE) {
		return rendez.getRendezEtudiant(CNE);
	}

}
