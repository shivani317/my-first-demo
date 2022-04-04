package com.app.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligin);

        EditText userid = findViewById(R.id.ID_ET);
        EditText pass = findViewById(R.id.Pass_ET);
        Button saveBtn = findViewById(R.id.btnSave);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userid.getText().toString();
                String password = pass.getText().toString();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("TRAINING",0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username" ,username);
                editor.putString("password", password);
                editor.commit();
                Toast.makeText(LoginActivity.this, "Data Saved",Toast.LENGTH_LONG).show();

                Intent intent =new Intent(LoginActivity.this,LoginPageActivity.class);
                intent.putExtra("ID" ,userid.getText().toString());
                intent.putExtra("Password" ,pass.getText().toString());
                startActivity(intent);

            }
        });

    }
}