package Metier.Gestion;

import java.util.ArrayList;

import Metier.POJO.Etudiant;
import persistance.DAO.DAOEtudiant;

public class GestionEtudiant {
	static DAOEtudiant etudiant = new DAOEtudiant();


	public static boolean delete(Etudiant table) {
		return etudiant.delete(table);
	}
	
	public static boolean insert(Etudiant table)
	{
		return etudiant.insert(table);
	}

	public static boolean isExist(Etudiant table) {
		return etudiant.isExist(table);
	}

	public static Etudiant searchById(String o) {
		return (Etudiant) etudiant.searchById(o);
	}

	public static ArrayList<Etudiant> getAll() {
		return etudiant.getAll();
	}

	public static Boolean update(Etudiant table) {
		return etudiant.update(table);
	}
	
	public static ArrayList<Etudiant> getListEtudiantPr(String codeprof){
		ArrayList<Etudiant> list1 = new ArrayList<Etudiant>();
		ArrayList<Etudiant> list2 = new ArrayList<Etudiant>();

		list2 = etudiant.getAll();
		
		int i=0;
		for(i=0; i<list2.size();i++) {
			String str = list2.get(i).getCode_professeur();
			if(codeprof.equals(str)) {
				list1.add(list2.get(i));
			}
		}
		
		return list1;
	}
	
	public static boolean chercher(String id, ArrayList<Etudiant> etds) {
		int i=0;
		for(i= 0;i<etds.size();i++) {
			if(id.equals(etds.get(i).getCNE())) {
				return true;
			}
		}
		
		return false;
	}
}