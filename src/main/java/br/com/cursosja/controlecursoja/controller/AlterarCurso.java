package br.com.cursosja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursosja.controlecursoja.model.dao.CursoDao;
import br.com.cursosja.controlecursoja.model.dao.ProfessorDao;
import br.com.cursosja.controlecursoja.model.entidade.Curso;
import br.com.cursosja.controlecursoja.model.entidade.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarCurso
 */
public class AlterarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String strValor = request.getParameter("valorcurso");
		
		//professor
		
		String nomep = request.getParameter("nomeprofessor");
		String celular = request.getParameter("celular");
		String strvalorhora = request.getParameter("valorhora");
		
		long id = 0;
		//professor
		long idp = 0;
		try {
			id = Long.parseLong(request.getParameter("id"));
			idp = Long.parseLong(request.getParameter("idprofessor"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		double valor = 0.0;
		//professor
		double valorhora = 0.0;
		try {
			valor = Double.parseDouble(strValor);
			valorhora = Double.parseDouble(strvalorhora);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Curso c = new Curso();
		c.setId(id);
		c.setNome(nome);
		c.setValor(valor);
		
		CursoDao dao = new CursoDao();
		
		Professor p = new Professor();
		p.setId(idp);
		p.setNome(nomep);
		p.setCelular(celular);
		p.setValorHora(valorhora);
		
		ProfessorDao daop = new ProfessorDao();
		
		boolean retorno = dao.alterar(c);
		
		boolean retornop = daop.alterar(p);
		
		response.sendRedirect("lista_curso.jsp");
		
		
	}

}
