package www.com.adapter;

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

public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.ViewHolder> {
    Context context;
    ShowBean.ResultBean list;

    public MlssAdapter(Context context, ShowBean.ResultBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.item_mlss_y, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.getMlss().getCommodityList().get(i).getCommodityName());
        viewHolder.price.setText(list.getMlss().getCommodityList().get(i).getPrice()+"");
        Glide.with(context).load(list.getMlss().getCommodityList().get(i).getMasterPic()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.getMlss().getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView price;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_mlss);
            price = itemView.findViewById(R.id.price_mlss);
            name = itemView.findViewById(R.id.name_mlss);
        }
    }
}
