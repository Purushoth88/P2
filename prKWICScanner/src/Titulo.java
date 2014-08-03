
public class Titulo implements Comparable<Titulo>{
	
	private String titulo;
	
	public Titulo(String titulo){
		this.titulo = titulo;
	}
	
	public String replace(String pal){
		StringBuilder res= new StringBuilder(titulo);
		String resAux = res.toString().toUpperCase();
		
		int indice = resAux.indexOf(pal.toUpperCase());
		while(indice >= 0){
			res.replace(indice, indice +pal.length(), "...");
			resAux = res.toString().toUpperCase();
			indice = resAux.indexOf(pal.toUpperCase(),indice+1);
		}
		
		return res.toString();
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Titulo){
			return ((Titulo) o).titulo.toLowerCase().equals(titulo.toLowerCase());
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return titulo.hashCode() + titulo.length();
	}	

	public int compareTo(Titulo t) {
		return titulo.compareTo(t.titulo);
	}

}
