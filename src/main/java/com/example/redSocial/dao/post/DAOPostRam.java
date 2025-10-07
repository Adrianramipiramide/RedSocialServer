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

    @Override
    public List<Post> filtrar(String descripcion) {


        ArrayList<Post> coincidencias = new ArrayList<>();


        for (Post p : listaPost) {
            if ((p.getDescripcion().toLowerCase()).contains(descripcion.toLowerCase())) {

                coincidencias.add(p);

            } else if ((p.getFechaPublicacion().toString()).equals(descripcion)) {
                coincidencias.add(p);
            } else if ((p.getCreador().toLowerCase()).contains(descripcion.toLowerCase())) {
                coincidencias.add(p);
            } else {
                System.out.println("No se ha encontrado un post que coincida");
            }
        }
        return coincidencias;

    }

    @Override
    public void darLike(String id) {
        try {
            for (Post p : listaPost) {
                if (p.getId() == Integer.parseInt(id)) {
                    p.setLikes(p.getLikes() + 1);
                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
