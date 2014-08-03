package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GitMainPanel extends JPanel {
	
	private JFrame frame;
	private PanelTree panelTree;
	private PanelFuncion panelFuncion;
	private JPanel mainPanel;
	
	public GitMainPanel(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		frame = new JFrame("Git");
		panelFuncion = new PanelFuncion();
		panelTree = new PanelTree("C:/");
		
		mainPanel.add(panelFuncion, BorderLayout.WEST);
		mainPanel.add(panelTree,BorderLayout.CENTER);
		
		frame.add(mainPanel);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}
