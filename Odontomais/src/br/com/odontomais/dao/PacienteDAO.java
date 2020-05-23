package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.sun.prism.paint.Stop;

import br.com.odontomais.model.Paciente;
import br.com.odontomais.util.ConnectionFactory;

public class PacienteDAO extends PessoaDAO{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;	

	public PacienteDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}

	public void salvarPaciente(Paciente paciente) {

		try {

			String sql = "INSERT INTO paciente (nomeConvenio, valCartaoConvenio, titularConvenio, codpessoa, ncartao) VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, paciente.getNomeConvenio());
			ps.setString(2, paciente.getValidadeCartaoConvenio());
			ps.setString(3, paciente.getTitularConvenio());
			ps.setInt(4, paciente.getCodPessoa());
			ps.setString(5, paciente.getCartaoConvenio());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();  
			rs.next();
			paciente.setCodPaciente(rs.getInt(1)); 

			ps.close();

		} catch (Exception e) {}
	}

	public void consultarPaciente(Paciente paciente) {

		try {
			ps = conn.prepareStatement("SELECT * FROM paciente WHERE codPessoa=?");
			ps.setInt(1, paciente.getCodPessoa());
			rs = ps.executeQuery(); 
			if(rs.next()) {
				paciente.setCodPaciente(rs.getInt("codPaciente"));
				paciente.setNomeConvenio(rs.getString("nomeconvenio"));
				paciente.setValidadeCartaoConvenio(rs.getString("valCartaoConvenio"));
				paciente.setTitularConvenio(rs.getString("titularConvenio"));
				paciente.setCartaoConvenio(rs.getString("ncartao"));
			} else {
				JOptionPane.showMessageDialog(null, "Paciente não encontrado");
			}
		} catch (Exception e) {}
	}

	public void alterarPaciente(Paciente paciente) {

		try {
			String sql = "UPDATE paciente SET nomeConvenio=?, valCartaoConvenio=?, titularConvenio=?, ncartao=? WHERE codpessoa=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, paciente.getNomeConvenio());
			ps.setString(2, paciente.getValidadeCartaoConvenio());
			ps.setString(3, paciente.getTitularConvenio());
			ps.setString(4, paciente.getCartaoConvenio());
			ps.setInt(5, paciente.getCodPessoa());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {}
	}

	public void excluirPaciente(Paciente paciente) {

		try {
			String sql = "DELETE FROM pessoa WHERE codPessoa=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paciente.getCodPessoa());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {}
	}
}
