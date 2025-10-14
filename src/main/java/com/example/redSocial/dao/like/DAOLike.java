package com.example.redSocial.dao.like;

import com.example.redSocial.clases.Post;

import java.util.List;

public interface DAOLike {

    public void getLikes(List<Post> posts);
    public void sumarLike(int idUser, int idPost);
}
