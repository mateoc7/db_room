package com.demo.db_room.Interface;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.demo.db_room.Modelo.Usuario;

import java.util.List;

@Dao
public interface UserDao {

    //Create
    @Insert
    void insertAll(Usuario... usuarios);

    //Read
    @Query("SELECT * FROM users")
    List<Usuario> getAll();

    //Update
    @Update
    void updateUsers(Usuario... usuarios);

    //Delete
    @Delete
    void delete(Usuario usuario);

    //Pasar parametros simples a una consulta (búsqueda)
    @Query("SELECT * FROM users WHERE nombre = :ref")
    Usuario[] loadUsersSameName(String ref);

    //Devuelve los usuarios que tienen menos de 18 años
    @Query("SELECT * FROM users WHERE edad < 18")
    List<Usuario> userYoung();

    //Devuelve los usuarios que tienen mas de 18 años
    @Query("SELECT * FROM users WHERE edad >= 18")
    List<Usuario> userAdult();

}
