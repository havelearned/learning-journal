package com.yinghua.jilijili.ui.buttom.my;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yinghua.jilijili.LoginActivity;
import com.yinghua.jilijili.MainActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.app.JiliJiliSharedPreferences;

import org.w3c.dom.Text;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


public class MyFragment extends Fragment {
    LinearLayout llaout_desc,llaout_loginout;
    ImageView iv_head;
    TextView tv_Nickname,tev;
    JiliJiliSharedPreferences jiliJiliSharedPreferences;
    SharedPreferences sharedPreferences;
    private MyViewModel myViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myViewModel =
                new ViewModelProvider(this).get(MyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my, container, false);

        //获取控件
        inItData(root);

        //全局文件 获取购票者账号信息
         jiliJiliSharedPreferences = new JiliJiliSharedPreferences(getContext().getApplicationContext());
         sharedPreferences = jiliJiliSharedPreferences.get();
        String ticketNickname = sharedPreferences.getString("ticketNickname", "未登录");
        String tel = sharedPreferences.getString("tel", "00000000000");
        if(ticketNickname==null){
            tv_Nickname.setText(ticketNickname);
            tev.setText(tel);
        }else{
            tv_Nickname.setText(ticketNickname);
            tev.setText(tel);
        }



        llaout_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "被点击了", Toast.LENGTH_SHORT).show();
            }
        });

        llaout_loginout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jiliJiliSharedPreferences.save("ticketNickname","请登录");
                jiliJiliSharedPreferences.save("tel","0000000000");
                String ticketNickname1 = sharedPreferences.getString("ticketNickname","");
                String tel1 = sharedPreferences.getString("tel", "");
                Intent intent = new Intent();
                intent.setClass(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
                onDestroy();
                getActivity().onCreateDescription();
            }
        });

        return root;
    }

    private void inItData(View root) {
        llaout_desc =root.findViewById(R.id.llaout_desc);
        llaout_loginout =root.findViewById(R.id.llaout_loginout);
        iv_head =root.findViewById(R.id.iv_head);
        tv_Nickname =root.findViewById(R.id.tv_Nickname);
        tev=root.findViewById(R.id.tv_tev);
    }
}