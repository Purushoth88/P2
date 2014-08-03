package CRE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import java.awt.List;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CancularCRE {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancularCRE window = new CancularCRE();
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
	public CancularCRE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 760, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 31, 46, 14);
		frame.getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(86, 28, 285, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 67, 70, 14);
		frame.getContentPane().add(lblMatricula);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 64, 285, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 109, 361, 14);
		frame.getContentPane().add(separator);
		
		JLabel lblDisciplina = new JLabel("Disciplina: ");
		lblDisciplina.setBounds(10, 137, 70, 14);
		frame.getContentPane().add(lblDisciplina);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setBounds(10, 180, 58, 14);
		frame.getContentPane().add(lblProfessor);
		
		textField_3 = new JTextField();
		textField_3.setBounds(90, 177, 281, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Calculo I", "Calculo II", "Calculo III", "Vetorial", "Linear", "P1", "P2", "PLP", "OAC", "LOAC", "LEDA", "EDA"}));
		comboBox.setBounds(90, 134, 281, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setBounds(10, 226, 46, 14);
		frame.getContentPane().add(lblPerodo);
		
		JRadioButton radioButton = new JRadioButton("2013.1");
		radioButton.setBounds(98, 222, 109, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2013.2");
		radioButton_1.setBounds(228, 222, 109, 23);
		frame.getContentPane().add(radioButton_1);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Calculo I", "DME", "Fulano"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Disciplina", "Departamento", "Professor"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(483, 127, 147, -79);
		frame.getContentPane().add(table);
	}
}
