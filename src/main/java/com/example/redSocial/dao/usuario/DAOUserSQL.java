package com.example.redSocial.dao.usuario;

import com.example.redSocial.clases.Usuario;
import com.example.redSocial.dao.BDConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOUserSQL implements DAOUsuario{


    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();

        String consulta = "select * from User";
        try{
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Usuario user = new Usuario(LocalDate.parse(rs.getString("fechaNacimiento")), rs.getString("nombre"),rs.getString("passw"));
                listaUsuarios.add(user);
                System.out.println(user);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    @Override
    public Usuario crearUsuario(String nombre, String passw, String fechaNacimiento) {
        System.out.println(nombre);
        System.out.println(passw);
        System.out.println(fechaNacimiento);
        try{
            String consulta = "insert into User (nombre,passw,fechaNacimiento) values (?,?,?)";
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);
            statement.setString(1,nombre);
            statement.setString(2, passw);
            statement.setString(3, fechaNacimiento);
            statement.execute();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return null;
    }


    public int getIdUsuarioLogeado(String nombreUsuario){
        int idUsuario = 0;
        String consulta = "select id from User where nombre = ?";
        try{
            PreparedStatement statement = BDConnector.getInstance().prepareStatement(consulta);

            statement.setString(1,nombreUsuario);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                idUsuario = rs.getInt("id");
            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return idUsuario;
    }
}
