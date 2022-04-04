package com.app.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);

        DBHelper dbHelperObj = new DBHelper(DBActivity.this, "TRAINING_DB", null, 1);

        EditText nameV = findViewById(R.id.nameET);
        EditText ageV = findViewById(R.id.ageET);
        EditText addressV = findViewById(R.id.addressEt);
        Button savebtnV = findViewById(R.id.savebtn);
        savebtnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelperObj.userInfo(DBActivity.this, nameV.getText().toString(),
                        Integer.parseInt(ageV.getText().toString()),
                                                      addressV.getText().toString());
                        dbHelperObj.getuserInfo();

            }
        });
    }
}