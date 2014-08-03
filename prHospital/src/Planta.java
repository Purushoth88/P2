
public class Planta {
	private String codigo;
	private Habitacion[] habitaciones;
	private final int NUMHAB=8;
	private final int NUMCAMAS=4;
	
	public Planta(int numHab, String num){
		if(numHab!=NUMHAB){
			throw new RuntimeException("Numero de habitaciones invalidas");
		}else if(numHab==NUMHAB){
			codigo=num;
			habitaciones= new Habitacion[NUMHAB];
			for(int i=0;i<NUMHAB;i++){
				habitaciones[i]= new Habitacion(NUMCAMAS, num+"H"+i);
			}
		}
		
	}
	
	public Habitacion getHabitacion(int i){
		if(i<=0 && i>NUMHAB){
			throw new RuntimeException("Habitacion no es valida");
		}else{
			return habitaciones[i];
		}
	}
	
	public int numHabitaciones(){
		return habitaciones.length;
	}
	
	public boolean hayCamaLibre(){
		boolean camalibre=false;
		for(Habitacion hab: habitaciones){
			if(hab.hayCamaLibre()) camalibre= true;
			break;
		}
		return camalibre;
	}
	
	public Cama camaLibre(){
		Cama camalibre=null;
		for(Habitacion hab: habitaciones){
			if(hab.hayCamaLibre()) camalibre=hab.camaLibre();
			break;
		}
		
		return camalibre;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	@Override
	public String toString(){
		return "Planta: "+codigo+" - Nº Habitaciones: "+numHabitaciones();
	}
}
