package ConvertEuroDolarGUI;

import java.awt.Event;
import java.awt.event.ActionListener;

public interface VistaConverter {
	
	double obtenerValor();
	void mensajem(String msg);
	void controlador(ActionListener ctr);
	
	String CONVERTTODOLAR = "D";
	String CONVERTTOEURO = "E";
}
