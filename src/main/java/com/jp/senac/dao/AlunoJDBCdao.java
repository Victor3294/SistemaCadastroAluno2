package com.jp.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jp.senac.model.Aluno;

public class AlunoJDBCdao {
	
	private Connection getConexao () throws ClassNotFoundException {
		
		//driver
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//banco de dados
		String url = "jdbc:mysql://localhost:3306/cadastroalunos?useTimezone=true&serverTimezone=UTC";
		
		//usuario
		String user = "root";
		
		//senha
		String password = "root";
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Conectando ao banco de dados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public List<Aluno> listarAlunos() throws ClassNotFoundException{
		List<Aluno> alunos = new ArrayList<>();
		String query = "Select * from alunos";
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String genero = rs.getString(4);
				String matricula = rs.getString(5);
				String semestre = rs.getString(6);
				alunos.add(new Aluno(nome, idade, semestre, genero, id, matricula));
			}
				rs.close();
				pst.close();
				con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return alunos;
	}
	
	public void excluirAluno(Aluno aluno) throws SQLException {
		String delete = "Delete from aluno where (id = ?)";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, aluno.getId());
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
