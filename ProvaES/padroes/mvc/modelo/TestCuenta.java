package mvc.modelo;

public class TestCuenta {
	public static void main(String[] args) {
		Cuenta c1 = Cuenta.instancia();
		Cuenta c2 = Cuenta.instancia();
		
		System.out.println("SALDO C1:"+c1.saldo());
		System.out.println("SALDO C2:"+c2.saldo());
		c1.ingresa(1000);
		System.out.println("SALDO C1:"+c1.saldo());
		System.out.println("SALDO C2:"+c2.saldo());
		c2.extrae(500);
		System.out.println("SALDO C1:"+c1.saldo());
		System.out.println("SALDO C2:"+c2.saldo());
		System.out.println(c2==c1);
	}
}
