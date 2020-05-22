package br.com.odontomais.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.odontomais.dao.TratamentoPacienteDAO;
import br.com.odontomais.view.frmPaciente;

public class TratamentoPaciente extends Tratamento{

	private int codTratamentoPaciente;
	private int horasConsulta;
	private String formaPagamento;
	private int parcelas;
	private TratamentoPacienteDAO DAOTratamentoPaciente;

	public int getCodTratamentoPaciente() {
		return codTratamentoPaciente;
	}
	public void setCodTratamentoPaciente(int codTratamentoPaciente) {
		this.codTratamentoPaciente = codTratamentoPaciente;
	}
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


	public void adicionarTratamentoPaciente(TratamentoPaciente tratamento, Paciente paciente) {

		try {
			DAOTratamentoPaciente = new TratamentoPacienteDAO();
			DAOTratamentoPaciente.adicionarTratamentoPaciente(tratamento, paciente);

			JOptionPane.showMessageDialog(null, "Tratamento adicionado com sucesso");

		} catch (Exception e) {}
	}

	public void buscaTratamentosPaciente(Paciente paciente, JTable tabelaTratamentos) {

		List<TratamentoPaciente> listaTratamentos = new ArrayList<>();

		try {

			DAOTratamentoPaciente = new TratamentoPacienteDAO();
			listaTratamentos = DAOTratamentoPaciente.buscaTratamentosPaciente(paciente);

			DefaultTableModel model = (DefaultTableModel) tabelaTratamentos.getModel();

			for(TratamentoPaciente tratamento : listaTratamentos) {
				model.addRow(new Object[] {tratamento.getCodTratamentoPaciente(), tratamento.getNomeTratamento(), tratamento.getNumeroConsultas(), tratamento.getHorasConsulta(), 
						tratamento.getValorTramento(), tratamento.getFormaPagamento(), tratamento.getParcelas() });
			}
		} catch (Exception e) {}
	}

	public void alteraTratamentoPaciente(TratamentoPaciente tratamento) {

		try {

			DAOTratamentoPaciente = new TratamentoPacienteDAO();
			DAOTratamentoPaciente.alteraTratamentoPaciente(tratamento);

			JOptionPane.showMessageDialog(null, "altarado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
