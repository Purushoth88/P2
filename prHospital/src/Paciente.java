
public class Paciente extends Persona {
	
	private double altura, peso;
	private String segsocial;
	private Boolean urgencia;
	private Medico medico;
	private Cama cama;
	
	public Paciente(String dni, String nombre, String apellidos, int edad,Genero sexo, double a, double p, String ss, boolean urg, Cama cama) {
		super(dni, nombre, apellidos, edad, sexo);
		altura=a;
		peso=p;
		segsocial=ss;
		urgencia=urg;
		medico=null;
		this.cama=cama;
		cama.setPaciente(this);
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
	
	public Cama getCama(){
		return cama;
	}
	
	public void setCama(Cama newcama){
		cama=newcama;
	}
	
	public void daAlta(){
		cama.libera();
	}
	
	@Override
	public String toString(){
		return "------Paciente-----\n"+"Nombre: "+this.getNombre()+"\n"+"Apellidos: "+this.getApellidos()+"\n"+"Edad: "+this.getEdad()+"\n"+"DNI: "+this.getDni()+"\n"+"Sexo: "+sexo+"\n"+"Altura: "+altura+"\n"+"Peso: "+peso+"\n"+"Urgencia: "+urgencia+"\n"+"Nº Seguro: "+segsocial+"\n"+"Cama: "+getCama().getCodigo()+"\nAtendiddo por: "+medico.getNombre()+" "+medico.getApellidos()+"\n-----------------";
	}

}
