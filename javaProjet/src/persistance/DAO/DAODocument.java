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

import Metier.POJO.Document;

public class DAODocument implements DAOInterface<Document>{

	public DAODocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	public boolean isExist(Document table) {
		
		boolean b = true;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM document where id_document=" + "'"+table.getId_document()+"'" ;
			r = stm.executeQuery(exist);
			if(!r.next()) 
				b = false;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean insert(Document table) {
		
		
		if(this.isExist(table)) return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String insert="INSERT INTO document VALUES('"+table.getId_document()+"','"+table.getNom_document()+"','"
					+table.getCNE()+"','"+table.getId_projets()+"','"+table.getCode_professeur()+"','"+table.getCreer_par()+"','"+"null"+"')";
			stm.execute(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}

	@Override
	public boolean delete(Document table) {
		if(!this.isExist(table))
			return false;
		
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String delete="DELETE FROM document WHERE id_document='"+table.getId_document()+"'";
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
		
		Document dd = new Document();
		dd.setId_document(id);
		if(!this.isExist(dd))
			return new Document();
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String select="SELECT * FROM document WHERE id_document='"+ id +"'";
			ResultSet res = stm.executeQuery(select);
			while(res.next())
			{
				Document p = new Document(id,res.getString("nom_document"),res.getString("CNE"),
						res.getString("id_projets"),res.getString("code_professeur"),res.getString("creer_par"));
				Object obj = (Document) p;
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
	public boolean update(Document table2) {
		
		if(!this.isExist(table2)) return false;

		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String update="UPDATE document SET nom_document = '"+table2.getNom_document()+"' , creer_par='"+table2.getCreer_par()+"'"
									+ " WHERE id_document = '"+table2.getId_document() +"'";
			stm.execute(update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			c.closeConnection(con);
		}
		return true;
	}
	
	public void setFile(String id,String path)
	{
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		try {
			Statement stm = con.createStatement();
			String sql = "UPDATE document SET fichier = ? WHERE id_document = '"+id+"'";
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
	
	
public ArrayList<Document>  getDocumentsEtudiant(String CNE) {
		
		ArrayList<Document> documents = new ArrayList<Document>();
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet r = null;
			String exist = "SELECT * FROM document where CNE='"+CNE+"' and creer_par='Etudiant'" ;
			r = stm.executeQuery(exist);
			while(r.next()) 
				documents.add(new Document(r.getString("id_document"),r.getString("nom_document"),CNE,
						r.getString("id_projets"),r.getString("code_professeur"),r.getString("creer_par")));
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return documents;
		
	}
	
	
	public void getFile(String id,String export,String fileName)
	{
		Statement stm;
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		FileOutputStream output = null;

		try {
			stm = con.createStatement();
			String sql = "SELECT fichier from document where id_document='"+id+"'";
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
	
	
	
	public ArrayList<Document> getAll()
	{
		ConnectionBD c = ConnectionBD.getcnx();
		Connection con = c.openConnection();
		ArrayList<Document> list = new ArrayList<>();
		
		try {
			Document d = null;
			Statement stm = con.createStatement();
			ResultSet res = null;
			String select = "SELECT * FROM document" ;
			res = stm.executeQuery(select);
			while(res.next())
			{
				d = new Document(res.getString("id_document"),res.getString("nom_document"),res.getString("CNE"),
						res.getString("id_projets"),res.getString("code_professeur"),res.getString("creer_par"));
				list.add(d);
				d = null;
				System.gc();
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		c.closeConnection(con);
		return list;
	}
	
	
	
	
		

}
