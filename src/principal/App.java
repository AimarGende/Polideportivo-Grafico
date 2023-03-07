package principal;

import controlador.ControladorPrincipal;
import vista.Principal;

public class App {

	public static void main(String[] args) {
		Principal princ = new Principal();
		
		ControladorPrincipal contr= new ControladorPrincipal(princ);
		contr.inicializar();
		princ.setVisible(true);

	}

}
