/*** NO MODIFICAR ESTE FICHERO ***/

package identificadores;

public interface Identificacion {
	// devuelve una cadena con el valor del identificador
	// ejemplo: ident.getId() ==> "72317296B"
	public String getId();
	// devuelve una cadena con el tipo de identificador
	// ejemplo: ident.nombreId() ==> "DNI"
	public String nombreId();
}
