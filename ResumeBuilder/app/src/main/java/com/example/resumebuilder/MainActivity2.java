package com.example.resumebuilder;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewName, textViewEmail, textViewMobile, textViewGender, textViewQualification;
    ImageView imageViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewName = findViewById(R.id.name);
        textViewEmail = findViewById(R.id.email);
        textViewMobile = findViewById(R.id.phone);
        textViewGender = findViewById(R.id.gender);
        textViewQualification = findViewById(R.id.qualification);
        imageViewProfile = findViewById(R.id.imageView);
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String email = intent.getStringExtra("email");
            String mobile = intent.getStringExtra("mobile");
            String gender = intent.getStringExtra("gender");
            String qualification = intent.getStringExtra("qualification");
            // Set data to TextViews
            textViewName.setText("Name: " + name);
            textViewEmail.setText("Email Id: " + email);
            textViewMobile.setText("Mobile No: " + mobile);
            textViewGender.setText("Gender: " + gender);
            textViewQualification.setText("Qualification: " + qualification);
            // Set profile image
            Bitmap imageBitmap =
                    intent.getParcelableExtra("imageBitmap");
            if (imageBitmap != null) {
                imageViewProfile.setImageBitmap(imageBitmap);
            }
        }
    }
}