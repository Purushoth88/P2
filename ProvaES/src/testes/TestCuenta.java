package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCuenta {
	
	private Cuenta cuenta;
	
	@Before
	public void inicio() throws CuentaExpection{
		cuenta = new Cuenta(3000.0);
	}
	
	@Test 
	public void testCriarContaSaldoNegativo(){
		cuenta = new Cuenta(-333.4);
		assertEquals(0, cuenta.saldo(),1);
	}
	
	@Test (expected = CuentaExpection.class)
	public void testInserir() throws CuentaExpection{
		cuenta.ingresa(2000);
		cuenta.ingresa(-3000.0);
		assertEquals("teste Inserir",5000.0, cuenta.saldo(),1);
	}
	
	@Test
	public void testCriarContaSalgoZero() throws CuentaExpection{
		cuenta = new Cuenta(0);
		assertEquals(0.0, cuenta.saldo(),1);
	}
	
	@Test 
	public void testExtrair() throws CuentaExpection{
		cuenta.extrae(2000.0);
		
		assertEquals(1000.0, cuenta.saldo(),1);
		cuenta.extrae(50000.0);
		assertEquals(0.0, cuenta.saldo(),1);
		
	}
	
	@Test (expected = CuentaExpection.class)
	public void testExtrairNegativo() throws CuentaExpection{
		assertEquals(3000.0, cuenta.saldo(),1);
		cuenta.extrae(-40.0);
		assertEquals(3000.0, cuenta.saldo(),1);
	}

}
