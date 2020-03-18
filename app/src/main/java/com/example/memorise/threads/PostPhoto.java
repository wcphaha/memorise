package com.example.memorise.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.memorise.MainActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostPhoto extends Thread {
    public StringRequest stringRequest;
    public RequestQueue mQueue;
    public Bitmap bitmap;
    public FileInputStream fis;

    public PostPhoto(RequestQueue mQueue,Bitmap bitmap) {
        this.mQueue = mQueue;
        this.bitmap = bitmap;
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
        stringRequest = new StringRequest(Request.Method.POST, "请求地址", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 返回的json参数 response

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 请求错误就会进入这里
            }
        }) {
            // 像服务器post提交参数的方法
            @Override
            protected Map<String, String> getParams() {
                // 在这里设置需要post的参数
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("user_img", image);
                return map;
            }
        };
        mQueue.add(stringRequest);
    }
}
