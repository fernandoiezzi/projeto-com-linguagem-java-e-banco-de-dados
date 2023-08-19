package br.com.cursosja.controlecursoja.model.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cursosja.controlecursoja.model.entidade.Professor;

public class ProfessorDao extends Conexao {
	public boolean incluir (Professor professor) {
		boolean ok = false;
		String sql = " insert into professor (nome, celular, valorhora) " + " values (?, ?, ?) ";
		
		try {
			
			
			PreparedStatement ps = criarConexao().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getCelular());
			ps.setDouble(3, professor.getValorHora());
			
			ok = ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
			ok = false;
		}
		
		return ok;
	}
   public List<Professor> listar(String nomepBuscar){
	   List<Professor> listarp = new ArrayList<Professor>();
	   
	   String sql = "select * from professor " + "where nome like ? " + "order by nome";
	   try {
		   PreparedStatement ps = criarConexao().prepareStatement(sql);
		   ps.setString(1, "%" + nomepBuscar + "%");
		   ResultSet rs = ps.executeQuery();
		   
		   Professor p;
		   while(rs.next()) {
			   p = new Professor();
			   p.setId(rs.getLong("idprofessor"));
			   p.setNome(rs.getString("nome"));
			   p.setCelular(rs.getString("celular"));
			   p.setValorHora(rs.getDouble("valorhora"));
			   
			   listarp.add(p);
		   }
	   } catch(Exception e) {
		   e.printStackTrace();	   
		   }
	   return listarp;
   }
public Professor buscarprof(long idp) {
	// TODO Auto-generated method stub
	Professor p = null;
	
	String sql = "select * from professor " + "where idprofessor = ? ";
	
	try {
		PreparedStatement ps = criarConexao().prepareStatement(sql);
		ps.setLong(1, idp);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			p = new Professor();
			p.setId(rs.getLong("idprofessor"));
			p.setNome(rs.getString("nome"));
			p.setCelular(rs.getString("celular"));
			p.setValorHora(rs.getDouble("valorhora"));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		fecharConexao();
	}
	
	return p;
}
public boolean alterar(Professor p) {
	// TODO Auto-generated method stub
	boolean ok = true;
	String sql = "update professor set " + "nome = ?, " + "celular = ?, " + "valorhora = ? " + "where idprofessor = ?";
	
	try {
		PreparedStatement ps = criarConexao().prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getCelular());
		ps.setDouble(3, p.getValorHora());
		ps.setLong(4, p.getId());
		
		ps.execute();
	}catch(Exception e) {
		e.printStackTrace();
		
		ok=false;
	}finally {
		fecharConexao();
	}
	return ok;
}
public boolean excluir(long idp) {
	// TODO Auto-generated method stub
	boolean ok = true;
	
	String sql = "delete from professor " + "where idprofessor = ? ";
	
	try {
		PreparedStatement ps = criarConexao().prepareStatement(sql);
		ps.setLong(1, idp);
		
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
