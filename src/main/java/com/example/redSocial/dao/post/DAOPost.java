package com.example.redSocial.dao.post;

import com.example.redSocial.clases.Post;

import java.util.List;

public interface DAOPost {

    public List<Post> getPosts();

    public Post crearPost(String descripcion,String fechaP, int creador);

    public void repostear(String descripcion,int idUser, String fechaPublicacion);

    public List<Post> filtrar(String descripcion);




}
