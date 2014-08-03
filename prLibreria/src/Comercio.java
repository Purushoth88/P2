import java.util.*;

/**
 * @author LTO
 * 
 * @param <T>
 *            Interfaz que representa comercios en los que se venden objetos de
 *            tipo T
 */
public interface Comercio<T> {
	/**
	 * @param objeto
	 *            que quiere comprar el cliente c
	 * @param c
	 *            cliente que quiere comprar
	 * @return el precio del objeto
	 */
	public double compro(T objeto, Cliente c);

	/**
	 * @param str
	 *            cadena que representa un criterio de busqueda
	 * @return la lista de objetos del comercio satisfacen el criterio de
	 *         busqueda
	 */
	List<T> busca(String str);
}
