import java.awt.event.ActionListener;

public interface VistaLibreria {
	// Comando del boton Crear librería
	String CREAR = "Crear";
	// Comando del boton Comprar libro
	String COMPRAR = "Comprar";
	// Comando del boton Buscar libro
	String BUSCAR = "Buscar";
	// Comando del boton Inventario librería
	String INVENTARIO = "Inventario";

	// Asigna el controlador
	public void controlador(ActionListener ctr);

	// Lee el nombre del fichero de entrada para
	// crear la librería
	public String fichCrear();

	// Lee el título del libro que se quiere comprar
	public String libroComprar();

	// Lee la referencia del libro que se quiere buscar
	public int libroBuscar();

	// Limpia el área de texto
	public void limpiar();

	// Añade al área de texto la cadena str
	public void mostrar(String str);

	// cambia el texto de la barra inferior por la cadena str
	public void mensaje(String str);

	// cambia el texto de la barra inferior por la cadena str
	// para informar de un error durante la realización de alguna
	// operación
	public void error(String str);
}
