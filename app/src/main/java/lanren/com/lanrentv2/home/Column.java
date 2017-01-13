package lanren.com.lanrentv2.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import lanren.com.lanrentv2.R;
import lanren.com.lanrentv2.adapter.ColumnAdapter;
import lanren.com.lanrentv2.okhttp.OkHttp;
import okhttp3.Request;

/**
 * Effect:专栏
 * autour: 张玉杰
 * date: 2017/1/5 14:04
 * update: 2017/1/5
 */

public class Column extends Fragment {

    private RecyclerView recyclerview;
    private View view;
    private ColumnAdapter columnAdapter;
    private lanren.com.lanrentv2.bean.Column bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_column, null);
        MyOkhttp();
        return view;
    }

    public void columns() {
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        //设置线性布局效果
        GridLayoutManager linearLayoutManagers = new GridLayoutManager(getActivity(), 2);
//        bagerecyclerview.setNestedScrollingEnabled(false);
        recyclerview.setLayoutManager(linearLayoutManagers);
        columnAdapter = new ColumnAdapter(getActivity(), bean);
        recyclerview.setAdapter(columnAdapter);
        columnAdapter.setOnItemClickListener(new ColumnAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void MyOkhttp() {
        OkHttp.getAsync("http://news-at.zhihu.com/api/4/sections", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                bean = gson.fromJson(result, lanren.com.lanrentv2.bean.Column.class);
                columns();
            }
        });
    }
}