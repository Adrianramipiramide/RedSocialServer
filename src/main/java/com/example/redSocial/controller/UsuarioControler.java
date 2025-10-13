package com.example.redSocial.controller;

import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;
import com.example.redSocial.dao.DAOFactory;
import com.example.redSocial.dao.usuario.DAOUserSQL;
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
    /*
        private DAOUserSQL daoUserSQL;

        public UsuarioControler(){
            this.daoUserSQL = new DAOUserSQL();
        }
    */
   public static int idUsuarioLogeado;

    @RequestMapping("/registro")
    String registro() {
        return "registro";
    }

    @RequestMapping("/inicioSesion")
    String inicioSesion() {
        return "inicioSesion";
    }

    @PostMapping("/comprobarLogin")
    String comprobarLogin(Usuario user, Model model) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Usuario> listaU = daoFactory.getDaoUsuario().getUsuarios();
      //  model.addAttribute("likes",daoFactory.getDaoLike().getLikes());

        if (listaU.contains(user)) {
            model.addAttribute("post", daoFactory.getDaoPost().getPosts());
            System.out.println(user.nombreUsuario);
            idUsuarioLogeado = DAOFactory.getInstance().getDaoUsuario().getIdUsuarioLogeado(user.nombreUsuario);
            return "posts";
        } else {
            System.out.println("Error");
            return "index";
        }

    }

    @PostMapping("crearUsuario")
    String registrarse(Usuario user, Model model) {

        DAOFactory daoFactory = DAOFactory.getInstance();

        DAOFactory.getInstance().getDaoUsuario().crearUsuario(user.getNombreUsuario(), user.getPassword(), String.valueOf(user.getFechaNacimiento()));

        List<Post> listaP = daoFactory.getDaoPost().getPosts();

        idUsuarioLogeado = DAOFactory.getInstance().getDaoUsuario().getIdUsuarioLogeado(user.nombreUsuario);
        System.out.println(idUsuarioLogeado);

   //     model.addAttribute("likes",DAOFactory.getInstance().getDaoLike().getLikes());

        model.addAttribute("post", listaP);
        System.out.println(user);


        return "posts";
    }
}
