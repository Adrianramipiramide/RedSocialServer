package com.example.redSocial.clases;

import java.time.LocalDate;
import java.util.Objects;

public class Post {
    public int id;
    public String descripcion;
    public LocalDate fechaPublicacion;

    // Añadir atributo de persona para poder hacer el filtrado y los likes
    //Añadir likes en el constructor con valor 0??

    public Post(int id, String descripcion , LocalDate fechaPublicacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
    }



    public String getDescripcion() {
        return descripcion;
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
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        Post post = (Post) o;
        return (post.descripcion).equals(this.descripcion);
    }
}