package br.com.odontomais.view;

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
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Cursor;

public class frmConsultar extends JFrame {

	private JPanel contentPane;
	public JFormattedTextField txtPacienteNascimento;
	public JComboBox cmbPacienteGenero;
	public JButton btnNewButton;
	public JScrollPane scrollPane;
	public JTable table;
	public JRadioButton chckbxNewCheckBox;
	public JRadioButton chckbxPaciente;
	public JRadioButton chckbxNewCheckBox_2;
	public JRadioButton chckbxNewCheckBox_1;
	public JPanel panel;
	public JPanel panel_1;

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
		setBounds(100, 100, 610, 411);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 109, 570, 256);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Paciente", "Tratamento", "Data", "Hor\u00E1rio", "Dentista"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		scrollPane.setViewportView(table);
		
		txtPacienteNascimento = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteNascimento.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteNascimento.setColumns(10);
		txtPacienteNascimento.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "PACIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteNascimento.setBounds(12, 57, 220, 40);
		contentPane.add(txtPacienteNascimento);
		
		cmbPacienteGenero = new JComboBox();
		cmbPacienteGenero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbPacienteGenero.setModel(new DefaultComboBoxModel(new String[] {"- Selecione", "Nome", "CPF"}));
		cmbPacienteGenero.setForeground(Color.BLACK);
		cmbPacienteGenero.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteGenero.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "FILTRO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteGenero.setBackground(Color.WHITE);
		cmbPacienteGenero.setBounds(244, 57, 220, 40);
		contentPane.add(cmbPacienteGenero);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(frmConsultar.class.getResource("/Prototipo/search-02.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(476, 57, 40, 40);
		contentPane.add(btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TIPO PESQUISA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1.setBounds(12, 11, 301, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(5, 18, 291, 16);
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		chckbxNewCheckBox = new JRadioButton("Data");
		chckbxNewCheckBox.setBounds(0, 0, 43, 16);
		panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBorder(null);
		
		chckbxPaciente = new JRadioButton("Paciente");
		chckbxPaciente.setBounds(53, 0, 67, 16);
		panel.add(chckbxPaciente);
		chckbxPaciente.setBorder(null);
		chckbxPaciente.setBackground(Color.WHITE);
		
		chckbxNewCheckBox_2 = new JRadioButton("Tratamento");
		chckbxNewCheckBox_2.setBounds(132, 0, 83, 16);
		panel.add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.setBorder(null);
		chckbxNewCheckBox_2.setBackground(Color.WHITE);
		
		chckbxNewCheckBox_1 = new JRadioButton("Dentista");
		chckbxNewCheckBox_1.setBounds(227, 0, 64, 16);
		panel.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setBorder(null);
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
	}
}
