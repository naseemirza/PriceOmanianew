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
            "Mobile Phones (23026)", "Computers/Laptops (34838)", "Tablets (1437)", "Cameras (15610)",
            "TV Video (2700)", "Audio (1525)", "Video Games (1499)", "Kids & Babies (27359)",
            "Men Fashion (13164)", "Eyewear (11946)", "Watches (15670)", "Women Fashion (44105)",
            "Home Appliances (3149)", "Home & Furniture (30479)", "Office Supplies (3043)", "Sports & Fitness (13383)",
            "Click for more categories",
    };

    Integer image_id[] = {
            R.drawable.categories, R.drawable.login, R.drawable.favorite, R.drawable.my_ad,
            R.drawable.send_us_feedback, R.drawable.login, R.drawable.categories, R.drawable.offer,
            R.drawable.categories, R.drawable.login, R.drawable.favorite, R.drawable.my_ad,
            R.drawable.send_us_feedback, R.drawable.login, R.drawable.categories, R.drawable.offer,
            R.drawable.categories,
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
