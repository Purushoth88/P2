package testes;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class Mockito {
	
	GestorLogin gestor;
	ICuenta cuenta;
	IRepositorioCuentas rep;
	
	@Before
	public void initTest(){
		rep = mock(IRepositorioCuentas.class);
		cuenta = mock(ICuenta.class);
		when(rep.buscar("lucas")).thenReturn(cuenta);
		gestor = new GestorLogin(rep);
	}
	
	@Test
	public void acessaCorreto() throws CuentaExpection{
		
		when(cuenta.claveCorrecta("1234")).thenReturn(true);
		when(cuenta.estaBloqueada()).thenReturn(false);
		when(cuenta.estaEnUso()).thenReturn(false);
		
		gestor.acceder("lucas", "1234");
		verify(cuenta).entrarCuenta();
		
		
	}
	
	@Test
	public void negarPrimeira() throws CuentaExpection{
		
		when(cuenta.claveCorrecta("1234")).thenReturn(false);
		when(cuenta.estaBloqueada()).thenReturn(false);
		when(cuenta.estaEnUso()).thenReturn(false);
		
		gestor.acceder("lucas", "1234");
		verify(cuenta,never()).entrarCuenta();
		
		when(cuenta.claveCorrecta("1234")).thenReturn(true);
		
		gestor.acceder("lucas", "1234");
		verify(cuenta,times(1)).entrarCuenta();
	}
	
	@Test (expected = CuentaExpection.class)
	public void usuarioDesconocido() throws CuentaExpection{
		when(rep.buscar("lucas")).thenReturn(null);
		gestor.acceder("lucas", "1234");
		verify(cuenta, never()).entrarCuenta();
		
	}
	
	@Test
	public void bloqueia() throws CuentaExpection{
		when(cuenta.claveCorrecta(anyString())).thenReturn(false);
		when(cuenta.estaBloqueada()).thenReturn(false);
		when(cuenta.estaEnUso()).thenReturn(false);
		
		gestor.acceder("lucas", "r");
		gestor.acceder("lucas", "s");
		gestor.acceder("lucas", "w");
		verify(cuenta, never()).entrarCuenta();
		verify(cuenta).bloquearCuenta();
	}
	
	@Test
	public void accederUnFallo() throws CuentaExpection{
		when(cuenta.claveCorrecta(anyString())).thenReturn(false);
		when(cuenta.claveCorrecta("1234")).thenReturn(true);
		when(cuenta.estaBloqueada()).thenReturn(false);
		when(cuenta.estaEnUso()).thenReturn(false);
		gestor.acceder("lucas", "r");
		gestor.acceder("lucas", "1234");
		verify(cuenta, timeout(1)).entrarCuenta();
		verify(cuenta, times(1)).entrarCuenta();
		
	}
	
	@Test
	public void accederDosFallos() throws CuentaExpection{
		when(cuenta.claveCorrecta(anyString())).thenReturn(false);
		when(cuenta.claveCorrecta("1234")).thenReturn(true);
		when(cuenta.estaBloqueada()).thenReturn(false);
		when(cuenta.estaEnUso()).thenReturn(false);
		gestor.acceder("lucas", "r");
		gestor.acceder("lucas", "rr");
		gestor.acceder("lucas", "1234");
		verify(cuenta, timeout(2)).entrarCuenta();
		verify(cuenta, times(1)).entrarCuenta();
	}
	
	@Test
	public void bloquea() throws CuentaExpection{
		when(cuenta.claveCorrecta(anyString())).thenReturn(false);
		when(cuenta.estaBloqueada()).thenReturn(false);
		when(cuenta.estaEnUso()).thenReturn(false);
		gestor.acceder("lucas", "r");
		gestor.acceder("lucas", "rr");
		gestor.acceder("lucas", "1234");
		gestor.acceder("lucas", "123ss4");
		verify(cuenta, never()).entrarCuenta();
		verify(cuenta).bloquearCuenta();
	}
	
	@Test
	public void accederOtros() throws CuentaExpection{
		when(rep.buscar("fulano")).thenReturn(cuenta);
	
		when(cuenta.claveCorrecta(anyString())).thenReturn(true);
		when(cuenta.estaBloqueada()).thenReturn(false);
		when(cuenta.estaEnUso()).thenReturn(false);
		gestor.acceder("lucas", "r");
		gestor.acceder("fulano", "rr");
		verify(cuenta, times(2)).entrarCuenta();

	}
	
	@Test
	public void negarAcessoBloqueadas() throws CuentaExpection{
		when(cuenta.estaBloqueada()).thenReturn(true);
		when(cuenta.claveCorrecta(anyString())).thenReturn(true);
		gestor.acceder("lucas", "1234");
		verify(cuenta, never()).entrarCuenta();
	}
}
