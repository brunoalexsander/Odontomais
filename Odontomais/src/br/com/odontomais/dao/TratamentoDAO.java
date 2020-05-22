package br.com.odontomais.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.odontomais.model.Tratamento;
import br.com.odontomais.util.ConnectionFactory;

public class TratamentoDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TratamentoDAO() throws Exception {
		
		try {
			conn = ConnectionFactory.getConnection();
		} catch(Exception e) {
			throw new Exception("Erro ao conectar ao DB"+ e.getMessage() );
		}
	}
	
	public void cadastrarTratamento(Tratamento tratamento) {
		
		try {
			
			String sql = "INSERT INTO tratamento (nomeTratamento, valorTratamento) VALUES (?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, tratamento.getNomeTratamento());
			ps.setDouble(2, tratamento.getValorTramento());
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String nomeTratamento(int codTramento) {
		
		String nomeTratamento = null;
		
		try {
			ps = conn.prepareStatement("SELECT nomeTratamento FROM tratamento WHERE codTratamento=?");
			ps.setInt(1, codTramento);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				nomeTratamento = rs.getString("nomeTratamento");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nomeTratamento;
	}

	public List getTratamentos() throws Exception{

		List<String> listaTratamentos = new ArrayList<String>();

		try {

			ps = conn.prepareStatement("SELECT * FROM tratamento ORDER BY nomeTratamento");
			rs = ps.executeQuery();
			listaTratamentos.add("Selecione -");
			
			while(rs.next()) {
				listaTratamentos.add(rs.getString("nomeTratamento") + " - cod. " + rs.getInt("codTratamento"));
			}
			ps.close();
			return listaTratamentos;
		}
		catch(Exception e) {
			throw new Exception("Erro ao Buscar" + e.getMessage());
		}
	}
	
}
