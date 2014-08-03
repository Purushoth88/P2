package testes;

/* 
 * Ejemplos Básicos del API de Mockito
 * @author Pablo López
 *
 * Este fichero contiene algunos ejemplos básicos de uso de Mockito.
 * La finalidad es mostrar el uso básico del API de Mockito.
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
		boolean hayMás = i.hasNext();
		
		// comprobar interacciones y resultados del objeto mock
		verify(i).next();
		verify(i).hasNext();
		assertNull(result);
		assertFalse(hayMás);
	}	

	// Se puede especificar la respuesta esperada de un
	// método sin argumentos del objeto mock.
	
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
		boolean hayMás = i.hasNext();
		String dosVeces = i.next() + " " + i.next();
		
		// comprobar interacciones y resultados del objeto mock
		verify(i, times(3)).next();
		verify(i).hasNext();
		assertEquals("hola", result);
		assertTrue(hayMás);
		assertEquals("hola hola", dosVeces);
	}	

	// Se puede especificar una secuencia de respuestas esperadas
	// de un método sin argumentos de un objeto mock. Las secuencia
	// especifica la respuesta esperada de las n primeras invocaciones;
	// las siguientes invocaciones devuelven el último valor de la secuencia.
	
	@Test
	public void secuenciaEsperada(){
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		Iterator i= mock(Iterator.class);
		
		// especificar la secuencia de respuestas esperadas 
		when(i.next()).thenReturn("hola").thenReturn("adiós");
		//             primera llamada    segunda y sucesivas llamadas
		
		// usar el objeto mock
		String result = i.next() + " " + i.next();
		String último = i.next() + " " + i.next();
		
		// comprobar interacciones y resultados del objeto mock
		verify(i, times(4)).next();
		assertEquals("hola adiós", result);
		assertEquals("adiós adiós", último);
	}
	
	// La secuencia de respuestas esperadas se puede facilitar
	// con una sintaxis simplificada
	
	@Test
	public void secuenciaEsperadaCompacta(){
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		Iterator i= mock(Iterator.class);
		
		// especificar la secuencia de respuestas esperadas de forma compacta
		when(i.next()).thenReturn("hola",  "adiós");
		//                        primera   segunda y sucesivas llamadas
		
		// usar el objeto mock
		String result = i.next() + " " + i.next();
		String último = i.next() + " " + i.next();
		
		// comprobar interacciones y resultados del objeto mock
		verify(i, times(4)).next();
		assertEquals("hola adiós", result);
		assertEquals("adiós adiós", último);
	}	
	
	// Si un método del objeto mock acepta argumentos, se pueden
	// especificar las respuestas esperadas según los valores de los
	// argumentos. Para los valores de los argumentos no especificados
	// se devuelve el "vacío".
	
	@Test
	public void respuestaSegúnArgumento() {
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		List l = mock(List.class);

		// especificar respuesta esperada según el argumento
		when(l.get(0)).thenReturn("uno");
		when(l.get(1)).thenReturn("dos");
		when(l.get(2)).thenReturn("tres");
		
		// usar el objeto mock
		String result = l.get(0) + " " + l.get(1) + " " + l.get(2);
		String noDefinido = (String) l.get(500); // vacío por defecto
		
		// comprobar interacciones y resultados del objeto mock
		verify(l).get(0);
		verify(l).get(1);
		verify(l).get(2);
		assertEquals("uno dos tres", result);
		verify(l).get(500);
		assertNull(noDefinido);
	}
	
	// Si un método del objeto mock acepta argumentos, se pueden
	// especificar un argumento comodín y su respuesta esperada.
	
	@Test
	public void argumentoComodín() {
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		List l = mock(List.class);
		
		// especificar respuesta para el argumento comodín
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
	
	// Si un método del objeto mock acepta argumentos, se pueden
	// especificar un argumento comodín y su respuesta esperada;
	// además, se pueden especificar respuestas esperadas para
	// argumentos concretos. El orden es importante: primero el
	// comodín y luego los casos concretos.
	
	@Test
	public void argumentoComodínYCasosConcretos() {
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		List l = mock(List.class);
		
		// especificar respuesta comodín
		when(l.get(anyInt())).thenReturn("banana");
		// especificar respuesta según argumento concreto
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
	
	// Si un método del objeto mock puede elevar una excepción,
	// se puede especificar tal comportamiento. Cuando se eleva
	// la excepción se interrumpe el flujo de control; el comportamiento
	// se comprueba con el "expected" de JUnit.
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void elevarExcepción() {
		
		// crear el objeto mock
		@SuppressWarnings("rawtypes")
		List l = mock(List.class);
		
		// especificar respuesta para argumento comodín
		when(l.get(anyInt())).thenThrow(new IndexOutOfBoundsException());
		// especificar respuesta según argumento concreto
		when(l.get(0)).thenReturn("uno");
		when(l.get(1)).thenReturn("dos");
		when(l.get(2)).thenReturn("tres");
		
		// usar el objeto mock
		
		System.out.println(l.get(0) + " " + l.get(1) + " " + l.get(2) + " " + l.get(100));

		// la anterior sentencia eleva una excepción; lo que queremos verificar
		// es su propagación con "expected"
	}	
}

