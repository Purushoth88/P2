package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBuffer {

	private Buffer buffer;
	
	@Before
	public void iniciotest() throws BufferExpection{
		buffer = new Buffer(3);
		assertTrue(buffer.isEmpty());
	}
	
	@Test(expected = BufferExpection.class)
	public void put() throws BufferExpection{
		assertTrue(buffer.isEmpty());
		buffer.put(2);
		buffer.put(3);
		buffer.put(4);
		buffer.put(5);
		assertTrue(buffer.isFull());
		assertEquals(2, buffer.get(2));
		assertEquals(3, buffer.get(3));
		assertEquals(4, buffer.get(5));		
		
	}

}

