package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;


public class AboutActivity extends AppCompatActivity {
    private WebView myAboutWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        myAboutWebView = findViewById(R.id.my_WebView2);
        myAboutWebView.loadUrl("file:///android_asset/About MyTopDesserts/about.html");
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