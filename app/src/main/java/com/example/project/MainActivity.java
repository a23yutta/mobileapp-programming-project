package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    //private final String JSON_FILE = "mountains.json";
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    private RecyclerView view;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adapter = new RecyclerViewAdapter(this, recipes, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Recipe items) {
                Toast.makeText(MainActivity.this, recipes.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        view = findViewById(R.id.recycler_view_);
        view.setLayoutManager((new LinearLayoutManager(this)));
        view.setAdapter(adapter);


    }
    private void getJson() {
        new JsonTask(this).execute(JSON_URL);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_updaterecycleview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_update_recyclerview) {
            getJson();
            Log.d("==>", "Update RecyclerView");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Recipe>>() {}.getType();
        recipes = gson.fromJson(json, type);
        Log.d("MainActivity", "new mountains" + recipes.size());
        adapter = new RecyclerViewAdapter(this, recipes, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Recipe items) {
                Toast.makeText(MainActivity.this, recipes.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

