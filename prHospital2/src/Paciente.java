
public class Paciente extends Persona {
	
	private double altura, peso;
	private String segsocial;
	private Boolean urgencia;
	private Medico medico;
	
	public Paciente(String dni, String nombre, String apellidos, int edad,Genero sexo, double a, double p, String ss, boolean urg) {
		super(dni, nombre, apellidos, edad, sexo);
		altura=a;
		peso=p;
		segsocial=ss;
		urgencia=urg;
		medico=null;

	}


	public double getAltura() {
		return altura;
	}


	public double getPeso() {
		return peso;
	}


	public String getNumSegsocial() {
		return segsocial;
	}
	
	public Boolean esUrgencia() {
		return urgencia;
	}
	
	public double getIndiceMasaCorporal(){
		return peso/(altura*altura);
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public void setEsUrgencia(Boolean urgencia) {
		this.urgencia = urgencia;
	}
	
	public void asignaMedico(Medico doctor){
		medico=doctor;
	}
	
	public Medico atendidoPor(){
		return medico;
	}
	
	@Override
	public String toString(){
		return super.toString()+"Altura: "+altura+"\n"+"Peso: "+peso+"\n"+"Urgencia: "+urgencia+"\n"+"Nº Seguro: "+segsocial+"\n"+"Atendiddo por: "+medico.getNombre()+" "+medico.getApellidos();
	}

}
