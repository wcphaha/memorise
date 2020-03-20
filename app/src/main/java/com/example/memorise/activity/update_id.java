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

public class update_id extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_id);
        getSupportActionBar().setTitle("修改昵称");
        final EditText editText = findViewById(R.id.e_id);
        final ImageButton btn = findViewById(R.id.upid);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Variable.user.islogin.compareTo("true") == 0){
                    Variable.user.name = editText.getText().toString();
                    DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext(),Variable.datebase,null,1);
                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                    SaveUser saveUser = new SaveUser( db );
                    saveUser.run();

                    Toast.makeText(getApplicationContext(),"修改昵称成功！",Toast.LENGTH_SHORT)
                            .show();

                }else {
                    Toast.makeText(getApplicationContext(),"先去登录吧！",Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
