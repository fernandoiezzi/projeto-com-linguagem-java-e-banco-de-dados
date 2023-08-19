package br.com.cursosja.controlecursoja.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.cursosja.controlecursoja.model.dao.TurmaDao;
import br.com.cursosja.controlecursoja.model.entidade.Curso;
import br.com.cursosja.controlecursoja.model.entidade.Professor;
import br.com.cursosja.controlecursoja.model.entidade.Turma;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncluirTurma
 */
public class IncluirTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncluirTurma() {
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
		String idCurso = request.getParameter("curso");
		String idProfessor = request.getParameter("professor");
		String dataInicio = request.getParameter("inicio");
		String dataTermino = request.getParameter("fim");
		
		System.out.println("idCurso => " + idCurso);
		System.out.println("idProfessor => " + idProfessor);
		System.out.println("data Inicio => " + dataInicio);
		System.out.println("Data Término => " + dataTermino);
		
		Curso c = new Curso();
		try {
			c.setId(Long.parseLong(idCurso));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Professor p = new Professor();
		try {
			p.setId(Long.parseLong(idProfessor));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Date inicio = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			inicio = fmt.parse(dataInicio);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		Date termino = new Date();
		try {
			termino = fmt.parse(dataTermino);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Turma t = new Turma();
		t.setCurso(c);
		t.setProfessor(p);
		t.setDataInicio(inicio);
		t.setDataFim(termino);
		
		TurmaDao dao = new TurmaDao();
		dao.incluir(t);
		response.sendRedirect("lista_turma.jsp");
		
	}

}
