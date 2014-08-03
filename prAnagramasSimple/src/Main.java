

public class Main {
	public static void main(String [] args) {
		// Con el orden natural
		System.out.println("Orden natural");
		Anagrama an1 = new Anagrama();
		for(String arg : args) {
			an1.nuevaPalabra(arg);
		}
		an1.mostrarEnConsola();
		// Con un orden alternativo
		System.out.println();
		System.out.println("Orden alternativo");
		Anagrama an2 = new Anagrama(new SatPalabra());
		for(String arg : args) {
			an2.nuevaPalabra(arg);
		}
		an2.mostrarEnConsola();
	}

}


