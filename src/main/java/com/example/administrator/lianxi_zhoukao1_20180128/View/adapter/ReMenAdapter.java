package com.example.administrator.lianxi_zhoukao1_20180128.View.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.lianxi_zhoukao1_20180128.Model.DataDataBean;
import com.example.administrator.lianxi_zhoukao1_20180128.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */

public class ReMenAdapter extends RecyclerView.Adapter<ReMenAdapter.MyZhuanTi> {
    private SimpleDraweeView re_SimpleDraweeView;
    Context context;
    List<DataDataBean.DataBean.SubjectsBean> subjects;
    private List<DataDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList;
    private List<DataDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList1;

    public ReMenAdapter(Context context, List<DataDataBean.DataBean.SubjectsBean> subjects) {
        this.context = context;
        this.subjects = subjects;
    }

    @Override
    public MyZhuanTi onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.remen_adapter_layout, null);
        MyZhuanTi myZhuanTi = new MyZhuanTi(view);
        return myZhuanTi;
    }

    @Override
    public void onBindViewHolder(MyZhuanTi holder, int position) {

        goodsList = subjects.get(position).getGoodsList();
        Uri parse = Uri.parse(goodsList.get(position).getGoods_img());
        re_SimpleDraweeView.setImageURI(parse);
    }

    @Override
    public int getItemCount() {

        for (int i=0;i<subjects.size();i++){
            goodsList1 = subjects.get(i).getGoodsList();
        }
        return goodsList1.size();
    }

    public class MyZhuanTi extends RecyclerView.ViewHolder {

        public MyZhuanTi(View itemView) {
            super(itemView);
            re_SimpleDraweeView = itemView.findViewById(R.id.re_SimpleDraweeView);
        }
    }
}
