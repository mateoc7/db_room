package com.demo.db_room.Modelo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "users")
public class Usuario implements Serializable {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name")
    public String nombre;

    @ColumnInfo(name = "email")
    public String mail;

    @ColumnInfo(name = "phone")
    public String tel;

    public Usuario(int id, String nombre, String mail, String tel) {
        this.id = id;
        this.nombre = nombre;
        this.mail = mail;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
