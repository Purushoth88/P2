import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;


public class AppDemo {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Creat elements
		//PanelCuentas1 vista = new PanelCuentas1(); //vista
		PanelCuentas3 vista = new PanelCuentas3();
		//PanelCuentas3 vista = new PanelCuentas3();
		Cuenta cuenta = new Cuenta(10000.0); //Model
		ActionListener controler = new CtrCuenta(vista, cuenta); //Controler
		JFrame frame = new JFrame();
		
		vista.controlador(controler);
		
		//Add elements
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(vista);
		frame.pack();
		frame.setVisible(true);
	}
	
	

}
