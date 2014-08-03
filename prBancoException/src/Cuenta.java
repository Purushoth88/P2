public class Cuenta {

	private String titular;
	private double saldo;
	private int cuenta;

	public Cuenta(String titular, int cuenta, double saldo) throws IllegalArgumentException{
		if(saldo<0){
			throw new IllegalArgumentException("Saldo no es valido");
		}else{
			this.titular = titular;
			this.cuenta = cuenta;
			this.saldo = saldo;

		}
	}

	public Cuenta(String titular, int cuenta) {
		this(titular, cuenta, 0);
	}

	public void ingreso(double value) throws IllegalArgumentException {
		if(value < 0){
			throw new IllegalArgumentException("Value no puede ser negativo");
		}else{
			saldo += value;
		}
		
	}

	public void debito(double value) {
		saldo -= value;
	}

	public String titular() {
		return titular;
	}

	public double saldo() {
		return saldo;
	}

	public int cuenta() {
		return cuenta;
	}

	@Override
	public String toString() {
		return "[(" + titular + "/" + cuenta + ")" + " -> " + saldo + "]";
	}

}
