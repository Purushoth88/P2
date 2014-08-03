package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.jgit.api.errors.NoMessageException;

import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JRadioButton;

public class GitMainPanel2 extends JPanel {

	private JFrame frame;
	private PanelTree panelTree;
	private PanelFuncion2 panelFuncion;
	private PanelBotoes panelBotoes;
	private JPanel mainPanel;
	private JPopupMenu popupMenu;
	private JRadioButton rdbtnRemover;
	
	public GitMainPanel2() {
		
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

		
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(25,25));
		frame = new JFrame("Git");
		panelFuncion = new PanelFuncion2();
		panelTree = new PanelTree("C:/");
		panelBotoes = new PanelBotoes();
		mainPanel.add(panelBotoes, BorderLayout.NORTH);
		mainPanel.add(panelFuncion, BorderLayout.EAST);
		mainPanel.add(panelTree,BorderLayout.CENTER);
		
		
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		frame.setResizable(false);
	}

	
	
}
