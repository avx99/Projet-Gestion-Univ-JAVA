package Metier.Gestion;

import java.util.ArrayList;

import Metier.POJO.Etudiant;
import Metier.POJO.Professeur;
import persistance.DAO.DAOProfesseur;

public class GestionProfesseur {
	static DAOProfesseur Professeur = new DAOProfesseur();
	


	public static boolean delete(Professeur table) {
		return Professeur.delete(table);
	}
	
	public static boolean insert(Professeur table) {
		return Professeur.insert(table);
	}

	public static boolean isExist(Professeur table) {
		return Professeur.isExist(table);
	}
	
	public static Professeur searchById(String o) {
		return (Metier.POJO.Professeur) Professeur.searchById(o);
	}

	public static ArrayList<Professeur> getAll() {
		return Professeur.getAll();
	}

	public static Boolean update(Professeur table) {
		return Professeur.update(table);
	}
	


}
