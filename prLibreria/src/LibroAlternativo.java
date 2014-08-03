import java.util.Comparator;


public class LibroAlternativo implements Comparator<Libro> {

	@Override
	public int compare(Libro o1, Libro o2) {
		Integer valor1 = new Integer(o1.getReferencia());
		Integer valor2 = new Integer(o2.getReferencia());
		return valor1.compareTo(valor2);
	}

}
