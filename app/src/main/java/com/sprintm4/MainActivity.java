package com.sprintm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageProfile;
    private Button buttonGoToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageProfile = findViewById(R.id.imageProfile);
        buttonGoToProfile = findViewById(R.id.buttonGoToProfile);

        // Glide Pic
        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Anonymous_emblem.svg/320px-Anonymous_emblem.svg.png") // Reemplaza con la URL de tu imagen
                .placeholder(R.drawable.profile_placeholder) // Imagen de placeholder
                .error(R.drawable.profile_error) // Imagen en caso de error
                .into(imageProfile);

        // ProfileActivity Button
        buttonGoToProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
