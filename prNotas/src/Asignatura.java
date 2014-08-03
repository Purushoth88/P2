import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Asignatura {
	
	private String nombre;
	private String[] malos;
	private Alumno[]alumnos;
	private static final int TAM_ARRAY=10;
	private static int pplBueno, pplMalos;
	
	public Asignatura(String nombre, String[]datosAlumnos){
		this.nombre=nombre;
		alumnos= new Alumno[TAM_ARRAY];
		malos= new String[TAM_ARRAY];
		pplBueno=0;
		pplMalos=0;
	
		for(String a: datosAlumnos){
			if(a!=null){
				anadeAlumno(a);	
			}
		}		
	}
	
	private void anadeAlumno(String alum){
		Scanner sc = new Scanner(alum);
		sc.useDelimiter("[;]+");
		sc.useLocale(Locale.ENGLISH);
		
		try{
			String dni = sc.next();
			String nom = sc.next();
			double nota = sc.nextDouble();
			alumnos[pplBueno]=(new Alumno(nom, dni, nota));
			pplBueno++;
			//System.out.println("BUENO ADD: "+alum);
		}catch(InputMismatchException e){
			malos[pplMalos]=("ERROR. Nota no numérica: "+alum);
			//System.out.println("1 MALO ADD: "+alum);
			pplMalos++;
		}catch(NoSuchElementException e){
			malos[pplMalos]=("ERROR. Faltan datos: "+alum);
			//System.out.println("2 MALO ADD: "+alum);
			pplMalos++;
		}catch(AlumnoException e){
			malos[pplMalos]=(e.getMessage()+alum);
			//System.out.println("3 MALO ADD: "+alum);
			pplMalos++;
		}finally{
			sc.close();
		}
	}
	
	
	public double getCalificacion(Alumno al) throws AlumnoException {
		double nota = -1;
		for (Alumno a : alumnos) {
			try {
				if (a.equals(al) && a != null) {
					return a.getCalificacion();
				}
			} catch (NullPointerException n) {
				throw new AlumnoException("El alumno " + al.toString()+ " no se ecuentra");
			}

		}
		return nota;

		

	}
	
	
	
	public Alumno[] getAlumnos(){
		Alumno[] salida= new Alumno[pplBueno];
		for(int i=0;i<alumnos.length;i++){
			if(alumnos[i]!=null) salida[i]=alumnos[i];
		}
		return salida;
	}
	
	
	public String[] getMalos(){
		String[] salida= new String[pplMalos];
		for(int i=0;i<malos.length;i++){
			if(malos[i]!=null) salida[i]=malos[i];
		}
		return salida;
	}
	
	public double getMedia(){
		double somaNotas = 0.0;
		for(Alumno a: alumnos){
			if(a!=null) somaNotas+=a.getCalificacion();
		}
		
		return somaNotas/pplBueno;
	}
	
	
	public void print(){
		System.out.println(nombre+"\n");
		for(Alumno a: alumnos){
			if(a!=null) System.out.println(a.toString());
		}
	}
	
	@Override
	public String toString(){
		String alunos="";
		String malos="";
		for(Alumno a: getAlumnos()){
			alunos+=a.toString();
		}
		
		for(String m: getMalos()){
			malos+=m+" ";
		}
		return nombre+": "+"{["+alunos+"], ["+malos+"]}";
	}
		
}
	
	

