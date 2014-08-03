import java.awt.event.ActionListener;

public interface VistaLibreria {
	// Comando del boton Crear librer�a
	String CREAR = "Crear";
	// Comando del boton Comprar libro
	String COMPRAR = "Comprar";
	// Comando del boton Buscar libro
	String BUSCAR = "Buscar";
	// Comando del boton Inventario librer�a
	String INVENTARIO = "Inventario";

	// Asigna el controlador
	public void controlador(ActionListener ctr);

	// Lee el nombre del fichero de entrada para
	// crear la librer�a
	public String fichCrear();

	// Lee el t�tulo del libro que se quiere comprar
	public String libroComprar();

	// Lee la referencia del libro que se quiere buscar
	public int libroBuscar();

	// Limpia el �rea de texto
	public void limpiar();

	// A�ade al �rea de texto la cadena str
	public void mostrar(String str);

	// cambia el texto de la barra inferior por la cadena str
	public void mensaje(String str);

	// cambia el texto de la barra inferior por la cadena str
	// para informar de un error durante la realizaci�n de alguna
	// operaci�n
	public void error(String str);
}
