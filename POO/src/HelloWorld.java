import java.util.Arrays;
import java.util.Scanner;


public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int v=1;
		Boolean b = false;
		Boolean bb= new Boolean(false);
		System.out.println(b.booleanValue());
		System.out.println(b);
		
	System.out.printf("Meu nome: %10s tenho %2d variacao de %1.3f", "Lucas Albuquerque de Almeida",399999999, 568.769590);
	System.out.println("\nDigite os dados: ");
	Scanner sc = new Scanner(System.in);
	String nome = sc.next();
	int idade= sc.nextInt();
	System.out.println("\ndados lidos: ");
	System.out.println(nome+idade);
	sc.close();
	}

}
