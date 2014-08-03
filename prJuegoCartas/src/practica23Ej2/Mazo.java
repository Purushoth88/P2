package practica23Ej2;


import java.util.Arrays;
import java.util.Random;

public class Mazo {
	private static int numCartas;
	private  static Random alea=new Random();
	private  Carta[] mazo;

	
	
	public Mazo(){
		mazo = new Carta[52];
		numCartas=0;
		for(int valor=1;valor<=13 && numCartas<52;valor++){
			for(Carta.Palo p: Carta.Palo.values()){
				Carta c= new Carta(valor,p);
				mazo[numCartas++]=c;
			}
		
		}
		
		baraja();
	}
	
	public int numeroCartas(){
		return numCartas+1;
	}
	
	
	public void baraja(){
		for(int i=0;i<mazo.length;i++){
			int cambio=alea.nextInt(52);
			Carta temp=mazo[i];
			mazo[i]=mazo[cambio];
			mazo[cambio]=temp;	
		}
	}
	
	
	public Carta daCarta() {
		Carta carta;
		int posicao;
		if(numCartas>0){
				
			//selecionando uma carta aleatoria
			posicao=(alea.nextInt(numCartas));
			carta=mazo[posicao];
			
			mazo[posicao]=null;
			numCartas--;
			//Atualizando o mazo
			int contador = 0; //insere na posicao
			Carta[] mazoTemp=Arrays.copyOf(mazo,mazo.length); //faz uma copia temporaria
			mazo= new Carta[numCartas]; //reinicializa o mazo
			for(int valor=0;valor<mazoTemp.length;valor++){
				if(mazoTemp[valor]!=null){
					mazo[contador]=mazoTemp[valor];
					contador+=1;
				}
			}	
			
			
			return carta;

		}else{
			throw new RuntimeException("No hay cartas");
		}	
		
	}
	
}