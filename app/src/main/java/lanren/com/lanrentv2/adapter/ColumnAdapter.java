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
import lanren.com.lanrentv2.bean.Column;


/**
 * 1.version:
 * 2.date:2017/1/5 20:23
 * 3.update:2017/1/5.
 * 4.autour:张玉杰
 */

public class ColumnAdapter extends RecyclerView.Adapter<ColumnAdapter.MyViewHodler> {
    private Context context;
    private Column bean;
    private static RecyclerView.Adapter Adapter;
    private static OnItemClickListener mOnItemClickListener;

    //设置点击和长按事件
    public interface OnItemClickListener {
        void onItemClick(View view, int position); //设置点击事件

    }

    public static void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public ColumnAdapter(Context context, Column bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public ColumnAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHodler hodler = new MyViewHodler(LayoutInflater.from(context).inflate(R.layout.item_column, parent, false));
        return hodler;
    }

    @Override
    public void onBindViewHolder(final ColumnAdapter.MyViewHodler holder, final int position) {
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(bean.getData().get(position).getThumbnail(), holder.columnImage);
        holder.columntop.setText(bean.getData().get(position).getDescription());
        holder.columnbottom.setText(bean.getData().get(position).getName());
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
        return bean.getData().size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {
        ImageView columnImage;
        TextView columntop, columnbottom;

        public MyViewHodler(View itemView) {
            super(itemView);
            columnImage = (ImageView) itemView.findViewById(R.id.columnimage);
            columntop = (TextView) itemView.findViewById(R.id.columnntop);
            columnbottom = (TextView) itemView.findViewById(R.id.columnbottom);
        }
    }
}
