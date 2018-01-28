package com.example.administrator.lianxi_zhoukao1_20180128.View.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.lianxi_zhoukao1_20180128.Model.DataDataBean;
import com.example.administrator.lianxi_zhoukao1_20180128.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


/**
 * Created by Administrator on 2018/1/1.
 */

public class BiaoTiAdapter extends RecyclerView.Adapter<BiaoTiAdapter.MyBiaoTiAdapter>{
    private  SimpleDraweeView img5;
    Context context; List<DataDataBean.DataBean.Ad5Bean> ad5;
    private TextView tname;

    public BiaoTiAdapter(Context context, List<DataDataBean.DataBean.Ad5Bean> ad5) {
        this.context = context;
        this.ad5 = ad5;
    }


    @Override
    public MyBiaoTiAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.biaotiadapter_layout, null);
        return new MyBiaoTiAdapter(view);
    }

    @Override
    public void onBindViewHolder(MyBiaoTiAdapter holder, int position) {
        String image = ad5.get(position).getImage();
        img5.setImageURI(Uri.parse(image));
        tname.setText(ad5.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return ad5.size();
    }

    public class MyBiaoTiAdapter extends RecyclerView.ViewHolder {
        public MyBiaoTiAdapter(View itemView) {
            super(itemView);
            tname = itemView.findViewById(R.id.tname);
            img5 = itemView.findViewById(R.id.img5);

        }
    }
}
