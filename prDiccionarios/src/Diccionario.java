import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;


public interface Diccionario <C extends String,V extends String> {
	
	boolean insertar(String c, String v);
	List<V> consultar(String c);
	boolean eliminar (String c);
	int tamano();
	void limpiar();
	Set<String> claves();
	void escribirDiccionario(String string) throws FileNotFoundException;
	
}
