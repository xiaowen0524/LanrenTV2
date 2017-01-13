package lanren.com.lanrentv2.allthepeoplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lanren.com.lanrentv2.R;


/**
 * Effect:魔兽争霸3
 * autour: 张玉杰
 * date: 2017/1/5 14:35
 * update: 2017/1/5
 */

public class Warcraft3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_warcraft3, null);
        return view;
    }
}