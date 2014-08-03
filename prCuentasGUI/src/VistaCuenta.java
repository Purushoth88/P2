import java.awt.event.ActionListener;


public interface VistaCuenta {
	
	double obtenerCantidad();
	void saldo(double saldo);
	void mensaje(String msg);
	void controlador(ActionListener ctr);
	
	
	String INGRESO = "I";
	String GASTO = "G";
	String SALDO = "S";
}
