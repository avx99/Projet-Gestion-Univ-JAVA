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
import Metier.POJO.Rapport;
public class DAORapport implements DAOInterface<Rapport>{

	public DAORapport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	@Override
	public boolean isExist(Rapport table) {
boolean b = true;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM Rapport where id_rapport='" + table.getId_rapport()+"'" ;
			r = stm.executeQuery(exist);
			if(!r.next()) 
				b = false;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean insert(Rapport table) {
		
		if(this.isExist(table)) return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String insert="INSERT INTO rapport VALUES('"+table.getId_rapport()+"','"+table.getNom_rapport()+"',"
					+ "'"+table.getCNE()+"','"+table.getCode_professeur()+"','"+table.getValider()+"','"+"null"+"')";
			stm.execute(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}

	@Override
	public boolean delete(Rapport table) {
		
		if(!this.isExist(table))
			return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String delete="DELETE FROM rapport WHERE id_rapport='"+table.getId_rapport()+"'";
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
			String select="SELECT * FROM rapport WHERE id_rapport='"+ id +"'";
			ResultSet res = stm.executeQuery(select);
			while(res.next())
			{
				Rapport p = new Rapport(id,res.getString("nom_rapport"),res.getString("CNE"),res.getString("code_professeur"),
						res.getString("valider"));
				return (Rapport) p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return null;
	}

	@Override
	public boolean update(Rapport table2) {
		
		if(!this.isExist(table2)) return this.insert(table2);

		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String update="UPDATE rapport SET nom_rapport= '"+table2.getNom_rapport()+"' , valider='"+table2.getValider()+"'"
									+ " WHERE id_rapport = '"+table2.getId_rapport()+"'";
			stm.execute(update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}
	
	public ArrayList<Rapport>  getRapportsEtudiant(String CNE) {
		
		ArrayList<Rapport> rapports = new ArrayList<Rapport>();
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM Rapport where CNE='"+CNE+"'";
			r = stm.executeQuery(exist);
			while(r.next())
				rapports.add(new Rapport(r.getString("id_rapport"),r.getString("nom_rapport"),CNE,
						r.getString("code_professeur"),r.getString("valider")));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rapports;
	}
	
	
	public ArrayList<Rapport> getAll()
	{
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		ArrayList<Rapport> list = new ArrayList<>();
		
		try {
			Rapport p = null;
			Statement stm = con.createStatement();
			ResultSet r = null;
			String select = "SELECT * FROM rapport" ;
			r = stm.executeQuery(select);
			while(r.next())
			{
				p = new Rapport(r.getString("id_rapport"),r.getString("nom_rapport"),r.getString("CNE"),
						r.getString("code_professeur"),r.getString("valider"));
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
			String sql = "UPDATE projet SET fichier = ? WHERE id_rapport = '"+id+"'";
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
			String sql = "SELECT fichier from document where id_rapport='"+id+"'";
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
