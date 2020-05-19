package br.com.odontomais.model;

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

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void consultarPaciente(Paciente paciente) {
		
		try {
			
			consultarPessoa(paciente);
			
			DAOpaciente = new PacienteDAO();
			DAOpaciente.consultarPaciente(paciente);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
