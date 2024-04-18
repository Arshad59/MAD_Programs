package com.example.music_service;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button start,stop,color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        start = findViewById(R.id.start);
        color=findViewById(R.id.color);
        stop = findViewById(R.id.stop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(),MyService.class));
            }
        });

        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                stopService(new Intent(getApplicationContext(),MyService.class));
            }
        });
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout l = findViewById(R.id.main);
                Random rand = new Random();
                l.setBackgroundColor(Color.rgb(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
            }
        });
    }
}