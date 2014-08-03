package ConvertEuroDolarGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelConverter2 extends JPanel implements VistaConverter {
	
	private JPanel panelEsq, panelDir;
	private JLabel mensajem;
	private JTextField inputCantidad;
	private JButton convertEuroToDolarB, convertDolarToEuroB;
	
	public PanelConverter2() {
		
		setLayout(new GridLayout(2,2));
		
		//Criando os elementos
		mensajem = new JLabel(" ");
		mensajem.setBorder(BorderFactory.createTitledBorder("Resultado"));
		inputCantidad = new JTextField(10);
		inputCantidad.setBorder(BorderFactory.createTitledBorder("Cantidad"));
		convertDolarToEuroB = new JButton("Dolar to Euro");
		convertEuroToDolarB = new JButton("Euro to Dolar");
		panelDir=new JPanel();
		
		//add elementos no panel
		add(inputCantidad);
		add(convertDolarToEuroB);
		add(mensajem);
		add(convertEuroToDolarB);
		
	}

	@Override
	public double obtenerValor() {
		return Double.parseDouble(inputCantidad.getText());
	}

	@Override
	public void mensajem(String msg) {
		mensajem.setText(msg);
	}


	@Override
	public void controlador(ActionListener ctr) {
		convertDolarToEuroB.addActionListener(ctr);
		convertDolarToEuroB.setActionCommand(CONVERTTOEURO);
		convertEuroToDolarB.addActionListener(ctr);
		convertEuroToDolarB.setActionCommand(CONVERTTODOLAR);
	}
}
