package com.demo.db_room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.db_room.Database.AgenteRoom;
import com.demo.db_room.Interface.UserDao;
import com.demo.db_room.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Registrar extends AppCompatActivity {

    EditText input_name, input_mail, input_phone, input_age;
    Button btn_send, btn_cancel;

    UserDao userDao;

    String[] apodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Init();

        userDao = AgenteRoom.getRoom(this);

        btn_send.setOnClickListener(v -> {
            if (validateFields()) {
                Thread thread = new Thread(() -> {
                    agregarUsuario(
                            input_name.getText().toString(),
                            input_mail.getText().toString(),
                            input_phone.getText().toString(),
                            Integer.parseInt(input_age.getText().toString()),
                            apodos
                    );

                    Log.i("TAG->Registrar->Size/:", String.valueOf(userDao.getAll().size()));
                });
                thread.start();
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
        input_age = findViewById(R.id.input_age);
        btn_send = findViewById(R.id.btn_send);
        btn_cancel = findViewById(R.id.btn_cancel);
        apodos = new String[] {"Juancho", "Mono", "Pipe"};
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

    private void agregarUsuario(String nombre, String correo, String tel, int edad, String[] apodos) {
        Usuario usuario = new Usuario(nombre, edad, correo, tel, apodos);
        userDao.insertAll(usuario);
    }
}