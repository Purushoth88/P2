
public class Solicitante implements Comparable<Solicitante> {
	
	private String nif,nombre;
	private double puntos;
	private boolean indicacion;
	
	public Solicitante(String nif, String nombre, double puntos){
		this.nif = nif;
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	public String toString(){
		return nif+" "+nombre+" "+puntos;
	}

	public boolean getTienePlaza() {
		return indicacion;
	}

	public void setTienePlaza(boolean indicacion) {
		this.indicacion = indicacion;
	}

	public String getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPuntos() {
		return puntos;
	}
	
	public boolean equals(Solicitante s1){
		return puntos==s1.getPuntos()&&nombre.equalsIgnoreCase(s1.getNombre());
	}

	@Override
	public int compareTo(Solicitante o) {
		int resultado = 0;
		if(puntos==o.getPuntos()){
			resultado = nombre.toUpperCase().compareTo(o.getNombre().toUpperCase());
		}else{
			Double pontos1= new Double(o.getPuntos());
			resultado = pontos1.compareTo(new Double(puntos));
		}
		
		return resultado;
	}
	
	
}
