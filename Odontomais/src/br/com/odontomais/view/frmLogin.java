package br.com.odontomais.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JLabel label;
	public JButton btnCancelar;
	public JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setTitle("Login");
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 324);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "USU\u00C1RIO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField.setBounds(75, 120, 300, 40);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "SENHA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		textField_1.setBounds(75, 171, 300, 40);
		contentPane.add(textField_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(frmLogin.class.getResource("/Prototipo/logo.png")));
		label.setBounds(175, 11, 100, 109);
		contentPane.add(label);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(315, 214, 60, 60);
		contentPane.add(btnCancelar);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(245, 214, 60, 60);
		contentPane.add(btnLogin);
	}
}
