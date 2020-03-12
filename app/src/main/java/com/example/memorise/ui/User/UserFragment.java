package com.example.memorise.ui.User;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.memorise.R;
import com.example.memorise.StaticVar.Variable;

public class UserFragment extends Fragment {

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
        user_name.setText(Variable.user.name);
        sign.setText(Variable.user.sign);
        plan.setText(String.valueOf(Variable.user.dayplan));

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
}