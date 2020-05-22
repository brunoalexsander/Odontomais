package br.com.odontomais.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

import br.com.odontomais.dao.EnderecoDAO;
import br.com.odontomais.dao.PessoaDAO;

public class Pessoa extends Endereco{

	/*ATRIBUTOS*/
	/*------------------------------------*/

	private int codPessoa;
	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String genero;
	private String email;
	private String celular;
	private String telefone;
	private PessoaDAO DAOpessoa;
	private EnderecoDAO DAOendereco;


	/*CONSTRUTORES*/
	/*------------------------------------*/

	public Pessoa() {

	}

	public Pessoa(String nome, String cpf, String dataNascimento, String genero, String email,
			String celular, String telefone) {

		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.email = email;
		this.celular = celular;
		this.telefone = telefone;
	}

	/*GETTERS & SETTERS*/
	/*------------------------------------*/

	public int getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[\\D]", "");
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg.replaceAll("[\\D]", "");
	}

	public String getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {			
		this.dataNascimento = dataNascimento.replaceAll("[\\D]", "");
	}

	public String getGenero() {
		return this.genero;
	}

	public int getGenero(JComboBox<?> ComboGenero) {
		int index = 0;

		if(this.genero == "M") {
			index = 0;
		} else {
			index = 1;
		}

		ComboGenero.setSelectedIndex(index);

		return index; 

	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setGenero(JComboBox<?> genero) {

		switch (genero.getSelectedIndex()) {
		case 1: this.genero = "M";
		break;
		case 2: this.genero = "F";
		break;
		}
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;		
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) { 
		this.celular = celular.replaceAll("[\\D]", "");
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone.replaceAll("[\\D]", "");
	}


	public static boolean verificaMaiorIdade(String dataNasc){

		boolean maiorIdade = false;

		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date dataNascInput = null;

		try {

			dataNascInput = sdf.parse(dataNasc);

		} catch (Exception e) {}

		Calendar dateOfBirth = new GregorianCalendar(); //DATA DE ANIVERSÁRIO

		Calendar dataAtual = new GregorianCalendar();

		dateOfBirth.setTime(dataNascInput);

		int idade = dataAtual.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, idade);

		if (idade > 18) {
			maiorIdade = true;
		} else if(idade < 18) {
			maiorIdade = false;
		} else if (idade == 18) {
			
			int mes =  (dateOfBirth.get(Calendar.MONTH)) - dataAtual.get(Calendar.MONTH);

			if(mes > 0) {
				maiorIdade = true;		
			} else if(mes < 0) {
				maiorIdade = false;
			} else if(mes == 0) {
				
				int dia = dataAtual.get(Calendar.DAY_OF_MONTH) - dateOfBirth.get(Calendar.DAY_OF_MONTH);
				
				if(dia > 0 || dia == 0) {
					maiorIdade = true;
				}else {
					maiorIdade = false;
				}
			}
		}

		return maiorIdade;
	}

	/*MÉTODOS DA CLASSE*/
	/*------------------------------------*/

	protected void salvarPessoa(Pessoa pessoa) throws Exception {

		DAOpessoa = new PessoaDAO();
		DAOpessoa.salvarPessoa(pessoa);

		DAOendereco = new EnderecoDAO();
		DAOendereco.salvarEndereco(pessoa);
	}

	protected void consultarPessoa(Pessoa pessoa) throws Exception {

		DAOpessoa = new PessoaDAO();
		DAOpessoa.consultarPessoa(pessoa);

		DAOendereco = new EnderecoDAO();
		DAOendereco.consultarEndereco(pessoa);
	}

	protected void alterarPessoa(Pessoa pessoa) throws Exception{

		DAOpessoa = new PessoaDAO();
		DAOpessoa.alterarPessoa(pessoa);
		
		DAOendereco = new EnderecoDAO();
		DAOendereco.alterarEndereco(pessoa);

	}

	/*protected void excluirCadastrato() throws Exception{

		DAOpessoa = new PessoaDAO();
		DAOpessoa.excluirCadastro(frmAluno.aluno.getCodPessoa());

		DAOendereco = new EnderecoDAO();
		DAOendereco.excluirEndereco(frmAluno.aluno.getCodEndereco());

	}*/
}
