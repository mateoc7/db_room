package com.demo.db_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_agg, btn_gestionar, btn_adult, btn_guy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_agg = findViewById(R.id.btn_agg);
        btn_gestionar = findViewById(R.id.btn_gestionar);
        btn_adult = findViewById(R.id.btn_adult);
        btn_guy = findViewById(R.id.btn_guy);

        btn_agg.setOnClickListener(view -> runIntent(Registrar.class, view.getId()));

        btn_gestionar.setOnClickListener(view -> runIntent(Gestionar.class, view.getId()));

        btn_adult.setOnClickListener(view -> runIntent(Gestionar.class, view.getId()));

        btn_guy.setOnClickListener(view -> runIntent(Gestionar.class, view.getId()));

    }

    private void runIntent(Class c, int btn) {
        Log.i("id btn/", String.valueOf(btn));
        Intent i = new Intent(this, c);
        i.putExtra("ref", btn);
        startActivity(i);
    }


}