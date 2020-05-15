package br.com.odontomais.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import br.com.odontomais.dao.EnderecoDAO;
import br.com.odontomais.dao.PessoaDAO;
import br.com.odontomais.model.Endereco;
import br.com.odontomais.model.Funcionario;
import br.com.odontomais.model.Paciente;
import br.com.odontomais.model.Pessoa;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class Principal extends JDialog {
	
	private JTabbedPane panel;
	private JPanel paciente;
	private JPanel funcionario;
	private JTextField txtPacienteNome;
	private JTextField txtPacienteCPF;
	private JTextField txtPacienteRG;
	private JTextField txtPacienteNascimento;
	private JTextField txtPacienteEmail;
	private JTextField txtPacienteTelefone;
	private JTextField txtPacienteCelular;
	private JTextField txtPacienteConvenio;
	private JTextField txtPacienteEndereco;
	private JTextField txtPacienteComplemento;
	private JComboBox cmbPacienteUF;
	private JComboBox cmbPacienteGenero;
	private JTextField txtPacienteCEP;
	private JTextField txtPacienteMunicipio;
	private JButton btnPacienteSalvar;
	private JButton btnPacienteExcluir;
	private JButton btnPacienteAlterar;
	private JButton btnPacienteConsultar;
	private JButton btnPacienteLimpar;
	private JLabel lblFuncionarioNome;
	private JTextField txtFuncionarioNome;
	private JLabel lblCadastroFuncionario;
	private JLabel lblFuncionarioCPF;
	private JTextField txtFuncionarioCPF;
	private JLabel lblFuncionarioRG;
	private JTextField txtFuncionarioRG;
	private JLabel lblFuncionarioNascimento;
	private JTextField txtFuncionarioNascimento;
	private JLabel lblFuncionarioGenero;
	private JLabel lblFuncionarioEmail;
	private JTextField txtFuncionarioEmail;
	private JLabel lblFuncionarioTelefone;
	private JTextField txtFuncionarioTelefone;
	private JLabel lblFuncionarioCelular;
	private JTextField txtFuncionarioCelular;
	private JLabel lblFuncionarioSenha;
	private JTextField txtFuncionarioSenha;
	private JLabel lblFuncionarioEndereco;
	private JTextField txtFuncionarioEndereco;
	private JLabel lblFuncionarioComplemento;
	private JTextField txtFuncionarioComplemento;
	private JLabel lblFuncionarioUF;
	private JComboBox cmbFuncionarioUF;
	private JComboBox cmbFuncionarioGenero;
	private JLabel lblFuncionarioCEP;
	private JTextField txtFuncionarioCEP;
	private JLabel lblFuncionarioMunicipio;
	private JTextField txtFuncionarioMunicipio;
	private JButton btnFuncionarioSalvar;
	private JButton btnFuncionarioExcluir;
	private JButton btnFuncionarioAlterar;
	private JButton btnFuncionarioConsultar;
	private JButton btnFuncionarioLimpar;
	private JLabel lblFuncionarioPermissao;
	private JComboBox cmbFuncionarioPermissao;
	
	private Pessoa pessoas;
	private Paciente pacientes;
	private Funcionario funcionarios;
	private Endereco endereco;
	
	private MaskFormatter mfCPF;
	private MaskFormatter mfRG;
	private MaskFormatter mfData;
	private MaskFormatter mfTelefone;
	private MaskFormatter mfCelular;
	private MaskFormatter mfCEP;
	public JPanel panel_1;
	public JTextField txt;
	public JPanel panel_3;
	public JFormattedTextField txtPacienteValidadeConvenio;
	public JTextField textPacienteTitularPlano;
	public JSeparator separator;
	public JComboBox cmbPacienteConvenio;
	public JPanel panel_2;
	public JCheckBox chckbxNewCheckBox;
	public JSeparator separator_1;
	
	public Principal(Frame owner, boolean isModal, int permissao) throws ParseException {
		super(owner, isModal);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo.png"));
		this.setResizable(false);
		this.setTitle("Odontomais");
		this.setSize(800, 941);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		mfCPF = new MaskFormatter("###.###.###-##");
		mfRG = new MaskFormatter("##.###.###-#");
		mfData = new MaskFormatter("##/##/####");
		mfTelefone = new MaskFormatter("(##)####-####");
		mfCelular = new MaskFormatter("(##)#####-####");
		mfCEP = new MaskFormatter("#####-###");
		
		panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(47, 11, 700, 787);
		this.getContentPane().add(panel);
		
		funcionario = new JPanel();
		panel.addTab("Funcionário", null, funcionario, null);
		funcionario.setLayout(null);
		
		lblFuncionarioNome = new JLabel("Nome: *");
		lblFuncionarioNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioNome.setBounds(10, 60, 220, 20);
		funcionario.add(lblFuncionarioNome);
		
		txtFuncionarioNome = new JTextField();
		txtFuncionarioNome.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioNome.setColumns(10);
		txtFuncionarioNome.setBounds(10, 82, 220, 20);
		funcionario.add(txtFuncionarioNome);
		
		lblCadastroFuncionario = new JLabel("Cadastro de Funcion\u00E1rios");
		lblCadastroFuncionario.setFont(new Font("Arial", Font.BOLD, 24));
		lblCadastroFuncionario.setBounds(10, 11, 305, 38);
		funcionario.add(lblCadastroFuncionario);
		
		lblFuncionarioCPF = new JLabel("CPF: *");
		lblFuncionarioCPF.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioCPF.setBounds(270, 60, 220, 20);
		funcionario.add(lblFuncionarioCPF);
		
		txtFuncionarioCPF = new JFormattedTextField(mfCPF);
		txtFuncionarioCPF.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioCPF.setColumns(10);
		txtFuncionarioCPF.setBounds(270, 82, 220, 20);
		funcionario.add(txtFuncionarioCPF);
		
		lblFuncionarioRG = new JLabel("RG:");
		lblFuncionarioRG.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioRG.setBounds(528, 60, 220, 20);
		funcionario.add(lblFuncionarioRG);
		
		txtFuncionarioRG = new JFormattedTextField(mfRG);
		txtFuncionarioRG.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioRG.setColumns(10);
		txtFuncionarioRG.setBounds(528, 82, 220, 20);
		funcionario.add(txtFuncionarioRG);
		
		lblFuncionarioNascimento = new JLabel("Data de Nascimento: *");
		lblFuncionarioNascimento.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioNascimento.setBounds(10, 113, 220, 20);
		funcionario.add(lblFuncionarioNascimento);
		
		txtFuncionarioNascimento = new JFormattedTextField(mfData);
		txtFuncionarioNascimento.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioNascimento.setColumns(10);
		txtFuncionarioNascimento.setBounds(10, 135, 220, 20);
		funcionario.add(txtFuncionarioNascimento);
		
		lblFuncionarioGenero = new JLabel("G\u00EAnero: *");
		lblFuncionarioGenero.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioGenero.setBounds(270, 113, 220, 20);
		funcionario.add(lblFuncionarioGenero);
		
		lblFuncionarioEmail = new JLabel("E-mail: *");
		lblFuncionarioEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioEmail.setBounds(528, 113, 220, 20);
		funcionario.add(lblFuncionarioEmail);
		
		txtFuncionarioEmail = new JTextField();
		txtFuncionarioEmail.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioEmail.setColumns(10);
		txtFuncionarioEmail.setBounds(528, 135, 220, 20);
		funcionario.add(txtFuncionarioEmail);
		
		lblFuncionarioTelefone = new JLabel("Telefone: *");
		lblFuncionarioTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioTelefone.setBounds(10, 172, 220, 20);
		funcionario.add(lblFuncionarioTelefone);
		
		txtFuncionarioTelefone = new JFormattedTextField(mfTelefone);
		txtFuncionarioTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioTelefone.setColumns(10);
		txtFuncionarioTelefone.setBounds(10, 194, 220, 20);
		funcionario.add(txtFuncionarioTelefone);
		
		lblFuncionarioCelular = new JLabel("Celular:");
		lblFuncionarioCelular.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionarioCelular.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioCelular.setBounds(270, 172, 220, 20);
		funcionario.add(lblFuncionarioCelular);
		
		txtFuncionarioCelular = new JFormattedTextField(mfCelular);
		txtFuncionarioCelular.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioCelular.setColumns(10);
		txtFuncionarioCelular.setBounds(270, 194, 220, 20);
		funcionario.add(txtFuncionarioCelular);
		
		lblFuncionarioSenha = new JLabel("Senha: *");
		lblFuncionarioSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioSenha.setBounds(528, 172, 220, 20);
		funcionario.add(lblFuncionarioSenha);
		
		txtFuncionarioSenha = new JTextField();
		txtFuncionarioSenha.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioSenha.setColumns(10);
		txtFuncionarioSenha.setBounds(528, 194, 220, 20);
		funcionario.add(txtFuncionarioSenha);
		
		lblFuncionarioEndereco = new JLabel("Endere\u00E7o: *");
		lblFuncionarioEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioEndereco.setBounds(10, 231, 220, 20);
		funcionario.add(lblFuncionarioEndereco);
		
		txtFuncionarioEndereco = new JTextField();
		txtFuncionarioEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioEndereco.setColumns(10);
		txtFuncionarioEndereco.setBounds(10, 253, 480, 20);
		funcionario.add(txtFuncionarioEndereco);
		
		lblFuncionarioComplemento = new JLabel("Complemento:");
		lblFuncionarioComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionarioComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioComplemento.setBounds(528, 231, 220, 20);
		funcionario.add(lblFuncionarioComplemento);
		
		txtFuncionarioComplemento = new JTextField();
		txtFuncionarioComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioComplemento.setColumns(10);
		txtFuncionarioComplemento.setBounds(528, 253, 220, 20);
		funcionario.add(txtFuncionarioComplemento);
		
		lblFuncionarioUF = new JLabel("UF: *");
		lblFuncionarioUF.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioUF.setBounds(10, 284, 220, 20);
		funcionario.add(lblFuncionarioUF);
		
		cmbFuncionarioUF = new JComboBox();
		cmbFuncionarioUF.setModel(new DefaultComboBoxModel(new String[] {"SP", "MG", "GO", "BA", "MT"}));
		cmbFuncionarioUF.setFont(new Font("Arial", Font.BOLD, 14));
		cmbFuncionarioUF.setBounds(10, 306, 220, 22);
		funcionario.add(cmbFuncionarioUF);
		
		cmbFuncionarioGenero = new JComboBox();
		cmbFuncionarioGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cmbFuncionarioGenero.setFont(new Font("Arial", Font.BOLD, 14));
		cmbFuncionarioGenero.setBounds(270, 135, 220, 22);
		funcionario.add(cmbFuncionarioGenero);
		
		lblFuncionarioCEP = new JLabel("CEP: *");
		lblFuncionarioCEP.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioCEP.setBounds(270, 284, 220, 20);
		funcionario.add(lblFuncionarioCEP);
		
		txtFuncionarioCEP = new JFormattedTextField(mfCEP);
		txtFuncionarioCEP.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioCEP.setColumns(10);
		txtFuncionarioCEP.setBounds(270, 306, 220, 20);
		funcionario.add(txtFuncionarioCEP);
		
		lblFuncionarioMunicipio = new JLabel("Munic\u00EDpio: *");
		lblFuncionarioMunicipio.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncionarioMunicipio.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioMunicipio.setBounds(528, 284, 220, 20);
		funcionario.add(lblFuncionarioMunicipio);
		
		txtFuncionarioMunicipio = new JTextField();
		txtFuncionarioMunicipio.setFont(new Font("Arial", Font.BOLD, 14));
		txtFuncionarioMunicipio.setColumns(10);
		txtFuncionarioMunicipio.setBounds(528, 306, 220, 20);
		funcionario.add(txtFuncionarioMunicipio);
		
		btnFuncionarioSalvar = new JButton("");
		btnFuncionarioSalvar.setIcon(new ImageIcon("images/05.png"));
		btnFuncionarioSalvar.setBounds(688, 343, 60, 60);
		funcionario.add(btnFuncionarioSalvar);
		
		btnFuncionarioExcluir = new JButton("");
		btnFuncionarioExcluir.setIcon(new ImageIcon("images/04.png"));
		btnFuncionarioExcluir.setBounds(600, 343, 60, 60);
		funcionario.add(btnFuncionarioExcluir);
		
		btnFuncionarioAlterar = new JButton("");
		btnFuncionarioAlterar.setIcon(new ImageIcon("images/03.png"));
		btnFuncionarioAlterar.setBounds(510, 343, 60, 60);
		funcionario.add(btnFuncionarioAlterar);
		
		btnFuncionarioConsultar = new JButton("");
		btnFuncionarioConsultar.setIcon(new ImageIcon("images/02.png"));
		btnFuncionarioConsultar.setBounds(416, 343, 60, 60);
		funcionario.add(btnFuncionarioConsultar);
		
		btnFuncionarioLimpar = new JButton("");
		btnFuncionarioLimpar.setIcon(new ImageIcon("images/01.png"));
		btnFuncionarioLimpar.setBounds(324, 343, 60, 60);
		funcionario.add(btnFuncionarioLimpar);
		
		lblFuncionarioPermissao = new JLabel("Cargo: *");
		lblFuncionarioPermissao.setFont(new Font("Arial", Font.BOLD, 14));
		lblFuncionarioPermissao.setBounds(10, 345, 220, 20);
		funcionario.add(lblFuncionarioPermissao);
		
		cmbFuncionarioPermissao = new JComboBox();
		cmbFuncionarioPermissao.setModel(new DefaultComboBoxModel(new String[] {"Secret\u00E1ria", "Dentista"}));
		cmbFuncionarioPermissao.setFont(new Font("Arial", Font.BOLD, 14));
		cmbFuncionarioPermissao.setBounds(10, 367, 220, 22);
		funcionario.add(cmbFuncionarioPermissao);
		
		paciente = new JPanel();
		paciente.setBackground(Color.WHITE);
		panel.addTab("Paciente", null, paciente, null);
		paciente.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)), "DADOS PESSOAIS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(62, 11, 570, 290);
		paciente.add(panel_1);
		panel_1.setLayout(null);
		
		txtPacienteNome = new JTextField();
		txtPacienteNome.setBounds(61, 22, 450, 40);
		panel_1.add(txtPacienteNome);
		txtPacienteNome.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "NOME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtPacienteNome.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteNome.setColumns(10);
		
		txtPacienteCPF = new JFormattedTextField(mfCPF);
		txtPacienteCPF.setBounds(61, 73, 220, 40);
		panel_1.add(txtPacienteCPF);
		txtPacienteCPF.setText("");
		txtPacienteCPF.setBorder(new TitledBorder(null, "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteCPF.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteCPF.setColumns(10);
		
		txtPacienteRG = new JFormattedTextField(mfRG);
		txtPacienteRG.setBounds(291, 73, 220, 40);
		panel_1.add(txtPacienteRG);
		txtPacienteRG.setBorder(new TitledBorder(null, "RG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteRG.setText("");
		txtPacienteRG.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteRG.setColumns(10);
		
		txtPacienteNascimento = new JFormattedTextField(mfData);
		txtPacienteNascimento.setBounds(61, 124, 220, 40);
		panel_1.add(txtPacienteNascimento);
		txtPacienteNascimento.setBorder(new TitledBorder(null, "DATA DE NASCIMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteNascimento.setText("");
		txtPacienteNascimento.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteNascimento.setColumns(10);
		
		cmbPacienteGenero = new JComboBox();
		cmbPacienteGenero.setBounds(291, 123, 220, 40);
		panel_1.add(cmbPacienteGenero);
		cmbPacienteGenero.setForeground(Color.BLACK);
		cmbPacienteGenero.setBackground(Color.WHITE);
		cmbPacienteGenero.setBorder(new TitledBorder(null, "G\u00CANERO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cmbPacienteGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cmbPacienteGenero.setFont(new Font("Arial", Font.BOLD, 14));
		
		txtPacienteEmail = new JTextField();
		txtPacienteEmail.setBounds(61, 189, 450, 40);
		panel_1.add(txtPacienteEmail);
		txtPacienteEmail.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "E-MAIL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtPacienteEmail.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteEmail.setColumns(10);
		
		txtPacienteCelular = new JFormattedTextField(mfCelular);
		txtPacienteCelular.setBounds(61, 240, 220, 40);
		panel_1.add(txtPacienteCelular);
		txtPacienteCelular.setBorder(new TitledBorder(null, "CELULAR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteCelular.setText("");
		txtPacienteCelular.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteCelular.setColumns(10);
		
		txtPacienteTelefone = new JFormattedTextField(mfTelefone);
		txtPacienteTelefone.setBounds(291, 240, 220, 40);
		panel_1.add(txtPacienteTelefone);
		txtPacienteTelefone.setBorder(new TitledBorder(null, "TELEFONE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteTelefone.setText("");
		txtPacienteTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteTelefone.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(61, 176, 450, 2);
		panel_1.add(separator);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)), "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(62, 312, 570, 216);
		paciente.add(panel_3);
		panel_3.setLayout(null);
		
		txtPacienteEndereco = new JTextField();
		txtPacienteEndereco.setBounds(60, 67, 355, 40);
		panel_3.add(txtPacienteEndereco);
		txtPacienteEndereco.setBorder(new TitledBorder(null, "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteEndereco.setColumns(10);
		
		txtPacienteComplemento = new JTextField();
		txtPacienteComplemento.setBounds(60, 118, 450, 40);
		panel_3.add(txtPacienteComplemento);
		txtPacienteComplemento.setBorder(new TitledBorder(null, "COMPLEMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteComplemento.setColumns(10);
		
		cmbPacienteUF = new JComboBox();
		cmbPacienteUF.setBounds(330, 164, 180, 40);
		panel_3.add(cmbPacienteUF);
		cmbPacienteUF.setBorder(new TitledBorder(null, "ESTADO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cmbPacienteUF.setFont(new Font("Arial", Font.BOLD, 14));
		cmbPacienteUF.setModel(new DefaultComboBoxModel(new String[] {"SP", "MG", "GO", "BA", "MT"}));
		
		txtPacienteCEP = new JFormattedTextField(mfCEP);
		txtPacienteCEP.setBounds(60, 16, 220, 40);
		panel_3.add(txtPacienteCEP);
		txtPacienteCEP.setBorder(new TitledBorder(null, "CEP", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteCEP.setText("");
		txtPacienteCEP.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteCEP.setColumns(10);
		
		txtPacienteMunicipio = new JTextField();
		txtPacienteMunicipio.setBounds(60, 165, 260, 40);
		panel_3.add(txtPacienteMunicipio);
		txtPacienteMunicipio.setBorder(new TitledBorder(null, "CIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteMunicipio.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteMunicipio.setColumns(10);
		
		txt = new JTextField();
		txt.setBounds(425, 67, 85, 40);
		panel_3.add(txt);
		txt.setFont(new Font("Arial", Font.BOLD, 14));
		txt.setColumns(10);
		txt.setBorder(new TitledBorder(null, "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_2 = new JPanel();
		panel_2.setEnabled(false);
		panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)), "PLANO ODONTOL\u00D3GICO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(62, 569, 570, 177);
		paciente.add(panel_2);
		panel_2.setLayout(null);
		
		txtPacienteConvenio = new JTextField();
		txtPacienteConvenio.setBounds(60, 75, 220, 40);
		panel_2.add(txtPacienteConvenio);
		txtPacienteConvenio.setBorder(new TitledBorder(null, "N\u00BA CART\u00C3O/CONV\u00CANIO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtPacienteConvenio.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteConvenio.setColumns(10);
		
		txtPacienteValidadeConvenio = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteValidadeConvenio.setBounds(290, 75, 220, 40);
		panel_2.add(txtPacienteValidadeConvenio);
		txtPacienteValidadeConvenio.setText("");
		txtPacienteValidadeConvenio.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteValidadeConvenio.setColumns(10);
		txtPacienteValidadeConvenio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "VALIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		textPacienteTitularPlano = new JTextField();
		textPacienteTitularPlano.setBounds(60, 126, 450, 40);
		panel_2.add(textPacienteTitularPlano);
		textPacienteTitularPlano.setFont(new Font("Arial", Font.BOLD, 14));
		textPacienteTitularPlano.setColumns(10);
		textPacienteTitularPlano.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TITULAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		cmbPacienteConvenio = new JComboBox();
		cmbPacienteConvenio.setBounds(60, 24, 450, 40);
		panel_2.add(cmbPacienteConvenio);
		cmbPacienteConvenio.setBackground(new Color(255, 255, 255));
		cmbPacienteConvenio.setFont(new Font("Arial", Font.BOLD, 14));
		cmbPacienteConvenio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CONV\u00CANIO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		chckbxNewCheckBox = new JCheckBox("Possui Conv\u00EAnio?");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(120, 539, 109, 23);
		paciente.add(chckbxNewCheckBox);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(62, 528, 570, 2);
		paciente.add(separator_1);
		
		btnPacienteLimpar = new JButton("");
		btnPacienteLimpar.setBounds(617, 809, 60, 60);
		getContentPane().add(btnPacienteLimpar);
		btnPacienteLimpar.setIcon(new ImageIcon("images/01.png"));
		
		btnPacienteConsultar = new JButton("");
		btnPacienteConsultar.setBounds(407, 809, 60, 60);
		getContentPane().add(btnPacienteConsultar);
		btnPacienteConsultar.setIcon(new ImageIcon("images/02.png"));
		
		btnPacienteAlterar = new JButton("");
		btnPacienteAlterar.setBounds(477, 809, 60, 60);
		getContentPane().add(btnPacienteAlterar);
		btnPacienteAlterar.setIcon(new ImageIcon("images/03.png"));
		
		btnPacienteExcluir = new JButton("");
		btnPacienteExcluir.setBounds(547, 809, 60, 60);
		getContentPane().add(btnPacienteExcluir);
		btnPacienteExcluir.setIcon(new ImageIcon("images/04.png"));
		
		btnPacienteSalvar = new JButton("");
		btnPacienteSalvar.setBounds(338, 809, 60, 60);
		getContentPane().add(btnPacienteSalvar);
		btnPacienteSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarPaciente();
			}
		});
		btnPacienteSalvar.setIcon(new ImageIcon("images/05.png"));
	}
	
	public void salvarPaciente() {
		int codPessoa = 0;
		Pessoa p = new Pessoa();
		p.setNome(txtPacienteNome.getText());
		p.setCpf(txtPacienteCPF.getText());
		p.setRg(txtPacienteRG.getText());
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//	p.setDataNascimento(new java.sql.Date(((java.util.Date)formatter.parse(txtPacienteNascimento.getText())).getTime()));
		} catch (Exception event) {
			event.printStackTrace();
		}
		if (cmbPacienteGenero.getSelectedIndex() == 0) p.setGenero("m");
		if (cmbPacienteGenero.getSelectedIndex() == 1) p.setGenero("f");
		p.setEmail(txtPacienteEmail.getText());
		p.setTelefone(txtPacienteTelefone.getText());
		p.setCelular(txtPacienteCelular.getText());
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			codPessoa = pessoaDAO.salvar(p);
		} catch (Exception e) {
			
		}
		Endereco endereco = new Endereco();
		endereco.setEndereco(txtPacienteEndereco.getText());
		endereco.setComplemento(txtPacienteComplemento.getText());
		endereco.setUf((String) cmbPacienteUF.getSelectedItem());
		endereco.setCep(txtPacienteCEP.getText());
		//endereco.setMunicipio(txtPacienteMunicipio.getText());
		endereco.setCodPessoa(codPessoa);
		try {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.salvar(endereco);
			JOptionPane.showMessageDialog(null, "Paciente salvo com sucesso!");
		} catch (Exception e) {
			
		}
	}
}
