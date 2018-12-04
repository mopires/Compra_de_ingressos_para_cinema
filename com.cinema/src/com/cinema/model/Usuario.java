package com.cinema.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
	
	private String cpf;
	@Size(min=11 , message="Preencher Campo")
	private String nome;
	@Size(min=1 , message="Preencher Campo")
	private String estudante;
	@Size(min=1 , message="Preencher Campo")
	private String senha;
	@Size(min=5 , message="Preencher Campo")
		
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEstudante() {
		return estudante;
	}
	
	public void setEstudante(String estuda) {
		this.estudante = estuda;
	}

}











