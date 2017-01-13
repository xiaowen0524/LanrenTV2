package lanren.com.lanrentv2.allthepeoplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lanren.com.lanrentv2.R;


/**
 * Effect:英雄联盟
 * autour: 张玉杰
 * date: 2017/1/5 14:15
 * update: 2017/1/5
 */

public class LoL extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_lo_l, null);
        return view;
    }
}
