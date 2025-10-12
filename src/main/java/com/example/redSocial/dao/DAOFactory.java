package com.example.redSocial.dao;

import com.example.redSocial.dao.like.DAOLike;
import com.example.redSocial.dao.like.DAOLikeSQL;
import com.example.redSocial.dao.post.DAOPost;

import com.example.redSocial.dao.post.DAOPostSQL;
import com.example.redSocial.dao.usuario.DAOUserSQL;
import com.example.redSocial.dao.usuario.DAOUsuario;


public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOPost daoPost;
    private DAOUsuario daoUsuario;

    private DAOLike daoLike;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOPost getDaoPost() {
        if (this.daoPost == null) {
            daoPost = new DAOPostSQL();
        }
        return daoPost;
    }

    public DAOLike getDaoLike(){
        if (this.daoLike == null){
            daoLike = new DAOLikeSQL();
        }
        return daoLike;
    }

    public DAOUsuario getDaoUsuario() {
        if (this.daoUsuario == null) {
            this.daoUsuario = new DAOUserSQL();
        }
        return daoUsuario;
    }
}
