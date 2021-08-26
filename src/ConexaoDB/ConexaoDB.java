/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoDB;
import java.sql.*;
import Exception.DBException;


/**
 *
 * @author JD
 */
public class ConexaoDB {
    
    public static Connection conn;
	
    public static Connection getConnection(){
        try {
            String db = "projeto_swing";
            String user = "sa";
            String pass = "promaster";
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=" + db + ";"
                    + "user=" + user + ";"
                    + "password=" + pass + ";";
            conn = DriverManager.getConnection(url);

        }
        catch (SQLException e) {
            throw new DBException("Erro: " + e.getMessage());
        }
        return conn;
		
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
                                conn = null;
			}
			catch(SQLException e) {
				throw new DBException("Erro: " + e.getMessage());
			}
			
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}
			catch(SQLException e) {
				throw new DBException("Erro: " + e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch(SQLException e) {
				throw new DBException("Erro: " + e.getMessage());
			}
		}
	}
	

}
