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

public class Principal extends JDialog {
	
	private JTabbedPane panel;
	private JPanel paciente;
	private JPanel funcionario;
	private JLabel lblPacienteNome;
	private JTextField txtPacienteNome;
	private JLabel lblCadastroDePacientes;
	private JLabel lblPacienteCPF;
	private JTextField txtPacienteCPF;
	private JLabel lblPacienteRG;
	private JTextField txtPacienteRG;
	private JLabel lblPacienteNascimento;
	private JTextField txtPacienteNascimento;
	private JLabel lblPacienteGenero;
	private JLabel lblPacienteEmail;
	private JTextField txtPacienteEmail;
	private JLabel lblPacienteTelefone;
	private JTextField txtPacienteTelefone;
	private JLabel lblPacienteCelular;
	private JTextField txtPacienteCelular;
	private JLabel lblPacienteConvenio;
	private JTextField txtPacienteConvenio;
	private JLabel lblPacienteEndereco;
	private JTextField txtPacienteEndereco;
	private JLabel lblPacienteComplemento;
	private JTextField txtPacienteComplemento;
	private JLabel lblPacienteUF;
	private JComboBox cmbPacienteUF;
	private JComboBox cmbPacienteGenero;
	private JLabel lblPacienteCEP;
	private JTextField txtPacienteCEP;
	private JLabel lblPacienteMunicipio;
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
	
