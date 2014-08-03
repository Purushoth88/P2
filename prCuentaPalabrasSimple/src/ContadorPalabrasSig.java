import java.util.Scanner;


public class ContadorPalabrasSig extends ContadorPalabras{
	
	private String[] palNoSig;
	
	public ContadorPalabrasSig(int n, String[] palNoSig){
		super(n);
		this.palNoSig=palNoSig;
	}
	
	public ContadorPalabrasSig(String[] palNoSig){
		this.palNoSig=palNoSig;
	}
	
	@Override
	public void incluye(PalabraEnTexto p){
		boolean temSig=true;
		for(String pal: palNoSig){
			if ((pal.toUpperCase().equals(p.getPalabra().toUpperCase()))){
				temSig=false;
				break;
			}
		}
		
		if(temSig) super.incluye(p);
	}
	
	@Override
	public void incluyeTodas(String linea, String del){
		Scanner sc = new Scanner(linea);
		sc.useDelimiter(del);
		while(sc.hasNext()){
			this.incluye(new PalabraEnTexto(sc.next()));
		}
	}
	
	@Override
	public void incluyeTodas(String[] linea, String del){
		for(String l: linea){
			this.incluyeTodas(l, del);
		}
	}
	
}
