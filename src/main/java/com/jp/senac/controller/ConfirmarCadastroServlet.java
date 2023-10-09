package com.jp.senac.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ConfirmarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperando a sessão
		HttpSession session = request.getSession();
		
		// Recuperando os valores informados
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		
		AlunoJDBCdao dao = new AlunoJDBCdao();
		
		
		String matricula = "";
		LocalDate dataAtual = LocalDate.now();
		int mes = dataAtual.getMonthValue();
		int semestrezao = (mes < 7) ? 1 : 2;
		String ano = String.valueOf(dataAtual.getYear());
		Random random = new Random();
		matricula = ano + String.format("%02d", mes) + "0" + semestrezao + String.format("%02d", Integer.parseInt(idade));
		
	
		for (int i = 0; i < 4; i++) {
			matricula += random.nextInt(10);
		}
		
		// Guardar no objeto aluno
		Aluno aluno = new Aluno(nome, idade, semestre, genero, matricula);
		Aluno alunoCadastrado = dao.cadastrarAluno(aluno);
		request.setAttribute("aluno", alunoCadastrado);
		
		// Encaminhar a requisição para o JSP	
		request.getRequestDispatcher("detalharAluno.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

}
