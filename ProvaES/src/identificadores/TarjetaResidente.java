/*** NO MODIFICAR ESTE FICHERO ***/

package identificadores;

public class TarjetaResidente implements Identificacion {
	String id;

	public TarjetaResidente(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String nombreId() {
		return "Tarjeta de Residente";
	}
}
