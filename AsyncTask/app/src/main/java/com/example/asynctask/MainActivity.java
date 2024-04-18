package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView t;
    ProgressBar p;
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
        b=findViewById(R.id.button);
        t=findViewById(R.id.textView);
        p=findViewById(R.id.progressBar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T t1 = new T();
                t1.execute("100");
            }
        });
    }
    class T extends AsyncTask<String,Integer,String>{
        @Override
        protected void onPreExecute(){super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings){
            int max=Integer.parseInt(strings[0]);
            int i=0;
            while(i<max)
            {
                try{
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                publishProgress(i);
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values)
        {
            p.setProgress(values[0]);
            t.setText(values[0].toString());
            super.onProgressUpdate(values);
        }
    }
}