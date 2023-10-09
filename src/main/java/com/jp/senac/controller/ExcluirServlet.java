package com.jp.senac.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ExcluirServlet
 */
public class ExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AlunoJDBCdao dao = new AlunoJDBCdao();
		try {
			dao.excluirAluno(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("ListarServlet").forward(request, response);
	}

	

}
