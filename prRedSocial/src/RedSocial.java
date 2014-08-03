import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class RedSocial {

	private SortedMap<Persona,SortedSet<String>> red;

	public RedSocial(String fichero) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(fichero));
		red = new TreeMap<Persona,SortedSet<String>>();
		generaUsuarios(sc);
		sc.close();
	}
	
	
	private void generaUsuarios(Scanner sc){
		while(sc.hasNextLine()){
			criarUsuarios(sc.nextLine());
		}
	}
	
	private List<String> generaAficiones(String linha){
		StringTokenizer st = new StringTokenizer(linha,",");
		List<String> aficiones = new ArrayList<String>();
		while(st.hasMoreTokens()){
			aficiones.add(st.nextToken());
		}
		return aficiones;
	}

	private void criarUsuarios(String linha){
		
		try{
			StringTokenizer st = new StringTokenizer(linha,"%");
			while(st.hasMoreTokens()){
				String nome = st.nextToken();
				Integer idade = Integer.parseInt(st.nextToken());
				String email =st.nextToken();
				List<String>afficiones = generaAficiones(st.nextToken());
				anadirPersona(new Persona(nome, email, idade, afficiones));

			}

		}catch (RedSocialException e) {
			throw new RedSocialException("Ta faltando dados no txt");
		}

	}

	public void anadirPersona(Persona p){
		if(!red.keySet().contains(p)&& p!=null){
			red.put(p, new TreeSet<String>());
		}
	}

	public void anadirAmigo(Persona p, String email){
		if(p==null|| red.get(p)==null){
			throw new RedSocialException();
		}else if(!red.get(p).contains(email) && emailPersona(email)!=null){
			red.get(p).add(email);
		}
	}

	public void anadirAmigo(Persona p, List<String> emails){
		if(red.keySet().contains(p)){
			for(String email : emails){
				anadirAmigo(p, email);
			}

		}else{
			throw new RedSocialException("O amigo que vc quer add nao esta cadastrado");
		}
	}

	public void eliminarAmigos(Persona p,List<String> emails){
		if(red.keySet().contains(p)){
			for(String email : red.get(p)){
				if(emails.contains(email)){
					red.get(p).remove(email);
				}
			}
		}else{
			throw new RedSocialException();
		}
	}

	public Persona emailPersona(String email){
		Persona salida = null;
		for(Persona per :  red.keySet()){
			if(per.getCorreo().equals(email)){
				salida = per;
				break;
			}
		}

		return salida;
	}

	public String toString(){
		String salida = "";
		for(Persona p : red.keySet()){
			salida+=p.toString()+"\n";
			for(String amigos : red.get(p)){
				salida+="\t"+amigos;
			}
		}

		return salida;
	}

	public void guardar(String fichero) throws FileNotFoundException{
		PrintWriter print = new PrintWriter(new File(fichero));
		print.write(toString());
		print.close();
	}

	public List<Persona> amigos(Persona p){
		List<Persona> amigos = new ArrayList<Persona>();
		if(red.containsKey(p)){
			for(String email : red.get(p)){
				amigos.add(emailPersona(email));
			}
		}else{
			throw new RedSocialException("Persona no eh um usuari");
		}
		Collections.sort(amigos);
		return amigos;
	}

	public SortedMap<String,SortedSet<Persona>> buscarPersonasAficion(Persona p){
		SortedMap<String,SortedSet<Persona>> salida = new TreeMap<String,SortedSet<Persona>>();
		if(red.keySet().contains(p)){
			for(Persona per: red.keySet()){
				if(!red.get(p).contains(per.getCorreo()) && !p.equals(per)){
					for(String aficones : aficionComun(p, per)){
						 
						if(salida.get(aficones)==null){
							SortedSet<Persona> personas = new TreeSet<Persona>();
							personas.add(per);
							salida.put(aficones, personas);
						}else{
							salida.get(aficones).add(per);
						
						}
					}
				}
			}
		}

		return salida;

	}

	public Set<String> aficionComun(Persona p1, Persona p2){
		Set<String> set = new TreeSet<String>();
		if(red.keySet().contains(p1)&&red.keySet().contains(p2)){
			for(String aficiones1 : p2.getAficiones()){
				if(p1.getAficiones().contains(aficiones1)){
					set.add(aficiones1);
				}
			}
		}
		return set;
	}





}
