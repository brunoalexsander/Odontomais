package br.com.odontomais.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.odontomais.dao.TratamentoPacienteDAO;
import br.com.odontomais.dao.UsuarioDAO;

public class Usuario {

	private int codUsusario;
	private String nomeUsuario;
	private String login;
	private int senhaUsuario;
	private int nivelAcessoUsusario;
	private UsuarioDAO DAOusuario;

	public int getCodUsusario() {
		return codUsusario;
	}
	public void setCodUsusario(int codUsusario) {
		this.codUsusario = codUsusario;
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
			buscaUsuarios(tabela);
		} catch (Exception e) {}
	}


	public void buscaUsuarios(JTable tabela) {
		
		List<Usuario> lista = new ArrayList<>();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);
		
		try {
			DAOusuario = new UsuarioDAO();
			lista = DAOusuario.buscaUsuarios();

			for(Usuario usuario : lista) {
				model.addRow(new Object[] {
						usuario.getCodUsusario(), 
						usuario.getNomeUsuario(), 
						usuario.getLogin(), 
						usuario.getSenhaUsuario(), 
						usuario.getNivelAcessoUsusario() 
				});	
			}
		} catch (Exception e) {e.printStackTrace();}
	}

}
