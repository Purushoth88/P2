package Estudando;

import java.util.*;

public class ParNumerico {
	
	public <T> void hello(Par<?> a1, Par<?> a2){
		System.out.println("helo");
	}
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		lista.add("a");
		lista.add("j");
		lista.add("z");
		lista.add("e");
		Collections.sort(lista);
		for(String s: lista){
			System.out.println(s);
		}
		
		Par<String> par = new Par<String>();
		Par<Character> par2 = new Par<Character>();
		
		ParNumerico p = new ParNumerico();
		p.hello(par2,par);
	}

	
}
