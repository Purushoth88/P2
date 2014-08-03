
public class TestLlaves {
	public static void main(String[] args) {
		try{
			Llave l = new Llave(3);
			Cerradura c = new Cerradura(3);
			Cerradura cc = new Cerradura(3);
			Cerradura ccc = new Cerradura(2);
			l.limarDiente(2, 4);
			l.limarDiente(1, 3);
			l.limarDiente(0, 8);
			System.out.println("Llave "+l);
			c.agregarMarca(0, 8);
			c.agregarMarca(1, 3);
			c.agregarMarca(2, 4);
			System.out.println("Cerradura 1 "+c);
			cc.agregarMarca(0,3);
			cc.agregarMarca(2,9);
			cc.agregarMarca(0,8);
			cc.agregarMarca(1,3);
			cc.agregarMarca(2,4);
			System.out.println("Cerradura 2 "+cc);
			ccc.agregarMarca(0,2);
			ccc.agregarMarca(0,5);
			ccc.agregarMarca(1,9);
			System.out.println("Cerradura 3 "+ccc);
			System.out.println("¿Encaja la llave con a cerradra 1? "+c.adrir(l));
			System.out.println("¿Encaja la llave con a cerradra 2? "+cc.adrir(l));
			System.out.println("¿Encaja la llave con a cerradra 3? "+ccc.adrir(l));
			
		}catch (LyCException e) {
			e.getMessage();
		}
	}
}
