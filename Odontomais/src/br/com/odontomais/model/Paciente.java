package br.com.odontomais.model;

public class Paciente extends Pessoa{
	
	private int codPessoa;
	private String nomeConvenio;
	private String cartaoConvenio;
	private String validadeCartaoConvenio;
	private String titular;
	
	public Paciente() {
		
	}
	
	public Paciente(int codPessoa, String convenio, String cartaoConvenio, String titular) {
		super();
		this.nomeConvenio = convenio;
		this.cartaoConvenio = cartaoConvenio;
		this.titular = titular;
	}

	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getConvenio() {
		return nomeConvenio;
	}

	public void setConvenio(String convenio) {
		this.nomeConvenio = convenio;
	}

	public String getCartaoConvenio() {
		return cartaoConvenio;
	}

	public String getValidadeCartaoConvenio() {
		return validadeCartaoConvenio;
	}

	public void setValidadeCartaoConvenio(String validadeCartaoConvenio) {
		this.validadeCartaoConvenio = validadeCartaoConvenio;
	}

	public void setCartaoConvenio(String cartaoConvenio) {
		this.cartaoConvenio = cartaoConvenio;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
