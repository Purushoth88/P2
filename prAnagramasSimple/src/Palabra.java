import java.util.Arrays;


public class Palabra implements Comparable<Palabra>{
	private String palabra,signatura;
	
	public Palabra(String palabra){
		this.palabra=palabra.toLowerCase();
		char[] aux = palabra.toCharArray();
		Arrays.sort(aux);
		signatura = new String(aux);
	}
	
	public String getSignatura(){
		return signatura;
	}
	
	public String getPalabra(){
		return palabra;
	}
	
	public int hasCode(){
		return palabra.hashCode();
	}
	
	
	public boolean equals(Object p){
		return (p instanceof Palabra) && (palabra.equals(((Palabra) p).palabra));
	}
	
	public String toString(){
		return palabra;
	}
	
	public boolean esAnagrama(Palabra p) {
		return signatura.equals(p.signatura);
	}

	@Override
	public int compareTo(Palabra o) {
		return palabra.compareTo(o.getPalabra());
	}

}
