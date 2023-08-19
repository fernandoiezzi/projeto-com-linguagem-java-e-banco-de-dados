package br.com.cursosja.controlecursoja.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cursosja.controlecursoja.model.entidade.Usuario;

public class UsuarioDao extends Conexao {

	public Usuario logar(String login, String senha) {
		Usuario usr = null;
		
		String sql= "select * from usuario where login = ? and senha = ? ";
		
		try {
		 PreparedStatement ps = criarConexao().prepareStatement(sql);	
		 ps.setString(1, login);
		 ps.setString(2, senha);

		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			usr = new Usuario();
			usr.setId(rs.getLong("idusuario"));
			usr.setNome(rs.getString("nome"));
			usr.setLogin(rs.getString("login"));
			usr.setSenha(rs.getString("senha"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		  fecharConexao();
		}
		return usr;
		
		
	}

	public boolean cadastrar(Usuario usr) {
		// TODO Auto-generated method stub
		boolean ok = false;
		
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, usr.getNome());
			ps.setString(2, usr.getLogin());
			ps.setString(3, usr.getSenha());
			
			ok = ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
			ok = false;
		}finally {
			fecharConexao();
		}
		return ok;
	}

}
