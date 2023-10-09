package com.jp.senac.controller;

import java.io.IOException;
import java.util.List;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PesquisarMatriculaNomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcao = request.getParameter("meio");
		String pesquisa = request.getParameter("pesquisa");
		AlunoJDBCdao dao = new AlunoJDBCdao();
		
		try {
			List<Aluno> listaAlunosSelecionados = dao.pesquisarPorNomeMatricula(opcao, pesquisa);
			
			System.out.println(listaAlunosSelecionados);
			
			request.setAttribute("listaAlunosSelecionados", listaAlunosSelecionados);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("listarPesquisa.jsp").forward(request, response);
	}

}
