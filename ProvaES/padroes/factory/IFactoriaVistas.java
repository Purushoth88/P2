package factory;

import mvc.vista.IVistaCuenta;

public interface IFactoriaVistas {
	
	IVistaCuenta creator(String tipo);
}
