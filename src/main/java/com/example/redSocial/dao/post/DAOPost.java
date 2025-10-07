package com.example.redSocial.dao.post;

import com.example.redSocial.clases.Post;

import java.util.List;

public interface DAOPost {

    public List<Post> getPosts();

    public Post repostear(String descripcion,String creador, String fechaPublicacion);

    public List<Post> filtrar(String descripcion);

    public void darLike(String id);


}
