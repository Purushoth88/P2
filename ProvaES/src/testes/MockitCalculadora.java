package testes;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MockitCalculadora {

	InterfaceCalculadora cal;
	
	@Before
	public void inicio(){
		cal = mock(InterfaceCalculadora.class);
	}
	
	@Test
	public void soma(){
		when(cal.somar(5,1.6)).thenReturn(6.6);
		assertTrue(cal.somar(5,1.6)==6.6);
	}
	
	@Test
	public void subtratir(){
		when(cal.subitrar(1,10)).thenReturn(-10.0);
		when(cal.subitrar(1,-10)).thenReturn(11.0);
		assertTrue(cal.subitrar(1,10)==-10.0);
		assertTrue(cal.subitrar(1,-10)==11.0);
	}
	
	@Test
	public void dividir() throws Exception{
		when(cal.dividir(anyDouble(), eq(0))).thenThrow(new Exception("error"));
		when(cal.dividir(6, 2)).thenReturn(3.0);
		System.out.println(cal.dividir(4, 0));
		assertTrue(cal.dividir(6, 2)==3);
	}

}

