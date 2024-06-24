package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {

	public static Connection getConexion() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tienda";
			String usr = "root";
			String pws = "admin";
			con = DriverManager.getConnection(url, usr, pws);

		} catch (ClassNotFoundException ex) {

			System.out.println("Error>> ¡Driver no instalado!:C");
			// TODO: handle exception
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("Error>> de conexion con la BD" + ex.getMessage());
		}
		return con;
	}

}
