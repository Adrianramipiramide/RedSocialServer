package com.example.redSocial.controller;

import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;
import com.example.redSocial.dao.DAOFactory;
import com.example.redSocial.dao.post.DAOPostRam;
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

        DAOFactory daoFactory = DAOFactory.getInstance();
       List<Post> listaP =  daoFactory.getDaoPost().getPosts();

        listaP.add(post);
        System.out.println(post);
        model.addAttribute("post", listaP);
        model.addAttribute("usuario", user);

        return "posts";
    }

    @GetMapping("/filtrarPost")
    String filtrado(@RequestParam("descripcion") String descripcion, Model model) {
        ArrayList<Post> coincidencias = new ArrayList<>();

        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Post> listaP =  daoFactory.getDaoPost().getPosts();
        for (Post p : listaP) {
            if ((p.getDescripcion().toLowerCase()).contains(descripcion.toLowerCase())) {

                coincidencias.add(p);

            } else if ((p.getFechaPublicacion().toString()).equals(descripcion)) {
                coincidencias.add(p);
            } else if ((p.getCreador().toLowerCase()).contains(descripcion.toLowerCase())) {
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
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Post> listaP =  daoFactory.getDaoPost().getPosts();
        try {
            for (Post p : listaP) {
                if (p.getId() == Integer.parseInt(id)) {
                    p.setLikes(p.getLikes() + 1);
                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//le tengo que pasar la lista con los posts para que me recorra la lista
        model.addAttribute("post", listaP);

        return "posts";
    }


    @PostMapping("/repostear")
    String repostear(String descripcion,String creador, String fechaPublicacion, Model model){


        DAOFactory daoFactory = DAOFactory.getInstance();


        daoFactory.getDaoPost().repostear(descripcion,creador,fechaPublicacion);
        List<Post> listaP =  daoFactory.getDaoPost().getPosts();


        model.addAttribute("post", listaP);

        return "posts";
    }

    @GetMapping("/ordenarFechas")
    String ordenarFechas(String fecha, Model model) {

        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Post> listaP =  daoFactory.getDaoPost().getPosts();
        List<Post> fechasOrdenadas;

        fechasOrdenadas = listaP.stream().sorted(Comparator.comparing(Post::getFechaPublicacion)).toList();

        System.out.println(fechasOrdenadas);

        model.addAttribute("post", fechasOrdenadas);

        return "posts";
    }


    @GetMapping("/ordenarFechasDescendente")
    String ordenarFechasdesc(String fecha, Model model) {

        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Post> listaP =  daoFactory.getDaoPost().getPosts();
        List<Post> fechasOrdenadas;

        fechasOrdenadas = listaP.stream().sorted(Comparator.comparing(Post::getFechaPublicacion).reversed()).toList();

        System.out.println(fechasOrdenadas);

        model.addAttribute("post", fechasOrdenadas);

        return "posts";
    }
}