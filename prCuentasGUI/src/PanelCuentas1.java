import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelCuentas1 extends JPanel implements VistaCuenta {
	
	private JPanel panel,panel2;
	private JButton ingresarB, extraerB, saldoB;
	private JLabel cantidadTxt, saldoTxt, valorSaldoTxt, msgTxt;
	private JTextField inputValor;
	
	public PanelCuentas1(){
		
		//Defenindo o layout da tela
		setLayout(new BorderLayout());
				
		//Criando elementos
		ingresarB = new JButton("Ingresar");
		extraerB = new JButton("Extraer");
		saldoB = new JButton("Salado");
		cantidadTxt = new  JLabel("Cantidad");
		saldoTxt = new  JLabel("Saldo");
		valorSaldoTxt = new  JLabel();
		msgTxt = new  JLabel();
		inputValor = new JTextField(10);
		
		//Panel central
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		panel.add(cantidadTxt);
		panel.add(inputValor);
		panel.add(saldoTxt);
		panel.add(valorSaldoTxt);
		
		
		//panel direito
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(ingresarB);
		panel2.add(extraerB);
		panel2.add(saldoB);
		
		add(panel, BorderLayout.CENTER);
		add(panel2,BorderLayout.EAST);
		add(msgTxt, BorderLayout.SOUTH);
		
	}

	@Override
	public double obtenerCantidad() {
		return Double.parseDouble(inputValor.getText());
	}

	@Override
	public void saldo(double saldo) {
		valorSaldoTxt.setText(saldo+"");
	}

	@Override
	public void mensaje(String msg) {
		msgTxt.setText(msg);
	}

	@Override
	public void controlador(ActionListener ctr) {
		ingresarB.addActionListener(ctr);
		ingresarB.setActionCommand(INGRESO);
		extraerB.addActionListener(ctr);
		extraerB.setActionCommand(GASTO);
		saldoB.addActionListener(ctr);
		saldoB.setActionCommand(SALDO);
		
	}
	
}

