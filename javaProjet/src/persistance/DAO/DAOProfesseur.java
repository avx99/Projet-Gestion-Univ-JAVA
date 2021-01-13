package persistance.DAO;

import java.sql.*;
import java.util.ArrayList;

import Metier.POJO.Professeur;

public class DAOProfesseur implements DAOInterface<Professeur>
{

	
	public DAOProfesseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public boolean isExist(Professeur p) {
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM professeur WHERE code_professeur= '" + p.getCode_professeur() + "'" ;
			r = stm.executeQuery(exist);
			if(r.next() == true) 
			{
				c.closeConnection(con);
				return true;
			}
			else
			{
				c.closeConnection(con);
				return false;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		c.closeConnection(con);
		return false;
		
	}

	@Override
	public boolean insert(Professeur p){
			if(this.isExist(p)) return false;
			
			ConnectionBD c = ConnectionBD.getcnx();
			Connection con = c.openConnection();
			try {
				Statement stm = con.createStatement();
				String insert="INSERT INTO professeur VALUES('"+p.getCode_professeur()+"','"+p.getNom_professeur()+"',"
						+ "'"+p.getPrenom_professeur()+"','"+p.getGrade_professeur()+"','"+p.getEmail_professeur()+"')";
				stm.execute(insert);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				c.closeConnection(con);
			}
			return true;
		}

	@Override
	public boolean delete(Professeur p) {
		if(!this.isExist(p))
			return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String delete="DELETE FROM professeur WHERE code_professeur='"+p.getCode_professeur()+"'";
			stm.execute(delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}
	

	@Override
	public Object searchById(String id)
	{
		Professeur pp = new Professeur();
		pp.setCode_professeur(id);
		if(!this.isExist(pp))
			return new Professeur();
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String select="SELECT * FROM professeur WHERE code_professeur='"+ id +"'";
			ResultSet res = stm.executeQuery(select);
			while(res.next())
			{
				Professeur p = new Professeur(id,res.getString("nom_professeur"),res.getString("prenom_professeur"),
						res.getString("grade_professeur"),res.getString("email_professeur"));
				Object obj = (Professeur) p;
				return p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return null;	
	}

	@Override
	public boolean update(Professeur p2) {
		
		if(!this.isExist(p2)) return this.insert(p2);

		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String update="UPDATE professeur SET nom_professeur = '"+p2.getNom_professeur()+"' , "
					+ "prenom_professeur = '"+p2.getPrenom_professeur()+"'"
							+ " , grade_professeur = '"+p2.getGrade_professeur()+"'"
							+ " , email_professeur = '"+p2.getEmail_professeur()+"'"
									+ " WHERE code_professeur = '"+p2.getCode_professeur()+"'";
			stm.execute(update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
		
	}
	
	
	public ArrayList<Professeur> getAll()
	{
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		ArrayList<Professeur> list = new ArrayList<>();
		
		try {
			Professeur p = null;
			Statement stm = con.createStatement();
			ResultSet r = null;
			String select = "SELECT * FROM professeur" ;
			r = stm.executeQuery(select);
			while(r.next())
			{
				p = new Professeur(r.getString("code_professeur"),r.getString("nom_professeur"),r.getString("prenom_professeur"),
						r.getString("grade_professeur"),r.getString("email_professeur"));
				list.add(p);
				p = null;
				System.gc();
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		c.closeConnection(con);
		return list;
	}
	
	
		
	}
	
	

