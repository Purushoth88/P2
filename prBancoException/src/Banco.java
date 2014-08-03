import java.util.Arrays;

public class Banco {

	private static final int NCTAS = 10;
	private static final int NUMCTALIBRE = 1001;
	private String nombre;
	// Primera posicion libre
	private int ppl;
	// Primero numero de cuenta libre
	private int unca;
	private Cuenta[] ctas;

	public Banco(String nombre, int num_cuentas) {
		this.nombre = nombre;
		ctas = new Cuenta[num_cuentas];
		ppl = 0;
		unca = NUMCTALIBRE;
	}

	public Banco(String nombre) {
		this(nombre, NCTAS);
	}

	public int abrirCuenta(String titular, double value) {
		if (ppl == ctas.length) {
			doblarArrayCuentas();
		}
		int num_cuenta = unca;
		ctas[ppl] = new Cuenta(titular, unca, value);
		ppl++;
		unca++;
		return num_cuenta;
	}

	public int abrirCuenta(String titular) {
		return abrirCuenta(titular, 0);
	}

	private void doblarArrayCuentas() {
		Cuenta[] ctas_copy = new Cuenta[ppl * 2];
		System.arraycopy(ctas, 0, ctas_copy, 0, ppl);
		ctas = ctas_copy;
	}

	public void cerrarCuenta(int cuenta) throws BancoException {
		
		int posicion = posicionCuenta(cuenta);
		for (int i = posicion; i < ppl - 1; i++) {
			ctas[i] = ctas[i + 1];
		}
		ppl--;
	}
	

	private int posicionCuenta(int cuenta) throws BancoException {
		int posicion = 0;
		boolean check=false;
		for (Cuenta elem : ctas) {
			if (elem!=null && elem.cuenta() == cuenta){
				check=true;
				break;
			}
				
			posicion++;
		}
		if (!check)
			throw new BancoException("No existe la cuenta dada "+cuenta);
		else {
			return posicion;
		}
	}

	public void ingreso(int cuenta, double value) throws BancoException {
		int posicion = posicionCuenta(cuenta);
		
		try{
			ctas[posicion].ingreso(value);
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public double debito(int cuenta, double value) throws BancoException {
		int posicion = posicionCuenta(cuenta);
		double debito;
		Cuenta cta = ctas[posicion];
		if (cta.saldo() - value < 0) {
			debito = cta.saldo();
			cta.debito(cta.saldo());
		} else {
			debito = value;
			cta.debito(value);
		}
		return debito;
	}

	public double saldo(int cuenta) throws BancoException {
		return ctas[posicionCuenta(cuenta)].saldo();
	}

	public double transferencia(int cuenta_origen, int cuenta_destino,
			double value) throws BancoException {
		double debito = debito(cuenta_origen, value);
		ingreso(cuenta_destino, debito);
		return debito;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(ctas, 0, ppl));
	}

}
