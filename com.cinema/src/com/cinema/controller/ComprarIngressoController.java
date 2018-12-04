package com.cinema.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.dao.CadastroDAO;
import com.cinema.dao.ComprarIngressoDAO;
import com.cinema.model.Usuario;
import com.cinema.model.Ingresso;

@Controller
public class ComprarIngressoController {

	
    @RequestMapping("comprarIngresso")
    public String comprarIngresso() {
        return "comprar/ingresso";
    }
    
    @RequestMapping("compraIngresso")
    public String compraIngresso(Usuario usuario, Ingresso ingresso, HttpSession session)
    						  throws ClassNotFoundException {
        
    	if(new ComprarIngressoDAO().ComprarIngresso(usuario, ingresso)) {
        
    		//session.setAttribute("usuarioLogado", usuario);
            return "redirect:listaPrincipal";
        
    	}else {
        	return "redirect:listaPrincipal";
    	}
        

    }
    
    
    
    
    
    
    
    
    
    
    
}
