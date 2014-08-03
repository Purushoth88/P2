import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainGUI {
	
	public static void main(String[] args) {

		VistaRedSocial panel = new PanelRedSocial();
		ControladorRedSocial ctr = new ControladorRedSocial(panel);
		panel.controlador(ctr);
		
		JFrame window = new JFrame("Red Social");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane((JPanel) panel);
		window.pack();
		window.setVisible(true);
	}

}
