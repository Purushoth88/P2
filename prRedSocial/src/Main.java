import java.io.IOException;
import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {
		try {
			RedSocial r = new RedSocial("C:\\Users\\Lucas\\workspace\\prRedSocial\\src\\redsocial.txt");
			Persona ana = r.emailPersona("wong@correo.com");
			ArrayList<String> amigos = new ArrayList<String>();
			amigos.add("brandon@correo.com");
			r.anadirAmigo(r.emailPersona("wong@correo.com"), amigos);
			//r.eliminarAmigos(r.emailPersona("wong@correo.com"), amigos);
			for(String a : r.buscarPersonasAficion(ana).keySet()){
				System.out.println(a);
				for(Persona p : r.buscarPersonasAficion(ana).get(a)){
					System.out.println("\t"+p.toString());
				}
			}
			
			System.out.println(r.amigos(r.emailPersona("wong@correo.com")).size());
		
			
						
		} catch (RedSocialException e) {
			System.out.println("ERROR: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR en Entrada/Salida: " + e.getMessage());
		}		
	}
}
