package com.example.google_registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class AdditionalInfoActivity extends AppCompatActivity {
    private EditText fullNameEdit, phoneNumberEdit, countryEdit;
    private MaterialButton continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_info);

        // Initialize views
        fullNameEdit = findViewById(R.id.fullName);
        phoneNumberEdit = findViewById(R.id.phoneNumber);
        countryEdit = findViewById(R.id.country);
        continueButton = findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = fullNameEdit.getText().toString();
                String phoneNumber = phoneNumberEdit.getText().toString();
                String country = countryEdit.getText().toString();

                if (fullName.isEmpty() || phoneNumber.isEmpty() || country.isEmpty()) {
                    Toast.makeText(AdditionalInfoActivity.this, 
                        "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Navigate to welcome page
                Intent intent = new Intent(AdditionalInfoActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
} 