package br.com.odontomais.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.odontomais.model.Tratamento;
import br.com.odontomais.model.TratamentoPaciente;

import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JSpinner;
import java.awt.Rectangle;
import javax.swing.JSlider;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;

public class frmTratamento extends JFrame {

	private JPanel contentPane;
	public JTextField txtNomeTratamento;
	public JFormattedTextField txtValorTratamento;
	public JComboBox cmbFormaPagamento;
	public JButton btnAdicionarTratamento;
	public JButton btnPacienteConsultar;
	public JButton btnPacienteAlterar;
	public JButton btnPacienteExcluir;
	public JComboBox cmbParcelas;
	public JSpinner txtQtdConsultas;

	public Tratamento tratamento;
	public TratamentoPaciente tratamentoPaciente;
	public JSpinner txtHorasConsulta;
	public JPanel panel;
	public JPanel panel_1;
	public JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTratamento frame = new frmTratamento();
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
	public frmTratamento() {
		setResizable(false);
		setTitle("Adicionar Tratamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 337);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(70, 130, 180)), "CONSULTAS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 130, 180)));
		panel.setBounds(11, 12, 325, 115);
		contentPane.add(panel);
		panel.setLayout(null);

		txtNomeTratamento = new JTextField();
		txtNomeTratamento.setBounds(5, 18, 315, 40);
		panel.add(txtNomeTratamento);
		txtNomeTratamento.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNomeTratamento.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TRATAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtNomeTratamento.setBackground(Color.WHITE);
		
				txtQtdConsultas = new JSpinner();
				txtQtdConsultas.setBounds(5, 70, 102, 40);
				panel.add(txtQtdConsultas);
				txtQtdConsultas.setFont(new Font("Dialog", Font.PLAIN, 12));
				txtQtdConsultas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				txtQtdConsultas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				txtQtdConsultas.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "QUANTIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
				txtQtdConsultas.setBackground(Color.WHITE);
				
				txtHorasConsulta = new JSpinner();
				txtHorasConsulta.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				txtHorasConsulta.setBounds(119, 70, 74, 40);
				panel.add(txtHorasConsulta);
				txtHorasConsulta.setFont(new Font("Arial", Font.PLAIN, 13));
				txtHorasConsulta.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "HORAS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
				txtHorasConsulta.setBackground(Color.WHITE);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(16, 145, 314, 84);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtValorTratamento = new JFormattedTextField((AbstractFormatter) null);
		txtValorTratamento.setBounds(0, 0, 188, 40);
		panel_1.add(txtValorTratamento);
		txtValorTratamento.setText("");
		txtValorTratamento.setFont(new Font("Arial", Font.PLAIN, 13));
		txtValorTratamento.setColumns(10);
		txtValorTratamento.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "VALOR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		cmbFormaPagamento = new JComboBox();
		cmbFormaPagamento.setBounds(0, 44, 188, 40);
		panel_1.add(cmbFormaPagamento);
		cmbFormaPagamento.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbFormaPagamento.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbFormaPagamento.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "FORMA/PAGAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbFormaPagamento.setBackground(Color.WHITE);
		
				cmbParcelas = new JComboBox();
				cmbParcelas.setBounds(200, 44, 114, 40);
				panel_1.add(cmbParcelas);
				cmbParcelas.setModel(new DefaultComboBoxModel(new String[] {"1"}));
				cmbParcelas.setFont(new Font("Arial", Font.PLAIN, 13));
				cmbParcelas.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "PARCELAS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
				cmbParcelas.setBackground(Color.WHITE);

		btnAdicionarTratamento = new JButton("");
		btnAdicionarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tratamentoPaciente = new TratamentoPaciente();
				tratamentoPaciente.setNomeTratamento(txtNomeTratamento.getText());
				tratamentoPaciente.setNumeroConsultas((Integer)txtQtdConsultas.getValue());
				tratamentoPaciente.setHorasConsulta((Integer)txtHorasConsulta.getValue());
				tratamentoPaciente.setFormaPagamento((String)cmbFormaPagamento.getSelectedItem());
				tratamentoPaciente.setParcelas(Integer.parseInt(cmbParcelas.getSelectedItem().toString()));
				
				if(tratamentoPaciente.setValorTratamento(txtValorTratamento.getText()) == true) {
					tratamentoPaciente.adicionarTratamentoPaciente(tratamentoPaciente, frmPaciente.paciente);
				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
			}
		});
		btnAdicionarTratamento.setIcon(new ImageIcon(frmTratamento.class.getResource("/br/com/odontomais/view/plus-02.png")));
		btnAdicionarTratamento.setBorder(null);
		btnAdicionarTratamento.setBackground(new Color(255, 255, 255));
		btnAdicionarTratamento.setBounds(119, 241, 45, 45);
		contentPane.add(btnAdicionarTratamento);

		btnPacienteConsultar = new JButton("");
		btnPacienteConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tratamentoPaciente.setNomeTratamento(txtNomeTratamento.getText());
				tratamentoPaciente.setNumeroConsultas((Integer)txtQtdConsultas.getValue());
				tratamentoPaciente.setHorasConsulta((Integer)txtHorasConsulta.getValue());
				tratamentoPaciente.setFormaPagamento((String)cmbFormaPagamento.getSelectedItem());
				tratamentoPaciente.setParcelas(Integer.parseInt(cmbParcelas.getSelectedItem().toString()));
				
				if(tratamentoPaciente.setValorTratamento(txtValorTratamento.getText()) == true) {
					tratamentoPaciente.adicionarTratamentoPaciente(tratamentoPaciente, frmPaciente.paciente);
				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
				
				tratamentoPaciente.alteraTratamentoPaciente(tratamentoPaciente);
			}
			
		});
		btnPacienteConsultar.setIcon(new ImageIcon(frmTratamento.class.getResource("/br/com/odontomais/view/search.png")));
		btnPacienteConsultar.setBorder(null);
		btnPacienteConsultar.setBackground(new Color(255, 255, 255));
		btnPacienteConsultar.setBounds(176, 241, 45, 45);
		contentPane.add(btnPacienteConsultar);

		btnPacienteAlterar = new JButton("");
		btnPacienteAlterar.setIcon(new ImageIcon(frmTratamento.class.getResource("/br/com/odontomais/view/editi-01.png")));
		btnPacienteAlterar.setBorder(null);
		btnPacienteAlterar.setBackground(new Color(255, 255, 255));
		btnPacienteAlterar.setBounds(233, 241, 45, 45);
		contentPane.add(btnPacienteAlterar);

		btnPacienteExcluir = new JButton("");
		btnPacienteExcluir.setIcon(new ImageIcon(frmTratamento.class.getResource("/br/com/odontomais/view/cancel-01.png")));
		btnPacienteExcluir.setBorder(null);
		btnPacienteExcluir.setBackground(new Color(255, 255, 255));
		btnPacienteExcluir.setBounds(290, 241, 45, 45);
		contentPane.add(btnPacienteExcluir);
		
		separator = new JSeparator();
		separator.setForeground(new Color(70, 130, 180));
		separator.setBounds(16, 131, 314, 2);
		contentPane.add(separator);
	}
}
