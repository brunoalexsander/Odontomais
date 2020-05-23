package br.com.odontomais.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.odontomais.model.Usuario;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.Cursor;
import javax.swing.JLabel;
 
public class frmPrincipal extends JFrame {
	public JMenuBar menuBar;
	public static JMenu btnPaciente;
	public static JMenu btnUsuario;
	public static frmLogin login;
	public static int nivel;
	public JMenu btnSair;
	public static JLabel lblUsuario;
	protected static Object frame;
	public JLabel lblUsurio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frmPrincipal frame = new frmPrincipal();
					frame.setVisible(true);

					login = new frmLogin();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
					
				} catch (Exception e) {}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		setTitle("Odonto Mais");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("");
		lblUsuario.setBounds(64, 11, 211, 26);
		getContentPane().add(lblUsuario);
		
		lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(10, 11, 55, 26);
		getContentPane().add(lblUsurio);
		setBackground(new Color(255, 255, 255));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setResizable(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmPrincipal.class.getResource("/br/com/odontomais/view/logo.png")));
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		btnPaciente = new JMenu("Paciente");
		btnPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				
				nivel = login.usuario.getNivelAcessoUsusario();
				
				try {
					frmPaciente paciente = new frmPaciente();
					paciente.setVisible(true);
					paciente.setLocationRelativeTo(null);
					paciente.tbpPaciente.removeTabAt(2);
					paciente.tbpPaciente.removeTabAt(1);
					
					if(nivel == 1 || nivel == 2) {
						paciente.btnSalvarPaciente.setVisible(false);
					} else {
						paciente.btnSalvarPaciente.setVisible(true);
					}
				} catch (ParseException e) {}
			}
		});
		btnPaciente.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(btnPaciente);

		btnUsuario = new JMenu("Usu\u00E1rios");
		btnUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuario.setVisible(false);
		btnUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmUsuario user = new frmUsuario();
				user.setVisible(true);
				user.setLocationRelativeTo(null);
				user.usuario = new Usuario();
				user.usuario.listarUsuarios(user.tblUsuario);
			}
		});
		btnUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(btnUsuario);
		
		btnSair = new JMenu("Sair");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
				login = new frmLogin();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
			}
		});
		btnSair.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(btnSair);
	}
}
