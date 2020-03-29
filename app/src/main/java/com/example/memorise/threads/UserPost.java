package com.example.memorise.threads;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Base64;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.memorise.StaticVar.variable;
import com.example.memorise.sql.my_data_base;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * POST请求，更改头像线程
 */
public class UserPost extends Thread {
    public SQLiteDatabase db;
    public StringRequest stringRequest;
    public RequestQueue mQueue;
    public Bitmap bitmap;
    public FileInputStream fis;

    public UserPost(RequestQueue mQueue, Bitmap bitmap, SQLiteDatabase db) {
        this.mQueue = mQueue;
        this.bitmap = bitmap;
        this.db = db;
    }

    @Override
    public void run() {
        super.run();
        post();
    }

    void post() {
        String image = bitmapToBase64(bitmap);
        post_image(image);
    }

    public String bitmapToBase64(Bitmap bitmap) {
        // 实现第二步 Bitmap 转 Base64 的字节流
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                baos.flush();
                baos.close();
                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void post_image(final String image) {
        final my_data_base mdb = new my_data_base(db);
        stringRequest = new StringRequest(Request.Method.POST, "http://132.232.45.108:5000/liuyan/header", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 返回的参数 response
                //修改数据库
                //修改User变量
                variable.user.headpath = response;
                mdb.update("update user set headpath = '" + variable.user.headpath + "';");
                System.out.println("11111:" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 请求错误就会进入这里
                System.out.println("222222" + "啊啊啊啊啊");
            }
        }) {
            // 像服务器post提交参数的方法
            @Override
            protected Map<String, String> getParams() {
                // 在这里设置需要post的参数
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("imgData", image);
                return map;
            }
        };
        mQueue.add(stringRequest);
    }
}
