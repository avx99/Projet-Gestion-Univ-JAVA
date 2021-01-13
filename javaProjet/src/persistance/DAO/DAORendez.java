package persistance.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.POJO.Professeur;
import Metier.POJO.Rendez;
import Metier.POJO.Rendez;


public class DAORendez implements DAOInterface<Rendez>{

	
	
	public DAORendez() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isExist(Rendez table) {
		boolean b = true;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM rendez"
					+ " where id_rendez= '" + table.getId_rendez()+"'" ;
			r = stm.executeQuery(exist);
			if(!r.next()) 
				b = false;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean insert(Rendez table) {
		
		if(this.isExist(table)) return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String insert="INSERT INTO rendez VALUES('"+table.getId_rendez()+"','"+table.getDate_rendez()+"','"
					+table.getCode_professeur()+"','"+table.getCNE()+"')";
			stm.execute(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}

	@Override
	public boolean delete(Rendez table) {
		
		if(!this.isExist(table))
			return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String delete="DELETE FROM rendez WHERE id_rendez='"+table.getId_rendez()+"'";
			stm.execute(delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}

	@Override
	public Object searchById(String id) {
		
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String select="SELECT * FROM rendez WHERE id_rendez='"+ id +"'";
			ResultSet res = stm.executeQuery(select);
			while(res.next())
			{
				Rendez p = new Rendez(id,res.getString("date_rendez"),res.getString("code_professeur"),res.getString("CNE"));
				return (Rendez) p;
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return null;
	}

	@Override
	public boolean update(Rendez table2) {
		
		if(!this.isExist(table2)) return false;

		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String update="UPDATE rendez SET date_rendez = '"+table2.getDate_rendez()+"' "
									+ " WHERE id_rendez = '"+table2.getId_rendez()+"'";
			stm.execute(update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}
	
	public ArrayList<Rendez> getAll()
	{
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		ArrayList<Rendez> list = new ArrayList<>();
		
		try {
			Rendez p = null;
			Statement stm = con.createStatement();
			ResultSet r = null;
			String select = "SELECT * FROM rendez" ;
			r = stm.executeQuery(select);
			while(r.next())
			{
				p = new Rendez(r.getString("id_rendez"),r.getString("date_rendez"),
						r.getString("code_professeur"),r.getString("cne"));
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
	
	
	public ArrayList<Rendez>  getRendezEtudiant(String CNE) {
		
		ArrayList<Rendez> rendez = new ArrayList<Rendez>();
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM rendez where CNE=" + "'"+CNE+"'" ;
			r = stm.executeQuery(exist);
			while(r.next())
				rendez.add(new Rendez(r.getString("id_rendez"),r.getString("date_rendez"),r.getString("code_professeur"),
						CNE));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rendez;
	}

}
