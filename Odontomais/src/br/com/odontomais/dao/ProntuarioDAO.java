package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.odontomais.model.Paciente;
import br.com.odontomais.model.Pessoa;
import br.com.odontomais.model.Prontuario;
import br.com.odontomais.model.TratamentoPaciente;
import br.com.odontomais.util.ConnectionFactory;
import javafx.scene.web.PromptData;

public class ProntuarioDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;	

	public ProntuarioDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}

	public void salvarAnotacaoProntuario(Prontuario prontuario) {

		try {

			String sql = "INSERT INTO prontuario (nomeMedico, dataAnotacao, anotacao, codPaciente) VALUES (?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, prontuario.getNomeMedico());
			ps.setString(2, prontuario.getDataAnotacao());
			ps.setString(3, prontuario.getAnotacao());
			ps.setInt(4, prontuario.getCodPaciente());
			ps.executeUpdate();
			ps.close();		

		} catch (Exception e) {
			
		}
	}
	
	public List buscaProntuarioPaciente(Paciente paciente) {

		List<Prontuario> listaAnotacoes = new ArrayList<>();

		try {
			
			ps = conn.prepareStatement("SELECT * FROM prontuario WHERE codPaciente=? ORDER BY codanotacao");
			ps.setInt(1, paciente.getCodPaciente());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Prontuario prontuario = new Prontuario();
				prontuario.setCodAnotacao(rs.getInt("codanotacao"));
				prontuario.setNomeMedico(rs.getString("nomeMedico"));
				prontuario.setDataAnotacao(rs.getString("dataanotacao"));
				prontuario.setAnotacao(rs.getString("anotacao"));
				listaAnotacoes.add(prontuario);
			}
		}
		catch (Exception e) {e.printStackTrace();}
		
		return listaAnotacoes;
	}
	
	public Prontuario buscaAnotacaoPaciente(int cod) {
		
		Prontuario prontuario = new Prontuario();
		String nome = null;
		
		try {
			
			ps = conn.prepareStatement("SELECT * FROM prontuario WHERE codAnotacao=?");
			ps.setInt(1, cod);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				prontuario.setCodPaciente(rs.getInt("codPaciente"));
				prontuario.setCodAnotacao(rs.getInt("codAnotacao"));
				prontuario.setNomeMedico(rs.getString("nomeMedico"));
				prontuario.setDataAnotacao(rs.getString("dataanotacao"));
				prontuario.setAnotacao(rs.getString("anotacao"));
			}
		}
		catch (Exception e) {e.printStackTrace();}
		
		return prontuario;
	}
	
	public void alterarAnotacao(Prontuario prontuario) {
				
		try {
			
			String sql = "UPDATE prontuario SET nomeMedico=?, dataAnotacao=?, anotacao=? WHERE codAnotacao=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, prontuario.getNomeMedico());
			ps.setString(2, prontuario.getDataAnotacao());
			ps.setString(3, prontuario.getAnotacao());
			ps.setInt(4, prontuario.getCodAnotacao());
			ps.executeUpdate();
			ps.close();		

		} catch (Exception e) {}
	}
}
