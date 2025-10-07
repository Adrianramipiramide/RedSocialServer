package com.example.redSocial.dao.post;

import com.example.redSocial.clases.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOPostRam implements DAOPost{

    private List<Post> listaPost;

    public DAOPostRam(){
        this.listaPost = new ArrayList<>();
    }

    @Override
    public List<Post> getPosts() {
        return this.listaPost;
    }

    @Override
    public Post repostear(String descripcion,String creador, String fechaPublicacion) {


        int id = (int) (Math.random()*1000);
        Post p = new Post(id,descripcion, LocalDate.parse(fechaPublicacion), creador);
        listaPost.add(p);

        return p;
    }
}
