package com.yinghua.jilijili.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.MainActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.app.JiliJiliSharedPreferences;
import com.yinghua.jilijili.bean.Ticket;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_TickeyFragment extends Fragment {
    Handler handler = new Handler();
    ImageView loginTotle, loing_qq, login_wx, login_back;

    EditText login_Name, login_password;

    TextView login_tvName, login_tvPassword;

    Button login_Login, login_newUser, login_email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login__tickey, container, false);
        inItView(view);
        OnlickReg(view);
        Glide.with(this).load("https://goss2.cfp.cn/creative/vcg/800/new/VCG211292029131.gif").into(login_back);


        /**
         * 获取账号信息
         * 购票者账号和密码
         * 发送登录请求
         * 服务器返回json数据
         * 解析数据，如果有数据就是成功，如果没有数据提示注册账号
         * */
        //测试登录：17754576486，1775457648623223
        login_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_name1 = login_Name.getText().toString().trim();
                String login_password1 = login_password.getText().toString().trim();
                if (login_name1.equals("") || login_name1.length() != 11) {
                    Toast.makeText(getContext(), "不正确的手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (login_password1.equals("") || login_password1.length() < 6 || login_password1.length() > 16) {
                    Toast.makeText(getContext(), "不正确的密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                sendRequestLogin(login_name1, login_password1);

            }
        });

        login_email.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_TickeyFragment_to_login_EmailFragment));

        //注册信息返回
        regBreak();
        return view;


    }

    private void regBreak() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            Log.e(Consts.TAG, "s注册信息传回来是空的");
        } else {
            String tel = arguments.getString("tel");
            login_Name.setText(tel);
        }
    }

    private void sendRequestLogin(String login_name, String login_password) {
        MoviesRetrofitClient.getInstance()
                .ticketService()
                .requestLogin(login_name, login_password)
                .enqueue(new Callback<Ticket>() {
                    @Override
                    public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                        Ticket ticket = response.body();
                        Log.e(Consts.TAG, "sendRequestLogin_请求成功:" + response.body());
                        Log.e(Consts.TAG, "sendRequestLogin_请求成功:" + login_name + "=====" + ticket.gettCard());
                        if (login_name.equals(ticket.gettPhone()) && login_password.equals(ticket.gettCard())) {

                            //启动
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            JiliJiliSharedPreferences jiliJiliSharedPreferences = new JiliJiliSharedPreferences(getActivity().getApplicationContext());
                            jiliJiliSharedPreferences.save("ticketNickname",ticket.gettNickname());
                            jiliJiliSharedPreferences.save("tel",ticket.gettPhone());
                            intent.putExtra("newDate", new SimpleDateFormat("yyyy-dd-MM HH:mm").format(new Date()));
                            startActivity(intent);
                            getActivity().finish();

                        } else {
                            Toast.makeText(getContext(), "账号或密码错误！", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Ticket> call, Throwable t) {
                        Log.e(Consts.TAG, "sendRequestLogin_请求失败:" + t.getMessage());
                    }
                });
    }

    private void inItView(View view) {
        login_back = view.findViewById(R.id.login_back);
        loginTotle = view.findViewById(R.id.logImage_totle);
        loing_qq = view.findViewById(R.id.logni_qqLogin);
        login_wx = view.findViewById(R.id.logni_wxLogin);

        login_Name = view.findViewById(R.id.login_name);
        login_password = view.findViewById(R.id.login_password);

        login_tvName = view.findViewById(R.id.login_tvName);
        login_tvPassword = view.findViewById(R.id.login_tvPassword);

        login_Login = view.findViewById(R.id.login_login);

        login_newUser = view.findViewById(R.id.login_newUser);
        login_email = view.findViewById(R.id.login_email);
    }


    public void OnlickReg(View view) {
        login_newUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_TickeyFragment_to_login_RegFragment));
    }
}
