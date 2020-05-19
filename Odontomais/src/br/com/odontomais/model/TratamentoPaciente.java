package br.com.odontomais.model;

import br.com.odontomais.dao.TratamentoPacienteDAO;

public class TratamentoPaciente extends Tratamento{
	
	private int horasConsulta;
	private String formaPagamento;
	private int parcelas;
	private TratamentoPacienteDAO DAOTratamentoPaciente;
	
	public int getHorasConsulta() {
		return horasConsulta;
	}
	public void setHorasConsulta(int horasConsulta) {
		this.horasConsulta = horasConsulta;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	
	
	public void adicionarTratamento(TratamentoPaciente tratamento, Paciente paciente) {
		
		try {
			DAOTratamentoPaciente = new TratamentoPacienteDAO();
			DAOTratamentoPaciente.adicionarTratamento(tratamento, paciente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
