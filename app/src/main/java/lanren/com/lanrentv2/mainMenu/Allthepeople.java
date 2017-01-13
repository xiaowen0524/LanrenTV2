package lanren.com.lanrentv2.mainMenu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lanren.com.lanrentv2.R;
import lanren.com.lanrentv2.allthepeoplefragment.Ballbigfight;
import lanren.com.lanrentv2.allthepeoplefragment.Blizzard;
import lanren.com.lanrentv2.allthepeoplefragment.CF;
import lanren.com.lanrentv2.allthepeoplefragment.DNF;
import lanren.com.lanrentv2.allthepeoplefragment.DOTA2;
import lanren.com.lanrentv2.allthepeoplefragment.FIFA;
import lanren.com.lanrentv2.allthepeoplefragment.Furnacestonelegend;
import lanren.com.lanrentv2.allthepeoplefragment.Handtourarea;
import lanren.com.lanrentv2.allthepeoplefragment.Kingofglory;
import lanren.com.lanrentv2.allthepeoplefragment.LoL;
import lanren.com.lanrentv2.allthepeoplefragment.Myworld;
import lanren.com.lanrentv2.allthepeoplefragment.NBA2K;
import lanren.com.lanrentv2.allthepeoplefragment.Onlinegames;
import lanren.com.lanrentv2.allthepeoplefragment.Outdoors;
import lanren.com.lanrentv2.allthepeoplefragment.QQSpeed;
import lanren.com.lanrentv2.allthepeoplefragment.Recommendation;
import lanren.com.lanrentv2.allthepeoplefragment.Singlehost;
import lanren.com.lanrentv2.allthepeoplefragment.Starshow;
import lanren.com.lanrentv2.allthepeoplefragment.Thesecondelement;
import lanren.com.lanrentv2.allthepeoplefragment.Valuecontrol;
import lanren.com.lanrentv2.allthepeoplefragment.Warcraft3;
import lanren.com.lanrentv2.allthepeoplefragment.Watchthepioneer;


/**
 * Effect:全民TV
 * autour: 张玉杰
 * date: 2017/1/4 14:14
 * update: 2017/1/4
 */

public class Allthepeople extends AppCompatActivity {
    public static final String[] tabTitles =
            new String[]{"颜值控", "英雄联盟", "全民星秀", "守望先锋", "全民户外", "炉石传说", "手游专区", "网游竞技", "单机主机", "王者荣耀", "精彩推荐", "DOTA2", "穿越火线", "DNF", "QQ飞车", "魔兽争霸3", "NBA2K", "我的世界", "FIFA", "暴雪经典", "球球大作战", "二次元区"};

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allthepeople);
        initViews();
    }

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
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    public List<Fragment> setFragment() {
        list = new ArrayList<>();
        list.add(new Valuecontrol());
        list.add(new LoL());
        list.add(new Starshow());
        list.add(new Watchthepioneer());
        list.add(new Outdoors());
        list.add(new Furnacestonelegend());
        list.add(new Handtourarea());
        list.add(new Onlinegames());
        list.add(new Singlehost());
        list.add(new Kingofglory());
        list.add(new Recommendation());
        list.add(new DOTA2());
        list.add(new CF());
        list.add(new DNF());
        list.add(new QQSpeed());
        list.add(new Warcraft3());
        list.add(new NBA2K());
        list.add(new Myworld());
        list.add(new FIFA());
        list.add(new Blizzard());
        list.add(new Ballbigfight());
        list.add(new Thesecondelement());
        return list;
    }
}
