package br.com.cursosja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursosja.controlecursoja.model.dao.ProfessorDao;
import br.com.cursosja.controlecursoja.model.entidade.Professor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarProfessor
 */
public class AlterarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarProfessor() {
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
		
		String nomep = request.getParameter("nomeprofessor");
		String celular = request.getParameter("celular");
		String strvalorhora = request.getParameter("valorhora");
		
		
		//professor
		long idp = 0;
		try {
			idp = Long.parseLong(request.getParameter("idprof"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		double valorhora = 0.0;
		try {
		
			valorhora = Double.parseDouble(strvalorhora);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		Professor p = new Professor();
		p.setId(idp);
		p.setNome(nomep);
		p.setCelular(celular);
		p.setValorHora(valorhora);
		
		ProfessorDao daop = new ProfessorDao();
		
		boolean retornop = daop.alterar(p);
		
		response.sendRedirect("lista_professor.jsp");
		
		
	}


	}

