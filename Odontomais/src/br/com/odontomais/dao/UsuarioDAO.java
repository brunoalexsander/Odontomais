package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.odontomais.model.Usuario;
import br.com.odontomais.util.ConnectionFactory;

public class UsuarioDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;	

	public UsuarioDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}

	public void salvarUsuario(Usuario usuario) {

		try {

			String sql = "INSERT INTO usuario (nome, login, senha, nivelacesso) VALUES (?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getNomeUsuario());
			ps.setString(2, usuario.getLogin());
			ps.setInt(3, usuario.getSenhaUsuario());
			ps.setInt(4, usuario.getNivelAcessoUsusario());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List buscaUsuarios() {

		List<Usuario> lista = new ArrayList<>();

		try {
			ps = conn.prepareStatement("SELECT * FROM usuario");
			rs = ps.executeQuery();

			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodUsuario(rs.getInt("codusuario"));
				usuario.setNomeUsuario(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenhaUsuario(rs.getInt("senha"));
				usuario.setNivelAcessoUsusario(rs.getInt("nivelacesso"));
				lista.add(usuario);
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Usuario buscaUsuario(int cod) {

		Usuario usuario = new Usuario();

		try {

			ps = conn.prepareStatement("SELECT * FROM usuario WHERE codUsuario=?");
			ps.setInt(1, cod);
			rs = ps.executeQuery();

			while(rs.next()) {
				usuario.setCodUsuario(rs.getInt("codUsuario"));
				usuario.setNomeUsuario(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenhaUsuario(rs.getInt("senha"));
				usuario.setNivelAcessoUsusario(rs.getInt("nivelacesso"));
			}
		}
		catch (Exception e) {e.printStackTrace();}

		return usuario;
	}
	
	public Usuario buscaUsuario(Usuario usuario) {
		
		try {

			ps = conn.prepareStatement("SELECT * FROM usuario WHERE login=? and senha=?");
			ps.setString(1, usuario.getLogin());
			ps.setInt(2, usuario.getSenhaUsuario());
			rs = ps.executeQuery();

			while(rs.next()) {
				usuario.setCodUsuario(rs.getInt("codUsuario"));
				usuario.setNomeUsuario(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenhaUsuario(rs.getInt("senha"));
				usuario.setNivelAcessoUsusario(rs.getInt("nivelacesso"));
			}
		}
		catch (Exception e) {e.printStackTrace();}

		return usuario;
	}

	public void editarUsuario(Usuario usuario){
		
		try {

			String sql = "UPDATE usuario SET nome=?, login=?, senha=?, nivelacesso=? WHERE codUsuario=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getNomeUsuario());
			ps.setString(2, usuario.getLogin());
			ps.setInt(3, usuario.getSenhaUsuario());
			ps.setInt(4, usuario.getNivelAcessoUsusario());
			ps.setInt(5, usuario.getCodUsuario());
			ps.executeUpdate();
			ps.close();
			System.out.println(usuario.getNomeUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
