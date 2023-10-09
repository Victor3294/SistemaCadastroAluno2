package com.jp.senac.controller;

import java.io.IOException;
import java.util.List;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlunoJDBCdao dao = new AlunoJDBCdao();
		List<Aluno> listaAlunos;
		try {
			listaAlunos = dao.listarAlunos();
			request.setAttribute("listaAlunos", listaAlunos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
	}

}
