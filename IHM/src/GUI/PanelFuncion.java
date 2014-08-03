package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class PanelFuncion extends JPanel implements VistaGitInterface{

	private JPanel panelNorte, panelSur, panelPrincipal,panelCommits,panelCommitReport;
	private JPanel panelNorteAux1,panelNorteAux2, panelAddFile,panelRemoveUndo;
	private JTabbedPane panelTabe;
	private JButton add, remove, desfazer, commit;
	private JTextField browserTxt, commitTxt;
	private JTextArea commitsHist, commitReport;
	private AvisoCommitGUI aviso;

	public PanelFuncion(){

		//Look and Feel
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR no LookAndFeel: "+e.getMessage());
		}

		//Criando os elementos
		aviso = new AvisoCommitGUI();
		add = new JButton("ADD", new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/add-2-icon.png"));
		//add = new JButton("Add", new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/add-2-icon.png"));
		remove = new JButton("Remove", new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Action-remove-icon.png"));
		desfazer = new JButton("Undo",new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/undo-icon.png"));
		commit = new JButton("Commit", new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Action-db-commit-icon.png"));
		commitTxt = new JTextField(20);
		commitsHist = new JTextArea();
		commitsHist.setEditable(false);
		commitsHist.setSize(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, WHEN_IN_FOCUSED_WINDOW);
		commitReport = new JTextArea();

			
		//Criando panel commit report
		panelCommitReport = new JPanel();
		panelCommitReport.setEnabled(false);
		panelCommitReport.setBorder(BorderFactory.createTitledBorder("Commit Report"));
		JScrollPane scroll1 = new JScrollPane(commitReport, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setPreferredSize(new Dimension(400,100));
		panelCommitReport.add(scroll1);

		
		//Criando pannel norte
		panelNorte= new JPanel();
		panelNorte.setBorder(BorderFactory.createTitledBorder("Funcions"));
		panelNorte.setLayout(new GridLayout(1,3,2,2));
		panelNorte.add(add);
		panelNorte.add(remove);
		panelNorte.add(desfazer);

		//Criando Panel Principal Sul
		panelSur = new JPanel();
		panelSur.setBorder(BorderFactory.createTitledBorder(""));
		panelSur.add(commitTxt);
		panelSur.add(commit);



		//Panel Principal
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(5,5));
		panelPrincipal.add(panelNorte, BorderLayout.NORTH);
		panelPrincipal.add(panelSur, BorderLayout.SOUTH);

		//Panel Commits
		JScrollPane scroll = new JScrollPane(commitsHist, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(400,100));
		panelCommits = new JPanel();
		panelCommits.add(scroll);

		panelTabe = new JTabbedPane();
		panelTabe.addTab("Principal ",new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Files-icon.png") ,panelPrincipal);
		panelTabe.addTab("Commits ", new ImageIcon("C:/Users/Lucas/workspace/IHM/imagens/Settings-Info-icon.png") ,panelCommits);

		//Feedback para usuario
		commit.setToolTipText("Guarda los cambios realizados, es irreversible");
		commitTxt.setToolTipText("Introduzca el texto será enlazada a el commit");
		desfazer.setToolTipText("Deshacer una acción que no se ha hecho commit");
		add.setToolTipText("Seleccione un archivo para añadir");
		panelTabe.setToolTipTextAt(0, "Manipulación de archivos");
		panelTabe.setToolTipTextAt(1, "Muestra todas los commits hechos");



		habilitarCommit(false);
		setLayout(new BorderLayout(25,25));
		add(panelTabe, BorderLayout.NORTH);
		add(panelCommitReport, BorderLayout.CENTER);

		
		//COmandos
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getPathName();
			}
		});
		
		commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(aviso.getExibirAviso()) aviso.show();
			}
		});

	}

	private void habilitarCommit(boolean b){
		commit.setEnabled(b);
		commitTxt.setEnabled(!b);
	}

	

	@Override
	public File[] getPathName() {
		File[] files = null;
		String camino = null;
		JFileChooser abrir = new JFileChooser();
		abrir.setMultiSelectionEnabled(true);
		int retorno = abrir.showOpenDialog(null);  
		if (retorno==JFileChooser.APPROVE_OPTION)
			files = abrir.getSelectedFiles();
			
		return files;
	}

	@Override
	public String getCommitText() {
		return commitTxt.getText();
	}

	@Override
	public void controlador(ActionListener ctr) {
		add.addActionListener(ctr);
		add.setActionCommand(ADD);
		remove.addActionListener(ctr);
		remove.setActionCommand(REMOVER);
		desfazer.addActionListener(ctr);
		desfazer.setActionCommand(UNDO);
		commit.addActionListener(ctr);
		commit.setActionCommand(COMMIT);
	}

	@Override
	public void setTextPath(String pathName) {
		
		
	}



}
