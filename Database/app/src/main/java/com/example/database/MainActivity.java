package com.example.database;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText n,a,addr;
    TextView t;

    Button insert,display;
    SQLiteDatabase db;
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
        n = findViewById(R.id.name);
        a = findViewById(R.id.age);
        addr = findViewById(R.id.address);
        t = findViewById(R.id.textView);
        insert = findViewById(R.id.button);
        display = findViewById(R.id.button2);
        insert.setOnClickListener(this);
        display.setOnClickListener(this);
    }
    @SuppressLint("Range")
    @Override
    public void onClick(View view){
        String name,age,address;
        name = n.getText().toString();
        age = a.getText().toString();
        address = addr.getText().toString();
        Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        try{
            db = this.openOrCreateDatabase("sample",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS TEST(name varchar(20),age varchar(10),address varchar(100))");
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
            if(view.getId()==insert.getId()){
                db.execSQL("INSERT INTO TEST VALUES('"+name+"','"+age+"','"+address+"')");
                Toast.makeText(this,"successfully inserted",Toast.LENGTH_SHORT).show();
            }
            if(view.getId()==display.getId()){
                String msg;
                msg = "Name\t Age\t Address\n";
                Cursor c = db.rawQuery("Select * from TEST",null);
                if(c!=null){
                    if(c.moveToFirst()){
                        do{
                            name = c.getString(c.getColumnIndex("name"));
                            age = c.getString(c.getColumnIndex("age"));
                            address = c.getString(c.getColumnIndex("address"));
                            msg = msg+name+'\t'+age+"\t"+address+"\n";
                        }while(c.moveToNext());
                    }
                }
                t.setText(msg);
            }
        }catch(SQLException e){
            System.out.println("Create failed");
        }finally {
            if(db!=null){
                db.close();
            }
        }
    }
}