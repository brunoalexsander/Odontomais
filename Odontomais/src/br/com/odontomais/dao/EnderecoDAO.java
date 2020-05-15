package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odontomais.model.Endereco;
import br.com.odontomais.util.ConnectionFactory;

public class EnderecoDAO {
	
	private Connection conn;
	private Endereco endereco;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EnderecoDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}
	
	public void salvar(Endereco endereco) {
		try {
			String sql = "INSERT INTO endereco (endereco, complemento, uf, cep, municipio, codPessoa) VALUES (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, endereco.getEndereco());
			ps.setString(2, endereco.getComplemento());
			ps.setString(3, endereco.getUf());
			ps.setString(4, endereco.getCep());
			ps.setString(5, endereco.getCidade());
			ps.setInt(6, endereco.getCodPessoa());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
