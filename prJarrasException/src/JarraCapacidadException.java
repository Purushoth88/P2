
public class JarraCapacidadException extends RuntimeException {
	
	public JarraCapacidadException(){
		super("La capacidad no es valida");
	}
	
	public JarraCapacidadException(String msg){
		super(msg);
	}
}
