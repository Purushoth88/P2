
public class Alumno {
	
	String nombre, dni;
	double calificacion;
	
	public Alumno(String nombre, String dni, double calificacion) throws AlumnoException{
		if(calificacion<0.0) {
			throw new AlumnoException("ERROR. Calificación Negativa: ");
		}else{
			this.nombre=nombre;
			this.dni=dni;
			this.calificacion=calificacion;
		}
		
	}
	
	public Alumno(String nombre, String dni){
		this.nombre=nombre;
		this.dni=dni;
		calificacion=0.0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getCalificacion() {
		return calificacion;
	}
	
	@Override
	public boolean equals(Object a){
		boolean result=false;
		if(a instanceof Alumno){
			result=(((Alumno)a).getNombre().toUpperCase().equals(nombre.toUpperCase()) && ((Alumno)a).getDni().toUpperCase().equals(dni.toUpperCase()));
		}
		return result;
	}
	
	@Override
	public int hashCode(){
		return nombre.toUpperCase().hashCode()+dni.toUpperCase().hashCode();
	}
	
	@Override
	public String toString(){
		return dni+"; " +nombre;
	}
	
	
}
