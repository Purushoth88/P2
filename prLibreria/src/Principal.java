import javax.swing.JFrame;
import javax.swing.JPanel;


public class Principal {
	public static void main(String[] args) {
		VistaLibreria vista = new PanelLibreria();
		Libraria libraria = new Libraria();
		Controlador ctr = new Controlador(vista);
		vista.controlador(ctr);
		
		JFrame frame = new JFrame();
		frame.setContentPane((JPanel) vista);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	
	
}
