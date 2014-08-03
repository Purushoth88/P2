/*** NO MODIFICAR ESTE FICHERO ***/

package identificadores;

public class DNI implements Identificacion {
	String id;

	public DNI(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String nombreId() {
		return "DNI";
	}
}
