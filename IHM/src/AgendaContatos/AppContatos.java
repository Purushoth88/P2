package AgendaContatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public class AppContatos {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MainPanelContato main = new MainPanelContato();
		frame.setLayout(new BorderLayout(5,5));
		frame.add(main);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		JMenuBar menu = new JMenuBar();
		menu.add(new JLabel("   "));
		frame.setJMenuBar(menu);
	
	}

}
