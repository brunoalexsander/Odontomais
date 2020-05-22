package br.com.odontomais.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.webkit.ContextMenu.ShowContext;

import br.com.odontomais.dao.ProntuarioDAO;
import br.com.odontomais.dao.TratamentoPacienteDAO;

public class Prontuario {

	private int codAnotacao;
	private String nomeMedico;
	private String dataAnotacao;
	private String anotacao;
	private int codPaciente;
	private ProntuarioDAO DAOProntuario;
	private Prontuario prontuario;

	public Prontuario(){

	}

	public Prontuario(Paciente paciente){
		int cod = paciente.getCodPaciente();
		this.codPaciente = cod;
	}

	public int getCodAnotacao() {
		return codAnotacao;
	}
	public void setCodAnotacao(int codAnotacao) {
		this.codAnotacao = codAnotacao;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public String getDataAnotacao() {
		return dataAnotacao;
	}
	public void setDataAnotacao(String dataAnotacao) {
		this.dataAnotacao = dataAnotacao;
	}
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
	public int getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}

	public void salvarAnotacaoProntuario(Prontuario prontuario) {

		try {
			DAOProntuario = new ProntuarioDAO();
			DAOProntuario.salvarAnotacaoProntuario(prontuario);

			JOptionPane.showMessageDialog(null, "Anotação Salva com Sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void buscarProntuarioPaciente(Paciente paciente, JTable tabelaAnotacoes) {

		List<Prontuario> listaAnotacoes = new ArrayList<>();

		try {

			DAOProntuario = new ProntuarioDAO();
			listaAnotacoes = DAOProntuario.buscaProntuarioPaciente(paciente);
			DefaultTableModel model = (DefaultTableModel) tabelaAnotacoes.getModel();

			for(Prontuario prontuario : listaAnotacoes) {

				String texto = "Dentista: " + prontuario.getNomeMedico() + "<br>" + "Data: " + prontuario.getDataAnotacao() + "<br>" + "Anotação: " + prontuario.getAnotacao();

				StringBuilder str = new StringBuilder();
				str.append("<html>"); 
				str.append(texto);
				str.append("</html>");
				str.toString();

				model.addRow(new Object[] {str, prontuario.getCodAnotacao()});
			}

		} catch (Exception e) {}
	}

	public Prontuario buscarAnotacaoPaciente(int cod) {

		prontuario = new Prontuario();

		try {
			DAOProntuario = new ProntuarioDAO();
			prontuario = DAOProntuario.buscaAnotacaoPaciente(cod);

		} catch (Exception e) {}

		return prontuario;
	}

	public void alterarAnotacao(Prontuario prontuario) {

		try {
			
			DAOProntuario = new ProntuarioDAO();
			DAOProntuario.alterarAnotacao(prontuario);
			
			JOptionPane.showMessageDialog(null, "Alterado com Sucesso");

		} catch (Exception e) {}
	}
}