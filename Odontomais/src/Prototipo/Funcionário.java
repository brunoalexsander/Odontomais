package Prototipo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Funcionário extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JPanel panel_1;
	public JTextField textField;
	public JFormattedTextField txtPacienteCPF;
	public JFormattedTextField txtPacienteRG;
	public JFormattedTextField txtPacienteNascimento;
	public JComboBox cmbPacienteGenero;
	public JTextField textField_1;
	public JFormattedTextField txtPacienteCelular;
	public JFormattedTextField txtPacienteTelefone;
	public JSeparator separator;
	public JPanel panel_2;
	public JTextField textField_2;
	public JTextField textField_3;
	public JComboBox cmbPacienteUF;
	public JFormattedTextField txtPacienteCEP;
	public JTextField textField_4;
	public JTextField textField_5;
	public JButton btnPacienteLimpar;
	public JButton btnPacienteExcluir;
	public JButton btnPacienteAlterar;
	public JButton btnPacienteConsultar;
	public JButton btnPacienteSalvar;
	public JComboBox cmbPacienteGenero_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionário frame = new Funcionário();
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
	public Funcionário() {
		setTitle("Funcion\u00E1rio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 470, 566);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "DADOS PESSOAIS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 59, 470, 290);
		panel.add(panel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "NOME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField.setBounds(10, 21, 450, 40);
		panel_1.add(textField);
		
		txtPacienteCPF = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteCPF.setText("");
		txtPacienteCPF.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteCPF.setColumns(10);
		txtPacienteCPF.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteCPF.setBounds(10, 72, 220, 40);
		panel_1.add(txtPacienteCPF);
		
		txtPacienteRG = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteRG.setText("");
		txtPacienteRG.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteRG.setColumns(10);
		txtPacienteRG.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "RG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteRG.setBounds(240, 72, 220, 40);
		panel_1.add(txtPacienteRG);
		
		txtPacienteNascimento = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteNascimento.setText("");
		txtPacienteNascimento.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteNascimento.setColumns(10);
		txtPacienteNascimento.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "DATA DE NASCIMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteNascimento.setBounds(10, 123, 220, 40);
		panel_1.add(txtPacienteNascimento);
		
		cmbPacienteGenero = new JComboBox();
		cmbPacienteGenero.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbPacienteGenero.setForeground(Color.BLACK);
		cmbPacienteGenero.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteGenero.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "G\u00CANERO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteGenero.setBackground(Color.WHITE);
		cmbPacienteGenero.setBounds(240, 122, 220, 40);
		panel_1.add(cmbPacienteGenero);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "E-MAIL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_1.setBounds(10, 188, 450, 40);
		panel_1.add(textField_1);
		
		txtPacienteCelular = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteCelular.setText("");
		txtPacienteCelular.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteCelular.setColumns(10);
		txtPacienteCelular.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CELULAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteCelular.setBounds(10, 239, 220, 40);
		panel_1.add(txtPacienteCelular);
		
		txtPacienteTelefone = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteTelefone.setText("");
		txtPacienteTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteTelefone.setColumns(10);
		txtPacienteTelefone.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TELEFONE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteTelefone.setBounds(240, 239, 220, 40);
		panel_1.add(txtPacienteTelefone);
		
		separator = new JSeparator();
		separator.setBounds(10, 175, 450, 2);
		panel_1.add(separator);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 350, 470, 216);
		panel.add(panel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_2.setBounds(10, 72, 355, 40);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "COMPLEMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_3.setBounds(10, 122, 450, 40);
		panel_2.add(textField_3);
		
		cmbPacienteUF = new JComboBox();
		cmbPacienteUF.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbPacienteUF.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteUF.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "ESTADO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteUF.setBackground(Color.WHITE);
		cmbPacienteUF.setBounds(280, 164, 180, 40);
		panel_2.add(cmbPacienteUF);
		
		txtPacienteCEP = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteCEP.setText("");
		txtPacienteCEP.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteCEP.setColumns(10);
		txtPacienteCEP.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CEP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteCEP.setBounds(10, 21, 220, 40);
		panel_2.add(txtPacienteCEP);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_4.setBounds(10, 165, 260, 40);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "N\u00BA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_5.setBounds(375, 72, 85, 40);
		panel_2.add(textField_5);
		
		cmbPacienteGenero_1 = new JComboBox();
		cmbPacienteGenero_1.setBounds(11, 11, 448, 40);
		panel.add(cmbPacienteGenero_1);
		cmbPacienteGenero_1.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbPacienteGenero_1.setForeground(Color.BLACK);
		cmbPacienteGenero_1.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteGenero_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CARGO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteGenero_1.setBackground(Color.WHITE);
		
		btnPacienteLimpar = new JButton("");
		btnPacienteLimpar.setIcon(new ImageIcon(Funcionário.class.getResource("/Prototipo/cancel-01.png")));
		btnPacienteLimpar.setBorder(null);
		btnPacienteLimpar.setBackground(Color.WHITE);
		btnPacienteLimpar.setBounds(421, 589, 60, 60);
		contentPane.add(btnPacienteLimpar);
		
		btnPacienteExcluir = new JButton("");
		btnPacienteExcluir.setIcon(new ImageIcon(Funcionário.class.getResource("/Prototipo/delete-01.png")));
		btnPacienteExcluir.setBorder(null);
		btnPacienteExcluir.setBackground(Color.WHITE);
		btnPacienteExcluir.setBounds(349, 589, 60, 60);
		contentPane.add(btnPacienteExcluir);
		
		btnPacienteAlterar = new JButton("");
		btnPacienteAlterar.setIcon(new ImageIcon(Funcionário.class.getResource("/Prototipo/editi-01.png")));
		btnPacienteAlterar.setBorder(null);
		btnPacienteAlterar.setBackground(Color.WHITE);
		btnPacienteAlterar.setBounds(277, 589, 60, 60);
		contentPane.add(btnPacienteAlterar);
		
		btnPacienteConsultar = new JButton("");
		btnPacienteConsultar.setIcon(new ImageIcon(Funcionário.class.getResource("/Prototipo/search.png")));
		btnPacienteConsultar.setBorder(null);
		btnPacienteConsultar.setBackground(Color.WHITE);
		btnPacienteConsultar.setBounds(205, 589, 60, 60);
		contentPane.add(btnPacienteConsultar);
		
		btnPacienteSalvar = new JButton("");
		btnPacienteSalvar.setIcon(new ImageIcon(Funcionário.class.getResource("/Prototipo/save.png")));
		btnPacienteSalvar.setBorder(null);
		btnPacienteSalvar.setBackground(Color.WHITE);
		btnPacienteSalvar.setBounds(133, 589, 60, 60);
		contentPane.add(btnPacienteSalvar);
	}
}
