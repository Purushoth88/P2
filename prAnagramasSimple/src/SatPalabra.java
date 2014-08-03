import java.util.Comparator;


public class SatPalabra implements Comparator<Palabra>{

	@Override
	public int compare(Palabra p1, Palabra p2) {
		int num = (new Integer(p1.getPalabra().length())).compareTo(new Integer(p2.getPalabra().length()));
		if(num==0){
			num = p1.getPalabra().compareToIgnoreCase(p2.getPalabra());
		}
		return num;
	}
	
}
