package com.example.project;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        String recipe = "Glass";
        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            String temp = extras.getString("Recipe url");
            if (temp != null) {
                recipe = temp;
            }
        }

        Log.d("hew", "url:" + recipe);

        myWebView = findViewById(R.id.my_webView1);
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        myWebView.loadUrl(recipe);
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_webview, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_close_current_Activity) {
            Log.d("Tag", "New Activity");
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}