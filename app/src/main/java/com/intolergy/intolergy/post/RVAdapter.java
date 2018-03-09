package com.intolergy.intolergy.post;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.intolergy.intolergy.R;

import java.net.URL;
import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PostViewHolder>{
    ArrayList<Post> posts;

    public RVAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_cardview, viewGroup, false);
        PostViewHolder pvh = new PostViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PostViewHolder personViewHolder, int i) {
        Post post=posts.get(i);
        personViewHolder.title.setText(post.title);
        personViewHolder.body.setText(post.body);
        personViewHolder.user.setText(post.user);
        try {
            URL url = new URL(post.image);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            personViewHolder.image.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView body;
        TextView user;
        ImageView image;

        public PostViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.post_cv);
            title = (TextView)itemView.findViewById(R.id.post_title);
            body = (TextView)itemView.findViewById(R.id.post_body);
            image = (ImageView)itemView.findViewById(R.id.post_image);
            user = (TextView) itemView.findViewById(R.id.post_user);
        }
    }

}
