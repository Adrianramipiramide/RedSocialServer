package com.example.redSocial.clases;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    public String descripcion;
    public int numLikes;
    public LocalDate fechaPublicacion;

    public Post(String descripcion, int numLikes, LocalDate fechaPublicacion) {
        this.descripcion = descripcion;
        this.numLikes = numLikes;
        this.fechaPublicacion = fechaPublicacion;
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

    @Override
    public String toString() {
        return "Post{" +
                "descripcion='" + descripcion + '\'' +
                ", numLikes=" + numLikes +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, numLikes, fechaPublicacion);
    }
}