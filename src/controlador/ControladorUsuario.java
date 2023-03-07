package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Usuario;
import modelo.UsuarioModelo;
import vista.UsuarioFormulario;

public class ControladorUsuario  implements ActionListener, MouseListener{
	private UsuarioModelo usuarioM;
	private UsuarioFormulario formularioUsuario;
	
	public ControladorUsuario(UsuarioModelo usuarioM, UsuarioFormulario formularioUsuario) {
		this.usuarioM = usuarioM;
		this.formularioUsuario = formularioUsuario;
		
		formularioUsuario.GuadrarBTN.addActionListener(this);
		formularioUsuario.BuscarBTN.addActionListener(this);
		formularioUsuario.EliminarBTN.addActionListener(this);
		formularioUsuario.LimpiarBTN.addActionListener(this);
		formularioUsuario.ModificarBTN.addActionListener(this);
		
		formularioUsuario.table.addMouseListener(this);
		
	}
	public void inicializar() {
		this.formularioUsuario.setTitle("Usuarios");
		formularioUsuario.setLocationRelativeTo(null);
		formularioUsuario.setVisible(false);
		
		usuarioM.conectar();
		ArrayList<Usuario> usuarios = usuarioM.getUsuarios();
		usuarioM.cerrar();
		
		formularioUsuario.rellenarTabla(usuarios);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == formularioUsuario.GuadrarBTN) {
			Usuario usuario=formularioUsuario.getDatosUsuario();
			
			usuarioM.conectar();
			if(usuarioM.insertarUsuario(usuario)) {
				JOptionPane.showMessageDialog(formularioUsuario, "Usuario insertado", "Ok",JOptionPane.INFORMATION_MESSAGE);
				formularioUsuario.limpiar();
			}else {
				JOptionPane.showMessageDialog(formularioUsuario, "Error en la insercion", "Error", JOptionPane.ERROR_MESSAGE);
			}
			ArrayList<Usuario> usuarios = usuarioM.getUsuarios();
			usuarioM.cerrar();

			formularioUsuario.rellenarTabla(usuarios);
		}
		
		if(e.getSource() == formularioUsuario.BuscarBTN) {
			int id=Integer.parseInt(formularioUsuario.idUsuarioText.getText());
			
			usuarioM.conectar();
			Usuario usuario=usuarioM.getUsuario(id);
			
			if(usuario != null) {
				formularioUsuario.rellenarCampos(usuario);
			}
			
			usuarioM.cerrar();
		}
		
		if(e.getSource() == formularioUsuario.EliminarBTN) {
			Usuario usuario=formularioUsuario.getDatosUsuario();
			
			usuarioM.conectar();
			if(usuarioM.eliminarUsuario(usuario)) {
				JOptionPane.showMessageDialog(formularioUsuario, "Usuario eliminado", "Ok",JOptionPane.INFORMATION_MESSAGE);
				formularioUsuario.limpiar();
			}else {
				JOptionPane.showMessageDialog(formularioUsuario, "Error en la eliminacion", "Error", JOptionPane.ERROR_MESSAGE);
			}
			ArrayList<Usuario> usuarios = usuarioM.getUsuarios();
			usuarioM.cerrar();

			formularioUsuario.rellenarTabla(usuarios);
		}
		
		if(e.getSource() == formularioUsuario.LimpiarBTN) {
			formularioUsuario.limpiar();
		}
		
		if(e.getSource() == formularioUsuario.ModificarBTN) {
			Usuario usuario=formularioUsuario.getDatosUsuario();
			
			usuarioM.conectar();
			if(usuarioM.modificarUsuario(usuario)) {
				JOptionPane.showMessageDialog(formularioUsuario, "Usuario modificado", "Ok",JOptionPane.INFORMATION_MESSAGE);
				formularioUsuario.limpiar();
			}else {
				JOptionPane.showMessageDialog(formularioUsuario, "Error en la modificacion", "Error", JOptionPane.ERROR_MESSAGE);
			}
			ArrayList<Usuario> usuarios = usuarioM.getUsuarios();
			usuarioM.cerrar();

			formularioUsuario.rellenarTabla(usuarios);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
