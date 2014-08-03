import java.io.FileNotFoundException;




public class RedSocialConTope extends RedSocial{
	
	private final int TOPE;
	
	public RedSocialConTope(String fichero, int tope) throws FileNotFoundException {
		super(fichero);
		this.TOPE = tope;
	}
	
	@Override
	public void anadirAmigo(Persona p, String email){
		if(super.amigos(p).size()<TOPE){
			super.anadirAmigo(p, email);
		}else{
			throw new RedSocialException("Limite de amigos atingido");
		}
	}

	public void anadirAmigosAficiones(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
