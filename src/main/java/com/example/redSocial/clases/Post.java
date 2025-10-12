package com.example.redSocial.clases;

import java.time.LocalDate;
import java.util.Objects;

public class Post {
    public int id;
    public String descripcion;
    public LocalDate fechaPublicacion;
    public int likes;
    public int idUser;

    public Post(int id, String descripcion , LocalDate fechaPublicacion, int idUser) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.likes = 0;
        this.idUser = idUser;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public int getCreador() {
        return idUser;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public int getId(){
        return id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "descripcion='" + descripcion + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        Post post = (Post) o;
        return (post.descripcion).equals(this.descripcion);
    }
}