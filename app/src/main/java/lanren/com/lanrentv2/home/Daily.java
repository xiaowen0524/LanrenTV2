package lanren.com.lanrentv2.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import lanren.com.lanrentv2.R;
import lanren.com.lanrentv2.adapter.ColumnAdapter;
import lanren.com.lanrentv2.adapter.DailyAdapter;
import lanren.com.lanrentv2.okhttp.OkHttp;
import okhttp3.Request;


/**
 * Effect:日报
 * autour: 张玉杰
 * date: 2017/1/5 14:03
 * update: 2017/1/5
 */

public class Daily extends Fragment {

    private RecyclerView recyclerview;
    private ViewPager viewpager;
    private View view;
    private DailyAdapter dailyAdapter;
    private lanren.com.lanrentv2.bean.DailyBean bean;

    //存放图片
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_daily, null);
//        viewpager = (ViewPager) view.findViewById(R.id.daily_vp);
        MyOkhttp();
        return view;
    }

    public void dailys() {
        recyclerview = (RecyclerView) view.findViewById(R.id.daily_rv);
        //设置线性布局效果
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(getActivity());
//        recyclerview.setNestedScrollingEnabled(false);
        recyclerview.setLayoutManager(linearLayoutManagers);
        dailyAdapter = new DailyAdapter(getActivity(), bean);
        recyclerview.setAdapter(dailyAdapter);
        dailyAdapter.setOnItemClickListener(new ColumnAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void MyOkhttp() {
        OkHttp.getAsync("http://news-at.zhihu.com/api/4/news/latest", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                bean = gson.fromJson(result, lanren.com.lanrentv2.bean.DailyBean.class);
                Log.d("6666666666660", "888" + result);
                dailys();
            }
        });
    }
}