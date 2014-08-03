import java.util.Comparator;


public class OrdemPersona implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		int resulado = 0;
		if(!o1.equals(o2.getNome())){
			resulado = o1.getNome().compareTo(o2.getNome());
		}else{
			Integer id1 = new Integer(o1.getEdad());
			Integer id2 = new Integer(o2.getEdad());
			resulado = id1.compareTo(id2);
		}
		
		return resulado;
	}

}
