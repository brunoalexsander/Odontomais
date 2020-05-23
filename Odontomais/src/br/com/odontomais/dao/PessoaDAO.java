package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.odontomais.model.Pessoa;
import br.com.odontomais.util.ConnectionFactory;

public class PessoaDAO extends EnderecoDAO{

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

	public void salvarPessoa(Pessoa pessoa) {

		try {

			String sql = "INSERT INTO pessoa (nome, cpf, rg, nascimento, genero, email, celular, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getRg());
			ps.setString(4, pessoa.getDataNascimento());
			ps.setString(5, pessoa.getGenero());
			ps.setString(6, pessoa.getEmail());
			ps.setString(7, pessoa.getCelular());
			ps.setString(8, pessoa.getTelefone());
			int row = ps.executeUpdate();

			if (row == 1) {
				rs = ps.getGeneratedKeys();
				if(rs.next()) {
					pessoa.setCodPessoa(rs.getInt(1));
				}
			}

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*CONSULTAR PESSOA*/
	public void consultarPessoa(Pessoa pessoa) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM pessoa WHERE cpf=? or codPessoa=?");
			ps.setString(1, pessoa.getCpf());
			ps.setInt(2, pessoa.getCodPessoa());
			rs = ps.executeQuery(); 
			if(rs.next()) {
				pessoa.setCodPessoa(rs.getInt("codpessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setRg(rs.getString("rg"));
				pessoa.setDataNascimento(rs.getString("nascimento"));
				pessoa.setGenero(rs.getString("genero"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setCelular(rs.getString("celular"));
				pessoa.setTelefone(rs.getString("telefone"));
				ps.close();
			}
		}
		catch (Exception e) {
			throw new Exception("Erro ao consultar" + e.getMessage());
		}
	}

	/*ALTERAR PESSOA*/
	public void alterarPessoa(Pessoa pessoa) {

		try {

			String sql = "UPDATE pessoa SET nome=?, cpf=?, rg=?, nascimento=?, genero=?, email=?, celular=?, telefone=? WHERE codPessoa=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getRg());
			ps.setString(4, pessoa.getDataNascimento());
			ps.setString(5, pessoa.getGenero());
			ps.setString(6, pessoa.getEmail());
			ps.setString(7, pessoa.getCelular());
			ps.setString(8, pessoa.getTelefone());
			ps.setInt(9, pessoa.getCodPessoa());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
