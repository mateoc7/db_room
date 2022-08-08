package com.demo.db_room;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.db_room.Adapter.UserAdapter;
import com.demo.db_room.Database.AgenteRoom;
import com.demo.db_room.Interface.UserDao;
import com.demo.db_room.Modelo.Usuario;

import java.util.List;

public class Gestionar extends AppCompatActivity {

    RecyclerView recycler_users;

    List<Usuario> usuarios;

    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar);
        Init();

        userDao = AgenteRoom.getRoom(this);

        Thread thread = new Thread(() -> usuarios = userDao.getAll());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        InitAdapter();

    }

    private void InitAdapter() {
        UserAdapter adapter = new UserAdapter(this, usuarios);
        recycler_users.setAdapter(adapter);
        recycler_users.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void Init() {
        recycler_users = findViewById(R.id.recycler_users);
    }
}