	public Principal(Frame owner, boolean isModal, int permissao) throws ParseException {
		super(owner, isModal);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo.png"));
		this.setResizable(false);
		this.setTitle("Odontomais");
		this.setSize(800, 500);
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
		panel.setBounds(10, 11, 764, 442);
		this.getContentPane().add(panel);
		
		paciente = new JPanel();
		panel.addTab("Paciente", null, paciente, null);
		paciente.setLayout(null);
		
		lblPacienteNome = new JLabel("Nome: *");
		lblPacienteNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteNome.setBounds(10, 60, 220, 20);
		paciente.add(lblPacienteNome);
		
		txtPacienteNome = new JTextField();
		txtPacienteNome.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteNome.setBounds(10, 82, 220, 20);
		paciente.add(txtPacienteNome);
		txtPacienteNome.setColumns(10);
		
		lblCadastroDePacientes = new JLabel("Cadastro de Pacientes");
		lblCadastroDePacientes.setFont(new Font("Arial", Font.BOLD, 24));
		lblCadastroDePacientes.setBounds(10, 11, 305, 38);
		paciente.add(lblCadastroDePacientes);
		
		lblPacienteCPF = new JLabel("CPF: *");
		lblPacienteCPF.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteCPF.setBounds(270, 60, 220, 20);
		paciente.add(lblPacienteCPF);
		
		txtPacienteCPF = new JFormattedTextField(mfCPF);
		txtPacienteCPF.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteCPF.setColumns(10);
		txtPacienteCPF.setBounds(270, 82, 220, 20);
		paciente.add(txtPacienteCPF);
		
		lblPacienteRG = new JLabel("RG:");
		lblPacienteRG.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteRG.setBounds(528, 60, 220, 20);
		paciente.add(lblPacienteRG);
		
		txtPacienteRG = new JFormattedTextField(mfRG);
		txtPacienteRG.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteRG.setColumns(10);
		txtPacienteRG.setBounds(528, 82, 220, 20);
		paciente.add(txtPacienteRG);
		
		lblPacienteNascimento = new JLabel("Data de Nascimento: *");
		lblPacienteNascimento.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteNascimento.setBounds(10, 113, 220, 20);
		paciente.add(lblPacienteNascimento);
		
		txtPacienteNascimento = new JFormattedTextField(mfData);
		txtPacienteNascimento.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteNascimento.setColumns(10);
		txtPacienteNascimento.setBounds(10, 135, 220, 20);
		paciente.add(txtPacienteNascimento);
		
		lblPacienteGenero = new JLabel("G\u00EAnero: *");
		lblPacienteGenero.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteGenero.setBounds(270, 113, 220, 20);
		paciente.add(lblPacienteGenero);
		
		lblPacienteEmail = new JLabel("E-mail: *");
		lblPacienteEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteEmail.setBounds(528, 113, 220, 20);
		paciente.add(lblPacienteEmail);
		
		txtPacienteEmail = new JTextField();
		txtPacienteEmail.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteEmail.setColumns(10);
		txtPacienteEmail.setBounds(528, 135, 220, 20);
		paciente.add(txtPacienteEmail);
		
		lblPacienteTelefone = new JLabel("Telefone: *");
		lblPacienteTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteTelefone.setBounds(10, 172, 220, 20);
		paciente.add(lblPacienteTelefone);
		
		txtPacienteTelefone = new JFormattedTextField(mfTelefone);
		txtPacienteTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteTelefone.setColumns(10);
		txtPacienteTelefone.setBounds(10, 194, 220, 20);
		paciente.add(txtPacienteTelefone);
		
		lblPacienteCelular = new JLabel("Celular:");
		lblPacienteCelular.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacienteCelular.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteCelular.setBounds(270, 172, 220, 20);
		paciente.add(lblPacienteCelular);
		
		txtPacienteCelular = new JFormattedTextField(mfCelular);
		txtPacienteCelular.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteCelular.setColumns(10);
		txtPacienteCelular.setBounds(270, 194, 220, 20);
		paciente.add(txtPacienteCelular);
		
		lblPacienteConvenio = new JLabel("Conv\u00EAnio:");
		lblPacienteConvenio.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteConvenio.setBounds(528, 172, 220, 20);
		paciente.add(lblPacienteConvenio);
		
		txtPacienteConvenio = new JTextField();
		txtPacienteConvenio.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteConvenio.setColumns(10);
		txtPacienteConvenio.setBounds(528, 194, 220, 20);
		paciente.add(txtPacienteConvenio);
		
		lblPacienteEndereco = new JLabel("Endere\u00E7o: *");
		lblPacienteEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteEndereco.setBounds(10, 231, 220, 20);
		paciente.add(lblPacienteEndereco);
		
		txtPacienteEndereco = new JTextField();
		txtPacienteEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteEndereco.setColumns(10);
		txtPacienteEndereco.setBounds(10, 253, 480, 20);
		paciente.add(txtPacienteEndereco);
		
		lblPacienteComplemento = new JLabel("Complemento:");
		lblPacienteComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacienteComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteComplemento.setBounds(528, 231, 220, 20);
		paciente.add(lblPacienteComplemento);
		
		txtPacienteComplemento = new JTextField();
		txtPacienteComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteComplemento.setColumns(10);
		txtPacienteComplemento.setBounds(528, 253, 220, 20);
		paciente.add(txtPacienteComplemento);
		
		lblPacienteUF = new JLabel("UF: *");
		lblPacienteUF.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteUF.setBounds(10, 284, 220, 20);
		paciente.add(lblPacienteUF);
		
		cmbPacienteUF = new JComboBox();
		cmbPacienteUF.setFont(new Font("Arial", Font.BOLD, 14));
		cmbPacienteUF.setModel(new DefaultComboBoxModel(new String[] {"SP", "MG", "GO", "BA", "MT"}));
		cmbPacienteUF.setBounds(10, 306, 220, 22);
		paciente.add(cmbPacienteUF);
		
		cmbPacienteGenero = new JComboBox();
		cmbPacienteGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cmbPacienteGenero.setFont(new Font("Arial", Font.BOLD, 14));
		cmbPacienteGenero.setBounds(270, 135, 220, 22);
		paciente.add(cmbPacienteGenero);
		
		lblPacienteCEP = new JLabel("CEP: *");
		lblPacienteCEP.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteCEP.setBounds(270, 284, 220, 20);
		paciente.add(lblPacienteCEP);
		
		txtPacienteCEP = new JFormattedTextField(mfCEP);
		txtPacienteCEP.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteCEP.setColumns(10);
		txtPacienteCEP.setBounds(270, 306, 220, 20);
		paciente.add(txtPacienteCEP);
		
		lblPacienteMunicipio = new JLabel("Munic\u00EDpio: *");
		lblPacienteMunicipio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacienteMunicipio.setFont(new Font("Arial", Font.BOLD, 14));
		lblPacienteMunicipio.setBounds(528, 284, 220, 20);
		paciente.add(lblPacienteMunicipio);
		
		txtPacienteMunicipio = new JTextField();
		txtPacienteMunicipio.setFont(new Font("Arial", Font.BOLD, 14));
		txtPacienteMunicipio.setColumns(10);
		txtPacienteMunicipio.setBounds(528, 306, 220, 20);
		paciente.add(txtPacienteMunicipio);
		
		btnPacienteSalvar = new JButton("");
		btnPacienteSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarPaciente();
			}
		});
		btnPacienteSalvar.setIcon(new ImageIcon("images/05.png"));
		btnPacienteSalvar.setBounds(688, 343, 60, 60);
		paciente.add(btnPacienteSalvar);
		
		btnPacienteExcluir = new JButton("");
		btnPacienteExcluir.setIcon(new ImageIcon("images/04.png"));
		btnPacienteExcluir.setBounds(600, 343, 60, 60);
		paciente.add(btnPacienteExcluir);
		
		btnPacienteAlterar = new JButton("");
		btnPacienteAlterar.setIcon(new ImageIcon("images/03.png"));
		btnPacienteAlterar.setBounds(510, 343, 60, 60);
		paciente.add(btnPacienteAlterar);
		
		btnPacienteConsultar = new JButton("");
		btnPacienteConsultar.setIcon(new ImageIcon("images/02.png"));
		btnPacienteConsultar.setBounds(416, 343, 60, 60);
		paciente.add(btnPacienteConsultar);
		
		btnPacienteLimpar = new JButton("");
		btnPacienteLimpar.setIcon(new ImageIcon("images/01.png"));
		btnPacienteLimpar.setBounds(324, 343, 60, 60);
		paciente.add(btnPacienteLimpar);
		
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
	}
	
	public void salvarPaciente() {
		int codPessoa = 0;
		Pessoa p = new Pessoa();
		p.setNome(txtPacienteNome.getText());
		p.setCpf(txtPacienteCPF.getText());
		p.setRg(txtPacienteRG.getText());
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			p.setNascimento(new java.sql.Date(((java.util.Date)formatter.parse(txtPacienteNascimento.getText())).getTime()));
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
		endereco.setMunicipio(txtPacienteMunicipio.getText());
		endereco.setCodPessoa(codPessoa);
		try {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.salvar(endereco);
			JOptionPane.showMessageDialog(null, "Paciente salvo com sucesso!");
		} catch (Exception e) {
			
		}
	}
}
