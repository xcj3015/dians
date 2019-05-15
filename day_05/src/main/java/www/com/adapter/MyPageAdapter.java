package www.com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import www.com.MainActivity;
import www.com.R;
import www.com.bean.XbnnerBean;

/**
 * Name:  The.xue
 * Date  2019-05-15
 */
public class MyPageAdapter extends RecyclerView.Adapter<MyPageAdapter.ViewHolder> {

    Context context;
    List<XbnnerBean.ResultBean> result;
    private View view;

    public MyPageAdapter(Context context, List<XbnnerBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyPageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = View.inflate(context, R.layout.xbanner, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPageAdapter.ViewHolder viewHolder, int i) {
        Glide.with(view).load(result.get(i).getImageUrl()).into(viewHolder.mImage);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
        }
    }
}
