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


    @RequestMapping("/index")
    String index(){
        return "index";
    }



//Falta que el usuario me acompañe alla donde voy
// hacer un cerrar sesion
// likes
// repostear
// los filtrados
//orden de publicaciones por fecha con comparable
// favicon y hacerlo bonito
}