package com.example.redSocial.controller;
import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class   MainController {
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ArrayList<Post> listaPost = new ArrayList<>();

    @RequestMapping("/index")
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

    @PostMapping("/comprobarLogin")
    String comprobarLogin(Usuario user, Model model){
        if(listaUsuarios.contains(user)){
            return "posts";
        }
        System.out.println("Error");
        return "index";
    }

    @PostMapping("crearUsuario")
    String registrarse(Usuario user, Model model){
        listaUsuarios.add(user);
        model.addAttribute("user",user);
        System.out.println(user);
        return "posts";
    }

    @RequestMapping("paginaPost")
    String paginaPost(){

        return "posts";
    }

    @RequestMapping("crearPost")
    String crearPosr(){
        return "crearPost";
    }

    @PostMapping("crearPostReal")
    String creacionPost(Post post,Usuario user, Model model){
        listaPost.add(post);
        System.out.println(post);
        model.addAttribute("post", listaPost);
        model.addAttribute("usuario",user);
        return "posts";
    }
//Falta que el usuario me acompañe alla donde voy
// hacer un cerrar sesion
// likes
// repostear
// los filtrados
//orden de publicaciones por fecha con comparable
// favicon y hacerlo bonito
}