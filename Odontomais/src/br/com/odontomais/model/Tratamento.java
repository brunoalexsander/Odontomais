package br.com.odontomais.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import br.com.odontomais.dao.TratamentoDAO;

public class Tratamento {

	private String nomeTratamento;
	private double ValorTratamento;
	private int NumeroConsultas;
	private TratamentoDAO DAOtratamento;

	public String getNomeTratamento() {
		return nomeTratamento;
	}

	public void setNomeTratamento(String nomeTratamento) {
		this.nomeTratamento = nomeTratamento;
	}

	public double getValorTramento() {
		return ValorTratamento;
	}

	public void setValorTratamento(double valorTratamento){
		ValorTratamento = valorTratamento;
	}

	public boolean setValorTratamento(String valorTratamento){

		boolean valida = false;
		double valor = 0.0;
		String valorDigitado = valorTratamento.replace(".", "").replace(",", ".");

		try {
			valor = Double.parseDouble(valorDigitado);
			valida = true;

		} catch (Exception e) {
			valida = false;
		}

		ValorTratamento = valor;
		
		return valida;
	}

	public int getNumeroConsultas() {
		return NumeroConsultas;
	}

	public void setNumeroConsultas(int numeroConsultas) {
		NumeroConsultas = numeroConsultas;
	}


	public void cadastraTratamento(Tratamento tratamento) {
		
		try {
			
			DAOtratamento = new TratamentoDAO();
			DAOtratamento.cadastrarTratamento(tratamento);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List nomesTratamentos(JComboBox<String> cmbTratamenos){

		List<String> listaTratamentos = new ArrayList<String>();

		try {

			DAOtratamento = new TratamentoDAO();	
			listaTratamentos = DAOtratamento.getTratamentos();

			for(String curso: listaTratamentos) {
				cmbTratamenos.addItem(curso);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	

		return listaTratamentos;
	}
	
}
