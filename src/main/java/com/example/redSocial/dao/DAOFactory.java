package com.example.redSocial.dao;
import com.example.redSocial.clases.Post;
import com.example.redSocial.dao.post.DAOPost;
import com.example.redSocial.dao.post.DAOPostRam;
import com.example.redSocial.dao.usuario.DAOUserSQL;
import com.example.redSocial.dao.usuario.DAOUsuario;


public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOPost daoPost;
    private DAOUsuario daoUsuario;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOPost getDaoPost(){
        if(this.daoPost == null){
            daoPost = new DAOPostRam();
        }
        return daoPost;
    }

    public DAOUsuario getDaoUsuario(){
        if(this.daoUsuario == null){
            this.daoUsuario = new DAOUserSQL();
        }
        return daoUsuario;
    }
}
