package com.example.redSocial.clases;

import java.time.LocalDate;
import java.util.Objects;

public class Post {
    public int id;
    public String descripcion;
    public int numLikes;
    public LocalDate fechaPublicacion;

    public Post(String descripcion, int id) {
        this.descripcion = descripcion;
        this.id = id;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "descripcion='" + descripcion + '\'' +
                ", numLikes=" + numLikes +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

}