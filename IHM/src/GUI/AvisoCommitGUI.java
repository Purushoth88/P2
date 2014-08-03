package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AvisoCommitGUI extends JFrame{

	private JFrame frame;
	private static boolean mostrar = true;
	JCheckBox exibirNovamente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvisoCommitGUI window = new AvisoCommitGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AvisoCommitGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.setBounds(100, 100, 460, 168);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		exibirNovamente = new JCheckBox("No volver a mostrar el mensaje.");
		exibirNovamente.setBounds(0, 32, 179, 98);
		frame.getContentPane().add(exibirNovamente);
		
		JLabel aviso = new JLabel("\u00A1Atenci\u00F3n! Commit es una operaci\u00F3n irreversible.");
		aviso.setBounds(0, 0, 444, 32);
		aviso.setIcon(new ImageIcon("C:\\Users\\Lucas\\workspace\\IHM\\imagens\\warning-icon.png"));
		aviso.setFont(new Font("Arial", Font.BOLD, 17));
		frame.getContentPane().add(aviso);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(exibirNovamente.isSelected()) mostrar = true;
				else mostrar = false;
				show(false);
			}
		});
		btnOk.setBounds(345, 96, 89, 23);
		frame.getContentPane().add(btnOk);
	}
	
	public boolean getExibirAviso(){
		return mostrar;
	}
	
}
