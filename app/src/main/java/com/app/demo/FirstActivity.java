package com.app.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btn = findViewById(R.id.clickButton);
        EditText NaEt =findViewById(R.id.nameET);
        EditText SaEt =findViewById(R.id.salaryET);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("Name" ,NaEt.getText().toString());
                intent.putExtra("Salary" ,SaEt.getText().toString());
                        startActivity(intent);

            }
        });


    }
}