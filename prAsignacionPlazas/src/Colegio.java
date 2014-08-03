import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Colegio {

	protected SortedMap<String,SortedSet<Solicitante>> solicitantes;

	public Colegio(String fichero) throws IOException{
		solicitantes = new TreeMap<String,SortedSet<Solicitante>>();
		learquivo(fichero);
	}

	private void learquivo(String fichero) throws IOException{
		BufferedReader buffer = new BufferedReader(new FileReader(fichero));
		String linha = buffer.readLine();
		while(linha!=null){
			processaCurso(linha, buffer);
			linha = buffer.readLine();
		}

	}

	private void processaCurso(String linha, BufferedReader bf) throws IOException{
		try{
			StringTokenizer linia = new StringTokenizer(linha, " ");
			String curso = linia.nextToken();
			int numeroSolicitantes = Integer.parseInt(linia.nextToken());
			processarSolicitantes(curso,numeroSolicitantes,bf);
		}catch (NoSuchElementException  e) {
			throw new AsignacionException("Falta Parametros");
		}catch (NumberFormatException e) {
			throw new AsignacionException("Formato invalido");
		}

	}

	private void processarSolicitantes(String curso, int numeroS, BufferedReader bf) throws IOException{
		SortedSet<Solicitante> set = new TreeSet<Solicitante>();
		try{
			for(int i=0; i<numeroS;i++){
				String linha = bf.readLine();
				StringTokenizer dados = new StringTokenizer(linha, " ");
				String nif = dados.nextToken();
				double puntos = Double.parseDouble(dados.nextToken());
				System.out.println(puntos);
				String nombre = dados.nextToken("\n");
				Solicitante sol = new Solicitante(nif, nombre, puntos);
				set.add(sol);
			}

		}catch (NoSuchElementException  e) {
			throw new AsignacionException("Falta Parametros");
		}catch (NumberFormatException e) {
			throw new AsignacionException("Formato invalido");
		}
		solicitantes.put(curso, set);
	}

	public void asignarPlazas(Map<String,Integer> plazas){
		for(String curso : plazas.keySet()){
			if(solicitantes.keySet().contains(curso)){
				assignarPlazaSolicitador(curso,plazas.get(curso));
			}
		}
	}

	private void assignarPlazaSolicitador(String curso, int vagas){
		vagas = Math.min(vagas,solicitantes.get(curso).size());
		SortedSet<Solicitante> sol = solicitantes.get(curso);
		if(sol!=null){
			Iterator<Solicitante> it = sol.iterator();
			while(it.hasNext()){
				it.next().setTienePlaza(true);
				vagas--;
			}
		}

	}
	
	public void limpiar(){
		for(String curso : solicitantes.keySet()){
			for(Solicitante sol : solicitantes.get(curso)){
				sol.setTienePlaza(false);
			}
		}
	}
	
	public void mostrarSolicitantes (boolean conPlaza, PrintWriter pw){
		for(String curso : solicitantes.keySet()){
			pw.println(curso);
			for(Solicitante sol : solicitantes.get(curso)){
				if(sol.getTienePlaza()==conPlaza){
					pw.println(sol.toString());
				}
			}
		}
	}
	
	public void mostrarSolicitantes(boolean conPlaza, String nombreFichero) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File(nombreFichero));
		for(String curso : solicitantes.keySet()){
			pw.write(curso);
			for(Solicitante sol : solicitantes.get(curso)){
				if(sol.getTienePlaza()==conPlaza){
					pw.write(sol.toString());
				}
			}
		}
		pw.close();
	}

}
