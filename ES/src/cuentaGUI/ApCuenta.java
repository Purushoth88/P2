package cuentaGUI;

/*******************************************************************************
 * Aplicación de consola
 ******************************************************************************/

public class ApCuenta {
	public static void main(String args[]) {
		Cuenta cuenta = new Cuenta(Double.parseDouble(args[0]));
		cuenta.ingresa(3000);
		double realExt = cuenta.extrae(6000);

		System.out.println("Saldo     = " + cuenta.saldo());
		System.out.println("Extraido  = " + realExt);
	}
}
