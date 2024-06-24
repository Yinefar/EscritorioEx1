package mantenimientos;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import utils.MySQLConexion;

public class GestionProducto implements ProductoInterface {

	@Override
	public int registrarProducto(Producto p) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion(); // Obtenemos la conexion a la BD
			String sql = "insert into Producto values (null, ?, ?,?)";
			pst = con.prepareStatement(sql);
			// Vincular los ?
			pst.setString(1, p.getNombre());
			pst.setInt(2, p.getStock());
			pst.setDouble(3, p.getPrecio());

			resultado = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {

				System.out.println("Error al cerrar.");

			}
		}

		return resultado;

	}

	@Override
	public int eliminarProducto(int id) {
		return 0;
	}

	@Override
	public ArrayList<Producto> listarProducto() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {

			con = MySQLConexion.getConexion();
			String sql = " Select id_Producto, nombre, stock, precio from Producto ";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId_Producto(rs.getInt(1));
				producto.setNombre(rs.getString(2));
				producto.setStock(rs.getInt(3));
				producto.setPrecio(rs.getDouble(4));
				lista.add(producto);
			}

		} catch (Exception e) {
			System.out.println("Error en la ejecucion " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar conexion " + e2.getMessage());
			}
		}
		return lista;

	}

}
