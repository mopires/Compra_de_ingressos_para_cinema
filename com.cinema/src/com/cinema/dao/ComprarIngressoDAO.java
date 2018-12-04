package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cinema.jdbc.ConnectionFactory;
import com.cinema.model.Ingresso;
import com.cinema.model.Usuario;

public class ComprarIngressoDAO {

	Connection connection;
	
	public ComprarIngressoDAO() throws ClassNotFoundException{
		
		this.connection = new ConnectionFactory().getConnection();
	
	}
	
	public ResultSet ListarIngresso() {
		
		String query = "select * from ingresso";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(query);
			
			ResultSet dado = stmt.executeQuery();
				
			return dado;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	public boolean ComprarIngresso(Usuario user, Ingresso idIngresso) {
		
		String query = "update ingresso set cliente = '"+user.getCpf()+"'"
						+ "where idIngresso = '"+idIngresso.getId()+"'";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(query);
			
			stmt.execute();
				
			return true;
				
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
