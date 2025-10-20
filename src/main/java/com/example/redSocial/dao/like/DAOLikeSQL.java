package com.example.redSocial.dao.like;

import com.example.redSocial.clases.Post;
import com.example.redSocial.dao.BDConnector;
import com.example.redSocial.dao.DAOFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOLikeSQL implements DAOLike {

    public void getLikes(List<Post> posts) {

        String consulta = "select idPost,count(idUser) as numLikes from UserPost_Likes group by idPost";

        String consultaNumColumnas = "usar tabla virtual";
        try {
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);

            ResultSet rs = statement.executeQuery();


            while (rs.next()) {
                for (Post p : posts){
                    if(p.getId() == rs.getInt("idPost")) {
                        p.setLikes(rs.getInt("numLikes"));
                        break;
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getLikeUnUser(int idUSer, int idPost) {
        boolean like = true;

        String consulta = "select idPost from UserPost_Likes where idUser like ? AND idPost like ?";

        try {
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);
            statement.setInt(1, idUSer);
            statement.setInt(2, idPost);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                like = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return like;
    }

    public void restarLike(int idUser, int idPost) {
        String consulta2 = "SET SQL_SAFE_UPDATES = 0";
        String consulta = "delete from UserPost_Likes where idUser like ? AND idPost like ?";

        try {
            PreparedStatement statement2 = BDConnector.getInstance().prepareStatement(consulta2);
            statement2.execute();

            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);
            statement.setInt(1, idUser);
            statement.setInt(2, idPost);
            statement.execute();


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
