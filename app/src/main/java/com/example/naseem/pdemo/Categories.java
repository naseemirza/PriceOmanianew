package com.example.naseem.pdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Categories extends AppCompatActivity {

    String categoriesItems[] = {
            "ListView Title 1", "ListView Title 2", "ListView Title 3", "ListView Title 4",
            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8",
            "ListView Title 9", "ListView Title 10", "ListView Title 11", "ListView Title 12",
            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8",
            "ListView Title 9", "ListView Title 10", "ListView Title 11", "ListView Title 12",
    };

    Integer image_id[] = {
            R.drawable.categories, R.drawable.login, R.drawable.favorite, R.drawable.my_ad,
            R.drawable.send_us_feedback, R.drawable.login, R.drawable.categories, R.drawable.offer,
            R.drawable.categories, R.drawable.login, R.drawable.favorite, R.drawable.my_ad,
            R.drawable.send_us_feedback, R.drawable.login, R.drawable.categories, R.drawable.offer,
            R.drawable.categories, R.drawable.login, R.drawable.favorite, R.drawable.my_ad,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CategoryListAdapter adapter = new CategoryListAdapter(this, image_id, categoriesItems);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
