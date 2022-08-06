package com.demo.db_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.demo.db_room.Adapter.UserAdapter;
import com.demo.db_room.Database.AppDataBase;
import com.demo.db_room.Interface.UserDao;
import com.demo.db_room.Modelo.Usuario;

import java.util.List;

public class Gestionar extends AppCompatActivity {

    RecyclerView recycler_users;

    List<Usuario> usuarios;

    UserDao userDao;
    AppDataBase room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar);
        Init();

        room = Room
                .databaseBuilder(this, AppDataBase.class, "users")
                .build();

        userDao = room.userDao();

        Thread thread = new Thread(() -> usuarios = userDao.getAll());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Usuario u: usuarios) {
            System.out.println("TAG /:" + u.nombre);
        }

    }

    private void InitAdapter() {
        /*UserAdapter adapter = new UserAdapter(this, ref);
        recycler_users.setAdapter(adapter);
        recycler_users.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));*/
    }

    private void Init() {
        recycler_users = findViewById(R.id.recycler_users);
    }
}