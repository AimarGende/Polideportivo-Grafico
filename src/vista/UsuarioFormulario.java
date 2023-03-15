package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Usuario;
import modelo.UsuarioModelo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

public class UsuarioFormulario extends JDialog {

	private final JPanel contentPanel ;
	public JTextField idUsuarioText;
	public JTextField NombreUsuarioText;
	public JTextField dniUsuarioText;
	public JTextField codigoUsuarioText;
	public DefaultTableModel tableModel;
	public JTable table;
	public JLabel lblNewLabel;
	public JButton BuscarBTN;
	public JButton LimpiarBTN;
	public JButton ModificarBTN;
	public JButton EliminarBTN;
	public JButton GuadrarBTN;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			UsuarioFormulario dialog = new UsuarioFormulario();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public UsuarioFormulario(JFrame padre, boolean modal) {
		super(padre, modal);
		setBounds(100, 100, 690, 319);
		contentPanel = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel idUsuario = new JLabel("ID");
		idUsuario.setBounds(31, 54, 23, 14);
		contentPanel.add(idUsuario);
		
		JLabel nombre_apellidoUsuario = new JLabel("Nombre ");
		nombre_apellidoUsuario.setBounds(21, 90, 57, 14);
		contentPanel.add(nombre_apellidoUsuario);
		
		JLabel dniUsuario = new JLabel("DNI");
		dniUsuario.setBounds(31, 133, 23, 14);
		contentPanel.add(dniUsuario);
		
		JLabel codigoUsuario = new JLabel("Codigo");
		codigoUsuario.setBounds(21, 171, 46, 14);
		contentPanel.add(codigoUsuario);
		
		idUsuarioText = new JTextField();
		idUsuarioText.setBounds(128, 51, 86, 20);
		contentPanel.add(idUsuarioText);
		idUsuarioText.setColumns(10);
		
		NombreUsuarioText = new JTextField();
		NombreUsuarioText.setBounds(128, 87, 86, 20);
		contentPanel.add(NombreUsuarioText);
		NombreUsuarioText.setColumns(10);
		
		dniUsuarioText = new JTextField();
		dniUsuarioText.setBounds(128, 130, 86, 20);
		contentPanel.add(dniUsuarioText);
		dniUsuarioText.setColumns(10);
		
		codigoUsuarioText = new JTextField();
		codigoUsuarioText.setBounds(128, 168, 86, 20);
		contentPanel.add(codigoUsuarioText);
		codigoUsuarioText.setColumns(10);
		
		String[] columnas= {"id", "nombre", "dni", "codigo"}; 
		
		this.tableModel = new DefaultTableModel(columnas, 0);
		
		
		
		table = new JTable(tableModel);
		table.setBounds(280, 11, 144, 214);

		
		lblNewLabel = new JLabel("completo");
		lblNewLabel.setBounds(21, 103, 57, 14);
		contentPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 54, 262, 112);
		contentPanel.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		GuadrarBTN = new JButton("Guardar");
		GuadrarBTN.setBounds(60, 231, 89, 23);
		contentPanel.add(GuadrarBTN);
		
		EliminarBTN = new JButton("Eliminar");
		EliminarBTN.setBounds(212, 231, 89, 23);
		contentPanel.add(EliminarBTN);
		
		ModificarBTN = new JButton("Modificar");
		ModificarBTN.setBounds(369, 231, 89, 23);
		contentPanel.add(ModificarBTN);
		
		LimpiarBTN = new JButton("Limpiar");
		LimpiarBTN.setBounds(553, 231, 89, 23);
		contentPanel.add(LimpiarBTN);
		
		BuscarBTN = new JButton("Buscar");
		BuscarBTN.setBounds(234, 50, 89, 23);
		contentPanel.add(BuscarBTN);
	}
	
	public void limpiar() {
		idUsuarioText.setText("");
		NombreUsuarioText.setText("");
		dniUsuarioText.setText("");
		codigoUsuarioText.setText("");
	}
	
	public Usuario getDatosUsuario() {
		Usuario usuario=new Usuario();
		usuario.setNombre_apellido(NombreUsuarioText.getText());
		usuario.setDni(dniUsuarioText.getText());
		usuario.setCodigo(codigoUsuarioText.getText());
		return usuario;
	}
	
	public void rellenarTabla(ArrayList<Usuario> usuarios) {
		UsuarioModelo model= new UsuarioModelo();
		model.conectar();
		for (Usuario usu : model.getUsuarios()) {
			int id=usu.getId();
			String nombre=usu.getNombre_apellido();
			String dni=usu.getDni();
			String codigo=usu.getCodigo();
			
			Object[] datos= {id, nombre, dni, codigo};
			
			tableModel.addRow(datos);
		}
		model.cerrar();
	}
	
	public void rellenarCampos(Usuario usuario) {
		idUsuarioText.setText(String.valueOf(usuario.getId()));
		NombreUsuarioText.setText(usuario.getNombre_apellido());
		dniUsuarioText.setText(usuario.getDni());
		codigoUsuarioText.setText(usuario.getCodigo());
	}
	
	public void rellenarCamposDeSeleccionDeTabla(int row) {
		idUsuarioText.setText(String.valueOf(tableModel.getValueAt(row, tableModel.findColumn("id"))));
		codigoUsuarioText.setText(String.valueOf(tableModel.getValueAt(row, tableModel.findColumn("codigo"))));
		NombreUsuarioText.setText(String.valueOf(tableModel.getValueAt(row, tableModel.findColumn("nombre"))));
		dniUsuarioText.setText(String.valueOf(tableModel.getValueAt(row, tableModel.findColumn("dni"))));		
	}
	public void limpiarTablaProductos() {
		for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--) {
			this.tableModel.removeRow(i);
		}
	}
}
