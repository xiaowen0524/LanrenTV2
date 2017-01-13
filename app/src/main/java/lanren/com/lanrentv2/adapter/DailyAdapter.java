package lanren.com.lanrentv2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import lanren.com.lanrentv2.R;
import lanren.com.lanrentv2.bean.DailyBean;

/**
 * 1.version:
 * 2.date:2017/1/13 20:36
 * 3.update:2017/1/13.
 * 4.autour:张玉杰
 */

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.MyViewHodler> {

    private Context context;
    private DailyBean bean;
    private static RecyclerView.Adapter Adapter;
    private static ColumnAdapter.OnItemClickListener mOnItemClickListener;

    //设置点击和长按事件
    public interface OnItemClickListener {
        void onItemClick(View view, int position); //设置点击事件

    }

    public static void setOnItemClickListener(ColumnAdapter.OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public DailyAdapter(Context context, DailyBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public DailyAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHodler hodler = new MyViewHodler(LayoutInflater.from(context).inflate(R.layout.item_daily, parent, false));
        return hodler;
    }

    @Override
    public void onBindViewHolder(final DailyAdapter.MyViewHodler holder, final int position) {
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(bean.getStories().get(position).getImages().get(0), holder.picUrl);
        holder.title.setText(bean.getStories().get(position).getTitle());
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() { //itemview是holder里的所有控件，可以单独设置比如ImageButton Button等
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return bean.getStories().size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {
        ImageView picUrl;
        TextView title;

        public MyViewHodler(View itemView) {
            super(itemView);
            picUrl = (ImageView) itemView.findViewById(R.id.picUrls);
            title = (TextView) itemView.findViewById(R.id.titles);
        }
    }
}
