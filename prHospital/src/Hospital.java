
public class Hospital {
	private String nombre;
	private String direccion;
	private Departamento[] departamentos;
	private int numPlantas;
	private final int NUMHAB=8;
	private Planta[] plantas;
	
	public Hospital(String nombre, String direccion,Departamento[] departamentos, int numPlantas){
		this.nombre= nombre;
		this.direccion=direccion;
		this.departamentos=departamentos;
		this.numPlantas= numPlantas;
		plantas= new Planta[NUMHAB];
		for(int i=0;i<numPlantas;i++){
			plantas[i]= new Planta(NUMHAB,"P"+i );
		}
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
	
	public int numPlantas(){
		return numPlantas;
	}
	
	public Planta getPlanta(int i){
		if(i<0 && i>numPlantas){
			throw new RuntimeException("Planta no es valida");
		}else{
			return plantas[i];
		}
	}
	
	@Override
	public String toString(){
		return "Hospital: "+nombre+" | Direccion: "+direccion+" | Numero de departamentos: "+getNumDepartamentos()+" | Nº de plantas: "+numPlantas;
	}
	
}
