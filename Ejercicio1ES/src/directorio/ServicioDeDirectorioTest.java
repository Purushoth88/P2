/**
 * Casos de prueba para el servicio de directorio
 */
package directorio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.* ;

import org.junit.Before;
import org.junit.Test;

public class ServicioDeDirectorioTest {
	
	private ServicioDeDirectorios servicos;
	private SingletonIdentificadores id;
	
	@Before
	public void inicio(){
		servicos = new ServicioDeDirectorios();
		id = SingletonIdentificadores.Instancia();
	}
	
	@Test
	public void incertarEnDiretorioVacio(){
		assertEquals("testa numero de entradas inicial de um diretorio",0,servicos.numeroDeEntradas());
		assertTrue(servicos.nuevaEntrada("Brasil", id.obtenerIdentificador()));
		assertEquals("testa numero de entradas",1,servicos.numeroDeEntradas());
		
	}
	
	@Test
	public void comprobaIncrementaUnidades(){
		long numEntradas = servicos.numeroDeEntradas();
		assertTrue(servicos.nuevaEntrada("Alemanha", id.obtenerIdentificador()));
		assertEquals("Numero de entradas es incrementado +1",numEntradas+1,servicos.numeroDeEntradas());
		numEntradas = servicos.numeroDeEntradas();
		assertTrue(servicos.nuevaEntrada("Holanda", id.obtenerIdentificador()));
		assertEquals("Numero de entradas es incrementado +1",numEntradas+1,servicos.numeroDeEntradas());
		
	}
	
	@Test
	public void insertarEnListaVacia(){
		assertEquals(0, servicos.numeroDeEntradas());
		assertEquals(-1,servicos.buscaFichero("Chile"));
		assertTrue(servicos.nuevaEntrada("Chile", id.obtenerIdentificador()));
		assertEquals("testa numero de entradas inicial de um diretorio",1,servicos.numeroDeEntradas());
		assertFalse(servicos.buscaFichero("Chile")==-1);
		
	}
	
	@Test
	public void insertarTresEnListaVacia(){
		assertEquals(0, servicos.numeroDeEntradas());
		assertEquals(-1,servicos.buscaFichero("Polonia"));
		assertEquals(-1,servicos.buscaFichero("Hungria"));
		assertEquals(-1,servicos.buscaFichero("Belgica"));
		assertTrue(servicos.nuevaEntrada("Polonia", id.obtenerIdentificador()));
		assertTrue(servicos.nuevaEntrada("Hungria", id.obtenerIdentificador()));
		assertTrue(servicos.nuevaEntrada("Belgica", id.obtenerIdentificador()));
		assertEquals("testa numero de entradas inicial de um diretorio",3,servicos.numeroDeEntradas());
		assertFalse(servicos.buscaFichero("Hungria")==-1);
	}
	
	@Test
	public void insertaFicherosIguales(){
		assertTrue(servicos.buscaFichero("Rusia")==-1);
		assertTrue(servicos.nuevaEntrada("Rusia", id.obtenerIdentificador()));
		assertFalse(servicos.nuevaEntrada("Rusia", id.obtenerIdentificador()));
	}
	
	@Test
	public void borraFichero(){
		assertEquals(0,servicos.numeroDeEntradas());
		assertTrue(servicos.nuevaEntrada("Croacia", id.obtenerIdentificador()));
		assertEquals(1,servicos.numeroDeEntradas());
		assertFalse(servicos.buscaFichero("Croacia")==-1);
		assertTrue(servicos.borrarFichero("Croacia"));
		assertEquals(0,servicos.numeroDeEntradas());
	}
	
	@Test
	public void hacerCopia(){
		IServicioDeCopia copia = mock(IServicioDeCopia.class);
		when(copia.existeCopia(servicos)).thenReturn(false);
		servicos.hacerCopiaDeSeguridad(copia);
		verify(copia).hacerCopia(servicos);
	}
	
	@Test
	public void hacerCopiaExist(){
		IServicioDeCopia copia = mock(IServicioDeCopia.class);
		when(copia.existeCopia(servicos)).thenReturn(true);
		servicos.hacerCopiaDeSeguridad(copia);
		verify(copia, never()).hacerCopia(servicos);
	}

}
