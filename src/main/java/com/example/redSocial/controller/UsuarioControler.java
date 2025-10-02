package com.example.redSocial.controller;
import com.example.redSocial.clases.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

@Controller
public class UsuarioControler {
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

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

        try (BufferedWriter bf = new BufferedWriter(new FileWriter("posts.html"))) {
            bf.write("Bienvenido "+ user.nombreUsuario + " ");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @PostMapping("crearUsuario")
    String registrarse(Usuario user, Model model){
        listaUsuarios.add(user);
        model.addAttribute("user",user);
        System.out.println(user);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("posts.html", true))) {
            bf.write("Bienvenido "+ user.nombreUsuario + " ");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "posts";
    }
}
