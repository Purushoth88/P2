package JUnit;

import static org.junit.Assert.*;

import javax.naming.directory.InvalidAttributesException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteBuffer {
	
	private Buffer buffer,buffer2;
	
	@Before
	public void BufferTest() throws InvalidAttributesException{
		buffer = new Buffer(3);
		assertTrue(buffer.isEmpty());
		assertFalse(buffer.isFull());
		//assertEquals("Tamano no es valido", new Buffer(-3));
	
	}
	
	@After
	public void EstadoInicial(){
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class) 
	public void addTest() throws IndexOutOfBoundsException, InvalidAttributesException {
		buffer.put(10);
		buffer.put(20);
		buffer.put(30);
		
		assertTrue(buffer.isFull());
		
		buffer.put(40);
		
		assertEquals(10,buffer.get(10));
		assertEquals(20,buffer.get(20));
		assertEquals(30,buffer.get(30));
		
	}
	
	@Test (expected = InvalidAttributesException.class)
	public void getTest() throws InvalidAttributesException{
		
		buffer.put(10);
		assertFalse(buffer.isFull());
		buffer.put(30);
		assertFalse(buffer.isFull());
		buffer.put(30);
		assertTrue(buffer.isFull());
		buffer.get(5555);
		
		assertFalse(buffer.isEmpty());
		assertEquals(10, buffer.get(10));
		assertEquals(30, buffer.get(30));
		assertEquals(30, buffer.get(30));
		assertEquals(30, buffer.get(30));
		assertTrue(buffer.isEmpty());
	}
	
	@Test
	public void emptyTest(){
		assertTrue(buffer.isEmpty());
		buffer.put(10);
		buffer.put(30);
		buffer.put(40);
		assertFalse(buffer.isEmpty());
	}
	
	@Test
	public void fullTest(){
		assertFalse(buffer.isFull());
		buffer.put(10);
		buffer.put(30);
		buffer.put(40);
		assertTrue(buffer.isFull());
	}
	
	

}
