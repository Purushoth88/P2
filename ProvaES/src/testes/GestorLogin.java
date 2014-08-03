package testes;

public class GestorLogin {
	
	IRepositorioCuentas rep;
	ICuenta cuenta;
	int contador;
	final int MAX_INTENTO =3;
	
	public GestorLogin(IRepositorioCuentas rep){
		this.rep = rep;
		contador=0;
	}
	
	public void acceder(String user, String clave) throws CuentaExpection{
		cuenta=rep.buscar(user);
		if(cuenta==null){
			throw new CuentaExpection("Conta nao existe");
		}
		if(cuenta.claveCorrecta(clave)&& !cuenta.estaEnUso() && !cuenta.estaBloqueada() && contador<MAX_INTENTO){
			cuenta.entrarCuenta();
		}else{
			contador++;
			if(contador==MAX_INTENTO)
				cuenta.bloquearCuenta();
		}
	}
}
