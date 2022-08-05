package com.demo.db_room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.demo.db_room.Database.AppDataBase;
import com.demo.db_room.Interface.UserDao;
import com.demo.db_room.Modelo.Usuario;

public class Registrar extends AppCompatActivity {

    EditText input_name, input_mail, input_phone;
    Button btn_send, btn_cancel;

    UserDao userDao;
    AppDataBase room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Init();

        room = Room
                .databaseBuilder(this, AppDataBase.class, "users")
                .build();

        userDao = room.userDao();

        btn_send.setOnClickListener(v -> {
            if (validateFields()) {
                Thread thread = new Thread(() -> {
                    agregarUsuario();
                    Log.i("TAG", String.valueOf(userDao.getAll().size()));
                });
                thread.start();
                clearFields();
                returnClass();
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Campos requeridos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Init() {
        input_name = findViewById(R.id.input_name);
        input_mail = findViewById(R.id.input_mail);
        input_phone = findViewById(R.id.input_phone);
        btn_send = findViewById(R.id.btn_send);
        btn_cancel = findViewById(R.id.btn_cancel);
    }

    private boolean validateFields() {
        if (input_name.getText().toString().equals("") || input_name.getText().toString().trim().equals("")) {
            return false;
        } else if (input_mail.getText().toString().equals("") || input_mail.getText().toString().trim().equals("")) {
            return false;
        } else return !input_phone.getText().toString().equals("") && !input_phone.getText().toString().trim().equals("");
    }

    private void returnClass() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void clearFields() {
        input_name.setText("");
        input_mail.setText("");
        input_phone.setText("");
    }

    private void agregarUsuario() {
        Usuario usuario = new Usuario(
                input_name.getText().toString(),
                input_mail.getText().toString(),
                input_phone.getText().toString()
        );
        userDao.insertAll(usuario);
    }
}