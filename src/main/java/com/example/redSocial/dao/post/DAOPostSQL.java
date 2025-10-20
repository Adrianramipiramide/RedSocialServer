package com.example.redSocial.dao.post;

import com.example.redSocial.clases.Post;
import com.example.redSocial.clases.Usuario;
import com.example.redSocial.dao.BDConnector;
import com.example.redSocial.dao.DAOFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOPostSQL implements DAOPost{


    @Override
    public List<Post> getPosts() {
        List<Post> listaPost = new ArrayList<>();
        String consulta = "select * from Post ";
        try{
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Post p = new Post(rs.getInt("id"),rs.getString("descripcion"), LocalDate.parse(rs.getString("fechaPublicacion")),rs.getInt("idUser"));
                listaPost.add(p);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }



        return listaPost;
    }

    @Override
    public Post crearPost(String descripcion, String fechaP, int idUser) {
        try{
                String consulta = "insert into Post (descripcion,fechaPublicacion,idUser) values (?,?,?)";
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,descripcion);
            statement.setString(2,fechaP);
            statement.setInt(3,idUser);
            statement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }



    @Override
    public void repostear(String descripcion, int idUser, String fechaPublicacion) {

       crearPost(descripcion,fechaPublicacion,idUser);

    }

    @Override
    public List<Post> filtrar(String descripcion) {
        List<Post> listaPost;
        listaPost = getPosts();
        ArrayList<Post> coincidencias = new ArrayList<>();
        for (Post p : listaPost) {
            if ((p.getDescripcion().toLowerCase()).contains(descripcion.toLowerCase())) {

                coincidencias.add(p);

            } else if ((p.getFechaPublicacion().toString()).equals(descripcion)) {
                coincidencias.add(p);
            }
        }
        return coincidencias;
    }


}
