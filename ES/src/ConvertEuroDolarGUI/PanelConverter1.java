package ConvertEuroDolarGUI;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelConverter1 extends Panel implements VistaConverter{

	private JButton convertEuroToDolarB, convertDolarToEuroB;
	private JLabel mensajemLabel, cantidadLabel;
	private JTextField inputValor;
	private JPanel panelNorte,panelSul;
	
	public PanelConverter1(){
		
		//setando layout
		setLayout(new BorderLayout());
		
		
		//Inicializando os componentes da interface
		convertDolarToEuroB = new JButton("Dolar to Euro");
		convertEuroToDolarB = new JButton("Euro to Dolar");
		cantidadLabel = new JLabel("Cantidad");
		inputValor = new JTextField();
		mensajemLabel = new JLabel(" ");
		panelNorte = new JPanel();
		panelSul= new JPanel();
		
		//add elementos no panel norte
		panelNorte.setLayout(new GridLayout(2,2));
		panelNorte.add(cantidadLabel);
		panelNorte.add(inputValor);
		panelNorte.add(mensajemLabel);
		
		//add elementos no panel Sul
		panelSul.setLayout(new GridLayout(1,2));
		panelSul.add(convertDolarToEuroB);
		panelSul.add(convertEuroToDolarB);
		
		//add elementos no panel principal
		add(panelNorte, BorderLayout.NORTH);
		add(panelSul, BorderLayout.SOUTH);
		
		
	}
	
	
	
	@Override
	public double obtenerValor() {
		return Double.parseDouble(inputValor.getText());
	}

	@Override
	public void mensajem(String msg) {
		mensajemLabel.setText(msg);
	}


	@Override
	public void controlador(ActionListener ctr) {
		convertDolarToEuroB.addActionListener(ctr);
		convertDolarToEuroB.setActionCommand(CONVERTTOEURO);
		convertEuroToDolarB.addActionListener(ctr);
		convertEuroToDolarB.setActionCommand(CONVERTTODOLAR);
	}

}
