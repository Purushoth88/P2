import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;


public class ControladorAsignacion implements ActionListener {

	private VistaAsignacion vista;
	private Colegio col;
	
	public ControladorAsignacion(VistaAsignacion vista){
		this.vista = vista;
		vista.habilitarInicio(true);
		vista.ok("introduzca el nombre del fichero y pulse elbotón iniciar");
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(vista.INICIAR_ASIGNACION)){
			vista.habilitarInicio(false);
			vista.ok("asignación.");
			col = new Colegio(vista.ficheroSolicitudes());
		}else if(comando.equals(vista.INICIAR_ASIGNACION_FAMILIAR)){
			vista.habilitarInicio(false);
			vista.ok("asignación.");
			col = new ColegioFamiliar(vista.ficheroSolicitudes());
		}else if(comando.equals(vista.ASIGNAR)){
			vista.habilitarInicio(false);
			col.limpiar();
			Map<String, Integer> mapa = new TreeMap<>();
			mapa.put("I3", vista.plazasI3());
			mapa.put("I4", vista.plazasI4());
			mapa.put("I5", vista.plazasI5());
			mapa.put("P1", vista.plazasP1());
			mapa.put("P2", vista.plazasP2());
			mapa.put("P3", vista.plazasP3());
			mapa.put("P4", vista.plazasP4());
			mapa.put("P5", vista.plazasP5());
			mapa.put("P6", vista.plazasP6());
			col.asignarPlazas(mapa);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			col.mostrarSolicitantes(true, pw);
			pw.close();
			vista.añadirAHistórico(sw.toString());
			vista.ok("Salida correcta en pantalla y en fichero");
			try {
				col.mostrarSolicitantes(true, vista.ficheroSalidaConPlaza());
				col.mostrarSolicitantes(false, vista.ficheroSalidaSinPlaza());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(comando.equalsIgnoreCase(vista.FINALIZAR)){
			col.limpiar();
			vista.limpiar();
			
			vista.habilitarInicio(true);
		}
		
	}

}
