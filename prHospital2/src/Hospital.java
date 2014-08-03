
public class Hospital {
	private String nombre;
	private String direccion;
	private Departamento[] departamentos;
	
	public Hospital(String nombre, String direccion,Departamento[] departamentos){
		this.nombre= nombre;
		this.direccion=direccion;
		this.departamentos=departamentos;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public int getNumDepartamentos(){
		return departamentos.length;
	}
	
	public Departamento getDepartamento(String nom){
		Departamento departamento=null;
		for(Departamento dep:departamentos){
			if(dep.getNombre().equals(nom)) departamento=dep;
		}
		
		return departamento;
	}
	
	@Override
	public String toString(){
		return "Hospital: "+nombre+" | Direccion: "+direccion+" | Numero de departamentos: "+getNumDepartamentos();
	}
}
