package com.jp.senac.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if(usuario.equals("admin")  && senha.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(500);
			request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("index.jsp?erro=1").forward(request, response);
		}

	}

}
