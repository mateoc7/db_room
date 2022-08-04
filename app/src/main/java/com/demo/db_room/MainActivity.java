package com.demo.db_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_agg, btn_gestionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_agg = findViewById(R.id.btn_agg);
        btn_gestionar = findViewById(R.id.btn_gestionar);

        btn_agg.setOnClickListener(view -> {
            runIntent(Registrar.class);
        });

        btn_gestionar.setOnClickListener(view -> {
            runIntent(Gestionar.class);
        });

    }

    private void runIntent(Class c) {
        Intent i = new Intent(this, c);
        startActivity(i);
    }


}