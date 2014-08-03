import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrCuenta implements ActionListener{
	
	private VistaCuenta vistacuenta;
	private Cuenta cuenta;
	
	public CtrCuenta(VistaCuenta vc, Cuenta cuenta){
		vistacuenta = vc;
		this.cuenta =cuenta;  
	}
	
	public void actionPerformed(ActionEvent evento){
		String comando = evento.getActionCommand();
		vistacuenta.mensaje(" ");
		
		try{
			if(comando.equals(vistacuenta.INGRESO)){
				cuenta.ingresa(vistacuenta.obtenerCantidad());
				vistacuenta.mensaje("Ingreso realizado con exito");
				vistacuenta.saldo(cuenta.saldo());
			}else if(comando.equals(vistacuenta.GASTO)){
				double cantidad = vistacuenta.obtenerCantidad();
				double realCantidad = cuenta.extrae(cantidad);
				vistacuenta.saldo(cuenta.saldo());
				if (cantidad != realCantidad) {
					vistacuenta.mensaje("Extraccion limitada a "
							+ String.format("%12.2f", realCantidad));
				} else {
					vistacuenta.mensaje("Extraccion realizada con exito");
				}
				
			}else if (comando.equals(vistacuenta.SALDO)){
				vistacuenta.saldo(cuenta.saldo());
				vistacuenta.mensaje("Su saldo es: "+cuenta.saldo());
			}
		}catch (Exception e) {
			vistacuenta.mensaje("Introduzca un valido");
		}
	}
}
