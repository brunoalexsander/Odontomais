package br.com.odontomais.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FerramentasFormulario {

	public void limpaComponentes(JTextField... args) {

		for(JTextField componentes: args) {
			componentes.setText(null);
		}
	}

	public void habilitaComponentes(JTextField... args) {
		for(JTextField componentes: args) {
			componentes.setEnabled(true);
		}
	}

	public void habilitaComponentes(JComboBox... args) {
		for(JComboBox componentes: args) {
			componentes.setEnabled(true);
		}
	}

	public void habilitaComponentes(JRadioButton... args) {
		for(JRadioButton componentes: args) {
			componentes.setEnabled(true);
		}
	}

	public void habilitaComponentes(JButton... args) {
		for(JButton componentes: args) {
			componentes.setEnabled(true);
		}
	}


	public void desabilitaComponentes(JTextField... args) {
		for(JTextField componentes: args) {
			componentes.setEnabled(false);
		}
	}

	public void desabilitaComponentes(JComboBox... args) {
		for(JComboBox componentes: args) {
			componentes.setEnabled(false);
		}
	}

	public void desabilitaComponentes(JRadioButton... args) {
		for(JRadioButton componentes: args) {
			componentes.setEnabled(false);
		}
	}

	public void desabilitaComponentes(JButton... args) {
		for(JButton componentes: args) {
			componentes.setEnabled(false);
		}
	}

	public void resetCombo(JComboBox... args) {
		for(JComboBox componentes: args) {
			componentes.setSelectedIndex(0);
		}
	}

	public String removeMascara(String arg) {
		arg = arg.replaceAll("[\\D]", "");
		return arg;
	}

	/*public void limparTudoAluno() {

		limpaComponentes(frmAluno.txtNome, frmAluno.txtNascimento, frmAluno.txtCpf, frmAluno.txtEmail, frmAluno.txtEmail, frmAluno.txtCelular, frmAluno.txtTelefone);
		limpaComponentes(frmAluno.txtCep, frmAluno.txtEndereco, frmAluno.txtNumero, frmAluno.txtComplemento, frmAluno.txtBairro, frmAluno.txtCidade);
		resetCombo(frmAluno.cmbUF, frmAluno.cmbUnidade, frmAluno.cmbGenero, frmAluno.cmbCurso);
	}

	public void habilitaTudoAluno() {

		habilitaComponentes(frmAluno.txtRgm, frmAluno.txtNome, frmAluno.txtCpf, frmAluno.txtNascimento, frmAluno.txtEmail, frmAluno.txtCelular, frmAluno.txtTelefone); //Habilita os campos do panel Alunos
		habilitaComponentes(frmAluno.txtCep, frmAluno.txtEndereco, frmAluno.txtNumero, frmAluno.txtComplemento, frmAluno.txtBairro, frmAluno.txtCidade); //Habilita os campos do panel Endereço
		habilitaComponentes(frmAluno.cmbCurso, frmAluno.cmbUF, frmAluno.cmbUnidade);
		habilitaComponentes(frmAluno.cmbUF, frmAluno.cmbUnidade, frmAluno.cmbGenero, frmAluno.cmbCurso);
		habilitaComponentes(frmAluno.rdbMatutino, frmAluno.rdbNoturno, frmAluno.rdbVespertino);

	}

	public void desabilitaTudo() {
		desabilitaComponentes(frmAluno.txtRgm, frmAluno.txtNome, frmAluno.txtNascimento, frmAluno.txtCpf, frmAluno.txtEmail, frmAluno.txtCelular, frmAluno.txtTelefone); 
		desabilitaComponentes(frmAluno.txtCep, frmAluno.txtEndereco, frmAluno.txtNumero, frmAluno.txtComplemento, frmAluno.txtBairro, frmAluno.txtCidade); 
		desabilitaComponentes(frmAluno.cmbCurso, frmAluno.cmbUF, frmAluno.cmbUnidade);
		desabilitaComponentes(frmAluno.cmbUF, frmAluno.cmbUnidade, frmAluno.cmbGenero, frmAluno.cmbCurso);
		desabilitaComponentes(frmAluno.rdbMatutino, frmAluno.rdbNoturno, frmAluno.rdbVespertino);
	}*/

	public boolean validaCombo(JComboBox... comp) {

		boolean validador = false;
		
		for(JComboBox args : comp) {

			if (args.getSelectedIndex() == 0) {
				args.setBorder(new LineBorder(Color.RED));
				validador = false;
				break;
			}
			else {
				args.setBorder(new LineBorder(Color.DARK_GRAY));
				validador = true;
			}
		}
		return validador;
	}
	
	public boolean validaText(JTextField... comp) {

		boolean validador = false;
		String texto;
		for(JTextField args : comp) {
			texto = args.getText();
			if (texto.equals("")) {
				args.setBorder(new LineBorder(Color.RED));
				validador = false;
				break;
			}
			else {
				args.setBorder(new LineBorder(Color.DARK_GRAY));
				validador = true;
			}
		}
		return validador;
	}
}
