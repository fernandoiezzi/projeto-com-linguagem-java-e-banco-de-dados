package br.com.cursosja.controlecursoja.controller;

import java.io.IOException;

import br.com.cursosja.controlecursoja.model.dao.ProfessorDao;
import br.com.cursosja.controlecursoja.model.entidade.Professor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IniciarAlterarProfessor
 */
public class IniciarAlterarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarAlterarProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long idp = 0;
		
		try {
			idp = Long.parseLong(request.getParameter("id"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ProfessorDao daop = new ProfessorDao();
		Professor p = daop.buscarprof(idp);
		
		request.setAttribute("professor", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("editar_professor.jsp");
		rd.forward(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
