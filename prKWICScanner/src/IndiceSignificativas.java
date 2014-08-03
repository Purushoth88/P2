
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;

import java.util.Scanner;

import java.util.SortedSet;

import java.util.TreeSet;


public class IndiceSignificativas extends Indice{

	private SortedSet<String> noSignificativas;

	public IndiceSignificativas(String sep, String ficheroNoSig) throws FileNotFoundException{
		super(sep);
		noSignificativas = new TreeSet<String>();
		Scanner sc = new  Scanner(new File(ficheroNoSig));
		sc.useDelimiter(sep);
		while(sc.hasNext()){
			String pal = sc.next();
			
			noSignificativas.add(pal.toLowerCase());
		}	

	}

	public IndiceSignificativas(String sep,String ficheroEntrada, String ficheroNoSig) throws FileNotFoundException{
		this(sep,ficheroNoSig);
		agregarTitulo(new Scanner(new File(ficheroEntrada)));

	}


	@Override
	public void agregarTitulo(String titulo){
		
		Scanner sc = new Scanner(titulo);
		sc.useDelimiter(separadores);
		
		while(sc.hasNext()){
			String pal = sc.next();
			
			if(!noSignificativas.contains(pal) && kwic.containsKey(pal)){
				
				kwic.get(pal).add(new Titulo(titulo));
			}else if(!noSignificativas.contains(pal) && !kwic.containsKey(pal)){
				SortedSet<Titulo> set = new TreeSet<Titulo>();
				Titulo tit = new Titulo(titulo);
				set.add(tit);
				kwic.put(pal, set);
			}
		}

	}
	
	public void palabrasNoSignificativas(String pal){
		noSignificativas.add(pal);
	}
	
	public void palabrasNoSignificativas(Scanner sc){
		while (sc.hasNextLine()) {
			String frase = sc.nextLine();
			Scanner sc2= new Scanner(frase);
			while(sc2.hasNext()){
				palabrasNoSignificativas(sc2.next());
			}
			sc2.close();
			
		}
		sc.close();
	}

}



