package com.example.asd.imviewrview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by asd on 2017/4/19.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RequestManager requestManager;
        public ViewHolder(View itemView,RequestManager requestManager) {
            super(itemView);
            this.requestManager=requestManager;
            imageView= (ImageView) itemView.findViewById(R.id.imageview);
        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.litm,parent,false);
        RequestManager requestManager= Glide.with(parent.getContext());
        final ViewHolder holder=new ViewHolder(view,requestManager);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                if (position!=-1) {
                    Images.getList().remove(position);
                    notifyItemRemoved(position);
                }

            }
        });


        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.requestManager.load(Images.getList().get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return Images.getList().size();
    }
}
