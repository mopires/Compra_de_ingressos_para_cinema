package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cinema.jdbc.ConnectionFactory;
import com.cinema.model.Usuario;

public class CadastroDAO {

	Connection connection;
	
	public CadastroDAO() throws ClassNotFoundException{
	
		this.connection = new ConnectionFactory().getConnection();
	
	}
	
	public boolean CadastrarUsuario(Usuario user) {
		
		String sql = "insert into cliente (cpf, nome, estudante, pass) values "
				+ "('"+user.getCpf()+"','"+user.getNome()+"', '"+user.getEstudante()+"', '"+user.getSenha()+"')";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.execute();
				
			return true;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		
	}
	
	
}
















