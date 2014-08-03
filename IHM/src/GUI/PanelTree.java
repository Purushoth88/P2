package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.eclipse.jgit.api.AddCommand;


import java.awt.Font;

public class PanelTree extends JPanel {

	private FileTreeFrame tree;
	private JTabbedPane panelTabe;
	
	public PanelTree(String pathName){
		
		

		
		setLayout(new BorderLayout(1,1));
		tree = new FileTreeFrame(pathName);
		panelTabe = new JTabbedPane();
		panelTabe.addTab("Git Repository ",new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Card-file-icon.png") ,tree);
		panelTabe.setToolTipTextAt(0, "Árbol de archivos del repositorio Git");
		add(panelTabe,BorderLayout.NORTH);
	}

}
