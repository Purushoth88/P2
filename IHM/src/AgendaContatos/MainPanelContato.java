package AgendaContatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ImageCapabilities;
import java.awt.print.Book;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainPanelContato extends JPanel{
	private PanelBusca panelBusca;
	private PanelCadastrar panelCadastra;
	private JTabbedPane panelTab;
	
	public MainPanelContato(){
		panelBusca = new PanelBusca();
		panelCadastra = new PanelCadastrar();
		
		panelTab = new JTabbedPane();
		panelTab.addTab("Cadastrar", new ImageIcon(), panelCadastra);
		panelTab.addTab("Buscar", new ImageIcon(), panelBusca);
		
		
		add(panelTab,BorderLayout.CENTER);
	}
}

