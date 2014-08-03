
public abstract class Persona {
	private String dni,nombre,apellidos;
	private int edad;
	protected Genero sexo;
	
	public Persona(String dni, String nombre, String apellidos, int edad, Genero sexo) {
			this.dni=dni;
			this.nombre= nombre;
			this.apellidos= apellidos;
			this.edad= edad;
			this.sexo=sexo;
		
	}
	
	public String getDni(){
		return dni;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public Genero getSexo(){
		return sexo;
	}
	
	public void setEdad(int e){
		edad=e;
	}
	
	public void setSexo(Genero c){
		sexo=c;
	}
	
	public String toString(){
		return "Nombre: "+nombre+"\n"+"Apellidos: "+apellidos+"\n"+"Edad: "+edad+"\n"+"DNI: "+dni+"\n"+"Sexo: "+sexo+"\n" ;
	}
}
