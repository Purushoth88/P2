import org.omg.CORBA.CTX_RESTRICT_SCOPE;


public class Medico extends Persona {
	
	private Categoria categoriaProf;
	private Boolean trabajaEmPrivado;
	private double horasSemanales;
	
	public Medico(String dni, String nombre, String apellidos, int edad,Genero sexo, Categoria cat, boolean trabajaP, double horas) {
		
		super(dni, nombre, apellidos, edad, sexo);
		
		categoriaProf=cat;
		trabajaEmPrivado=trabajaP;
		horasSemanales=horas;
		
	}
	
	public Categoria getCategoriaProfesional(){
		return categoriaProf;
	}
	
	public boolean trabajaEnPrivado(){
		return trabajaEmPrivado;
	}
	
	public double getHorasSemanales(){
		return horasSemanales;
	}
	
	public void setCategoriaProfesional(Categoria cat){
		categoriaProf= cat;
	}
	
	@Override
	public String toString(){
		return super.toString()+"Categoria: "+categoriaProf+"\n"+"Trabaja en privado: "+trabajaEmPrivado+"\n"+"Horas semanales: "+horasSemanales;
	}

}
