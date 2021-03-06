package com.example.memorise.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.memorise.R;
import com.example.memorise.StaticVar.variable;
import com.example.memorise.sql.database_helper;
import com.example.memorise.threads.InitData;
import com.example.memorise.threads.InitUser;
import com.example.memorise.threads.SaveData;
import com.example.memorise.threads.SaveUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class main_activity extends AppCompatActivity {

    private SearchView mSearchView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.title_menu, menu);
        initSearch(menu);
        return true;
    }

    /**
     * 初始化搜索框
     * @param menu
     */
    private void initSearch(Menu menu) {
        MenuItem searchItem = menu.findItem(R.id.menu_search_view);
        mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("search...");
        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {

                return false;
            }
        });

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //输入完毕后点击搜索按钮事件
                variable.search_vocab = s;
                Intent intent = new Intent(main_activity.this, web_activity.class);
                startActivity(intent);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                //搜索框变化监听事件

                return true;
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_set)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //////////!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //创建DatabaseHelper对象管理SQLITE数据库
        database_helper databasehelper = new database_helper(this, variable.datebase,null,1);
        SQLiteDatabase db = databasehelper.getWritableDatabase();//得到数据库对象
        //打开软件，调用InitData线程，从数据库初始化界面显示数据
        InitData initData = new InitData(db);
        initData.run();
        //打开软件，调用InitUser线程，从数据库初始化用户数据
        InitUser initUser = new InitUser(db);
        initUser.run();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //当软件处于onPause状态时，获取数据库对象
        database_helper databasehelper = new database_helper(this, variable.datebase,null,1);
        SQLiteDatabase db = databasehelper.getWritableDatabase();
        //调用SaveData线程，保存界面数据
        SaveData saveData = new SaveData(db);
        saveData.run();
        //调用SaveUser对象，保存用户数据
        SaveUser saveUser = new SaveUser(db);
        saveUser.run();
    }
}
