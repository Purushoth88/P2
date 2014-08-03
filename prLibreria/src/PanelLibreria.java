import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelLibreria extends JPanel implements VistaLibreria {

	private static final long serialVersionUID = 1L;
	JButton bCrear = new JButton("Crear");
	JButton bComprar = new JButton("Comprar");
	JButton bBuscar = new JButton("Buscar");
	JButton bInventario = new JButton("Inventario");
	JLabel mensaje = new JLabel("Panel Librería creado");
	JTextField tfCrear = new JTextField(20);
	JTextField tfComprar = new JTextField(20);
	JTextField tfBuscar = new JTextField(20);
	JTextArea area = new JTextArea(30, 60);

	public PanelLibreria() {
		setLayout(new BorderLayout());
		JPanel norte = new JPanel();
		norte.setLayout(new GridLayout(3, 2));
		norte.add(bCrear);
		norte.add(tfCrear);
		norte.add(bComprar);
		norte.add(tfComprar);
		norte.add(bBuscar);
		norte.add(tfBuscar);

		add(BorderLayout.NORTH, norte);
		add(BorderLayout.CENTER, new JScrollPane(area));
		JPanel sur = new JPanel();
		sur.setLayout(new GridLayout(2, 1));
		sur.add(bInventario);
		sur.add(mensaje);
		add(BorderLayout.SOUTH, sur);

	}

	public void controlador(ActionListener ctr) {
		bCrear.addActionListener(ctr);
		bCrear.setActionCommand(CREAR);
		bComprar.addActionListener(ctr);
		bComprar.setActionCommand(COMPRAR);
		bBuscar.addActionListener(ctr);
		bBuscar.setActionCommand(BUSCAR);
		bInventario.addActionListener(ctr);
		bInventario.setActionCommand(INVENTARIO);

	}

	public String fichCrear() {
		return tfCrear.getText();
	}

	public String libroComprar() {
		return tfComprar.getText();
	}

	public int libroBuscar() {
		return Integer.parseInt(tfBuscar.getText());
	}

	public void limpiar() {
		area.setText("");
	}

	public void mostrar(String str) {
		area.append(str + "\n");
	}

	public void mensaje(String str) {
		mensaje.setForeground(Color.BLACK);
		mensaje.setText(str);
	}

	public void error(String str) {
		mensaje.setForeground(Color.RED);
		mensaje.setText(str);

	}

}
