package testes;

public class Cuenta {
	private double saldo;
	
	public Cuenta(double si){
		
			saldo = Math.max(0, si);
		
		
	}
	
	public void ingresa(double ing) throws CuentaExpection {
		if(ing >=0)
			saldo += ing;
		else
			throw new CuentaExpection("Valor invalido");
	}
	
	public double extrae(double extrae) throws CuentaExpection {
		if(extrae >= 0.0){
			double realExtrae = extrae;
			
			if (saldo < extrae) {
				realExtrae = saldo;
			saldo = 0;
			} else {
				saldo -= realExtrae;
			}
			return realExtrae;
		}else{
			throw new CuentaExpection("Valor de extrair tem que ser maior que zero");
		}
		
	
	}
	
	public double saldo() {
		return saldo;
	}
}
