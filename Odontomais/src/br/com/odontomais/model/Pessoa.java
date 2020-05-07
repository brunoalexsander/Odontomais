package br.com.odontomais.model;

import java.sql.Date;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private String rg;
	private Date nascimento;
	private String genero;
	private String email;
	private String telefone;
	private String celular;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf, String rg, Date nascimento, String genero, String email, String telefone, String celular) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.nascimento = nascimento;
		this.genero = genero;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}