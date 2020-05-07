package br.com.odontomais.model;

public class Endereco {
	
	private String endereco;
	private String complemento;
	private String uf;
	private String cep;
	private String municipio;
	private int codPessoa;
	
	public Endereco() {
		
	}

	public Endereco(String endereco, String complemento, String uf, String cep, String municipio, int codPessoa) {
		this.endereco = endereco;
		this.complemento = complemento;
		this.uf = uf;
		this.cep = cep;
		this.municipio = municipio;
		this.codPessoa = codPessoa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}
}
