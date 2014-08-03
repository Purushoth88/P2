import java.util.Random;


public class Urna {
	
	private enum ColorBola {BLANCA,NEGRA};
	private int blancas=0;
	private int negras=0;
	private static Random ale;
	
	public Urna(int b, int n) throws RuntimeException{
		if(b < 0 || n < 0){
			throw new RuntimeException();
		}else{
			blancas=b;
			negras= n;
		}
	}
	
	public int totalBolas(){
		return blancas+negras;
	}
	
	public void ponerBlancas(){
		blancas+=1;
	}
	
	public void ponerNegras(){
		negras+=1;
	}
	
	public ColorBola extraerBola(){
		ale= new Random();
		if(ale.nextInt(totalBolas()+1)<= blancas){
			blancas-=1;
			return ColorBola.BLANCA;
		}else{
			negras-=1;
			return ColorBola.NEGRA;
		}
	}
}
