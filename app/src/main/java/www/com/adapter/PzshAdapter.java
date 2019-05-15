package www.com.adapter;

/**
 * Name:  The.xue
 * Date  2019-05-14
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import www.com.R;
import www.com.bean.ShowBean;


public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.ViewHolder> {
    Context context;
    ShowBean.ResultBean list;

    public PzshAdapter(Context context, ShowBean.ResultBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.item_pzsh_y, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.getPzsh().getCommodityList().get(i).getCommodityName());
        viewHolder.price.setText(list.getPzsh().getCommodityList().get(i).getPrice()+"");
        Glide.with(context).load(list.getPzsh().getCommodityList().get(i).getMasterPic()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.getPzsh().getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView price;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_pzsh);
            price = itemView.findViewById(R.id.price_pzsh);
            name = itemView.findViewById(R.id.name_pzsh);
        }
    }
}
