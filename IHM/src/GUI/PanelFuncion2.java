package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PanelFuncion2 extends JPanel {
	
	private JPanel panelBotoes, panelCommitHist, panelCommit, panelFilesAdd, panelFilesRemove, panelEsq;
	private JButton addB,removeB,desfazerB,commitB;
	private JTextArea commitHistTxt, filesAddTxt, commitTxt, filesRemoveTxt;
	private AvisoCommitGUI aviso;
	private JTabbedPane panelTabeCommit, panelTabFiles;
	
	public PanelFuncion2(){
		
		
		//Criando elementos
		addB = new JButton("ADD        ");
		addB.setIcon(new ImageIcon("C:\\Users\\Lucas\\workspace\\IHM\\imagens\\add-2-icon.png"));
		removeB = new JButton("Remove  ");
		removeB.setIcon(new ImageIcon("C:\\Users\\Lucas\\workspace\\IHM\\imagens\\Action-remove-icon.png"));
		commitB = new JButton("Commit", new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Action-db-commit-icon.png"));
		commitB.setToolTipText("Guarda los cambios realizados (es irreversible)");
		desfazerB = new JButton("Checkout");
		desfazerB.setIcon(new ImageIcon("C:\\Users\\Lucas\\workspace\\IHM\\imagens\\undo-icon.png"));
		filesAddTxt = new JTextArea();
		filesAddTxt.setRows(5);
		filesAddTxt.setEditable(false);
		filesRemoveTxt = new JTextArea();
		filesRemoveTxt.setEditable(false);
		commitTxt = new JTextArea();
		commitTxt.setToolTipText("Introduzca el texto ser\u00E1 enlazada a el commit");
		commitTxt.setRows(3);
		commitTxt.setSize(100, 200);
		

		
		
		//Criando Panel Commits
		commitHistTxt = new JTextArea();
		commitHistTxt.setEditable(false);
		JScrollPane scroll = new JScrollPane(commitHistTxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(400,100));
		panelCommitHist = new JPanel();
		panelCommitHist.add(scroll);
		
		panelCommit = new JPanel();
		JScrollPane scroll2 = new JScrollPane(commitTxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400,100));
		
		panelCommit.setLayout(new BorderLayout(10,10));
		panelCommit.add(scroll2,BorderLayout.NORTH);
		panelCommit.add(commitB, BorderLayout.EAST);
		
		panelTabeCommit = new JTabbedPane();
		panelTabeCommit.setBorder(BorderFactory.createTitledBorder(""));
		panelTabeCommit.addTab("Hacer Commit",new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Actions-document-save-icon.png") ,panelCommit);
		panelTabeCommit.addTab("Commits Hechos", new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/doc-icon.png") ,panelCommitHist);
		
		
		
		//Criando Panel de Botoes
//		panelBotoes = new JPanel();
//		JPanel panelBotoesAux = new JPanel();
//		panelBotoes.setLayout(new BoxLayout(panelBotoes, BoxLayout.Y_AXIS));
//		panelBotoes.setBorder(BorderFactory.createTitledBorder(""));
//		
//		
//		addB.setAlignmentX(Component.CENTER_ALIGNMENT);
//		removeB.setAlignmentX(Component.CENTER_ALIGNMENT);
//		desfazerB.setAlignmentX(Component.CENTER_ALIGNMENT);
//		panelBotoes.add(Box.createRigidArea(new Dimension(0,60)));
//		panelBotoes.add(addB);
//		panelBotoes.add(Box.createRigidArea(new Dimension(0,20)));
//		panelBotoes.add(removeB);
//		panelBotoes.add(Box.createRigidArea(new Dimension(0,20)));
//		panelBotoes.add(desfazerB);
		
		
		//Criando Panel Files
		panelFilesAdd = new JPanel();
		JScrollPane scroll1 = new JScrollPane(filesAddTxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setPreferredSize(new Dimension(400,100));
		panelFilesAdd.add(scroll1);
		
		panelFilesRemove = new JPanel();
		JScrollPane scrollFilesRemove = new JScrollPane(filesRemoveTxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollFilesRemove.setPreferredSize(new Dimension(400,100));
		panelFilesRemove = new JPanel();
		panelFilesRemove.add(scrollFilesRemove);
		
		panelTabFiles = new JTabbedPane();
		panelTabFiles.setBorder(BorderFactory.createTitledBorder(""));
		panelTabFiles.setPreferredSize(new Dimension(400,100));
		panelTabFiles.addTab("Files ADD",new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Document-Add-icon.png") ,panelFilesAdd);
		panelTabFiles.addTab("Files Remove", new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Document-Delete-icon.png") ,panelFilesRemove);
		
		
		//Panel Esquerdo (commit + files)
		panelEsq = new JPanel();
		panelEsq.setLayout(new BorderLayout(5,5));
		panelEsq.add(panelTabFiles, BorderLayout.CENTER);
		panelEsq.add(panelTabeCommit, BorderLayout.NORTH);
		
		
		
		//FeedBack
		panelTabeCommit.setToolTipTextAt(0, "Hacer un nuevo commit");
		panelTabeCommit.setToolTipTextAt(1, "Muestra todas los commits hechos");
		panelTabFiles.setToolTipTextAt(0, "Cola de ficheros para añadir");
		panelTabFiles.setToolTipTextAt(1, "Cola de ficheros para remover");
		
		
		
		
		//Add no panel principal
		setLayout(new BorderLayout(27,27));
		//add(panelBotoes,BorderLayout.WEST);
		add(panelEsq, BorderLayout.CENTER);
		
	}
	
	
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		PanelFuncion2 panel = new PanelFuncion2();
//		frame.getContentPane().add(panel);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
//		frame.pack();
//	}
//	
	
}