package practica23Ej2;

import java.util.Arrays;

public class ManoBacarra extends Mano{
	
	public ManoBacarra(){
		super(3);
	}

	@Override
	public double cuentaPuntos() {
		double soma=0.0;
		
		if(this.numeroCartas()>0){
			Carta[] mano= Arrays.copyOf(this.mano, this.mano.length);
			
			for(int i=0; i<mano.length && mano[i]!=null;i++){
				if(mano[i].valor()>=1 && mano[i].valor()<=9) soma+=mano[i].valor();
				else soma+=0.0;
			}
		}
		
		return soma%10;
	}
	
	public boolean esNatural(){
		if(cuentaPuntos()==9 || cuentaPuntos()==8) return true;
		else return false;
	}

}
