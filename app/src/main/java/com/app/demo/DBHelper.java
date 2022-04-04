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

public class DBHelper extends SQLiteOpenHelper {
    String VNAME = "NAME";
    String VAGE = "AGE";
    String VADDRESS = "ADDRESS";
    String VUSER_TABLE = "USER_TABLE";


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name,factory,version );
    }
// ON CREATE METHOD HAS DATABASE INSTANCE i.e sqLiteDatabase , Line 29 has the query that do the execution for create table querry
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String userTable = "Create table "+VUSER_TABLE+ " ("+VNAME+" TEXT, "+VAGE+" INTEGER, "+VADDRESS+" VARCHAR)";
        Log.v("userTable", "" + userTable);
        sqLiteDatabase.execSQL(userTable);
    }

    public void userInfo(Context context ,String iname, int iage , String iaddress){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();   // contentValues is used to save all data in one column
        values.put(VNAME,iname);
        values.put(VAGE,iage);
        values.put(VADDRESS,iaddress);
        long valueCount = sqLiteDatabase.insert(VUSER_TABLE, null,values);
        Log.v("valueCount" , "" +valueCount);
        Toast.makeText(context, "Data saved" ,Toast.LENGTH_SHORT).show();
    }
    @SuppressLint("Range")
    public void getuserInfo(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String getquery = "SELECT "+VNAME+" ,"+VAGE+" ,"+VADDRESS+"  FROM " + VUSER_TABLE;
        Cursor cursor = sqLiteDatabase.rawQuery(getquery ,null);
        while (cursor.moveToNext()){
            Log.v("USER" ,cursor.getString(cursor.getColumnIndex(VNAME)) +"-"+
                   cursor.getString(cursor.getColumnIndex(VAGE)) +" - "+
                   cursor.getString(cursor.getColumnIndex(VADDRESS)));
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
