import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;




public class Cerradura {

	public static final int MAX_MARCAS_POR_ANCLAJE = 4;
	private List<Set<Integer>> anclajes;


	public Cerradura(int numAnclajes){
		anclajes = new ArrayList<Set<Integer>>();
		for(int i=0; i<numAnclajes;i++){
			anclajes.add(new HashSet<Integer>());
		}
	}

	public void agregarMarca(int anclaje, int marca) throws LyCException{
		
		if(0<=marca && marca<=10){
			try{
				anclajes.get(anclaje).add(marca);
			}catch (Exception e) {
				throw new LyCException("Anclaje no es valida");
			}
		}
		else throw new LyCException("Marca no es valida");
	}

	public boolean adrir(Llave llave) throws LyCException{
		boolean apertura = true;

		if(anclajes.size()==llave.numeroDeDientes()){
			for(int i = 0; i<anclajes.size() && apertura; i++){
				apertura = encajaDienteAnclaje(llave.obtenerAltura(i), anclajes.get(i));			
			}
		}else{
			apertura=false;
		}
		return apertura;
	}

	
	private static boolean encajaDienteAnclaje(int altura, Set<Integer> anclaje){
		boolean encaja = false;
		Iterator<Integer> marcas = anclaje.iterator();
		while (marcas.hasNext() && !encaja) {
			if(altura+marcas.next()==10) encaja=true;
		}
		
		return encaja;
	}
	
	public String toString(){
		String saida = "";
		for (int i=0;i<anclajes.size();i++){
			saida+=anclajes.get(i).toString()+" ";
		}
		
		return saida;
	}

}
