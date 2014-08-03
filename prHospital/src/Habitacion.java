import javax.management.RuntimeErrorException;


public class Habitacion {
	private String codigo;
	private Cama[] camas;
	

	public Habitacion(int numCam, String num){
		codigo=num;
		
		camas= new Cama[numCam];
		for(int i=0;i<numCam;i++){
			camas[i]= new Cama(num+"C"+i); 
		}			

	}

	public Cama getCama(int i){
		if(i<0 && i>=camas.length){
			throw new RuntimeException("Cama no es valida");
		}else{
			return camas[i];
		}
	}

	public int numCamas(){
		return camas.length;
	}

	public boolean hayCamaLibre() {
		boolean salida=false;
		for(Cama cama: camas){
			if(cama.estaLibre()) salida=true;
			break;
		}
		return salida;
	}

	public String getCodigo(){
		return codigo;
	}

	public Cama camaLibre(){
		Cama camalibre = null;
		int contador=0;
		for(Cama cama: camas){
			if(cama.estaLibre()){
				camalibre=cama;
				contador++;
			}
		}
		if(contador==0) throw new RuntimeException("No hay cama libres");
		else return camalibre;
	}

	@Override
	public String toString(){
		return "Habitacion: "+codigo+" - Nº de camas: "+numCamas();
	}
}
