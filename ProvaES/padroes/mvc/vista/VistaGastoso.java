package mvc.vista;

/*********************************************************
 * Vista Gastoso para Cuenta
 * Solo puede extraer y consultar
 *********************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory;


@SuppressWarnings("serial")
public class VistaGastoso extends JPanel implements IVistaCuenta {
	
	private JLabel mensajeJL;
	private JLabel rotuloCantidadJL;
	private JLabel rotuloSaldoJL;
	private JTextField cantidadJTF;
	private JLabel saldoJL;
	private JButton extraerJB;
	private JButton saldoJB;
	

	public VistaGastoso() {
		// Definicion de componentes basicos
		cantidadJTF = new JTextField(10);
		saldoJL = new JLabel(" ", SwingConstants.CENTER);
		mensajeJL = new JLabel(" ",SwingConstants.RIGHT);
		extraerJB = new JButton("Extraer");
		saldoJB = new JButton("Consulta de Saldo");
		rotuloCantidadJL = new JLabel("Cantidad a retirar", SwingConstants.CENTER);
		rotuloSaldoJL = new JLabel("Saldo actual", SwingConstants.CENTER);
		
		// Panel central para retiradas
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(3, 1));
		panelC.add(rotuloCantidadJL);
		panelC.add(cantidadJTF);
		panelC.add(extraerJB);
		panelC.setBackground(Color.CYAN);
		panelC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Panel Oeste para consulta de saldo
		JPanel panelW = new JPanel();
		panelW.setLayout(new GridLayout(3, 1));
		panelW.add(rotuloSaldoJL);
		panelW.add(saldoJL);
		panelW.add(saldoJB);
		panelW.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Panel Sur para el mensaje
		JPanel panelS = new JPanel();
		panelS.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelS.add(mensajeJL);
		panelS.setBackground(Color.CYAN);
		panelS.setForeground(Color.WHITE);
		
		// Confeccion del panel principal de contenidos
		setLayout(new BorderLayout());
		add(panelC, BorderLayout.CENTER);
		add(panelW, BorderLayout.WEST);
		add(panelS, BorderLayout.SOUTH);
	}

	public void controlador(ActionListener ctr) {
		extraerJB.addActionListener(ctr);
		extraerJB.setActionCommand(GASTO);
		saldoJB.addActionListener(ctr);
		saldoJB.setActionCommand(SALDO);
	}

	public double obtenerCantidad() {
		return Double.parseDouble(cantidadJTF.getText());
	}

	public void saldo(double cantidad) {
		saldoJL.setText(String.format("%,12.2f", cantidad));
	}

	public void mensaje(String msg) {
		mensajeJL.setText(msg);
	}

}
