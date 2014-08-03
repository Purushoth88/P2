import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;


public class ControladorEurocopa implements ActionListener{

	private VistaEurocopa vista;
	private Eurocopa copa;
	
	public ControladorEurocopa(VistaEurocopa panel){
		vista = panel;
		vista.habilitarInicio(true);
		vista.ok("introduzca!nombre!de!ficheros y pulse!el!botón!iniciar");
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(vista.INICIAR_EUROCOPA)){
			try {
				vista.habilitarInicio(false);
				vista.ok("Contrua um time ideal");
				copa = new Eurocopa("C:\\Users\\Lucas\\Documents\\Universidad de Málaga\\Java\\prova OO junho 2012\\equipos.txt");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(comando.equals(vista.INICIAR_EUROCOPA_JUEGO_LIMPIO)){
			try {
				vista.habilitarInicio(false);
				vista.ok("Contrua um time ideal");
				copa= new EurocopaJuegoLimpio("equipos.txt",vista.ficheroTarjetas());
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(comando.equals(vista.FORMAR_EQUIPO_IDEAL)){
			SortedSet<Jugador> ideial = copa.formarEquipoIdeal(vista.defensas(),vista.centrocampistas(),vista.atacantes());
			vista.añadirAHistórico(copa.representarEquipoIdeal(ideial));
			try {
				copa.mostrarEquipoIdeal(vista.ficheroSalida(), ideial);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(comando.equalsIgnoreCase(vista.FINALIZAR)){
			vista.limpiar();
			vista
			.ok("Introduzca nombre de ficheros (y tope de tarjetas) y pulse Botón Iniciar preferido");
	vista.habilitarInicio(true);
		}
		
	}

}
