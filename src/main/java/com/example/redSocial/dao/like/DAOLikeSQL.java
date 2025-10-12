package com.example.redSocial.dao.like;

import com.example.redSocial.dao.BDConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOLikeSQL implements DAOLike{

    public int getLikes() {
        int numLikes = 0;
        String consulta = "select * from UserPost_Likes";
        try {
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                numLikes++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numLikes;
    }

    public void sumarLike(int idUser, int idPost) {
//UN POST NO PUEDE TENER MAS DE UNA LIKE POR LA PK
        //TENGO QUE PONER QUE ME COJA EL IDUSER BIEN
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
