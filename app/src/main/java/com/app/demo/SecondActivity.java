package com.app.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intentObj = getIntent();
        String NameObj = intentObj.getStringExtra("Name");
        String SalaryObj = intentObj.getStringExtra("Salary");

        TextView nameSec = findViewById(R.id.nameSec );
        TextView salarySec = findViewById(R.id.salarySec);
        nameSec.setText(NameObj);
        salarySec.setText(SalaryObj);
        Button btn = findViewById(R.id.clickButtonSecond);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(intent);
                // Or
                 // finish();
            }
        });
    }
}