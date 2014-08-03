import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PanelJarras extends JPanel implements VistaJarras {
	
	private JPanel panelEsq, panelCentro, panelDir, panelBajo;
	private JLabel jarraA,jarraB,contenidoA,contenidoB,capacidadA,capacidadB,mensajeResult;
	private JTextField contenidoTxtA,contenidoTxtB,capacidadTxtA,capacidadTxtB,jarraATxt, jarraBTxt;
	private JButton llenarA,llenarB,vaciarA,vaciarB,finalizar,iniciarCapacidad,setaToB, setaToA;
	private JTextArea info;
	
	public PanelJarras(){
		
		//criando elementos
		jarraA = new JLabel("Jarra A");
		jarraB = new JLabel("Jarra B");
		contenidoA = new JLabel("Contenido: ");
		contenidoB = new JLabel("Contenido: ");
		capacidadA = new JLabel("Capacidad: ");
		capacidadB = new JLabel("Capacidad: ");
		mensajeResult = new JLabel("");
		contenidoTxtA = new JTextField(3);
		contenidoTxtB = new JTextField(3);
		capacidadTxtA = new JTextField(3);
		capacidadTxtB = new JTextField(3);
		llenarA = new JButton("Llenar");
		llenarB = new JButton("Llenar");
		vaciarA = new JButton("Vaciar");
		vaciarB = new JButton("Vaciar");
		finalizar = new JButton("Finalizar");
		iniciarCapacidad = new JButton("Iniciar Capacidades");
		setaToB = new JButton(new ImageIcon("go-next.jpg"));
		setaToA = new JButton(new ImageIcon("go-previous.jpg"));
		info = new JTextArea();
		jarraATxt = new JTextField(3);
		jarraBTxt = new JTextField(3);
		
		capacidadTxtA.setEnabled(false);
		contenidoTxtA.setEnabled(false);
		capacidadTxtB.setEnabled(false);
		contenidoTxtB.setEnabled(false);
		
		//Setando estado inicial da interface
		habilitarInicio(false);
		
		
		//Panel Esquerdo
		panelEsq = new JPanel();
		panelEsq.setLayout(new GridLayout(5,1,3,3));
		JPanel panelAuxEsq1 = new JPanel();
		panelAuxEsq1.add(jarraA);
		panelAuxEsq1.add(jarraATxt);
		JPanel panelAuxEsq2 = new JPanel();
		panelAuxEsq2.add(contenidoA);
		panelAuxEsq2.add(contenidoTxtA);
		JPanel panelAuxEsq3 = new JPanel();
		panelAuxEsq3.add(capacidadA);
		panelAuxEsq3.add(capacidadTxtA);
		panelEsq.add(panelAuxEsq1);
		panelEsq.add(llenarA);
		panelEsq.add(panelAuxEsq2);
		panelEsq.add(panelAuxEsq3);
		panelEsq.add(vaciarA);
		
		//panel centro
		panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(4,1,3,3));
		panelCentro.add(iniciarCapacidad);
		panelCentro.add(setaToB);
		panelCentro.add(setaToA);
		panelCentro.add(finalizar);
		
		//Panel direto
		panelDir = new JPanel();
		panelDir.setLayout(new GridLayout(5,1,3,3));
		JPanel panelAuxDir1 = new JPanel();
		 panelAuxDir1.add(jarraB);
		 panelAuxDir1.add(jarraBTxt);
		JPanel panelAuxDir2 = new JPanel();
		panelAuxDir2.add(contenidoB);
		panelAuxDir2.add(contenidoTxtB);
		JPanel panelAuxDir3 = new JPanel();
		panelAuxDir3.add(capacidadB);
		panelAuxDir3.add(capacidadTxtB);
		panelDir.add(panelAuxDir1);
		panelDir.add(llenarB);
		panelDir.add(panelAuxDir2);
		panelDir.add(panelAuxDir3);
		panelDir.add(vaciarB);
		
		//Panel Bajo
		panelBajo = new JPanel();
		panelBajo.setLayout(new BorderLayout());
		JScrollPane scroll = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(400,100));
		panelBajo.add(scroll,BorderLayout.NORTH);
		mensajeResult.setForeground(Color.BLUE);    
		panelBajo.add(mensajeResult, BorderLayout.SOUTH);
		
		//Panel Principal
		setLayout(new BorderLayout(3,3));
		add(panelEsq, BorderLayout.WEST);
		add(panelCentro, BorderLayout.CENTER);
		add(panelDir, BorderLayout.EAST);
		add(panelBajo, BorderLayout.SOUTH);
	}

	@Override
	public void controlador(ActionListener ctr) {
		llenarA.addActionListener(ctr);
		llenarA.setActionCommand(LLENAR_A);
		llenarB.addActionListener(ctr);
		llenarB.setActionCommand(LLENAR_B);
		vaciarA.addActionListener(ctr);
		vaciarA.setActionCommand(VACIAR_A);
		vaciarB.addActionListener(ctr);
		vaciarB.setActionCommand(VACIAR_B);
		finalizar.addActionListener(ctr);
		finalizar.setActionCommand(FINALIZAR);
		iniciarCapacidad.addActionListener(ctr);
		iniciarCapacidad.setActionCommand(INICIAR);
		setaToB.addActionListener(ctr);
		setaToB.setActionCommand(VOLCAR_A_EN_B);
		setaToA.addActionListener(ctr);
		setaToA.setActionCommand(VOLCAR_B_EN_A);
		
	}

	@Override
	public int capacidadInicialA() {
		
		try{
			return Integer.parseInt(jarraATxt.getText());
		}catch (Exception e) {
			throw new JarraCapacidadException("Cantidad invalida");
		}
		
		
	}

	@Override
	public int capacidadInicialB() {
		try{
			return Integer.parseInt(jarraBTxt.getText());
		}catch (Exception e) {
			throw new JarraCapacidadException("Cantidad invalida");
		}
	}

	@Override
	public void error(String mensaje) {
		mensajeResult.setText(mensaje);
		mensajeResult.setForeground(Color.RED);
		
	}

	@Override
	public void ok(String mensaje) {
		mensajeResult.setText(mensaje);
		mensajeResult.setForeground(Color.BLUE);
	}

	@Override
	public void habilitarInicio(boolean b) {
		llenarA.setEnabled(b);
		contenidoA.setEnabled(b);
		contenidoB.setEnabled(b);
		capacidadA.setEnabled(b);
		capacidadB.setEnabled(b);
		vaciarA.setEnabled(b);
		llenarB.setEnabled(b);
		vaciarB.setEnabled(b);
		setaToA.setEnabled(b);
		setaToB.setEnabled(b);
		finalizar.setEnabled(b);
		iniciarCapacidad.setEnabled(!b);
		jarraA.setEnabled(!b);
		jarraATxt.setEditable(!b);
		jarraB.setEnabled(!b);
		jarraBTxt.setEditable(!b);
	}

	@Override
	public void capacidadA(int c) {
		capacidadTxtA.setText(c+"");
	}

	@Override
	public void capacidadB(int c) {
		capacidadTxtB.setText(c+"");
		
	}

	@Override
	public void contenidoA(int c) {
		contenidoTxtA.setText(c+"");
	}

	@Override
	public void contenidoB(int c) {
		contenidoTxtB.setText(c+"");
	}

	@Override
	public void anadirAHistórico(String mensaje) {
		info.setText(info.getText()+("\n"+mensaje));
	}

	@Override
	public void limpiar() {
		info.setText("");
		contenidoTxtA.setText("");
		contenidoTxtB.setText("");
		capacidadTxtA.setText("");
		capacidadTxtB.setText("");
		jarraATxt.setText("");
		jarraBTxt.setText("");
	}
	

}
