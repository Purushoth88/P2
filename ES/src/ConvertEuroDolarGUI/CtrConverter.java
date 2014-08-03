package ConvertEuroDolarGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrConverter implements ActionListener {
	VistaConverter vista;
	Converter converter;
	
	public CtrConverter(VistaConverter vista, Converter converter){
		this.vista=vista;
		this.converter=converter;
		vista.mensajem("Conversor inicializado!");
	}
	
	public void actionPerformed(ActionEvent evento){
		String comando = evento.getActionCommand();
		vista.mensajem(" ");
		try{
			if(comando.equals(vista.CONVERTTODOLAR)){
				double valor = converter.convertEuroToDolar(vista.obtenerValor());
				vista.mensajem("$"+valor);
			}else if(comando.equals(vista.CONVERTTOEURO)){
				double valor = converter.convertDolarToEuro(vista.obtenerValor());
				vista.mensajem("€"+valor);
			}
		}catch(NumberFormatException e){
			vista.mensajem("Valor no es valido");
		}
		
	}
}
