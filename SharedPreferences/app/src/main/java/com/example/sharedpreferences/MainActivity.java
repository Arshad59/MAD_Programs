package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
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
    EditText e1,e2,e3;
    Button b1,b2,b3;
    public static final String MyPrefs="MyPrefs";
    public static final String Name="NameKey";
    public static final String Phone="phoneKey";
    public static final String Email="emailKey";
    SharedPreferences sp;
    SharedPreferences.Editor er;
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
        b1=(Button)findViewById( R.id.button );
        b2=(Button)findViewById( R.id.button2 );
        b3=(Button)findViewById( R.id.button3 );
        e1=(EditText)findViewById( R.id.e1 );
        e2=(EditText)findViewById( R.id.e2 );
        e3=(EditText)findViewById( R.id.e3 );
        sp=getSharedPreferences( MyPrefs,MODE_PRIVATE );
        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=e1.getText().toString();
                String phone=e2.getText().toString();
                String email=e3.getText().toString();
                SharedPreferences.Editor editor=sp.edit();
                editor.putString( Name,name );
                editor.putString( Phone,phone);
                editor.putString( Email,email );
                editor.commit();
                Toast.makeText( MainActivity.this,"thanks", Toast.LENGTH_SHORT ).show();
            }
        } );
        b2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                er=sp.edit();
                er.clear();
                er.commit();
            }
        } );
        b3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="Name-"+sp.getString(Name,null)+" Email-"+sp.getString( Email,null )+" Phone-"+sp.getString( Phone,null );

                Toast.makeText( MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
        } );
    }
}