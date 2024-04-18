package com.example.resumebuilder;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextEmail, editTextMobile,editTextQualification;
    RadioGroup radioGroupGender;
    RadioButton radioButtonMale, radioButtonFemale;
    Button buttonNext, buttonSelectImage;
    ImageView imageViewProfile;
    Bitmap imageBitmap;
    static final int REQUEST_IMAGE_CAPTURE = 1;
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
        editTextName = findViewById(R.id.editTextText);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextMobile = findViewById(R.id.editTextPhone);
        editTextQualification = findViewById(R.id.editTextTextQualification);
        radioGroupGender = findViewById(R.id.gender);
        radioButtonMale = findViewById(R.id.male);
        radioButtonFemale = findViewById(R.id.female);
        buttonNext = findViewById(R.id.button);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        buttonSelectImage = findViewById(R.id.button2);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user inputs
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String mobile = editTextMobile.getText().toString().trim();
                String qualification = editTextQualification.getText().toString().trim();
                String gender = radioButtonMale.isChecked() ? "Male" : "Female";
                // Pass data to PreviewActivity
                // Pass data to MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("mobile", mobile);
                intent.putExtra("qualification", qualification);
                intent.putExtra("gender", gender);
                intent.putExtra("imageBitmap", imageBitmap);
                startActivity(intent);
            }
        });
        buttonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 1);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if (requestCode == 1 && resultCode == RESULT_OK) {
                assert data != null;
                Bundle extras = data.getExtras();
                assert extras != null;
                imageBitmap = (Bitmap) extras.get("data");
                imageViewProfile.setImageBitmap(imageBitmap);
            }
            super.onActivityResult(requestCode, resultCode, data);


        }
}