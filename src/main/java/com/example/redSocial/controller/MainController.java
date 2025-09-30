package com.example.redSocial.controller;
import com.example.redSocial.clases.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MainController {
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @RequestMapping("/")
    String index(){
        return "index";
    }

    @RequestMapping("/registro")
    String registro(){
        return "registro";
    }

    @RequestMapping("/inicioSesion")
    String inicioSesion(){
        return "inicioSesion";
    }

    @PostMapping("crearUsuario")
    String registrarse(Usuario user, Model model){
        listaUsuarios.add(user);
        model.addAttribute("usuario",user);
        return "posts";
    }

    @RequestMapping("paginaPost")
    String paginaPost(){

        return "posts";
    }

}