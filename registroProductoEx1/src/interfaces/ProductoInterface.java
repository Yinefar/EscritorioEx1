package interfaces;

import java.util.ArrayList;

import model.Producto;

public interface ProductoInterface {
	
	public int registrarProducto(Producto p); 
	public int eliminarProducto(int id);
	public ArrayList<Producto> listarProducto();

}
