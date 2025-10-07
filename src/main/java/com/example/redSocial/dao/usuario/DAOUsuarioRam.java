package com.example.redSocial.dao.usuario;

import com.example.redSocial.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DAOUsuarioRam implements DAOUsuario {
    List<Usuario> listaUsuarios;

    public DAOUsuarioRam(){
        this.listaUsuarios = new ArrayList<>();
    }

    @Override
    public List<Usuario> getUsuarios() {
        return this.listaUsuarios;
    }
}
