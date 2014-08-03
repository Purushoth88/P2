import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class DiccionarioDePalabras implements Diccionario<String, String> {

	private SortedMap<String,List<String>> dic;
	private String dicionarioFichero;

	public DiccionarioDePalabras(){
		dic = new TreeMap<String,List<String>>();
	}

	public DiccionarioDePalabras(String nombreFichero) throws FileNotFoundException{
		dic = new TreeMap<String,List<String>>();
		generarDic(nombreFichero);
	}

	private void generarDic(String nombreFichero) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(nombreFichero));
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			Scanner scLinea = new Scanner(line);
			scLinea.useDelimiter(":");
			while(scLinea.hasNext()){
				String clave = scLinea.next();
				String valores = scLinea.next();
				Scanner scValores= new Scanner(valores);
				scValores.useDelimiter(";");

				while (scValores.hasNext()) {
					insertar(clave, scValores.next());
				}		
			}
		}
	}
	
	@Override
	public void escribirDiccionario(String nombreFichero) throws FileNotFoundException{	
		PrintWriter print = new PrintWriter(nombreFichero);
		for(String clave : dic.keySet()){
			String salidaValor="";
			for (String valor : dic.get(clave)) {
				salidaValor+=valor+";";
			}
			
			print.println(clave+":"+salidaValor);
		}
		print.close();
	}
	
	@Override
	public boolean insertar(String c, String v) {
		boolean salida = false;
		if(c == null) throw new RuntimeException("La clave es null");
		else{
			if(!dic.containsKey(c)){
				List<String> valores = new ArrayList<String>();
				valores.add(v);
				dic.put(c, valores);
				salida = true;
			}else if(dic.containsKey(c) && !dic.get(c).contains(v)){
				dic.get(c).add(v);
			}
		}

		return salida;
	}

	@Override
	public List<String> consultar(String c) {
		if(dic.containsKey(c)){
			return dic.get(c);
		}else{
			return null;
		}

	}

	@Override
	public boolean eliminar(String c) {
		if(dic.containsKey(c)){
			dic.remove(c);
			return true;
		}else{
			return false;
		}

	}

	@Override
	public int tamano() {
		return dic.size();
	}

	@Override
	public void limpiar() {
		dic.clear();
	}

	@Override
	public Set<String> claves(){
		return dic.keySet();
	}

}
