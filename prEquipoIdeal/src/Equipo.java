
public class Equipo implements Comparable<Equipo> {
	
	private String nombre;
	private int votos;
	
	public Equipo(String nombre, int votos){
		this.nombre = nombre;
		this.votos = votos;
	}
	
	@Override
	public String toString(){
		return nombre+" "+votos;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	public boolean equals(Equipo eq){
		return this.nombre.toUpperCase().equals(eq.nombre.toUpperCase()) && this.votos==eq.votos;
	}

	@Override
	public int compareTo(Equipo o) {
		int resultado = 0;
		if(this.votos!=o.votos){
			Integer votos2= new Integer(o.votos);
			resultado = votos2.compareTo(new Integer(this.votos));
		}else{
			resultado = this.nombre.toUpperCase().compareTo(o.nombre.toUpperCase());
		}
		
		return resultado;
	}
}
