package testes;

import java.awt.Component;

import javax.swing.JFrame;

public class DemoNome {
	public static void main(String[] args) {
		IntMeuNome vista = new MeuNome();
		Nome modelo = new Nome("Lucas");
		ControlerNome controler = new ControlerNome(vista, modelo);
		vista.controlador(controler);
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.add((Component) vista);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}
