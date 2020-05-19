package Prototipo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JSpinner;
import java.awt.ComponentOrientation;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class frmAgendamento extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JFormattedTextField txtCPFPaciente;
	public JComboBox cmbGeneroPaciente;
	public JComboBox cmbGeneroPaciente_1;
	public JComboBox cmbGeneroPaciente_2;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;
	public JButton btnNewButton_6;
	public JButton btnNewButton_7;
	public JButton btnNewButton_8;
	public JButton btnNewButton_9;
	public JTextField textField_2;
	public JPanel panel;
	public JPanel panel_1;
	public JButton btnSalvarPaciente;
	public JButton btnPacienteLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAgendamento frame = new frmAgendamento();
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
	public frmAgendamento() {
		setTitle("Agendamento de Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "PACIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel.setBounds(5, 12, 410, 165);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 120, 400, 40);
		panel.add(textField);
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TRATAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField.setBackground(Color.WHITE);
		
		textField_1 = new JTextField();
		textField_1.setBounds(5, 69, 400, 40);
		panel.add(textField_1);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "NOME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		
		txtCPFPaciente = new JFormattedTextField((AbstractFormatter) null);
		txtCPFPaciente.setBounds(5, 18, 220, 40);
		panel.add(txtCPFPaciente);
		txtCPFPaciente.setText("");
		txtCPFPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCPFPaciente.setColumns(10);
		txtCPFPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "HOR\u00C1RIO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_1.setBounds(5, 185, 410, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		cmbGeneroPaciente = new JComboBox();
		cmbGeneroPaciente.setBounds(5, 70, 58, 40);
		panel_1.add(cmbGeneroPaciente);
		cmbGeneroPaciente.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbGeneroPaciente.setForeground(Color.BLACK);
		cmbGeneroPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbGeneroPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "DIA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbGeneroPaciente.setBackground(Color.WHITE);
		
		cmbGeneroPaciente_1 = new JComboBox();
		cmbGeneroPaciente_1.setBounds(75, 70, 67, 40);
		panel_1.add(cmbGeneroPaciente_1);
		cmbGeneroPaciente_1.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}));
		cmbGeneroPaciente_1.setForeground(Color.BLACK);
		cmbGeneroPaciente_1.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbGeneroPaciente_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "M\u00CAS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbGeneroPaciente_1.setBackground(Color.WHITE);
		
		cmbGeneroPaciente_2 = new JComboBox();
		cmbGeneroPaciente_2.setBounds(154, 70, 67, 40);
		panel_1.add(cmbGeneroPaciente_2);
		cmbGeneroPaciente_2.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021"}));
		cmbGeneroPaciente_2.setForeground(Color.BLACK);
		cmbGeneroPaciente_2.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbGeneroPaciente_2.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "ANO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbGeneroPaciente_2.setBackground(Color.WHITE);
		
		btnNewButton = new JButton("12:00");
		btnNewButton.setBounds(5, 122, 70, 30);
		panel_1.add(btnNewButton);
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		
		btnNewButton_1 = new JButton("12:50");
		btnNewButton_1.setBounds(87, 122, 70, 30);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(70, 130, 180));
		
		btnNewButton_2 = new JButton("13:40");
		btnNewButton_2.setBounds(169, 122, 70, 30);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(70, 130, 180));
		
		btnNewButton_3 = new JButton("14:30");
		btnNewButton_3.setBounds(251, 122, 70, 30);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(30, 144, 255));
		
		btnNewButton_4 = new JButton("15:20");
		btnNewButton_4.setBounds(333, 122, 70, 30);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBackground(new Color(70, 130, 180));
		
		btnNewButton_5 = new JButton("16:10");
		btnNewButton_5.setBounds(5, 164, 70, 30);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setBackground(new Color(70, 130, 180));
		
		btnNewButton_6 = new JButton("17:00");
		btnNewButton_6.setBounds(87, 164, 70, 30);
		panel_1.add(btnNewButton_6);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBorder(null);
		btnNewButton_6.setBackground(new Color(30, 144, 255));
		
		btnNewButton_7 = new JButton("17:50");
		btnNewButton_7.setBounds(169, 164, 70, 30);
		panel_1.add(btnNewButton_7);
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBorder(null);
		btnNewButton_7.setBackground(new Color(70, 130, 180));
		
		btnNewButton_8 = new JButton("18:40");
		btnNewButton_8.setBounds(251, 164, 70, 30);
		panel_1.add(btnNewButton_8);
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBorder(null);
		btnNewButton_8.setBackground(new Color(30, 144, 255));
		
		btnNewButton_9 = new JButton("19:30");
		btnNewButton_9.setBounds(333, 164, 70, 30);
		panel_1.add(btnNewButton_9);
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setBorder(null);
		btnNewButton_9.setBackground(new Color(70, 130, 180));
		
		textField_2 = new JTextField();
		textField_2.setBounds(5, 18, 400, 40);
		panel_1.add(textField_2);
		textField_2.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_2.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "M\u00C9DICO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_2.setBackground(Color.WHITE);
		
		btnSalvarPaciente = new JButton("");
		btnSalvarPaciente.setIcon(new ImageIcon(frmAgendamento.class.getResource("/Prototipo/save.png")));
		btnSalvarPaciente.setBorder(null);
		btnSalvarPaciente.setBackground(Color.WHITE);
		btnSalvarPaciente.setBounds(277, 405, 60, 60);
		contentPane.add(btnSalvarPaciente);
		
		btnPacienteLimpar = new JButton("");
		btnPacienteLimpar.setIcon(new ImageIcon(frmAgendamento.class.getResource("/Prototipo/cancel-01.png")));
		btnPacienteLimpar.setBorder(null);
		btnPacienteLimpar.setBackground(Color.WHITE);
		btnPacienteLimpar.setBounds(349, 405, 60, 60);
		contentPane.add(btnPacienteLimpar);
	}
}
