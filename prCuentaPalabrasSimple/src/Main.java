import java.util.NoSuchElementException;

public class Main {
	public static void main(String [] args) {
		String [] datos = {	
			"Guerra tenía una jarra y Parra tenía una perra, ",
			"pero la perra de Parra rompió la jarra de Guerra.",
			"Guerra pegó con la porra a la perra de Parra. ",
			"¡Oiga usted buen hombre de Parra! ",
			"Por qué ha pegado con la porra a la perra de Parra.",
			"Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
			"Guerra no hubiera pegado con la porra a la perra de Parra."};
		// Quitar el comentario según se use Scanner o StringTokenizer
		 String delimitadores = "[ .,:;\\-\\!\\¡\\¿\\?]+";    // Para Scanner
		// String delimitadores = " .,:;-!¡¿?";                 // Para StringTokenizer 
		String [] noSig = {"CON", "LA", "A", "DE", "NO", "SI", "Y", "UNA"};
		ContadorPalabras contador = null, contadorSig = null;
		// Si no se incluye un argumento numérico, se crea por defecto.
		try {
			int n = Integer.parseInt(args[0]);
			System.out.println("Con argumento " + n);
			contador = new ContadorPalabras(n);
			contadorSig = new ContadorPalabrasSig(n, noSig);
		} catch (RuntimeException e) {
			System.out.println("Por defecto...");
			contador = new ContadorPalabras();
			contadorSig = new ContadorPalabrasSig(noSig);
		}
		// Incluimos todas las palabras que hay en datos 
		// teniendo en cuenta los delimitadores
		contador.incluyeTodas(datos, delimitadores);
		contadorSig.incluyeTodas(datos, delimitadores);
		
		System.out.println(contador + "\n");
		
		System.out.println(contadorSig + "\n");
		
		try {
			System.out.println(contador.encuentra("parra"));
			System.out.println(contador.encuentra("Gorra"));
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
	}
}

