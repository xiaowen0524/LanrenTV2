package lanren.com.lanrentv2.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import lanren.com.lanrentv2.R;
import lanren.com.lanrentv2.adapter.ColumnAdapter;
import lanren.com.lanrentv2.adapter.WechatAdapter;
import lanren.com.lanrentv2.okhttp.OkHttp;
import lanren.com.lanrentv2.webview.WebviewActivity;
import okhttp3.Request;


/**
 * Effect:微信
 * autour: 张玉杰
 * date: 2017/1/5 14:03
 * update: 2017/1/5
 */

public class Wechat extends Fragment {

    private RecyclerView recyclerview;
    private View view;
    private WechatAdapter wechatAdapter;
    private lanren.com.lanrentv2.bean.WechatBean bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_wechat, null);
        MyOkhttp();
        return view;
    }

    public void wechats() {
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerviews);
        //设置线性布局效果
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(getActivity());
//        recyclerview.setNestedScrollingEnabled(false);
        recyclerview.setLayoutManager(linearLayoutManagers);
        wechatAdapter = new WechatAdapter(getActivity(), bean);
        recyclerview.setAdapter(wechatAdapter);
        wechatAdapter.setOnItemClickListener(new ColumnAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
                String url = bean.getNewslist().get(position).getUrl();
                Intent intent = new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }

    public void MyOkhttp() {
        OkHttp.getAsync("http://api.tianapi.com/wxnew/?key=89bc539c8d6424551960925d21c0eab3&num=10&page=1", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                bean = gson.fromJson(result, lanren.com.lanrentv2.bean.WechatBean.class);
                wechats();
            }
        });
    }
}