package practica23Ej2;

import java.util.Arrays;

public class ManoSieteyMedia extends Mano {
	
	
	@Override
	public double cuentaPuntos() {
		
		double soma=0.0;
		
		if(this.numeroCartas()>0){
			Carta[] mano= Arrays.copyOf(this.mano, this.mano.length);
			
			for(int i=0; i<mano.length && mano[i]!=null;i++){
				
				if(mano[i].valor()>=1 && mano[i].valor()<=7) soma+=mano[i].valor();
				if(mano[i].valor() >= 8 && mano[i].valor()<=10) soma+= 0.0;
				if(mano[i].valor()>=11 && mano[i].valor()<=13) soma +=0.5;
			}
		}
		
		return soma;
	}
}
