import java.util.ArrayList;
import java.util.List;


public class Llave {
	
	public static final int MAX_ALTURA_DIENTE = 10;
	private List<Integer> dientes;
	
	public Llave( int numDientes){
		dientes = new ArrayList<Integer>();
		for(int i=0;i<numDientes;i++){
			dientes.add(new Integer(0));
		}
	}
	
	public void limarDiente(int diente, int altura) throws LyCException{
		if(MAX_ALTURA_DIENTE-altura<0){
			throw new LyCException("Alturo del diente no es valida");
		}else{
			dientes.set(diente, new Integer(MAX_ALTURA_DIENTE-altura));
		}
		
	}
	
	public int obtenerAltura(int diente) throws LyCException{
		try{
			return dientes.get(diente);
		}catch (Exception e) {
			throw new LyCException("el diento no es valido");
		}
		
	}
	
	public int numeroDeDientes(){
		return dientes.size();
	}
	
	public String toString(){
		return dientes.toString();	
	}
}
