package lanren.com.lanrentv2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lanren.com.lanrentv2.R;
import lanren.com.lanrentv2.home.Column;
import lanren.com.lanrentv2.home.Daily;
import lanren.com.lanrentv2.home.Popular;
import lanren.com.lanrentv2.home.Wechat;
import lanren.com.lanrentv2.mainMenu.About;
import lanren.com.lanrentv2.mainMenu.Allthepeople;
import lanren.com.lanrentv2.mainMenu.Module;
import lanren.com.lanrentv2.mainMenu.Settings;

public class MainActivity extends FragmentActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String[] tabTitles =
            new String[]{"日报", "专栏", "微信", "热门"};

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> list = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        //悬浮按钮
        fab();
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    /**
     * 悬浮按钮
     * */
    public void fab(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Toast.makeText(MainActivity.this, "再点一下", Toast.LENGTH_SHORT).show();
            }
        });

    }
    /**
     * 日报、专栏、微信、热门
     */
    private void initViews() {
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        //添加Fragment
        setFragment();

        //为ViewPager设置FragmentPagerAdapter
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            /**
             * 为TabLayout中每一个tab设置标题
             */
            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitles[position];
            }

        });

        //TabLaout和ViewPager进行关联
        mTabLayout.setupWithViewPager(mViewPager);
        //防止tab太多，都拥挤在一起
//        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
    public List<Fragment> setFragment() {
        list = new ArrayList<>();
        list.add(new Daily());
        list.add(new Column());
        list.add(new Wechat());
        list.add(new Popular());
        return list;
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(MainActivity.this, "1", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, Module.class));
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(MainActivity.this, "2", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, Allthepeople.class));
        } else if (id == R.id.nav_share) {
            Toast.makeText(MainActivity.this, "3", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, Settings.class));
        } else if (id == R.id.nav_send) {
            Toast.makeText(MainActivity.this, "4", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, About.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
