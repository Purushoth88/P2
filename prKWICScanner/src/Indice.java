import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.ProxySelector;
import java.util.*;


public class Indice {
	
	protected SortedMap<String, SortedSet<Titulo>> kwic;
	protected String separadores, ruta;
	
	public Indice(String sep){
		if(sep == null || sep.isEmpty()) throw new IllegalArgumentException();
		
		separadores = sep;
		kwic = new TreeMap<String, SortedSet<Titulo>>();
	}
	
	
	public Indice(String sep, String ruta) throws FileNotFoundException{
		this(sep);
		this.ruta = ruta;
		Scanner sc = new Scanner( new File(ruta));
		agregarTitulo(sc);
	}
	
	
	public void agregarTitulo(String t){
		Scanner sc = new Scanner(t);
		sc.useDelimiter(separadores);
		while(sc.hasNext()){
			String palabra = sc.next();
			if(kwic.containsKey(palabra)){
				kwic.get(palabra).add(new Titulo(t));
			}else{
				SortedSet<Titulo> set = new TreeSet<Titulo>();
				Titulo titulo = new Titulo(t);
				set.add(titulo);
				kwic.put(palabra, set);
			}
		}
		sc.close();
	}
	
	
	public void agregarTitulo(Scanner sc){
		if(sc==null) throw new IllegalArgumentException("Colecion null");
		
		while(sc.hasNextLine()){
			String sa = sc.nextLine();
			agregarTitulo(sa);
			
			
		}
			
		
	}
	
	public void presentaIndice(String ruta) throws FileNotFoundException{
		try {
			presentaIndice(new PrintWriter(ruta));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Fichero no encontrado");
			
		}
	}
	
	public void presentaIndice(PrintWriter print){
		String salida ="";
		for(String ind : kwic.keySet()){
			if(kwic.containsKey(ind)){
				salida+=ind.toUpperCase()+"\n";
				for(Titulo t: kwic.get(ind)){
					salida+="\t"+t.replace(ind)+"\n";
				}
				
			}
		}
		print.println(salida);
		print.close();
	}
	
}
