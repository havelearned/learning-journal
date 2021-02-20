package com.yinghua.jilijili.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Message;
import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yinghua.jilijili.R;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login_RegFragment extends Fragment implements View.OnClickListener {
    ImageButton login_breakLogin;
    Button to_email, reg__succeed;
    EditText et_reg_nickname, et_reg_pass, et_reg_tel;
    RadioGroup reg_userSex;
    String sex = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login__reg, container, false);
        inItView(view);

        login_breakLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_RegFragment_to_login_TickeyFragment));
        to_email.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_RegFragment_to_login_EmailFragment));
        onDestroy();
        reg__succeed.setOnClickListener(this);
        return view;
    }

    private void inItView(View view) {
        et_reg_nickname = view.findViewById(R.id.et_reg_nickname);
        login_breakLogin = view.findViewById(R.id.login_breakLogin);
        to_email = view.findViewById(R.id.to_email);
        reg__succeed = view.findViewById(R.id.reg__succeed);
        et_reg_pass = view.findViewById(R.id.et_reg_pass);
        et_reg_tel = view.findViewById(R.id.et_reg_tel);
        reg_userSex = view.findViewById(R.id.reg_userSex);
        reg_userSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == 2) {
                    sex = "女";
                } else if (checkedId == 1) {
                    sex = "男";
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        String nickname = et_reg_nickname.getText().toString().trim();
        if (nickname.length() < 1 || nickname.length() > 6) {
            Toast.makeText(getContext(), "昵称不符合", Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "手机号不符合", Toast.LENGTH_SHORT).show();
            return;
        }


        String pass = et_reg_pass.getText().toString().trim();
        if (pass.length() < 6 || pass.length() > 16) {
            Toast.makeText(getContext(), "密码不符合", Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "手机号不符合", Toast.LENGTH_SHORT).show();
            return;
        }

        if (sex.equals("")) {
            Toast.makeText(getContext(), "性别：不符合", Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "手机号不符合", Toast.LENGTH_SHORT).show();
            return;
        }

        String tel = et_reg_tel.getText().toString();
        if (tel.length() != 11) {
            Toast.makeText(getContext(), "手机号不符合", Toast.LENGTH_SHORT).show();
            return;
        }

        System.out.println("Login_RegFragment.onClick" +
                "\n" +
                "\n" + nickname +
                "\n" + pass +
                "\n" + tel);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                MoviesRetrofitClient.getInstance()
                        .ticketService()
                        .requestReg(pass, tel, sex, nickname)
                        .enqueue(new Callback<Integer>() {
                            @Override
                            public void onResponse(Call<Integer> call, Response<Integer> response) {


                                Integer body = response.body();
                                if (body == null || body == 0) {
                                    Log.e(Consts.TAG, response.raw() + "\nLogin_RegFragment.onResponse_请求失败：0 失败--》" + response.body());
                                    Toast.makeText(getContext(), "系统异常", Toast.LENGTH_SHORT).show();
                                } else {
                                    Log.e(Consts.TAG, response.raw() + "\nLogin_RegFragment.onResponse_请求成功：0 失败--》" + response.body());
                                    Bundle bundle = new Bundle();
                                    bundle.putString("tel", tel);
                                    //回到登录页面
                                    NavController navController = Navigation.findNavController(v);
                                    navController.navigate(R.id.action_login_RegFragment_to_login_TickeyFragment, bundle);
                                }
                            }

                            @Override
                            public void onFailure(Call<Integer> call, Throwable t) {

                                Toast.makeText(getContext(), "网络异常" + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


    }
}