package br.com.odontomais.model;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.odontomais.dao.PacienteDAO;
import br.com.odontomais.dao.ResponsavelDAO;

public class Paciente extends Pessoa{

	private int codPaciente;
	private String nomeConvenio;
	private String cartaoConvenio;
	private String validadeCartaoConvenio;
	private String titularConvenio;
	private PacienteDAO DAOpaciente;
	private ResponsavelDAO DAOResponsavel;

	public Paciente() {

	}

	public Paciente(int codPessoa, String convenio, String cartaoConvenio, String titular) {
		super();
		this.nomeConvenio = convenio;
		this.cartaoConvenio = cartaoConvenio;
		this.titularConvenio = titular;
	}

	public int getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}

	public String getNomeConvenio() {
		return nomeConvenio;
	}
	
	public int getNomeConvenio(JComboBox combo) {
		
		int index = 0;
		
		if(nomeConvenio.equals("Porto Seguro")) {
			index = 1;
		}else {
			index = 2;
		}
		
		return index;
	}

	public void setNomeConvenio(String convenio) {
		this.nomeConvenio = convenio;
	}

	public String getCartaoConvenio() {
		return cartaoConvenio;
	}

	public String getValidadeCartaoConvenio() {
		return validadeCartaoConvenio;
	}

	public void setValidadeCartaoConvenio(String validadeCartaoConvenio) {
		this.validadeCartaoConvenio = validadeCartaoConvenio.replaceAll("/", "");
	}

	public void setCartaoConvenio(String cartaoConvenio) {
		this.cartaoConvenio = cartaoConvenio;
	}

	public String getTitularConvenio() {
		return titularConvenio;
	}

	public void setTitularConvenio(String titularConvenio) {
		this.titularConvenio = titularConvenio;
	}

	/*SALVAR PACIENTE*/
	public void salvarPaciente(Paciente paciente) {

		try {

			salvarPessoa(paciente);

			DAOpaciente = new PacienteDAO();
			DAOpaciente.salvarPaciente(paciente);

			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");

		} catch (Exception e) {}
	}

	/*CONSULTAR PACIENTE*/
	public void consultarPaciente(Paciente paciente) {

		try {
			consultarPessoa(paciente);
			DAOpaciente = new PacienteDAO();
			DAOpaciente.consultarPaciente(paciente);
			
			if(paciente.getNome() == null) {
				paciente.setCpf(null);
			}

		} catch (Exception e) {}
	}

	/*ALTERAR PACIENTE*/
	public void alterarPaciente(Paciente paciente) {
		try {
			
			DAOpaciente = new PacienteDAO();
			DAOpaciente.alterarPaciente(paciente);
			alterarPessoa(paciente);
			
			JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
		} catch (Exception e) {}
	}
	
	public void alterarPaciente(Paciente paciente, Responsavel responsavel) {
		try {
			
			DAOpaciente = new PacienteDAO();
			DAOpaciente.alterarPaciente(paciente);
			alterarPessoa(paciente);
			alterarPessoa(responsavel);
			
			JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
			
		} catch (Exception e) {}
	}
	
	public void excluirPaciente(Paciente paciente) {
		try {
			DAOpaciente = new PacienteDAO();
			DAOpaciente.excluirPaciente(paciente);
			
			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
			
		} catch (Exception e) {e.printStackTrace();}
	}
}
