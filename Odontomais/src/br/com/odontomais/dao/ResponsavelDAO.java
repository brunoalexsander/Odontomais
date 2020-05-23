package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.odontomais.model.Paciente;
import br.com.odontomais.model.Pessoa;
import br.com.odontomais.model.Responsavel;
import br.com.odontomais.util.ConnectionFactory;

public class ResponsavelDAO {

	private Pessoa pessoa;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public ResponsavelDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}

	public void salvarResponsavel(Pessoa responsavel, Paciente paciente) {

		try {

			String sql = "INSERT INTO responsavelpaciente (codPessoa, codPaciente) VALUES (?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, responsavel.getCodPessoa());
			ps.setInt(2, paciente.getCodPaciente());
			ps.executeUpdate();
			ps.close();		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pessoa consultarResponsavel(Responsavel responsavel) {
			
		try {
			ps = conn.prepareStatement("SELECT * FROM responsavelpaciente WHERE codPaciente=?");
			ps.setInt(1, responsavel.getCodPaciente());
			rs = ps.executeQuery(); 
			if(rs.next()) {
				responsavel.setCodPessoa(rs.getInt("codPessoa"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return responsavel;
	}

}