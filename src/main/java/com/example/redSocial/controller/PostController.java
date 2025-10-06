package com.example.redSocial.controller;

import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class PostController {

    ArrayList<Post> listaPost = new ArrayList<>();


    @RequestMapping("paginaPost")
    String paginaPost() {

        return "posts";
    }

    @RequestMapping("crearPost")
    String crearPosr() {
        return "crearPost";
    }

    @PostMapping("crearPostReal")
    String creacionPost(Post post, Usuario user, Model model) {
        listaPost.add(post);
        System.out.println(post);
        model.addAttribute("post", listaPost);
        model.addAttribute("usuario", user);

        return "posts";
    }

    @GetMapping("/filtrarPost")
    String filtrado(@RequestParam("descripcion") String descripcion, Model model) {
        ArrayList<Post> coincidencias = new ArrayList<>();


        for (Post p : listaPost) {
            if ((p.getDescripcion().toLowerCase()).contains(descripcion.toLowerCase())) {

                coincidencias.add(p);

            } else {
                System.out.println("No se ha encontrado un post que coincida");
            }
        }

        model.addAttribute("post", coincidencias);

        return "posts";
    }

    @PostMapping("/gustar")
    String darMeGusta(String id, Model model) {

        try {
            for (Post p : listaPost) {
                if (p.getId() == Integer.parseInt(id)) {
                    p.setLikes(p.getLikes() + 1);
                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//le tengo que pasar la lista con los posts para que me recorra la lista
        model.addAttribute("post", listaPost);

        return "posts";
    }


    @PostMapping("/repostear")
    String repostear(String descripcion, String fechaPublicacion, Model model){

        int id = (int) (Math.random()*1000);
        Post p = new Post(id,descripcion,LocalDate.parse(fechaPublicacion));
        listaPost.add(p);


        model.addAttribute("post", listaPost);

        return "posts";
    }

    @GetMapping("/ordenarFechas")
    String ordenarFechas(String fecha, Model model) {


        List<Post> fechasOrdenadas;

        fechasOrdenadas = listaPost.stream().sorted(Comparator.comparing(Post::getFechaPublicacion)).toList();

        System.out.println(fechasOrdenadas);

        model.addAttribute("post", fechasOrdenadas);

        return "posts";
    }


    @GetMapping("/ordenarFechasDescendente")
    String ordenarFechasdesc(String fecha, Model model) {


        List<Post> fechasOrdenadas;

        fechasOrdenadas = listaPost.stream().sorted(Comparator.comparing(Post::getFechaPublicacion).reversed()).toList();

        System.out.println(fechasOrdenadas);

        model.addAttribute("post", fechasOrdenadas);

        return "posts";
    }
}