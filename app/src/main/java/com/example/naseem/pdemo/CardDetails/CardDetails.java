package com.example.naseem.pdemo.CardDetails;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.naseem.pdemo.R;

public class CardDetails extends AppCompatActivity implements ActionBar.TabListener {


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

        getSupportActionBar().setTitle("Card Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        ab.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));





        // Three tab to display in actionbar
        ab.addTab(ab.newTab().setText("Compare Prices").setTabListener(this));
        ab.addTab(ab.newTab().setText("Description").setTabListener(this));
        ab.addTab(ab.newTab().setText("FAQ").setTabListener(this));
        ab.addTab(ab.newTab().setText("Compare Prices").setTabListener(this));
        ab.addTab(ab.newTab().setText("Description").setTabListener(this));
        ab.addTab(ab.newTab().setText("FAQ").setTabListener(this));

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        int nTabSelected = tab.getPosition();
        switch (nTabSelected) {
            case 0:
                setContentView(R.layout.actionbar_compare);
                break;
            case 1:
                setContentView(R.layout.actionbar_descr);
                break;
            case 2:
                setContentView(R.layout.actionbar_faq);
                break;
            case 3:
                setContentView(R.layout.actionbar_compare);
                break;
            case 4:
                setContentView(R.layout.actionbar_descr);
                break;
            case 5:
                setContentView(R.layout.actionbar_faq);
                break;
        }

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}


