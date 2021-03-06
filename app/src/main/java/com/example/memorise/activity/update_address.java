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

public class update_address extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);
        getSupportActionBar().setTitle("修改地址");

        final EditText editText = findViewById(R.id.e_address);
        final ImageButton btn = findViewById(R.id.upaddress);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先判断用户是否处于登录状态，是则修改，不是则发出提示
                if (variable.user.islogin.compareTo("true") == 0){
                    //修改内容
                    variable.user.address = editText.getText().toString();
                    //获取数据库
                    database_helper databasehelper = new database_helper(getApplicationContext(), variable.datebase,null,1);
                    SQLiteDatabase db = databasehelper.getWritableDatabase();
                    //主动调用SaveUser线程，保存修改后的数据
                    SaveUser saveUser = new SaveUser( db );
                    saveUser.run();
                    //提示
                    Toast.makeText(getApplicationContext(),"修改地址成功！",Toast.LENGTH_SHORT)
                            .show();
                }else {
                    Toast.makeText(getApplicationContext(),"先去登录吧！",Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
