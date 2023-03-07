package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.UsuarioModelo;
import vista.*;

public class ControladorPrincipal implements ActionListener{
	private Principal principal;

	public ControladorPrincipal(Principal principal) {
		this.principal = principal;
		
		this.principal.ActividadBTN.addActionListener(this);
		this.principal.UsuariosBTN.addActionListener(this);
		this.principal.InscripcionBTN.addActionListener(this);
	}
	
	public void inicializar() {
		principal.setTitle("Desktop");
		principal.setLocationRelativeTo(null);
		principal.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== principal.ActividadBTN) {
			
			ActividadFormulario form = new ActividadFormulario(principal, true);
			
			ControladorActividad contr = new ControladorActividad();
			form.setVisible(true);
		}
		
		if(e.getSource()== principal.UsuariosBTN) {
			UsuarioModelo model= new UsuarioModelo();
			UsuarioFormulario form = new UsuarioFormulario(principal, true);
			
			ControladorUsuario contr = new ControladorUsuario(model,form);
			contr.inicializar();
			form.setVisible(true);
		}
		
		if(e.getSource()== principal.InscripcionBTN) {
			InscripcionFormulario form = new InscripcionFormulario(principal, true);
			
			ControladorInscripcion contr = new ControladorInscripcion();
			form.setVisible(true);
		}
		
	}
	
}
