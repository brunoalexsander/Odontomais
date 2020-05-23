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
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Frame;
import javax.swing.JPasswordField;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	public JTextField txtLogin;
	public JPasswordField txtSenha;
	public JButton btnLogin;

	public Usuario usuario;
	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmLogin.class.getResource("/br/com/odontomais/view/logo.png")));
		setResizable(false);
		setTitle("Login");
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 208);
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
		txtLogin.setBounds(63, 12, 200, 40);
		contentPane.add(txtLogin);

		txtSenha = new JPasswordField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSenha.setColumns(10);
		txtSenha.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "SENHA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtSenha.setBounds(63, 63, 200, 40);
		contentPane.add(txtSenha);

		btnLogin = new JButton("LOGIN");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				usuario = new Usuario();
				usuario.setLogin(txtLogin.getText());

				try {
					usuario.setSenhaUsuario(Integer.parseInt(txtSenha.getText()));
					usuario.buscaUsuario(usuario);		

					if(usuario.getCodUsuario() != 0) {
						JOptionPane.showMessageDialog(null, "Seja Bem-vindo");
						frmPrincipal.lblUsuario.setText(usuario.getNomeUsuario());
						frmPrincipal.login.setVisible(false);
					}
					if(usuario.getNivelAcessoUsusario() > 2) {
						frmPrincipal.btnUsuario.setVisible(true);
					} else {
						frmPrincipal.btnUsuario.setVisible(false);
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Senha inválida");
					frmPrincipal.login.setVisible(true);
					txtSenha.setText(null);
				}
			}
		});
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setBounds(116, 115, 93, 51);
		contentPane.add(btnLogin);
	}
}
