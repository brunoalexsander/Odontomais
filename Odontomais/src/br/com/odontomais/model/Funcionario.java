package br.com.odontomais.model;

public class Funcionario {
	
	private int codPessoa;
	private int permissao;
	private String senha;
	
	public Funcionario() {
		
	}

	public Funcionario(int codPessoa, int permissao, String senha) {
		this.codPessoa = codPessoa;
		this.permissao = permissao;
		this.senha = senha;
	}

	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
