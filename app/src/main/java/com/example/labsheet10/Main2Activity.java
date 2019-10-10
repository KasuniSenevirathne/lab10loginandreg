package com.example.labsheet10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import Database.DBHelper;
import Database.Usermaster;

public class Main2Activity extends AppCompatActivity {
    EditText UserName,Password;
    Button Register;
    RadioButton Rteacher;
    RadioButton  Rstudent;
    DBHelper Db;
    String name, password, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        UserName = (EditText)findViewById(R.id.editTextUname);
        Password = (EditText)findViewById(R.id.eTextPassword);
        Register = (Button)findViewById(R.id.btnRegister);
        Rteacher = (RadioButton)findViewById(R.id.radioButtonT);
        Rstudent = (RadioButton)findViewById(R.id.radioButtonS);
        Db = new DBHelper(this);
    }
    public void AddInfo(View view){
        name = UserName.getText().toString();
        password = Password.getText().toString();
        if((Rteacher.isChecked() == true) &&(Rstudent.isChecked() == false)){
            type = ("teacher");
        }
        else if ((Rstudent.isChecked() == true) &&(Rteacher.isChecked() == false)){
            type = ("student");}
        boolean data = Db.AddData(name,password,type);
        if(data ==true){
            Toast.makeText(getApplicationContext(),"Data addded",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
    }

}
