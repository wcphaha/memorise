package com.example.memorise.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.memorise.R;
import com.example.memorise.StaticVar.variable;
import com.example.memorise.sql.database_helper;
import com.example.memorise.threads.SaveUser;

public class update_email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_email);
        getSupportActionBar().setTitle("修改邮箱");

        final EditText editText = findViewById(R.id.e_email);
        final ImageButton btn = findViewById(R.id.upemail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (variable.user.islogin.compareTo("true") == 0) {
                    //原理和update_address.java一样
                    variable.user.email = editText.getText().toString();
                    database_helper databasehelper = new database_helper(getApplicationContext(), variable.datebase, null, 1);
                    SQLiteDatabase db = databasehelper.getWritableDatabase();
                    SaveUser saveUser = new SaveUser(db);
                    saveUser.run();

                    Toast.makeText(getApplicationContext(), "修改邮箱成功！", Toast.LENGTH_SHORT)
                            .show();
                }else {
                    Toast.makeText(getApplicationContext(), "先去登录吧！", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

    }
}
