/*** NO MODIFICAR ESTE FICHERO ***/

/* Si tu implementacion del metodo factoria es correcta el
 * siguiente programa debe generar la siguiente salida:
 * 
 *    28901174F es un numero de DNI
 *    X60176544 es un numero de Tarjeta de Residente
*     p47203843 es un numero de Pasaporte
 */

package identificadores;
public class ClienteIDs {

	public static void main(String[] args) {
		Identificacion ident;
		final IFactoriaIDs factoria = new FactoriaIDs();

		ident = factoria.crearIdentificacion("28901174F");
		System.out.println(ident.getId() + " es un numero de " + ident.nombreId());

		ident = factoria.crearIdentificacion("X60176544");
		System.out.println(ident.getId() + " es un numero de " + ident.nombreId());

		ident = factoria.crearIdentificacion("p47203843");
		System.out.println(ident.getId() + " es un numero de " + ident.nombreId());
	}
}
