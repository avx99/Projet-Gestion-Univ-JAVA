package Metier.Gestion;

import java.util.ArrayList;

import Metier.POJO.User;
import persistance.DAO.DAOUser;

public class GestionUser {
	
	private static  DAOUser daouser = new DAOUser();

	public GestionUser() {
		super();
		
	}

	
	public static boolean isProf(String userName, String password)
	{
		User u = new User();
		u = daouser.userProfesseur(password);
		if(u.getUserName() != null && u.getUserName().equals(userName) && u.getPassword() != null)
			return true;
		return false;
	}
	


	public static boolean isEtd(String userName, String password)
	{
		User u = daouser.userEtudiant(password);
		if(u.getUserName() != null && u.getUserName().equals(userName) && u.getPassword() != null)
			return true;
		return false;
	}
	
	
	
	public static boolean isAdmin(String userName, String password)
	{
		User u = daouser.userAdmin();
		if(u.getUserName().equals(userName) && u.getPassword().equals(password))
			return true;
		return false;
	}

	
	
}
