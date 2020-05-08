package Prototipo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class frmPaciente extends JFrame {

	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JPanel paciente;
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
	public JPanel panel_3;
	public JTextField textField_6;
	public JFormattedTextField txtPacienteValidadeConvenio;
	public JTextField textField_7;
	public JComboBox cmbPacienteConvenio;
	public JCheckBox chckbxNewCheckBox;
	public JComboBox cmbPacienteConvenio_1;
	public JButton btnNewButton;
	public JTable table;
	public JButton btnPacienteSalvar;
	public JButton btnPacienteConsultar;
	public JButton btnPacienteAlterar;
	public JButton btnPacienteExcluir;
	public JButton btnPacienteLimpar;
	public JPanel panel;
	public JPanel panel_4;
	public JPanel panel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPaciente frame = new frmPaciente();
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
	public frmPaciente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(11, 10, 980, 573);
		contentPane.add(tabbedPane);
		
		paciente = new JPanel();
		paciente.setLayout(null);
		paciente.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("Paciente", null, paciente, null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 14, 470, 517);
		paciente.add(panel_4);
		panel_4.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 470, 290);
		panel_4.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "DADOS PESSOAIS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_1.setBackground(Color.WHITE);
		
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
		panel_2.setBounds(0, 301, 470, 216);
		panel_4.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_2.setBackground(Color.WHITE);
		
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
		cmbPacienteUF.setBackground(Color.WHITE);
		cmbPacienteUF.setModel(new DefaultComboBoxModel(new String[] {"SP"}));
		cmbPacienteUF.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteUF.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "ESTADO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
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
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(490, 14, 470, 436);
		paciente.add(panel_5);
		panel_5.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 34, 470, 177);
		panel_5.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "PLANO ODONTOL\u00D3GICO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setAlignmentX(0.0f);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "N\u00BA CART\u00C3O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_6.setBounds(10, 75, 220, 40);
		panel_3.add(textField_6);
		
		txtPacienteValidadeConvenio = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteValidadeConvenio.setEnabled(false);
		txtPacienteValidadeConvenio.setText("");
		txtPacienteValidadeConvenio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteValidadeConvenio.setColumns(10);
		txtPacienteValidadeConvenio.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "VALIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteValidadeConvenio.setBounds(240, 75, 220, 40);
		panel_3.add(txtPacienteValidadeConvenio);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TITULAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_7.setBounds(10, 126, 450, 40);
		panel_3.add(textField_7);
		
		cmbPacienteConvenio = new JComboBox();
		cmbPacienteConvenio.setEnabled(false);
		cmbPacienteConvenio.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbPacienteConvenio.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteConvenio.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CONV\u00CANIO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteConvenio.setBackground(Color.WHITE);
		cmbPacienteConvenio.setBounds(10, 24, 450, 40);
		panel_3.add(cmbPacienteConvenio);
		
		chckbxNewCheckBox = new JCheckBox("Possui Conv\u00EAnio?");
		chckbxNewCheckBox.setBounds(10, 0, 123, 23);
		panel_5.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setBorder(null);
		chckbxNewCheckBox.setForeground(new Color(70, 130, 180));
		chckbxNewCheckBox.setFont(new Font("Roboto", Font.BOLD, 12));
		chckbxNewCheckBox.setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setBounds(0, 222, 464, 214);
		panel_5.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "TRATAMENTOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel.setLayout(null);
		
		cmbPacienteConvenio_1 = new JComboBox();
		cmbPacienteConvenio_1.setBounds(10, 16, 400, 40);
		panel.add(cmbPacienteConvenio_1);
		cmbPacienteConvenio_1.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbPacienteConvenio_1.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteConvenio_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TRATAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteConvenio_1.setBackground(Color.WHITE);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(frmPaciente.class.getResource("/Prototipo/plus-01.png")));
		btnNewButton.setBounds(425, 21, 35, 35);
		panel.add(btnNewButton);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		table = new JTable();
		table.setBounds(10, 67, 450, 140);
		panel.add(table);
		table.setBorder(new LineBorder(new Color(70, 130, 180)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"TRATAMENTO", "VALOR", "PARCELAS", "FORMA PAG", "M\u00C9DICO", "CONSULTAS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		
		btnPacienteSalvar = new JButton("");
		btnPacienteSalvar.setIcon(new ImageIcon(frmPaciente.class.getResource("/Prototipo/save.png")));
		btnPacienteSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPacienteSalvar.setBorder(null);
		btnPacienteSalvar.setBackground(Color.WHITE);
		btnPacienteSalvar.setBounds(612, 459, 60, 60);
		paciente.add(btnPacienteSalvar);
		
		btnPacienteConsultar = new JButton("");
		btnPacienteConsultar.setIcon(new ImageIcon(frmPaciente.class.getResource("/Prototipo/search.png")));
		btnPacienteConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPacienteConsultar.setBorder(null);
		btnPacienteConsultar.setBackground(Color.WHITE);
		btnPacienteConsultar.setBounds(684, 459, 60, 60);
		paciente.add(btnPacienteConsultar);
		
		btnPacienteAlterar = new JButton("");
		btnPacienteAlterar.setIcon(new ImageIcon(frmPaciente.class.getResource("/Prototipo/editi-01.png")));
		btnPacienteAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPacienteAlterar.setBorder(null);
		btnPacienteAlterar.setBackground(Color.WHITE);
		btnPacienteAlterar.setBounds(756, 459, 60, 60);
		paciente.add(btnPacienteAlterar);
		
		btnPacienteExcluir = new JButton("");
		btnPacienteExcluir.setIcon(new ImageIcon(frmPaciente.class.getResource("/Prototipo/delete-01.png")));
		btnPacienteExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPacienteExcluir.setBorder(null);
		btnPacienteExcluir.setBackground(Color.WHITE);
		btnPacienteExcluir.setBounds(828, 459, 60, 60);
		paciente.add(btnPacienteExcluir);
		
		btnPacienteLimpar = new JButton("");
		btnPacienteLimpar.setIcon(new ImageIcon(frmPaciente.class.getResource("/Prototipo/cancel-01.png")));
		btnPacienteLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPacienteLimpar.setBorder(null);
		btnPacienteLimpar.setBackground(Color.WHITE);
		btnPacienteLimpar.setBounds(900, 459, 60, 60);
		paciente.add(btnPacienteLimpar);
	}
}
