
public class MainJarra {
	static public void main(String[] args) {
		Jarra jarra, jarra2;
		
		try{
			jarra = new Jarra(Integer.parseInt(args[0]));
			jarra2 = new Jarra(Integer.parseInt(args[1]));
		}catch( ArrayIndexOutOfBoundsException e){
			System.out.println("ERROR: Use: TestJarra capacidadInicialJarra1 capacidadInicialJarra2");
		}catch(NumberFormatException e2){
			System.out.println("ERROR: Algún parámetro no es un número");
		}catch(RuntimeException e3){
			System.out.println(e3.getMessage());
		}
		
	}
}
