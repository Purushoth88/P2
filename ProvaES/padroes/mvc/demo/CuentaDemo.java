package mvc.demo;

/*********************************************************
 *    Aplicación con GUI MVC
 *********************************************************/

import javax.swing.JFrame;
import javax.swing.JPanel;

import factory.Creator;
import factory.IFactoriaVistas;

import mvc.modelo.Cuenta;
import mvc.vista.*;
import mvc.controlador.CtrCuenta;

public class CuentaDemo {
	
	public static void main(String[] args) {
			crearMVC("SUSALDO");
			crearMVC("GASTOSO");
			crearMVC("AHORRADOR");
	}
	
	private static void crearMVC(String tipoVista){
		IFactoriaVistas factory = new Creator();
		
		
		// Montamos el MVC
		
		// creamos el modelo
		Cuenta cuenta = Cuenta.instancia();  // saldo inicial = 0
		
		// la vista
		IVistaCuenta vistaCuenta = factory.creator(tipoVista);
		
		// y el controlador
		@SuppressWarnings("unused")
		CtrCuenta ctr = new CtrCuenta(vistaCuenta, cuenta);

		// Mostramos la vista en una ventana y la activamos
		JFrame ventana = new JFrame("Control de cuentas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vistaCuenta);
		ventana.setLocation(400, 100);
		ventana.pack();
		ventana.setVisible(true);
	}
}
