import java.util.*;


public class Anagrama {
	
	private Map<Palabra,Set<Palabra>> mapa;

	
	
	public Anagrama(){
		mapa = new TreeMap<Palabra, Set<Palabra>>();
	}
	
	public Anagrama(SatPalabra sat){
		mapa = new TreeMap<Palabra, Set<Palabra>>(sat);
	}
	
	public void nuevaPalabra(String obj){
		Palabra p = new Palabra(obj);
		if(!mapa.containsKey(p)){
			Set<Palabra> anagramas = new TreeSet<Palabra>();
			mapa.put(p, anagramas);
			for(Palabra pal: mapa.keySet()){
				if(p.esAnagrama(pal) && !p.getPalabra().equals(pal.getPalabra())){
					anagramas.add(pal);
					mapa.get(pal).add(p);
				}
			}
		}
		
		
	}
	
	public void mostrarEnConsola(){
		String text = "";
		int higherKey = 0;
		for(Palabra pal: mapa.keySet()){
			if(pal.getPalabra().length()>higherKey){
				higherKey = pal.getPalabra().length();
			}
		}
		for(Palabra pal: mapa.keySet()){
			text += String.format("%." + higherKey + "s" + "   ( ", pal);
			for(Palabra p: mapa.get(pal)){
				text+=(p.getPalabra() + " ");
			}
			text += ") \n";
		}
		System.out.println(text);
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Anagrama){
			return ((Anagrama)obj).hashCode()==hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return mapa.hashCode();
	}

}
