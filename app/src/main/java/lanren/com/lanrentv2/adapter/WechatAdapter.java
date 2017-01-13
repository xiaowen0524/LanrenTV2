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
import lanren.com.lanrentv2.bean.WechatBean;

/**
 * 1.version:
 * 2.date:2017/1/12 14:54
 * 3.update:2017/1/12.
 * 4.autour:张玉杰
 */

public class WechatAdapter extends RecyclerView.Adapter<WechatAdapter.MyViewHodler> {

    private Context context;
    private WechatBean bean;
    private static RecyclerView.Adapter Adapter;
    private static ColumnAdapter.OnItemClickListener mOnItemClickListener;

    //设置点击和长按事件
    public interface OnItemClickListener {
        void onItemClick(View view, int position); //设置点击事件

    }

    public static void setOnItemClickListener(ColumnAdapter.OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public WechatAdapter(Context context, WechatBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public WechatAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHodler hodler = new MyViewHodler(LayoutInflater.from(context).inflate(R.layout.item_wechat, parent, false));
        return hodler;
    }

    @Override
    public void onBindViewHolder(final WechatAdapter.MyViewHodler holder, final int position) {
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(bean.getNewslist().get(position).getPicUrl(), holder.picUrl);
        holder.title.setText(bean.getNewslist().get(position).getTitle());
        holder.description.setText(bean.getNewslist().get(position).getDescription());
        holder.ctime.setText(bean.getNewslist().get(position).getCtime());
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
        return bean.getNewslist().size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {

        ImageView picUrl;
        TextView title, description, ctime;

        public MyViewHodler(View itemView) {
            super(itemView);
            picUrl = (ImageView) itemView.findViewById(R.id.picUrl);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            ctime = (TextView) itemView.findViewById(R.id.ctime);
        }
    }
}
