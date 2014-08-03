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
public class VistaSuSaldo extends JPanel implements IVistaCuenta {
	
	private JLabel mensajeJL;
	private JLabel rotuloSaldoJL;
	private JLabel saldoJL;
	private JButton saldoJB;
	

	public VistaSuSaldo() {
		// Definicion de componentes basicos
		saldoJL = new JLabel(" ", SwingConstants.RIGHT);
		mensajeJL = new JLabel(" ",SwingConstants.RIGHT);
		saldoJB = new JButton("Consulta de Saldo");
		rotuloSaldoJL = new JLabel("Saldo actual", SwingConstants.CENTER);
		
		// Panel Norte para consulta de saldo
		JPanel panelN = new JPanel();
		panelN.setLayout(new GridLayout(3, 1));
		panelN.add(rotuloSaldoJL);
		panelN.add(saldoJL);
		panelN.add(saldoJB);
		rotuloSaldoJL.setFont(new java.awt.Font("Bradley Hand ITC", 1, 36)); // NOI18N
		saldoJL.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
		
		// Panel Sur para el mensaje
		JPanel panelS = new JPanel();
		panelS.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panelS.add(mensajeJL);
		panelS.setBackground(Color.LIGHT_GRAY);
        saldoJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		// Confeccion del panel principal de contenidos
		setLayout(new BorderLayout());
		add(panelN, BorderLayout.NORTH);
		add(panelS, BorderLayout.SOUTH);
	}

	public void controlador(ActionListener ctr) {
		saldoJB.addActionListener(ctr);
		saldoJB.setActionCommand(SALDO);
	}

	

	public void saldo(double cantidad) {
		saldoJL.setText(String.format("%,12.2f", cantidad));
	}

	public void mensaje(String msg) {
		mensajeJL.setText(msg);
	}

	@Override
	public double obtenerCantidad() {
		return 0;
	}

}
