import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;


public class PanelCuentas3 extends JPanel implements VistaCuenta, ActionListener{

	private JTextField inputValor;
	private JButton ingresarB, extraerB;
	private JLabel saldo, vacio;
	private JTextArea informaciones;
	private JButton[] listBotones = new JButton[11];
	private JPanel panelEsq, panelDir,panelBajo;

	public PanelCuentas3(){


		//Look and Feel
		NimRODTheme nt = new NimRODTheme();


		nt.setPrimary1( new Color(0, 133, 235));
		nt.setPrimary2( new Color(50, 190, 255));
		nt.setPrimary3( new Color(0, 153, 255));
		nt.setSecondary1(new Color(220, 220, 220));
		nt.setSecondary2(new Color(230, 230, 230));
		nt.setSecondary3(new Color(240, 240, 240));
		nt.setWhite(new Color(250,250,250));
		nt.setBlack(new Color(0,0,0));
		nt.setMenuOpacity(195);
		nt.setFrameOpacity(180);
		
		NimRODLookAndFeel NimRODLF = new NimRODLookAndFeel();
		NimRODLF.setCurrentTheme( nt);

		try{
			//UIManager.setLookAndFeel( nimrodlf);
			UIManager.setLookAndFeel( NimRODLF);
			SwingUtilities.updateComponentTreeUI(this);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR no LookAndFeel: "+e.getMessage());
		}

		//Creat elements
		inputValor= new JTextField();
		ingresarB= new JButton("Ingresar");
		extraerB = new JButton("Extraer");
		saldo = new JLabel("Saldo: ");
		vacio = new JLabel();
		informaciones = new JTextArea();


		// Panel Esquerdo
		panelEsq = new JPanel();
		panelEsq.setLayout(new GridLayout(4,3));
		for(int i=0;i<listBotones.length;i++){
			int valor=i+1;
			System.out.println(valor+" "+i);
			if(valor==10){
				listBotones[i]= new JButton("0");
				panelEsq.add(listBotones[i]);
			}
			else if(valor==11){
				listBotones[i]= new JButton("Borrar");
				panelEsq.add(vacio);
				panelEsq.add(listBotones[i]);
			}
			else{
				listBotones[i]= new JButton(""+valor);
				panelEsq.add(listBotones[i]);
			}

		}

		//Panel derecho 
		panelDir = new JPanel();
		panelDir.setLayout(new GridLayout(2,1));
		panelDir.add(ingresarB);
		panelDir.add(extraerB);

		//Panel Bajo
		panelBajo = new JPanel();
		panelBajo.setLayout(new BorderLayout(2,2));
		JScrollPane scroll = new JScrollPane(informaciones, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(100,100));
		panelBajo.add(saldo, BorderLayout.EAST);
		panelBajo.add(scroll,BorderLayout.SOUTH);




		//Principal Panel
		setLayout(new BorderLayout(2,2));
		add(inputValor, BorderLayout.NORTH);
		add(panelEsq,BorderLayout.WEST);
		add(panelDir,BorderLayout.CENTER);
		add(panelBajo, BorderLayout.SOUTH);

	}

	@Override
	public double obtenerCantidad() {
		return Double.parseDouble(inputValor.getText());
	}

	@Override
	public void saldo(double cantidad) {
		saldo.setText("         Saldo: "+String.format("%12.2f", cantidad));

	}

	@Override
	public void mensaje(String msg) {
		String info = "\n"+msg;
		informaciones.setText(informaciones.getText()+info);

	}

	@Override
	public void controlador(ActionListener ctr) {
		ingresarB.addActionListener(ctr);
		ingresarB.setActionCommand(INGRESO);
		extraerB.addActionListener(ctr);
		extraerB.setActionCommand(GASTO);
		for(JButton bot:listBotones){
			bot.addActionListener(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object scr = e.getSource();
		if(scr.equals(listBotones[10])){
			informaciones.setText("");
			inputValor.setText("");
		}else{
			int index = 0;
			while(!scr.equals(listBotones[index]) && index<10){
				index++;
			}if(index<11){
				inputValor.setText(inputValor.getText()+(index+""));
			}
		}

	}
}
