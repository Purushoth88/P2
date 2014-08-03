import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import javax.xml.ws.handler.MessageContext.Scope;


public class Libraria  implements Comercio<Libro>{

	private Map<Seccion,SortedMap<Libro,Integer>> livraria;

	public Libraria(){
		livraria = new HashMap<Seccion,SortedMap<Libro,Integer>>();
	}

	public Libraria(String fichero) throws FileNotFoundException{
		livraria = new HashMap<Seccion,SortedMap<Libro,Integer>>();
		leerArquivo(fichero);
	}

	private void leerArquivo(String fichero) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(fichero));
		sc.useDelimiter("[:]+");
		while(sc.hasNextLine()){
			String secao = sc.next();
			String linha = sc.nextLine();

			criaLivro(secao,linha);

		}

	}

	private void criaLivro(String secao,String linha){
		Libro libro;
		Seccion seccion = Seccion.OpcoesMenu(secao);
		StringTokenizer stk = new StringTokenizer(linha,":");
		List<String> itensLibro = new ArrayList<String>();
		try{
			while(stk.hasMoreTokens()){

				String item = stk.nextToken();

				itensLibro.add(item);

			}

			if(itensLibro.size()==5){
				libro = new LibroRebajado(itensLibro.get(2), itensLibro.get(1), Integer.parseInt(itensLibro.get(0)), Double.parseDouble(itensLibro.get(3)), Integer.parseInt(itensLibro.get(4)));
			}else{
				libro = new Libro(itensLibro.get(2), itensLibro.get(1), Integer.parseInt(itensLibro.get(0)), Double.parseDouble(itensLibro.get(3)));
			}


		}catch (NumberFormatException e) {
			throw new LibroException("Formato invalido");
		}catch(NoSuchElementException e){
			throw new LibroException("Falta elementos");
		}



		if(!livraria.containsKey(seccion)){
			SortedMap<Libro,Integer> map = new TreeMap<Libro,Integer>();
			map.put(libro, 1);
			livraria.put(seccion,map);
		}else{
			if(livraria.get(seccion).containsKey(libro)){
				int valor = livraria.get(seccion).get(libro)+1;
				livraria.get(seccion).put(libro, valor);
			}else{
				livraria.get(seccion).put(libro, 1);
			}
		}



	}



	@Override
	public double compro(Libro objeto, Cliente c) {
		if(busca(objeto.getReferencia())!=null){
			return objeto.getPrecio()*(100-c.getDescuento());
		}else{
			throw new LibroException("Nao ha exemplares");
		}
	}

	public double compro(String titulo){
		if(libro(titulo)!=null){
			return libro(titulo).getPrecio();
		}else{
			throw new LibroException("Nao ha exemplares");
		}
	}


	public void nuevosEjemplares(Libro l,int n,Seccion s){
		if(!livraria.get(s).containsKey(l)){
			SortedMap<Libro,Integer> map = new TreeMap<Libro,Integer>();
			map.put(l, n);
			livraria.put(s, map);
		}else{
			SortedMap<Libro,Integer> map = new TreeMap<Libro,Integer>();
			int novoValor = livraria.get(s).get(l)+n;
			map.put(l, novoValor);
			livraria.put(s, map);
		}

	}

	
	public Seccion seccion(String t){
		Seccion sec = null;
		for(Seccion sc : livraria.keySet()){
			for(Libro l : livraria.get(sc).keySet()){
				if(l.getTitulo().equalsIgnoreCase(t)){
					sec = sc;
					break;
				}
			}		
		}
		return sec;
	}

	public Libro libro(String t){
		Libro libro = null;
		for(Seccion sec : livraria.keySet()){
			for(Libro l : livraria.get(sec).keySet()){
				if(l.getTitulo().equalsIgnoreCase(t)){
					libro = l;
					break;
				}
			}
		}

		return libro;
	}
	
	
	public Libro busca(int ref){
		Libro libro = null;
		for(Seccion sec : livraria.keySet()){
			for(Libro l : livraria.get(sec).keySet()){
				if(l.getReferencia()==ref){
					libro = l;
					break;
				}
			}
		}

		return libro;
	}

	@Override
	public  List<Libro> busca(String str){
		List<Libro> libro = new ArrayList<Libro>();
		for(Seccion sec : livraria.keySet()){
			for(Libro l : livraria.get(sec).keySet()){
				if(l.getAutor().toUpperCase().contains(str.toUpperCase())){
					libro.add(l);
				}
			}
		}

		return libro;
	}


	public SortedMap<Libro,Integer> inventario(){
		SortedMap<Libro,Integer> map = new TreeMap<Libro,Integer>();
		for(Seccion sc : livraria.keySet()){
			for(Libro l : livraria.get(sc).keySet()){
				if(map.containsKey(l)){
					map.put(l, map.get(l)+1);
					System.out.println("1"+l.getAutor());
				}else{
					map.put(l, 1);
					System.out.println("2"+l.getAutor());
				}
			}
		}
		return map;
	}

	public void  inventario(String fichero) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File(fichero));
		for(Libro l : inventario().keySet()){
			pw.println(l.getTitulo()+" "+inventario().get(l));
		}
		pw.close();
	}
	
	public void inventario(PrintWriter pw){
		for(Libro l : inventario().keySet()){
			pw.println(l.getTitulo()+" "+inventario().get(l));
		}
	}


//	public static void main(String[] args) throws FileNotFoundException {
//		Libraria libraria = new Libraria("txt/libros.txt");
//		//		for(Seccion s : libraria.livraria.keySet()){
//		//			System.out.println(s.toString());
//		//			for(Libro l : libraria.livraria.get(s).keySet()){
//		//				System.out.println("\t"+l.getTitulo()+" "+ libraria.livraria.get(s).get(l));
//		//			}
//		//		}
//
//
//
//		Libro libro1 = new Libro("lucas", "titulo", 123,1.5);
//		Libro libro2 = new Libro("lucas", "titulo", 123,1.5);
//		libraria.nuevosEjemplares(libro1, 2, Seccion.literatura);
//		libraria.nuevosEjemplares(libro2, 2, Seccion.literatura);
//		Map<Libro,Integer> map = libraria.inventario();
//
//		for(Libro l : map.keySet()){
//
//			System.out.println(l.getTitulo()+" "+map.get(l));
//
//		}
	}




