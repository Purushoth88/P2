import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;


public class PanelCuentas2 extends JPanel implements VistaCuenta{
	
	private JTextField cantidadJTF;
	private JLabel saldoJL,mensajeJL;
	private JButton ingresarJB,extraerJB;
	
	public PanelCuentas2(){
		
		setLayout(new GridLayout(1,2));
		
		cantidadJTF = new JTextField(10);
		saldoJL = new JLabel("         Saldo: ");
		mensajeJL = new JLabel(" ");
		ingresarJB = new JButton("Ingresar");
		extraerJB = new JButton("Extraer");
		
		//Panel esquerdo
		JPanel panelEsq = new JPanel();
		panelEsq.setLayout(new BorderLayout(2, 2));
		panelEsq.add(cantidadJTF, BorderLayout.NORTH);
		panelEsq.add(ingresarJB,BorderLayout.WEST);
		panelEsq.add(extraerJB,BorderLayout.CENTER);
		
		//Panel direcho
		JPanel panelDir = new JPanel();
		panelDir.setLayout(new BorderLayout());
		panelDir.add(saldoJL, BorderLayout.CENTER);
		panelDir.add(mensajeJL, BorderLayout.SOUTH);
		
		
		add(panelEsq,BorderLayout.WEST);
		add(panelDir,BorderLayout.CENTER);
		
	}

	public void controlador(ActionListener ctr) {
		ingresarJB.addActionListener(ctr);
		ingresarJB.setActionCommand(INGRESO);
		extraerJB.addActionListener(ctr);
		extraerJB.setActionCommand(GASTO);

	}

	public double obtenerCantidad() {
		return Double.parseDouble(cantidadJTF.getText());
	}

	public void saldo(double cantidad) {
		saldoJL.setText("         Saldo: "+String.format("%12.2f", cantidad));
	}

	public void mensaje(String msg) {
		mensajeJL.setText(msg);
	}
	
}
