package com.jp.senac.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		
		// Recuperando a lista da sessão, caso não exista, cria
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos");
		int max = 0;
		int id = 0;
		
		if (listaAlunos == null) {
			listaAlunos = new ArrayList<>(); // Criando a lista
		}else {
			for(Aluno a : listaAlunos) {
				if(a.getId() > max) {
					max = a.getId();
					id = max;
				}
			}
		}
		
		String matricula = "";
		LocalDate dataAtual = LocalDate.now();
		int mes = dataAtual.getMonthValue();
		int semestrezao = (mes < 7) ? 1 : 2;
		String ano = String.valueOf(dataAtual.getYear());
		Random random = new Random();
		matricula = ano + String.valueOf(mes) + "0" + semestrezao + idade;
		
	
		for (int i = 0; i < 4; i++) {
			matricula += random.nextInt(10);
		}
		
		// Guardar no objeto aluno
		Aluno aluno = new Aluno(nome, idade, semestre, genero, id+1, matricula);
		
		// Adicionando aluno na lista (INSERT)
		listaAlunos.add(aluno);
		
		session.setAttribute("listaAlunos", listaAlunos);
		request.setAttribute("aluno", aluno);
		
		// Encaminhar a requisição para o JSP
		request.getRequestDispatcher("detalharAluno.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

}
