package com.example.redSocial.dao.usuario;

import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface DAOUsuario {

    public List<Usuario> getUsuarios();

    public Usuario crearUsuario(String nombre, String passw, String fechaNacimiento);

    public int getIdUsuarioLogeado(String nombreUsuario);




}
