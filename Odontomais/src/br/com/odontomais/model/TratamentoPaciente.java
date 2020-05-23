package br.com.odontomais.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
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

	public int getFormaPagamento(JComboBox combo) {

		int index = 0;
		String forma = this.formaPagamento;

		if(forma.equals("Cartão")) {
			index = 1;
		} else 
			if(forma.equals("Boleto")) {
				index = 2;
			}
		return index;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento, JComboBox combo) {

		this.formaPagamento = formaPagamento;

		if(formaPagamento == "Cartão") {
			combo.setSelectedIndex(1);
		} else 
			if(formaPagamento == "Boleto") {
				combo.setSelectedIndex(2);
			}
	}


	public int getParcelas() {
		return parcelas;
	}

	public int getParcelas(JComboBox combo) {

		int index = 0;
		int parcelas = this.parcelas;

		if(parcelas == 1) {
			index = 0;
		} else if(parcelas == 2) {
			index = 1;
		} else if(parcelas == 3) {
			index = 2;
		}

		return index;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public void setParcelas(int parcelas, JComboBox combo) {
		this.parcelas = parcelas;
		combo.setSelectedIndex(parcelas+1);
	}


	public void adicionarTratamentoPaciente(TratamentoPaciente tratamento, Paciente paciente, JTable tabelaTratamentos) {

		try {
			DAOTratamentoPaciente = new TratamentoPacienteDAO();
			DAOTratamentoPaciente.adicionarTratamentoPaciente(tratamento, paciente);

			JOptionPane.showMessageDialog(null, "Tratamento adicionado com sucesso");

			DefaultTableModel model = (DefaultTableModel) tabelaTratamentos.getModel();
			model.setRowCount(0);
			buscaTratamentosPaciente(paciente, tabelaTratamentos);

		} catch (Exception e) {}
	}

	public void buscaTratamentosPaciente(Paciente paciente, JTable tabelaTratamentos) {

		List<TratamentoPaciente> listaTratamentos = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) tabelaTratamentos.getModel();
		model.setRowCount(0);
		try {

			DAOTratamentoPaciente = new TratamentoPacienteDAO();
			listaTratamentos = DAOTratamentoPaciente.buscaTratamentosPaciente(paciente);

			for(TratamentoPaciente tratamento : listaTratamentos) {
				model.addRow(new Object[] {tratamento.getCodTratamentoPaciente(), tratamento.getNomeTratamento(), tratamento.getNumeroConsultas(), tratamento.getHorasConsulta(), 
						tratamento.getValorTramento(), tratamento.getFormaPagamento(), tratamento.getParcelas() });
			}
		} catch (Exception e) {}
	}

	public void alteraTratamentoPaciente(TratamentoPaciente tratamento, JTable tabelaTratamentos) {

		try {

			DAOTratamentoPaciente = new TratamentoPacienteDAO();
			DAOTratamentoPaciente.alteraTratamentoPaciente(tratamento);

			JOptionPane.showMessageDialog(null, "altarado com sucesso");

			DefaultTableModel model = (DefaultTableModel) tabelaTratamentos.getModel();
			model.setRowCount(0);
			buscaTratamentosPaciente(frmPaciente.paciente, tabelaTratamentos);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirTratamento(Paciente paciente, TratamentoPaciente tratamento, JTable tabelaTratamentos) {
		
		try {
			
			DAOTratamentoPaciente = new TratamentoPacienteDAO();
			DAOTratamentoPaciente.excluirTratamento(paciente, tratamento);
			
			JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			
			DefaultTableModel model = (DefaultTableModel) tabelaTratamentos.getModel();
			model.setRowCount(0);
			buscaTratamentosPaciente(frmPaciente.paciente, tabelaTratamentos);
			
		} catch (Exception e) {
			
		}
	}
}
