package com.example.google_registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEdit, passwordEdit;
    private MaterialButton signUpButton, signInButton;
    private ImageView googleIcon, microsoftIcon, facebookIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        usernameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);
        signUpButton = findViewById(R.id.signupbtn);
        signInButton = findViewById(R.id.signinbtn);
        googleIcon = findViewById(R.id.google_icon);
        microsoftIcon = findViewById(R.id.microsoft_icon);
        facebookIcon = findViewById(R.id.facebook_icon);

        // Set up click listeners
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                // Navigate to additional info page
                Intent intent = new Intent(MainActivity.this, AdditionalInfoActivity.class);
                startActivity(intent);
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                // Navigate directly to welcome page for sign in
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        View.OnClickListener socialClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String provider = "";
                if (v.getId() == R.id.google_icon) {
                    provider = "Google";
                } else if (v.getId() == R.id.microsoft_icon) {
                    provider = "Microsoft";
                } else if (v.getId() == R.id.facebook_icon) {
                    provider = "Facebook";
                }
                
                // Navigate to welcome page for social login
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        };

        googleIcon.setOnClickListener(socialClickListener);
        microsoftIcon.setOnClickListener(socialClickListener);
        facebookIcon.setOnClickListener(socialClickListener);
    }
}
