package www.com.adapter;

/**
 * Name:  The.xue
 * Date  2019-05-14
 */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import www.com.R;
import www.com.bean.ShowBean;

public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    Context context;
    ShowBean.ResultBean list;

    public RxxpAdapter(Context context, ShowBean.ResultBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.item_rxxp_y, null);
        return new RxxpAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(list.getRxxp().getCommodityList().get(i).getCommodityName());
        viewHolder.price.setText(list.getRxxp().getCommodityList().get(i).getPrice()+"");
        Glide.with(context).load(list.getRxxp().getCommodityList().get(i).getMasterPic()).into(viewHolder.img);
        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicks.OnCallback(list.getRxxp().getCommodityList().get(i).getCommodityId(),v.getId());

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list.getRxxp().getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView price;
        private TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_rxxp);
            price = itemView.findViewById(R.id.price_rxxp);
            name = itemView.findViewById(R.id.name_rxxp);
        }
    }
    public interface OnClicks{
        void OnCallback(String id,int position);
    }
    public OnClicks onClicks;

    public void setOnClicks(OnClicks onClicks) {
        this.onClicks = onClicks;
    }
}
