package com.intolergy.intolergy.product;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intolergy.intolergy.R;

import java.net.URL;
import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PostViewHolder>{
    ArrayList<Product> products;
    private Context context;

    public RVAdapter(ArrayList<Product> products){
        this.products = products;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_product, viewGroup, false);
        PostViewHolder pvh = new PostViewHolder(v);
        context=viewGroup.getContext();
        return pvh;
    }

    @Override
    public void onBindViewHolder(PostViewHolder personViewHolder, int i) {
        Product product=products.get(i);
        personViewHolder.name.setText(product.name);
        personViewHolder.user.setText(product.user);
        personViewHolder.downvotes.setText(String.valueOf(product.negative));
        personViewHolder.upvotes.setText(String.valueOf(product.positive));
        if(product.image!=null) {
            try {
                URL url = new URL(product.image);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                personViewHolder.image.setImageBitmap(bmp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            personViewHolder.image.setImageResource(R.drawable.ic_food_grey600_48dp);
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView user;
        ImageView image;
        TextView upvotes;
        TextView downvotes;

        public PostViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.product_cv);
            name = (TextView)itemView.findViewById(R.id.product_name);
            image = (ImageView)itemView.findViewById(R.id.product_image);
            user = (TextView) itemView.findViewById(R.id.product_user);
            upvotes=itemView.findViewById(R.id.product_upvotes);
            downvotes=itemView.findViewById(R.id.product_downvotes);
        }
    }

}
