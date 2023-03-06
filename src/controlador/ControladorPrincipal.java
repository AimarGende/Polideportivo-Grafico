package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.*;

public class ControladorPrincipal implements ActionListener{
	private Principal principal;

	public ControladorPrincipal(Principal principal) {
		this.principal = principal;
		
		principal.ActividadBTN.addActionListener(this);
		principal.UsuariosBTN.addActionListener(this);
		principal.InscripcionBTN.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== principal.ActividadBTN) {
			ActividadFormulario form = new ActividadFormulario();
			
			form.setVisible(true);
		}
		
		if(e.getSource()== principal.UsuariosBTN) {
			
		}
		
		if(e.getSource()== principal.InscripcionBTN) {
			
		}
		
	}
	
}
