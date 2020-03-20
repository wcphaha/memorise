package com.example.memorise.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.memorise.R;
import com.example.memorise.StaticVar.Variable;
import com.example.memorise.sql.DatabaseHelper;
import com.example.memorise.threads.SaveUser;

public class update_sign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sign);
        getSupportActionBar().setTitle("修改签名");
        final EditText editText = findViewById(R.id.e_sign);
        final ImageButton btn = findViewById(R.id.upsign);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Variable.user.sign = editText.getText().toString();
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext(),"user4_db",null,1);
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                SaveUser saveUser = new SaveUser( db );
                saveUser.run();

                Toast.makeText(getApplicationContext(),"修改签名成功！",Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
