package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.cinema.jdbc.ConnectionFactory;
import com.cinema.model.Usuario;

public class LoginDAO {
	
	Connection connection;
	
	public LoginDAO() throws ClassNotFoundException{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean existeUsuario(Usuario usuario){
		
			String sql = "select * from cliente where cpf = '"+usuario.getCpf()+"' "
						+ "and pass = '"+usuario.getSenha()+"'";
			
			try{
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				
				//stmt.setString(1, usuario.getCpf());
				//stmt.setString(2, usuario.getSenha());
				
				ResultSet resultset = stmt.executeQuery(sql);

				if(resultset.next())
				{
					
					stmt.close();
					return true;
						
				}
				else
				{
					stmt.close();
					return false;
				}
			
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
	}
	
}
