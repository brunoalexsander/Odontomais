package br.com.odontomais.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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

	public boolean validaCombo(JComboBox... comp) {

		boolean validador = false;
		
		for(JComboBox args : comp) {

			if (args.getSelectedIndex() == 0) {
				validador = false;
				break;
			}
			else {
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
				validador = false;
				break;
			}
			else {
				validador = true;
			}
		}
		return validador;
	}
}
