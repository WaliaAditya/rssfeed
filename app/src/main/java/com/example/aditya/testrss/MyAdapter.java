package com.example.aditya.testrss;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Aditya Walia on 2017-06-05.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<FeedRSS> feedRSSes;
    Context context;

    public MyAdapter(Context context,ArrayList<FeedRSS> feedRSSes){
        this.feedRSSes = feedRSSes;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_row_news_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        final FeedRSS current = feedRSSes.get(position);
        holder.Title.setText(current.getTitle());
        holder.Description.setText(current.getDescription());
        holder.Date.setText(current.getPubDate());
        Picasso.with(context).load(current.getThumbnailUrl()).into(holder.Thumbnail);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailedNews.class);
                intent.putExtra("Link",current.getLink());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return feedRSSes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Title,Description,Date;
        ImageView Thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            Title = (TextView)itemView.findViewById(R.id.title_text);
            Description = (TextView)itemView.findViewById(R.id.description_text);
            Date = (TextView)itemView.findViewById(R.id.date_text);
            Thumbnail = (ImageView) itemView.findViewById(R.id.thumb_img);
            cardView = (CardView) itemView.findViewById(R.id.cardview);

        }
    }
}
