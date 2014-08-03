package cuentaGUI;
/*********************************************************

 *   Segunda Vista para Cuenta
 *********************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelCuenta2 extends JPanel implements VistaCuenta {
	private JTextField cantidadJTF;
	private JLabel saldoJL;
	private JLabel mensajeJL;
	private JButton ingresarJB;
	private JButton extraerJB;
	private JButton saldoJB;

	public PanelCuenta2() {
		cantidadJTF = new JTextField(10);
		saldoJL = new JLabel(" ");
		mensajeJL = new JLabel(" ");
		ingresarJB = new JButton("Ingresar");
		extraerJB = new JButton("Extraer");
		saldoJB = new JButton("Saldo");
		setLayout(new BorderLayout());
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(2, 1));
		cantidadJTF.setBorder(BorderFactory.createTitledBorder("Cantidad"));
		panelC.add(cantidadJTF);
		saldoJL.setBorder(BorderFactory.createTitledBorder("Saldo"));
		panelC.add(saldoJL);
		add(panelC, BorderLayout.CENTER);
		JPanel panelD = new JPanel();
		panelD.setLayout(new GridLayout(3, 1));
		panelD.add(ingresarJB);
		panelD.add(extraerJB);
		panelD.add(saldoJB);
		add(panelD, BorderLayout.EAST);
		mensajeJL.setBorder(BorderFactory.createTitledBorder("Mensaje"));
		add(mensajeJL, BorderLayout.SOUTH);
	}

	public void controlador(ActionListener ctr) {
		ingresarJB.addActionListener(ctr);
		ingresarJB.setActionCommand(INGRESO);
		extraerJB.addActionListener(ctr);
		extraerJB.setActionCommand(GASTO);
		saldoJB.addActionListener(ctr);
		saldoJB.setActionCommand(SALDO);
	}

	public double obtenerCantidad() {
		return Double.parseDouble(cantidadJTF.getText());
	}

	public void saldo(double cantidad) {
		saldoJL.setText(String.format("%12.2f", cantidad));
	}

	public void mensaje(String msg) {
		mensajeJL.setText(msg);
	}

}
