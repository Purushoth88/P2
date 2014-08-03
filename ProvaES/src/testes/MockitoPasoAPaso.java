package testes;

/* 
 * Ejemplos B�sicos del API de Mockito
 * @author Pablo L�pez
 *
 * Este fichero contiene algunos ejemplos b�sicos de uso de Mockito.
 * La finalidad es mostrar el uso b�sico del API de Mockito.
 * 
 * No se trata de un buen ejemplo de mocking.
 * 
 * En un ejemplo real de mocking tenemos un objeto que se desea testear
 * y unos colaboradores necesarios que son los objetos sobre los que
 * hacemos mocking. Por el contrario, en los siguientes ejemplos hacemos
 * mocking sobre unos objetos que no son colaboradores.
 * 
 * Basado en "Mockito in Six Easy Examples"
 * http://gojko.net/2009/10/23/mockito-in-six-easy-examples/
 */

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Iterator;
import java.util.List;

public class MockitoPasoAPaso {
	
	// Por defecto las operaciones sobre un objeto mock devuelven
	// el "nulo" de su tipo (null, 0, false...).
	
	@Test
	public void vaciosPorDefecto(){
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		Iterator i = mock(Iterator.class);
		
		// usar el objeto mock 
		Object result = i.next();
		boolean hayM�s = i.hasNext();
		
		// comprobar interacciones y resultados del objeto mock
		verify(i).next();
		verify(i).hasNext();
		assertNull(result);
		assertFalse(hayM�s);
	}	

	// Se puede especificar la respuesta esperada de un
	// m�todo sin argumentos del objeto mock.
	
	@Test
	public void respuestaEsperada(){
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		Iterator i= mock(Iterator.class);
		
		// especificar respuesta esperada
		when(i.next()).thenReturn("hola");
		when(i.hasNext()).thenReturn(true);
		
		// usar el objeto mock
		String result = (String) i.next();
		boolean hayM�s = i.hasNext();
		String dosVeces = i.next() + " " + i.next();
		
		// comprobar interacciones y resultados del objeto mock
		verify(i, times(3)).next();
		verify(i).hasNext();
		assertEquals("hola", result);
		assertTrue(hayM�s);
		assertEquals("hola hola", dosVeces);
	}	

	// Se puede especificar una secuencia de respuestas esperadas
	// de un m�todo sin argumentos de un objeto mock. Las secuencia
	// especifica la respuesta esperada de las n primeras invocaciones;
	// las siguientes invocaciones devuelven el �ltimo valor de la secuencia.
	
	@Test
	public void secuenciaEsperada(){
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		Iterator i= mock(Iterator.class);
		
		// especificar la secuencia de respuestas esperadas 
		when(i.next()).thenReturn("hola").thenReturn("adi�s");
		//             primera llamada    segunda y sucesivas llamadas
		
		// usar el objeto mock
		String result = i.next() + " " + i.next();
		String �ltimo = i.next() + " " + i.next();
		
		// comprobar interacciones y resultados del objeto mock
		verify(i, times(4)).next();
		assertEquals("hola adi�s", result);
		assertEquals("adi�s adi�s", �ltimo);
	}
	
	// La secuencia de respuestas esperadas se puede facilitar
	// con una sintaxis simplificada
	
	@Test
	public void secuenciaEsperadaCompacta(){
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		Iterator i= mock(Iterator.class);
		
		// especificar la secuencia de respuestas esperadas de forma compacta
		when(i.next()).thenReturn("hola",  "adi�s");
		//                        primera   segunda y sucesivas llamadas
		
		// usar el objeto mock
		String result = i.next() + " " + i.next();
		String �ltimo = i.next() + " " + i.next();
		
		// comprobar interacciones y resultados del objeto mock
		verify(i, times(4)).next();
		assertEquals("hola adi�s", result);
		assertEquals("adi�s adi�s", �ltimo);
	}	
	
	// Si un m�todo del objeto mock acepta argumentos, se pueden
	// especificar las respuestas esperadas seg�n los valores de los
	// argumentos. Para los valores de los argumentos no especificados
	// se devuelve el "vac�o".
	
	@Test
	public void respuestaSeg�nArgumento() {
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		List l = mock(List.class);

		// especificar respuesta esperada seg�n el argumento
		when(l.get(0)).thenReturn("uno");
		when(l.get(1)).thenReturn("dos");
		when(l.get(2)).thenReturn("tres");
		
		// usar el objeto mock
		String result = l.get(0) + " " + l.get(1) + " " + l.get(2);
		String noDefinido = (String) l.get(500); // vac�o por defecto
		
		// comprobar interacciones y resultados del objeto mock
		verify(l).get(0);
		verify(l).get(1);
		verify(l).get(2);
		assertEquals("uno dos tres", result);
		verify(l).get(500);
		assertNull(noDefinido);
	}
	
	// Si un m�todo del objeto mock acepta argumentos, se pueden
	// especificar un argumento comod�n y su respuesta esperada.
	
	@Test
	public void argumentoComod�n() {
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		List l = mock(List.class);
		
		// especificar respuesta para el argumento comod�n
		when(l.get(anyInt())).thenReturn("banana");
	
		// usar el objeto mock
		String result = l.get(0) + " " + l.get(1) + " " + l.get(2) + " " + l.get(100);
		
		// comprobar interacciones y resultados del objeto mock
		verify(l).get(0);
		verify(l).get(1);
		verify(l).get(2);
		verify(l).get(100);
		assertEquals("banana banana banana banana", result);
	}
	
	// Si un m�todo del objeto mock acepta argumentos, se pueden
	// especificar un argumento comod�n y su respuesta esperada;
	// adem�s, se pueden especificar respuestas esperadas para
	// argumentos concretos. El orden es importante: primero el
	// comod�n y luego los casos concretos.
	
	@Test
	public void argumentoComod�nYCasosConcretos() {
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		List l = mock(List.class);
		
		// especificar respuesta comod�n
		when(l.get(anyInt())).thenReturn("banana");
		// especificar respuesta seg�n argumento concreto
		when(l.get(0)).thenReturn("uno");
		when(l.get(1)).thenReturn("dos");
		when(l.get(2)).thenReturn("tres");

		// usar el objeto mock
		String result = l.get(0) + " " + l.get(1) + " " + l.get(2) + " " + l.get(100);
		
		// comprobar interacciones y resultados del objeto mock
		verify(l).get(0);
		verify(l).get(1);
		verify(l).get(2);
		verify(l).get(100);
		assertEquals("uno dos tres banana", result);
	}		
	
	// Si un m�todo del objeto mock puede elevar una excepci�n,
	// se puede especificar tal comportamiento. Cuando se eleva
	// la excepci�n se interrumpe el flujo de control; el comportamiento
	// se comprueba con el "expected" de JUnit.
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void elevarExcepci�n() {
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		List l = mock(List.class);
		
		// especificar respuesta para argumento comod�n
		when(l.get(anyInt())).thenThrow(new IndexOutOfBoundsException());
		// especificar respuesta seg�n argumento concreto
		when(l.get(0)).thenReturn("uno");
		when(l.get(1)).thenReturn("dos");
		when(l.get(2)).thenReturn("tres");
		
		// usar el objeto mock
		
		System.out.println(l.get(0) + " " + l.get(1) + " " + l.get(2) + " " + l.get(100));

		// la anterior sentencia eleva una excepci�n; lo que queremos verificar
		// es su propagaci�n con "expected"
	}	
}

