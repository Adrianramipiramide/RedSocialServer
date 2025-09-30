package com.example.redSocial.clases;


import java.time.LocalDate;

public class Usuario {
    public LocalDate fechaNacimiento;
    public String nombreUsuario;
    public String password;


    public Usuario(LocalDate fechaNacimiento, String nombreUsuario, String password) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }


    public LocalDate getFechaNacimiento() {
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
}