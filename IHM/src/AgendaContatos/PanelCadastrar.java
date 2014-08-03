package AgendaContatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class PanelCadastrar extends JPanel{

	private JButton salvarB;
	private  JTextArea nomeTxt,numeroTxt,emailTxt,enderecoTxt,grupoTxt,descricaoTxt,dataNascimentoTxt;
	private JPanel dadosBasicos,datosAvancados,panelDatos,panelNiver,pEndereco,panelGrupo;
	private JSeparator separator;
	private JComboBox dias, anos, meses;

	public PanelCadastrar(){

		try{
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		}catch (Exception e){
			e.printStackTrace();
		}



		//Criando elementos
		nomeTxt = new JTextArea();
		nomeTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nomeTxt.setText("");
				nomeTxt.setForeground(Color.BLACK);
			}
		});
		nomeTxt.setRows(1);
		nomeTxt.setColumns(30);
		nomeTxt.setText("Introduza o nome do contato");
		nomeTxt.setForeground(Color.GRAY);
		
		numeroTxt = new JTextArea();
		numeroTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numeroTxt.setText("");
				numeroTxt.setForeground(Color.BLACK);
			}
		});
		numeroTxt.setText("Introduza o número: XX-XXXXXXXX");
		numeroTxt.setForeground(Color.GRAY);
		numeroTxt.setColumns(30);
		
		emailTxt = new JTextArea();
		emailTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				emailTxt.setText("exemplo@exemplo.com");
				emailTxt.setForeground(Color.BLACK);
			}
		});
		emailTxt.setColumns(30);
		emailTxt.setText("exemplo@exemplo.com");
		emailTxt.setForeground(Color.GRAY);
		
		enderecoTxt  = new JTextArea();
		enderecoTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enderecoTxt.setText("");
				enderecoTxt.setForeground(Color.BLACK);
				
			}
		});
		enderecoTxt.setColumns(30);
		enderecoTxt.setText("Rua, Bairo, nº XXX, Cidade");
		enderecoTxt.setForeground(Color.GRAY);
		
		grupoTxt = new JTextArea();
		grupoTxt.setColumns(30);
		dataNascimentoTxt = new JTextArea();
		dataNascimentoTxt.setColumns(20);

		//Criando panel dados basicos
		dadosBasicos = new JPanel();
		dadosBasicos.setBorder(BorderFactory.createTitledBorder(""));
		dadosBasicos.setLayout(new GridLayout(3,1,5,5));
		JPanel Pnome = new JPanel();
		Pnome.setBorder(BorderFactory.createTitledBorder("Nome:"));
		Pnome.add(nomeTxt);

		JPanel Pnumero = new JPanel();
		Pnumero.setBorder(BorderFactory.createTitledBorder("Numero:"));
		Pnumero.add(numeroTxt);

		JPanel Pemail = new JPanel();
		Pemail.setBorder(BorderFactory.createTitledBorder("Email:"));
		Pemail.add(emailTxt);

		dadosBasicos.add(Pnome);
		dadosBasicos.add(Pnumero);
		dadosBasicos.add(Pemail);

		//Criando Panel Avançados

		datosAvancados = new JPanel();
		datosAvancados.setLayout(new GridLayout(3,1,5,5));
		datosAvancados.setBorder(BorderFactory.createTitledBorder(""));
		pEndereco = new JPanel();
		pEndereco.setBorder(BorderFactory.createTitledBorder("Endereço:"));
		pEndereco.add(enderecoTxt);

		panelGrupo = new JPanel();
		panelGrupo.setBorder(BorderFactory.createTitledBorder("Grupo:"));
		panelGrupo.add(grupoTxt);



		anos = new JComboBox();
		for(int i =0;i<100;i++){
			anos.addItem(2013-i);
		}
		
		dias = new JComboBox();
		for(int i =0;i<31;i++){
			dias.addItem(i+1);
		}
		
		meses = new JComboBox();
		for(int i =0;i<12;i++){
			meses.addItem(i+1);
		}

		
		panelNiver = new JPanel();
		panelNiver.setToolTipText("Data de anivers\u00E1rio (dd/mm/aaaa)");
		panelNiver.setBorder(BorderFactory.createTitledBorder("Nadascimento:"));
		panelNiver.add(dias);
		panelNiver.add(meses);
		panelNiver.add(anos);

		abiltaAvancado(false);

		final JCheckBox checkAvancado = new JCheckBox("Cadastro detalhado");
		checkAvancado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(checkAvancado.isSelected())
					abiltaAvancado(true);
				else abiltaAvancado(false);
			}
		});


		datosAvancados.add(checkAvancado);
		datosAvancados.add(pEndereco);
		datosAvancados.add(panelNiver);
		

		//Criando Panel datos
		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(2,1));
		panelDatos.add(dadosBasicos);
		panelDatos.add(datosAvancados);

		//Criando Panel esquerdo
		JPanel panelFoto = new JPanel();
		panelFoto.setLayout(new BorderLayout(5,5));
		panelFoto.setBorder(BorderFactory.createTitledBorder("User Profile"));
		ImageIcon icone = new ImageIcon("imagens/Places-user-identity-icon.png");
		JButton selecionarImagens = new JButton("Select", new ImageIcon("imagens/search-icon.png"));
		selecionarImagens.setToolTipText("Selecione uma imagem para o perfil do contato");
		JLabel foto = new JLabel(icone);
		panelFoto.add(foto, BorderLayout.NORTH);
		panelFoto.add(selecionarImagens, BorderLayout.SOUTH);


		JButton cancelar = new JButton("Cancelar", new ImageIcon("imagens/Sign-Error-icon.png"));
		cancelar.setToolTipText("Cancela o cadastramento e limpa todos os campos");
		salvarB = new JButton("Salvar", new ImageIcon("imagens/Actions-document-save-icon.png"));
		salvarB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Contacto salvo com exito!");
				
			}
		});
		salvarB.setToolTipText("Salvar os dados de um novo contato");
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridLayout(4,1,7,7));
		botoes.add(new JLabel());
		botoes.add(salvarB);
		botoes.add(cancelar);
		botoes.add(new JLabel());

		JPanel panelTotalEsq = new JPanel();
		panelTotalEsq.setLayout(new BorderLayout());
		panelTotalEsq.add(panelFoto, BorderLayout.NORTH);
		panelTotalEsq.add(botoes, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		add(panelDatos, BorderLayout.WEST);
		add(panelTotalEsq, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		PanelCadastrar cad = new PanelCadastrar();
		frame.getContentPane().add(cad);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}


	private void abiltaAvancado(boolean abilita){
		
		enderecoTxt.setEnabled(abilita);
		
		grupoTxt.setEnabled(abilita);

		dataNascimentoTxt.setEnabled(abilita);
		panelNiver.setEnabled(abilita);
		pEndereco.setEnabled(abilita);
		dias.setEnabled(abilita);
		meses.setEnabled(abilita);
		anos.setEnabled(abilita);
	}
	
	public JPanel getEditaPanel(){
		return panelDatos;
	}


}



