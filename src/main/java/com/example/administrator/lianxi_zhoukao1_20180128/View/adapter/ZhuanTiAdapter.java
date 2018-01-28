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

public class ZhuanTiAdapter extends RecyclerView.Adapter<ZhuanTiAdapter.MyZhuanTi> {
        Context context;
        List<DataDataBean.DataBean.SubjectsBean> subjects;
private SimpleDraweeView img4;
private List<DataDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList;
private List<DataDataBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList1;

public ZhuanTiAdapter(Context context, List<DataDataBean.DataBean.SubjectsBean> subjects) {
        this.context = context;
        this.subjects = subjects;
        }

@Override
public MyZhuanTi onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.zhuantiadapter_layout, null);
        MyZhuanTi myZhuanTi = new MyZhuanTi(view);
        return myZhuanTi;
        }

@Override
public void onBindViewHolder(MyZhuanTi holder, int position) {
        Log.d("TAG","56"+subjects.get(position).getGoodsList().get(position).getGoods_img());
        goodsList = subjects.get(position).getGoodsList();
    Uri parse = Uri.parse(goodsList.get(position).getGoods_img());
    img4.setImageURI(parse);
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
        img4 = itemView.findViewById(R.id.img4);
    }
}

}
