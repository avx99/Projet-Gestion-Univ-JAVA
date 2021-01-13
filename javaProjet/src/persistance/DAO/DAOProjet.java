package persistance.DAO;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.POJO.Professeur;
import Metier.POJO.Projet;
public class DAOProjet implements DAOInterface<Projet> {
	
	

	public DAOProjet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isExist(Projet table) {
		boolean b = true;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM projet where id_projets=" + "'"+table.getId_projets()+"'" ;
			r = stm.executeQuery(exist);
			if(!r.next()) 
				b = false;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean insert(Projet table) {
		
		if(this.isExist(table)) return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String insert="INSERT INTO projet VALUES('"+table.getId_projets()+"','"+table.getCode_professeur()+"','"+table.getCNE()+"','"+table.getType_projet()+
					"','"+table.getSujet()+"','"+table.getProgres()+"','"+table.getValider()+"','"+"null"+"')";
			stm.execute(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}

	@Override
	public boolean delete(Projet table) {
		
		if(!this.isExist(table))
			return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String delete="DELETE FROM projet WHERE id_projets='"+table.getId_projets()+"'";
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
		
		Projet dd = new Projet();
		dd.setId_projets(id);
		if(!this.isExist(dd))
			return new Projet();
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String select="SELECT * FROM projet WHERE id_projets='"+ id +"'";
			ResultSet res = stm.executeQuery(select);
			while(res.next())
			{
				Projet p = new Projet(id,res.getString("code_professeur"),res.getString("CNE")
						,res.getString("type_projet"),res.getString("sujet"),res.getString("progres"),res.getString("valider"));
				
				Object obj = (Projet) p;
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
	public boolean update(Projet table2) {
		
		if(!this.isExist(table2)) return false;

		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String update="UPDATE projet SET type_projet = '"+table2.getType_projet()+"', valider='"+table2.getValider()
			+"',  progres='"+table2.getProgres()+"', sujet='"+table2.getSujet()+"'"
					+ "WHERE  id_projets = '"+table2.getId_projets()+"'";
			stm.execute(update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}
	
	public ArrayList<Projet>  getProjetsEtudiant(String CNE) {
		
		ArrayList<Projet> projets = new ArrayList<Projet>();
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM projet where CNE=" + "'"+CNE+"'" ;
			r = stm.executeQuery(exist);
			while(r.next())
				projets.add(new Projet(r.getString("id_projets"),r.getString("code_professeur"),CNE,
						r.getString("type_projet"),r.getString("sujet"),r.getString("progres"),r.getString("valider")));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return projets;
	}
	
	public ArrayList<Projet> getAll()
	{
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		ArrayList<Projet> list = new ArrayList<>();
		
		try {
			Projet p = null;
			Statement stm = con.createStatement();
			ResultSet r = null;
			String select = "SELECT * FROM projet" ;
			r = stm.executeQuery(select);
			while(r.next())
			{
				p = new Projet(r.getString("id_projets"),r.getString("code_professeur"),r.getString("CNE"),
						r.getString("type_projet"),r.getString("sujet"),r.getString("progres"),r.getString("valider"));
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
	
	
	
	public void setFile(String id,String path)
	{
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String sql = "UPDATE projet SET fichier = ? WHERE id_projets = '"+id+"'";
			PreparedStatement pstm = con.prepareStatement(sql);
			File f = new File(path);
			FileInputStream ff;
			try {
				ff = new FileInputStream(f);
				pstm.setBinaryStream(1,ff);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
	}
	
	
	public void getFile(String id,String export,String fileName)
	{
		Statement stm;
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		FileOutputStream output = null;

		try {
			stm = con.createStatement();
			String sql = "SELECT fichier from projet where id_projets='"+id+"'";
			ResultSet rs = stm.executeQuery(sql);
			File f = new File(export+"//"+fileName);
			try {
				output = new FileOutputStream(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rs.next())
			{
				InputStream input = rs.getBinaryStream("fichier");
				byte[] buffer = new byte[1024];
				try {
					while(input.read(buffer) > 0)
					{
						output.write(buffer);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
	}
}
