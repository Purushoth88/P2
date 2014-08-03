/*** NO MODIFICAR ESTE FICHERO ***/

package identificadores;

public class Pasaporte implements Identificacion {
	String id;

	public Pasaporte(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String nombreId() {
		return "Pasaporte";
	}
}
