package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odontomais.model.Endereco;
import br.com.odontomais.model.Pessoa;
import br.com.odontomais.util.ConnectionFactory;

public class EnderecoDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public EnderecoDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}

	public void salvarEndereco(Pessoa pessoa) {
		try {

			String sql = "INSERT INTO endereco (cep, endereco, numero, bairro, complemento, cidade, UF, codPessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getCep());
			ps.setString(2, pessoa.getEndereco());
			ps.setString(3, pessoa.getNumero());
			ps.setString(4, pessoa.getBairro());
			ps.setString(5, pessoa.getComplemento());
			ps.setString(6, pessoa.getCidade());
			ps.setString(7, pessoa.getUf());
			ps.setInt(8, pessoa.getCodPessoa());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*CONSULTA ENDEREÇO*/

	public void consultarEndereco(Pessoa pessoa) throws Exception {

		try {
			ps = conn.prepareStatement("SELECT * FROM endereco WHERE codpessoa=?");
			ps.setInt(1, pessoa.getCodPessoa());
			rs = ps.executeQuery(); 
			if(rs.next()) {
				pessoa.setCep(rs.getString("cep"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setBairro(rs.getString("bairro"));
				pessoa.setComplemento(rs.getString("complemento"));
				pessoa.setNumero(rs.getString("numero"));
				pessoa.setUf(rs.getString("uf"));
				pessoa.setCidade(rs.getString("cidade"));
				ps.close();
			}

		}
		catch (Exception e) {
			throw new Exception("Erro ao consultar" + e.getMessage());
		}
	}

}
