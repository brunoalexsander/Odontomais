package br.com.odontomais.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JDesktopPane;

public class frmPrincipal extends JFrame {
	public JMenuBar menuBar;
	public JMenu mnNewMenu;
	public JMenu mnNewMenu_1;
	public static frmLogin login;

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
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setResizable(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmPrincipal.class.getResource("/br/com/odontomais/view/logo.png")));
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Paciente");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				try {
					frmPaciente paciente = new frmPaciente();
					paciente.setVisible(true);
					paciente.setLocationRelativeTo(null);
				} catch (ParseException e) {}
			}
		});
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		mnNewMenu_1 = new JMenu("Usu\u00E1rios");
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
	}
}
