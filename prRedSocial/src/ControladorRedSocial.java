import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


public class ControladorRedSocial implements ActionListener{
	
	private VistaRedSocial vista;
	private RedSocial red;
	
	public ControladorRedSocial(VistaRedSocial vista){
		this.vista = vista;
		vista.activarInit(true);
		vista.ok("Introduza o ficheiro e clique em inciar uma rede");
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(vista.INIT_RED)){
			try {
				vista.activarInit(false);
				vista.ok("add amigos a sua rede");
				red= new RedSocial(vista.fichUsuarios());
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(comando.endsWith(vista.INIT_RED_TOPE)){
			vista.activarInit(false);
			vista.ok("add amigos a sua rede");
			try {
				red = new RedSocialConTope(vista.fichUsuarios(), vista.tope());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(comando.equals(vista.ASIGNAR_AMIGOS)){
			red.anadirAmigo(p, vista.numAmigos());
		}
		
	}
}
