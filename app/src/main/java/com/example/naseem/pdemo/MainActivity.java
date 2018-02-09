package com.example.naseem.pdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {


    public static final String ORIENTATION="orientation";
    private RecyclerView mRecyclerview;
    private Boolean mHorizontal;
    NestedScrollView scrollView;
    public ImageButton imageButton;

//    private DrawerLayout mDrawerlayout;
//    private ActionBarDrawerToggle mTogel;


    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mRecyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        mRecyclerview.setNestedScrollingEnabled(false);


        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setHasFixedSize(true);

        if (savedInstanceState==null){
            mHorizontal=true;

        }else {
            mHorizontal=savedInstanceState.getBoolean(ORIENTATION);
        }
        setupAdapter();


        //viewpager
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
        MyCustomPagerAdapter myCustomPagerAdapter = new MyCustomPagerAdapter(this);
        viewPager.setAdapter(myCustomPagerAdapter);

        dotscount = myCustomPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,3000);



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//      scrollView = (NestedScrollView) findViewById (R.id.nestdscrolview);
//        scrollView.setFillViewport (true);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION,mHorizontal);
    }

    private void setupAdapter(){
        List<App> apps=getApps();
        SnapAdapter snapAdapter=new SnapAdapter();
        if(mHorizontal){
            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL,"FEATURED PRODUCTS",apps));
            snapAdapter.addSnap(new Snap(Gravity.START,"APPLE IPHONES",apps));
            snapAdapter.addSnap(new Snap(Gravity.END,"CAMERAS",apps));
            snapAdapter.addSnap(new Snap(Gravity.END,"TABLETS",apps));
            //snapAdapter.addSnap(new Snap(Gravity.CENTER,"Apple Products",apps));
        }else {

            snapAdapter.addSnap(new Snap(Gravity.CENTER_VERTICAL,"Apple Products",apps));
            snapAdapter.addSnap(new Snap(Gravity.TOP,"Apple Products",apps));
            snapAdapter.addSnap(new Snap(Gravity.BOTTOM,"Apple Products",apps));
        }
        mRecyclerview.setAdapter(snapAdapter);

    }


    private List<App> getApps(){
        List<App> apps=new ArrayList<>();
        apps.add(new App("Apple iPhone 7 plus","AED 2199.00","38 Online Store(s)",R.drawable.apple7plus));
        apps.add(new App("Apple iPhone 7 plus","AED 18190.00","38 Online Store(s)",R.drawable.canon));
        apps.add(new App("Apple iPhone 7 plus","AED 1125.60","38 Online Store(s)",R.drawable.microlumia));
        apps.add(new App("Apple iPhone 7 plus","AED 2199.00","38 Online Store(s)",R.drawable.apple7plus));
        apps.add(new App("Apple iPhone 7 plus","AED 18190.00","38 Online Store(s)",R.drawable.canon));
        apps.add(new App("Apple iPhone 7 plus","AED 1125.60","38 Online Store(s)",R.drawable.microlumia));
        apps.add(new App("Apple iPhone 7 plus","AED 2199.00","38 Online Store(s)",R.drawable.apple7plus));

        return apps;
    }

//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//
//        if (item.getItemId()==R.id.LayoutType){
//            mHorizontal=!mHorizontal;
//            setupAdapter();
//            item.setTitle((mHorizontal ?"Vertical":"Horizontal"));
//
//        }
//        return false;
//
//    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }
                    else if(viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }
                    else if(viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);
                    }
                    else {
                        viewPager.setCurrentItem(0);
                    }


                }
            });
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}