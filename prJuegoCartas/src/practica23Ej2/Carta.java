package practica23Ej2;

public class Carta {
	
	public static enum Palo {CORAZON, DIAMANTE,TREBOL,PICA};
	
	private  static String nombreCarta;
	private String[]nombres={"AS","2","3","4","5","6","7","8","9","10","J","Q","k"};
	private  int valor;
	private  Palo palo;
	
	public Carta(int v, Palo palo){
		valor=v;
		this.palo=palo;
		nombreCarta=nombres[v-1];
	}
	
	public String palo(){
		return palo.name();
	}
	
	public int valor(){
		return valor;
	}
	
	public String toString(){
		return nombres[valor()-1]+" - "+palo();
	}
}
