
public class CalculaPK {
	
	static void calculaPk(int k, int lambida, int mi){
		int interacoes = 0;
		float pk = 0;
		
		while(interacoes<= k){
			if(interacoes < k){
				pk = (interacoes/lambida);
				System.out.println("Para k="+interacoes+" temos Pk="+pk);
				interacoes++;
			}else{
				 pk = interacoes/mi;
				 System.out.println("Para k="+interacoes+" temos Pk="+pk);
				 interacoes++;
			}
			
			
			
			
		}
		
		
	}
	
	public static void main(String[] args) {
		//calculaPk(10, 2, 5);
		double d = (1/2);
		System.out.println(d);
	}

}
