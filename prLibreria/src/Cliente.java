
public class Cliente {
	
	private String nombre;
	private int dni, descuento;
	
	public Cliente(String nombre, int dni, int descuento){
		this.nombre=nombre;
		this.dni=dni;
		this.descuento=descuento;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getDni() {
		return dni;
	}

	public int getDescuento() {
		return descuento;
	}

	public Cliente (String nombre, int dni){
		this.nombre=nombre;
		this.dni=dni;
		descuento = 0;
	}
	
	public <T> double compra(String str, Comercio<T> c){
		double total = 0.0;
		for(T t : c.busca(str)){
			total+=c.compro(t, this);		
		}
		return total;
	}
	
	
}
