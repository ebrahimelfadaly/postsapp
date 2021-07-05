package com.example.mypostapp.Ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mypostapp.Pojo.PostModel;
import com.example.mypostapp.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
  private  ArrayList<PostModel> postModels=new ArrayList<>();

    @NonNull

    @Override
    public PostViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
      holder.userid.setText(postModels.get(position).getUserId()+"");
      holder.titletv.setText(postModels.get(position).getTitle());
        holder.body.setText(postModels.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }
    public void setList(ArrayList<PostModel> list)
    {
        this.postModels=list;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titletv;
        TextView userid;
        TextView body;
        public PostViewHolder(@NonNull  View itemView) {
            super(itemView);
            titletv=itemView.findViewById(R.id.titletv);
            userid=itemView.findViewById(R.id.userIdtv);
            body=itemView.findViewById(R.id.bodytv);

        }
    }
}
