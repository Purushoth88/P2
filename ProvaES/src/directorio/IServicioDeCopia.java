/**
 * Interfaz para un servicio de copias de seguridad de directorios
 */
package directorio;

public interface IServicioDeCopia {
  /**
   * Hace un copia de seguridad de un directorio
   * @param directorio El directorio 
   * @return true si la copia ha tenido exito, false en caso contrario
   */
  public boolean hacerCopia(ServicioDeDirectorios directorio) ;
  
  /**
   * Devuelve true si ya existe una copia de seguridad del directorio, y false
   * si no existe
   * @param directorio El directorio
   * @return true si existe ya la copia del directorio
   */
  public boolean existeCopia(ServicioDeDirectorios directorio) ;
}
