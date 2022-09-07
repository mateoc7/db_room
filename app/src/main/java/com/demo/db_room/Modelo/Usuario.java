package com.demo.db_room.Modelo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity(tableName = "users")
public class Usuario implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "edad")
    public int edad;

    @ColumnInfo(name = "correo_electronico")
    public String mail;

    @ColumnInfo(name = "telefono")
    public String tel;

    @ColumnInfo (name = "apodos")
    @TypeConverters(Converter.class)
    public String[] apodos;

    public Usuario(String nombre, int edad, String mail, String tel, String[] apodos) {
        this.nombre = nombre;
        this.edad = edad;
        this.mail = mail;
        this.tel = tel;
        this.apodos = apodos;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
