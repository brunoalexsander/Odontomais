package br.com.odontomais.model;

import br.com.odontomais.dao.ResponsavelDAO;

public class Responsavel extends Pessoa{
	
	private int codPaciente;
	private int codResponsavel;
	private ResponsavelDAO DAOResponsavel;
	
	public int getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}
	public int getCodResponsavel() {
		return codResponsavel;
	}
	public void setCodResponsavel(int codResponsavel) {
		this.codResponsavel = codResponsavel;
	}
	
	public void salvarResponsavel(Pessoa responsavel, Paciente paciente) {
		
		try {
			
			salvarPessoa(responsavel);
			
			DAOResponsavel = new ResponsavelDAO();
			DAOResponsavel.salvarResponsavel(responsavel, paciente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void consultarResponsavel(Responsavel responsavel) {
		
		try {
			
			DAOResponsavel = new ResponsavelDAO();
			DAOResponsavel.consultarResponsavel(responsavel);
			
			consultarPessoa(responsavel);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
