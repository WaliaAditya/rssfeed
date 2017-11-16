package com.example.aditya.testrss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class DetailedNews extends AppCompatActivity {

    WebView webView;
    Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        webView = (WebView)findViewById(R.id.webview);
        back_btn = (Button)findViewById(R.id.back_btn);
        Bundle bundle = getIntent().getExtras();
        webView.loadUrl(bundle.getString("Link"));

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
