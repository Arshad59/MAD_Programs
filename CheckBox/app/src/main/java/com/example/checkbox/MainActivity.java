package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        CheckBox idli=findViewById(R.id.c1);
        CheckBox vada=findViewById(R.id.c2);
        CheckBox tea=findViewById(R.id.c3);
        CheckBox coffee=findViewById(R.id.c4);
        Button b=findViewById(R.id.button);
        TextView txtv=findViewById(R.id.txtv);
        Button b2 = findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtv.setText("");
                int total=0;
                StringBuilder result = new StringBuilder();
                result.append("\nOrdered items are:");
                if(idli.isChecked()){
                    total+=80;
                    result.append("\nIdli - 80rs");
                }
                if(vada.isChecked()){
                    total+=90;
                    result.append("\nvada - 90rs");
                }
                if(tea.isChecked()){
                    total+=20;
                    result.append("\ntea - 20rs");
                }
                if(coffee.isChecked()){
                    total+=30;
                    result.append("\ncoffee - 30rs");
                }
                result.append("\nTotal= "+total);
                txtv.append(result.toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtv.setText("");

            }
        });
    }
}