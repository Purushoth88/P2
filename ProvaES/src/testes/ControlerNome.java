package testes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.mockito.internal.verification.NoMoreInteractions;

public class ControlerNome implements ActionListener {
	
	private IntMeuNome vista;
	private Nome nome;
	
	public ControlerNome(IntMeuNome vista, Nome nome) {
		this.vista  = vista;
		vista.setMsg(nome.getNome());
		this.nome = nome;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(vista.MOSTRAR)){
			nome.setNome(vista.getNome());
			vista.setMsg(nome.getNome());
		}
		
	}
}
