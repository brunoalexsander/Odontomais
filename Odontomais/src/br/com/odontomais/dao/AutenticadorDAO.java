package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odontomais.model.Funcionario;
import br.com.odontomais.util.ConnectionFactory;

public class AutenticadorDAO {
	
	private Funcionario funcionario;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private int permissao;
	
	public AutenticadorDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}
	
	public boolean autenticar(String email, String senha) throws Exception {
		if (email.isEmpty() || senha.isEmpty()) {
			throw new Exception("Informe todos os campos!");
		}
		try {
			String sql = "SELECT COUNT(*) AS total FROM funcionario f INNER JOIN pessoa p ON f.codPessoa = p.codPessoa WHERE p.email = ? AND f.senha = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()) {}
			if (rs.getInt("total") > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Funcionario permissao(String email, String senha) throws Exception {
		try {
			String sql = "SELECT f.* FROM funcionario f INNER JOIN pessoa p ON f.codPessoa = p.codPessoa WHERE p.email = ? AND f.senha = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codPessoa = rs.getInt("codPessoa");
				int permissao = rs.getInt("permissao");
				String password = rs.getString("senha");
				funcionario = new Funcionario(codPessoa, permissao, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionario;
	}
}
