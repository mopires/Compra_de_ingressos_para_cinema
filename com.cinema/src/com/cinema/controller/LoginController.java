package com.cinema.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.dao.LoginDAO;
import com.cinema.model.Usuario;

@Controller
public class LoginController{

    @RequestMapping("loginForm")
    public String loginForm() {
        return "login/formulario-login";
    }
   
    @RequestMapping("efetuaLogin")
    public String efetuaLogin(Usuario usuario, HttpSession session) throws ClassNotFoundException {
        
    	if(new LoginDAO().existeUsuario(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:listaPrincipal";
        }
        return "redirect:loginForm";
        
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }
    
}