package practica23Ej2;

import java.util.Arrays;

public abstract class Mano {
	private  int numCartas;
	private  final static int TOPE=20;
	protected  Carta[] mano;
	
	Mano(){
		numCartas=0;
		mano= new Carta[TOPE];
	}
	
	Mano(int v){
		numCartas=0;
		mano= new Carta[v];
	}
	
	public int numeroCartas(){
		return numCartas;
	}
	
	public void agnadeCarta(Carta c){
		
		if(numCartas<mano.length){
			mano[numCartas]=c;
			numCartas+=1;
		}else{
			throw new RuntimeException("mano llenada");
		}
	}
	
	
	public void descartaTodas(){
		numCartas=0;
		int originalSize=mano.length;
		mano= new Carta[originalSize];
	}
	
	public String toString(){
		String saida="[";
		for(int i=0; i<mano.length && mano[i]!=null;i++){
			saida+= mano[i].toString()+" | ";
		}
		return saida+"]";
	}

	public abstract double cuentaPuntos();
}
