
public class PalabraEnTexto {
	
	private String palabra;
	private int num;
	
	public PalabraEnTexto(String palabra){
		this.palabra=palabra;
		num=1;
	}
	
	public String getPalabra(){
		return palabra;
	}
	
	@Override
	public boolean equals(Object o){
		return ((PalabraEnTexto)o).getPalabra().toUpperCase().equals(getPalabra().toUpperCase());
	}
	
	public int hasCode(){
		return palabra.toUpperCase().hashCode()+1;
	}
	
	public void incrementa(){
		num+=1;
	}
	
	@Override
	public String toString(){
		return palabra+" "+num;
	}
}
