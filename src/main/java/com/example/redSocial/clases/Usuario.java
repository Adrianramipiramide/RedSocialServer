package com.example.redSocial.clases;
import java.time.LocalDate;
import java.util.Date;

public class Usuario {
    public int id;
    public Date fechaNacimiento;
    public String nombreUsuario;
    public String password;


    public Usuario(Date fechaNacimiento, String nombreUsuario, String password) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "fechaNacimiento=" + fechaNacimiento +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Usuario usuario = (Usuario) obj;
        return ((usuario.nombreUsuario.equals(this.nombreUsuario)) & (usuario.password.equals(this.password)));
    }
}