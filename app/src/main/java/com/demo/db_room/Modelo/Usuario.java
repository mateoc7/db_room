package com.demo.db_room.Modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String mail;
    private String tel;

    public Usuario(String nombre, String mail, String tel) {
        this.nombre = nombre;
        this.mail = mail;
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
