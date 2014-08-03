import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;


public class Controlador implements ActionListener{

	private VistaLibreria vista;
	private Libraria libreria;
	private Libro libro;
	
	
	public Controlador(VistaLibreria vista){
		this.vista = vista;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		System.out.println(e.equals(vista.CREAR));
		if(e.equals(vista.CREAR)){
			
			try {
				
				libreria = new Libraria(vista.fichCrear());
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			libreria.inventario(pw);
			vista.mostrar(sw.getBuffer().toString());
			vista.mensaje("Librería creada con éxito");
		}else if(comando.equals(vista.BUSCAR)){
			
			Libro l =libreria.busca(vista.libroBuscar());
			if(l!=null){
				vista.limpiar();
				vista.mensaje(l.getTitulo()+"\n"+l.getAutor()+"\n"+l.getReferencia()+"\n"+l.getPrecio());
			}
		}else if(comando.equals(vista.COMPRAR)){
			Libro l =libreria.busca(vista.libroBuscar());
			if(l!=null){
				vista.limpiar();
				vista.mensaje(l.getTitulo()+"\n"+l.getAutor()+"\n"+l.getReferencia()+"\n"+l.getPrecio());
			}
		}else if(comando.equals(vista.INVENTARIO)){
			vista.limpiar();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			libreria.inventario(pw);
			vista.mensaje("Inventario");
		}
		
	}

}
