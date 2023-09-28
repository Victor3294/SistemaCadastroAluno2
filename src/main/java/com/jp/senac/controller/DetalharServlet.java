package com.jp.senac.controller;

import java.io.IOException;
import java.util.List;

import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class DetalharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		HttpSession session = request.getSession();
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos");
		Aluno aluno = null;
		for(Aluno a: listaAlunos) {
			if(a.getNome().equals(nome)) {
				aluno = a;
			}
		}
		request.setAttribute("aluno", aluno);
		request.getRequestDispatcher("detalharAluno.jsp").forward(request, response);
		
	}

	
	

}
