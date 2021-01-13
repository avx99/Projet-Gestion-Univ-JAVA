package persistance.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	
	private  String URL;
	private  String Login;
	private  String Password;
	
	
	public ConnectionBD()
	{
		this.URL = "jdbc:mysql://localhost:3306/projetjava";
		this.Login = "root";
		this.Password = "";
	}
	
	static ConnectionBD cnx = new ConnectionBD();
	
	public static ConnectionBD getcnx() {
		return cnx;
	}
	
	
	
	
	public String getURL() {
		return URL;
	}



	public String getLogin() {
		return Login;
	}



	public String getPassword() {
		return Password;
	}



	public static Connection openConnection()
	{
		Connection c = null;
		
		try {
			c = DriverManager.getConnection(cnx.getURL(),cnx.getLogin(),cnx.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	
	public static void closeConnection(Connection c)
	{
		if(c != null)
		{
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	


}
