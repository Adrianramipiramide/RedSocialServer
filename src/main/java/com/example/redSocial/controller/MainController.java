package com.example.redSocial.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class   MainController {


    @RequestMapping("/index")
    String index(){
        return "index";
    }



// los filtrado por (fecha)
//filtrados por usuario
//Hacer con formato DAOFactory-> Crear las clases en el dao para que haya menos codigo en el Controller
}