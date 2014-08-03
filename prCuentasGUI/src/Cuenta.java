
public class Cuenta {
	private double saldo;
	
	public Cuenta(double si) {
		saldo = Math.max(0, si);
	}
	
	public void ingresa(double ing) {
		saldo += ing;
	}
	
	public double extrae(double extrae) {
		double realExtrae = extrae;
		if (saldo < extrae) {
			realExtrae = saldo;
		saldo = 0;
		} else {
			saldo -= realExtrae;
		}
	return realExtrae;
	}
	
	public double saldo() {
		return saldo;
	}
}
