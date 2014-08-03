package identificadores;

public class FactoriaIDs implements IFactoriaIDs {
	
	
	
	@Override
	public Identificacion crearIdentificacion(String id) {
		Identificacion identificador = null;		
		
		if(Character.isLetter(id.charAt(id.length()-1))){
			identificador = new DNI(id);
			
		}if(Character.toUpperCase(id.charAt(0))=='P'){
			identificador = new Pasaporte(id);
			
		}if(Character.toUpperCase(id.charAt(0))=='X'){
			identificador = new TarjetaResidente(id);
			
		}
		
		return identificador;
	}

	
}
