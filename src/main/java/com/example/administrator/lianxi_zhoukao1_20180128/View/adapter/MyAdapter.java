package com.example.administrator.lianxi_zhoukao1_20180128.View.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.administrator.lianxi_zhoukao1_20180128.Model.DataDataBean;
import com.example.administrator.lianxi_zhoukao1_20180128.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */

public class MyAdapter  extends RecyclerView.Adapter{
    private  RecyclerView recyclerView2;
    private  RecyclerView ermen2_RecyclerView;
    DataDataBean.DataBean data;
    Context context;
    int a=0;
    int b=1;
    int c=2;
    int d=4;
    private RecyclerView recyclerView3;
    private SimpleDraweeView img3;

    public MyAdapter( DataDataBean.DataBean data, Context context) {
        super();
        this.data = data;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if (viewType == a) {
            view = View.inflate(parent.getContext(), R.layout.myadapter_layout, null);
            return new MyViewHolder(view);
        } else if (viewType == b) {
            view = View.inflate(parent.getContext(), R.layout.remen_layout, null);
            return new RightImageHolder(view);
        } else if (viewType == c) {
            view = View.inflate(parent.getContext(), R.layout.remen2_layout, null);
            return new ReMenImageHolder(view);
        }
        else {
            view = View.inflate(parent.getContext(), R.layout.zhuanti_layout, null);
            return new ThreeImageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                List<DataDataBean.DataBean.DefaultGoodsListBean> defaultGoodsList = data.getDefaultGoodsList();
                List<String> list=new ArrayList<>();
                for (int i=0;i<defaultGoodsList.size();i++){
                    list.add(defaultGoodsList.get(i).getGoods_img());
                }
                MyViewHolder holder1 = (MyViewHolder) holder;
                Banner banner = holder1.banner;
                //轮播下面样式属性
                banner.setBannerStyle(Banner.CIRCLE_INDICATOR);//设置圆形指示器与标题
                banner.setIndicatorGravity(Banner.CENTER);//设置指示器位置
                banner.setDelayTime(2000);//设置轮播时间
                banner.isAutoPlay(true);
                //设置图片集合
                banner.setImages(list);//设置图片源
                break;
            case 1:
               List<DataDataBean.DataBean.Ad5Bean> ad5 = data.getAd5();
                recyclerView3.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                recyclerView3.setAdapter(new BiaoTiAdapter(context,ad5));
                break;
            case 2:
                List<DataDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList = data.getSubjects().get(position).getGoodsList();
                ermen2_RecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                List<DataDataBean.DataBean.SubjectsBean> subjects = data.getSubjects();
                ermen2_RecyclerView.setAdapter(new ReMenAdapter(context,subjects));
                break;
            case 3:
                List<DataDataBean.DataBean.SubjectsBean> subjects1 = data.getSubjects();
                Uri parse = Uri.parse(subjects1.get(position).getDescImage());
                img3.setImageURI(parse);
                recyclerView2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                recyclerView2.setAdapter(new ZhuanTiAdapter(context,subjects1));
                break;
        }
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getItemCount() {
        return 4;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        Banner banner;
        public MyViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.ba);
        }
    }
    class RightImageHolder extends RecyclerView.ViewHolder {
        public RightImageHolder(View itemView) {
            super(itemView);
            recyclerView3 = itemView.findViewById(R.id.RecyclerView3);

        }
    }

    class ThreeImageHolder extends RecyclerView.ViewHolder {
        public ThreeImageHolder(View itemView) {
            super(itemView);
            recyclerView2 = itemView.findViewById(R.id.RecyclerView2);
            img3 = itemView.findViewById(R.id.img3);
        }
    }
    class ReMenImageHolder extends RecyclerView.ViewHolder {
        public ReMenImageHolder(View itemView) {
            super(itemView);
            ermen2_RecyclerView= itemView.findViewById(R.id.ermen2_RecyclerView);
        }
    }
}
