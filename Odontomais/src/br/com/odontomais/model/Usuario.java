package br.com.odontomais.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.odontomais.dao.TratamentoPacienteDAO;
import br.com.odontomais.dao.UsuarioDAO;

public class Usuario {

	private int codUsuario;
	private String nomeUsuario;
	private String login;
	private int senhaUsuario;
	private int nivelAcessoUsusario;
	private UsuarioDAO DAOusuario;
	private Usuario usuario;

	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(int senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	public int getNivelAcessoUsusario() {
		return nivelAcessoUsusario;
	}
	public void setNivelAcessoUsusario(int nivelAcessoUsusario) {
		this.nivelAcessoUsusario = nivelAcessoUsusario;
	}


	public void salvarUsuario(Usuario usuario, JTable tabela) {

		try {
			DAOusuario = new UsuarioDAO();
			DAOusuario.salvarUsuario(usuario);
			JOptionPane.showMessageDialog(null, "Usuario salvo com Sucesso");
			listarUsuarios(tabela);
		} catch (Exception e) {}
	}


	public void listarUsuarios(JTable tabela) {

		List<Usuario> lista = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);

		try {
			DAOusuario = new UsuarioDAO();
			lista = DAOusuario.buscaUsuarios();

			for(Usuario usuario : lista) {
				model.addRow(new Object[] {
						usuario.getCodUsuario(), 
						usuario.getNomeUsuario(), 
						usuario.getLogin(),  
						usuario.getNivelAcessoUsusario() 
				});	
			}
		} catch (Exception e) {}
	}

	public Usuario buscaUsuario(int cod) {

		usuario = new Usuario();
		
		try {
			DAOusuario = new UsuarioDAO();
			usuario = DAOusuario.buscaUsuario(cod);
		} catch (Exception e) {}
		
		return usuario;
	}
	
	public Usuario buscaUsuario(Usuario usuario) {
		
		try {
			
			DAOusuario = new UsuarioDAO();
			usuario = DAOusuario.buscaUsuario(usuario);
			
			if(usuario.getNivelAcessoUsusario() == 0) {
				JOptionPane.showMessageDialog(null, "Login ou Senha inválidos");
			}
			
		} catch (Exception e) {}
		
		return usuario;
	}
	
	public void alteraUsuario(Usuario usuario, JTable tabela) {
		try {
			DAOusuario = new UsuarioDAO();
			DAOusuario.editarUsuario(usuario);
			
			JOptionPane.showMessageDialog(null, "Usuario alterado com Sucesso");
			listarUsuarios(tabela);

		} catch (Exception e) {}
	}
}
