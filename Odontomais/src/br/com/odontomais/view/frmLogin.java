package br.com.odontomais.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.odontomais.model.Usuario;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	public JTextField txtLogin;
	public JTextField txtSenha;
	public JButton btnLogin;

	private Usuario usuario;
	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setResizable(false);
		setTitle("Login");
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLogin.setColumns(10);
		txtLogin.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "USU\u00C1RIO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtLogin.setBounds(63, 93, 200, 40);
		contentPane.add(txtLogin);
		
		txtSenha = new JTextField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSenha.setColumns(10);
		txtSenha.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "SENHA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtSenha.setBounds(63, 144, 200, 40);
		contentPane.add(txtSenha);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usuario = new Usuario();
				usuario.setLogin(txtLogin.getText());
				
				try {
					usuario.setSenhaUsuario(Integer.parseInt(txtSenha.getText()));
					usuario.buscaUsuario(usuario);
					frmPrincipal.login.setVisible(false);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Senha inválida");
					txtSenha.setText(null);
				}
			}
		});
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(133, 196, 60, 60);
		contentPane.add(btnLogin);
	}
}
