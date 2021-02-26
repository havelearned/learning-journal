package com.yinghua.jilijili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class WEBActivity extends AppCompatActivity {
    WebView webView;
    TextView webtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_e_b);
        this.getSupportActionBar().hide();
        webView = findViewById(R.id.webView);
        webtitle = findViewById(R.id.web_title);
        Intent intent = getIntent();
        if (intent != null) {

            String content = intent.getStringExtra("content");
            webtitle.setText(intent.getStringExtra("title"));
            String s = Base64.encodeToString(content.getBytes(), Base64.NO_PADDING);
            webView.loadData(s, "text/html", "base64");
            webView.setWebViewClient(new WebViewClient());
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            if (webView.canGoBack()) {//当前webview 是否可以返回
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}