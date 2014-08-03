package testes;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MeuNome extends JPanel implements IntMeuNome {
	
	private JTextArea texto;
	private JButton botao;
	private JLabel nome;
	
	public MeuNome(){
		setLayout(new BorderLayout());
		texto = new JTextArea();
		botao = new JButton("Print");
		nome = new JLabel();
		
		add(texto, BorderLayout.NORTH);
		add(botao, BorderLayout.CENTER);
		add(nome, BorderLayout.SOUTH);
	}

	@Override
	public String getNome() {
		return texto.getText();
	}

	@Override
	public void setMsg(String msg) {
		nome.setText(msg);
		
	}

	@Override
	public void controlador(ActionListener action) {
		botao.addActionListener(action);
		botao.setActionCommand(MOSTRAR);
		
	}

}
