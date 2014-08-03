package mvc.controlador;

/*********************************************************
 *    Controlador
 *********************************************************/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import mvc.modelo.Cuenta;
import mvc.modelo.ISubject;
import mvc.vista.IVistaCuenta;;

public class CtrCuenta implements ActionListener, IObserver{

	
	private IVistaCuenta vistaCuenta;
	private Cuenta cuenta;
	

	// Al constructor se le pasan la vista y el modelo
	public CtrCuenta(IVistaCuenta vc, Cuenta c) {
		vistaCuenta = vc;
		cuenta = c;
		cuenta.addObserve(this);
		vc.saldo(c.saldo());
		vc.mensaje("cuenta inicializada con exito");
		// Asignamos el controlador a la vista, lo enganchamos
		vistaCuenta.controlador(this);
		
		
	}

	public void actionPerformed(ActionEvent evento) {

		// procesar los eventos propagados por la vista:

		String comando = evento.getActionCommand();
		vistaCuenta.mensaje(" ");

		switch (comando) {

		case IVistaCuenta.INGRESO: {
			double cantidad = vistaCuenta.obtenerCantidad();
			cuenta.ingresa(cantidad);
			vistaCuenta.saldo(cuenta.saldo());
			vistaCuenta.mensaje("Ingreso realizado con exito");
			break;
		}

		case IVistaCuenta.GASTO: {
			double cantidad = vistaCuenta.obtenerCantidad();
			double realCantidad = cuenta.extrae(cantidad);
			vistaCuenta.saldo(cuenta.saldo());
			if (cantidad != realCantidad) {
				vistaCuenta.mensaje("Extraccion limitada a "
						+ String.format("%12.2f", realCantidad));
			} else {
				vistaCuenta.mensaje("Extraccion realizada con exito");
			}
			break;
		}

		case IVistaCuenta.SALDO:
			vistaCuenta.saldo(cuenta.saldo());
			vistaCuenta.mensaje("Saldo consultado con exito");
		}
	}

	@Override
	public void upDate(double saldo) {
		vistaCuenta.saldo(saldo);
	}
}
