package com.example.sms;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Button b = findViewById(R.id.button);
        EditText num = findViewById(R.id.editTextPhone);
        EditText msg = findViewById(R.id.editTextText);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = num.getText().toString();
                String message = msg.getText().toString();
                try{
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,message,null,null);
                    Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Unable to send message",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}