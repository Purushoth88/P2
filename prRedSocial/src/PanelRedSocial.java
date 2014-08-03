import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class PanelRedSocial extends JPanel implements VistaRedSocial {

	private JTextField fichUsuarios, tope, numAmigos, fichSalida;
	private JButton initR, initRT, asignar, terminar;
	private JLabel mensaje;
	private JTextArea log;
	
	public PanelRedSocial() {
		// north panel
				JPanel north = new JPanel();
				north.setLayout(new GridLayout(2,2,5,5));
				
				JLabel fT = new JLabel("Fichero Usuarios");
				fichUsuarios = new JTextField(10);
				
				initR = new JButton("Red Social");
				
				initRT = new JButton("Red Social con Tope");
								
				//JLabel fC = new JLabel("Card File");
				//fileCards = new JTextField(10);
				JLabel topeLabel = new JLabel("Tope");
				tope = new JTextField(3);
				
				JPanel t = new JPanel();
				t.add(fT);
				t.add(fichUsuarios);
					
				JPanel ta = new JPanel();
				//ta.add(fC);
				//ta.add(fileCards);
				ta.add(topeLabel);
				ta.add(tope);
				
					
				north.add(t);
				north.add(ta);
				north.add(initR);
				north.add(initRT);
			
				
				
		// central panel
				
												
				JPanel outputData = new JPanel();
				JLabel salida = new JLabel("Fichero salida:");
				fichSalida = new JTextField(10);
				outputData.add(salida);
				outputData.add(fichSalida);
				
				terminar = new JButton("Terminar");
							
				
				JPanel asociarP = new JPanel();
				asignar = new JButton("Asignar Amigos");
				JLabel asignarL = new JLabel("NumAmigos");
				numAmigos = new JTextField(3);
				
				asociarP.add(asignarL);
				asociarP.add(numAmigos);
				asociarP.add(asignar);
								
				
				JPanel buildArea = new JPanel();
				buildArea.setLayout(new GridLayout(4,1,5,5));
				//buildArea.add(asignar);
				buildArea.add(asociarP);
				buildArea.add(outputData);
				buildArea.add(terminar);
				
				
				// text area in central panel
				log =  new JTextArea();
				JScrollPane logScroll = new JScrollPane(log);
				// central panel creation 
				JPanel central = new JPanel();
				central.setLayout(new GridLayout(2,1,5,5));
				central.add(buildArea);
				central.add(logScroll);
				
		// south panel
				mensaje = new JLabel();
				
		// main panel
				setLayout(new BorderLayout());
				
				add(north,BorderLayout.NORTH);
				add(central,BorderLayout.CENTER);
				add(mensaje,BorderLayout.SOUTH);
	}
	
	@Override
	public void controlador(ActionListener ctr) {

		initR.addActionListener(ctr);
		initR.setActionCommand(INIT_RED);
		initRT.addActionListener(ctr);
		initRT.setActionCommand(INIT_RED_TOPE);
		asignar.addActionListener(ctr);
		asignar.setActionCommand(ASIGNAR_AMIGOS);
		terminar.addActionListener(ctr);
		terminar.setActionCommand(TERMINAR);
	}

	@Override
	public String fichUsuarios() {
		return fichUsuarios.getText();
	}

	
	@Override
	public String fichSalida() {
		return fichSalida.getText();
	}
	
	@Override
	public int tope() {
		return  Integer.parseInt(tope.getText());
	}

	@Override
	public int numAmigos() {
		return  Integer.parseInt(numAmigos.getText());
	}
	
	
	@Override
	public void error(String mensaje) {
		this.mensaje.setForeground(Color.RED);
		this.mensaje.setText(mensaje);
	}

	@Override
	public void ok(String mensaje) {
		this.mensaje.setForeground(Color.BLUE);
		this.mensaje.setText(mensaje);
	}

	@Override
	public void activarInit(boolean b) {

		initR.setEnabled(b);
		initRT.setEnabled(b);
		fichUsuarios.setEnabled(b);
		tope.setEnabled(b);
				
			
		asignar.setEnabled(!b);
		numAmigos.setEnabled(!b);
		fichSalida.setEnabled(!b);
		terminar.setEnabled(!b);
		log.setEnabled(!b);
	}

	@Override
	public void addLog(String mensaje) {
		log.append(mensaje + "\n");
	}
	
	@Override
	public void clear() {
		log.setText("");
		fichUsuarios.setText("");
		tope.setText("");
		numAmigos.setText("");
		fichSalida.setText("");
	}

	

}
