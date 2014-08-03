
public class Jugador implements Comparable<Jugador> {
	
	public enum Demarcacion{PORTERIA,DEFENSA,CENTRO,ATAQUE}
	
	private String nombre,demarcacion;
	private int valoracion;
	private boolean indicacion;
	
	public Jugador(String nombre, String demarcacion, int valoracion){
		this.demarcacion = demarcacion;
		this.nombre = nombre;
		this.valoracion = valoracion;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getDemarcacion(){
		return demarcacion;
	}
	
	public boolean getElegido(){
		return indicacion;
	}
	
	public void setElegido(boolean elegido){
		indicacion = elegido;
	}
	
	public boolean equals(Jugador jogador){
		return nombre.toUpperCase().equals(jogador.getNombre().toUpperCase())&& 
				valoracion==jogador.valoracion && 
				demarcacion.toUpperCase().equals(jogador.getDemarcacion().toUpperCase());
		
	}
	
	
	
	
	
	
	
	@Override
	public String toString(){
		return nombre+" "+demarcacion+" "+valoracion;
	}

	@Override
	public int compareTo(Jugador o) {
		int resultado = 0;
		if(this.getDemarcacion()!=o.getDemarcacion()){
			resultado = o.getDemarcacion().toUpperCase().compareTo(this.getDemarcacion().toUpperCase());
		}else if(this.getDemarcacion()==o.getDemarcacion()){
			if(valoracion==o.valoracion){
				resultado = getNombre().compareTo(o.getNombre());
			}else{
				Integer valoricacao2 = new Integer(o.valoracion);
				resultado= valoricacao2.compareTo(new Integer(valoracion));
			}	
		}
		
		return resultado;
	}
	
}

