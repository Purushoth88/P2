/**
 * Clase que representa un servicio de directorio, que consiste en una tabla
 * de pares <nombre, identificadorUnico>, donde el identificadorUnico es un 
 * entero que representa a un determinado tipo de recurso. 
 */
package directorio ;

import java.util.Vector;

public class  ServicioDeDirectorios {
  public class EntradaDeDirectorio {
    String nombreFichero ;
    long identificadorFichero;
    public EntradaDeDirectorio(String nombre, long identificadorFichero) {
      this.nombreFichero = nombre ;
      this.identificadorFichero = identificadorFichero ;
    }
  }
  
  Vector<EntradaDeDirectorio> directorio = null ;
  public ServicioDeDirectorios() {
    directorio = new Vector<EntradaDeDirectorio>() ;
  }
  
  /**
   * Inserta una nueva entrada de directorio si el nombre del fichero no existe
   * @param nombre Nombre del fichero
   * @param identificador Fichero
   * @return true si el nombre no existia, false en caso contrario
   */
  public boolean nuevaEntrada(String nombre, long identificadorFichero) {
    boolean ok = true ;
    if (buscaFichero(nombre)==-1)
      directorio.add(new EntradaDeDirectorio(nombre, identificadorFichero)) ;
    else
      ok = false;
    return ok ;
  }
  
  /**
   * Busca el fichero con el nombre pasado como argumento
   * @param nombre Nombre del fichero a buscar
   * @return El identificador del fichero si esta en el directorio, null si no esta
   */
  public long buscaFichero(String nombre) {
    long identificadorFichero = -1 ;
    int index = 0 ;
    while ((index < directorio.size()) && (identificadorFichero == -1)) {
      if (directorio.get(index).nombreFichero.equals(nombre)) {
        identificadorFichero = directorio.get(index).identificadorFichero ;
      } 
      else {
        index++ ;
      }
    }
    return identificadorFichero ;
  }
    
  /**
   * Borra un fichero el directorio
   * @param nombre Nombre del fichero a borrar
   * @return true si el fichero ha sido borrado, false si el fichero no esta en
   * el directorio
   */
  public boolean borrarFichero(String nombre) {
    boolean resultado = false ;
    long fichero = buscaFichero(nombre) ;
    if (fichero != -1) {
      resultado = true ;
      int index = 0 ;
      boolean encontrado = false ;
      while (!encontrado && (index < directorio.size())) {
        if (directorio.get(index).nombreFichero.equals(nombre)) {
          encontrado = true ;
          directorio.remove(index) ;
        } 
        else {
          index++ ;
        }
      }
    }
    
    return resultado ;
  }
  
  /**
   * Devuelve el numero de entradas del directorio
   * @return Numero de entradas del directorio
   */
  public int numeroDeEntradas() {
    return directorio.size() ;
  }
  
  /**
   * Guarda una copia de seguridad del directorio en un servidor remoto si 
   * no existe una copia previa
   */
  public void hacerCopiaDeSeguridad (IServicioDeCopia servicioDeCopia) {
    if (!servicioDeCopia.existeCopia(this))
      servicioDeCopia.hacerCopia(this) ;
  }
}
