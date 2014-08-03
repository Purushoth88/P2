package ConvertEuroDolarGUI;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ConverteDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Converter");
		//PanelConverter1 vista = new PanelConverter1();
		PanelConverter2 vista = new PanelConverter2();
		Converter converter = new Converter();
		ActionListener controler = new CtrConverter(vista, converter);
		vista.controlador(controler);
		
		frame.add(vista);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
