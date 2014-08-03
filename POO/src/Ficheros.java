import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;


public class Ficheros {
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("datos.txt");
		pw.println("Hello Wordl!");
		pw.close();
	}
}
