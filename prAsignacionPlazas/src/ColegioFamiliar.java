import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;


public class ColegioFamiliar extends Colegio {
	
	public ColegioFamiliar(String fichero){
		super(fichero);
	}
	
	@Override
	public void asignarPlazas(Map<String,Integer> plazas){
		
	}
	
	
	private SortedMap<String,List<Solicitante>> buscarHermanos (String nif){
		SortedMap<String,List<Solicitante>>  set = new TreeMap<String,List<Solicitante>>();
		for(String curso : solicitantes.keySet()){
			for(Solicitante sol : solicitantes.get(curso)){
				if(sol.getNif().equals(nif)){
					if(set.get(curso)!=null){
						set.get(curso).add(sol);
					}else{
						List<Solicitante> listaSol = new ArrayList<Solicitante>();
						listaSol.add(sol);
						set.put(curso, listaSol);
					}
				}
			}
		}
		return set;
	}
	
	public boolean hayPlazas(SortedMap<String,List<Solicitante>>hermanos, Map<String,Integer> plazas){
		int contador = 0;
		for(String curso : hermanos.keySet()){
			if(plazas.containsKey(curso) && plazas.get(curso) >= hermanos.get(curso).size()){
				contador++;
			}
		}
		if(contador==)
	}
	
	public void asignarPlazaHermanos (SortedMap<String, List<Solicitante>>hermanos, Map<String,Integer> plazas){
		for(String curso : hermanos.keySet()){
			for(Solicitante sol : hermanos.get(curso)){
				sol.setTienePlaza(true);
				int num = plazas.get(curso);
				plazas.put(curso, --num);
			}
		}
	}

}
