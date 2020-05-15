package br.com.odontomais.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import br.com.odontomais.dao.EnderecoDAO;
import jdk.nashorn.internal.runtime.ListAdapter;

public class Endereco {

	private int codEndereco;
	private int codPessoa;
	private String cep;
	private String endereco;
	private String bairro;
	private String complemento;
	private String numCasa;
	private String cidade;
	private String uf;

	
	public Endereco() {
		
	}
	
	public Endereco(int codEndereco, String cep, String endereco, String bairro, String complemento, String numCasa,
			String uf, String cidade) {

		this.codEndereco = codEndereco;
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numCasa = numCasa;
		this.uf = uf;
		this.cidade = cidade;
	}

	
	
	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	public int getCodEndereco() {
		return this.codEndereco;
	}

	public void setCodEndereco(int codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep.replaceAll("[\\D]", "");
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return this.numCasa;
	}

	public void setNumero(String numero) {
		this.numCasa = numero;
	}

	public String getUf() {
		return this.uf;
	}

	public int getUF(JComboBox<?> UF) {
		
		int index = 0;
		
		switch (this.uf) {
		case "AC":
			index = 1;
			break;
		case "AL":
			index = 2;
			break;
		case "AP":
			index = 3;
			break;
		case "AM":
			index = 4;
			break;
		case "BA":
			index = 5;
			break;
		case "CE":
			index = 6;
			break;
		case "ES":
			index = 7;
			break;
		case "DF":
			index = 8;
			break;
		case "GO":
			index = 9;
			break;
		case "MA":
			index = 10;
			break;
		case "MT":
			index = 11;
			break;
		case "MS":
			index = 12;
			break;
		case "MG":
			index = 13;
			break;
		case "PA":
			index = 14;
			break;
		case "PB":
			index = 15;
			break;
		case "PR":
			index = 16;
			break;
		case "PE":
			index = 17;
			break;
		case "PI":
			index = 18;
			break;
		case "RJ":
			index = 19;
			break;
		case "RN":
			index = 20;
			break;
		case "RS":
			index = 21;
			break;
		case "RO":
			index = 22;
			break;
		case "RR":
			index = 23;
			break;
		case "SC":
			index = 24;
			break;
		case "SP":
			index = 25;
			break;
		case "SE":
			index = 26;
			break;
		case "TO":
			index = 27;
			break;
		}
		
		return index;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	public List buscarUF(){

		List<String> listaUF = new ArrayList<String>();

		try {
			EnderecoDAO DAOendereco = new EnderecoDAO();			
			//listaUF = DAOendereco.listaUF();
		} 
		catch (Exception e) {
			System.out.println("erro ao listar" + e.getMessage());
		}
		return listaUF;	
	}
	
	public List buscarUF(JComboBox<String> cmbUF){

		List<String> listaUF = new ArrayList<String>();

		try {
			EnderecoDAO DAOendereco = new EnderecoDAO();			
			//listaUF = DAOendereco.listaUF();
			for(String uf: listaUF) {
				cmbUF.addItem(uf);
			}
		} 
		catch (Exception e) {
			System.out.println("erro ao listar" + e.getMessage());
		}
		return listaUF;	
	}
}
