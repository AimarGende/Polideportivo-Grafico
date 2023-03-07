package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;

import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;
	public JButton UsuariosBTN ;
	public JButton ActividadBTN;
	public JButton InscripcionBTN;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Principal frame = new Principal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UsuariosBTN = new JButton("Usuarios");
		UsuariosBTN.setBounds(159, 44, 137, 23);
		contentPane.add(UsuariosBTN);
		
		ActividadBTN = new JButton("Actividad");
		ActividadBTN.setBounds(159, 106, 137, 23);
		contentPane.add(ActividadBTN);
		
		InscripcionBTN = new JButton("Inscripcion");
		InscripcionBTN.setBounds(159, 165, 137, 23);
		contentPane.add(InscripcionBTN);
	}
}
