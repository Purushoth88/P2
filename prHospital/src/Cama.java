
public class Cama {
	private String codigo;
	private Paciente paciente;
	
	public Cama(String num){
		codigo=num;
		paciente=null;
	}
	
	public Paciente getPaciente(){
		return paciente;
	}
	
	public void setPaciente(Paciente p){
		paciente=p;
	}
	
	public boolean estaLibre(){
		if(paciente==null) return true;
		else return false;
	}
	
	public void libera(){
		paciente=null;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	@Override
	public String toString(){
		if(estaLibre()) return "Cama: "+codigo+" | Status: "+estaLibre();
		else return "Cama: "+codigo+" | Status: "+estaLibre()+" | Ocupada por: "+getPaciente().getNombre()+" "+getPaciente().getApellidos();
	}
}
