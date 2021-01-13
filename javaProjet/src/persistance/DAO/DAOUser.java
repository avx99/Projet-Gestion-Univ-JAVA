package persistance.DAO;

import Metier.Gestion.GestionEtudiant;
import Metier.Gestion.GestionProfesseur;
import Metier.POJO.User;

public class DAOUser {
	
	public User userProfesseur(String password) 
	{
		return new User(GestionProfesseur.searchById(password).getNom_professeur(),GestionProfesseur.searchById(password).getCode_professeur());
	}
	
	public User userEtudiant(String password) 
	{
		return new User(GestionEtudiant.searchById(password).getNom_etudiant(),GestionEtudiant.searchById(password).getCNE());
	}
	
	public User userAdmin() 
	{
		return new User("admin","admin");
	}
	
}
