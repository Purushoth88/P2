package Practica23;

public abstract class Coche {
	String nombre;
	double price, iva;
	
	public Coche(String nombre,double price){
		this.nombre=nombre;
		this.price=price;
		iva=price*0.16;
	}
	
	
}
