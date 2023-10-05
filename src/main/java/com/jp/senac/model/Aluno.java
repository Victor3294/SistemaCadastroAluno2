package com.jp.senac.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private String nome;
	private String idade;
	private String semestre;
	private String genero;
	private Integer id;
	private String matricula;
	
	public Aluno() { 
	}
	
	public Aluno(String nome, String idade, String semestre, String genero, Integer id, String matricula) {
		this.nome = nome;
		this.idade = idade;
		this.semestre = semestre;
		this.genero = genero;
		this.id = id;
		this.matricula = matricula;
	}
	
	public Aluno(String nome, String idade, String semestre, String genero, String matricula) {
		this.nome = nome;
		this.idade = idade;
		this.semestre = semestre;
		this.genero = genero;
		this.matricula = matricula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	

}
