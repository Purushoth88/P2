package cuentaGUI;
public class Cuenta {
	
	private double saldo;

	public Cuenta(double valor) {
		saldo=valor;
	}

	public void ingresa(double i) {
		saldo+=i;
		
	}

	public double extrae(double extrae) {
		double salida;
		
		if(extrae>saldo){
			salida=saldo;
			saldo=0.0;
			
		}else{
			saldo-=extrae;
			salida=extrae;
		}
		return salida;
	}

	public double saldo() {
		return saldo;
	}
	
	

}
