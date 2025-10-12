package com.example.redSocial.dao.like;

public interface DAOLike {

    public int getLikes();
    public void sumarLike(int idUser, int idPost);
}
