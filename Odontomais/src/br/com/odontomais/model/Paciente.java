package br.com.odontomais.model;

public class Paciente {
	
	private int codPessoa;
	private String codConvenio;
	
	public Paciente() {
		
	}

	public Paciente(int codPessoa, String codConvenio) {
		this.codPessoa = codPessoa;
		this.codConvenio = codConvenio;
	}

	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getCodConvenio() {
		return codConvenio;
	}

	public void setCodConvenio(String codConvenio) {
		this.codConvenio = codConvenio;
	}
}
