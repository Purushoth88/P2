package AgendaContatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class PanelBusca extends JPanel{
	
	private JTextArea buscaTxt,infoContatoTxt;
	private JButton editarB,deleteB,buscarB;
	private JPanel pBuscar,pEsq,pDir;
	private JScrollPane infoPanel,detalheInfo;
	private JTabbedPane tabInfo;
	
	public PanelBusca(){
		
		try{
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		buscaTxt = new JTextArea();
		buscaTxt.setColumns(25);
		infoContatoTxt= new JTextArea();
		infoContatoTxt.setRows(4);
		infoContatoTxt.setEditable(false);
		
		editarB = new JButton("Editar", new ImageIcon("imagens/Pencil-icon.png"));
		deleteB = new JButton("Apagar", new ImageIcon("imagens/delete-icon.png"));
		buscarB = new JButton(new ImageIcon("imagens/search-icon.png"));
		
		pBuscar = new JPanel();
		pBuscar.setBorder(BorderFactory.createTitledBorder(""));
		pBuscar.add(buscaTxt);
		pBuscar.add(buscarB);
		
		//Panel de info
		infoContatoTxt.setText("Nome:"+"\n"+"\n"+"Numero:"+"\n"+"\n"+"Email:"+"\n"+"\n"+"Endereço:"+"\n"+"\n"+"Aniversario:");
		infoPanel = new JScrollPane(infoContatoTxt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		detalheInfo = new JScrollPane(new PanelCadastrar().getEditaPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabInfo = new JTabbedPane();
		tabInfo.setBorder(BorderFactory.createTitledBorder(""));
		
		tabInfo.addTab("Info",new ImageIcon("imagens/info-icon.png"),infoPanel);
		tabInfo.addTab("Detalhes",new ImageIcon("imagens/user-icon.png"),detalheInfo);
		
		//Panel Esq
		pEsq = new JPanel();
		pEsq.setLayout(new BorderLayout(5,5));
		pEsq.add(pBuscar, BorderLayout.NORTH);
		pEsq.add(tabInfo, BorderLayout.CENTER);
		
		//Panel Foto
		JPanel panelFoto = new JPanel();
		panelFoto.setLayout(new BorderLayout(5,5));
		panelFoto.setBorder(BorderFactory.createTitledBorder("Nome do user"));
		ImageIcon icone = new ImageIcon("imagens/Places-user-identity-icon.png");
		JLabel fotoUser = new JLabel(icone);
		panelFoto.add(fotoUser);
		
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridLayout(4,1,10,10));
		
		botoes.add(editarB);
		botoes.add(deleteB);
		botoes.add(new JLabel());
		botoes.add(new JLabel());
		
		
		pDir = new JPanel();
		pDir.setLayout(new BorderLayout(5,5));
		pDir.add(panelFoto, BorderLayout.NORTH);
		pDir.add(botoes, BorderLayout.CENTER);
		
		setLayout(new BorderLayout(5,5));
		add(pEsq,BorderLayout.WEST);
		add(pDir,BorderLayout.EAST);
	}

}

