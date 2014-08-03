
public class LibroRebajado extends Libro {
	
	private int rebaja;

	public LibroRebajado(String autor, String titulo, int referencia,
			double precio, int rebaja) {
		super(autor, titulo, referencia, precio);
		this.rebaja = rebaja;
		
	}

}
