package mvc.vista;

/*********************************************************
 *   Interfaz para las Vistas
 *********************************************************/
import java.awt.event.*;

public interface IVistaCuenta {
	
	// el controlador puede manejar ciertos eventos
	// y leer/escribir datos de la vista
	
	// lectura de datos del formulario
	double obtenerCantidad();
	
	// escritura de datos en el formulario
	void saldo(double saldo);
	void mensaje(String msg);

	// eventos exportados al controlador
	String INGRESO = "I";
	String GASTO = "G";
	String SALDO = "S";
	
    // para registrar el controlador	
	void controlador(ActionListener ctr);
}
