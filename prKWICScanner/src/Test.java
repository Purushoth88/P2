import java.io.*;

public class Test {

	public static void main(String[] args) {

		String separadores = "[ ,;.:\\(\\)\\¿\\!\\¡\\?]+";
		//String separadores = " ,;.:()¿!¡?";

		try {
			Indice index = new Indice(separadores, "frases.txt");
			// para presentar por pantalla
			PrintWriter pw = new PrintWriter(System.out, true);
			index.presentaIndice(pw);
			// para guardar en fichero
			index.presentaIndice("salida.txt");

			// Ahora con palabrasNoSignificativas
			IndiceSignificativas indexSig = new IndiceSignificativas(
					separadores, "frases.txt", "noClaves.txt");
			// para presentar por pantalla
			indexSig.presentaIndice(pw);

			// para guardar en fichero
			indexSig.presentaIndice("salidaNoSig.txt");
		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
}
