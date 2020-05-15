package Prototipo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.TitledBorder;
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

public class frmTratamento extends JFrame {

	private JPanel contentPane;
	public JTextField cmbPacienteConvenio;
	public JFormattedTextField txtPacienteRG;
	public JComboBox cmbPacienteConvenio_1;
	public JButton btnPacienteSalvar;
	public JButton btnPacienteConsultar;
	public JButton btnPacienteAlterar;
	public JButton btnPacienteExcluir;
	public JComboBox cmbPacienteConvenio_2;
	public JFormattedTextField txtPacienteRG_1;
	public JComboBox cmbPacienteConvenio_3;

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
		setTitle("Adicionar Tratamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmbPacienteConvenio = new JTextField();
		cmbPacienteConvenio.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteConvenio.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "TRATAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteConvenio.setBackground(Color.WHITE);
		cmbPacienteConvenio.setBounds(12, 11, 400, 40);
		contentPane.add(cmbPacienteConvenio);
		
		txtPacienteRG = new JFormattedTextField((AbstractFormatter) null);
		txtPacienteRG.setText("");
		txtPacienteRG.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteRG.setColumns(10);
		txtPacienteRG.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "VALOR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteRG.setBounds(12, 63, 200, 40);
		contentPane.add(txtPacienteRG);
		
		cmbPacienteConvenio_1 = new JComboBox();
		cmbPacienteConvenio_1.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbPacienteConvenio_1.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteConvenio_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "FORMA/PAGAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteConvenio_1.setBackground(Color.WHITE);
		cmbPacienteConvenio_1.setBounds(12, 113, 291, 40);
		contentPane.add(cmbPacienteConvenio_1);
		
		btnPacienteSalvar = new JButton("");
		btnPacienteSalvar.setIcon(new ImageIcon(frmTratamento.class.getResource("/Prototipo/plus-02.png")));
		btnPacienteSalvar.setBorder(null);
		btnPacienteSalvar.setBackground(new Color(255, 255, 255));
		btnPacienteSalvar.setBounds(196, 217, 45, 45);
		contentPane.add(btnPacienteSalvar);
		
		btnPacienteConsultar = new JButton("");
		btnPacienteConsultar.setIcon(new ImageIcon(frmTratamento.class.getResource("/Prototipo/editi-02.png")));
		btnPacienteConsultar.setBorder(null);
		btnPacienteConsultar.setBackground(new Color(255, 255, 255));
		btnPacienteConsultar.setBounds(253, 217, 45, 45);
		contentPane.add(btnPacienteConsultar);
		
		btnPacienteAlterar = new JButton("");
		btnPacienteAlterar.setIcon(new ImageIcon(frmTratamento.class.getResource("/Prototipo/delete-02.png")));
		btnPacienteAlterar.setBorder(null);
		btnPacienteAlterar.setBackground(new Color(255, 255, 255));
		btnPacienteAlterar.setBounds(310, 217, 45, 45);
		contentPane.add(btnPacienteAlterar);
		
		btnPacienteExcluir = new JButton("");
		btnPacienteExcluir.setIcon(new ImageIcon(frmTratamento.class.getResource("/Prototipo/cancel-02.png")));
		btnPacienteExcluir.setBorder(null);
		btnPacienteExcluir.setBackground(new Color(255, 255, 255));
		btnPacienteExcluir.setBounds(367, 217, 45, 45);
		contentPane.add(btnPacienteExcluir);
		
		cmbPacienteConvenio_2 = new JComboBox();
		cmbPacienteConvenio_2.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbPacienteConvenio_2.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteConvenio_2.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "M\u00C9DICO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteConvenio_2.setBackground(Color.WHITE);
		cmbPacienteConvenio_2.setBounds(12, 165, 291, 40);
		contentPane.add(cmbPacienteConvenio_2);
		
		txtPacienteRG_1 = new JFormattedTextField();
		txtPacienteRG_1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPacienteRG_1.setText("1");
		txtPacienteRG_1.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPacienteRG_1.setColumns(10);
		txtPacienteRG_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "N\u00BA CONSULTAS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		txtPacienteRG_1.setBounds(315, 166, 97, 40);
		contentPane.add(txtPacienteRG_1);
		
		cmbPacienteConvenio_3 = new JComboBox();
		cmbPacienteConvenio_3.setModel(new DefaultComboBoxModel(new String[] {"1"}));
		cmbPacienteConvenio_3.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbPacienteConvenio_3.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "PARCELAS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		cmbPacienteConvenio_3.setBackground(Color.WHITE);
		cmbPacienteConvenio_3.setBounds(315, 113, 97, 40);
		contentPane.add(cmbPacienteConvenio_3);
	}
}
