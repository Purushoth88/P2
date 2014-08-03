import java.util.List;


public class Persona implements Comparable<Persona>{
	
	private String nome,correo;
	private int edad;
	private List<String> aficiones;
	
	public Persona(String nombre,String correo, int edad, List<String> aficiones){
		
		if(edad<0 || aficiones.isEmpty()){
			throw new RedSocialException("Parametros de persona invalidos");
		}else{
			nome = nombre;
			this.edad = edad;
			this.aficiones = aficiones;
			this.correo = correo;
		}
	}
	
	public String toString(){
		return nome+" "+edad+" "+"("+correo+")";
	}

	public String getNome() {
		return nome;
	}

	public String getCorreo() {
		return correo;
	}


	public int getEdad() {
		return edad;
	}

	public List<String> getAficiones(){
		return aficiones;
	}

	@Override
	public int compareTo(Persona o) {
		int resultado = 0;
		if(correo!=o.getCorreo()){
			resultado = correo.compareTo(o.getCorreo());
		}else{
			resultado = nome.compareTo(o.getNome());
		}
		
		return resultado;
	}
	
	public boolean equals(Persona p){
		return nome.equalsIgnoreCase(p.getNome())&& correo.equals(p.getCorreo());
	}

	
	
	
	
	
}
