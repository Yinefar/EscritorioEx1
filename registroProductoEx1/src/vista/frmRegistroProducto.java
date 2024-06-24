package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionProducto;
import model.Producto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class frmRegistroProducto extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel label_1;
	private JLabel lblProducto;
	private JTextField txtProducto;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblPrecio;
	private JButton btnRegistrar;
	private JButton btnLimpiar;
	private JTextField txtPrecio;
	private JLabel lblMantenimientoDeProductos;
	private JScrollPane scrollPane;
	private JLabel lblListadoDeProductos;
	private JTable tblProductos;
	private DefaultTableModel modelo;

	// Var. global

	GestionProducto gestion = new GestionProducto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistroProducto frame = new frmRegistroProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmRegistroProducto() {
		setBackground(new Color(255, 20, 147));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kanch\\Downloads\\demostracion-en-la-tienda.png"));
		setTitle("Registro de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(21, 67, 65, 14);
		contentPane.add(lblCodigo);

		label_1 = new JLabel("Autogenerado");
		label_1.setBounds(115, 67, 92, 14);
		contentPane.add(label_1);

		lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(21, 96, 65, 14);
		contentPane.add(lblProducto);

		txtProducto = new JTextField();
		txtProducto.setColumns(10);
		txtProducto.setBounds(115, 93, 159, 20);
		contentPane.add(txtProducto);

		lblStock = new JLabel("Stock:");
		lblStock.setBounds(21, 121, 65, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(115, 121, 119, 20);
		contentPane.add(txtStock);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(21, 151, 65, 14);
		contentPane.add(lblPrecio);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(255, 69, 0));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(344, 80, 90, 30);
		contentPane.add(btnRegistrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(255, 69, 0));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(344, 119, 90, 30);
		contentPane.add(btnLimpiar);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(115, 148, 119, 20);
		contentPane.add(txtPrecio);

		lblMantenimientoDeProductos = new JLabel("Registro de Productos");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMantenimientoDeProductos.setBounds(21, 11, 301, 25);
		contentPane.add(lblMantenimientoDeProductos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 255, 414, 220);
		contentPane.add(scrollPane);

		tblProductos = new JTable();
		tblProductos.addMouseListener(this);
		scrollPane.setViewportView(tblProductos);

		modelo = new DefaultTableModel();
		modelo.addColumn("código");
		modelo.addColumn("Producto");
		modelo.addColumn("Stock");
		modelo.addColumn("Precio");
		tblProductos.setModel(modelo);

		lblListadoDeProductos = new JLabel("Listado de Productos");
		lblListadoDeProductos.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblListadoDeProductos.setBounds(21, 219, 301, 25);
		contentPane.add(lblListadoDeProductos);
		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {

		String nombre;
		int stock;
		Double precio;

		// entradas
		nombre = leerNombre();
		stock = leerStock();
		precio = leerPrecio();

		// procesos

		Producto p = new Producto();
		p.setNombre(nombre);
		p.setStock(stock);
		p.setPrecio(precio);

		//

		GestionProducto gp = new GestionProducto();
		int ok = gp.registrarProducto(p);

		// salidas

		if (ok == 0) {

			System.out.println("Error");
		} else {
			System.out.println("Registro OK");
		}
		listar();
	}

	// metodos
	String leerNombre() {
		return txtProducto.getText();
	}

	int leerStock() {
		return Integer.parseInt(txtStock.getText());
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());

	}

	// listar

	void listar() {
		modelo.setRowCount(0);
		ArrayList<Producto> listaProductos = gestion.listarProducto();
		for (int i = 0; i < listaProductos.size(); i++) {
			Object[] fila = { listaProductos.get(i).getId_Producto(), listaProductos.get(i).getNombre(),
					listaProductos.get(i).getStock(), listaProductos.get(i).getPrecio() };
			modelo.addRow(fila);

		}
	}

	protected void limpiarControles() {
		txtProducto.setText("");
		txtPrecio.setText("");
		txtStock.setText("");

	}

	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiarControles();
	}

	void navegar() {
		int fila = tblProductos.getSelectedRow();
		txtProducto.setText("" + tblProductos.getValueAt(fila, 1));
		txtPrecio.setText("" + tblProductos.getValueAt(fila, 2));
		txtStock.setText("" + tblProductos.getValueAt(fila, 3));
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblProductos) {
			mouseClickedTblProductos(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTblProductos(MouseEvent e) {
		navegar();
	}
}
