import java.io.*;


public class TestDiccionario {

	public static void main(String[] args) throws IOException{
		Diccionario<String, String> dic = new DiccionarioDePalabras("datos.txt");

		System.out.println(dic.claves());
		System.out.println(dic.insertar("feo", "Horroroso"));
		System.out.println(dic.consultar("feo"));
		System.out.println(dic.consultar("arco"));
		System.out.println(dic.eliminar("arco"));
		System.out.println(dic.consultar("costal"));
		System.out.println(dic.insertar("costal", "Listón de madera"));
		System.out.println(dic.consultar("costal"));
		System.out.println(dic.tamano());
		System.out.println(dic.consultar("bombín"));
		System.out.println(dic.claves());
		System.out.println(dic.eliminar("feo"));
		System.out.println(dic.eliminar("feo"));
		System.out.println(dic.claves());
		dic.escribirDiccionario("dic.txt");
		dic.limpiar();
		System.out.println(dic.tamano());

	}
}
