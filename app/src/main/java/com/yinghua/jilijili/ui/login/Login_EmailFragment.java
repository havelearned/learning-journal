package com.yinghua.jilijili.ui.login;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.MainActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.Email;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;
import com.yinghua.jilijili.utily.CountDownTimerUtils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_EmailFragment extends Fragment {
    ImageView login_email_back, login_email_breack;//背景图片，返回按钮
    Button login_email_newUser, login_email_Verification; //邮箱登录按钮，获取验证码按钮；
    EditText login_email_name, login_email_password;//邮箱输入框，验证码
    int emailChecked;//有效验证码
    String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";//邮箱正则表达式

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login__email, container, false);
        //获取控件
        inItView(view);

        //背景图片 ，网络加载
        Glide.with(getContext()).load("https://goss1.cfp.cn/creative/vcg/800/new/VCG211258357656.gif").into(login_email_back);

        //初始化邮箱表达式验证
        Pattern compile = Pattern.compile(check);//

        //发送验证码
        sendEmailCode(compile);

        //邮箱登录前 检测
        loginEmail(compile);
        //返回按钮
        breakAnim(view);
        return view;
    }

    private void breakAnim(View view) {
        ObjectAnimator.ofFloat(view.findViewById(R.id.login_email_breack), "scaleX", 3f, 0.2f).setDuration(2000).setRepeatCount(100);
        login_email_breack.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_EmailFragment_to_login_TickeyFragment));
        
    }

    private void sendEmailCode(Pattern compile) {
        login_email_Verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email_name.getText().toString();
                Matcher matcher = compile.matcher(email);
                if (matcher.matches()) {    //是否是一个合法的邮箱
                    Toast.makeText(getContext(), "验证码已发送", Toast.LENGTH_SHORT).show();
                    String emailCode = login_email_password.getText().toString();
                    MoviesRetrofitClient
                            .getInstance()
                            .ticketService()
                            .requesEmailtLogin(email,emailCode)
                            .enqueue(new Callback<Integer>() {
                                @Override
                                public void onResponse(Call<Integer> call, Response<Integer> response) {
                                    if(response.code()==200){
                                        emailChecked  = response.body();
                                        Log.e(Consts.TAG, "Login_EmailFragment_请求成功：" + response.raw()+"\n" +
                                                emailChecked);
                                    }else{
                                        Log.e(Consts.TAG, "Login_EmailFragment_请求失败：" + response.raw());
                                    }

                                }
                                @Override
                                public void onFailure(Call<Integer> call, Throwable t) {
                                    Log.e(Consts.TAG, "Login_EmailFragment_请求失败：" + t.getMessage());
                                }
                            });
                    CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(60000, 1000, login_email_Verification);
                    countDownTimerUtils.start();
                } else {
                    Toast.makeText(getContext(), "不合法的邮箱", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginEmail(Pattern compile) {
        login_email_newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email_name.getText().toString();
                Matcher matcher = compile.matcher(email);
                if (matcher.matches()) {    //是否是一个合法的邮箱
                    String emailcode = login_email_password.getText().toString();
                    if (emailcode.equals(String.valueOf(emailChecked))) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    } else {
                        Toast.makeText(getContext(), "验证码错误!请查看邮箱", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "不合法的邮箱", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inItView(View view) {
        login_email_Verification = view.findViewById(R.id.login_email_Verification);
        login_email_back = view.findViewById(R.id.login_email_back);
        login_email_password = view.findViewById(R.id.login_email_password);
        login_email_name = view.findViewById(R.id.login_email_name);
        login_email_newUser = view.findViewById(R.id.login_email_newUser);
        login_email_breack = view.findViewById(R.id.login_email_breack);
    }



}