package com.cinema.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.dao.CadastroDAO;
import com.cinema.model.Usuario;

@Controller
public class CadastroController {

	
    @RequestMapping("CadastroForm")
    public String CadastroForm() {
        return "cadastro/formulario-cadastro";
    }
    
    @RequestMapping("efetuaCadastro")
    public String efetuaCadastro(Usuario usuario, HttpSession session)
    						  throws ClassNotFoundException {
        
    	if(new CadastroDAO().CadastrarUsuario(usuario)) {
        
    		//session.setAttribute("usuarioLogado", usuario);
            return "redirect:loginForm";
        
    	}else {
        	return "redirect:CadastroForm";
    	}
        

    }
    
    
    
    
    
}
