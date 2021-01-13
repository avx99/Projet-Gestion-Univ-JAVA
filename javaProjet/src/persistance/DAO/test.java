package persistance.DAO;

import java.util.ArrayList;

import Metier.POJO.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Professeur p = new Professeur("prof1","ahmed","alami","PA","ahmed@gmail.com");
		DAOProfesseur dp = new DAOProfesseur();
		dp.insert(p);
		
		ArrayList<Professeur> l = new ArrayList<>();

		DAOProfesseur d5p = new DAOProfesseur();
		l = d5p.getAll();
		System.out.println(l.get(1).getCode_professeur());
		
		
		
		DAODocument dd = new DAODocument();
		Document d = new Document("doc1","pdf java","R1","projet1","prof1","professeur");
		Document ddd = new Document();
				
		
	
		
		
		
		
	Etudiant e = new Etudiant("R1","prof1","oussxxxxxxxxxama","abouzid","oussamaa@Aaa","4eme");
		DAOEtudiant de = new DAOEtudiant();

		de.insert(e);
		
	}

}
