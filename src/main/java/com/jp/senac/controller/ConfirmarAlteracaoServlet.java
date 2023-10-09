package com.jp.senac.controller;

import java.io.IOException;
import java.util.List;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ConfirmarAlteracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		String matricula = request.getParameter("matricula");
		int id = Integer.parseInt(request.getParameter("id"));
		Aluno aluno = new Aluno(nome, idade, semestre, genero, id, matricula);
		AlunoJDBCdao dao = new AlunoJDBCdao();
		dao.alterarAluno(aluno);
		request.getRequestDispatcher("ListarServlet").forward(request, response);
	}

}
