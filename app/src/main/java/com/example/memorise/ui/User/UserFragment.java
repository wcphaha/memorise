package com.example.memorise.ui.User;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.memorise.R;
import com.example.memorise.StaticVar.Variable;
import com.example.memorise.sql.DatabaseHelper;
import com.example.memorise.threads.UserPost;

public class UserFragment extends Fragment {

    public RequestQueue mQueue;//一个请求队列，发请求时，将请求添加进来
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    //调用系统相册-选择图片
    private static final int IMAGE = 1;
    private UserViewModel userViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        final ImageView headphoto = root.findViewById(R.id.headphoto);
        final TextView user_name = root.findViewById(R.id.user_name);
        final TextView sign = root.findViewById(R.id.sign);
        final EditText plan = root.findViewById(R.id.user_plan);
        final EditText email = root.findViewById(R.id.user_email);
        final EditText address = root.findViewById(R.id.user_address);
        final EditText sum = root.findViewById(R.id.user_sum);
        mQueue = Volley.newRequestQueue(getActivity());
        sum.setText(String.valueOf(Variable.user.sumvocab));
        email.setText(Variable.user.email);
        address.setText(Variable.user.address);
        user_name.setText(Variable.user.name);
        sign.setText(Variable.user.sign);
        plan.setText(String.valueOf(Variable.user.dayplan));

        headphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyStoragePermissions(getActivity());
                //调用相册
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE);
            }
        });
        sum.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    Toast.makeText(getActivity(),"不能作弊哦！",Toast.LENGTH_SHORT)
                            .show();
                }
                return true;
            }
        });
        plan.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    Variable.user.dayplan = Integer.valueOf(plan.getText().toString());
                    Toast.makeText(getActivity(),"修改成功",Toast.LENGTH_SHORT)
                            .show();
                }
                return true;
            }
        });
        Glide.with(this).load(Variable.user.headpath).into(headphoto);

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getActivity().getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
    }
    //加载图片
    private void showImage(String imaePath){
        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        ((ImageView)getActivity().findViewById(R.id.headphoto)).setImageBitmap(bm);
        //获取本地数据库
        DatabaseHelper databaseHelper = new DatabaseHelper(getContext(),"user4_db",null,1);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        //调用上传图片线程
        UserPost userPost = new UserPost(mQueue,bm,db);
        userPost.run();
    }
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

}