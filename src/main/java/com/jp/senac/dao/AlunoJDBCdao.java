package com.jp.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public Aluno pesquisarPorId(int id) {
		String query = "Select * from alunos where id = ? ";
		Aluno aluno = null;
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getInt(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String genero = rs.getString(4);
				String matricula = rs.getString(5);
				String semestre = rs.getString(6);
				aluno = new Aluno(nome, idade, semestre, genero, id, matricula);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return aluno;
	}
	
	public List<Aluno> pesquisarPorNomeMatricula(String opcao, String pesquisa) {
		List<Aluno> alunosSelecionados = new ArrayList<>();
		if(opcao.equals("Matricula")) {
			String query = "Select * from alunos WHERE matricula LIKE '%"+pesquisa+"%' ";
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
					alunosSelecionados.add(new Aluno(nome, idade, semestre, genero, id, matricula));
				}
				rs.close();
				pst.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(opcao.equals("Nome")) {
			String query = "Select * from alunos WHERE nome LIKE '%"+pesquisa+"%'";
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
					alunosSelecionados.add(new Aluno(nome, idade, semestre, genero, id, matricula));
				}
				rs.close();
				pst.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return alunosSelecionados;
	}
	
	public Aluno cadastrarAluno(Aluno aluno) {
		String query = "Insert into alunos (nome, idade, genero, matricula, semestre) values( ?, ?, ?, ?, ?)";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getIdade());
			pst.setString(3, aluno.getGenero());
			pst.setString(4, aluno.getMatricula());
			pst.setString(5, aluno.getSemestre());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()) {
				int id = rs.getInt(1);
				System.out.println("id gerado foi " + id);
				aluno.setId(id);
			}
			
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aluno;
	}
	public void alterarAluno(Aluno aluno) {
		String query = "UPDATE alunos SET nome = ?, idade = ?, genero = ?, semestre = ? WHERE id = ?";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getIdade());
			pst.setString(3, aluno.getGenero());
			pst.setString(4, aluno.getSemestre());
			pst.setInt(5, aluno.getId());
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirAluno(int id) throws SQLException {
		String delete = "Delete from alunos where (id = ?)";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
