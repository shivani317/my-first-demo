package com.app.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView data = findViewById(R.id.userIDSec);
        TextView dataB = findViewById(R.id.passSec);


        Intent intentObj = getIntent();
        String userIDObj = intentObj.getStringExtra("ID");
        String passObj = intentObj.getStringExtra("Password");
        data.setText(userIDObj);
        dataB.setText(passObj);
        Button showBtn = findViewById(R.id.btnShow);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("TRAINING",0);
//                String data1 = sharedPreferences.getString("data", String.valueOf(data));
//                String data2 = sharedPreferences.getString("data", String.valueOf(dataB));
//                showBtn.setText("data1");
            }
        });
    }
}