package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odontomais.model.Pessoa;
import br.com.odontomais.util.ConnectionFactory;

public class PessoaDAO {
	
	private Pessoa pessoa;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public PessoaDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}
	
	public void salvar(Pessoa pessoa) {
		try {
			String sql = "INSERT INTO pessoa (nome, cpf, rg, nascimento, genero, email, telefone, celular) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getRg());
			ps.setDate(4, pessoa.getNascimento());
			ps.setString(5, pessoa.getGenero());
			ps.setString(6, pessoa.getEmail());
			ps.setString(7, pessoa.getTelefone());
			ps.setString(8, pessoa.getCelular());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
