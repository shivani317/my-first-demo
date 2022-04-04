package com.app.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmpformActivity extends Activity {


    EmpDBRecord empdbObj = new EmpDBRecord(EmpformActivity.this, "Emp_Data",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empform);

        Button btnsave = findViewById(R.id.saveBtn);
        Button btcancel = findViewById(R.id.cancelBtn);
        EditText naET = findViewById(R.id.nameET);
        EditText cdET = findViewById(R.id.codeET);
        EditText addET = findViewById(R.id.addressET);
        EditText conET = findViewById(R.id.contactET);

        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(naET.getText().toString().length()==0){
                    Toast.makeText(EmpformActivity.this, "NAME Cannot be blank" ,Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(EmpformActivity.this, EmpSecPageActivity.class);
                intent.putExtra("Name", naET.getText().toString());
                intent.putExtra("Code", cdET.getText().toString());
                intent.putExtra("Address", addET.getText().toString());
                intent.putExtra("Contact", conET.getText().toString());
                startActivity(intent);

                empdbObj.empInfo(EmpformActivity.this, naET.getText().toString(),
                        Integer.parseInt(cdET.getText().toString()),Integer.parseInt(conET.getText().toString()),
                        addET.getText().toString());
                empdbObj.getEmpInfo();

                Toast.makeText(EmpformActivity.this, "Something", Toast.LENGTH_LONG).show();
            }


        });
    }
}



//    @Override
//    public void onClick(View view){
//            Intent intent = new Intent(EmpformActivity.this, EmpSecPageActivity.class);
//            intent.putExtra("Name", naET.getText().toString());
//            intent.putExtra("Code", cdET.getText().toString());
//            intent.putExtra("Address", addET.getText().toString());
//            intent.putExtra("Contact", conET.getText().toString());
//            startActivity(intent);
//
//    }
//}