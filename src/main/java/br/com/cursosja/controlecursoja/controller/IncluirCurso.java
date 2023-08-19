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
 * Servlet implementation class IncluirCurso
 */
public class IncluirCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncluirCurso() {
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
		
		
		String nome = request.getParameter("nomecurso");
		String strValor = request.getParameter("valorcurso");
		String nomeprof = request.getParameter("nomeprofessor");
		String cel = request.getParameter("celular");
		String strValorh = request.getParameter("valorhora");
		
		double valorhora = 0.0;
		double valorcurso = 0.0;
		
		try {
			valorcurso = Double.parseDouble(strValor);
			valorhora = Double.parseDouble(strValorh);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print(strValor);
		
		Professor p = new Professor();
		p.setNome(nomeprof);
		p.setCelular(cel);
		p.setValorHora(valorhora);
		
		
		Curso c = new Curso();
		c.setNome(nome);
		c.setValor(valorcurso);
		
		ProfessorDao pdao = new ProfessorDao();
		CursoDao dao = new CursoDao();
		boolean retorno = dao.incluir(c);
		boolean retornoprof = pdao.incluir(p);
		response.sendRedirect("lista_curso.jsp");
	}

}
