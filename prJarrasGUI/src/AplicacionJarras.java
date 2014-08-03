import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class AplicacionJarras {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Jarras");
		PanelJarras vista = new PanelJarras();
		ActionListener controler = new ControladorJarras(vista);
		vista.controlador(controler);
		
		frame.add(vista);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}
