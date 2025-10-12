package com.example.redSocial.controller;

import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;
import com.example.redSocial.dao.DAOFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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
    String creacionPost( String descripcion, LocalDate fechaPublicacion, int idUser, Model model) {

        DAOFactory daoFactory = DAOFactory.getInstance();

        System.out.println("El id de usuario es "+idUser);
        DAOFactory.getInstance().getDaoPost().crearPost(descripcion,String.valueOf(fechaPublicacion), idUser);
        List<Post> listaP = daoFactory.getDaoPost().getPosts();
        model.addAttribute("post", listaP);


        return "posts";
    }

    @GetMapping("/filtrarPost")
    String filtrado(@RequestParam("descripcion") String descripcion, Model model) {

        DAOFactory daoFactory = DAOFactory.getInstance();
        model.addAttribute("post", daoFactory.getDaoPost().filtrar(descripcion));

        return "posts";
    }

    @PostMapping("/gustar")
    String darMeGusta(int idPost, Model model) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Post> listaP = daoFactory.getDaoPost().getPosts();
        daoFactory.getDaoLike().sumarLike(1,idPost);

        model.addAttribute("likes",daoFactory.getDaoLike().getLikes());
        model.addAttribute("post", listaP);

        return "posts";
    }


    @PostMapping("/repostear")
    String repostear(String descripcion, int idUser, String fechaPublicacion, Model model) {

        DAOFactory daoFactory = DAOFactory.getInstance();


        daoFactory.getDaoPost().repostear(descripcion, idUser, fechaPublicacion);
        List<Post> listaP = daoFactory.getDaoPost().getPosts();

        model.addAttribute("post", listaP);

        return "posts";
    }

    @GetMapping("/ordenarFechas")
    String ordenarFechas(String fecha, Model model) {

        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Post> listaP = daoFactory.getDaoPost().getPosts();
        List<Post> fechasOrdenadas;

        fechasOrdenadas = listaP.stream().sorted(Comparator.comparing(Post::getFechaPublicacion)).toList();

        model.addAttribute("post", fechasOrdenadas);

        return "posts";
    }


    @GetMapping("/ordenarFechasDescendente")
    String ordenarFechasdesc(String fecha, Model model) {

        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Post> listaP = daoFactory.getDaoPost().getPosts();
        List<Post> fechasOrdenadas;

        fechasOrdenadas = listaP.stream().sorted(Comparator.comparing(Post::getFechaPublicacion).reversed()).toList();

        model.addAttribute("post", fechasOrdenadas);

        return "posts";
    }
}