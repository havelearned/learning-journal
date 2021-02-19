package com.yinghua.jilijili.ui.login;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.R;

public class Login_EmailFragment extends Fragment {
    ImageView login_email_back,login_email_breack;
    Button login_email_newUser;
    EditText login_email_name,login_email_password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login__email, container, false);
        inItView(view);

        Glide.with(getContext()).load("https://goss1.cfp.cn/creative/vcg/800/new/VCG211258357656.gif").into(login_email_back);





        //返回按钮
        ObjectAnimator.ofFloat(view.findViewById(R.id.login_email_breack), "scaleX", 3f, 0.2f).setDuration(2000).setRepeatCount(100);
        login_email_breack.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_EmailFragment_to_login_TickeyFragment));

        return view;
    }

    private void inItView(View view) {
        login_email_back=view.findViewById(R.id.login_email_back);
        login_email_password=view.findViewById(R.id.login_email_password);
        login_email_name=view.findViewById(R.id.login_email_name);
        login_email_newUser=view.findViewById(R.id.login_email_newUser);
        login_email_breack=view.findViewById(R.id.login_email_breack);
    }
}