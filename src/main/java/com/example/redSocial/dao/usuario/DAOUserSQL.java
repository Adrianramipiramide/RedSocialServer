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
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    @Override
    public Usuario crearUsuario(String nombre, String passw, String fechaNacimiento) {

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
}
