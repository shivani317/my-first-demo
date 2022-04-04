package com.app.demo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmpSecPageActivity extends Activity implements View.OnClickListener {
    private String CHANNEL_ID = "5";
    private CharSequence CHANNEL_NAME ="Notifications";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_sec_page);

        Intent intentObj = getIntent();
        String NameObj =intentObj.getStringExtra("Name");
        String CodeObj =intentObj.getStringExtra("Code");
        String AddressObj =intentObj.getStringExtra("Address");
        String ContactObj =intentObj.getStringExtra("Contact");

        TextView NameSec = findViewById(R.id.nameSec);
        TextView CodeSec = findViewById(R.id.codeSec);
        TextView AddressSec = findViewById(R.id.addressSec);
        TextView ContactSec = findViewById(R.id.contactSec);
        Button btnBack =findViewById(R.id.ButtonSec);
        btnBack.setOnClickListener(this);

        NameSec.setText(NameObj);
        CodeSec.setText(CodeObj);
        AddressSec.setText(AddressObj);
        ContactSec.setText(ContactObj);

    }

    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(EmpSecPageActivity.this,EmpformActivity.class);
//        startActivity(intent);
        int notificationId = (int) System.currentTimeMillis();
        NotificationManager notificationManager = null;
        Notification.Builder myBuilder;

        Intent intent = new Intent(getApplicationContext(),EmpformActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        if(notificationManager == null){
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel myChannel = notificationManager.getNotificationChannel(CHANNEL_ID);
            if (myChannel == null){
                myChannel = new NotificationChannel(CHANNEL_ID ,CHANNEL_NAME , importance);
                myChannel.setDescription("Channel_Description");
                myChannel.enableVibration(true);
                myChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200,400});
                notificationManager.createNotificationChannel(myChannel);
            }
            myBuilder = new Notification.Builder(EmpSecPageActivity.this, CHANNEL_ID);
            myBuilder.setContentTitle("Notification")
                    .setSmallIcon(R.drawable.androidlogo)
                    .setContentText("Employee Details submitted")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200,400})
                    .setDefaults(Notification.DEFAULT_ALL);
        }else{
            myBuilder = new Notification.Builder(EmpSecPageActivity.this);
            myBuilder.setContentTitle("Notification")
                    .setSmallIcon(R.drawable.androidlogo)
                    .setContentText("Employee Details submitted")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                  //  .setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200,400})
                    .setDefaults(Notification.DEFAULT_VIBRATE);

        }
        notificationManager.notify(100,myBuilder.build());
        finish();



    }
}