package br.com.cursosja.controlecursoja.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.cursosja.controlecursoja.model.dao.CursoDao;
import br.com.cursosja.controlecursoja.model.dao.ProfessorDao;
import br.com.cursosja.controlecursoja.model.entidade.Curso;
import br.com.cursosja.controlecursoja.model.entidade.Professor;

/**
 * Servlet implementation class IncluirProfessor
 */
public class IncluirProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncluirProfessor() {
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
		String nomeprof = request.getParameter("nomeprofessor");
		String cel = request.getParameter("celular");
		String strValorh = request.getParameter("valorhora");
		
		double valorhora = 0.0;
		
		try {
			valorhora = Double.parseDouble(strValorh);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Professor p = new Professor();
		p.setNome(nomeprof);
		p.setCelular(cel);
		p.setValorHora(valorhora);
		
		
		
		ProfessorDao pdao = new ProfessorDao();
		boolean retornoprof = pdao.incluir(p);
		response.sendRedirect("lista_professor.jsp");
	}

}
