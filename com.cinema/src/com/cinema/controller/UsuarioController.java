package com.cinema.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.dao.UsuarioDAO;
import com.cinema.model.Usuario;

@Controller
public class UsuarioController {
	
    @Autowired
    UsuarioDAO daoUsuario;

	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/formulario";
	}
	
	@RequestMapping("adicionaUsuario")
	public String adiciona(@Valid Usuario usuario, BindingResult result) throws ClassNotFoundException {
		
		if(result.hasFieldErrors("cpf") || result.hasFieldErrors("nome") || 
			result.hasFieldErrors("estudante") || result.hasFieldErrors("senha")) {
			
			return "usuario/formulario";
	
		}
		
		daoUsuario.adiciona(usuario);
		
		return "redirect:listaUsuarios";
	}
	
	@RequestMapping("alteraUsuario")
	public String altera(@Valid Usuario usuario, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("nome") || result.hasFieldErrors("login") || result.hasFieldErrors("senha") || result.hasFieldErrors("dataNascimento") || result.hasFieldErrors("altura")) {
			 return "usuario/mostra";
	     }
		daoUsuario.altera(usuario);
        return "redirect:listaUsuarios";
    }
	
    @RequestMapping("removeUsuario")
    public String remove(Usuario usuario) throws ClassNotFoundException {
    	daoUsuario.remove(usuario);
        return "redirect:listaUsuarios";
    }
    
}