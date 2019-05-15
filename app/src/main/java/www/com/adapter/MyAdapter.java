package www.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import www.com.MainActivity;
import www.com.R;
import www.com.bean.ShowBean;
import www.com.bean.XBannerBean;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ShowBean.ResultBean result;
    XBannerBean xbannerBean;
    private int RXXP_TYPE=1;
    private int MLSS_TYPE=2;
    private int PZSH_TYPE=3;
    private int Banner_TYPE=0;
    private RxxpHolder rxxpHolder;
    private PzshHolder pzshHolder;
    private MlssHolder mlssHolder;
    private List<XBannerBean.ResultBean> xbanner;
    private XbannerHolder xbannerHolder;
    private RxxpAdapter rxxpAdapter;


    public MyAdapter(Context context, ShowBean.ResultBean result, XBannerBean xbannerBean) {
        this.context = context;
        this.result = result;
        this.xbannerBean=xbannerBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==Banner_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, viewGroup, false);
            xbannerHolder = new XbannerHolder(view);
            return xbannerHolder;
        }else if(i==RXXP_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.item_rxxp, viewGroup, false);
            rxxpHolder = new RxxpHolder(view);
            return rxxpHolder;
        } else if (i==MLSS_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.item_mlss, viewGroup, false);
            mlssHolder = new MlssHolder(view);
            return mlssHolder;
        }else if (i==PZSH_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.item_pzsh, viewGroup, false);
            pzshHolder = new PzshHolder(view);
            return pzshHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof XbannerHolder){
            xbannerHolder = (XbannerHolder) viewHolder;
            List<String>list = new ArrayList<>();
            xbanner = xbannerBean.getResult();
            for (int j = 0; j < xbanner.size(); j++) {
                list.add(xbanner.get(i).getImageUrl());
            }
            xbannerHolder.Xbanner.setData(list,null);
            xbannerHolder.Xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, View view, int position) {
                    Glide.with(context).load(xbanner.get(position).getImageUrl()).into((ImageView) view);
                }
            });

        }else if (viewHolder instanceof  RxxpHolder){

            final RxxpHolder rxxpHolder = (RxxpHolder) viewHolder;
            rxxpHolder.text_rxxp.setText(result.getRxxp().getName());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            rxxpHolder.recycle_rxxp.setLayoutManager(linearLayoutManager);
            rxxpAdapter = new RxxpAdapter(context,result);
            rxxpHolder.recycle_rxxp.setAdapter(rxxpAdapter);
            /*rxxpAdapter.setOnClicks(new RxxpAdapter.OnClicks() {
                @Override
                public void OnCallback(String id, int position) {
                    Toast.makeText(context,"点击成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,XiangActivity.class);
                    intent.putExtra("id",id);
                    context.startActivity(intent);
                }
            });*/

        }else if (viewHolder instanceof PzshHolder){

            PzshHolder pzshHolder = (PzshHolder) viewHolder;
            pzshHolder.text_pzsh.setText(result.getPzsh().getName());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            pzshHolder.recycle_pzsh.setLayoutManager(gridLayoutManager);
            pzshHolder.recycle_pzsh.setAdapter(new PzshAdapter (context,result));
        } else if (viewHolder instanceof MlssHolder){

            MlssHolder mlssHolder = (MlssHolder) viewHolder;
            mlssHolder.text_mlss.setText(result.getMlss().getName());
            LinearLayoutManager   linearLayoutManager = new LinearLayoutManager(context);
            mlssHolder.recycle_mlss.setLayoutManager(linearLayoutManager);
            mlssHolder.recycle_mlss.setAdapter(new MlssAdapter (context,result));
        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return Banner_TYPE;
        }else if(position==1){
            return RXXP_TYPE;
        }else if (position==2){
            return MLSS_TYPE;
        }else if (position==3){
            return PZSH_TYPE;
        }
        return super.getItemViewType(position);
    }


    private class XbannerHolder extends RecyclerView.ViewHolder{
        private XBanner Xbanner;
        public XbannerHolder(View itemView) {
            super(itemView);
            Xbanner = itemView.findViewById(R.id.Xbanner);
        }
    }
    private class RxxpHolder extends RecyclerView.ViewHolder{
        private TextView text_rxxp;
        private RecyclerView recycle_rxxp;
        public RxxpHolder(View itemView) {
            super(itemView);
            text_rxxp = itemView.findViewById(R.id.text_rxxp);
            recycle_rxxp = itemView.findViewById(R.id.recycle_rxxp);
        }
    }
    private class PzshHolder extends RecyclerView.ViewHolder {

        private TextView text_pzsh;
        private RecyclerView recycle_pzsh;
        public PzshHolder(View itemView) {
            super(itemView);
            recycle_pzsh = itemView.findViewById(R.id.recycle_pzsh);
            text_pzsh = itemView.findViewById(R.id.text_pzsh);
        }
    }
    private class MlssHolder extends RecyclerView.ViewHolder{
        private TextView text_mlss;
        private RecyclerView recycle_mlss;

        public MlssHolder(View itemView) {
            super(itemView);
            recycle_mlss = itemView.findViewById(R.id.recycle_mlss);
            text_mlss = itemView.findViewById(R.id.text_mlss);
        }
    }
}

