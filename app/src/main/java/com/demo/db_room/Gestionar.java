package com.demo.db_room;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.db_room.Adapter.UserAdapter;
import com.demo.db_room.Database.AgenteRoom;
import com.demo.db_room.Interface.Listener;
import com.demo.db_room.Interface.UserDao;
import com.demo.db_room.Modelo.Usuario;
import com.demo.db_room.Utilities.Utility;

import java.util.List;

public class Gestionar extends AppCompatActivity implements Listener {

    RecyclerView recycler_users;
    Dialog dialog;

    List<Usuario> usuarios;
    Usuario usuario;
    UserAdapter adapter;

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
        adapter = new UserAdapter(this, usuarios, this);
        recycler_users.setAdapter(adapter);
        recycler_users.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void Init() {
        recycler_users = findViewById(R.id.recycler_users);
    }

    @Override
    public synchronized void editUser(int id, int idObj) {
        Log.i("id Edit/", String.valueOf(id));
        usuario = usuarios.get(idObj);
        dialog = Utility.dialogEditUser(this, R.layout.resource_edit_user, usuario);

        EditText input_new_name = dialog.findViewById(R.id.input_new_name);
        EditText input_new_age = dialog.findViewById(R.id.input_new_age);
        EditText input_new_mail = dialog.findViewById(R.id.input_new_mail);
        EditText input_new_phone = dialog.findViewById(R.id.input_new_phone);

        dialog.findViewById(R.id.btn_actualizar).setOnClickListener(v -> {

            usuario.setNombre(input_new_name.getText().toString());
            usuario.setEdad(Integer.parseInt(input_new_age.getText().toString()));
            usuario.setMail(input_new_mail.getText().toString());
            usuario.setTel(input_new_phone.getText().toString());

            new Thread(() -> userDao.updateUsers(usuario)).start();

            dialog.dismiss();

            adapter.notifyDataSetChanged();
        });
        dialog.findViewById(R.id.btn_cancel_act).setOnClickListener(v -> dialog.dismiss());
    }

    @Override
    public synchronized void deleteUser(int id, int idObj) {
        Log.i("id Delete/", String.valueOf(id));
        usuario = usuarios.get(idObj);
        dialog = Utility.centeSmallDialog(this, R.layout.resource_delete_user, usuario);

        dialog.findViewById(R.id.btn_aceptar_del).setOnClickListener(v -> {

            new Thread(() -> userDao.delete(usuario)).start();

            dialog.dismiss();

            usuarios.remove(idObj);
            adapter.notifyDataSetChanged();
        });

        dialog.findViewById(R.id.btn_cancel_del).setOnClickListener(v -> dialog.dismiss());
    }
}