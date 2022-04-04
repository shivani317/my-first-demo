package com.app.demo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class EmpDBRecord extends SQLiteOpenHelper {
    String EMP_NAME = "EMPNAME";
    String EMP_CODE ="EMPCODE";
    String EMP_CONTACT ="EMPCONTACT";
    String EMP_ADDRESS ="EMPADDRESS";
    String EMP_TABLE = "EMPTABLE";

    public EmpDBRecord(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String empTable = "Create table "+EMP_TABLE+" ("+EMP_NAME+" TEXT, "+EMP_CODE+" INTEGER,"+EMP_CONTACT+" INTEGER,"+EMP_ADDRESS+" VARCHAR)";
        Log.v("empTable", "" + empTable);
        sqLiteDatabase.execSQL(empTable);
    }

    public void empInfo(Context context , String iname,int icode ,int icontact ,String iaddress){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMP_NAME,iname);
        values.put(EMP_CODE,icode);
        values.put(EMP_CONTACT,icontact);
        values.put(EMP_ADDRESS,iaddress);
        long valueCount = sqLiteDatabase.insert(EMP_TABLE, null,values);
        Log.v("valueCount" , "" +valueCount);
        Toast.makeText(context , "Data saved" ,Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("Range")
    public void getEmpInfo(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String entry = "Select "+EMP_NAME+","+EMP_CODE+" ,"+EMP_CONTACT+","+EMP_ADDRESS+" From "+EMP_TABLE;
        Cursor cursor = sqLiteDatabase.rawQuery(entry,null);
        while (cursor.moveToNext()){
            Log.v("Employee" ,cursor.getString(cursor.getColumnIndex(EMP_NAME)) +"-"+ cursor.getString(cursor.getColumnIndex(EMP_CODE))
                    +"-"+cursor.getString(cursor.getColumnIndex(EMP_CONTACT)) +"-"+cursor.getString(cursor.getColumnIndex(EMP_ADDRESS)));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
