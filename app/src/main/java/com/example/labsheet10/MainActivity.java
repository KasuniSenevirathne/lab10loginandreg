package com.example.labsheet10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHelper;
import Database.Usermaster;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button Login;
    Button Register;
    Cursor cursor;
    SQLiteDatabase db;
    SQLiteOpenHelper OpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        OpenHelper = new DBHelper(this);
        db = OpenHelper.getReadableDatabase();
        username = (EditText)findViewById(R.id.editTextUn);
        password = (EditText)findViewById(R.id.editTextPw);
        Login = (Button)findViewById(R.id.BtLogin);
        Register = (Button)findViewById(R.id.BtRegister);

    }
    public void send(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
    public  void Login(View view){
        String inputUserName = username.getText().toString();
        String inputPassword = password.getText().toString();
        cursor = db.rawQuery("SELECT * FROM " + Usermaster.UseEntery.TABLE_NAME + " where " + Usermaster.UseEntery.COL_NAME1 + " =? AND " + Usermaster.UseEntery.COL_NAME2 + "=?", new String[]{inputUserName,inputPassword});
        if(cursor !=null){
            if(cursor.getCount() > 0){
                cursor.moveToNext();
                Toast.makeText(getApplicationContext(),"login" ,Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getApplicationContext(),"Error" ,Toast.LENGTH_SHORT).show();
        }

    }
//    public void ValidateUser(String inputUserName, String inputPassword, Context applicationContext){
//        DBHelper dpHelper = new DBHelper(getApplicationContext());
//        SQLiteDatabase db = dpHelper.getReadableDatabase();
//
//        String [] projection = {BaseColumns._ID, Usermaster.UseEntery.COL_NAME1, Usermaster.UseEntery.COL_NAME2, Usermaster.UseEntery.COL_NAME3};
//        String selection = Usermaster.UseEntery.COL_NAME1 + " =? AND " + Usermaster.UseEntery.COL_NAME2 + " =?";
//        String[]selectionargs = {inputUserName, inputPassword};
//
//        Cursor cursor  = db.query(Usermaster.UseEntery.TABLE_NAME,projection,selection,selectionargs,null,null,null);
//
//        Intent i = new Intent(this,student.class);
//        startActivity(i);
//    }

}
