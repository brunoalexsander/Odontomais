package br.com.odontomais.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.odontomais.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmUsuario extends JFrame {

	private JPanel contentPane;
	public JTextField txtNomeUsuario;
	public JButton btnSalvarPaciente;
	public JTextField txtLoginUsuario;
	public JPasswordField txtSenhaUsuario;
	public JComboBox cmbNivelAcesso;
	public JScrollPane scrollPane;
	public JButton btnExcluirUsuario;
	public JButton btnEditarUsuario;
	public JTable tblUsuario;
	public Usuario usuario;
	public JPanel panel;
	private FerramentasFormulario frmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUsuario frame = new frmUsuario();
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
	 */
	public frmUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 11, 317, 144);
		contentPane.add(panel);
		panel.setLayout(null);

		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(2, 0, 315, 40);
		panel.add(txtNomeUsuario);
		txtNomeUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNomeUsuario.setColumns(10);
		txtNomeUsuario.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "NOME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setBounds(0, 52, 165, 40);
		panel.add(txtLoginUsuario);
		txtLoginUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLoginUsuario.setColumns(10);
		txtLoginUsuario.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "LOGIN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		txtSenhaUsuario = new JPasswordField();
		txtSenhaUsuario.setBounds(179, 52, 138, 40);
		panel.add(txtSenhaUsuario);
		txtSenhaUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSenhaUsuario.setColumns(10);
		txtSenhaUsuario.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "SENHA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));

		cmbNivelAcesso = new JComboBox();
		cmbNivelAcesso.setBounds(2, 104, 315, 40);
		panel.add(cmbNivelAcesso);
		cmbNivelAcesso.setModel(new DefaultComboBoxModel(new String[] {"Selecione -", "Assistente - cod 2", "Dentista - cod 1", "Secretaria - cod 3"}));
		cmbNivelAcesso.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbNivelAcesso.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TIPO/USU\u00C1RIO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbNivelAcesso.setBackground(Color.WHITE);

		btnSalvarPaciente = new JButton("");
		btnSalvarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmt = new FerramentasFormulario();
				
				boolean valida1 = frmt.validaText(txtLoginUsuario, txtLoginUsuario, txtSenhaUsuario);
				boolean valida2 = frmt.validaCombo(cmbNivelAcesso);
				
				if(valida1 == true && valida2 == true) {
				usuario = new Usuario();
				usuario.setNomeUsuario(txtNomeUsuario.getText());
				usuario.setLogin(txtLoginUsuario.getText());
				usuario.setSenhaUsuario(Integer.parseInt(txtSenhaUsuario.getText()));
				usuario.setNivelAcessoUsusario(Integer.parseInt(cmbNivelAcesso.getSelectedItem().toString().replaceAll("[\\D]", "")));

				usuario.salvarUsuario(usuario, tblUsuario);
				
				txtLoginUsuario.setText(null);
				txtSenhaUsuario.setText(null);
				txtNomeUsuario.setText(null);
				cmbNivelAcesso.setSelectedIndex(0);
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}

			}
		});
		btnSalvarPaciente.setIcon(new ImageIcon(frmUsuario.class.getResource("/br/com/odontomais/view/save.png")));
		btnSalvarPaciente.setBorder(null);
		btnSalvarPaciente.setBackground(Color.WHITE);
		btnSalvarPaciente.setBounds(125, 330, 60, 60);
		contentPane.add(btnSalvarPaciente);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 167, 315, 151);
		contentPane.add(scrollPane);

		tblUsuario = new JTable();
		tblUsuario.addMouseListener(new MouseAdapter() {
			int cont = 0;
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cont++;

				if(cont == 2) {

					usuario = new Usuario();
					int linha = tblUsuario.getSelectedRow();

					if(tblUsuario.getSelectedRow() != -1) {	

						usuario.setCodUsuario((Integer)tblUsuario.getValueAt(linha, 0));
						int cod = usuario.getCodUsuario();
						usuario = usuario.buscaUsuario(cod);

						txtNomeUsuario.setText(usuario.getNomeUsuario());
						txtLoginUsuario.setText(usuario.getLogin());
						txtSenhaUsuario.setText(Integer.toString(usuario.getSenhaUsuario()));

						cont = 0;
					}
				}
			}
		});
		tblUsuario.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
						"", "Nome", "Login", "Tipo"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(15);
		tblUsuario.getColumnModel().getColumn(0).setMaxWidth(15);
		tblUsuario.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblUsuario.getColumnModel().getColumn(2).setPreferredWidth(50);
		tblUsuario.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPane.setViewportView(tblUsuario);

		btnExcluirUsuario = new JButton("");
		btnExcluirUsuario.setIcon(new ImageIcon(frmUsuario.class.getResource("/br/com/odontomais/view/delete-01.png")));
		btnExcluirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirUsuario.setBorder(null);
		btnExcluirUsuario.setBackground(Color.WHITE);
		btnExcluirUsuario.setBounds(269, 330, 60, 60);
		contentPane.add(btnExcluirUsuario);

		btnEditarUsuario = new JButton("");
		btnEditarUsuario.setIcon(new ImageIcon(frmUsuario.class.getResource("/br/com/odontomais/view/editi-01.png")));
		btnEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				usuario.setNomeUsuario(txtNomeUsuario.getText());
				usuario.setLogin(txtLoginUsuario.getText());
				usuario.setSenhaUsuario(Integer.parseInt(txtSenhaUsuario.getText()));
				usuario.setNivelAcessoUsusario(Integer.parseInt(cmbNivelAcesso.getSelectedItem().toString().replaceAll("[\\D]", "")));
				usuario.alteraUsuario(usuario, tblUsuario);
				
			}
		});
		btnEditarUsuario.setBorder(null);
		btnEditarUsuario.setBackground(Color.WHITE);
		btnEditarUsuario.setBounds(197, 330, 60, 60);
		contentPane.add(btnEditarUsuario);
	}
}
