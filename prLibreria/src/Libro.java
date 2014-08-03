
public class Libro implements Comparable<Libro>{
	
	private String autor, titulo;
	private int referencia;
	double precio;
	
	public Libro(String autor, String titulo, int referencia, double precio){
		this.autor=autor;
		this.titulo=titulo;
		this.referencia=referencia;
		this.precio=precio;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getReferencia() {
		return referencia;
	}

	public double getPrecio() {
		return precio;
	}
	
	public boolean equals(Libro l){
		return referencia==l.getReferencia();
	}

	@Override
	public int compareTo(Libro o) {
		int resultado= 0;
		if(!autor.equalsIgnoreCase(o.getAutor())){
			resultado = autor.toUpperCase().compareTo(o.getAutor().toUpperCase());
		}else{
			resultado = titulo.toUpperCase().compareTo(o.getTitulo().toUpperCase());
		}
		return resultado;
	}
	
	
}
