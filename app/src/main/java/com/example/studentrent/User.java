package com.example.studentrent;

import java.io.Serializable;

public class User implements Serializable {
    String user;
    String password;
    String email;
    String phoneNumber;

    public static class usuario {
    }
    public String getUsuario() {
        return user;
    }

    public void setUsuario(String usuario) {
        this.user = user;
    }

    public String getContrasinal() {
        return password;
    }

    public void setContrasinal(String contrasinal) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}