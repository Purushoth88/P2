package factory;

import mvc.vista.IVistaCuenta;
import mvc.vista.VistaAhorrador;
import mvc.vista.VistaGastoso;
import mvc.vista.VistaNormal;
import mvc.vista.VistaSuSaldo;

public class Creator implements IFactoriaVistas {

	@Override
	public IVistaCuenta creator(String tipo) {
		IVistaCuenta vista = null;
		if(tipo.toUpperCase().equals(TipoVistas.AHORRADOR.toString())){
			vista = new VistaAhorrador();
		}else if(tipo.toUpperCase().equals(TipoVistas.GASTOSO.toString())){
			vista = new VistaGastoso();
		}else if(tipo.toUpperCase().equals(TipoVistas.NORMAL.toString())){
			vista = new VistaNormal();
		}else if(tipo.toUpperCase().equals(TipoVistas.SUSALDO.toString())){
			vista = new VistaSuSaldo();
		}
		return vista;
	}

}
