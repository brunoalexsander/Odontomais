package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.odontomais.model.Paciente;
import br.com.odontomais.model.Tratamento;
import br.com.odontomais.model.TratamentoPaciente;
import br.com.odontomais.util.ConnectionFactory;

public class TratamentoPacienteDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private TratamentoDAO DAOtratamento;

	public TratamentoPacienteDAO() throws Exception {

		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}

	public void adicionarTratamentoPaciente(TratamentoPaciente tratamento, Paciente paciente) {

		int codTratamento = Integer.parseInt(tratamento.getNomeTratamento().replaceAll("[\\D]", ""));

		try {

			ps = conn.prepareStatement("INSERT INTO tratamentoPaciente (codTratamento, codPaciente, valorTratamento, consultasTratamento, horasConsultas, formaPagamento, parcelas)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, codTratamento);
			ps.setInt(2, paciente.getCodPaciente());
			ps.setDouble(3, tratamento.getValorTramento());
			ps.setInt(4, tratamento.getNumeroConsultas());
			ps.setInt(5, tratamento.getHorasConsulta());
			ps.setString(6, tratamento.getFormaPagamento());
			ps.setInt(7, tratamento.getParcelas());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {}
	}

	public List buscaTratamentosPaciente(Paciente paciente) {

		List<TratamentoPaciente> listaTratamentos = new ArrayList<>();

		try {

			DAOtratamento = new TratamentoDAO();

			ps = conn.prepareStatement("SELECT * FROM tratamentoPaciente WHERE codPaciente=?");
			ps.setInt(1, paciente.getCodPaciente());
			rs = ps.executeQuery();

			while(rs.next()) {
				TratamentoPaciente tratamento = new TratamentoPaciente();
				tratamento.setCodTratamentoPaciente(rs.getInt("codTratamentoPaciente"));
				tratamento.setNomeTratamento(DAOtratamento.nomeTratamento(rs.getInt("codTratamento")));
				tratamento.setNumeroConsultas(rs.getInt("consultasTratamento"));
				tratamento.setHorasConsulta(rs.getInt("horasConsultas"));
				tratamento.setValorTratamento(rs.getDouble("valorTratamento"));
				tratamento.setFormaPagamento(rs.getString("formaPagamento"));
				tratamento.setParcelas(rs.getInt("parcelas"));
				listaTratamentos.add(tratamento);
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaTratamentos;
	}

	public void alteraTratamentoPaciente(TratamentoPaciente tratamento) {

		try {

			ps = conn.prepareStatement("UPDATE tratamentoPaciente SET valorTratamento=?, consultasTratamento=?, horasConsultas=?, formaPagamento=?, parcelas=?"
					+ " WHERE codTratamentoPaciente=?");

			ps.setDouble(1, tratamento.getValorTramento());
			ps.setInt(2, tratamento.getNumeroConsultas());
			ps.setInt(3, tratamento.getHorasConsulta());
			ps.setString(4, tratamento.getFormaPagamento());
			ps.setInt(5, tratamento.getParcelas());
			ps.setInt(6, tratamento.getCodTratamentoPaciente());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
