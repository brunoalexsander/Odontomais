package Prototipo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class frmConsultar extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public JFormattedTextField txtPacienteNascimento;
	public JComboBox cmbPacienteGenero;
	public JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultar frame = new frmConsultar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmConsultar() {
		setTitle("Pesquisar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBorder(new LineBorder(new Color(70, 130, 180)));
		table.setBounds(10, 63, 574, 256);
		contentPane.add(table);
		
		txtPacienteNascimento = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteNascimento.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteNascimento.setColumns(10);
		txtPacienteNascimento.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "PESQUISA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteNascimento.setBounds(10, 12, 220, 40);
		contentPane.add(txtPacienteNascimento);
		
		cmbPacienteGenero = new JComboBox();
		cmbPacienteGenero.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbPacienteGenero.setForeground(Color.BLACK);
		cmbPacienteGenero.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteGenero.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "FILTRO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteGenero.setBackground(Color.WHITE);
		cmbPacienteGenero.setBounds(240, 11, 220, 40);
		contentPane.add(cmbPacienteGenero);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(frmConsultar.class.getResource("/Prototipo/search-02.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(470, 11, 40, 40);
		contentPane.add(btnNewButton);
	}
}
