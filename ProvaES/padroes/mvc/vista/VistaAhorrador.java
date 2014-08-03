package mvc.vista;

/*********************************************************
 * Vista Ahorrador para Cuenta
 * Solo puede ingresar y consultar
 *********************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory;


@SuppressWarnings("serial")
public class VistaAhorrador extends JPanel implements IVistaCuenta {
	
	private JLabel mensajeJL;
	private JLabel rotuloCantidadJL;
	private JLabel rotuloSaldoJL;
	private JTextField cantidadJTF;
	private JLabel saldoJL;
	private JButton ingresarJB;
	private JButton saldoJB;
	

	public VistaAhorrador() {
		// Definicion de componentes basicos
		cantidadJTF = new JTextField(10);
		saldoJL = new JLabel(" ", SwingConstants.RIGHT);
		mensajeJL = new JLabel(" ",SwingConstants.RIGHT);
		ingresarJB = new JButton("Ingresar");
		saldoJB = new JButton("Consulta de Saldo");
		rotuloCantidadJL = new JLabel("Cantidad a Ingresar");
		rotuloSaldoJL = new JLabel("Saldo actual", SwingConstants.CENTER);
		
		
		// Panel central para ingresos
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(3, 1));
		panelC.add(rotuloCantidadJL);
		panelC.add(cantidadJTF);
		panelC.add(ingresarJB);
		panelC.setBackground(Color.ORANGE);
		
		// Panel Este para consulta de saldo
		JPanel panelE = new JPanel();
		panelE.setLayout(new GridLayout(3, 1));
		panelE.add(rotuloSaldoJL);
		panelE.add(saldoJL);
		panelE.add(saldoJB);
		
		// Panel Sur para el mensaje
		JPanel panelS = new JPanel();
		panelS.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panelS.add(mensajeJL);
		panelS.setBackground(Color.ORANGE);
		
		// Confeccion del panel principal de contenidos
		setLayout(new BorderLayout());
		add(panelC, BorderLayout.CENTER);
		add(panelE, BorderLayout.EAST);
		add(panelS, BorderLayout.SOUTH);
	}

	public void controlador(ActionListener ctr) {
		ingresarJB.addActionListener(ctr);
		ingresarJB.setActionCommand(INGRESO);
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
