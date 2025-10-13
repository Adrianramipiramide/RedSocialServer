package com.example.redSocial.dao.like;

import com.example.redSocial.clases.Post;
import com.example.redSocial.dao.BDConnector;
import com.example.redSocial.dao.DAOFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOLikeSQL implements DAOLike {

    public void getLikes() {

        List<Post> listaP = DAOFactory.getInstance().getDaoPost().getPosts().stream().toList();



        String consulta = "select idPost,count(idUser) from UserPost_Likes group by idPost";
        try {
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);

            ResultSet rs = statement.executeQuery();
            int contador = 0;
            while (rs.next()) {
//porque no me hace el set likes
                listaP.get(contador).setLikes(rs.getInt(2));
                contador++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sumarLike(int idUser, int idPost) {

        String consulta = "insert into UserPost_Likes (idUser, idPost) values (?,?)";

        try {
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);
            statement.setInt(1, idUser);
            statement.setInt(2, idPost);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
