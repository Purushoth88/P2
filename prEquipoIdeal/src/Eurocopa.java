import java.io.*;
import java.util.*;

public class Eurocopa {

	protected SortedMap<Equipo, List<Jugador>> puntuaciones;

	public Eurocopa(String nombreFichero) throws IOException {
		puntuaciones = new TreeMap<Equipo, List<Jugador>>();
		leeArq(nombreFichero);
		
	}

	private void leeArq(String fichero) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(fichero));
		while(sc.hasNextLine()){
			criarEquipe(sc.nextLine(),sc);
		}
		
	}
	
	private void criarEquipe(String linha,Scanner sc){
		StringTokenizer stk = new StringTokenizer(linha," ");
		while(stk.hasMoreTokens()){
			String nombre = stk.nextToken();
			Integer votos = Integer.parseInt(stk.nextToken());
			Integer numJogadores = Integer.parseInt(stk.nextToken());
			Equipo eq = new Equipo(nombre, votos);
			criarJogadores(eq,numJogadores,sc);
			
		}
	}
	
	private void criarJogadores(Equipo eq, int numJ, Scanner sc){
		ArrayList<Jugador> listaJogadores = new ArrayList<Jugador>();
		try{
			while(sc.hasNextLine()){
				StringTokenizer stk = new StringTokenizer(sc.nextLine()," ");
				String nombre = stk.nextToken();
				String posicao = stk.nextToken();
				Integer valoricao = Integer.parseInt(stk.nextToken());
				Jugador ju = new Jugador(nombre, posicao, valoricao);
				listaJogadores.add(ju);
				
			}
		}catch (NumberFormatException e) {
			throw new EurocopaException("Formato de numero errado");
		}catch (NoSuchElementException e) {
			throw new EurocopaException("Falta dados");
		}
		
		if(!puntuaciones.containsKey(eq)){
			puntuaciones.put(eq, listaJogadores);
		}else{
			puntuaciones.get(eq).addAll(listaJogadores);
		}
		
	}
	

	public SortedSet<Jugador> formarEquipoIdeal(int defensa, int centro,
			int ataque) {
		SortedSet<Jugador> ideal = new TreeSet<Jugador>();

		ideal.addAll(seleccionar(1, "PORTERIA")); // por defecto se selecciona
													// un portero
		ideal.addAll(seleccionar(defensa, "DEFENSA"));
		ideal.addAll(seleccionar(centro, "CENTRO"));
		ideal.addAll(seleccionar(ataque, "ATAQUE"));

		return ideal;
	}

	private SortedSet<Jugador> seleccionar(int numJugadores, String demarcacion) {
		SortedSet<Jugador> ideal = new TreeSet<Jugador>();

		int contJugadores = 0;

		Set<Equipo> equipos = puntuaciones.keySet();
		Iterator<Equipo> iter = equipos.iterator();
		int numeroEquiposPorConsultar = equipos.size();

		while ((contJugadores < numJugadores)
				&& (numeroEquiposPorConsultar > 0)) {
			if (iter.hasNext()) {
				Jugador j = seleccionarJugador(iter.next(), demarcacion);
				if (j != null) {
					contJugadores++;
					j.setElegido(true);
					ideal.add(j);
					numeroEquiposPorConsultar = equipos.size();
				} else {
					numeroEquiposPorConsultar--;
				}
			} else {
				iter = equipos.iterator();
			}
		}
		return ideal;
	}

	protected Jugador seleccionarJugador(Equipo eq, String demarcacion) {
		List<Jugador> jugadores = puntuaciones.get(eq);
		Iterator<Jugador> iter = jugadores.iterator();
		Jugador resultado = null;
		while ((resultado == null) && iter.hasNext()) {
			Jugador j = iter.next();
			if (!j.getElegido()
					&& (demarcacion.equalsIgnoreCase(j.getDemarcacion()))) {
				resultado = j;
			}
		}
		if (resultado != null) {
			while (iter.hasNext()) {
				Jugador j = iter.next();
				if (!j.getElegido()
						&& (demarcacion.equalsIgnoreCase(j.getDemarcacion()))
						&& (j.compareTo(resultado) < 0)) {
					resultado = j;
				}
			}
		}

		return resultado;
	}

	public static String representarEquipoIdeal(SortedSet<Jugador> ideal) {
		StringBuilder sb = new StringBuilder();
		for (Jugador j : ideal) {
			sb.append(j.toString()).append("\n");
		}
		return sb.toString();
	}

	public static void mostrarEquipoIdeal(SortedSet<Jugador> ideal) {
		System.out.println(representarEquipoIdeal(ideal));
	}

	public static void mostrarEquipoIdeal(String nombreFichero,
			SortedSet<Jugador> ideal) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(nombreFichero);
		pw.println(representarEquipoIdeal(ideal));
		pw.close();
	}

}
