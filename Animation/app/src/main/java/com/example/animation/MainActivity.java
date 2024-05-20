package com.example.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button zoom,rotate,move,blink;
    ImageView img;
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
        img = findViewById(R.id.imageView);
        zoom = findViewById(R.id.zoom);
        blink = findViewById(R.id.blink);
        rotate = findViewById(R.id.rotate);
        move = findViewById(R.id.move);

        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                img.startAnimation(ani);
            }
        });
        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                img.startAnimation(ani);
            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                img.startAnimation(ani);
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                img.startAnimation(ani);
            }
        });
    }
}