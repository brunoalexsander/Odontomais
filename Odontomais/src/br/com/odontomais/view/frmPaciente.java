package br.com.odontomais.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.odontomais.model.Paciente;
import br.com.odontomais.model.Pessoa;
import br.com.odontomais.model.Prontuario;
import br.com.odontomais.model.Responsavel;
import br.com.odontomais.model.Tratamento;
import br.com.odontomais.model.TratamentoPaciente;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JEditorPane;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class frmPaciente extends JFrame {

	private JPanel contentPane;
	protected JTabbedPane tbpPaciente;
	protected JPanel panel_1;
	protected JTextField txtNomePaciente;
	protected JFormattedTextField txtCPFPaciente;
	protected JFormattedTextField txtRGPaciente;
	protected JFormattedTextField txtNascimentoPaciente;
	protected JComboBox cmbGeneroPaciente;
	protected JTextField txtEmailPaciente;
	protected JFormattedTextField txtCelularPaciente;
	protected JFormattedTextField txtTelefonePaciente;
	protected JSeparator separator;
	protected JPanel panel_2;
	protected JTextField txtEnderecoPaciente;
	protected JTextField txtComplementoPaciente;
	protected JComboBox cmbUFPaciente;
	protected JFormattedTextField txtCepPaciente;
	protected JTextField txtCidadePaciente;
	protected JPanel panel_3;
	protected JTextField txtCartaoConvenioPaciente;
	protected JFormattedTextField txtValidadeConvenioPaciente;
	protected JTextField txtConvenioTitularPaciente;
	protected JComboBox cmbConvenioPaciente;
	protected JCheckBox chkConvenioPaciente;
	protected JComboBox cmbTratamentos;
	protected JButton btnNovoTratamentoPaciente;
	protected JButton btnPacienteSalvar;
	protected JButton btnConsultarPaciente;
	protected JButton btnAlterarPaciente;
	protected JButton btnExcluirPaciente;
	protected JButton btnCancelarPaciente;
	protected JPanel panel;
	protected JPanel panel_4;
	protected JPanel panel_5;
	protected JPanel pnlProntuario;
	protected JPanel panel_7;
	protected JTextField txtNomeDentista;
	protected JFormattedTextField txtDataProntuario;
	protected JTextPane txtAnotacaoProntuario;
	protected JButton btnSalvarProntuario;
	protected JPanel panel_8;
	protected JButton btnCancelarProntuario;
	protected JTextField txtBairroPaciente;
	public JButton btnSalvarPaciente;
	public JTextField txtNumeroPaciente;
	public JFormattedTextField txtCPFPaciente_1;
	public JFormattedTextField txtRGPaciente_1;
	public JFormattedTextField txtNascimentoPaciente_1;
	public JFormattedTextField txtCelularPaciente_1;
	public JFormattedTextField txtTelefonePaciente_1;
	public JPanel pnlResponsavel;
	public JTextField txtNomeResponsavel;
	public JFormattedTextField txtCPFResponsavel;
	public JTextField txtRGResponsavel;
	public JFormattedTextField txtNascimentoResponsavel;
	public JComboBox cmbGeneroResponsavel;
	public JTextField txtEmailResponsavel;
	public JFormattedTextField txtCelularResponsavel;
	public JFormattedTextField txtTelefoneResponsavel;
	public JPanel panel_10;
	public JButton btnSalvarResponsavel;
	public JPanel panel_9;
	public JTextField txtEnderecoResponsavel;
	public JTextField txtComplementoResponsavel;
	public JComboBox cmbUFResponsavel;
	public JFormattedTextField txtCepResponsavel;
	public JTextField txtCidadeResponsavel;
	public JTextField txtBairroResponsavel;
	public JTextField txtNumeroResponsavel;
	public JFormattedTextField txtPaciente;
	public JScrollPane scrollPane;
	public static JTable tblTratamentoPaciente;
	public JScrollPane scrollPane_1;
	public JTable tblAnotacoesProntuario;
	public JButton btnAlterarProntuário;
	public JScrollPane scrollPane_2;

	public static Paciente paciente;
	public Responsavel responsavel;
	private FerramentasFormulario frmt; 
	private Tratamento tratamento;
	private TratamentoPaciente tratamentoPaciente;
	private Prontuario prontuario;
	private boolean habilitaComponentes = false;
	private JPanel pnlPaciente;
	public JLabel lblCodResposavel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPaciente frame = new frmPaciente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public frmPaciente() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmPaciente.class.getResource("/br/com/odontomais/view/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1009, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tbpPaciente = new JTabbedPane(JTabbedPane.TOP);
		tbpPaciente.setBorder(null);
		tbpPaciente.setBounds(11, 10, 980, 654);
		contentPane.add(tbpPaciente);

		pnlPaciente = new JPanel();
		pnlPaciente.setLayout(null);
		pnlPaciente.setBackground(new Color(245, 245, 245));
		tbpPaciente.addTab("Paciente", null, pnlPaciente, null);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 14, 470, 600);
		pnlPaciente.add(panel_4);
		panel_4.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 57, 470, 290);
		panel_4.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "DADOS PESSOAIS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_1.setBackground(Color.WHITE);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setDisabledTextColor(Color.GRAY);
		txtNomePaciente.setSelectionColor(Color.GRAY);
		txtNomePaciente.setEnabled(false);
		txtNomePaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNomePaciente.setColumns(10);
		txtNomePaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "NOME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtNomePaciente.setBounds(10, 21, 450, 40);
		panel_1.add(txtNomePaciente);

		txtCPFPaciente = new JFormattedTextField((AbstractFormatter) null);
		txtCPFPaciente.setDisabledTextColor(Color.GRAY);
		txtCPFPaciente.setSelectionColor(Color.GRAY);
		txtCPFPaciente.setEnabled(false);
		txtCPFPaciente.setText("");
		txtCPFPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCPFPaciente.setColumns(10);
		txtCPFPaciente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		txtCPFPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtCPFPaciente.setBounds(10, 72, 220, 40);
		panel_1.add(txtCPFPaciente);

		txtRGPaciente = new JFormattedTextField((AbstractFormatter) null);
		txtRGPaciente.setDisabledTextColor(Color.GRAY);
		txtRGPaciente.setSelectionColor(Color.GRAY);
		txtRGPaciente.setEnabled(false);
		txtRGPaciente.setText("");
		txtRGPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtRGPaciente.setColumns(10);
		txtRGPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "RG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtRGPaciente.setBounds(240, 72, 220, 40);
		panel_1.add(txtRGPaciente);

		txtNascimentoPaciente = new JFormattedTextField((AbstractFormatter) null);
		txtNascimentoPaciente.setDisabledTextColor(Color.GRAY);
		txtNascimentoPaciente.setSelectionColor(Color.GRAY);
		txtNascimentoPaciente.setEnabled(false);
		txtNascimentoPaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				String data = txtNascimentoPaciente.getText().replaceAll("[\\D]", "");
				int tamanho = data.length();

				boolean maiorIdade = true;

				if(tamanho == 8) {
					maiorIdade = Pessoa.verificaMaiorIdade(txtNascimentoPaciente.getText());
				}

				if(maiorIdade == false){
					JOptionPane.showMessageDialog(null, "Digite os dados do responsável");
					tbpPaciente.addTab("Respons\u00E1vel", null, pnlResponsavel, null);
					btnSalvarResponsavel.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/save.png")));
					btnSalvarResponsavel.setEnabled(true);
					tbpPaciente.setSelectedIndex(1);
					tbpPaciente.setEnabledAt(0, false);

					frmt.habilitaComponentes(txtNomeResponsavel, 
							txtCPFResponsavel, txtRGResponsavel, 
							txtNascimentoResponsavel, txtEmailResponsavel, 
							txtCelularResponsavel, txtTelefoneResponsavel,
							txtCelularResponsavel, txtCepResponsavel, 
							txtEnderecoResponsavel, txtNumeroResponsavel, 
							txtBairroResponsavel, txtComplementoResponsavel, txtCidadeResponsavel);
					frmt.habilitaComponentes(cmbGeneroResponsavel, cmbUFResponsavel);
				}
			}
		});
		txtNascimentoPaciente.setText("");
		txtNascimentoPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNascimentoPaciente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		txtNascimentoPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "DATA DE NASCIMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtNascimentoPaciente.setBounds(10, 123, 220, 40);
		panel_1.add(txtNascimentoPaciente);

		cmbGeneroPaciente = new JComboBox();
		cmbGeneroPaciente.setEnabled(false);
		cmbGeneroPaciente.setModel(new DefaultComboBoxModel(new String[] {"-Selecione", "Masculino", "Feminino"}));
		cmbGeneroPaciente.setForeground(Color.BLACK);
		cmbGeneroPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbGeneroPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "G\u00CANERO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbGeneroPaciente.setBackground(Color.WHITE);
		cmbGeneroPaciente.setBounds(240, 122, 220, 40);
		panel_1.add(cmbGeneroPaciente);

		txtEmailPaciente = new JTextField();
		txtEmailPaciente.setDisabledTextColor(Color.GRAY);
		txtEmailPaciente.setSelectionColor(Color.GRAY);
		txtEmailPaciente.setEnabled(false);
		txtEmailPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEmailPaciente.setColumns(10);
		txtEmailPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "E-MAIL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtEmailPaciente.setBounds(10, 188, 450, 40);
		panel_1.add(txtEmailPaciente);

		txtCelularPaciente = new JFormattedTextField((AbstractFormatter) null);
		txtCelularPaciente.setDisabledTextColor(Color.GRAY);
		txtCelularPaciente.setSelectionColor(Color.GRAY);
		txtCelularPaciente.setEnabled(false);
		txtCelularPaciente.setText("");
		txtCelularPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCelularPaciente.setColumns(10);
		txtCelularPaciente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) #####-####")));
		txtCelularPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CELULAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtCelularPaciente.setBounds(10, 239, 220, 40);
		panel_1.add(txtCelularPaciente);

		txtTelefonePaciente = new JFormattedTextField((AbstractFormatter) null);
		txtTelefonePaciente.setDisabledTextColor(Color.GRAY);
		txtTelefonePaciente.setSelectionColor(Color.GRAY);
		txtTelefonePaciente.setEnabled(false);
		txtTelefonePaciente.setText("");
		txtTelefonePaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTelefonePaciente.setColumns(10);
		txtTelefonePaciente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) ####-####")));
		txtTelefonePaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TELEFONE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtTelefonePaciente.setBounds(240, 239, 220, 40);
		panel_1.add(txtTelefonePaciente);

		separator = new JSeparator();
		separator.setBounds(10, 175, 450, 2);
		panel_1.add(separator);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 358, 470, 230);
		panel_4.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_2.setBackground(Color.WHITE);

		txtEnderecoPaciente = new JTextField();
		txtEnderecoPaciente.setDisabledTextColor(Color.GRAY);
		txtEnderecoPaciente.setSelectionColor(Color.GRAY);
		txtEnderecoPaciente.setEnabled(false);
		txtEnderecoPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEnderecoPaciente.setColumns(10);
		txtEnderecoPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtEnderecoPaciente.setBounds(10, 72, 360, 40);
		panel_2.add(txtEnderecoPaciente);

		txtComplementoPaciente = new JTextField();
		txtComplementoPaciente.setDisabledTextColor(Color.GRAY);
		txtComplementoPaciente.setSelectionColor(Color.GRAY);
		txtComplementoPaciente.setEnabled(false);
		txtComplementoPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtComplementoPaciente.setColumns(10);
		txtComplementoPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "COMPLEMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtComplementoPaciente.setBounds(240, 124, 220, 40);
		panel_2.add(txtComplementoPaciente);

		cmbUFPaciente = new JComboBox();
		cmbUFPaciente.setEnabled(false);
		cmbUFPaciente.setBackground(Color.WHITE);
		cmbUFPaciente.setModel(new DefaultComboBoxModel(new String[] {"Selecione -", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cmbUFPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbUFPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "ESTADO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbUFPaciente.setBounds(280, 176, 180, 40);
		panel_2.add(cmbUFPaciente);

		txtCepPaciente = new JFormattedTextField((AbstractFormatter) null);
		txtCepPaciente.setDisabledTextColor(Color.GRAY);
		txtCepPaciente.setSelectionColor(Color.GRAY);
		txtCepPaciente.setEnabled(false);
		txtCepPaciente.setText("");
		txtCepPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCepPaciente.setColumns(10);
		txtCepPaciente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		txtCepPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CEP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtCepPaciente.setBounds(10, 21, 220, 40);
		panel_2.add(txtCepPaciente);

		txtCidadePaciente = new JTextField();
		txtCidadePaciente.setDisabledTextColor(Color.GRAY);
		txtCidadePaciente.setSelectionColor(Color.GRAY);
		txtCidadePaciente.setEnabled(false);
		txtCidadePaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCidadePaciente.setColumns(10);
		txtCidadePaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtCidadePaciente.setBounds(10, 177, 260, 40);
		panel_2.add(txtCidadePaciente);

		txtBairroPaciente = new JTextField();
		txtBairroPaciente.setDisabledTextColor(Color.GRAY);
		txtBairroPaciente.setSelectionColor(Color.GRAY);
		txtBairroPaciente.setEnabled(false);
		txtBairroPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtBairroPaciente.setColumns(10);
		txtBairroPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "BAIRRO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtBairroPaciente.setBounds(10, 124, 220, 40);
		panel_2.add(txtBairroPaciente);

		txtNumeroPaciente = new JTextField();
		txtNumeroPaciente.setDisabledTextColor(Color.GRAY);
		txtNumeroPaciente.setSelectionColor(Color.GRAY);
		txtNumeroPaciente.setEnabled(false);
		txtNumeroPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumeroPaciente.setColumns(10);
		txtNumeroPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "N\u00BA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtNumeroPaciente.setBounds(380, 72, 80, 40);
		panel_2.add(txtNumeroPaciente);

		txtPaciente = new JFormattedTextField();
		txtPaciente.setDisabledTextColor(new Color(0, 0, 0));
		txtPaciente.setEnabled(false);
		txtPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPaciente.setColumns(10);
		txtPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "COD PACIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPaciente.setBounds(10, 5, 220, 40);
		panel_4.add(txtPaciente);

		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(490, 14, 470, 531);
		pnlPaciente.add(panel_5);
		panel_5.setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBounds(0, 35, 470, 177);
		panel_5.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "PLANO ODONTOL\u00D3GICO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setAlignmentX(0.0f);

		txtCartaoConvenioPaciente = new JTextField();
		txtCartaoConvenioPaciente.setDisabledTextColor(Color.GRAY);
		txtCartaoConvenioPaciente.setSelectionColor(Color.GRAY);
		txtCartaoConvenioPaciente.setEnabled(false);
		txtCartaoConvenioPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCartaoConvenioPaciente.setColumns(10);
		txtCartaoConvenioPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "N\u00BA CART\u00C3O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtCartaoConvenioPaciente.setBounds(10, 75, 220, 40);
		panel_3.add(txtCartaoConvenioPaciente);

		txtValidadeConvenioPaciente = new JFormattedTextField((AbstractFormatter) null);
		txtValidadeConvenioPaciente.setDisabledTextColor(Color.GRAY);
		txtValidadeConvenioPaciente.setSelectionColor(Color.GRAY);
		txtValidadeConvenioPaciente.setEnabled(false);
		txtValidadeConvenioPaciente.setText("");
		txtValidadeConvenioPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtValidadeConvenioPaciente.setColumns(10);
		txtValidadeConvenioPaciente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		txtValidadeConvenioPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "VALIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtValidadeConvenioPaciente.setBounds(240, 75, 220, 40);
		panel_3.add(txtValidadeConvenioPaciente);

		txtConvenioTitularPaciente = new JTextField();
		txtConvenioTitularPaciente.setDisabledTextColor(Color.GRAY);
		txtConvenioTitularPaciente.setSelectionColor(Color.GRAY);
		txtConvenioTitularPaciente.setEnabled(false);
		txtConvenioTitularPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		txtConvenioTitularPaciente.setColumns(10);
		txtConvenioTitularPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TITULAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtConvenioTitularPaciente.setBounds(10, 126, 450, 40);
		panel_3.add(txtConvenioTitularPaciente);

		cmbConvenioPaciente = new JComboBox();
		cmbConvenioPaciente.setEnabled(false);
		cmbConvenioPaciente.setModel(new DefaultComboBoxModel(new String[] {"- Selecione", "Porto Seguro", "Sul Am\u00E9rica"}));
		cmbConvenioPaciente.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbConvenioPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CONV\u00CANIO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbConvenioPaciente.setBackground(Color.WHITE);
		cmbConvenioPaciente.setBounds(10, 24, 450, 40);
		panel_3.add(cmbConvenioPaciente);

		chkConvenioPaciente = new JCheckBox("Possui Conv\u00EAnio?");
		chkConvenioPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frmt = new FerramentasFormulario();

				if(chkConvenioPaciente.isSelected()) {

					frmt.habilitaComponentes(txtConvenioTitularPaciente, txtCartaoConvenioPaciente, txtValidadeConvenioPaciente);
					cmbConvenioPaciente.setEnabled(true);
				}
				else {

					frmt.desabilitaComponentes(txtConvenioTitularPaciente, txtCartaoConvenioPaciente, txtValidadeConvenioPaciente);
					cmbConvenioPaciente.setEnabled(false);
				}
			}
		});
		chkConvenioPaciente.setBounds(10, 0, 123, 23);
		panel_5.add(chkConvenioPaciente);
		chkConvenioPaciente.setBorder(null);
		chkConvenioPaciente.setForeground(new Color(70, 130, 180));
		chkConvenioPaciente.setFont(new Font("Roboto", Font.BOLD, 12));
		chkConvenioPaciente.setBackground(Color.WHITE);

		panel = new JPanel();
		panel.setBounds(0, 222, 464, 309);
		panel_5.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "TRATAMENTOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel.setLayout(null);

		tratamento = new Tratamento();
		cmbTratamentos = new JComboBox();
		cmbTratamentos.setEnabled(false);
		cmbTratamentos.setBounds(10, 16, 400, 40);
		panel.add(cmbTratamentos);
		cmbTratamentos.setModel(new DefaultComboBoxModel(tratamento.nomesTratamentos(cmbTratamentos).toArray()));
		cmbTratamentos.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbTratamentos.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TRATAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbTratamentos.setBackground(Color.WHITE);

		btnNovoTratamentoPaciente = new JButton("");
		btnNovoTratamentoPaciente.setEnabled(false);
		btnNovoTratamentoPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frmTratamento frmTratamento = new frmTratamento();
				frmTratamento.setVisible(true);
				frmTratamento.setLocationRelativeTo(null);
				frmTratamento.txtNomeTratamento.setText(cmbTratamentos.getSelectedItem().toString());
			}
		});
		btnNovoTratamentoPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/plus-01.png")));
		btnNovoTratamentoPaciente.setBounds(425, 21, 35, 35);
		panel.add(btnNovoTratamentoPaciente);
		btnNovoTratamentoPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoTratamentoPaciente.setBorder(null);
		btnNovoTratamentoPaciente.setBackground(new Color(255, 255, 255));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 450, 240);
		panel.add(scrollPane);

		tblTratamentoPaciente = new JTable();
		tblTratamentoPaciente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTratamentoPaciente.setSurrendersFocusOnKeystroke(true);
		tblTratamentoPaciente.addMouseListener(new MouseAdapter() {
			int cont = 0;
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cont++;
				if(cont == 2) {

					TratamentoPaciente tratamento;
					int linha = tblTratamentoPaciente.getSelectedRow();

					frmTratamento frame = new frmTratamento();
					tratamento = frame.tratamentoPaciente = new TratamentoPaciente();

					if(tblTratamentoPaciente.getSelectedRow() != -1) {	

						tratamento.setCodTratamentoPaciente((Integer)tblTratamentoPaciente.getValueAt(linha, 0));
						tratamento.setNomeTratamento((String)tblTratamentoPaciente.getValueAt(linha, 1));
						tratamento.setNumeroConsultas((Integer)tblTratamentoPaciente.getValueAt(linha, 2));
						tratamento.setHorasConsulta((Integer)tblTratamentoPaciente.getValueAt(linha, 3));
						tratamento.setValorTratamento((Double)tblTratamentoPaciente.getValueAt(linha, 4));
						tratamento.setFormaPagamento((String)tblTratamentoPaciente.getValueAt(linha, 5));
						tratamento.setParcelas((Integer)tblTratamentoPaciente.getValueAt(linha, 6));

						frame.txtNomeTratamento.setText(tratamento.getNomeTratamento());
						frame.txtHorasConsulta.setValue(tratamento.getHorasConsulta());
						frame.txtQtdConsultas.setValue(tratamento.getNumeroConsultas());
						frame.cmbFormaPagamento.setSelectedIndex(tratamento.getFormaPagamento(frame.cmbFormaPagamento));
						frame.cmbParcelas.setSelectedIndex(tratamento.getParcelas(frame.cmbParcelas));
						frame.txtValorTratamento.setText(Double.toString(tratamento.getValorTramento()));

						cont = 0;
					}

					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}
			}
		});
		tblTratamentoPaciente.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Ref", "Tratamento", "Qtd/Consulta", "Hora/Consulta", "Valor", "Forma/Pagamento", "Parcelas"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, Integer.class, Integer.class, Double.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblTratamentoPaciente);

		btnPacienteSalvar = new JButton("");
		btnPacienteSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnPacienteSalvar.setIcon(new ImageIcon(frmPaciente.class.getResource("save.png")));
		btnPacienteSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPacienteSalvar.setBorder(null);
		btnPacienteSalvar.setBackground(Color.WHITE);
		btnPacienteSalvar.setBounds(612, 471, 60, 60);

		btnConsultarPaciente = new JButton("");
		btnConsultarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean valida1, valida2;

				if(habilitaComponentes == false) {

					frmt = new FerramentasFormulario();
					frmt.desabilitaComponentes(txtNomePaciente, 
							txtCPFPaciente, txtRGPaciente, 
							txtNascimentoPaciente, txtEmailPaciente, 
							txtCelularPaciente, txtTelefonePaciente,
							txtCelularPaciente, txtCepPaciente, 
							txtEnderecoPaciente, txtNumeroPaciente, 
							txtBairroPaciente, txtComplementoPaciente, txtCidadePaciente);
					frmt.desabilitaComponentes(cmbGeneroPaciente, cmbUFPaciente);

					frmt.desabilitaComponentes(txtNomeResponsavel, 
							txtCPFResponsavel, txtRGResponsavel, 
							txtNascimentoResponsavel, txtEmailResponsavel, 
							txtCelularResponsavel, txtTelefoneResponsavel,
							txtCelularResponsavel, txtCepResponsavel, 
							txtEnderecoResponsavel, txtNumeroResponsavel, 
							txtBairroResponsavel, txtComplementoResponsavel, txtCidadeResponsavel);
					frmt.desabilitaComponentes(cmbGeneroResponsavel, cmbUFResponsavel);

					frmt.desabilitaComponentes(btnSalvarPaciente, btnAlterarPaciente, btnExcluirPaciente);
					btnSalvarResponsavel.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/editi-01.png")));

					txtPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
					try {
						txtPaciente.setText(null);
						txtPaciente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
					} catch (ParseException e1) {e1.printStackTrace();}
					txtPaciente.setEnabled(true);
					txtPaciente.setText(null);

					try {tbpPaciente.removeTabAt(2); tbpPaciente.removeTabAt(1);} catch (Exception e2) {}

					habilitaComponentes = true;
				}else {

					/*PACIENTE*/
					paciente = new Paciente();
					paciente.setCpf(txtPaciente.getText());
					paciente.consultarPaciente(paciente);

					txtNomePaciente.setText(paciente.getNome());
					txtCPFPaciente.setText(paciente.getCpf());
					txtRGPaciente.setText(paciente.getRg());
					txtNascimentoPaciente.setText(paciente.getDataNascimento());
					cmbGeneroPaciente.setSelectedIndex(paciente.getGenero(cmbGeneroPaciente));
					txtEmailPaciente.setText(paciente.getEmail());
					txtCelularPaciente.setText(paciente.getCelular());
					txtTelefonePaciente.setText(paciente.getTelefone());
					txtCepPaciente.setText(paciente.getCep());
					txtEnderecoPaciente.setText(paciente.getEndereco());
					txtNumeroPaciente.setText(paciente.getNumero());
					txtBairroPaciente.setText(paciente.getBairro());
					txtComplementoPaciente.setText(paciente.getComplemento());
					txtCidadePaciente.setText(paciente.getCidade());
					cmbUFPaciente.setSelectedIndex(paciente.getUF(cmbUFPaciente));
					cmbConvenioPaciente.setSelectedIndex(paciente.getNomeConvenio(cmbConvenioPaciente));
					txtConvenioTitularPaciente.setText(paciente.getTitularConvenio());
					txtCartaoConvenioPaciente.setText(paciente.getCartaoConvenio());
					txtValidadeConvenioPaciente.setText(paciente.getValidadeCartaoConvenio());

					boolean maiorIdade = paciente.verificaMaiorIdade(txtNascimentoPaciente.getText());

					if(maiorIdade == false) {
						/*RESPONSÁVEL*/
						tbpPaciente.addTab("Respons\u00E1vel", null, pnlResponsavel, null);
						
						responsavel = new Responsavel();
						responsavel.setCodPaciente(paciente.getCodPaciente());
						responsavel.consultarResponsavel(responsavel);
						
						lblCodResposavel.setText(Integer.toString(responsavel.getCodPessoa()));
						txtNomeResponsavel.setText(responsavel.getNome());
						txtCPFResponsavel.setText(responsavel.getCpf());
						txtRGResponsavel.setText(responsavel.getRg());
						txtNascimentoResponsavel.setText(responsavel.getDataNascimento());
						cmbGeneroResponsavel.setSelectedIndex(responsavel.getGenero(cmbGeneroResponsavel));
						txtEmailResponsavel.setText(responsavel.getEmail());
						txtCelularResponsavel.setText(responsavel.getCelular());
						txtTelefoneResponsavel.setText(responsavel.getTelefone());
						txtCepResponsavel.setText(responsavel.getCep());
						txtEnderecoResponsavel.setText(responsavel.getEndereco());
						txtNumeroResponsavel.setText(responsavel.getNumero());
						txtBairroResponsavel.setText(responsavel.getBairro());
						txtComplementoResponsavel.setText(responsavel.getComplemento());
						txtCidadeResponsavel.setText(responsavel.getCidade());
						cmbUFResponsavel.setSelectedIndex(responsavel.getUF(cmbUFResponsavel));		
					}

					/*TRATAMENTOS*/
					tratamentoPaciente = new TratamentoPaciente();
					tratamentoPaciente.buscaTratamentosPaciente(paciente, tblTratamentoPaciente);

					/*PRONTUARIO*/
					prontuario = new Prontuario();
					prontuario.buscarProntuarioPaciente(paciente, tblAnotacoesProntuario);

					frmt.habilitaComponentes(btnAlterarPaciente, btnExcluirPaciente);

					if(frmPrincipal.nivel == 1) {
						tbpPaciente.addTab("Prontu\u00E1rio", null, pnlProntuario, null);
						btnAlterarPaciente.setEnabled(false);
						btnExcluirPaciente.setEnabled(false);
						txtNomeDentista.setText(frmPrincipal.lblUsuario.getText());
					}else if(frmPrincipal.nivel == 2) {
						tbpPaciente.addTab("Prontu\u00E1rio", null, pnlProntuario, null);
						btnAlterarPaciente.setEnabled(false);
						btnExcluirPaciente.setEnabled(false);
						btnAlterarProntuário.setEnabled(false);
						btnSalvarProntuario.setEnabled(false);
					}
					habilitaComponentes = false;
				}
			}
		});
		btnConsultarPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/search.png")));
		btnConsultarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarPaciente.setBorder(null);
		btnConsultarPaciente.setBackground(Color.WHITE);
		btnConsultarPaciente.setBounds(687, 554, 60, 60);
		pnlPaciente.add(btnConsultarPaciente);

		btnAlterarPaciente = new JButton("");
		btnAlterarPaciente.setEnabled(false);
		btnAlterarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean valida1, valida2;

				if(habilitaComponentes == false) {

					frmt = new FerramentasFormulario();
					frmt.habilitaComponentes(txtNomePaciente, 
							txtCPFPaciente, txtRGPaciente, 
							txtNascimentoPaciente, txtEmailPaciente, 
							txtCelularPaciente, txtTelefonePaciente,
							txtCelularPaciente, txtCepPaciente, 
							txtEnderecoPaciente, txtNumeroPaciente, 
							txtBairroPaciente, txtComplementoPaciente, txtCidadePaciente);
					
					frmt.habilitaComponentes(txtNomeResponsavel, 
							txtCPFResponsavel, txtRGResponsavel, 
							txtNascimentoResponsavel, txtEmailResponsavel, 
							txtCelularResponsavel, txtTelefoneResponsavel,
							txtCelularResponsavel, txtCepResponsavel, 
							txtEnderecoResponsavel, txtNumeroResponsavel, 
							txtBairroResponsavel, txtComplementoResponsavel, txtCidadeResponsavel);
					frmt.habilitaComponentes(cmbGeneroResponsavel, cmbUFResponsavel);
					btnSalvarResponsavel.setEnabled(true);

					frmt.habilitaComponentes(cmbGeneroPaciente, cmbUFPaciente, cmbTratamentos);
					frmt.habilitaComponentes(btnCancelarPaciente, btnAlterarPaciente, btnNovoTratamentoPaciente);
					frmt.desabilitaComponentes(btnSalvarPaciente, btnConsultarPaciente, btnExcluirPaciente);

					txtPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "COD PACIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
					txtPaciente.setFormatterFactory(null);
					txtPaciente.setEnabled(false);
					try {
						txtPaciente.setText(Integer.toString(paciente.getCodPaciente()));	
					} catch (Exception e) {}


					habilitaComponentes = true;

				}else {

					valida1 = frmt.validaCombo(cmbGeneroPaciente, cmbUFPaciente);
					valida2 = frmt.validaText(txtNomePaciente, 
							txtCPFPaciente, txtRGPaciente, 
							txtNascimentoPaciente, txtEmailPaciente, 
							txtCelularPaciente, txtCelularPaciente, 
							txtCepPaciente, txtEnderecoPaciente, 
							txtNumeroPaciente, txtBairroPaciente, 
							txtComplementoPaciente, txtCidadePaciente);

					if(valida1 == false && valida2 == false) {

						JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");

					}else {

						paciente.setNome(txtNomePaciente.getText());
						paciente.setCpf(txtCPFPaciente.getText());
						paciente.setRg(txtRGPaciente.getText());
						paciente.setDataNascimento(txtNascimentoPaciente.getText());	
						paciente.setGenero(cmbGeneroPaciente);
						paciente.setEmail(txtEmailPaciente.getText());
						paciente.setCelular(txtCelularPaciente.getText());
						paciente.setTelefone(txtTelefonePaciente.getText());
						paciente.setCep(txtCepPaciente.getText());
						paciente.setEndereco(txtEnderecoPaciente.getText());
						paciente.setNumero(txtNumeroPaciente.getText());
						paciente.setBairro(txtBairroPaciente.getText());
						paciente.setComplemento(txtComplementoPaciente.getText());
						paciente.setCidade(txtCidadePaciente.getText());
						paciente.setUf(cmbUFPaciente.getSelectedItem().toString());
						paciente.setNomeConvenio(cmbConvenioPaciente.getSelectedItem().toString());
						paciente.setCartaoConvenio(txtCartaoConvenioPaciente.getText());
						paciente.setValidadeCartaoConvenio(txtValidadeConvenioPaciente.getText());
						paciente.setTitularConvenio(txtConvenioTitularPaciente.getText());

						boolean maiorIdade = paciente.verificaMaiorIdade(txtNascimentoPaciente.getText());

						if(maiorIdade == false) {
							valida1 = frmt.validaCombo(cmbGeneroResponsavel, cmbUFResponsavel);
							valida2 = frmt.validaText(txtNomeResponsavel, 
									txtCPFResponsavel, txtRGResponsavel, 
									txtNascimentoResponsavel, txtEmailResponsavel, 
									txtCelularResponsavel, txtCelularResponsavel, 
									txtCepResponsavel, txtEnderecoResponsavel, 
									txtNumeroResponsavel, txtBairroResponsavel, 
									txtComplementoResponsavel, txtCidadeResponsavel);

							if(valida1 == false && valida2 == false) {
								JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios do Responsável");

							}else {

								responsavel.setNome(txtNomeResponsavel.getText());
								responsavel.setCpf(txtCPFResponsavel.getText());
								responsavel.setRg(txtRGResponsavel.getText());
								responsavel.setDataNascimento(txtNascimentoResponsavel.getText());	
								responsavel.setGenero(cmbGeneroResponsavel);
								responsavel.setEmail(txtEmailResponsavel.getText());
								responsavel.setCelular(txtCelularResponsavel.getText());
								responsavel.setTelefone(txtTelefoneResponsavel.getText());
								responsavel.setCep(txtCepResponsavel.getText());
								responsavel.setEndereco(txtEnderecoResponsavel.getText());
								responsavel.setNumero(txtNumeroResponsavel.getText());
								responsavel.setBairro(txtBairroResponsavel.getText());
								responsavel.setComplemento(txtComplementoResponsavel.getText());
								responsavel.setCidade(txtCidadeResponsavel.getText());
								responsavel.setUf(cmbUFResponsavel.getSelectedItem().toString());
								paciente.alterarPaciente(paciente, responsavel);
								habilitaComponentes = false;
							}
						}else {
							paciente.alterarPaciente(paciente);
							habilitaComponentes = false;
						}
					}
				}
			}
		});
		btnAlterarPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/editi-01.png")));
		btnAlterarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterarPaciente.setBorder(null);
		btnAlterarPaciente.setBackground(Color.WHITE);
		btnAlterarPaciente.setBounds(759, 554, 60, 60);
		pnlPaciente.add(btnAlterarPaciente);

		btnExcluirPaciente = new JButton("");
		btnExcluirPaciente.setEnabled(false);
		btnExcluirPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean maiorIdade = paciente.verificaMaiorIdade(txtNascimentoPaciente.getText());

				paciente.excluirPaciente(paciente);

				frmt = new FerramentasFormulario();
				frmt.limpaComponentes(
						txtPaciente, txtNomePaciente, 
						txtCPFPaciente, txtRGPaciente, 
						txtNascimentoPaciente, txtEmailPaciente, 
						txtCelularPaciente, txtTelefonePaciente,
						txtCelularPaciente, txtCepPaciente, 
						txtEnderecoPaciente, txtNumeroPaciente, 
						txtBairroPaciente, txtComplementoPaciente, 
						txtCidadePaciente
						);

				frmt.desabilitaComponentes(
						txtPaciente, txtNomePaciente, 
						txtCPFPaciente, txtRGPaciente, 
						txtNascimentoPaciente, txtEmailPaciente, 
						txtCelularPaciente, txtTelefonePaciente,
						txtCelularPaciente, txtCepPaciente, 
						txtEnderecoPaciente, txtNumeroPaciente, 
						txtBairroPaciente, txtComplementoPaciente, txtCidadePaciente
						);

				frmt.resetCombo(cmbConvenioPaciente, cmbGeneroPaciente, cmbTratamentos, cmbUFPaciente);

				if(maiorIdade == false) {
					tbpPaciente.removeTabAt(1);
				}

				frmt.limpaTabela(tblTratamentoPaciente);
				frmt.limpaTabela(tblAnotacoesProntuario);
				txtPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "COD PACIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
				txtPaciente.setFormatterFactory(null);
			}			
		});
		btnExcluirPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/delete-01.png")));
		btnExcluirPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirPaciente.setBorder(null);
		btnExcluirPaciente.setBackground(Color.WHITE);
		btnExcluirPaciente.setBounds(831, 554, 60, 60);
		pnlPaciente.add(btnExcluirPaciente);

		btnCancelarPaciente = new JButton("");
		btnCancelarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmt = new FerramentasFormulario();
				frmt.limpaComponentes(
						txtPaciente, txtNomePaciente, 
						txtCPFPaciente, txtRGPaciente, 
						txtNascimentoPaciente, txtEmailPaciente, 
						txtCelularPaciente, txtTelefonePaciente,
						txtCelularPaciente, txtCepPaciente, 
						txtEnderecoPaciente, txtNumeroPaciente, 
						txtBairroPaciente, txtComplementoPaciente, 
						txtCidadePaciente, txtCartaoConvenioPaciente,
						txtValidadeConvenioPaciente, txtConvenioTitularPaciente
						);

				frmt.resetCombo(
						cmbConvenioPaciente, cmbGeneroPaciente, 
						cmbTratamentos, cmbUFPaciente, cmbConvenioPaciente
						);

				frmt.desabilitaComponentes(
						txtPaciente, txtNomePaciente, 
						txtCPFPaciente, txtRGPaciente, 
						txtNascimentoPaciente, txtEmailPaciente, 
						txtCelularPaciente, txtTelefonePaciente,
						txtCelularPaciente, txtCepPaciente, 
						txtEnderecoPaciente, txtNumeroPaciente, 
						txtBairroPaciente, txtComplementoPaciente, 
						txtCidadePaciente, txtCartaoConvenioPaciente,
						txtValidadeConvenioPaciente, txtConvenioTitularPaciente
						);

				frmt.desabilitaComponentes(
						cmbConvenioPaciente, cmbGeneroPaciente, 
						cmbTratamentos, cmbUFPaciente, cmbConvenioPaciente
						);

				chkConvenioPaciente.setSelected(false);

				frmt.limpaComponentes(
						txtNomeResponsavel, txtNomeResponsavel, 
						txtCPFResponsavel, txtRGResponsavel, 
						txtNascimentoResponsavel, txtEmailResponsavel, 
						txtCelularResponsavel, txtTelefoneResponsavel,
						txtCelularResponsavel, txtCepResponsavel, 
						txtEnderecoResponsavel, txtNumeroResponsavel, 
						txtBairroResponsavel, txtComplementoResponsavel, 
						txtCidadeResponsavel
						);

				frmt.resetCombo(cmbGeneroResponsavel, cmbUFResponsavel);

				
				tbpPaciente.removeTabAt(1);

				frmt.limpaTabela(tblTratamentoPaciente);
				frmt.limpaTabela(tblAnotacoesProntuario);

				frmt.desabilitaComponentes(btnAlterarPaciente, btnExcluirPaciente);
				frmt.habilitaComponentes(btnConsultarPaciente, btnSalvarPaciente);

				txtPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "COD PACIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
				txtPaciente.setFormatterFactory(null);

				btnSalvarPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/plus-02.png")));

				habilitaComponentes = false;
			}
		});
		btnCancelarPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/cancel-01.png")));
		btnCancelarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelarPaciente.setBorder(null);
		btnCancelarPaciente.setBackground(Color.WHITE);
		btnCancelarPaciente.setBounds(903, 554, 60, 60);
		pnlPaciente.add(btnCancelarPaciente);

		btnSalvarPaciente = new JButton("");
		btnSalvarPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/plus-02.png")));
		btnSalvarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean valida1, valida2;

				if(habilitaComponentes == false) {

					frmt = new FerramentasFormulario();
					frmt.habilitaComponentes(txtNomePaciente, 
							txtCPFPaciente, txtRGPaciente, 
							txtNascimentoPaciente, txtEmailPaciente, 
							txtCelularPaciente, txtTelefonePaciente,
							txtCelularPaciente, txtCepPaciente, 
							txtEnderecoPaciente, txtNumeroPaciente, 
							txtBairroPaciente, txtComplementoPaciente, txtCidadePaciente);
					frmt.habilitaComponentes(cmbGeneroPaciente, cmbUFPaciente);

					frmt.habilitaComponentes(btnSalvarPaciente, btnCancelarPaciente);
					frmt.desabilitaComponentes(btnAlterarPaciente, btnConsultarPaciente, btnExcluirPaciente);
					btnSalvarPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/save.png")));
					txtPaciente.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "COD PACIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

					habilitaComponentes = true;

				}else {

					valida1 = frmt.validaCombo(cmbGeneroPaciente, cmbUFPaciente);
					valida2 = frmt.validaText(txtNomePaciente, 
							txtCPFPaciente, txtRGPaciente, 
							txtNascimentoPaciente, txtEmailPaciente, 
							txtCelularPaciente, txtCelularPaciente, 
							txtCepPaciente, txtEnderecoPaciente, 
							txtNumeroPaciente, txtBairroPaciente, 
							txtComplementoPaciente, txtCidadePaciente);

					if(valida1 == false && valida2 == false) {

						JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");

					}else {

						paciente = new Paciente();
						paciente.setNome(txtNomePaciente.getText());
						paciente.setCpf(txtCPFPaciente.getText());
						paciente.setRg(txtRGPaciente.getText());
						paciente.setDataNascimento(txtNascimentoPaciente.getText());	
						paciente.setGenero(cmbGeneroPaciente);
						paciente.setEmail(txtEmailPaciente.getText());
						paciente.setCelular(txtCelularPaciente.getText());
						paciente.setTelefone(txtTelefonePaciente.getText());
						paciente.setCep(txtCepPaciente.getText());
						paciente.setEndereco(txtEnderecoPaciente.getText());
						paciente.setNumero(txtNumeroPaciente.getText());
						paciente.setBairro(txtBairroPaciente.getText());
						paciente.setComplemento(txtComplementoPaciente.getText());
						paciente.setCidade(txtCidadePaciente.getText());
						paciente.setUf(cmbUFPaciente.getSelectedItem().toString());
						paciente.setNomeConvenio(cmbConvenioPaciente.getSelectedItem().toString());
						paciente.setCartaoConvenio(txtCartaoConvenioPaciente.getText());
						paciente.setValidadeCartaoConvenio(txtValidadeConvenioPaciente.getText());
						paciente.setTitularConvenio(txtConvenioTitularPaciente.getText());

						boolean maiorIdade = paciente.verificaMaiorIdade(txtNascimentoPaciente.getText());

						if (maiorIdade == false) {

							paciente.salvarPaciente(paciente);
							responsavel.salvarResponsavel(responsavel, paciente);

						}else {

							paciente.salvarPaciente(paciente);
							txtPaciente.setText(Integer.toString(paciente.getCodPaciente()));
						}

						txtPaciente.setText(Integer.toString(paciente.getCodPaciente()));

						cmbTratamentos.setEnabled(true);
						btnNovoTratamentoPaciente.setEnabled(true);

						frmt.desabilitaComponentes(btnSalvarPaciente);
						frmt.habilitaComponentes(btnConsultarPaciente, btnCancelarPaciente);

						btnSalvarPaciente.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/plus-02.png")));
						habilitaComponentes = false;
					}
				}
			}
		});
		btnSalvarPaciente.setBorder(null);
		btnSalvarPaciente.setBackground(Color.WHITE);
		btnSalvarPaciente.setBounds(615, 554, 60, 60);
		pnlPaciente.add(btnSalvarPaciente);

		pnlResponsavel = new JPanel();
		pnlResponsavel.setBorder(null);
		pnlResponsavel.setBackground(new Color(245,245,245));
		tbpPaciente.addTab("Respons\u00E1vel", null, pnlResponsavel, null);
		pnlResponsavel.setLayout(null);

		panel_10 = new JPanel();
		panel_10.setBounds(12, 12, 470, 281);
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "DADOS RESPONS\u00C1VEL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		pnlResponsavel.add(panel_10);
		panel_10.setLayout(null);

		txtNomeResponsavel = new JTextField();
		txtNomeResponsavel.setDisabledTextColor(Color.GRAY);
		txtNomeResponsavel.setSelectionColor(Color.GRAY);
		txtNomeResponsavel.setEnabled(false);
		txtNomeResponsavel.setBounds(12, 22, 450, 40);
		panel_10.add(txtNomeResponsavel);
		txtNomeResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNomeResponsavel.setColumns(10);
		txtNomeResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "NOME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		txtCPFResponsavel = new JFormattedTextField();
		txtCPFResponsavel.setDisabledTextColor(Color.GRAY);
		txtCPFResponsavel.setSelectionColor(Color.GRAY);
		txtCPFResponsavel.setEnabled(false);
		txtCPFResponsavel.setBounds(12, 74, 220, 40);
		panel_10.add(txtCPFResponsavel);
		txtCPFResponsavel.setText("");
		txtCPFResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCPFResponsavel.setColumns(10);
		txtCPFResponsavel.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		txtCPFResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		txtRGResponsavel = new JTextField();
		txtRGResponsavel.setDisabledTextColor(Color.GRAY);
		txtRGResponsavel.setSelectionColor(Color.GRAY);
		txtRGResponsavel.setEnabled(false);
		txtRGResponsavel.setBounds(242, 74, 220, 40);
		panel_10.add(txtRGResponsavel);
		txtRGResponsavel.setText("");
		txtRGResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtRGResponsavel.setColumns(10);
		txtRGResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "RG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		txtNascimentoResponsavel = new JFormattedTextField();
		txtNascimentoResponsavel.setDisabledTextColor(Color.GRAY);
		txtNascimentoResponsavel.setSelectionColor(Color.GRAY);
		txtNascimentoResponsavel.setEnabled(false);
		txtNascimentoResponsavel.setBounds(12, 127, 220, 40);
		panel_10.add(txtNascimentoResponsavel);
		txtNascimentoResponsavel.setText("");
		txtNascimentoResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNascimentoResponsavel.setColumns(10);
		txtNascimentoResponsavel.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		txtNascimentoResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "DATA DE NASCIMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		cmbGeneroResponsavel = new JComboBox();
		cmbGeneroResponsavel.setEnabled(false);
		cmbGeneroResponsavel.setModel(new DefaultComboBoxModel(new String[] {"Selecione -", "Masculino", "Feminino"}));
		cmbGeneroResponsavel.setBounds(242, 127, 220, 40);
		panel_10.add(cmbGeneroResponsavel);
		cmbGeneroResponsavel.setForeground(Color.BLACK);
		cmbGeneroResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbGeneroResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "G\u00CANERO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbGeneroResponsavel.setBackground(Color.WHITE);

		txtEmailResponsavel = new JTextField();
		txtEmailResponsavel.setDisabledTextColor(Color.GRAY);
		txtEmailResponsavel.setSelectionColor(Color.GRAY);
		txtEmailResponsavel.setEnabled(false);
		txtEmailResponsavel.setBounds(12, 179, 450, 40);
		panel_10.add(txtEmailResponsavel);
		txtEmailResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEmailResponsavel.setColumns(10);
		txtEmailResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "E-MAIL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		txtCelularResponsavel = new JFormattedTextField();
		txtCelularResponsavel.setDisabledTextColor(Color.GRAY);
		txtCelularResponsavel.setSelectionColor(Color.GRAY);
		txtCelularResponsavel.setEnabled(false);
		txtCelularResponsavel.setBounds(12, 231, 220, 40);
		panel_10.add(txtCelularResponsavel);
		txtCelularResponsavel.setText("");
		txtCelularResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCelularResponsavel.setColumns(10);
		txtCelularResponsavel.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) #####-####")));
		txtCelularResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CELULAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		txtTelefoneResponsavel = new JFormattedTextField();
		txtTelefoneResponsavel.setDisabledTextColor(Color.GRAY);
		txtTelefoneResponsavel.setSelectionColor(Color.GRAY);
		txtTelefoneResponsavel.setEnabled(false);
		txtTelefoneResponsavel.setBounds(242, 231, 220, 40);
		panel_10.add(txtTelefoneResponsavel);
		txtTelefoneResponsavel.setText("");
		txtTelefoneResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTelefoneResponsavel.setColumns(10);
		txtTelefoneResponsavel.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) ####-####")));
		txtTelefoneResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TELEFONE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		btnSalvarResponsavel = new JButton("");
		btnSalvarResponsavel.setEnabled(false);
		btnSalvarResponsavel.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/save.png")));
		btnSalvarResponsavel.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {

				responsavel = new Responsavel();
				responsavel.setNome(txtNomeResponsavel.getText());
				responsavel.setCpf(txtCPFResponsavel.getText());
				responsavel.setRg(txtRGResponsavel.getText());
				responsavel.setDataNascimento(txtNascimentoResponsavel.getText());	
				responsavel.setGenero(cmbGeneroResponsavel);
				responsavel.setEmail(txtEmailResponsavel.getText());
				responsavel.setCelular(txtCelularResponsavel.getText());
				responsavel.setTelefone(txtTelefoneResponsavel.getText());
				responsavel.setCep(txtCepResponsavel.getText());
				responsavel.setEndereco(txtEnderecoResponsavel.getText());
				responsavel.setNumero(txtNumeroResponsavel.getText());
				responsavel.setBairro(txtBairroResponsavel.getText());
				responsavel.setComplemento(txtComplementoResponsavel.getText());
				responsavel.setCidade(txtCidadeResponsavel.getText());
				responsavel.setUf(cmbUFResponsavel.getSelectedItem().toString());
				responsavel.setCodPessoa(Integer.parseInt(lblCodResposavel.getText()));

				txtCepPaciente.setText(responsavel.getCep());
				txtEnderecoPaciente.setText(responsavel.getEndereco());
				txtNumeroPaciente.setText(responsavel.getNumero());
				txtBairroPaciente.setText(responsavel.getBairro());
				txtComplementoPaciente.setText(responsavel.getComplemento());
				txtCidadePaciente.setText(responsavel.getCidade());
				cmbUFPaciente.setSelectedIndex(responsavel.getUF(cmbUFPaciente));

				tbpPaciente.setEnabledAt(0, true);		
				tbpPaciente.setSelectedIndex(0);	

			}
		});
		btnSalvarResponsavel.setBorder(null);
		btnSalvarResponsavel.setBackground(Color.WHITE);
		btnSalvarResponsavel.setBounds(422, 554, 60, 60);
		pnlResponsavel.add(btnSalvarResponsavel);

		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(12, 305, 470, 230);
		pnlResponsavel.add(panel_9);

		txtEnderecoResponsavel = new JTextField();
		txtEnderecoResponsavel.setDisabledTextColor(Color.GRAY);
		txtEnderecoResponsavel.setSelectionColor(Color.GRAY);
		txtEnderecoResponsavel.setEnabled(false);
		txtEnderecoResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEnderecoResponsavel.setColumns(10);
		txtEnderecoResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "ENDERE\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtEnderecoResponsavel.setBounds(10, 72, 360, 40);
		panel_9.add(txtEnderecoResponsavel);

		txtComplementoResponsavel = new JTextField();
		txtComplementoResponsavel.setDisabledTextColor(Color.GRAY);
		txtComplementoResponsavel.setSelectionColor(Color.GRAY);
		txtComplementoResponsavel.setEnabled(false);
		txtComplementoResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtComplementoResponsavel.setColumns(10);
		txtComplementoResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "COMPLEMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtComplementoResponsavel.setBounds(240, 124, 220, 40);
		panel_9.add(txtComplementoResponsavel);

		cmbUFResponsavel = new JComboBox();
		cmbUFResponsavel.setEnabled(false);
		cmbUFResponsavel.setModel(new DefaultComboBoxModel(new String[] {"Selecione -", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cmbUFResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbUFResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "ESTADO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbUFResponsavel.setBackground(Color.WHITE);
		cmbUFResponsavel.setBounds(280, 176, 180, 40);
		panel_9.add(cmbUFResponsavel);

		txtCepResponsavel = new JFormattedTextField();
		txtCepResponsavel.setDisabledTextColor(Color.GRAY);
		txtCepResponsavel.setSelectionColor(Color.GRAY);
		txtCepResponsavel.setEnabled(false);
		txtCepResponsavel.setText("");
		txtCepResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCepResponsavel.setColumns(10);
		txtCepResponsavel.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		txtCepResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CEP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtCepResponsavel.setBounds(10, 21, 220, 40);

		panel_9.add(txtCepResponsavel);

		txtCidadeResponsavel = new JTextField();
		txtCidadeResponsavel.setDisabledTextColor(Color.GRAY);
		txtCidadeResponsavel.setSelectionColor(Color.GRAY);
		txtCidadeResponsavel.setEnabled(false);
		txtCidadeResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtCidadeResponsavel.setColumns(10);
		txtCidadeResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "CIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtCidadeResponsavel.setBounds(10, 177, 260, 40);
		panel_9.add(txtCidadeResponsavel);

		txtBairroResponsavel = new JTextField();
		txtBairroResponsavel.setDisabledTextColor(Color.GRAY);
		txtBairroResponsavel.setSelectionColor(Color.GRAY);
		txtBairroResponsavel.setEnabled(false);
		txtBairroResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtBairroResponsavel.setColumns(10);
		txtBairroResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "BAIRRO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtBairroResponsavel.setBounds(10, 124, 220, 40);
		panel_9.add(txtBairroResponsavel);

		txtNumeroResponsavel = new JTextField();
		txtNumeroResponsavel.setDisabledTextColor(Color.GRAY);
		txtNumeroResponsavel.setSelectionColor(Color.GRAY);
		txtNumeroResponsavel.setEnabled(false);
		txtNumeroResponsavel.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumeroResponsavel.setColumns(10);
		txtNumeroResponsavel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "N\u00BA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtNumeroResponsavel.setBounds(380, 72, 80, 40);
		panel_9.add(txtNumeroResponsavel);
		
		lblCodResposavel = new JLabel("");
		lblCodResposavel.setVisible(false);
		lblCodResposavel.setBounds(500, 63, 55, 16);
		pnlResponsavel.add(lblCodResposavel);

		pnlProntuario = new JPanel();
		tbpPaciente.addTab("Prontu\u00E1rio", null, pnlProntuario, null);
		pnlProntuario.setLayout(null);

		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "ANOTA\u00C7\u00C3O", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 11, 468, 531);
		pnlProntuario.add(panel_7);

		txtNomeDentista = new JTextField();
		txtNomeDentista.setDisabledTextColor(Color.GRAY);
		txtNomeDentista.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNomeDentista.setColumns(10);
		txtNomeDentista.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "DENTISTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtNomeDentista.setBounds(10, 21, 450, 40);
		panel_7.add(txtNomeDentista);

		txtDataProntuario = new JFormattedTextField((Object) null);
		txtDataProntuario.setDisabledTextColor(Color.GRAY);
		txtDataProntuario.setText("");
		txtDataProntuario.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDataProntuario.setColumns(10);
		txtDataProntuario.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		txtDataProntuario.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "DATA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtDataProntuario.setBounds(10, 72, 220, 40);
		panel_7.add(txtDataProntuario);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		scrollPane_2.setBounds(12, 123, 448, 396);
		panel_7.add(scrollPane_2);

		txtAnotacaoProntuario = new JTextPane();
		scrollPane_2.setViewportView(txtAnotacaoProntuario);
		txtAnotacaoProntuario.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtAnotacaoProntuario.setBorder(new LineBorder(new Color(70, 130, 180)));

		btnSalvarProntuario = new JButton("");
		btnSalvarProntuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				prontuario = new Prontuario(paciente);
				prontuario.setNomeMedico(txtNomeDentista.getText());
				prontuario.setDataAnotacao(txtDataProntuario.getText());
				prontuario.setAnotacao(txtAnotacaoProntuario.getText());

				prontuario.salvarAnotacaoProntuario(prontuario, tblAnotacoesProntuario);

				txtNomeDentista.setText(null);
				txtDataProntuario.setText(null);
				txtAnotacaoProntuario.setText(null);
			}
		});
		btnSalvarProntuario.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/save.png")));
		btnSalvarProntuario.setBorder(null);
		btnSalvarProntuario.setBackground(Color.WHITE);
		btnSalvarProntuario.setBounds(274, 554, 60, 60);
		pnlProntuario.add(btnSalvarProntuario);

		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "HIST\u00D3RICO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(490, 11, 468, 603);
		pnlProntuario.add(panel_8);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 22, 444, 569);
		panel_8.add(scrollPane_1);

		tblAnotacoesProntuario = new JTable();
		tblAnotacoesProntuario.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tblAnotacoesProntuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblAnotacoesProntuario.addMouseListener(new MouseAdapter() {
			int cont = 0;
			@Override
			public void mouseClicked(MouseEvent arg0) {

				cont++;
				if(cont == 2) {

					prontuario = new Prontuario();
					int linha = tblAnotacoesProntuario.getSelectedRow();

					txtNomeDentista.setEnabled(false);
					txtDataProntuario.setEnabled(false);

					if(tblAnotacoesProntuario.getSelectedRow() != -1) {	

						prontuario.setCodAnotacao((Integer)tblAnotacoesProntuario.getValueAt(linha, 1));
						int cod = prontuario.getCodAnotacao();
						prontuario = prontuario.buscarAnotacaoPaciente(cod);

						txtNomeDentista.setText(prontuario.getNomeMedico());
						txtDataProntuario.setText(prontuario.getDataAnotacao().replaceAll("/", ""));
						txtAnotacaoProntuario.setText(prontuario.getAnotacao());

						btnSalvarProntuario.setEnabled(false);

						cont = 0;
					} 

					if(frmPrincipal.nivel == 1) {
						btnAlterarProntuário.setEnabled(true);
					} else {
						btnAlterarProntuário.setEnabled(false);
					}
				}
			}
		});
		tblAnotacoesProntuario.setRowMargin(0);
		tblAnotacoesProntuario.setRowHeight(100);
		tblAnotacoesProntuario.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ANOTA\u00C7\u00D5ES", "REF"
				}
				) {
			Class[] columnTypes = new Class[] {
					Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblAnotacoesProntuario.getColumnModel().getColumn(1).setPreferredWidth(30);
		tblAnotacoesProntuario.getColumnModel().getColumn(1).setMinWidth(30);
		tblAnotacoesProntuario.getColumnModel().getColumn(1).setMaxWidth(45);
		scrollPane_1.setViewportView(tblAnotacoesProntuario);

		btnCancelarProntuario = new JButton("");
		btnCancelarProntuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(frmPrincipal.nivel == 1) {
					txtNomeDentista.setText(null);
					txtDataProntuario.setText(null);
					txtAnotacaoProntuario.setText(null);
					btnAlterarProntuário.setEnabled(false);
					btnSalvarProntuario.setEnabled(true);
					txtNomeDentista.setEnabled(true);
					txtDataProntuario.setEnabled(true);
				}
			}
		});
		btnCancelarProntuario.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/cancel-01.png")));
		btnCancelarProntuario.setBorder(null);
		btnCancelarProntuario.setBackground(Color.WHITE);
		btnCancelarProntuario.setBounds(418, 554, 60, 60);
		pnlProntuario.add(btnCancelarProntuario);

		btnAlterarProntuário = new JButton("");
		btnAlterarProntuário.setEnabled(false);
		btnAlterarProntuário.setIcon(new ImageIcon(frmPaciente.class.getResource("/br/com/odontomais/view/editi-01.png")));
		btnAlterarProntuário.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				prontuario.setNomeMedico(txtNomeDentista.getText());
				prontuario.setDataAnotacao(txtDataProntuario.getText());
				prontuario.setAnotacao(txtAnotacaoProntuario.getText());

				prontuario.alterarAnotacao(prontuario, tblAnotacoesProntuario);

			}
		});
		btnAlterarProntuário.setBorder(null);
		btnAlterarProntuário.setBackground(Color.WHITE);
		btnAlterarProntuário.setBounds(346, 554, 60, 60);
		pnlProntuario.add(btnAlterarProntuário);
	}
}
