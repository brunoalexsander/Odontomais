package br.com.odontomais.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.odontomais.dao.AutenticadorDAO;
import br.com.odontomais.model.Funcionario;

public class Autenticador extends JFrame {
	
	private JFrame autenticador;
	private JLabel lblFavicon;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblSenha;
	private JButton btnEntrar;
	private JButton btnSair;
	private JButton btnLimpar;
	private JLabel lblWelcome;
	private JPasswordField txtSenha;
	private Funcionario funcionario;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autenticador autenticador = new Autenticador();
					autenticador.autenticador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Autenticador() {
		autenticador = new JFrame();
		autenticador.setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo.png"));
		autenticador.setResizable(false);
		autenticador.setTitle("Odontomais");
		autenticador.setSize(800, 500);
		autenticador.setLocationRelativeTo(null);
		autenticador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		autenticador.getContentPane().setLayout(null);
		
		lblFavicon = new JLabel("");
		lblFavicon.setIcon(new ImageIcon("images/logo.png"));
		lblFavicon.setBounds(352, 57, 95, 100);
		autenticador.getContentPane().add(lblFavicon);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 18));
		lblEmail.setBounds(150, 213, 62, 30);
		autenticador.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrar();
			}
		});
		txtEmail.setFont(new Font("Arial", Font.BOLD, 18));
		txtEmail.setBounds(150, 243, 493, 30);
		autenticador.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 18));
		lblSenha.setBounds(150, 284, 62, 30);
		autenticador.getContentPane().add(lblSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrar();
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEntrar.setBounds(150, 367, 150, 45);
		autenticador.getContentPane().add(btnEntrar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Arial", Font.BOLD, 18));
		btnSair.setBounds(493, 367, 150, 45);
		autenticador.getContentPane().add(btnSair);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText(null);
				txtSenha.setText(null);
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 18));
		btnLimpar.setBounds(322, 367, 150, 45);
		autenticador.getContentPane().add(btnLimpar);
		
		lblWelcome = new JLabel("ACESSE SUA CONTA");
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));
		lblWelcome.setBounds(309, 168, 186, 30);
		autenticador.getContentPane().add(lblWelcome);
		
		txtSenha = new JPasswordField();
		txtSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrar();
			}
		});
		txtSenha.setFont(new Font("Arial", Font.BOLD, 18));
		txtSenha.setBounds(150, 313, 493, 30);
		autenticador.getContentPane().add(txtSenha);
	}
	
	public void entrar() {
		try {
			AutenticadorDAO dao = new AutenticadorDAO();
			funcionario = dao.permissao(txtEmail.getText(), txtSenha.getText());
			if (dao.autenticar(txtEmail.getText(), txtSenha.getText())) {
				txtSenha.setText(null);
				Principal principal = new Principal(autenticador, true, funcionario.getPermissao());
				autenticador.setVisible(false);
				principal.setVisible(true);
				autenticador.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos!");
			}
		} catch (Exception event) {
			JOptionPane.showMessageDialog(null, event.getMessage());
		}
	}
}