package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odontomais.model.Paciente;
import br.com.odontomais.model.Tratamento;
import br.com.odontomais.model.TratamentoPaciente;
import br.com.odontomais.util.ConnectionFactory;

public class TratamentoPacienteDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TratamentoPacienteDAO() throws Exception {
		
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}
	
	public void adicionarTratamento(TratamentoPaciente tratamento, Paciente paciente) {
		
		int codTratamento = Integer.parseInt(tratamento.getNomeTratamento().replaceAll("[\\D]", ""));
		
		
		
		try {
			
			String sql = "INSERT INTO tratamentoPaciente (codTratamento, codPaciente, valorTratamento, consultasTratamento, horasConsultas, formaPagamento, parcelas) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codTratamento);
			ps.setInt(2, paciente.getCodPaciente());
			ps.setDouble(3, tratamento.getValorTramento());
			ps.setInt(4, tratamento.getNumeroConsultas());
			ps.setInt(5, tratamento.getHorasConsulta());
			ps.setString(6, tratamento.getFormaPagamento());
			ps.setInt(7, tratamento.getParcelas());
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
