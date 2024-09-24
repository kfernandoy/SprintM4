package com.sprintm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    private Button buttonLinkedIn;
    private Button buttonWhatsApp;
    private Button buttonEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        buttonLinkedIn = findViewById(R.id.buttonLinkedIn);
        buttonWhatsApp = findViewById(R.id.buttonWhatsApp);
        buttonEmail = findViewById(R.id.buttonEmail);

        // LinkedIn
        buttonLinkedIn.setOnClickListener(v -> {
            Intent linkedInIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/kfernandoy/"));
            startActivity(linkedInIntent);
        });

        // WhatsApp
        buttonWhatsApp.setOnClickListener(v -> {
            String phoneNumberWithCountryCode = "56945953996";  // Phone number
            String message = "Hello world!";  // Default message

            Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
            whatsappIntent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumberWithCountryCode + "&text=" + Uri.encode(message)));

            try {
                // Try opening WhatsApp
                startActivity(whatsappIntent);
            } catch (Exception e) {
                e.printStackTrace();
                // If WhatsApp not installed go to browser instead
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumberWithCountryCode + "&text=" + Uri.encode(message)));
                startActivity(browserIntent);
            }
        });

        // Email
        buttonEmail.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:k.fernandoy@gmail.com"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del mensaje");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Cuerpo del mensaje");
            startActivity(emailIntent);
        });
    }
}

