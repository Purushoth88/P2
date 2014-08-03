import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ContadorPalabras {
	
	private PalabraEnTexto[] palabras;
	private final int TAMANO_ARRAY=10;
	private int contador;
	
	public ContadorPalabras(){
		palabras= new PalabraEnTexto[TAMANO_ARRAY];
		contador=0;
	}
	
	public ContadorPalabras(int tamano){
		palabras= new PalabraEnTexto[tamano]; 
		contador=0;
	}
	
	private int esta(PalabraEnTexto p){
		int posicion=-1;
		for(int i=0;i<palabras.length && palabras[i]!=null;i++){
			if(p!=null && palabras[i].equals(p)){
				posicion=i; 
				break;
			}
		}
		
		return posicion;
	}
	
	public void incluye(PalabraEnTexto p){
		if(esta(p)!=-1){
			palabras[esta(p)].incrementa();
		}else{
			if(palabras.length<=contador){
				palabras = Arrays.copyOf(palabras, palabras.length+TAMANO_ARRAY);
				palabras[contador]=p;
				contador++;
			}else{
				palabras[contador]=p;
				contador++;
			}
		}
	}
	
	
	public void incluyeTodas(String linea, String del){
		Scanner sc = new Scanner(linea);
		sc.useDelimiter(del);
		while(sc.hasNext()){
			incluye(new PalabraEnTexto(sc.next()));
		}
	}
	
	
	public void incluyeTodas(String[] linea, String del){
		for(String l: linea){
			incluyeTodas(l, del);
		}
	}
	
	
	public PalabraEnTexto encuentra(String pal){
		for(PalabraEnTexto palavra:palabras){
			if(palavra!=null && palavra.equals(new PalabraEnTexto(pal))) return palavra;
		}
		throw new NoSuchElementException("No existe la palabra "+pal);
	}
	
	@Override
	public String toString(){
		StringBuilder salida= new StringBuilder("[");
		for(PalabraEnTexto pal : palabras){
			if(pal!=null) salida.append(pal.toString()+", ");
		}
		salida.replace(salida.lastIndexOf(", "), salida.length()-1, "]");
		
		return salida.toString();
	}
	
}
