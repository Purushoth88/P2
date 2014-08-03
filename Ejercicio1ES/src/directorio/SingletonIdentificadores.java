/**
 * Clase que sigue el patron singleton para crear identificadores unicos de
 * tipo long. Para ello usa un contadador id_, que es incrementado en una 
 * unidad cada vez que se solicita un identificador en el metodo 
 * obtenerIdentificador()
 */

package directorio;

import java.util.Random;

public class SingletonIdentificadores {

	private static SingletonIdentificadores identificador;
	private long id;
	
	private SingletonIdentificadores(){
		id=0;
	}
	
	
	public long obtenerIdentificador() {
		return ++id;
	}

	public static SingletonIdentificadores Instancia() {
		if(identificador==null){
			identificador= new SingletonIdentificadores();
		}
		
		return identificador;
	}
  
}
