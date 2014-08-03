/**
 * Clase de pruebas JUnit para la clase SingletonIdentificadores
 */

package directorio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SingletonIdentificadoresTest {

  SingletonIdentificadores factoria_ ;
  
  /**
   * Inicializacion de recursos
   */
  @Before
  public void inicializar() {
    factoria_ = SingletonIdentificadores.Instancia() ;
  }
  
  /**
   * Comprueba que el primer identificador es 1
   */
  @Test
  public void valorInicialPrueba() {
    assertEquals("valorInicialPruebas", 1, factoria_.obtenerIdentificador()) ;
  }

  /**
   * Comprueba que no se crean instancias distintas del singleton
   */
  @Test 
  public void noSeCreanDosInstanciasDistintasPrueba() {
    SingletonIdentificadores factoria = SingletonIdentificadores.Instancia() ;
    assertSame("noSeCreanDosInstanciasDistintasPrueba", factoria_, factoria) ;
  }
  
  /**
   * Comprueba que dos llamadas al singleton devuelve dos identificadores
   * consecutivos
   */
  @Test
  public void identificadoresConsecutivosPrueba() {
    long id1 = factoria_.obtenerIdentificador() ;
    long id2 = factoria_.obtenerIdentificador() ;
    assertEquals("identificadoresConsecutivosPrueba", id1+1, id2) ;
  }
  
  /**
   * Liberacion de recursos
   */
  @After
  public void finalizar() {
    factoria_ = null ;
  }
}
