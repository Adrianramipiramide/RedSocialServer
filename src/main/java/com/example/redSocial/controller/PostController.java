package com.example.redSocial.controller;

import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PostController {

    ArrayList<Post> listaPost = new ArrayList<>();


    @RequestMapping("paginaPost")
    String paginaPost(){

        return "posts";
    }

    @RequestMapping("crearPost")
    String crearPosr(){
        return "crearPost";
    }

    @PostMapping("crearPostReal")
    String creacionPost(Post post, Usuario user, Model model){
        listaPost.add(post);
        System.out.println(post);
        model.addAttribute("post", listaPost);
        model.addAttribute("usuario",user);
        return "posts";
    }

    @GetMapping("/filtrarPost")
    String filtrado(@RequestParam("descripcion") String descripcion , Model model){
        ArrayList<Post> coincidencias = new ArrayList<>();


        for (Post p : listaPost) {
            if((p.getDescripcion().toLowerCase()).contains(descripcion.toLowerCase())){

                coincidencias.add(p);

            }else {
                System.out.println("No se ha encontrado un post que coincida");
            }
        }

        model.addAttribute("post",coincidencias);
        return "posts";
    }

    @PostMapping ("/gustar")
    String darMeGusta(Post post){

        post.setLikes(post.getLikes()+1);

        return "posts";
    }



}