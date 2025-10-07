package com.example.redSocial.controller;
import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;
import com.example.redSocial.dao.DAOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioControler {

    @RequestMapping("/registro")
    String registro(){
        return "registro";
    }

    @RequestMapping("/inicioSesion")
    String inicioSesion(){
        return "inicioSesion";
    }

    @PostMapping("/comprobarLogin")
    String comprobarLogin(Usuario user, Model model){
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Usuario> listaU =  daoFactory.getDaoUsuario().getUsuarios();

        if(listaU.contains(user)){
            model.addAttribute("post", daoFactory.getDaoPost().getPosts());
            return "posts";
        }
        System.out.println("Error");

        return "index";
    }

    @PostMapping("crearUsuario")
    String registrarse(Usuario user, Model model){

        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Usuario> listaU =  daoFactory.getDaoUsuario().getUsuarios();

        List<Post> listaP = daoFactory.getDaoPost().getPosts();

        listaU.add(user);
        model.addAttribute("user",user);
        model.addAttribute("post", listaP);
        System.out.println(user);


        return "posts";
    }
}
