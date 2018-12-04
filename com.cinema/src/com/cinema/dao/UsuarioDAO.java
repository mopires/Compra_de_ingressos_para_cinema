package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.model.Usuario;

@Repository
public class UsuarioDAO {
	Connection connection;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Usuario usuario){
		
		String sql = "insert into cliente (cpf, nome, estudante) " +
					"values (?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getEstudante());
			
			stmt.execute();
			stmt.close();
		
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
		
	public void remove(Usuario usuario){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from usuarios where cpf = ?");
			
			stmt.setString(1, usuario.getCpf());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
		
	public void altera(Usuario usuario){
		String sql = "update usuarios set nome = ? set estudante = ? where cpf = ?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEstudante());
			stmt.setString(3, usuario.getCpf());
			
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
