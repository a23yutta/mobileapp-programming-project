package com.example.project;

import android.content.Intent;
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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    private RecyclerView view;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adapter = new RecyclerViewAdapter(this, recipes, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("Recipe url", "recipe.getAuxdata()");
                startActivity(intent);
                Toast.makeText(MainActivity.this, recipe.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        view = findViewById(R.id.recycler_view_);
        view.setLayoutManager((new LinearLayoutManager(this)));
        view.setAdapter(adapter);
        getJson();
    }
    private void getJson() {
        new JsonTask(this).execute("https://mobprog.webug.se/json-api?login=a23yutta");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_aboutmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_open_AboutActivity) {
            Log.d("Tag", "New Activity");
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Recipe>>() {}.getType();
        recipes = gson.fromJson(json, type);

        adapter = new RecyclerViewAdapter(this, recipes, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("Recipe url", recipe.getAuxdata().getWiki());
                startActivity(intent);
                Toast.makeText(MainActivity.this, recipe.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

