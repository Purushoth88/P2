


public class Departamento {
	private String nombre;
	private Medico[] medicos;
	
	public Departamento(String nombre, Medico[] medicos){
		this.nombre=nombre;
		this.medicos= medicos;
	}
	
	public int getNumMedicos(){
		return medicos.length;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int numMedicos(Categoria cat){
		int contador=0;
		for(Medico elem : medicos){
			if(elem.getCategoriaProfesional().equals(cat)) contador++;
		}
		
		return contador;
	}
	
	public Medico getMedico(String dni){
		Medico doc=null;
		for(Medico elem : medicos){
			if(elem.getDni().equals(dni)) doc=elem;
		}
		
		return doc;
	}
	
	public boolean trabajaEnDepartamento(Medico doc){
		if(getMedico(doc.getDni())!=null) return true;
		else return false;
	}
	
	@Override
	public String toString(){
		return "Departamento: "+nombre+" | Numero de medicos: "+getNumMedicos();
	}
}
