package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotoes extends JPanel {

	private JButton addB,removeB,desfazerB;
	
	public PanelBotoes(){  
		
		addB = new JButton(" ADD       ");
		addB.setToolTipText("Seleccione un fichero para a\u00F1adir");
		removeB = new JButton("Remove  ");
		removeB.setToolTipText("Seleccionar un archivo del Git Repositorio para eliminar");
		desfazerB = new JButton("Checkout");
		desfazerB.setToolTipText("Deshacer una acci\u00F3n que no se ha hecho commit");
		
		addB.setIcon(new ImageIcon("C:\\Users\\Lucas\\workspace\\IHM\\imagens\\data-add-icon.png"));
		removeB.setIcon(new ImageIcon("C:\\Users\\Lucas\\workspace\\IHM\\imagens\\data-remove-icon.png"));
		desfazerB.setIcon(new ImageIcon("C:\\Users\\Lucas\\workspace\\IHM\\imagens\\data-undo-icon.png"));
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderFactory.createTitledBorder(""));
		
		
		addB.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeB.setAlignmentX(Component.CENTER_ALIGNMENT);
		desfazerB.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(20,10)));
		add(addB);
		add(Box.createRigidArea(new Dimension(10,20)));
		add(removeB);
		add(Box.createRigidArea(new Dimension(10,20)));
		add(desfazerB);
	}

}
