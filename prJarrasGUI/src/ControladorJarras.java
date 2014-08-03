import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorJarras implements ActionListener{

	private VistaJarras vista;
	private Jarra jarraA,jarraB;

	public ControladorJarras(VistaJarras vista){
		this.vista=vista;
	}

	public void actionPerformed(ActionEvent evento){
		String comando = evento.getActionCommand();

		try{

			if(comando.equals(vista.INICIAR)){
				jarraA = new Jarra(vista.capacidadInicialA());
				jarraB = new Jarra(vista.capacidadInicialB());
				vista.habilitarInicio(true);
				vista.capacidadA(vista.capacidadInicialA());
				vista.capacidadB(vista.capacidadInicialB());
				vista.ok("Jarras criadas com exito");

			}else if(comando.equals(vista.LLENAR_A)){
				jarraA.llena();
				vista.contenidoA(vista.capacidadInicialA());
				vista.anadirAHistórico("Llenamos la jarra A");
			}else if(comando.equals(vista.LLENAR_B)){
				jarraB.llena();
				vista.contenidoB(vista.capacidadInicialB());
				vista.anadirAHistórico("Llenamos la jarra B");
			}else if(comando.equals(vista.VACIAR_A)){
				jarraA.vacia();
				vista.contenidoA(0);
				vista.anadirAHistórico("Vaciamos la jarra A");
			}else if(comando.equals(vista.VACIAR_B)){
				jarraB.vacia();
				vista.contenidoB(0);
				vista.anadirAHistórico("Vaciamos la jarra B");
			}else if(comando.equals(vista.VOLCAR_A_EN_B) && jarraA.cantidad()>0 && jarraB.cantidad()!=jarraB.capacidad()){
				jarraB.llenadaDesde(jarraA);
				vista.contenidoB(jarraB.cantidad());
				vista.contenidoA(jarraA.cantidad());
				vista.anadirAHistórico("Volcamos el contenido de la jarra A en la jarra B");
			}else if(comando.equals(vista.VOLCAR_B_EN_A) && jarraB.cantidad()>0 && jarraA.cantidad()!=jarraA.capacidad()){
				jarraA.llenadaDesde(jarraB);
				vista.contenidoA(jarraA.cantidad());
				vista.contenidoB(jarraB.cantidad());
				vista.anadirAHistórico("Volcamos el contenido de la jarra B en la jarra A");
			}else if(comando.equals(vista.FINALIZAR)){
				vista.limpiar();
				vista.ok("");
				vista.habilitarInicio(false);
			}


		}catch (JarraCapacidadException e) {
			vista.error(e.getMessage());
		}

	}
}
