package persistance.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.POJO.Etudiant;
import Metier.POJO.Professeur;



public class DAOEtudiant implements DAOInterface<Etudiant>{
	
	

	public DAOEtudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public boolean isExist(Etudiant etd) {
			
			boolean b = true;
			
			ConnectionBD c = ConnectionBD.getcnx();
			Connection con = c.openConnection();
			
			try {
				
				Statement stm = con.createStatement();
				ResultSet r = null;
				String exist = "SELECT * FROM etudiant where CNE=" +"'"+etd.getCNE()+"'";
				r = stm.executeQuery(exist);
				if(!r.next()) 
					b = false;
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return b;
		
	}

	@Override
	public boolean insert(Etudiant etd) {
		
		if(this.isExist(etd)) return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String insert="INSERT INTO etudiant VALUES('"+ etd.getCNE() +"','"+etd.getCode_professeur()+"','"
					+etd.getNom_etudiant()+"','"+ etd.getPrenom_etudiant()+"','"+etd.getEmail_etudiant() +"','"+etd.getAnne()+"')";
			stm.execute(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			c.closeConnection(con);
		}
		return true;
	}

	@Override
	public boolean delete(Etudiant etd) {
		
		if(!this.isExist(etd))
			return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String delete="DELETE FROM etudiant WHERE CNE='"+etd.getCNE()+"'";
			stm.execute(delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}

	@Override
	public Object searchById(String CNE) {
		Etudiant pp = new Etudiant();
		pp.setCNE(CNE);
		if(!this.isExist(pp))
			return new Etudiant();
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String select="SELECT * FROM etudiant WHERE CNE= '"+ CNE +"'";
			ResultSet res = stm.executeQuery(select);
			while(res.next())
			{
				Etudiant etd = new Etudiant(CNE,res.getString("code_professeur"),res.getString("nom_etudiant"),res.getString("prenom_etudiant")
						,res.getString("email_etudiant"),res.getString("anne"));
				Object obj = (Etudiant) etd;
				return etd;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return null;	
	}

	@Override
	public boolean update(Etudiant etd2) {
		if(!this.isExist(etd2)) return this.insert(etd2);

		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String update="UPDATE etudiant SET nom_etudiant = '"+etd2.getNom_etudiant()+"' , "
					+ "prenom_etudiant = '"+etd2.getPrenom_etudiant()+"' , anne='"+etd2.getAnne()+"'"
							+ " , email_etudiant = '"+etd2.getEmail_etudiant()+"' WHERE CNE = '"+etd2.getCNE()+"'";
							
			stm.execute(update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}
	
	
	public ArrayList<Etudiant> getAll()
	{
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		ArrayList<Etudiant> list = new ArrayList<>();
		
		try {
			Etudiant e = null;
			Statement stm = con.createStatement();
			ResultSet r = null;
			String select = "SELECT * FROM etudiant" ;
			r = stm.executeQuery(select);
			while(r.next())
			{
				e = new Etudiant(r.getString("CNE"),r.getString("code_professeur"),r.getString("nom_etudiant"),r.getString("prenom_etudiant"),
						r.getString("email_etudiant"),r.getString("anne"));
				list.add(e);
				e = null;
				System.gc();
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		c.closeConnection(con);
		return list;
	}

	
	
	
}
