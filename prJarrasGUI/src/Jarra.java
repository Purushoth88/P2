
public class Jarra {
	private int capacidad;
	private int cantidad;

	public Jarra(int capacidad) throws JarraCapacidadException{
		if(capacidad<=0){
			throw new JarraCapacidadException();
		}
		this.capacidad = capacidad;
		cantidad = 0;
	}

	public void llena() {
		cantidad = capacidad;
	}

	public void vacia() {
		cantidad = 0;
	}

	public int capacidad() {
		return capacidad;
	}

	public int cantidad() {
		return cantidad;
	}

	public void llenadaDesde(Jarra jarra) {
		int cuantidadMaximaLlenada = capacidad - cantidad;
		if (cantidad < capacidad) {
			if (jarra.cantidad() <= cuantidadMaximaLlenada) {
				cantidad += jarra.cantidad();
				jarra.vacia();
			} else {
				cantidad = capacidad;
				jarra.cambiaCantidad(jarra.cantidad() - cuantidadMaximaLlenada);
			}
		}
	}

	private void cambiaCantidad(int nuevaCantidad) {
		if (nuevaCantidad <= capacidad)
			cantidad = nuevaCantidad;
		else
			System.out.println("Cantidad Indevida");
	}

	public String toString() {
		String salida = "Capacidad: " + capacidad + " / Cantidad: " + cantidad;
		return salida;
	}

}