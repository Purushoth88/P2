package practica23Ej1;


public class Coche {
	public  String nombre;
	private  double precio;
	private  static double PIVA;
	
	public Coche(String n, double p){
		nombre=n;
		precio=p;
		PIVA=0.16;
	}
	
	public static void setPiva(double i){
		PIVA=i;
	}
	
	public double precioTotal(){
		return precio + precio*PIVA;
	}
	
	public String nombre(){
		return nombre;
	}
	
	public String toString(){
		return nombre + " -> " + precioTotal();
	}
}
